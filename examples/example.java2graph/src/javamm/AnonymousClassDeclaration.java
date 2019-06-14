package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class AnonymousClassDeclaration  implements Serializable, IdentifiableElement, IAnonymousClassDeclaration, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AnonymousClassDeclaration"; }
public AnonymousClassDeclaration() { }public AnonymousClassDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String[] bodyDeclarations, String classInstanceCreation){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setBodyDeclarations(bodyDeclarations);
setClassInstanceCreation(classInstanceCreation);
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
String[] bodyDeclarations= new String[0];public void setBodyDeclarations(String[] v) {
  this.bodyDeclarations = v;
}
public String[] getBodyDeclarations() {
  return this.bodyDeclarations;
}
@lintra.utils.Reference
String classInstanceCreation;public void setClassInstanceCreation(String v) {
  this.classInstanceCreation = v;
}
public String getClassInstanceCreation() {
  return this.classInstanceCreation;
}
public String toString() {
String s = "AnonymousClassDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" bodyDeclarations="+ java.util.Arrays.toString(bodyDeclarations);s+=" classInstanceCreation="+classInstanceCreation;return s;}}