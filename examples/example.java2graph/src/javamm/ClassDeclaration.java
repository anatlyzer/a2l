package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ClassDeclaration  implements Serializable, IdentifiableElement, IClassDeclaration, javamm.ITypeDeclaration { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ClassDeclaration"; }
public ClassDeclaration() { }public ClassDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String abstractTypeDeclaration, String[] annotations, String anonymousClassDeclarationOwner, String modifier, String[] usagesInTypeAccess, String[] bodyDeclarations, String[] commentsBeforeBody, String[] commentsAfterBody, String package_, String[] superInterfaces, String[] typeParameters, String superClass){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setName(name);
setProxy(proxy);
setUsagesInImports(usagesInImports);
setAbstractTypeDeclaration(abstractTypeDeclaration);
setAnnotations(annotations);
setAnonymousClassDeclarationOwner(anonymousClassDeclarationOwner);
setModifier(modifier);
setUsagesInTypeAccess(usagesInTypeAccess);
setBodyDeclarations(bodyDeclarations);
setCommentsBeforeBody(commentsBeforeBody);
setCommentsAfterBody(commentsAfterBody);
setPackage(package_);
setSuperInterfaces(superInterfaces);
setTypeParameters(typeParameters);
setSuperClass(superClass);
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
String abstractTypeDeclaration;public void setAbstractTypeDeclaration(String v) {
  this.abstractTypeDeclaration = v;
}
public String getAbstractTypeDeclaration() {
  return this.abstractTypeDeclaration;
}
@lintra.utils.Reference
String[] annotations= new String[0];public void setAnnotations(String[] v) {
  this.annotations = v;
}
public String[] getAnnotations() {
  return this.annotations;
}
@lintra.utils.Reference
String anonymousClassDeclarationOwner;public void setAnonymousClassDeclarationOwner(String v) {
  this.anonymousClassDeclarationOwner = v;
}
public String getAnonymousClassDeclarationOwner() {
  return this.anonymousClassDeclarationOwner;
}
@lintra.utils.Reference
String modifier;public void setModifier(String v) {
  this.modifier = v;
}
public String getModifier() {
  return this.modifier;
}
@lintra.utils.Reference
String[] usagesInTypeAccess= new String[0];public void setUsagesInTypeAccess(String[] v) {
  this.usagesInTypeAccess = v;
}
public String[] getUsagesInTypeAccess() {
  return this.usagesInTypeAccess;
}
@lintra.utils.Reference
String[] bodyDeclarations= new String[0];public void setBodyDeclarations(String[] v) {
  this.bodyDeclarations = v;
}
public String[] getBodyDeclarations() {
  return this.bodyDeclarations;
}
@lintra.utils.Reference
String[] commentsBeforeBody= new String[0];public void setCommentsBeforeBody(String[] v) {
  this.commentsBeforeBody = v;
}
public String[] getCommentsBeforeBody() {
  return this.commentsBeforeBody;
}
@lintra.utils.Reference
String[] commentsAfterBody= new String[0];public void setCommentsAfterBody(String[] v) {
  this.commentsAfterBody = v;
}
public String[] getCommentsAfterBody() {
  return this.commentsAfterBody;
}
@lintra.utils.Reference
String package_;public void setPackage(String v) {
  this.package_ = v;
}
public String getPackage() {
  return this.package_;
}
@lintra.utils.Reference
String[] superInterfaces= new String[0];public void setSuperInterfaces(String[] v) {
  this.superInterfaces = v;
}
public String[] getSuperInterfaces() {
  return this.superInterfaces;
}
@lintra.utils.Reference
String[] typeParameters= new String[0];public void setTypeParameters(String[] v) {
  this.typeParameters = v;
}
public String[] getTypeParameters() {
  return this.typeParameters;
}
@lintra.utils.Reference
String superClass;public void setSuperClass(String v) {
  this.superClass = v;
}
public String getSuperClass() {
  return this.superClass;
}
public String toString() {
String s = "ClassDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" abstractTypeDeclaration="+abstractTypeDeclaration;s+=" annotations="+ java.util.Arrays.toString(annotations);s+=" anonymousClassDeclarationOwner="+anonymousClassDeclarationOwner;s+=" modifier="+modifier;s+=" usagesInTypeAccess="+ java.util.Arrays.toString(usagesInTypeAccess);s+=" bodyDeclarations="+ java.util.Arrays.toString(bodyDeclarations);s+=" commentsBeforeBody="+ java.util.Arrays.toString(commentsBeforeBody);s+=" commentsAfterBody="+ java.util.Arrays.toString(commentsAfterBody);s+=" package_="+package_;s+=" superInterfaces="+ java.util.Arrays.toString(superInterfaces);s+=" typeParameters="+ java.util.Arrays.toString(typeParameters);s+=" superClass="+superClass;return s;}}