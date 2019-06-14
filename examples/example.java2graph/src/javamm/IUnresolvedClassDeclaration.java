package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedClassDeclaration extends IdentifiableElement,javamm.IClassDeclaration,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}