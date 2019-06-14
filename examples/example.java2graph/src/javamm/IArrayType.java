package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IArrayType extends IdentifiableElement,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setDimensions(int v);public int getDimensions();public void setElementType(String v);public String getElementType();}