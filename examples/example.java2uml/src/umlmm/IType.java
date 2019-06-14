package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IType extends IdentifiableElement,umlmm.IPackageableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}