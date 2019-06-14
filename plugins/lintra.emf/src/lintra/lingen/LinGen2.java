package lintra.lingen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Generator for Lintra classes which take into account multiple inheritance.
 * @author jesus
 *
 */
public class LinGen2 extends LinGen {

	public LinGen2(Resource r) {
		super(r);
	}
	
	public List<GenClass> generate() {
		super.generate();
		genInterfaces();
		return genFiles;
	}

	private void genInterfaces() {
		for (EClass eClass : getClasses()) {
			genInterface(eClass);
		}		
	}
	
	private void genInterface(EClass c) {
		String s = "";
		
		s += "package " + getPkgName(c.getEPackage()) + ";" + cr(); 
		s += "import lintra2.blackboard.IdentifiableElement;" + cr();
		s += "import java.io.Serializable;" + cr();
		// s += "import �this.ePackage.name()�.Enums.*;;

		ArrayList<String> interfaces = new ArrayList<String>();
		interfaces.add("IdentifiableElement");
		interfaces.addAll(getSuperTypeInterfaces(c));

		String extends_ = 
			// There are always supertypes: IdentifiableElement
			// c.getESuperTypes().isEmpty() ? "" :
			"extends " + interfaces.stream().collect(Collectors.joining(","));
			
		s += "@SuppressWarnings(\"serial\")";
		s += "public interface " + getInterfaceName(c) + " " + extends_ + " { " + cr();
		
		s += "public String getId();" + cr();
		s += "public void setId(String id);" + cr();
		s += "public String getTypeId();" + cr();
		
		for(EStructuralFeature f : c.getEStructuralFeatures()) {
			String typeName = getPropertyTypeName(f.getEType());
			if ( f.isMany() ) {
				typeName = typeName + "[]";
			}
					
			s += "public void " + setter(f) + "(" + typeName + " v);";			
			s += "public " + typeName + " " + getter(f) + "();";
		}
		
		
		s += "}";

		genFiles.add(new GenClass(getPkgName(c.getEPackage()), getInterfaceName(c), s));
	}

	@Override
	protected Collection<String> getAdditionalInterfaces(EClass c) {
		return Stream.concat(Stream.of(getInterfaceName(c)), 
				c.getESuperTypes().stream().map(k -> getInterfaceQName(k))).
				collect(Collectors.toList());
	}

	protected Collection<String> getSuperTypeInterfaces(EClass c) {
		return c.getESuperTypes().stream().map(k -> getInterfaceQName(k)).
				collect(Collectors.toList());
	}
	
	public static String getInterfaceName(EClass c) {
		return "I" + getClassName(c);
	}
	
	public static String getInterfaceQName(EClass c) {
		return getPkgName(c.getEPackage()) + "." + getInterfaceName(c);
	}

	
}

