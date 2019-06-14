package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IConnectableElement extends IdentifiableElement,umlmm.ITypedElement,umlmm.IParameterableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}