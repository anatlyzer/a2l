package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class SuperFieldAccess  implements Serializable, IdentifiableElement, ISuperFieldAccess, javamm.IAbstractTypeQualifiedExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "SuperFieldAccess"; }
public SuperFieldAccess() { }public SuperFieldAccess(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String qualifier, String field){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setQualifier(qualifier);
setField(field);
}
@lintra.utils.Reference
String[] comments= new String[0];public void setComments(String[] v) {
  this.comments = v;
}
public String[] getComments() {
  return this.comments;
}
@lintra.utils.Reference
String originalCompilationUnit;public void setOriginalCompilationUnit(String v) {
  this.originalCompilationUnit = v;
}
public String getOriginalCompilationUnit() {
  return this.originalCompilationUnit;
}
@lintra.utils.Reference
String originalClassFile;public void setOriginalClassFile(String v) {
  this.originalClassFile = v;
}
public String getOriginalClassFile() {
  return this.originalClassFile;
}
@lintra.utils.Reference
String qualifier;public void setQualifier(String v) {
  this.qualifier = v;
}
public String getQualifier() {
  return this.qualifier;
}
@lintra.utils.Reference
String field;public void setField(String v) {
  this.field = v;
}
public String getField() {
  return this.field;
}
public String toString() {
String s = "SuperFieldAccess_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" qualifier="+qualifier;s+=" field="+field;return s;}}