package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Manifest  implements Serializable, IdentifiableElement, IManifest { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Manifest"; }
public Manifest() { }public Manifest(String id_,String[] mainAttributes, String[] entryAttributes){
setId(id_);
setMainAttributes(mainAttributes);
setEntryAttributes(entryAttributes);
}
@lintra.utils.Reference
String[] mainAttributes= new String[0];public void setMainAttributes(String[] v) {
  this.mainAttributes = v;
}
public String[] getMainAttributes() {
  return this.mainAttributes;
}
@lintra.utils.Reference
String[] entryAttributes= new String[0];public void setEntryAttributes(String[] v) {
  this.entryAttributes = v;
}
public String[] getEntryAttributes() {
  return this.entryAttributes;
}
public String toString() {
String s = "Manifest_"+this.id;s+=" mainAttributes="+ java.util.Arrays.toString(mainAttributes);s+=" entryAttributes="+ java.util.Arrays.toString(entryAttributes);return s;}}