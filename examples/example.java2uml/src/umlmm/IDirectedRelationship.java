package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IDirectedRelationship extends IdentifiableElement,umlmm.IRelationship { 
public String getId();
public void setId(String id);
public String getTypeId();
}