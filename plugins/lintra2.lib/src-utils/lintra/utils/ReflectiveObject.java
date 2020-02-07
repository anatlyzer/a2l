package lintra.utils;

import org.eclipse.emf.ecore.EObject;

public class ReflectiveObject {

	private Object obj;

	public ReflectiveObject(Object obj) {
		this.obj = obj;
	}
	
	public String getName() {
		String name = obj.getClass().getSimpleName();
		// TODO: Do this in a general way
		if ( obj instanceof EObject && name.endsWith("Impl")) {
			name = name.substring(0, name.length() - 4);
		}
		return name;
	}
	
}
