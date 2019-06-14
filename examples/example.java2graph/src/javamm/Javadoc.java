package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Javadoc  implements Serializable, IdentifiableElement, IJavadoc, javamm.IComment { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Javadoc"; }
public Javadoc() { }public Javadoc(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String content, boolean enclosedByParent, boolean prefixOfParent, String[] tags){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setContent(content);
setEnclosedByParent(enclosedByParent);
setPrefixOfParent(prefixOfParent);
setTags(tags);
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
java.lang.String content;public void setContent(java.lang.String v) {
  this.content = v;
}
public java.lang.String getContent() {
  return this.content;
}
boolean enclosedByParent;public void setEnclosedByParent(boolean v) {
  this.enclosedByParent = v;
}
public boolean getEnclosedByParent() {
  return this.enclosedByParent;
}
boolean prefixOfParent;public void setPrefixOfParent(boolean v) {
  this.prefixOfParent = v;
}
public boolean getPrefixOfParent() {
  return this.prefixOfParent;
}
@lintra.utils.Reference
String[] tags= new String[0];public void setTags(String[] v) {
  this.tags = v;
}
public String[] getTags() {
  return this.tags;
}
public String toString() {
String s = "Javadoc_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" content="+content;s+=" enclosedByParent="+enclosedByParent;s+=" prefixOfParent="+prefixOfParent;s+=" tags="+ java.util.Arrays.toString(tags);return s;}}