package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IPackage extends IdentifiableElement,simpleuml.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedElements(String[] v);public String[] getOwnedElements();}