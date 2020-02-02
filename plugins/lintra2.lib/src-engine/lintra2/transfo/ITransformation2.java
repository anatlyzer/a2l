package lintra2.transfo;

import lintra2.blackboard.BlackboardException;

public interface ITransformation2 {

	// For entrypoint rules mainly. Only one thread can do this
	public default void doInitialisation() { }
	public default void doEndpoint() { }
	
	public void transform(Object obj2) throws BlackboardException;

	public default void doPostprocessing() { }
	
	public default void doSequentialPostprocessing() { }
	
	public default void doParallelPostprocessing() { }

	public default void doSequentialCleanup() { }
	
	/** Profiling methods */
	
	public default int getNumExecutions() { return -1; }

	public default int getNumMatchedRuleExecutions() { return -1; }	

}
