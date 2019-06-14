package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class VariableDeclaration  implements Serializable, IdentifiableElement, IVariableDeclaration, javamm.INamedElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "VariableDeclaration"; }
public VariableDeclaration() { }public VariableDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, int extraArrayDimensions, String initializer, String[] usageInVariableAccess){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setExtraArrayDimensions(extraArrayDimensions);
setInitializer(initializer);
setUsageInVariableAccess(usageInVariableAccess);
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
int extraArrayDimensions;public void setExtraArrayDimensions(int v) {
  this.extraArrayDimensions = v;
}
public int getExtraArrayDimensions() {
  return this.extraArrayDimensions;
}
@lintra.utils.Reference
String initializer;public void setInitializer(String v) {
  this.initializer = v;
}
public String getInitializer() {
  return this.initializer;
}
@lintra.utils.Reference
String[] usageInVariableAccess= new String[0];public void setUsageInVariableAccess(String[] v) {
  this.usageInVariableAccess = v;
}
public String[] getUsageInVariableAccess() {
  return this.usageInVariableAccess;
}
}