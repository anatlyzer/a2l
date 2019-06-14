package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Database  implements Serializable, IdentifiableElement, IDatabase, relational.IModelElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Database"; }
public Database() { }public Database(String objId_,java.lang.String comment, java.lang.String name, java.lang.String url, String[] ownedSchemas){
setId(objId_);
setComment(comment);
setName(name);
setUrl(url);
setOwnedSchemas(ownedSchemas);
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
java.lang.String url;public void setUrl(java.lang.String v) {
  this.url = v;
}
public java.lang.String getUrl() {
  return this.url;
}
@lintra.utils.Reference
String[] ownedSchemas= new String[0];public void setOwnedSchemas(String[] v) {
  this.ownedSchemas = v;
}
public String[] getOwnedSchemas() {
  return this.ownedSchemas;
}
public String toString() {
String s = "Database_"+this.id;s+=" comment="+comment;s+=" name="+name;s+=" url="+url;s+=" ownedSchemas="+ java.util.Arrays.toString(ownedSchemas);return s;}}