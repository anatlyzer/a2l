package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEnhancedForStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();public void setExpression(String v);public String getExpression();public void setParameter(String v);public String getParameter();}