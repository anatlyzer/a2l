package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IType extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setUsagesInTypeAccess(String[] v);public String[] getUsagesInTypeAccess();}