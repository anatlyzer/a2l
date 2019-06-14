package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClassFile extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOriginalFilePath(java.lang.String v);public java.lang.String getOriginalFilePath();public void setType(String v);public String getType();public void setAttachedSource(String v);public String getAttachedSource();public void setPackage(String v);public String getPackage();}