package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class Comment  implements Serializable, IdentifiableElement, IComment, javamm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Comment"; }
public Comment() { }public Comment(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String content, boolean enclosedByParent, boolean prefixOfParent){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setContent(content);
setEnclosedByParent(enclosedByParent);
setPrefixOfParent(prefixOfParent);
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
}