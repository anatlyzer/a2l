package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IArchive extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOriginalFilePath(java.lang.String v);public java.lang.String getOriginalFilePath();public void setClassFiles(String[] v);public String[] getClassFiles();public void setManifest(String v);public String getManifest();}