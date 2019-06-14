package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISynchronizedStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();public void setExpression(String v);public String getExpression();}