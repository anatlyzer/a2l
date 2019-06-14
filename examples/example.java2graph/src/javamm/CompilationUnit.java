package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class CompilationUnit  implements Serializable, IdentifiableElement, ICompilationUnit, javamm.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "CompilationUnit"; }
public CompilationUnit() { }public CompilationUnit(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, java.lang.String originalFilePath, String[] commentList, String[] imports, String package_, String[] types){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setOriginalFilePath(originalFilePath);
setCommentList(commentList);
setImports(imports);
setPackage(package_);
setTypes(types);
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
java.lang.String originalFilePath;public void setOriginalFilePath(java.lang.String v) {
  this.originalFilePath = v;
}
public java.lang.String getOriginalFilePath() {
  return this.originalFilePath;
}
@lintra.utils.Reference
String[] commentList= new String[0];public void setCommentList(String[] v) {
  this.commentList = v;
}
public String[] getCommentList() {
  return this.commentList;
}
@lintra.utils.Reference
String[] imports= new String[0];public void setImports(String[] v) {
  this.imports = v;
}
public String[] getImports() {
  return this.imports;
}
@lintra.utils.Reference
String package_;public void setPackage(String v) {
  this.package_ = v;
}
public String getPackage() {
  return this.package_;
}
@lintra.utils.Reference
String[] types= new String[0];public void setTypes(String[] v) {
  this.types = v;
}
public String[] getTypes() {
  return this.types;
}
public String toString() {
String s = "CompilationUnit_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" originalFilePath="+originalFilePath;s+=" commentList="+ java.util.Arrays.toString(commentList);s+=" imports="+ java.util.Arrays.toString(imports);s+=" package_="+package_;s+=" types="+ java.util.Arrays.toString(types);return s;}}