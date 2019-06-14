package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IVariableDeclarationFragment extends IdentifiableElement,javamm.IVariableDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setVariablesContainer(String v);public String getVariablesContainer();}