package lintra.lingen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class generates an ILintraReader class able to process a specific
 * kind of EMF resource and convert it into Java objects defined according
 * to the {@link LinGen} generator.
 * 
 * @author jesus
 */
public class LintraEMFReaderGenerator extends AbstractGenerator {
	protected List<GenClass> genFiles = new ArrayList<GenClass>();

	public LintraEMFReaderGenerator(Resource resource) {
		super(resource);
	}

	public List<GenClass> generate() {
		genMainReader();
		return genFiles;
	}

	public String getReaderName() {
		EPackage pkg = getRootPackage();
		String readerClassName = getReaderName(pkg);
		return readerClassName;
	}
	
	public String getReaderPackageName() {
		return LinGen.getPkgName(getRootPackage());
	}
	
	private void genMainReader() {
		
		EPackage pkg = getRootPackage();
		String readerClassName = getReaderName(pkg);
		
		String s = "";
		
		s += "package " + LinGen.getPkgName(pkg) + ";" + cr(); 

		s += "import org.eclipse.emf.common.util.TreeIterator;" + cr();
		s += "import org.eclipse.emf.ecore.EObject;"  + cr();
		s += "import org.eclipse.emf.ecore.EClass;"  + cr();
		s += "import org.eclipse.emf.ecore.EEnum;"  + cr();
		s += "import org.eclipse.emf.common.util.Enumerator;" + cr();
		s += "import org.eclipse.emf.ecore.resource.Resource;"  + cr();
		s += "import lintra2.blackboard.IdentifiableElement;" + cr();
		s += "import java.util.HashMap;"  + cr();

		
		s += "@SuppressWarnings(\"serial\")";
		s += "public " + "class " + readerClassName  + " " + "implements " + "lintra2.runners.ILintraModelReader " + " { " + cr();
		s += "protected HashMap<EObject, IdentifiableElement> trace = new HashMap<>();";
		s += "protected Resource resource;";

		// Constructor
		s += "public " + readerClassName + "(Resource r) {";
			s += "this.resource = r;";
		s += "}";
		
		// getAllObjects
		s += "public java.util.Collection<Object> getAllObjects() { " + cr();
		s += "  doRead();";
		s += "  return java.util.Collections.unmodifiableCollection(trace.values());";
		s += "}";
		
		
		// read
		s += "private boolean alreadyRead = false;" + cr();
		s += "public void doRead() { " + cr();
		    s += "if ( alreadyRead ) return;";
		    s += "alreadyRead = true;" + cr(); 
			s += "int i = 0;";
			s += "TreeIterator<EObject> iterator = resource.getAllContents();"
				+ "while ( iterator.hasNext() ) {"
					+ "	EObject eObj = iterator.next();"
					+ "IdentifiableElement obj = readObject(eObj);"
					+ "obj.setId(((double) i) + \"\");"
					+ "trace.put(eObj, obj);" 
					+ "i++;"					
				+ "}";
		
			s += "trace.forEach((key, value) -> {	copyProperties(key, value);	});";			
		s += "} " + cr();

		
		// readObject
		s += "protected IdentifiableElement readObject(EObject obj) { " + cr();		
			s += "EClass eclass = obj.eClass();" + cr();
			for (EClass c : getClasses()) {
				if ( c.isAbstract() ) 
					continue;
				
				s += "if ( eclass.getName().equals(" + quote(c.getName()) + ") && "
						+ "eclass.getEPackage().getNsURI().equals(" + quote(c.getEPackage().getNsURI()) + ")) "
								+ "{ return " + "new " + LinGen.getClassQName(c) + "()" + "; }";
			}
	
			s += "throw new IllegalStateException();";
		s += "}" + cr();

		// copyProperties
		s += "protected void copyProperties(EObject eObj, Object obj) { " + cr();
			s += "EClass eclass = eObj.eClass();" + cr();
			for (EClass c : getClasses()) {
				if ( c.isAbstract() ) 
					continue;
				
				s += "if ( eclass.getName().equals(" + quote(c.getName()) + ") && "
						+ "eclass.getEPackage().getNsURI().equals(" + quote(c.getEPackage().getNsURI()) + ")) "
								+ "{ " + getSetPropertiesMethod(c) + "(eObj, " + cast(c) + "obj); return; }";
			}
	
			s += "throw new IllegalStateException();";
		s += "}" + cr();

		for (EEnum e : getEnums()) {
			s += "protected " + LinGen.getEnumQName(e) + " convertEnum_" + e.getName() + "(EEnum eObj) { " + cr();
			// easy way...
			s += "return " + LinGen.getEnumQName(e) + ".valueOf(" + "eObj.getName()" + ");"; 
			s += "}";
		}
		
		// setProperties
		for (EClass c : getClasses()) {		
			s += "protected void " + getSetPropertiesMethod(c) + "(EObject eObj, " + LinGen.getClassQName(c) + " obj) { " + cr();		
				for (EAttribute attribute : c.getEAllAttributes()) {					
					if ( attribute.isMany() ) {
						// toPrimitiveTypeName
						// create a temporary array with the attribute name and fill it with the collection contents
						String varName = "tmp" + attribute.getName();
						String colName = varName + "col";
						String idxName = varName + "idx";
						s += "java.util.Collection<Object> " + colName + " = (java.util.Collection<Object>) obj;";
						s += "int " + idxName + "= 0;";
						s += toPrimitiveTypeName(attribute.getEAttributeType()) + "[] " + varName + " = new " + toPrimitiveTypeName(attribute.getEAttributeType()) + "[" + colName + ".size()];";
						s += "for(Object o : " + colName + ") {";
						  s += varName + "[" + idxName + "++] = " + castPrimitive(attribute.getEAttributeType(), "o") + ";"; 						  
						s += "}";
						
						s += "obj." + LinGen.setter(attribute) + "(" + varName + ");" + cr();
					} else {
						String varName = "tmp" + attribute.getName();
						s += "Object " + varName + " = " + getFromEObject("eObj", attribute) + ";";
						// TODO: Set the default value established by the attribute
						s += "if ( " + varName + " != null ) ";  
							s += "obj." + LinGen.setter(attribute) + "(" + castPrimitive(attribute.getEAttributeType(), varName) + ");" + cr();
					}
				}
				
				for (EReference reference : c.getEAllReferences()) {
					if ( reference.isMany() ) {
						// s += "obj." + LinGen.getter(reference) + ".add(" + cast(reference.getEReferenceType()) + getFromEObject("eObj", reference) + ");" + cr();

						s += "obj." + LinGen.setter(reference) + "( convertObjectCollection((java.util.Collection<Object>)" + getFromEObject("eObj", reference) + ")" + ");" + cr();
					} else {
						// s += "obj." + LinGen.setter(reference) + "(" + cast(reference.getEReferenceType()) + getFromEObject("eObj", reference) + ");" + cr();
						
						s += "obj." + LinGen.setter(reference) + "( getObjFromTrace(" + getFromEObject("eObj", reference) + ")" + ");" + cr();
					}

				}
			
			s += "}" + cr();
		}
		
		// Get from trace
		s += "protected String getObjFromTrace(Object eObj) { " + cr();
			s += "if ( eObj == null ) return null;";
			s += "if ( ((EObject) eObj).eResource() != resource ) { System.out.println(\"Warning: cross resource: \" + eObj);	return null; }";
			s += "return trace.get((EObject) eObj).getId();";
		s += "}" + cr();

		s += "protected String[] convertObjectCollection(java.util.Collection<Object> objs) { " + cr();
			s += "String[] result = new String[objs.size()];";
			s += "int i = 0;";
			s += "for(Object o : objs) { result[i++] = getObjFromTrace(o); }";
			s += "return result;";
		s += "}" + cr();

		s += "}" + cr();
		
		genFiles.add(new GenClass(LinGen.getPkgName(pkg), readerClassName, s));		
	}

