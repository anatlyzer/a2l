package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEntityType extends IdentifiableElement,er.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setFeatures(String[] v);public String[] getFeatures();}