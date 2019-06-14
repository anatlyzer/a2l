package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class AbstractVariablesContainer  implements Serializable, IdentifiableElement, IAbstractVariablesContainer, jmm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AbstractVariablesContainer"; }
public AbstractVariablesContainer() { }public AbstractVariablesContainer(String objId_){
setId(objId_);
;
}
}