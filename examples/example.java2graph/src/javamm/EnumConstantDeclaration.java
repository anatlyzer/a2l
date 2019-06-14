package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class EnumConstantDeclaration  implements Serializable, IdentifiableElement, IEnumConstantDeclaration, javamm.IBodyDeclaration, javamm.IVariableDeclaration { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "EnumConstantDeclaration"; }
public EnumConstantDeclaration() { }public EnumConstantDeclaration(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, java.lang.String name, boolean proxy, String[] usagesInImports, String abstractTypeDeclaration, String[] annotations, String anonymousClassDeclarationOwner, String modifier, int extraArrayDimensions, String initializer, String[] usageInVariableAccess, String anonymousClassDeclaration, String[] arguments){
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
setExtraArrayDimensions(extraArrayDimensions);
setInitializer(initializer);
setUsageInVariableAccess(usageInVariableAccess);
setAnonymousClassDeclaration(anonymousClassDeclaration);
setArguments(arguments);
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
@lintra.utils.Reference
String anonymousClassDeclaration;public void setAnonymousClassDeclaration(String v) {
  this.anonymousClassDeclaration = v;
}
public String getAnonymousClassDeclaration() {
  return this.anonymousClassDeclaration;
}
@lintra.utils.Reference
String[] arguments= new String[0];public void setArguments(String[] v) {
  this.arguments = v;
}
public String[] getArguments() {
  return this.arguments;
}
public String toString() {
String s = "EnumConstantDeclaration_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" name="+name;s+=" proxy="+proxy;s+=" usagesInImports="+ java.util.Arrays.toString(usagesInImports);s+=" abstractTypeDeclaration="+abstractTypeDeclaration;s+=" annotations="+ java.util.Arrays.toString(annotations);s+=" anonymousClassDeclarationOwner="+anonymousClassDeclarationOwner;s+=" modifier="+modifier;s+=" extraArrayDimensions="+extraArrayDimensions;s+=" initializer="+initializer;s+=" usageInVariableAccess="+ java.util.Arrays.toString(usageInVariableAccess);s+=" anonymousClassDeclaration="+anonymousClassDeclaration;s+=" arguments="+ java.util.Arrays.toString(arguments);return s;}}