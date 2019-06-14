package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstraction extends IdentifiableElement,umlmm.IDependency { 
public String getId();
public void setId(String id);
public String getTypeId();
}