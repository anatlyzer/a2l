package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClass extends IdentifiableElement,simpleuml.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedProperty(String[] v);public String[] getOwnedProperty();public void setSuperClasses(String[] v);public String[] getSuperClasses();}