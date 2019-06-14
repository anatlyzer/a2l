package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISwitchCase extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setDefault(boolean v);public boolean getDefault();public void setExpression(String v);public String getExpression();}