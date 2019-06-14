package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedType extends IdentifiableElement,javamm.IType,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}