package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IMethodDeclaration extends IdentifiableElement,jmm.IAbstractMethodDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}