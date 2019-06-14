package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IProperty extends IdentifiableElement,simpleuml.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setPrimitiveType(java.lang.String v);public java.lang.String getPrimitiveType();public void setComplexType(String v);public String getComplexType();public void setIsContainment(boolean v);public boolean getIsContainment();}