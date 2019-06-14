package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAttribute extends IdentifiableElement,er.IFeature { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(java.lang.String v);public java.lang.String getType();}