	private String getReaderName(EPackage pkg) {
		String head = pkg.getName().substring(0, 1).toUpperCase();
		String tail = pkg.getName().substring(1, pkg.getName().length());

		return head + tail + "Reader";
	}

	private String cast(EClass t) {
		return "(" + LinGen.getClassQName(t) + ")";
	}
	
	private String castPrimitive(EDataType t, String varName) {
		if ( t instanceof EEnum ) {
			return "convertEnum_" + t.getName() + "((EEnum)" + varName + ")";
		}
		
		return "(" + toPrimitiveTypeName(t) + ") " +  varName;
	}
	
	private String toPrimitiveTypeName(EDataType t) {
		if ( t instanceof EEnum ) {
			return LinGen.getEnumQName((EEnum) t); 
		} else {
			if ( isString(t)  ) return "String";
			if ( isInteger(t) ) return "int";
			if ( isDouble(t)  ) return "double";
			if ( isBoolean(t)  ) return "boolean";
			if ( t.getName().equals("EJavaObject") ) return "Object";
			if ( t.getName().equals("EJavaClass") ) return "Class";
			if ( t.getInstanceTypeName() != null ) return t.getInstanceTypeName();
		}
		throw new IllegalStateException("Not supported: " + t);
	}



	private boolean isString(EDataType t) {
		return t.getName().toLowerCase().contains("string");
	}

	private boolean isInteger(EDataType t) {
		return t.getName().toLowerCase().contains("int");
	}

	private boolean isDouble(EDataType t) {
		return t.getName().toLowerCase().contains("double");
	}

	private boolean isBoolean(EDataType t) {
		return t.getName().toLowerCase().contains("bool");
	}



	private String getFromEObject(String objName, EStructuralFeature f) {
		return objName + ".eGet(" + objName + ".eClass().getEStructuralFeature(" + quote(f.getName()) + "))";
	}



	private String getSetPropertiesMethod(EClass c) {
		return "setProperties_" + c.getName();
	}


	
}
 