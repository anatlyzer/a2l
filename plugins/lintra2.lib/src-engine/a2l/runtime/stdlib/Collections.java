package a2l.runtime.stdlib;

import java.util.List;
import java.util.function.Function;

public class Collections {

	@SuppressWarnings("unchecked")
	public static <T> void sort(List<T> list, Function<T, Comparable<? extends Object>> map) {
    	java.util.Collections.sort(list,  (v1, v2) -> {
    		Comparable<? extends Object> c1 = map.apply(v1);
    		Comparable<? extends Object> c2 = map.apply(v2);    		
    		return ((Comparable<Object>) c1).compareTo((Comparable<Object>) c2);
    	});
    }
}
