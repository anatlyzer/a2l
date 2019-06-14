package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ManifestAttribute  implements Serializable, IdentifiableElement, IManifestAttribute { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ManifestAttribute"; }
public ManifestAttribute() { }public ManifestAttribute(String id_,java.lang.String key, java.lang.String value){
setId(id_);
setKey(key);
setValue(value);
}
java.lang.String key;public void setKey(java.lang.String v) {
  this.key = v;
}
public java.lang.String getKey() {
  return this.key;
}
java.lang.String value;public void setValue(java.lang.String v) {
  this.value = v;
}
public java.lang.String getValue() {
  return this.value;
}
public String toString() {
String s = "ManifestAttribute_"+this.id;s+=" key="+key;s+=" value="+value;return s;}}