package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class TryStatement  implements Serializable, IdentifiableElement, ITryStatement, javamm.IStatement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "TryStatement"; }
public TryStatement() { }public TryStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String body, String finally_, String[] catchClauses){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setBody(body);
setFinally(finally_);
setCatchClauses(catchClauses);
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
String body;public void setBody(String v) {
  this.body = v;
}
public String getBody() {
  return this.body;
}
@lintra.utils.Reference
String finally_;public void setFinally(String v) {
  this.finally_ = v;
}
public String getFinally() {
  return this.finally_;
}
@lintra.utils.Reference
String[] catchClauses= new String[0];public void setCatchClauses(String[] v) {
  this.catchClauses = v;
}
public String[] getCatchClauses() {
  return this.catchClauses;
}
public String toString() {
String s = "TryStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" body="+body;s+=" finally_="+finally_;s+=" catchClauses="+ java.util.Arrays.toString(catchClauses);return s;}}