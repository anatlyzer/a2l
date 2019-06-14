package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAnnotationTypeDeclaration extends IdentifiableElement,jmm.IAbstractTypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}