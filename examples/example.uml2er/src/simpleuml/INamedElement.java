package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface INamedElement extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();}