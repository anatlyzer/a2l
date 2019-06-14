package a2l.compiler;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import anatlyzer.atl.types.Type;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.VariableExp;

/**
 * This class gathers information about optimisation opportunities,
 * normally gathered by A2LOptimiser. 
 *  
 * @author jesus
 *
 */
public class OptimisationHints {

	private Map<OclExpression, Hotspot> hotspots = new HashMap<>();
	
	public void addHotspot(Hotspot h) {
		hotspots.put(h.getCachedExpression(), h);
	}
	
	public Hotspot getHotspot(OclExpression e) {
		return hotspots.get(e);
	}

	public Collection<? extends Hotspot> getHotspots() {
		return hotspots.values();
	}

	
	public static interface Hotspot {
		public OclExpression getCachedExpression();
	}

	@Override
	public String toString() {	
		return hotspots.values().stream().map(m -> m.toString()).collect(Collectors.joining("\n"));
	}
	
	public static class CachedValue implements Hotspot {
		private final OclExpression cachedExpression;
		private final OclExpression cachingKey;
		private final int index;
		private static int current = 0;

		public CachedValue(OclExpression cachedExpression, OclExpression cachingKey) {
			this.cachedExpression = cachedExpression;
			this.cachingKey = cachingKey;
			this.index = current ++;
		}
		
		public OclExpression getCachedExpression() {
			return cachedExpression;
		}
		
		public OclExpression getCachingKey() {
			return cachingKey;
		}

		public String getCacheSiteName() {
			String prefix = "cache" + index;
			if ( cachingKey instanceof VariableExp ) {
				prefix += "_" + ((VariableExp) cachingKey).getReferredVariable().getVarName();
			}
			return prefix;
		}

		public Type getKeyType() {
			return cachingKey.getInferredType();
		}

		public Type getValueType() {
			return cachedExpression.getInferredType();
		}

		
		@Override
		public String toString() {		
			return "[" + getCachingKey().getLocation() + ":" + getCachingKey().eClass().getName() + ", " + getCachedExpression().getLocation() + ":" + getCachedExpression().eClass().getName() + "]";
		}


	}


}
