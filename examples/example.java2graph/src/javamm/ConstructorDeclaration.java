package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ConstructorDeclaration  implements Serializable, IdentifiableElement, IConstructorDeclaration, javamm.IAbstractMethodDeclaration { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ConstructorDeclaration"; }
public ConstructorDeclaration() { }public ConstructorDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String abstractTypeDeclaration, String[] annotations, String anonymousClassDeclarationOwner, String modifier, String body, String[] parameters, String[] thrownExceptions, String[] typeParameters, String[] usagesInDocComments, String[] usages){
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
setBody(body);
setParameters(parameters);
setThrownExceptions(thrownExceptions);
setTypeParameters(typeParameters);
setUsagesInDocComments(usagesInDocComments);
setUsages(usages);
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
String body;public void setBody(String v) {
  this.body = v;
}
public String getBody() {
  return this.body;
}
@lintra.utils.Reference
String[] parameters= new String[0];public void setParameters(String[] v) {
  this.parameters = v;
}
public String[] getParameters() {
  return this.parameters;
}
@lintra.utils.Reference
String[] thrownExceptions= new String[0];public void setThrownExceptions(String[] v) {
  this.thrownExceptions = v;
}
public String[] getThrownExceptions() {
  return this.thrownExceptions;
}
@lintra.utils.Reference
String[] typeParameters= new String[0];public void setTypeParameters(String[] v) {
  this.typeParameters = v;
}
public String[] getTypeParameters() {
  return this.typeParameters;
}
@lintra.utils.Reference
String[] usagesInDocComments= new String[0];public void setUsagesInDocComments(String[] v) {
  this.usagesInDocComments = v;
}
public String[] getUsagesInDocComments() {
  return this.usagesInDocComments;
}
@lintra.utils.Reference
String[] usages= new String[0];public void setUsages(String[] v) {
  this.usages = v;
}
public String[] getUsages() {
  return this.usages;
}
public String toString() {
String s = "ConstructorDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" abstractTypeDeclaration="+abstractTypeDeclaration;s+=" annotations="+ java.util.Arrays.toString(annotations);s+=" anonymousClassDeclarationOwner="+anonymousClassDeclarationOwner;s+=" modifier="+modifier;s+=" body="+body;s+=" parameters="+ java.util.Arrays.toString(parameters);s+=" thrownExceptions="+ java.util.Arrays.toString(thrownExceptions);s+=" typeParameters="+ java.util.Arrays.toString(typeParameters);s+=" usagesInDocComments="+ java.util.Arrays.toString(usagesInDocComments);s+=" usages="+ java.util.Arrays.toString(usages);return s;}}