package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IMethodInvocation extends IdentifiableElement,javamm.IExpression,javamm.IAbstractMethodInvocation { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExpression(String v);public String getExpression();}