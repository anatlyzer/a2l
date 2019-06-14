package example.java2uml.runningexample;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IdMapper;
import lintra2.transfo.IDataSource;

public class EMFDataSource implements IDataSource {

	private Resource input;
	private HashMap<EObject, String> objects = new HashMap<EObject, String>();
	
	public EMFDataSource(Resource input) {
		this.input = input;
	}

	@Override
	public IdMapper getIdMapper() {
		return new EMFIdMapper();
	}

	@Override
	public void fill(IArea area) {
		int id = 0;
		TreeIterator<EObject> it = input.getAllContents();
		while ( it.hasNext() ) {
			EObject obj = it.next();
			objects.put(obj, (id * 1.0) + "");
			try {
				area.write(obj);
			} catch (BlackboardException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// objects.add(obj);
			id++;
		}
	}

	public class EMFIdMapper implements IdMapper<EObject> {

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
			return 0;
		}

		@Override
		public int getLastId() {
			return objects.size();
		}
		
	}
}
