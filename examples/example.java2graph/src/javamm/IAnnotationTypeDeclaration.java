package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAnnotationTypeDeclaration extends IdentifiableElement,javamm.IAbstractTypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
}