package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IFeature extends IdentifiableElement,umlmm.IRedefinableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}