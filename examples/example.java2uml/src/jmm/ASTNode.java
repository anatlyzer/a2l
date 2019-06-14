package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class ASTNode  implements Serializable, IdentifiableElement, IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ASTNode"; }
public ASTNode() { }public ASTNode(String objId_){
setId(objId_);
;
}
}