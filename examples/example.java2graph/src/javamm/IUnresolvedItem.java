package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedItem extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}