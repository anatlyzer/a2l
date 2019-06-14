package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IRealization extends IdentifiableElement,umlmm.IAbstraction { 
public String getId();
public void setId(String id);
public String getTypeId();
}