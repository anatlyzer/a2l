package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IProperty extends IdentifiableElement,umlmm.IStructuralFeature,umlmm.IConnectableElement,umlmm.IDeploymentTarget { 
public String getId();
public void setId(String id);
public String getTypeId();
}