package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IType extends IdentifiableElement,jmm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}