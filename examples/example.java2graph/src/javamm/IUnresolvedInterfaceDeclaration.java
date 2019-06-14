package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedInterfaceDeclaration extends IdentifiableElement,javamm.IInterfaceDeclaration,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}