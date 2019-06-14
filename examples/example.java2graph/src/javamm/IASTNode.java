package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IASTNode extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setComments(String[] v);public String[] getComments();public void setOriginalCompilationUnit(String v);public String getOriginalCompilationUnit();public void setOriginalClassFile(String v);public String getOriginalClassFile();}