package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class UnresolvedItemAccess  implements Serializable, IdentifiableElement, IUnresolvedItemAccess, javamm.IExpression, javamm.INamespaceAccess { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "UnresolvedItemAccess"; }
public UnresolvedItemAccess() { }public UnresolvedItemAccess(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String element, String qualifier){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setElement(element);
setQualifier(qualifier);
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
String element;public void setElement(String v) {
  this.element = v;
}
public String getElement() {
  return this.element;
}
@lintra.utils.Reference
String qualifier;public void setQualifier(String v) {
  this.qualifier = v;
}
public String getQualifier() {
  return this.qualifier;
}
public String toString() {
String s = "UnresolvedItemAccess_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" element="+element;s+=" qualifier="+qualifier;return s;}}