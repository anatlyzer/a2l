package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IFieldDeclaration extends IdentifiableElement,javamm.IBodyDeclaration,javamm.IAbstractVariablesContainer { 
public String getId();
public void setId(String id);
public String getTypeId();
}