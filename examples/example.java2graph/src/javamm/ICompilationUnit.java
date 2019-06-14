package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ICompilationUnit extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOriginalFilePath(java.lang.String v);public java.lang.String getOriginalFilePath();public void setCommentList(String[] v);public String[] getCommentList();public void setImports(String[] v);public String[] getImports();public void setPackage(String v);public String getPackage();public void setTypes(String[] v);public String[] getTypes();}