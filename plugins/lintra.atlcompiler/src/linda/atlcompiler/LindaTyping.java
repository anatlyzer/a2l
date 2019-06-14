package linda.atlcompiler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.OrderedSetType;
import anatlyzer.atl.types.SetType;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.ForStat;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.StaticRule;
import anatlyzer.atlext.OCL.CollectionExp;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LoopExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import lintra.atlcompiler.javagen.JParamTypeRef;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;

public class LindaTyping extends BaseTyping {

	private ATLModel atlModel;
	private List<ModelInfo> inModels;
	private List<ModelInfo> outModels;

	public static final String SET_BASE     = "javaslang.collection.Set";
	public static final String SET_CONCRETE = "javaslang.collection.HashSet";

	public static final String ORDERED_SET_BASE     = "javaslang.collection.Set";
	public static final String ORDERED_SET_CONCRETE = "javaslang.collection.HashSet";

	public static final String MUTABLE_SET_BASE     = "java.util.Set";
	public static final String MUTABLE_SET_CONCRETE = "java.util.HashSet";

	public static final String MUTABLE_ORDERED_SET_BASE     = "java.util.Set";
	public static final String MUTABLE_ORDERED_SET_CONCRETE = "java.util.HashSet";

	
	public LindaTyping(JavaGenModel jmodel, ATLModel model, DriverConfiguration drivers) {
		super(jmodel, drivers);
		this.atlModel = model;
		inModels = ATLUtils.getModelInfo(atlModel).stream().filter(m -> m.isInput()).collect(Collectors.toList());
		outModels = ATLUtils.getModelInfo(atlModel).stream().filter(m -> m.isOutput()).collect(Collectors.toList());
		
		
		LindaTyping typ = this;
		
		typ.createLibType("lintra.utils", "ReflectiveObject");
		
		typ.createLibType("java.util", "List");
		typ.createLibType("javaslang.collection", "List");
		typ.createLibType("javaslang.collection", "Set");
		typ.createLibType("java.util", "Set");
		typ.createLibType("javaslang.collection", "SortedSet");		
		typ.createLibType("javaslang.collection", "Map");
		typ.createLibType("java.util", "ArrayList");		
		typ.createLibType("java.util", "Map");		
		typ.createLibType("java.util", "Collection");
		typ.createLibType("default_", "boolean");
		typ.createLibType("default_", "int");
		typ.createLibType("default_", "double");		
		typ.createLibType("java.lang", "String");
		typ.createLibType("java.lang", "Integer");
		typ.createLibType("java.lang", "Boolean");
		typ.createLibType("java.lang", "Double");		
		typ.createLibType("java.lang", "Object");
		typ.createLibType("java.lang", "Exception");
	}

	@Override
	protected String createCollectionType(CollectionType t, boolean isMutable) {
		String prefix = "";
		if ( isMutable ) {
			// Ugly hack, prefix the java.util to disambiguate from javaslang
			prefix = "java.util";
		} else {
			prefix = "javaslang.collection";
		}

		// TODO: Analyse the kind of collection
		return prefix + ".List<" + getType(t.getContainedType() ) + ">";
	}

	@Override
	protected JTypeRef createCollectionTypeRef(CollectionType t, Supplier<JTypeRef> baseType, boolean isMutable) {
		String type;
		if ( isMutable ) {
			type = "java.util.List";
			if ( t instanceof SetType ) {
				type = MUTABLE_SET_BASE; 
			} else if ( t instanceof OrderedSetType ) {
				type = MUTABLE_ORDERED_SET_BASE; 
			}
		} else {
			type = "javaslang.collection.List"; // default type
			if ( t instanceof SetType ) {
				type = SET_BASE; // "javaslang.collection.Set";
			} else if ( t instanceof OrderedSetType ) {
	//			type = "javaslang.collection.SortedSet";
				type = ORDERED_SET_BASE; // "javaslang.collection.Set";
			}
		}
		
		JParamTypeRef param1 = JavagenFactory.eINSTANCE.createJParamTypeRef();		
		param1.setType(getType(type));
		param1.setContainedType(createTypeRef(t.getContainedType(), true, false, baseType));
		return param1;
	}

