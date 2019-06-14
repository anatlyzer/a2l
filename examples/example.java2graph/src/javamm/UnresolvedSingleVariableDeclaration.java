package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class UnresolvedSingleVariableDeclaration  implements Serializable, IdentifiableElement, IUnresolvedSingleVariableDeclaration, javamm.ISingleVariableDeclaration, javamm.IUnresolvedItem { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "UnresolvedSingleVariableDeclaration"; }
public UnresolvedSingleVariableDeclaration() { }public UnresolvedSingleVariableDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, int extraArrayDimensions, String initializer, String[] usageInVariableAccess, String modifier, boolean varargs, String type, String[] annotations, String methodDeclaration, String catchClause, String enhancedForStatement){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setExtraArrayDimensions(extraArrayDimensions);
setInitializer(initializer);
setUsageInVariableAccess(usageInVariableAccess);
setModifier(modifier);
setVarargs(varargs);
setType(type);
setAnnotations(annotations);
setMethodDeclaration(methodDeclaration);
setCatchClause(catchClause);
setEnhancedForStatement(enhancedForStatement);
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
boolean proxy;public void setProxy(boolean v) {
  this.proxy = v;
}
public boolean getProxy() {
  return this.proxy;
}
@lintra.utils.Reference
String[] usagesInImports= new String[0];public void setUsagesInImports(String[] v) {
  this.usagesInImports = v;
}
public String[] getUsagesInImports() {
  return this.usagesInImports;
}
int extraArrayDimensions;public void setExtraArrayDimensions(int v) {
  this.extraArrayDimensions = v;
}
public int getExtraArrayDimensions() {
  return this.extraArrayDimensions;
}
@lintra.utils.Reference
String initializer;public void setInitializer(String v) {
  this.initializer = v;
}
public String getInitializer() {
  return this.initializer;
}
@lintra.utils.Reference
String[] usageInVariableAccess= new String[0];public void setUsageInVariableAccess(String[] v) {
  this.usageInVariableAccess = v;
}
public String[] getUsageInVariableAccess() {
  return this.usageInVariableAccess;
}
@lintra.utils.Reference
String modifier;public void setModifier(String v) {
  this.modifier = v;
}
public String getModifier() {
  return this.modifier;
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
@lintra.utils.Reference
String[] annotations= new String[0];public void setAnnotations(String[] v) {
  this.annotations = v;
}
public String[] getAnnotations() {
  return this.annotations;
}
@lintra.utils.Reference
String methodDeclaration;public void setMethodDeclaration(String v) {
  this.methodDeclaration = v;
}
public String getMethodDeclaration() {
  return this.methodDeclaration;
}
@lintra.utils.Reference
String catchClause;public void setCatchClause(String v) {
  this.catchClause = v;
}
public String getCatchClause() {
  return this.catchClause;
}
@lintra.utils.Reference
String enhancedForStatement;public void setEnhancedForStatement(String v) {
  this.enhancedForStatement = v;
}
public String getEnhancedForStatement() {
  return this.enhancedForStatement;
}
public String toString() {
String s = "UnresolvedSingleVariableDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" extraArrayDimensions="+extraArrayDimensions;s+=" initializer="+initializer;s+=" usageInVariableAccess="+ java.util.Arrays.toString(usageInVariableAccess);s+=" modifier="+modifier;s+=" varargs="+varargs;s+=" type="+type;s+=" annotations="+ java.util.Arrays.toString(annotations);s+=" methodDeclaration="+methodDeclaration;s+=" catchClause="+catchClause;s+=" enhancedForStatement="+enhancedForStatement;return s;}}