package lintra.emf;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.ecore.EObject;

import lintra2.blackboard.IdMapper;

public class EMFTargetIdMapper implements IdMapper<EObject> {

	private Map<EObject,String> objects = new ConcurrentHashMap<EObject, String>();
	
	@Override
	public String getId(EObject e) {
		return objects.get(e);
	}
	
	@Override
	public void addMapping(EObject e, String id) {
		// Activate only for debug...
		//if ( objects.containsKey(e)) {
		//	throw new IllegalStateException();
		//}
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

	@Override
	public boolean belongsTo(Object obj) {
		return objects.containsKey(obj);
	}
}
