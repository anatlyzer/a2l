package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISuperMethodInvocation extends IdentifiableElement,javamm.IAbstractTypeQualifiedExpression,javamm.IAbstractMethodInvocation { 
public String getId();
public void setId(String id);
public String getTypeId();
}