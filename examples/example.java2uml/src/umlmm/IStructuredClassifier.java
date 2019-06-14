package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IStructuredClassifier extends IdentifiableElement,umlmm.IClassifier { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedAttribute(String[] v);public String[] getOwnedAttribute();}