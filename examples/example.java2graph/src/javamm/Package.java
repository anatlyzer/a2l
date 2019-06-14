package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Package  implements Serializable, IdentifiableElement, IPackage, javamm.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Package"; }
public Package() { }public Package(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String[] ownedElements, String model, String[] ownedPackages, String package_, String[] usagesInPackageAccess){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setOwnedElements(ownedElements);
setModel(model);
setOwnedPackages(ownedPackages);
setPackage(package_);
setUsagesInPackageAccess(usagesInPackageAccess);
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
String[] ownedElements= new String[0];public void setOwnedElements(String[] v) {
  this.ownedElements = v;
}
public String[] getOwnedElements() {
  return this.ownedElements;
}
@lintra.utils.Reference
String model;public void setModel(String v) {
  this.model = v;
}
public String getModel() {
  return this.model;
}
@lintra.utils.Reference
String[] ownedPackages= new String[0];public void setOwnedPackages(String[] v) {
  this.ownedPackages = v;
}
public String[] getOwnedPackages() {
  return this.ownedPackages;
}
@lintra.utils.Reference
String package_;public void setPackage(String v) {
  this.package_ = v;
}
public String getPackage() {
  return this.package_;
}
@lintra.utils.Reference
String[] usagesInPackageAccess= new String[0];public void setUsagesInPackageAccess(String[] v) {
  this.usagesInPackageAccess = v;
}
public String[] getUsagesInPackageAccess() {
  return this.usagesInPackageAccess;
}
public String toString() {
String s = "Package_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" ownedElements="+ java.util.Arrays.toString(ownedElements);s+=" model="+model;s+=" ownedPackages="+ java.util.Arrays.toString(ownedPackages);s+=" package_="+package_;s+=" usagesInPackageAccess="+ java.util.Arrays.toString(usagesInPackageAccess);return s;}}