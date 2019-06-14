package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Attribute  implements Serializable, IdentifiableElement, IAttribute, er.IFeature { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Attribute"; }
public Attribute() { }public Attribute(String objId_,java.lang.String name, java.lang.String type){
setId(objId_);
setName(name);
setType(type);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
java.lang.String type;public void setType(java.lang.String v) {
  this.type = v;
}
public java.lang.String getType() {
  return this.type;
}
public String toString() {
String s = "Attribute_"+this.id;s+=" name="+name;s+=" type="+type;return s;}}