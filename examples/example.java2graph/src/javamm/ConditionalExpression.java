package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ConditionalExpression  implements Serializable, IdentifiableElement, IConditionalExpression, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ConditionalExpression"; }
public ConditionalExpression() { }public ConditionalExpression(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String elseExpression, String expression, String thenExpression){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setElseExpression(elseExpression);
setExpression(expression);
setThenExpression(thenExpression);
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
String elseExpression;public void setElseExpression(String v) {
  this.elseExpression = v;
}
public String getElseExpression() {
  return this.elseExpression;
}
@lintra.utils.Reference
String expression;public void setExpression(String v) {
  this.expression = v;
}
public String getExpression() {
  return this.expression;
}
@lintra.utils.Reference
String thenExpression;public void setThenExpression(String v) {
  this.thenExpression = v;
}
public String getThenExpression() {
  return this.thenExpression;
}
public String toString() {
String s = "ConditionalExpression_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" elseExpression="+elseExpression;s+=" expression="+expression;s+=" thenExpression="+thenExpression;return s;}}