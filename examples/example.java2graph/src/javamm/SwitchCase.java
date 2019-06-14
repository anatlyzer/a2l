package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class SwitchCase  implements Serializable, IdentifiableElement, ISwitchCase, javamm.IStatement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "SwitchCase"; }
public SwitchCase() { }public SwitchCase(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, boolean default_, String expression){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setDefault(default_);
setExpression(expression);
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
boolean default_;public void setDefault(boolean v) {
  this.default_ = v;
}
public boolean getDefault() {
  return this.default_;
}
@lintra.utils.Reference
String expression;public void setExpression(String v) {
  this.expression = v;
}
public String getExpression() {
  return this.expression;
}
public String toString() {
String s = "SwitchCase_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" default_="+default_;s+=" expression="+expression;return s;}}