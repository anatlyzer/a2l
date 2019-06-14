package a2l.utils;

import org.eclipse.emf.ecore.EObject;

public class Assertions {

	public static boolean checkNoContainer(EObject obj) {
		if ( obj.eContainer() != null )
			throw new IllegalStateException();
		return true;
	}
	
}
