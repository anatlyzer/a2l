package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEModelElement extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}