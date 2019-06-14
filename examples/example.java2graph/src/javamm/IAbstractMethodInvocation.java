package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractMethodInvocation extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setMethod(String v);public String getMethod();public void setArguments(String[] v);public String[] getArguments();public void setTypeArguments(String[] v);public String[] getTypeArguments();}