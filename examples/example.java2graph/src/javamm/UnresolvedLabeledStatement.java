package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class UnresolvedLabeledStatement  implements Serializable, IdentifiableElement, IUnresolvedLabeledStatement, javamm.ILabeledStatement, javamm.IUnresolvedItem { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "UnresolvedLabeledStatement"; }
public UnresolvedLabeledStatement() { }public UnresolvedLabeledStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String body, String[] usagesInBreakStatements, String[] usagesInContinueStatements){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setBody(body);
setUsagesInBreakStatements(usagesInBreakStatements);
setUsagesInContinueStatements(usagesInContinueStatements);
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
@lintra.utils.Reference
String body;public void setBody(String v) {
  this.body = v;
}
public String getBody() {
  return this.body;
}
@lintra.utils.Reference
String[] usagesInBreakStatements= new String[0];public void setUsagesInBreakStatements(String[] v) {
  this.usagesInBreakStatements = v;
}
public String[] getUsagesInBreakStatements() {
  return this.usagesInBreakStatements;
}
@lintra.utils.Reference
String[] usagesInContinueStatements= new String[0];public void setUsagesInContinueStatements(String[] v) {
  this.usagesInContinueStatements = v;
}
public String[] getUsagesInContinueStatements() {
  return this.usagesInContinueStatements;
}
public String toString() {
String s = "UnresolvedLabeledStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" body="+body;s+=" usagesInBreakStatements="+ java.util.Arrays.toString(usagesInBreakStatements);s+=" usagesInContinueStatements="+ java.util.Arrays.toString(usagesInContinueStatements);return s;}}