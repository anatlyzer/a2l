package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPostfixExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOperator(PostfixExpressionKind v);public PostfixExpressionKind getOperator();public void setOperand(String v);public String getOperand();}