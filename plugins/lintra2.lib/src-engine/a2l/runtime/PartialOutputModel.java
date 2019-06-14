package a2l.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PartialOutputModel {

	private List<Object> objects = new ArrayList<Object>();
	
	public void write(Object obj) {
		objects.add(obj);		
	}

	public Collection<Object> allInstances() {
		return objects;
	}

	public boolean belongsTo(Object obj) {
		return objects.contains(obj);
	}

}
