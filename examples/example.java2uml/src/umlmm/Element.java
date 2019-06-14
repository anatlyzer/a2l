package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class Element  implements Serializable, IdentifiableElement, IElement, umlmm.IEModelElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Element"; }
public Element() { }public Element(String objId_){
setId(objId_);
;
}
}