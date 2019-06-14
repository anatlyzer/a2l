package a2l.compiler;

import anatlyzer.atlext.ATL.LocatedElement;
import anatlyzer.atlext.OCL.OclExpression;

public class AstAnnotations {

	public static final String MUTABLE = "MUTABLE"; 
	public static final String CACHEABLE = "CACHEABLE";

	public static boolean isMutable(LocatedElement elem) {
		String value = elem.getAnnotations().get(MUTABLE);
		return value != null && "TRUE".equals(value.toUpperCase());
	}
	
	public static boolean isCacheable(LocatedElement elem) {
		String value = elem.getAnnotations().get(CACHEABLE);
		return value != null && "TRUE".equals(value.toUpperCase());
	}
	
	public static void markMutable(LocatedElement elem) {
		elem.getAnnotations().put(AstAnnotations.MUTABLE, "true");	
	}

	public static void markCacheable(OclExpression elem) {
		elem.getAnnotations().put(AstAnnotations.CACHEABLE, "true");		
	}
	
}
