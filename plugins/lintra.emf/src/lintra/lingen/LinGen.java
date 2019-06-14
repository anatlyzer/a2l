package lintra.lingen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;

public class LinGen extends AbstractGenerator {

	protected Resource resource;
	
	protected List<GenClass> genFiles = new ArrayList<GenClass>();
	
	public LinGen(Resource r) {
		super(r);
		this.resource = r;
	}
	
	public List<GenClass> generate() {
		genClasses();
		return genFiles;
	}

	protected void genClasses() {
		for (EClass eClass : getClasses()) {
			genClass(eClass);
		}		
		for (EEnum eEnum : getEnums()) {
			genEnum(eEnum);
		}		
		
	}

	private void genEnum(EEnum e) {
		String s = "";

		s += "package " + getPkgName(e.getEPackage()) + ";" + cr(); 
		s += "public " +" enum " + getEnumName(e) + " { " + cr();
		
		s += e.getELiterals().stream().map(l -> getLiteralName(l)).collect(Collectors.joining(", ")) + ";";
		
		s += "}";

		genFiles.add(new GenClass(getPkgName(e.getEPackage()), getEnumName(e), s));

	}

	protected void genClass(EClass c) {
		String s = "";
		
		s += "package " + getPkgName(c.getEPackage()) + ";" + cr(); 
		s += "import lintra2.blackboard.IdentifiableElement;" + cr();
		s += "import java.io.Serializable;" + cr();
		// s += "import �this.ePackage.name()�.Enums.*;;
		
		String abstract_ = c.isAbstract() ? "abstract" : "";
//		String extends_ = c.getESuperTypes().isEmpty() ? "" :
//			"extends " +
//			c.getESuperTypes().stream().map(k -> getClassQName(k)).
//			collect(Collectors.joining(","));
		String extends_ = ""; // no longer needed due to the use of interfaces
		
		
		ArrayList<String> interfaces = new ArrayList<String>();
		interfaces.add("Serializable");
		interfaces.add("IdentifiableElement");
		interfaces.addAll(getAdditionalInterfaces(c));
		String interfacesStr = interfaces.stream().collect(Collectors.joining(", "));
		
		s += "@SuppressWarnings(\"serial\")";
		s += "public " + abstract_ + " class " + getClassName(c) + " " + extends_ + " implements " + interfacesStr + " { " + cr();
		s += !c.isAbstract() ? "String id, trgId, modelName_;" + cr() : "";
		if ( ! c.isAbstract() ) {
			s += "public String getId() { " + 
   			"	return id;"+
			"}" +
			" " +
			"public void setId(String id) {" +
   			"	this.id = id;" +
			"}" +
			"" +
			"public String getTrgId() {" +
   			"	return trgId;" +
			"}" +
			"" +
			"public void setTrgId(String trgId) {" +
   			"	this.trgId = trgId;" +
			"}" +
			"" +
			"public String getModelName() {" +
   			"	return modelName_;" +
			"}" +
			"" +
			"public void setModelName(String modelName) {" +
   			"	this.modelName_ = modelName;" +
			"}";	
   			;	
			
		}
		
		s += "@Override " +
				"public Object clone() throws CloneNotSupportedException { " + 
				"return super.clone(); " +
				"}";
		
		s += "public String getTypeId() { return \"" +  this.getTypeId(c) + "\"; }" + cr();


		// Constructors
		s += "public " + getClassName(c) + "() { }";
		
		s += "public " + getClassName(c) + "(String objId_";
		
		// Multiple inheritance does not work! Probably we should avoid this and use setters in the model parser
		// if ( c.getESuperTypes().size() > 1 )
		//	throw new UnsupportedOperationException("Multiple inheritance not supported!");


		String params = c.getEAllStructuralFeatures().stream().map(f -> {
			String typeName = getPropertyTypeName(f.getEType());
			if ( f.isMany() ) {
				typeName = typeName + "[]";
			}

			return typeName + " " + sanitize(f.getName());
 		}).collect(Collectors.joining(", "));
		
		s += params.isEmpty() ? ")" : "," + params + ")";
		// end-of-constructor signature
		
		s += "{" + "\n";
		String setters = c.getEAllStructuralFeatures().stream().map(f -> {
			return setter(f) + "(" + sanitize(f.getName()) + ")";
		}).collect(Collectors.joining(";\n")) + ";";
		s += "setId(objId_);\n" + setters;
		s += "\n}\n";
		
		// Setter / Getters
		
		for(EStructuralFeature f : c.getEAllStructuralFeatures()) {
			String typeName = getPropertyTypeName(f.getEType());
			if ( f.isMany() ) {
				typeName = typeName + "[]";
			}
		
			// What about containment? This is a possible optimization 

			String init = "";
			if ( f instanceof EReference ) {
				s += "@lintra.utils.Reference\n";
				if ( f.isMany() ) {
					init = "= new String[0]";
				}
			}
			s += typeName + " " + fname(f) + init + ";";
			
			s += "public void " + setter(f) + "(" + typeName + " v) {" + cr();
			s += "  this." + fname(f) + " = v;" + cr(); 
			s += "}" + cr();
			
			s += "public " + typeName + " " + getter(f) + "() {" + cr();
			s += "  return this." + fname(f) + ";" + cr(); 
			s += "}" + cr();
		}
		
		/*
		 
			«FOREACH this.eStructuralFeatures.typeSelect(EAttribute) AS f»
			public void «f.setter()»(«IF f.eType.name=='EBoolean'»boolean«ELSEIF f.eType.name=='EString'»String«ELSEIF f.eType.name=='EInt'»int«ELSEIF f.eType.name=='EDouble'»double«ELSE»«f.eType.name»«ENDIF»«IF f.many»[]«ENDIF» «IF f.name()=='default' || f.name()=='static' || f.name()=='abstract' || f.name()=='final' || f.name()=='public' || f.name()=='private' || f.name()=='protected' ||  f.name()=='volatile'|| f.name()=='transient'|| f.name()=='native'|| f.name()=='strictfp'|| f.name()=='synchronized'»_«f.name()»«ELSE»«f.name()»«ENDIF») {
				this.«IF f.name()=='default' || f.name()=='static' || f.name()=='abstract' || f.name()=='final' || f.name()=='public' || f.name()=='private' || f.name()=='protected' ||  f.name()=='volatile'|| f.name()=='transient'|| f.name()=='native'|| f.name()=='strictfp'|| f.name()=='synchronized'»_«f.name()»«ELSE»«f.name()»«ENDIF» = «IF f.name()=='default' || f.name()=='static' || f.name()=='abstract' || f.name()=='final' || f.name()=='public' || f.name()=='private' || f.name()=='protected' ||  f.name()=='volatile'|| f.name()=='transient'|| f.name()=='native'|| f.name()=='strictfp'|| f.name()=='synchronized'»_«f.name()»«ELSE»«f.name()»«ENDIF»;
			}
		 
		 */
		

		/*		
		«FOREACH this.eStructuralFeatures.typeSelect(EAttribute) AS f»
		«IF f.eType.name=='EBoolean'»boolean«ELSEIF f.eType.name=='EString'»String«ELSEIF f.eType.name=='EInt'»int«ELSEIF f.eType.name=='EDouble'»double«ELSE»«f.eType.name»«ENDIF»
		«IF f.many»[]«ENDIF»
		«IF f.name()=='default' || f.name()=='static' || f.name()=='abstract' || f.name()=='final' || f.name()=='public' || f.name()=='private' || f.name()=='protected' ||  f.name()=='volatile'|| f.name()=='transient'|| f.name()=='native'|| f.name()=='strictfp'|| f.name()=='synchronized'»_«f.name()»«ELSE»«f.name()»«ENDIF»;«ENDFOREACH»
*/

		if ( ! c.isAbstract() ) {
			s += "public String toString() {\n";
			s += "String s = " + "\"" + getClassName(c) + "_" + "\"+" + "this.id" + ";";
			// + "\""		
			for(EStructuralFeature f : c.getEAllStructuralFeatures()) {
				if ( f.isMany() ) {
					s += "s+=" + "\" " + sanitize(f.getName()) + "=" + "\"+ java.util.Arrays.toString(" +  fname(f) + ");";
				} else {
					s += "s+=" + "\" " + sanitize(f.getName()) + "=" + "\"+" + fname(f) + ";";
				}
			}
			s += "return s;";
			s += "}";
		}
		
		
		s += "}";

		genFiles.add(new GenClass(getPkgName(c.getEPackage()), getClassName(c), s));
	}

