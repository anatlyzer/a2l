package a2l.runtime;

import java.util.List;
import java.util.Set;

public class RuntimeUtils {

	public static void addToBindingTemporal(List<Object> bindingCollection, Set<Object> targetElements, Object rhs) {
		// Don't add things like 'OclUndefined'
		if (rhs == null)
			return;
		bindingCollection.add(rhs);
		targetElements.add(rhs);		
	}

}
