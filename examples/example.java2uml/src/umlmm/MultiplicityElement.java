package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class MultiplicityElement  implements Serializable, IdentifiableElement, IMultiplicityElement, umlmm.IElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "MultiplicityElement"; }
public MultiplicityElement() { }public MultiplicityElement(String objId_){
setId(objId_);
;
}
}