package linda.atlcompiler;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.utils.Assertions;
import anatlyzer.atl.analyser.namespaces.EnumNamespace;
import anatlyzer.atl.model.TypeUtils;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.BooleanType;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.EmptyCollectionType;
import anatlyzer.atl.types.EnumType;
import anatlyzer.atl.types.FloatType;
import anatlyzer.atl.types.IntegerType;
import anatlyzer.atl.types.MapType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.PrimitiveType;
import anatlyzer.atl.types.ReflectiveClass;
import anatlyzer.atl.types.StringType;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.types.UnionType;
import anatlyzer.atl.types.Unknown;
import lintra.atlcompiler.javagen.JArrayTypeRef;
import lintra.atlcompiler.javagen.JGenericTypeRef;
import lintra.atlcompiler.javagen.JLibType;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JParamNTypeRef;
import lintra.atlcompiler.javagen.JParamTypeRef;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.lingen.LinGen;
import lintra.lingen.LinGen2;

public abstract class BaseTyping implements ITyping {

	protected JavaGenModel jmodel;
	private DriverConfiguration drivers;

	public BaseTyping(JavaGenModel jmodel, DriverConfiguration drivers) {
		this.jmodel = jmodel;
		this.drivers = drivers;
		
		// Add base types to libtypes
		for (IMetaDriver driver : drivers.getDrivers()) {
			String baseType = driver.getBaseType();
			createLibType(extractPackageName(baseType), extractTypeName(baseType));
		}
		
		this.createLibType("lintra2.blackboard", "IdMapper");

	}

	@Override
	public JType getType(final String type) {
		if ( type.contains(".") ) {
			String pkg   = extractPackageName(type);
			String type2 = extractTypeName(type);
			return getType(pkg, type2);
		}
		
		return jmodel.getLibTypes().stream().
				filter(t -> t.getName().equals(type)).findAny().
				orElseThrow(() -> new IllegalStateException("Type " + type + " not found."));
	}

	private String extractPackageName(final String qualifiedTypeName) {
		int idx = qualifiedTypeName.lastIndexOf(".");
		String pkg = qualifiedTypeName.substring(0, idx);
		return pkg;
	}

	private String extractTypeName(final String qualifiedTypeName) {
		int idx = qualifiedTypeName.lastIndexOf(".");
		String type2 = qualifiedTypeName.substring(idx + 1);
		return type2;
	}
	
	private JType getType(String pkg, String type) {
		return jmodel.getLibTypes().stream().
				filter(t -> t.getName().equals(type) && pkg.equals(t.getPkg()) ).findAny().
				orElseThrow(() -> new IllegalStateException("Type " + type + " not found."));
	}

	@Override
	public void createLibType(String qname, String cname) {
		JLibType libType = JavagenFactory.eINSTANCE.createJLibType();
		libType.setName(cname);
		libType.setPkg(qname);
		jmodel.getLibTypes().add(libType);
	}

	@Override
	public String getType(Type t) {
		return getType(t, false, false);
	}
	
	public String getType(Type t, boolean isContainedType, boolean isMutable) {
		if ( t instanceof Metaclass ) {
			Metaclass m = (Metaclass) t;
			return drivers.get(m.getModel().getName()).getInterfaceQName(m.getKlass());
			// return LinGen2.getInterfaceQName(m.getKlass());
			// return m.getName();
		} else if ( t instanceof BooleanType ) {
			return isContainedType ? "Boolean" : "boolean";
		} else if ( t instanceof StringType ) {
			return "String";
		} else if ( t instanceof IntegerType ) {
			return isContainedType ? "Integer" : "int";
		} else if ( t instanceof FloatType ) {
			return isContainedType ? "Double" : "double";
		} else if ( t instanceof CollectionType ) {
			return createCollectionType(((CollectionType) t), isMutable);
		} else if ( t instanceof MapType ) {
			return createMapType((MapType) t);
		} else if ( t instanceof Unknown ) {
			return "java.lang.Object";
		} else if ( t instanceof UnionType ) {
			return "java.lang.Object";			
		}
		throw new UnsupportedOperationException("Not supported: " + t);
	}

