package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackageableElement extends IdentifiableElement,umlmm.INamedElement,umlmm.IParameterableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}