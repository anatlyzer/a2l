package a2l.runtime;

import java.util.HashMap;
import java.util.Map;

public class DefaultGlobalContext extends GlobalTrace implements IGlobalContext {

	private Map<String, IModel> models = new HashMap<String, IModel>();
	
	@Override
	public void addInputModel(String modelName, IModel model) {
		if ( models.containsKey(modelName))
			throw new IllegalArgumentException();
		models.put(modelName, model);
	}

	@Override
	public void addOutputModel(String modelName, IModel model) {
		if ( models.containsKey(modelName))
			throw new IllegalArgumentException();
		models.put(modelName, model);		
	}

	@Override
	public PartialTrace createPartialTrace() {
		// Delegates to GlobalTrace
		return this.newPartialTrace();
	}
	
	@Override
	public GlobalTrace getGlobalTrace() {
		return this;
	}

}
