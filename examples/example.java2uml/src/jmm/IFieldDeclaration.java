package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IFieldDeclaration extends IdentifiableElement,jmm.IBodyDeclaration,jmm.IAbstractVariablesContainer { 
public String getId();
public void setId(String id);
public String getTypeId();
}