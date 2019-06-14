package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ParameterizedType  implements Serializable, IdentifiableElement, IParameterizedType, javamm.IType { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ParameterizedType"; }
public ParameterizedType() { }public ParameterizedType(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String[] usagesInTypeAccess, String type, String[] typeArguments){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setUsagesInTypeAccess(usagesInTypeAccess);
setType(type);
setTypeArguments(typeArguments);
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
@lintra.utils.Reference
String[] usagesInTypeAccess= new String[0];public void setUsagesInTypeAccess(String[] v) {
  this.usagesInTypeAccess = v;
}
public String[] getUsagesInTypeAccess() {
  return this.usagesInTypeAccess;
}
@lintra.utils.Reference
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
@lintra.utils.Reference
String[] typeArguments= new String[0];public void setTypeArguments(String[] v) {
  this.typeArguments = v;
}
public String[] getTypeArguments() {
  return this.typeArguments;
}
public String toString() {
String s = "ParameterizedType_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" usagesInTypeAccess="+ java.util.Arrays.toString(usagesInTypeAccess);s+=" type="+type;s+=" typeArguments="+ java.util.Arrays.toString(typeArguments);return s;}}