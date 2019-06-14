package lintra2.blackboard;

import java.util.Collection;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;

public interface ISearch<ElementType> {
	
	public Collection<ElementType> search(IArea<ElementType> area) throws BlackboardException;
	
}
