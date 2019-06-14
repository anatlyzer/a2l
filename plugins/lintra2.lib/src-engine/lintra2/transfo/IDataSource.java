package lintra2.transfo;

import java.util.function.Consumer;

import a2l.runtime.IModel;
import a2l.runtime.InputExtent;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IdMapper;

public interface IDataSource {

	public IdMapper getIdMapper();
	public void fill(IArea area);
	
	public default IModel createModel() { return createModel(null); };
	public IModel createModel(AllInstancesAdder allInstancesAdder);
	
	public InputExtent toInputExtent();
	public InputExtent toInputExtentPartitioned(int numThreads);
	
	
	static interface AllInstancesAdder extends Consumer<Object> {
		
	}
	
}
