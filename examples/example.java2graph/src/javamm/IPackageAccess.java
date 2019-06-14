package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackageAccess extends IdentifiableElement,javamm.INamespaceAccess { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setPackage(String v);public String getPackage();public void setQualifier(String v);public String getQualifier();}