	protected Set<String> srcAreaOf(EObject obj) {
		if ( obj instanceof VariableDeclaration ) {
			return srcAreaOf((VariableDeclaration) obj);
		} else if ( obj instanceof OclExpression ){
			return srcAreaOf((OclExpression) obj);
		}
		throw new IllegalArgumentException();
	}
	
	protected Set<String> srcAreaOf(VariableDeclaration varDcl) {
		return findInputConformingModels( ((OclModelElement) varDcl.getType() ) );
	}
	
	protected Set<String> srcAreaOf(OclExpression exp) {
		// TODO: If there is only one source model, that is.
		if ( exp instanceof VariableExp ) {
			VariableExp v = (VariableExp) exp;
			VariableDeclaration vd = v.getReferredVariable();

			final OclModelElement me;
			if ( vd.getVarName().equals("self") ) {
				ContextHelper helper = ATLUtils.getContainer(v, ContextHelper.class);
				me = (OclModelElement) helper.getDefinition().getContext_().getContext_();				
			} else {			
				if ( vd.getType() == null ) {
					if ( vd instanceof Iterator ) {
						if ( vd.eContainer() instanceof LoopExp ) {
							// If vd belongs to an IterateExp, it will have a type if its the temp variable
							LoopExp loop = (LoopExp) vd.eContainer();
							return srcAreaOf(loop.getSource());
						} else {
							ForStat forStat = (ForStat) vd.eContainer();
							return srcAreaOf(forStat.getCollection());
						}
					} else {
						throw new UnsupportedTranslation("Cannot compute source model: " + vd, exp);
					}
				}
								
				me = getUnderlyingOclModelElement(vd.getType()); 
			}
			
			return findInputConformingModels(me);
		} else {
			if ( exp instanceof PropertyCallExp ) {
				PropertyCallExp prop = (PropertyCallExp) exp;
				
				if ( prop.getStaticResolver() instanceof Helper ) {
					// If it s a helper use the type of the return type
					return srcAreaOf(ATLUtils.getHelperReturnType((Helper) ((PropertyCallExp) exp).getStaticResolver()));
				} else if ( prop.getStaticResolver() instanceof StaticRule ) {
					// A target area name will be computed
					String tgtArea = getTgtArea(((Rule) prop.getStaticResolver()).getOutPattern().getElements().get(0));
					return singletonArea(tgtArea);
				} else {
					return srcAreaOf( prop.getSource());
				}
			} else if ( exp instanceof IfExp ) {
				IfExp ifexp = (IfExp) exp;
				Set<String> area1 = srcAreaOf(ifexp.getThenExpression());
				Set<String> area2 = srcAreaOf(ifexp.getElseExpression());
				
				area1.addAll(area2);
				
				return area1;
			} else if ( exp instanceof OclModelElement ) {
				return findInputConformingModels( (OclModelElement) exp );
			} else if ( exp instanceof CollectionExp ) {
				CollectionExp cexp = ((CollectionExp) exp);

				HashSet<String> areas = new HashSet<String>();
				for(int i = 0; i < cexp.getElements().size(); i++) {
					areas.addAll( srcAreaOf(cexp.getElements().get(i)) );
				}
								
				return areas;
			} else if ( exp instanceof anatlyzer.atlext.OCL.CollectionType ) {
				return srcAreaOf(((anatlyzer.atlext.OCL.CollectionType) exp).getElementType());
			} else if ( exp instanceof anatlyzer.atlext.OCL.MapType ) {
				// This is a bit heuristic, because it assumes something like
				// in XML2DSLmodel
				// thisModule.operationReturningAMap.get('value') => The type is the value
				return srcAreaOf(((anatlyzer.atlext.OCL.MapType) exp).getValueType());
			} else {
				throw new UnsupportedTranslation("Not supported: " + exp);
			}
		}
	}

