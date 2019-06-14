package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Model  implements Serializable, IdentifiableElement, IModel { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Model"; }
public Model() { }public Model(String objId_,String[] ownedElements, java.lang.String name){
setId(objId_);
setOwnedElements(ownedElements);
setName(name);
}
@lintra.utils.Reference
String[] ownedElements= new String[0];public void setOwnedElements(String[] v) {
  this.ownedElements = v;
}
public String[] getOwnedElements() {
  return this.ownedElements;
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
public String toString() {
String s = "Model_"+this.id;s+=" ownedElements="+ java.util.Arrays.toString(ownedElements);s+=" name="+name;return s;}}