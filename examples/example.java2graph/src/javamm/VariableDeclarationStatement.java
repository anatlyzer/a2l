package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class VariableDeclarationStatement  implements Serializable, IdentifiableElement, IVariableDeclarationStatement, javamm.IStatement, javamm.IAbstractVariablesContainer { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "VariableDeclarationStatement"; }
public VariableDeclarationStatement() { }public VariableDeclarationStatement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String type, String[] fragments, int extraArrayDimensions, String modifier, String[] annotations){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setType(type);
setFragments(fragments);
setExtraArrayDimensions(extraArrayDimensions);
setModifier(modifier);
setAnnotations(annotations);
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
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
@lintra.utils.Reference
String[] fragments= new String[0];public void setFragments(String[] v) {
  this.fragments = v;
}
public String[] getFragments() {
  return this.fragments;
}
int extraArrayDimensions;public void setExtraArrayDimensions(int v) {
  this.extraArrayDimensions = v;
}
public int getExtraArrayDimensions() {
  return this.extraArrayDimensions;
}
@lintra.utils.Reference
String modifier;public void setModifier(String v) {
  this.modifier = v;
}
public String getModifier() {
  return this.modifier;
}
@lintra.utils.Reference
String[] annotations= new String[0];public void setAnnotations(String[] v) {
  this.annotations = v;
}
public String[] getAnnotations() {
  return this.annotations;
}
public String toString() {
String s = "VariableDeclarationStatement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" type="+type;s+=" fragments="+ java.util.Arrays.toString(fragments);s+=" extraArrayDimensions="+extraArrayDimensions;s+=" modifier="+modifier;s+=" annotations="+ java.util.Arrays.toString(annotations);return s;}}