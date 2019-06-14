package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISingleVariableAccess extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setVariable(String v);public String getVariable();public void setQualifier(String v);public String getQualifier();}