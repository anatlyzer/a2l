package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class BooleanLiteral  implements Serializable, IdentifiableElement, IBooleanLiteral, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "BooleanLiteral"; }
public BooleanLiteral() { }public BooleanLiteral(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, boolean value){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setValue(value);
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
boolean value;public void setValue(boolean v) {
  this.value = v;
}
public boolean getValue() {
  return this.value;
}
public String toString() {
String s = "BooleanLiteral_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" value="+value;return s;}}