package lintra2.transfo;

import java.util.Collection;

import lintra2.blackboard.BlackboardException;

public interface ITransformation {

	public void transform(
			Collection<Object> objs, IMaster masterNextTransfo) throws BlackboardException, InterruptedException;

	public default void postprocessing() throws BlackboardException { }
}
