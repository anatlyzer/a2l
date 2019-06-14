package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModel extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setOwnedElements(String[] v);public String[] getOwnedElements();public void setOrphanTypes(String[] v);public String[] getOrphanTypes();public void setUnresolvedItems(String[] v);public String[] getUnresolvedItems();public void setCompilationUnits(String[] v);public String[] getCompilationUnits();public void setClassFiles(String[] v);public String[] getClassFiles();public void setArchives(String[] v);public String[] getArchives();}