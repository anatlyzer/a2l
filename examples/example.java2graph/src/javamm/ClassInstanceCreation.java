package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ClassInstanceCreation  implements Serializable, IdentifiableElement, IClassInstanceCreation, javamm.IExpression, javamm.IAbstractMethodInvocation { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ClassInstanceCreation"; }
public ClassInstanceCreation() { }public ClassInstanceCreation(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String method, String[] arguments, String[] typeArguments, String anonymousClassDeclaration, String expression, String type){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setMethod(method);
setArguments(arguments);
setTypeArguments(typeArguments);
setAnonymousClassDeclaration(anonymousClassDeclaration);
setExpression(expression);
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
@lintra.utils.Reference
String anonymousClassDeclaration;public void setAnonymousClassDeclaration(String v) {
  this.anonymousClassDeclaration = v;
}
public String getAnonymousClassDeclaration() {
  return this.anonymousClassDeclaration;
}
@lintra.utils.Reference
String expression;public void setExpression(String v) {
  this.expression = v;
}
public String getExpression() {
  return this.expression;
}
@lintra.utils.Reference
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
public String toString() {
String s = "ClassInstanceCreation_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" method="+method;s+=" arguments="+ java.util.Arrays.toString(arguments);s+=" typeArguments="+ java.util.Arrays.toString(typeArguments);s+=" anonymousClassDeclaration="+anonymousClassDeclaration;s+=" expression="+expression;s+=" type="+type;return s;}}