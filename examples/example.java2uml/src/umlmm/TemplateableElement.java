package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class TemplateableElement  implements Serializable, IdentifiableElement, ITemplateableElement, umlmm.IElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "TemplateableElement"; }
public TemplateableElement() { }public TemplateableElement(String objId_){
setId(objId_);
;
}
}