	protected String createCollectionType(CollectionType t, boolean isMutable) {
		// TODO: Analyse the kind of collection
		return "List<" + getType(t.getContainedType(), true, isMutable) + ">";
	}
	
	protected String createMapType(MapType t) {
		// TODO: Analyse the kind of collection
		return "Map<" + getType(t.getKeyType(), true, false) + "," + getType(t.getValueType(), true, false) + ">";
	}
	
	protected JTypeRef createCollectionTypeRef(CollectionType t, Supplier<JTypeRef> baseType, boolean isMutable) {		
		JParamTypeRef param1 = JavagenFactory.eINSTANCE.createJParamTypeRef();
		param1.setType(getType("Collection"));
		param1.setContainedType(createTypeRef(t.getContainedType(), true, false));
		return param1;
	}

	protected JTypeRef createMapTypeRef(MapType t) {		
		JGenericTypeRef param1 = JavagenFactory.eINSTANCE.createJGenericTypeRef();
		param1.setType(getType("Map"));
		param1.getTypeParams().add(createTypeRef(t.getKeyType(), true, false));
		param1.getTypeParams().add(createTypeRef(t.getValueType(), true, false));
		return param1;
	}
	
	public JTypeRef createParamTypeRef(String type, String containedType) {
		JParamTypeRef param1 = JavagenFactory.eINSTANCE.createJParamTypeRef();
		param1.setType(getType(type));
		param1.setContainedType(createTypeRef(containedType));
		return param1;
	}
	
	@Override
	public JTypeRef createParamNTypeRef(JType type, JTypeRef...types) {
		JParamNTypeRef param1 = JavagenFactory.eINSTANCE.createJParamNTypeRef();
		param1.setType(type);
		for(JTypeRef t : types) {
			Assertions.checkNoContainer(t);
			param1.getParams().add(t);
		}
		return param1;		
	}

//	public JTypeRef createParamTypeRef(String type, Type containedType) {
//		JParamTypeRef param1 = JavagenFactory.eINSTANCE.createJParamTypeRef();
//		param1.setType(getType(type));
//		param1.setContainedType(createTypeRef(containedType));
//		return param1;
//	}

	public JTypeRef createArrayTypeRef(String containedType) {
		JArrayTypeRef param1 = JavagenFactory.eINSTANCE.createJArrayTypeRef();
		param1.setType(getType(containedType)); // This is not very sensitive
		param1.setContainedType(createTypeRef(containedType));
		return param1;
	}
	
	public JTypeRef createTypeRef(Type type) {
		// The default supplier for basetype is Object
		return createTypeRef(type, false, false, () -> createTypeRef("java.lang.Object"));
	}
	
	public JTypeRef createTypeRef(Type type, boolean isMutable) {
		return createTypeRef(type, false, isMutable, () -> createTypeRef("java.lang.Object"));
	}
	
	@Override
	public JTypeRef createTypeRef(Type type, Supplier<JTypeRef> baseType) {
		return createTypeRef(type, false, false, baseType);
	}

	protected JTypeRef createTypeRef(Type type, boolean isContainedType, boolean isMutable) {
		// The default supplier for basetype is Object
		return createTypeRef(type, isContainedType, isMutable, () -> createTypeRef("java.lang.Object"));	
	}
	
	@Override
	public JTypeRef createTypeRef(JType t) {
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(t);
		return tr;
	}
	
	
	protected JTypeRef createTypeRef(Type type, boolean isContainedType, boolean isMutable, Supplier<JTypeRef> baseType) {
		if ( type instanceof Metaclass ) {
			return createMetaTypeRef((Metaclass) type);
		} else if ( type instanceof EnumType ) {
			return createEnumTypeRef((EnumType) type);
		} else if ( type instanceof PrimitiveType ){
			if ( type instanceof BooleanType ) {
				return isContainedType ? createTypeRef("Boolean") : createTypeRef("boolean");
			} else if ( type instanceof StringType ) {
				return createTypeRef("String");
			} else if ( type instanceof IntegerType ) {
				return isContainedType ? createTypeRef("Integer") : createTypeRef("int");
			} else if ( type instanceof FloatType ) {
				return isContainedType ? createTypeRef("Double") : createTypeRef("double");
			} 
			throw new UnsupportedOperationException();
		} else if ( type instanceof CollectionType ) {
			return createCollectionTypeRef((CollectionType) type, baseType, isMutable);
		} else if ( type instanceof MapType ) {
			return createMapTypeRef((MapType) type);
		} else if ( type instanceof UnionType ) {
			return TypingModel.allPossibleTypes(type).stream().
					allMatch(t -> t instanceof Metaclass) ? 
							// createTypeRef("IdentifiableElement") :
							// TODO: Delegate to a driver#baseType, but this requires the driver
							// creating the typing object
							baseType.get() : 
							createTypeRef("java.lang.Object"); 
		} else if ( type instanceof Unknown || type instanceof EmptyCollectionType ) {
			return createTypeRef("Object");
		} else if ( type instanceof ReflectiveClass ) {
			return createTypeRef("lintra.utils.ReflectiveObject");
		} else {
			throw new UnsupportedOperationException("Not type for " + type);
		}
	}
	
