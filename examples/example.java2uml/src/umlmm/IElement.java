package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IElement extends IdentifiableElement,umlmm.IEModelElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}