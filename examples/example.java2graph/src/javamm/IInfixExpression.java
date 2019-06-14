package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInfixExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOperator(InfixExpressionKind v);public InfixExpressionKind getOperator();public void setRightOperand(String v);public String getRightOperand();public void setLeftOperand(String v);public String getLeftOperand();public void setExtendedOperands(String[] v);public String[] getExtendedOperands();}