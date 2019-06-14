package lintra2.blackboard;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Consumer;

public class SearchByIdRange implements ISearch<Object> {
	
	double minId, maxId;
	boolean gapsAllowed;
	
	public SearchByIdRange(double d, double e, boolean gapsAllowed){
		this.minId = d;
		this.maxId = e;
		this.gapsAllowed = gapsAllowed;
	}

	@Override
	public Collection<Object> search(IArea area) throws BlackboardException {
		
//		if (gapsAllowed){
			return searchForAvailables(area);
//		} else {
//			return searchForAll(area);
//		}
		
	}

	private Collection<Object> searchForAvailables(IArea area) throws BlackboardException {
		Collection<Object> ies = new LinkedList<Object>();
		for (double i = minId; i <= maxId; i++) {
			Object ie = area.read(Double.toString(i));
			if (ie != null){
				ies.add(ie);
			}
		}
		return ies;
	}
	
	
	public void applyTo(IArea area, Consumer<Object> consumer) throws BlackboardException {
		for (double i = minId; i <= maxId; i++) {
			Object ie = area.read(Double.toString(i));
			if (ie != null){
				consumer.accept(ie);
			}
		}		
	}
}

