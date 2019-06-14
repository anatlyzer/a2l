package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class EModelElement  implements Serializable, IdentifiableElement, IEModelElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "EModelElement"; }
public EModelElement() { }public EModelElement(String objId_){
setId(objId_);
;
}
}