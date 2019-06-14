package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPrefixExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOperator(PrefixExpressionKind v);public PrefixExpressionKind getOperator();public void setOperand(String v);public String getOperand();}