package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class NamespaceAccess  implements Serializable, IdentifiableElement, INamespaceAccess, jmm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "NamespaceAccess"; }
public NamespaceAccess() { }public NamespaceAccess(String objId_){
setId(objId_);
;
}
}