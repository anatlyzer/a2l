package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class PostfixExpression  implements Serializable, IdentifiableElement, IPostfixExpression, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "PostfixExpression"; }
public PostfixExpression() { }public PostfixExpression(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, PostfixExpressionKind operator, String operand){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setOperator(operator);
setOperand(operand);
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
PostfixExpressionKind operator;public void setOperator(PostfixExpressionKind v) {
  this.operator = v;
}
public PostfixExpressionKind getOperator() {
  return this.operator;
}
@lintra.utils.Reference
String operand;public void setOperand(String v) {
  this.operand = v;
}
public String getOperand() {
  return this.operand;
}
public String toString() {
String s = "PostfixExpression_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" operator="+operator;s+=" operand="+operand;return s;}}