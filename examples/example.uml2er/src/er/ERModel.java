package er;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ERModel  implements Serializable, IdentifiableElement, IERModel, er.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ERModel"; }
public ERModel() { }public ERModel(String objId_,java.lang.String name, String[] entities){
setId(objId_);
setName(name);
setEntities(entities);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] entities= new String[0];public void setEntities(String[] v) {
  this.entities = v;
}
public String[] getEntities() {
  return this.entities;
}
public String toString() {
String s = "ERModel_"+this.id;s+=" name="+name;s+=" entities="+ java.util.Arrays.toString(entities);return s;}}