	private Set<String> singletonArea(String area) {
		HashSet<String> s = new HashSet<String>();
		s.add(area);
		return s;
	}

	private OclModelElement getUnderlyingOclModelElement(OclType type) {
		if ( type instanceof OclModelElement ) {
			return (OclModelElement) type;
		} else if ( type instanceof anatlyzer.atlext.OCL.CollectionType ) {
			return getUnderlyingOclModelElement(((anatlyzer.atlext.OCL.CollectionType) type).getElementType());
		}
		throw new IllegalStateException("Type " + type + " cannot be OclModelElement");
	}

	private Set<String> findInputConformingModels(final OclModelElement me) {
		List<ModelInfo> conformingModels = inModels.stream().filter(m -> m.getMetamodelName().equals(me.getModel().getName())).collect(Collectors.toList());
		if ( conformingModels.size() == 0 ) {
			throw new NoModelFound("No model found " + me.getName());
		} else {
			return conformingModels.stream().map(m -> m.getModelName()).collect(Collectors.toSet());
		}
	}
	
	public static class NoModelFound extends RuntimeException {

		public NoModelFound(String message) {
			super(message);
		}
		
	}
	
	// This is similar to the source, but only for the imperative part
	protected String getTgtArea(OclExpression exp) {
		if ( exp instanceof VariableExp ) {
			VariableExp v = (VariableExp) exp;
			VariableDeclaration vd = v.getReferredVariable();
			if ( vd.getType() == null ) {
				// TODO: If there is only one source model, that is.
				throw new UnsupportedTranslation("Cannot target source model", exp);
			}
			
			if ( !( vd.getType() instanceof OclModelElement )) {
				throw new IllegalStateException();
			}
			
			OclModelElement me = (OclModelElement) vd.getType();
			List<ModelInfo> conformingModels = outModels.stream().filter(m -> m.getMetamodelName().equals(me.getModel().getName())).collect(Collectors.toList());
			if ( conformingModels.size() == 0 ) {
				throw new IllegalStateException();
			} else if ( conformingModels.size() > 1 ) {
				throw new UnsupportedTranslation("Too many conforming models");
			} else {
				return conformingModels.get(0).getModelName();
			}
		} else {
			if ( exp instanceof PropertyCallExp ) {
				return getTgtArea(((PropertyCallExp) exp).getSource());
			} else {
				throw new UnsupportedTranslation("Not supported: " + exp);
			}
		}
	}
	
	public String getAreaName(String modelName) {
		return modelName + "Model_";
	}

	public String getPartialOutputAreaName(String modelName) {
		return modelName + "Model_PartialOutput_";
	}

	public List<String> getSrcAreaName(EObject obj) {
		return srcAreaOf(obj).stream().map(o -> getAreaName(o)).collect(Collectors.toList());
	}
	
	public String getPartialOutputModelFieldName(OutPatternElement ope) {
		return getPartialOutputAreaName(getTgtArea(ope));
	}
	
	public String getPartialOutputModelFieldName(OclExpression exp) {
		return getPartialOutputAreaName(getTgtArea(exp));
	}
	
	public String getOutputModelFieldName(OutPatternElement ope) {
		return getAreaName(getTgtArea(ope));
	}
	
	public String getOutputModelFieldName(OclExpression exp) {
		return getAreaName(getTgtArea(exp));
	}
		
	
	
	private String getTgtArea(OutPatternElement ope) {
		String mmName = ((OclModelElement) ope.getType()).getModel().getName();
		List<ModelInfo> conformingModels = outModels.stream().filter(m -> m.getMetamodelName().equals(mmName)).collect(Collectors.toList());
		if ( conformingModels.size() == 0 ) {
			throw new IllegalStateException();
		} else if ( conformingModels.size() > 1 ) {
			throw new UnsupportedTranslation("Too many conforming models");
		} else {
			return conformingModels.get(0).getModelName();
		}
	}


	
}
