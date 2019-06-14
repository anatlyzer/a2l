package lintra2.blackboard;

import java.io.Serializable;

public interface IdentifiableElement extends Serializable, Cloneable {
	
	public String getId();
	
	public void setId(String id);
	
	public String getTrgId();
	
	public void setTrgId(String trgId);
	
//	Object clone() throws CloneNotSupportedException;
}
