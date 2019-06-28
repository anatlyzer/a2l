package a2l.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public Object getSecondary(Object o, String opeName) {
		for (PartialTrace t : partialTraces) {
			Object r = t.getSecondary(o, opeName);
			if ( r != null )
				return r;
		}
		return null;
	}

	
	public static class PartialTrace extends HashMap<Object, Object> {
		private static final long serialVersionUID = -3402308008157891256L;

		private final Map<Object, Map<String, Object>> secondaryTrace = new HashMap<>();
		
		public void put(Object key, Object value, String varName) {
			Map<String, Object> map = secondaryTrace.computeIfAbsent(key, (k) -> new HashMap<>());
			map.put(varName, value);
		}

		public Object getSecondary(Object o, String opeName) {
			Map<String, Object> m = secondaryTrace.get(o);
			if ( m != null)
				return m.get(opeName);
			return null;
		}
		
		
	}

	public class SecondayTraceKey<A, B> {
		public final A _1;
		public final B _2;

		public SecondayTraceKey(A a, B b) {
			this._1 = a;
			this._2 = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
			result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SecondayTraceKey other = (SecondayTraceKey) obj;
			if (_1 == null) {
				if (other._1 != null)
					return false;
			} else if (!_1.equals(other._1))
				return false;
			if (_2 == null) {
				if (other._2 != null)
					return false;
			} else if (!_2.equals(other._2))
				return false;
			return true;
		}
		
		
	}


}
