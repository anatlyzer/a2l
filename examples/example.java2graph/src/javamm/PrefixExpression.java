package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class PrefixExpression  implements Serializable, IdentifiableElement, IPrefixExpression, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "PrefixExpression"; }
public PrefixExpression() { }public PrefixExpression(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, PrefixExpressionKind operator, String operand){
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
PrefixExpressionKind operator;public void setOperator(PrefixExpressionKind v) {
  this.operator = v;
}
public PrefixExpressionKind getOperator() {
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
String s = "PrefixExpression_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" operator="+operator;s+=" operand="+operand;return s;}}