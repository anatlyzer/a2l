package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackage extends IdentifiableElement,jmm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedPackages(String[] v);public String[] getOwnedPackages();public void setOwnedElements(String[] v);public String[] getOwnedElements();}