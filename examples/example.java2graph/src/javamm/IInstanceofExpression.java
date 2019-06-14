package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInstanceofExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setRightOperand(String v);public String getRightOperand();public void setLeftOperand(String v);public String getLeftOperand();}