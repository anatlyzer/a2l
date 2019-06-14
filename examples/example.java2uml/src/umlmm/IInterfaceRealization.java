package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInterfaceRealization extends IdentifiableElement,umlmm.IRealization { 
public String getId();
public void setId(String id);
public String getTypeId();
}