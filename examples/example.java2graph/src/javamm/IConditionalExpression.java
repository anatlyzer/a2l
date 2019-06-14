package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IConditionalExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setElseExpression(String v);public String getElseExpression();public void setExpression(String v);public String getExpression();public void setThenExpression(String v);public String getThenExpression();}