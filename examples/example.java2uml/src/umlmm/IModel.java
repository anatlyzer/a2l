package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModel extends IdentifiableElement,umlmm.IPackage { 
public String getId();
public void setId(String id);
public String getTypeId();
}