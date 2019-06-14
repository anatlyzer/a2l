package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractMethodDeclaration extends IdentifiableElement,jmm.IBodyDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}