package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IArrayInitializer extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExpressions(String[] v);public String[] getExpressions();}