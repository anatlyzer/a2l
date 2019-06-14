package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedEnumDeclaration extends IdentifiableElement,javamm.IEnumDeclaration,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}