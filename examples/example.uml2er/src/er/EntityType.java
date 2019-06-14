package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class EntityType  implements Serializable, IdentifiableElement, IEntityType, er.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "EntityType"; }
public EntityType() { }public EntityType(String objId_,java.lang.String name, String[] features){
setId(objId_);
setName(name);
setFeatures(features);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] features= new String[0];public void setFeatures(String[] v) {
  this.features = v;
}
public String[] getFeatures() {
  return this.features;
}
public String toString() {
String s = "EntityType_"+this.id;s+=" name="+name;s+=" features="+ java.util.Arrays.toString(features);return s;}}