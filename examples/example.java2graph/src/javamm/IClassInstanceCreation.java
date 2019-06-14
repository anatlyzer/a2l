package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClassInstanceCreation extends IdentifiableElement,javamm.IExpression,javamm.IAbstractMethodInvocation { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setAnonymousClassDeclaration(String v);public String getAnonymousClassDeclaration();public void setExpression(String v);public String getExpression();public void setType(String v);public String getType();}