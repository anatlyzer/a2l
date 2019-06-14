package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IReference extends IdentifiableElement,er.IFeature { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(String v);public String getType();}