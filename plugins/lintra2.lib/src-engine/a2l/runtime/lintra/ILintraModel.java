package a2l.runtime.lintra;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface ILintraModel {

	public Object read(String id);

	/**
	 * I used <T> to skip compiler checks "thanks" to erasure
	 */
	public <T> List<T> readAll(Collection<String> list);

	public List<? extends Object> allInstances();
}
