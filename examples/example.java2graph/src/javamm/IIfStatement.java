package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IIfStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExpression(String v);public String getExpression();public void setThenStatement(String v);public String getThenStatement();public void setElseStatement(String v);public String getElseStatement();}