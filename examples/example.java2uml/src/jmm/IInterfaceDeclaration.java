package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInterfaceDeclaration extends IdentifiableElement,jmm.ITypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}