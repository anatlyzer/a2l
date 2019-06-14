package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPrimitiveType extends IdentifiableElement,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
}