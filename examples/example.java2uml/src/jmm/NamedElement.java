package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class NamedElement  implements Serializable, IdentifiableElement, INamedElement, jmm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "NamedElement"; }
public NamedElement() { }public NamedElement(String objId_,boolean proxy, java.lang.String name){
setId(objId_);
setProxy(proxy);
setName(name);
}
boolean proxy;public void setProxy(boolean v) {
  this.proxy = v;
}
public boolean getProxy() {
  return this.proxy;
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
}