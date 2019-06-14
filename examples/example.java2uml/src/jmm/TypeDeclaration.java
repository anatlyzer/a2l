package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class TypeDeclaration  implements Serializable, IdentifiableElement, ITypeDeclaration, jmm.IAbstractTypeDeclaration { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "TypeDeclaration"; }
public TypeDeclaration() { }public TypeDeclaration(String objId_,boolean proxy, java.lang.String name, String modifier, String[] bodyDeclarations, String[] superInterfaces){
setId(objId_);
setProxy(proxy);
setName(name);
setModifier(modifier);
setBodyDeclarations(bodyDeclarations);
setSuperInterfaces(superInterfaces);
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
@lintra.utils.Reference
String[] bodyDeclarations= new String[0];public void setBodyDeclarations(String[] v) {
  this.bodyDeclarations = v;
}
public String[] getBodyDeclarations() {
  return this.bodyDeclarations;
}
@lintra.utils.Reference
String[] superInterfaces= new String[0];public void setSuperInterfaces(String[] v) {
  this.superInterfaces = v;
}
public String[] getSuperInterfaces() {
  return this.superInterfaces;
}
}