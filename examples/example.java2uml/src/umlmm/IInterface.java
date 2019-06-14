package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInterface extends IdentifiableElement,umlmm.IClassifier { 
public String getId();
public void setId(String id);
public String getTypeId();
}