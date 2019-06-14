package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IBehavioralFeature extends IdentifiableElement,umlmm.INamespace,umlmm.IFeature { 
public String getId();
public void setId(String id);
public String getTypeId();
}