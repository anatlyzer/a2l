package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IERModel extends IdentifiableElement,er.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setEntities(String[] v);public String[] getEntities();}