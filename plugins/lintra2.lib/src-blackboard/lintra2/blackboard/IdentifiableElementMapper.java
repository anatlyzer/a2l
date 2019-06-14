package lintra2.blackboard;

/**
 * This class is intended for internal use of Lintra only.
 * 
 * @author jesus
 *
 */
public class IdentifiableElementMapper implements IdMapper<IdentifiableElement> {
	
	@Override
	public String getId(IdentifiableElement e) {
		return e.getId();
	}
	
	@Override
	public void addMapping(IdentifiableElement e, String id) {
		if ( e.getId() != null )
			throw new IllegalStateException();
		e.setId(id);
	}

	@Override
	public int getFirstId() {
		throw new IllegalStateException();
	}

	@Override
	public int getLastId() {
		throw new IllegalStateException();
	}

	@Override
	public boolean belongsTo(Object obj) {
		throw new UnsupportedOperationException();
	}
	
}
