package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class AbstractVariablesContainer  implements Serializable, IdentifiableElement, IAbstractVariablesContainer, javamm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AbstractVariablesContainer"; }
public AbstractVariablesContainer() { }public AbstractVariablesContainer(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String type, String[] fragments){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setType(type);
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
}