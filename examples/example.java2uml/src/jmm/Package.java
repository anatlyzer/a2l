package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Package  implements Serializable, IdentifiableElement, IPackage, jmm.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Package"; }
public Package() { }public Package(String objId_,boolean proxy, java.lang.String name, String[] ownedPackages, String[] ownedElements){
setId(objId_);
setProxy(proxy);
setName(name);
setOwnedPackages(ownedPackages);
setOwnedElements(ownedElements);
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
String[] ownedPackages= new String[0];public void setOwnedPackages(String[] v) {
  this.ownedPackages = v;
}
public String[] getOwnedPackages() {
  return this.ownedPackages;
}
@lintra.utils.Reference
String[] ownedElements= new String[0];public void setOwnedElements(String[] v) {
  this.ownedElements = v;
}
public String[] getOwnedElements() {
  return this.ownedElements;
}
public String toString() {
String s = "Package_"+this.id;s+=" proxy="+proxy;s+=" name="+name;s+=" ownedPackages="+ java.util.Arrays.toString(ownedPackages);s+=" ownedElements="+ java.util.Arrays.toString(ownedElements);return s;}}