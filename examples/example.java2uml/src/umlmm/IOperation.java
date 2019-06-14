package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IOperation extends IdentifiableElement,umlmm.IBehavioralFeature,umlmm.IParameterableElement,umlmm.ITemplateableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}