package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IImportDeclaration extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setStatic(boolean v);public boolean getStatic();public void setImportedElement(String v);public String getImportedElement();}