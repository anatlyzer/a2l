package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IRelationship extends IdentifiableElement,umlmm.IElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}