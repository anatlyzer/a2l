package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractVariablesContainer extends IdentifiableElement,jmm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
}