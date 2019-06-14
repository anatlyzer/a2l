package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IStrongReference extends IdentifiableElement,er.IReference { 
public String getId();
public void setId(String id);
public String getTypeId();
}