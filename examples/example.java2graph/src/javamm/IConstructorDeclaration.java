package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IConstructorDeclaration extends IdentifiableElement,javamm.IAbstractMethodDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}