package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Model  implements Serializable, IdentifiableElement, IModel, umlmm.IPackage { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Model"; }
public Model() { }public Model(String objId_,java.lang.String name, String[] packagedElement){
setId(objId_);
setName(name);
setPackagedElement(packagedElement);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] packagedElement= new String[0];public void setPackagedElement(String[] v) {
  this.packagedElement = v;
}
public String[] getPackagedElement() {
  return this.packagedElement;
}
public String toString() {
String s = "Model_"+this.id;s+=" name="+name;s+=" packagedElement="+ java.util.Arrays.toString(packagedElement);return s;}}