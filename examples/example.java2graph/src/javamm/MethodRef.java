package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class MethodRef  implements Serializable, IdentifiableElement, IMethodRef, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "MethodRef"; }
public MethodRef() { }public MethodRef(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String method, String qualifier, String[] parameters){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setMethod(method);
setQualifier(qualifier);
setParameters(parameters);
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
String method;public void setMethod(String v) {
  this.method = v;
}
public String getMethod() {
  return this.method;
}
@lintra.utils.Reference
String qualifier;public void setQualifier(String v) {
  this.qualifier = v;
}
public String getQualifier() {
  return this.qualifier;
}
@lintra.utils.Reference
String[] parameters= new String[0];public void setParameters(String[] v) {
  this.parameters = v;
}
public String[] getParameters() {
  return this.parameters;
}
public String toString() {
String s = "MethodRef_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" method="+method;s+=" qualifier="+qualifier;s+=" parameters="+ java.util.Arrays.toString(parameters);return s;}}