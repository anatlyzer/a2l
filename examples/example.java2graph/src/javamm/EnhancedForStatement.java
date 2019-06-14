package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class EnhancedForStatement  implements Serializable, IdentifiableElement, IEnhancedForStatement, javamm.IStatement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "EnhancedForStatement"; }
public EnhancedForStatement() { }public EnhancedForStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String body, String expression, String parameter){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setBody(body);
setExpression(expression);
setParameter(parameter);
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
String expression;public void setExpression(String v) {
  this.expression = v;
}
public String getExpression() {
  return this.expression;
}
@lintra.utils.Reference
String parameter;public void setParameter(String v) {
  this.parameter = v;
}
public String getParameter() {
  return this.parameter;
}
public String toString() {
String s = "EnhancedForStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" body="+body;s+=" expression="+expression;s+=" parameter="+parameter;return s;}}