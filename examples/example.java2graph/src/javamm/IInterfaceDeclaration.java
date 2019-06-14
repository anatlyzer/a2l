package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInterfaceDeclaration extends IdentifiableElement,javamm.ITypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}