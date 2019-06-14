package lintra.lingen;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class AbstractGenerator {
	protected List<EObject> allObjects = new ArrayList<>();

	public AbstractGenerator(Resource resource) {
		resource.getAllContents().forEachRemaining(o -> allObjects.add(o));
	}

	protected List<EPackage> getPackages() {
		return allObjects.stream().
				filter(o -> o instanceof EPackage).
				map(o -> (EPackage) o).
				collect(Collectors.toList());		
	}
	
	protected List<EClass> getClasses() {
		return allObjects.stream().
				filter(o -> o instanceof EClass).
				map(o -> (EClass) o).
				collect(Collectors.toList());
	}
	
	protected List<EClass> getSortedClasses() {
		List<EClass> result = new ArrayList<EClass>();
		List<EClass> classes = getClasses();
		while ( ! classes.isEmpty() ) {
			EClass toBeRemoved = null;
			for (EClass c1 : classes) {
				boolean c1IsLeaf = true;
				for (EClass c2 : classes) {
					if ( c2.getESuperTypes().contains(c1) ) {
						c1IsLeaf = false;
						break;
					}
				}
				
				if ( c1IsLeaf ) {
					toBeRemoved = c1;
					break;
				}				
			}
			
			result.add(toBeRemoved);
			classes.remove(toBeRemoved);
		}
		
		return result;
		
	}
	
	protected List<EEnum> getEnums() {
		return allObjects.stream().
				filter(o -> o instanceof EEnum).
				map(o -> (EEnum) o).
				collect(Collectors.toList());
	}

	protected EPackage getRootPackage() {
		return getPackages().stream().filter(p -> p.getESuperPackage() == null).
				sorted((p1, p2) -> -1 * Integer.compare(numClasses(p1), numClasses(p2)) ).
				findFirst().get();
	}


	private int numClasses(EPackage p) {
		return (int) p.getEClassifiers().stream().filter(c -> c instanceof EClass).count();
	}

	protected String cr() {
		return "\n";
	}
	
	protected String quote(String s) {
		return "\"" + s + "\"";
	}

}
