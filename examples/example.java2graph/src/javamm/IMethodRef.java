package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IMethodRef extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setMethod(String v);public String getMethod();public void setQualifier(String v);public String getQualifier();public void setParameters(String[] v);public String[] getParameters();}