package a2l.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Represents a set of objects which are used as input for the transformation.
 * 
 * TODO: This could be smarter and have one input extent per metamodel/model used in the
 *       transformation, and used them to call specific transform-methods. However,
 *       this is a optimization that is only applicable to transforms which more than one
 *       input model and with many matchings. Probably not worth it.
 * 
 * @author jesus
 *
 */
public class InputExtent {

	private List<Object> allInstances = null;
	
	public void add(Object o) {
		if (allInstances == null)
			allInstances = new ArrayList<Object>();
		this.allInstances.add(o);
	}
	
	public void addAll(Collection<? extends Object> objects) {
		if (allInstances == null)
			allInstances = new ArrayList<Object>(objects.size());

		for (Object object : objects) {
			this.allInstances.add(object);
		}
	}
	
	public List<Object> getAllInstances() {
		if (allInstances == null)
			allInstances = new ArrayList<Object>();		
		return allInstances;
	}
	
	public long size() {
		return allInstances.size();
	}

	public Object get(long i) {
		// TODO: Handle this somehow!
		return allInstances.get((int) i);
	}

}