	public static String getTypeId(EClass c) {
		// TODO: Fully qualified name
		return c.getName();
	}

	protected Collection<String> getAdditionalInterfaces(EClass c) {
		return new ArrayList<String>();
	}

	protected String getPropertyTypeName(EClassifier eType) {
		if ( eType instanceof EClass ) {
			// return getQName((EClass) eType);
			return "String";
		} else {
			return getAttType(((EDataType) eType));
		}
	}

	public static String setter(EStructuralFeature f) {
		String head = f.getName().substring(0, 1).toUpperCase();
		String tail = f.getName().substring(1, f.getName().length());
 		
		return sanitizeSetter("set" + head + tail);
	}


	public static String getter(EStructuralFeature f) {
		String head = f.getName().substring(0, 1).toUpperCase();
		String tail = f.getName().substring(1, f.getName().length());
 		
		return sanitizeGetter("get" + head + tail);
	}

	protected String fname(EStructuralFeature f) {
		// check conflicts
		// return f.getName() + "_" + "id";
		// return f.getName() + "ID";
		return sanitize(f.getName());
	}

	protected String getAttType(EDataType t) {
		// Enums
		if ( t instanceof EEnum ) {
			return getEnumName((EEnum) t);
		}
			
		// Custom PTypes
		String instance = t.getInstanceTypeName();
		if ( instance != null ) {
			if ( instance.equals("java.lang.String") ) return "java.lang.String";
			else if ( instance.equals("java.lang.Integer") ) return "int";
			else if ( instance.equals("java.lang.Boolean") ) return "boolean";
			else if ( instance.equals("java.lang.Float") ) return "float";
			else if ( instance.equals("java.lang.Double") ) return "double";
			return instance;
		} else {
			// This is to support custom data types 
			if ( t.getName().toLowerCase().contains("string") ) return "java.lang.String";
			else if ( t.getName().toLowerCase().contains("int") ) return "int";
			else if ( t.getName().toLowerCase().contains("bool") ) return "boolean";
			else if ( t.getName().toLowerCase().contains("float") ) return "float";
			else if ( t.getName().toLowerCase().contains("double") ) return "double";
			throw new UnsupportedOperationException("Datatype: " + t.getName());
		}
	}

