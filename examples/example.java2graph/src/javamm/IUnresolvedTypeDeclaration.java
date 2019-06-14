package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedTypeDeclaration extends IdentifiableElement,javamm.IAbstractTypeDeclaration,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}