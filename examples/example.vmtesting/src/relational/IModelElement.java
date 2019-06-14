package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModelElement extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setComment(java.lang.String v);public java.lang.String getComment();}