	public static String getClassQName(EClass c) {
		return getPkgName(c.getEPackage()) + "." + getClassName(c);
	}
	
	public static String getEnumQName(EEnum c) {
		return getPkgName(c.getEPackage()) + "." + getEnumName(c);
	}

	public static String getPkgName(EPackage ePackage) {
		return sanitize(ePackage.getName().toLowerCase());
	}

	public static String getClassName(EClass c) {
		return sanitize(c.getName());
	}

	public static String getEnumName(EEnum c) {
		return sanitize(c.getName());
	}

	public static String getLiteralName(EEnumLiteral l) {
		return sanitize(l.getName());
	}

	protected static Set<String> keywords = new HashSet<>();
	static {
		String reserved = 
		"abstract 	continue 	for 	new 	switch " +
		"assert 	default 	goto 	package 	synchronized " +
		"boolean 	do 	if 	private 	this " +
		"break 	double 	implements 	protected 	throw " +
		"byte 	else 	import 	public 	throws " +
		"case 	enum 	instanceof 	return 	transient " +
		"catch 	extends 	int 	short 	try " +
		"char 	final 	interface 	static 	void " +
		"class 	finally 	long 	strictfp 	volatile " +
		"const 	float 	native 	super 	while " +
		"true false null ";
		
		// These are field names used internally
		reserved += " id trgId modelName_";
		
		// To avoid conflicts with runtime IModel when translated to the interface name
		reserved += " Model";
		
		for (String string : reserved.split("\\s+")) {
			keywords.add(string.trim());
		}
	}
	
	public static String sanitize(String s) {
		return keywords.contains(s) ? s + "_" : s;
	}
	
	protected static String sanitizeGetter(String s) {
		if ( "getId".equals(s) || "getTrgId".equals(s) || "getModelName".equals(s) || "getClass".equals(s))
			s = s + "_"; 
		return s;
	}

	protected static String sanitizeSetter(String s) {
		if ( "setId".equals(s) || "setTrgId".equals(s) || "setModelName".equals(s))
			s = s + "_"; 
		return s;
	}
	
	
}

