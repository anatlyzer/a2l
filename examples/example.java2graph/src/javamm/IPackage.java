package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackage extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedElements(String[] v);public String[] getOwnedElements();public void setModel(String v);public String getModel();public void setOwnedPackages(String[] v);public String[] getOwnedPackages();public void setPackage(String v);public String getPackage();public void setUsagesInPackageAccess(String[] v);public String[] getUsagesInPackageAccess();}