	public JTypeRef createTypeRef(String type) {
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(getType(type));
		return tr;
	}

	public JTypeRef createTypeRef(String pkg, String type) {
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(getType(pkg, type));
		return tr;
	}

	public JTypeRef createEnumTypeRef(EnumType m) {
		//return createLintraRef(m, LinGen2::getEnumName, LinGen2::getEnumQName);
		String mmName = ((EnumNamespace) m.getMetamodelRef()).getMetamodelName();
		IMetaDriver driver = drivers.get(mmName);
		return createLintraRef(m, driver::getEnumName, driver::getEnumQName);
	}
	
	@Override
	public JTypeRef createMetaTypeImplRef(Metaclass m) {
		IMetaDriver driver = drivers.get(m.getModel().getName());
		return createLintraRef(m, driver::getClassName, driver::getClassQName);
	}

	public JTypeRef createMetaTypeRef(Metaclass m) {		
		IMetaDriver driver = drivers.get(m.getModel().getName());
		return createLintraRef(m, driver::getInterfaceName, driver::getInterfaceQName);
	}
	
	public JTypeRef createLintraRef(Metaclass m, Function<EClass, String> nameGetter, Function<EClass, String> qNameGetter) {
		// String type = m.getName();
		String typeName = nameGetter.apply(m.getKlass());
		String qTypeName = qNameGetter.apply(m.getKlass());
		
		// TODO: Deal with packages
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		
		JMetaType meta = jmodel.getMetaTypes().stream().
				// filter(t -> t.getName().equals(type)).findFirst().orElseGet(() -> {
				filter(t -> t.getQualifiedJavaName().equals(qTypeName)).findFirst().orElseGet(() -> {
			JMetaType t = JavagenFactory.eINSTANCE.createJMetaType();
			t.setName(typeName);
//			t.setQualifiedJavaName(LinGen.getQName(m.getKlass())); // TODO: Create qualified name in Lintra
			
			t.setQualifiedJavaName(qNameGetter.apply(m.getKlass())); 
			
			jmodel.getMetaTypes().add(t);
			return t;
		});
		
		tr.setType(meta);
		return tr;
	}

	public JTypeRef createLintraRef(EnumType m, Function<EEnum, String> nameGetter, Function<EEnum, String> qNameGetter) {
		// String type = m.getName();
		String type = nameGetter.apply((EEnum) m.getEenum());
		String qTypeName = qNameGetter.apply((EEnum) m.getEenum());
		
		// TODO: Deal with packages
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		
		JMetaType meta = jmodel.getMetaTypes().stream().filter(t -> t.getQualifiedJavaName().equals(qTypeName)).findFirst().orElseGet(() -> {
			JMetaType t = JavagenFactory.eINSTANCE.createJMetaType();
			t.setName(type);
//			t.setQualifiedJavaName(LinGen.getQName(m.getKlass())); // TODO: Create qualified name in Lintra
			
			t.setQualifiedJavaName(qNameGetter.apply((EEnum) m.getEenum())); 
			
			jmodel.getMetaTypes().add(t);
			return t;
		});
		
		tr.setType(meta);
		return tr;
	}
	
	@Override
	public String getModelName(Metaclass t) {
		// TODO: Probably this requires aditional information to get the actual model
		return t.getModel().getName();
	}
}
