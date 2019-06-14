package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IMethodRefParameter extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setVarargs(boolean v);public boolean getVarargs();public void setType(String v);public String getType();}