package a2l.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;


public class GlobalTrace {

	private List<PartialTrace> partialTraces = new ArrayList<>();
	private HashMap<Object, Object> all;

	public PartialTrace newPartialTrace() {
		PartialTrace partialTrace = new PartialTrace();
		this.partialTraces.add(partialTrace);
		return partialTrace;
	}

	
	public void pack() {
		this.all = new HashMap<Object, Object>();
		for(PartialTrace t : this.partialTraces) {
			this.all.putAll(t);
		}
	}

	public Collection<? extends Object> getAll(Collection<? extends Object> sources) {
		ArrayList<Object> result = new ArrayList<>(sources.size());
		for (Object object : sources) {
			Object r = get(object);
			if ( r != null )
				result.add(r);
		}
		return result;
	}

	public Object get(Object o) {
		if ( all != null ) {
			return all.get(o);
		}
		
		for (PartialTrace t : partialTraces) {
			Object r = t.get(o);
			if ( r != null )
				return r;
		}
		return null;
	}

	public static class PartialTrace extends HashMap<Object, Object> {
		private static final long serialVersionUID = -3402308008157891256L;
	}


}
