package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IDeploymentTarget extends IdentifiableElement,umlmm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}