package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class ParameterableElement  implements Serializable, IdentifiableElement, IParameterableElement, umlmm.IElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ParameterableElement"; }
public ParameterableElement() { }public ParameterableElement(String objId_){
setId(objId_);
;
}
}