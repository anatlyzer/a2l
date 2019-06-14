package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface INamedElement extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setProxy(boolean v);public boolean getProxy();public void setUsagesInImports(String[] v);public String[] getUsagesInImports();}