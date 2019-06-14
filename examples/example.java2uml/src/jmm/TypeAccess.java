package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class TypeAccess  implements Serializable, IdentifiableElement, ITypeAccess, jmm.IExpression, jmm.INamespaceAccess { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "TypeAccess"; }
public TypeAccess() { }public TypeAccess(String objId_,String type){
setId(objId_);
setType(type);
}
@lintra.utils.Reference
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
public String toString() {
String s = "TypeAccess_"+this.id;s+=" type="+type;return s;}}