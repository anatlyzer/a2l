package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class NamedElement  implements Serializable, IdentifiableElement, INamedElement, umlmm.IElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "NamedElement"; }
public NamedElement() { }public NamedElement(String objId_,java.lang.String name){
setId(objId_);
setName(name);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
}