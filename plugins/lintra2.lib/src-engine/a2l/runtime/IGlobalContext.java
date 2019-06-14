package a2l.runtime;

import java.util.Map;

/**
 * Represents global information which may need to be accessed by a
 * transformation. 
 * 
 * The methods needs to be implemented in a thread-safe way.
 * 
 * @author jesus
 *
 */
public interface IGlobalContext {

	public void addInputModel(String modelName, IModel model);
	public void addOutputModel(String modelName, IModel model);
	
	public Map<Object, Object> createPartialTrace();
	public GlobalTrace getGlobalTrace();
	
	
}
