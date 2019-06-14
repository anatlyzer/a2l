package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAssertStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setMessage(String v);public String getMessage();public void setExpression(String v);public String getExpression();}