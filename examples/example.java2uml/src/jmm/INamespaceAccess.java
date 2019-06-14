package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface INamespaceAccess extends IdentifiableElement,jmm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
}