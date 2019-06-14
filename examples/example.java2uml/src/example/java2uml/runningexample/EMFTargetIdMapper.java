package example.java2uml.runningexample;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;

import lintra2.blackboard.IdMapper;

public class EMFTargetIdMapper implements IdMapper<EObject> {

	private HashMap<EObject, String> objects = new HashMap<EObject, String>();
	
	@Override
	public synchronized String getId(EObject e) {
		return objects.get(e);
	}
	
	@Override
	public synchronized void addMapping(EObject e, String id) {
		if ( objects.containsKey(e)) {
			throw new IllegalStateException();
		}
		objects.put(e, id);
	}

	@Override
	public int getFirstId() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getLastId() {
		throw new UnsupportedOperationException();
	}

}
