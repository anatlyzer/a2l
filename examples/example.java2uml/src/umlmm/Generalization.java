package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Generalization  implements Serializable, IdentifiableElement, IGeneralization, umlmm.IDirectedRelationship { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Generalization"; }
public Generalization() { }public Generalization(String objId_,String general){
setId(objId_);
setGeneral(general);
}
@lintra.utils.Reference
String general;public void setGeneral(String v) {
  this.general = v;
}
public String getGeneral() {
  return this.general;
}
public String toString() {
String s = "Generalization_"+this.id;s+=" general="+general;return s;}}