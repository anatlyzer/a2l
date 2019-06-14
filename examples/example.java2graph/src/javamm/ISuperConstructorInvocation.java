package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISuperConstructorInvocation extends IdentifiableElement,javamm.IStatement,javamm.IAbstractMethodInvocation { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExpression(String v);public String getExpression();}