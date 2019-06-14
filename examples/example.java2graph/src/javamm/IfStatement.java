package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class IfStatement  implements Serializable, IdentifiableElement, IIfStatement, javamm.IStatement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "IfStatement"; }
public IfStatement() { }public IfStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String expression, String thenStatement, String elseStatement){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setExpression(expression);
setThenStatement(thenStatement);
setElseStatement(elseStatement);
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
String thenStatement;public void setThenStatement(String v) {
  this.thenStatement = v;
}
public String getThenStatement() {
  return this.thenStatement;
}
@lintra.utils.Reference
String elseStatement;public void setElseStatement(String v) {
  this.elseStatement = v;
}
public String getElseStatement() {
  return this.elseStatement;
}
public String toString() {
String s = "IfStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" expression="+expression;s+=" thenStatement="+thenStatement;s+=" elseStatement="+elseStatement;return s;}}