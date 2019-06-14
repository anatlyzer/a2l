package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class AbstractMethodDeclaration  implements Serializable, IdentifiableElement, IAbstractMethodDeclaration, jmm.IBodyDeclaration { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AbstractMethodDeclaration"; }
public AbstractMethodDeclaration() { }public AbstractMethodDeclaration(String objId_,boolean proxy, java.lang.String name, String modifier){
setId(objId_);
setProxy(proxy);
setName(name);
setModifier(modifier);
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
@lintra.utils.Reference
String modifier;public void setModifier(String v) {
  this.modifier = v;
}
public String getModifier() {
  return this.modifier;
}
}