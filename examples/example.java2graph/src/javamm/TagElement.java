package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class TagElement  implements Serializable, IdentifiableElement, ITagElement, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "TagElement"; }
public TagElement() { }public TagElement(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String tagName, String[] fragments){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setTagName(tagName);
setFragments(fragments);
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
java.lang.String tagName;public void setTagName(java.lang.String v) {
  this.tagName = v;
}
public java.lang.String getTagName() {
  return this.tagName;
}
@lintra.utils.Reference
String[] fragments= new String[0];public void setFragments(String[] v) {
  this.fragments = v;
}
public String[] getFragments() {
  return this.fragments;
}
public String toString() {
String s = "TagElement_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" tagName="+tagName;s+=" fragments="+ java.util.Arrays.toString(fragments);return s;}}