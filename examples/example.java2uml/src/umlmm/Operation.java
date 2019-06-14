package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Operation  implements Serializable, IdentifiableElement, IOperation, umlmm.IBehavioralFeature, umlmm.IParameterableElement, umlmm.ITemplateableElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Operation"; }
public Operation() { }public Operation(String objId_,java.lang.String name){
setId(objId_);
setName(name);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
public String toString() {
String s = "Operation_"+this.id;s+=" name="+name;return s;}}