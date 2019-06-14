package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractTypeQualifiedExpression extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setQualifier(String v);public String getQualifier();}