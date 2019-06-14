package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class InstanceofExpression  implements Serializable, IdentifiableElement, IInstanceofExpression, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "InstanceofExpression"; }
public InstanceofExpression() { }public InstanceofExpression(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String rightOperand, String leftOperand){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setRightOperand(rightOperand);
setLeftOperand(leftOperand);
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
public String toString() {
String s = "InstanceofExpression_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" rightOperand="+rightOperand;s+=" leftOperand="+leftOperand;return s;}}