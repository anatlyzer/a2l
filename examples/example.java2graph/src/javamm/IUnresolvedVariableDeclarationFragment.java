package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedVariableDeclarationFragment extends IdentifiableElement,javamm.IVariableDeclarationFragment,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}