package lintra.lingen;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * This class generates an ILintraWriter class able to process java objects
 * created by a Lintra transformation and generate the corresponding EMF resource.
 * 
 * @author jesus
 */
public class LintraEMFWriterGenerator extends AbstractGenerator {
	protected List<GenClass> genFiles = new ArrayList<GenClass>();

	public LintraEMFWriterGenerator(Resource resource) {
		super(resource);
	}

	public List<GenClass> generate() {
		genMainReader();
		return genFiles;
	}

	public String getWriterName() {
		EPackage pkg = getRootPackage();
		String writerClassName = getWriterName(pkg);
		return writerClassName;
	}
	
	public String getWriterPackageName() {
		return LinGen.getPkgName(getRootPackage());
	}
	
	private void genMainReader() {
		
		EPackage pkg = getRootPackage();
		String writerClassName = getWriterName(pkg);
		
		String s = "";
		
		s += "package " + LinGen.getPkgName(pkg) + ";" + cr(); 

		s += "import org.eclipse.emf.common.util.TreeIterator;" + cr();
		s += "import org.eclipse.emf.ecore.EObject;"  + cr();
		s += "import org.eclipse.emf.ecore.EClass;"  + cr();
		s += "import org.eclipse.emf.ecore.EEnum;"  + cr();
		s += "import org.eclipse.emf.ecore.EPackage;"  + cr();
		s += "import org.eclipse.emf.ecore.resource.Resource;"  + cr();
		s += "import lintra2.blackboard.IdentifiableElement;" + cr();
		s += "import a2l.runtime.lintra.ILintraModel;" + cr();
		s += "import java.util.HashMap;"  + cr();

		
		s += "@SuppressWarnings(\"serial\")";
		s += "public " + "class " + writerClassName  + " " + "implements " + "lintra2.runners.ILintraModelWriter " + " { " + cr();
		s += "protected HashMap<String, EObject> trace = new HashMap<>();";
		s += "protected ILintraModel area;";
		s += "protected HashMap<String, EPackage> packages = new HashMap<>();";
		
		// Constructor
		s += "public " + writerClassName + "() {";
		s += "}";
		
		// read
		s += "public void doWrite(ILintraModel model, Resource r, Resource mm) { " + cr();
		        s += "this.area = model;";
		        s += "mm.getAllContents().forEachRemaining(o -> { if (o instanceof EPackage) packages.put( ((EPackage) o).getNsURI(), (EPackage) o); });";
		
				s += "try {";
				s += "for (Object o : area.allInstances()) {"
					+ "IdentifiableElement ie = (IdentifiableElement) o;" 
					+ "EObject eObj = readObject(ie);"
					+ "trace.put(ie.getId(), eObj);" 
				+ "}";
		
				s += "} catch (Exception e) { throw new RuntimeException(e); }";
				
			s += "trace.forEach((key, value) -> { try { copyProperties(value, area.read(key)); } catch (Exception e) { throw new RuntimeException(e); }	});";			
			
			s += "trace.forEach((key, value) -> { if ( value.eContainer() == null ) r.getContents().add(value); });";
		s += "} " + cr();


		System.out.println("Original classes:");
		for (EClass e : getClasses()) {
			System.out.println("  - " + e.getName());
		}

		System.out.println("Sorted classes:");
		for (EClass e : getSortedClasses()) {
			System.out.println("  - " + e.getName());
		}
		
		// readObject
		s += "protected EObject readObject(IdentifiableElement ie) { " + cr();		
			for (EClass c : getSortedClasses()) {
				if ( c.isAbstract() ) 
					continue;
				
				s += "if ( ie instanceof " + LinGen2.getInterfaceQName(c) + " ) {"						
						+ "return createEObject(" + quote(c.getName()) + ", " + quote(c.getEPackage().getNsURI()) + ");" 
					+ "}";
			}
	
			s += "throw new IllegalStateException();";
		s += "}" + cr();

		// copyProperties
		s += "protected void copyProperties(EObject eObj, Object ie) { " + cr();
			for (EClass c : getSortedClasses()) {
				if ( c.isAbstract() ) 
					continue;
				
				s += "if ( ie instanceof " + LinGen2.getInterfaceQName(c) + " ) {"						
						+ getSetPropertiesMethod(c) + "(eObj, " + cast(c) + "ie); return;"
					+ "}";
			}
	
			s += "throw new IllegalStateException();";
		s += "}" + cr();

		// setProperties
		for (EClass c : getClasses()) {		
			s += "protected void " + getSetPropertiesMethod(c) + "(EObject eObj, " + LinGen2.getInterfaceQName(c) + " obj) { " + cr();
				s += "EObject tmp = null;";
				for (EAttribute attribute : c.getEAllAttributes()) {
					String getter = "obj." + LinGen.getter(attribute) + "()";

					Function<String, String> getterCall = (valueExpr) -> {					
						if ( attribute.getEAttributeType() instanceof EEnum ) {
							EEnum eenum = (EEnum) attribute.getEAttributeType();
							return "createEEnum(" + quote(LinGen.getEnumName(eenum)) + ", " +
									quote(eenum.getEPackage().getNsURI()) + "," +
									valueExpr + "== null ? null :" + valueExpr + ".name())";
						} else {
							return valueExpr;
						}
					
					};
					
					if ( attribute.isMany() ) {
						// toPrimitiveTypeName
						// create a temporary array with the attribute name and fill it with the collection contents
						String ptypeName = toPrimitiveTypeName(attribute.getEAttributeType());
						String varName = "tmp" + attribute.getName();
						s += ptypeName + "[] " + varName + " = " + getter + ";"; 
						s += "if ( " + varName + " != null ) {";
							s += "for(" + ptypeName + " v : " + varName + ") {"; 
							  s += "( (java.util.Collection<Object>)" + getFromEObject("eObj", attribute) + ").add(" + getterCall.apply("v")+ ");";  
							s += "}";
						s += "}";
					} else {
						s += setForEObject("eObj", attribute, getterCall.apply(getter)) + ";";
					}
				}
				
				for (EReference reference : c.getEAllReferences()) {
					if ( reference.isMany() ) {
						// s += "obj." + LinGen.getter(reference) + ".add(" + cast(reference.getEReferenceType()) + getFromEObject("eObj", reference) + ");" + cr();

						s += "fillCollection((java.util.Collection<Object>) " + getFromEObject("eObj", reference) + ", obj." + LinGen.getter(reference) + "());";
					} else {
						s += "tmp = getObjFromTrace(obj." + LinGen.getter(reference) + "());";
						s += "if ( tmp != null ) { ";
								s += setForEObject("eObj", reference, "tmp") + ";";
						s += "}";
					}

				}
			
			s += "}" + cr();
		}
		
		// Get from trace
		s += "protected EObject getObjFromTrace(String str) { " + cr();
			s += "if ( str == null ) return null; EObject r = trace.get(str); if ( r == null ) throw new IllegalStateException(); return r;";
		s += "}" + cr();

		s += "protected void fillCollection(java.util.Collection<Object> objs, String[] strings) { " + cr();
			s += "for(String s : strings) { objs.add(getObjFromTrace(s)); }";
		s += "}" + cr();

		
		s += "protected EObject createEObject(String eClassName, String nsURI) {" 
			+ " EPackage pkg = packages.get(nsURI);"
			+ "EClass c = (EClass) pkg.getEClassifier(eClassName);"
			+ "return org.eclipse.emf.ecore.util.EcoreUtil.create(c);"
		+ "}";
				
		s += "protected Object createEEnum(String eClassName, String nsURI, String literal) {"  
			 + "EPackage pkg = packages.get(nsURI);"
			 + "EEnum c = (EEnum) pkg.getEClassifier(eClassName);"
			 + "return org.eclipse.emf.ecore.util.EcoreUtil.createFromString(c, literal);"
			 + "}";
		
		
		s += "}" + cr();
		
		genFiles.add(new GenClass(LinGen.getPkgName(pkg), writerClassName, s));		
	}

	private String getWriterName(EPackage pkg) {
		String head = pkg.getName().substring(0, 1).toUpperCase();
		String tail = pkg.getName().substring(1, pkg.getName().length());

		return head + tail + "Writer";
	}

	private String cast(EClass t) {
		// return "(" + LinGen.getClassQName(t) + ")";
		return "(" + LinGen2.getInterfaceQName(t) + ")";
	}
	
	private String castPrimitive(EDataType t) {
		return "(" + toPrimitiveTypeName(t) + ")";
	}
	
	private String toPrimitiveTypeName(EDataType t) {
		if ( t instanceof EEnum ) {
			return LinGen.getEnumQName((EEnum) t); 
		} else {
			if ( isString(t)  ) return "String";
			if ( isInteger(t) ) return "int";
			if ( isDouble(t)  ) return "double)";
			if ( isBoolean(t)  ) return "boolean";
		}
		throw new IllegalStateException();
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

	private String setForEObject(String objName, EStructuralFeature f, String value) {
		return objName + ".eSet(" + objName + ".eClass().getEStructuralFeature(" + quote(f.getName()) + "), " + value + ")";
	}


	private String getSetPropertiesMethod(EClass c) {
		return "setProperties_" + c.getName();
	}


	
}
 