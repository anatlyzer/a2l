package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ImportDeclaration  implements Serializable, IdentifiableElement, IImportDeclaration, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ImportDeclaration"; }
public ImportDeclaration() { }public ImportDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, boolean static_, String importedElement){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setStatic(static_);
setImportedElement(importedElement);
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
boolean static_;public void setStatic(boolean v) {
  this.static_ = v;
}
public boolean getStatic() {
  return this.static_;
}
@lintra.utils.Reference
String importedElement;public void setImportedElement(String v) {
  this.importedElement = v;
}
public String getImportedElement() {
  return this.importedElement;
}
public String toString() {
String s = "ImportDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" static_="+static_;s+=" importedElement="+importedElement;return s;}}