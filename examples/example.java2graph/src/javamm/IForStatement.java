package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IForStatement extends IdentifiableElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExpression(String v);public String getExpression();public void setUpdaters(String[] v);public String[] getUpdaters();public void setInitializers(String[] v);public String[] getInitializers();public void setBody(String v);public String getBody();}