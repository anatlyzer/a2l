package lintra2.blackboard;

public interface IdMapper<ElementType> {

	public String getId(ElementType e);

	public void addMapping(ElementType e, String id);
	
	public int getFirstId();

	public int getLastId();

	public boolean belongsTo(Object obj); 
	
}
