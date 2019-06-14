package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ConstructorDeclaration  implements Serializable, IdentifiableElement, IConstructorDeclaration, jmm.IAbstractMethodDeclaration { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ConstructorDeclaration"; }
public ConstructorDeclaration() { }public ConstructorDeclaration(String objId_,boolean proxy, java.lang.String name, String modifier){
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
public String toString() {
String s = "ConstructorDeclaration_"+this.id;s+=" proxy="+proxy;s+=" name="+name;s+=" modifier="+modifier;return s;}}