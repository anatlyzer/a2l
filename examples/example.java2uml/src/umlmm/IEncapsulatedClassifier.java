package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEncapsulatedClassifier extends IdentifiableElement,umlmm.IStructuredClassifier { 
public String getId();
public void setId(String id);
public String getTypeId();
}