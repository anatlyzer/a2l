package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITryStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();public void setFinally(String v);public String getFinally();public void setCatchClauses(String[] v);public String[] getCatchClauses();}