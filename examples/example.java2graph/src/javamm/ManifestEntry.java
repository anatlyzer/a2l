package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ManifestEntry  implements Serializable, IdentifiableElement, IManifestEntry { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ManifestEntry"; }
public ManifestEntry() { }public ManifestEntry(String id_,java.lang.String name, String[] attributes){
setId(id_);
setName(name);
setAttributes(attributes);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] attributes= new String[0];public void setAttributes(String[] v) {
  this.attributes = v;
}
public String[] getAttributes() {
  return this.attributes;
}
public String toString() {
String s = "ManifestEntry_"+this.id;s+=" name="+name;s+=" attributes="+ java.util.Arrays.toString(attributes);return s;}}