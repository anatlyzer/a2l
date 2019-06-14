package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ForStatement  implements Serializable, IdentifiableElement, IForStatement, javamm.IStatement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ForStatement"; }
public ForStatement() { }public ForStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String expression, String[] updaters, String[] initializers, String body){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setExpression(expression);
setUpdaters(updaters);
setInitializers(initializers);
setBody(body);
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
String expression;public void setExpression(String v) {
  this.expression = v;
}
public String getExpression() {
  return this.expression;
}
@lintra.utils.Reference
String[] updaters= new String[0];public void setUpdaters(String[] v) {
  this.updaters = v;
}
public String[] getUpdaters() {
  return this.updaters;
}
@lintra.utils.Reference
String[] initializers= new String[0];public void setInitializers(String[] v) {
  this.initializers = v;
}
public String[] getInitializers() {
  return this.initializers;
}
@lintra.utils.Reference
String body;public void setBody(String v) {
  this.body = v;
}
public String getBody() {
  return this.body;
}
public String toString() {
String s = "ForStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" expression="+expression;s+=" updaters="+ java.util.Arrays.toString(updaters);s+=" initializers="+ java.util.Arrays.toString(initializers);s+=" body="+body;return s;}}