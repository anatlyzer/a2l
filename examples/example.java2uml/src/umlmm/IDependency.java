package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IDependency extends IdentifiableElement,umlmm.IPackageableElement,umlmm.IDirectedRelationship { 
public String getId();
public void setId(String id);
public String getTypeId();
}