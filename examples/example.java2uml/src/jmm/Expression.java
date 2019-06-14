package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class Expression  implements Serializable, IdentifiableElement, IExpression, jmm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Expression"; }
public Expression() { }public Expression(String objId_){
setId(objId_);
;
}
}