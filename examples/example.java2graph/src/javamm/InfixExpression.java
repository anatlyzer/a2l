package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class InfixExpression  implements Serializable, IdentifiableElement, IInfixExpression, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "InfixExpression"; }
public InfixExpression() { }public InfixExpression(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, InfixExpressionKind operator, String rightOperand, String leftOperand, String[] extendedOperands){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setOperator(operator);
setRightOperand(rightOperand);
setLeftOperand(leftOperand);
setExtendedOperands(extendedOperands);
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
InfixExpressionKind operator;public void setOperator(InfixExpressionKind v) {
  this.operator = v;
}
public InfixExpressionKind getOperator() {
  return this.operator;
}
@lintra.utils.Reference
String rightOperand;public void setRightOperand(String v) {
  this.rightOperand = v;
}
public String getRightOperand() {
  return this.rightOperand;
}
@lintra.utils.Reference
String leftOperand;public void setLeftOperand(String v) {
  this.leftOperand = v;
}
public String getLeftOperand() {
  return this.leftOperand;
}
@lintra.utils.Reference
String[] extendedOperands= new String[0];public void setExtendedOperands(String[] v) {
  this.extendedOperands = v;
}
public String[] getExtendedOperands() {
  return this.extendedOperands;
}
public String toString() {
String s = "InfixExpression_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" operator="+operator;s+=" rightOperand="+rightOperand;s+=" leftOperand="+leftOperand;s+=" extendedOperands="+ java.util.Arrays.toString(extendedOperands);return s;}}