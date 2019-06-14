package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackage extends IdentifiableElement,umlmm.INamespace,umlmm.IPackageableElement,umlmm.ITemplateableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setPackagedElement(String[] v);public String[] getPackagedElement();}