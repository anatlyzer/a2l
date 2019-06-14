package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAssignment extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setLeftHandSide(String v);public String getLeftHandSide();public void setOperator(AssignmentKind v);public AssignmentKind getOperator();public void setRightHandSide(String v);public String getRightHandSide();}