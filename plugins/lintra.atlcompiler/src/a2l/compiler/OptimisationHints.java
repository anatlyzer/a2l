package a2l.compiler;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
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
	private Map<OutPatternElement, List<Rule>> dependencyInfo;
	
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
	
	// X.allInstances()->select(x = y) 
	// index X by x
	public static class IndexedValue implements Hotspot {

		private OperationCallExp allInstancesCall;
		private OclExpression preprocessedKeyExpr;
		private OclExpression dynamicKeyExpr;
		private Metaclass metaclass;
		private String nameHint;
		private IndexType type;

		public static enum IndexType {
			SET, /* exists */
			MAP_LIST  /* select */
		}
		
		public IndexedValue(IndexType type, OperationCallExp allInstancesCall, OclExpression preprocessedKeyExpr, OclExpression dynamicKeyExpr, Metaclass metaclass, String nameHint) {
			this.type = type;
			this.allInstancesCall = allInstancesCall;
			this.preprocessedKeyExpr = preprocessedKeyExpr;
			this.dynamicKeyExpr= dynamicKeyExpr;
			this.metaclass = metaclass;
			this.nameHint = nameHint;
		}
		
		public OperationCallExp getAllInstancesCall() {
			return allInstancesCall;
		}
		
		public IteratorExp getIteratorExp() {
			return (IteratorExp) allInstancesCall.eContainer();
		}
		
		public Metaclass getMetaclass() {
			return metaclass;
		}
		
		public IndexType getType() {
			return type;
		}
		
		public OclExpression getPreprocessedKeyExpr() {
			return preprocessedKeyExpr;
		}

		public OclExpression getDynamicKeyExpr() {
			return dynamicKeyExpr;
		}
		
		@Override
		public OclExpression getCachedExpression() {
			return allInstancesCall;
		}

		public String getCachedGetMethodName() {
			return "getValueOf_" + metaclass.getKlass().getName() + "_" + nameHint;
		}

		public String getCachedSetMethodName() {
			return "setValueOf_" + metaclass.getKlass().getName() + "_" + nameHint;
		}

	}

	public void addDependencyInfo(Map<OutPatternElement, List<Rule>> dependencyInfo) {
		this.dependencyInfo = dependencyInfo;		
	}

	public boolean isOutputPatternUsed(OutPatternElement ope) {
		List<Rule> rules = dependencyInfo.get(ope);
		return rules != null && rules.size() > 0;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getHotspots(Class<T> klass) {
		return (List<T>) hotspots.values().stream().filter(klass::isInstance).collect(Collectors.toList());
	}
	
	//public Map<OutPatternElement, List<MatchedRule>> getDependencyInfo() {
	//	return Collections.unmodifiableMap(dependencyInfo);
	//}


}
