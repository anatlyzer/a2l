package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ForeignKey  implements Serializable, IdentifiableElement, IForeignKey, relational.IModelElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ForeignKey"; }
public ForeignKey() { }public ForeignKey(String objId_,java.lang.String comment, java.lang.String name, String foreignTable, String sourceTable){
setId(objId_);
setComment(comment);
setName(name);
setForeignTable(foreignTable);
setSourceTable(sourceTable);
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
String foreignTable;public void setForeignTable(String v) {
  this.foreignTable = v;
}
public String getForeignTable() {
  return this.foreignTable;
}
@lintra.utils.Reference
String sourceTable;public void setSourceTable(String v) {
  this.sourceTable = v;
}
public String getSourceTable() {
  return this.sourceTable;
}
public String toString() {
String s = "ForeignKey_"+this.id;s+=" comment="+comment;s+=" name="+name;s+=" foreignTable="+foreignTable;s+=" sourceTable="+sourceTable;return s;}}