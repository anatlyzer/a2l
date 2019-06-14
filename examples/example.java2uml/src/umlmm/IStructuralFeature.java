package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IStructuralFeature extends IdentifiableElement,umlmm.IFeature,umlmm.ITypedElement,umlmm.IMultiplicityElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}