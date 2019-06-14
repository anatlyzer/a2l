package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Schema  implements Serializable, IdentifiableElement, ISchema, relational.IModelElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Schema"; }
public Schema() { }public Schema(String objId_,java.lang.String comment, java.lang.String name, String[] ownedTables, String owner){
setId(objId_);
setComment(comment);
setName(name);
setOwnedTables(ownedTables);
setOwner(owner);
}
java.lang.String comment;public void setComment(java.lang.String v) {
  this.comment = v;
}
public java.lang.String getComment() {
  return this.comment;
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] ownedTables= new String[0];public void setOwnedTables(String[] v) {
  this.ownedTables = v;
}
public String[] getOwnedTables() {
  return this.ownedTables;
}
@lintra.utils.Reference
String owner;public void setOwner(String v) {
  this.owner = v;
}
public String getOwner() {
  return this.owner;
}
public String toString() {
String s = "Schema_"+this.id;s+=" comment="+comment;s+=" name="+name;s+=" ownedTables="+ java.util.Arrays.toString(ownedTables);s+=" owner="+owner;return s;}}