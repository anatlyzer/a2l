package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedSingleVariableDeclaration extends IdentifiableElement,javamm.ISingleVariableDeclaration,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}