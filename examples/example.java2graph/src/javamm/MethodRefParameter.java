package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class MethodRefParameter  implements Serializable, IdentifiableElement, IMethodRefParameter, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "MethodRefParameter"; }
public MethodRefParameter() { }public MethodRefParameter(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean varargs, String type){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setVarargs(varargs);
setType(type);
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
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
boolean varargs;public void setVarargs(boolean v) {
  this.varargs = v;
}
public boolean getVarargs() {
  return this.varargs;
}
@lintra.utils.Reference
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
public String toString() {
String s = "MethodRefParameter_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" varargs="+varargs;s+=" type="+type;return s;}}