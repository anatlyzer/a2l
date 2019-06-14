package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Assignment  implements Serializable, IdentifiableElement, IAssignment, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Assignment"; }
public Assignment() { }public Assignment(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String leftHandSide, AssignmentKind operator, String rightHandSide){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setLeftHandSide(leftHandSide);
setOperator(operator);
setRightHandSide(rightHandSide);
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
String leftHandSide;public void setLeftHandSide(String v) {
  this.leftHandSide = v;
}
public String getLeftHandSide() {
  return this.leftHandSide;
}
AssignmentKind operator;public void setOperator(AssignmentKind v) {
  this.operator = v;
}
public AssignmentKind getOperator() {
  return this.operator;
}
@lintra.utils.Reference
String rightHandSide;public void setRightHandSide(String v) {
  this.rightHandSide = v;
}
public String getRightHandSide() {
  return this.rightHandSide;
}
public String toString() {
String s = "Assignment_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" leftHandSide="+leftHandSide;s+=" operator="+operator;s+=" rightHandSide="+rightHandSide;return s;}}