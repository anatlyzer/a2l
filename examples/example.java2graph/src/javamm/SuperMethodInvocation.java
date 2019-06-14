package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class SuperMethodInvocation  implements Serializable, IdentifiableElement, ISuperMethodInvocation, javamm.IAbstractTypeQualifiedExpression, javamm.IAbstractMethodInvocation { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "SuperMethodInvocation"; }
public SuperMethodInvocation() { }public SuperMethodInvocation(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String qualifier, String method, String[] arguments, String[] typeArguments){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setQualifier(qualifier);
setMethod(method);
setArguments(arguments);
setTypeArguments(typeArguments);
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
String qualifier;public void setQualifier(String v) {
  this.qualifier = v;
}
public String getQualifier() {
  return this.qualifier;
}
@lintra.utils.Reference
String method;public void setMethod(String v) {
  this.method = v;
}
public String getMethod() {
  return this.method;
}
@lintra.utils.Reference
String[] arguments= new String[0];public void setArguments(String[] v) {
  this.arguments = v;
}
public String[] getArguments() {
  return this.arguments;
}
@lintra.utils.Reference
String[] typeArguments= new String[0];public void setTypeArguments(String[] v) {
  this.typeArguments = v;
}
public String[] getTypeArguments() {
  return this.typeArguments;
}
public String toString() {
String s = "SuperMethodInvocation_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" qualifier="+qualifier;s+=" method="+method;s+=" arguments="+ java.util.Arrays.toString(arguments);s+=" typeArguments="+ java.util.Arrays.toString(typeArguments);return s;}}