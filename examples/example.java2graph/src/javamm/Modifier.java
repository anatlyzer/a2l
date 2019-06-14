package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Modifier  implements Serializable, IdentifiableElement, IModifier, javamm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Modifier"; }
public Modifier() { }public Modifier(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, VisibilityKind visibility, InheritanceKind inheritance, boolean static_, boolean transient_, boolean volatile_, boolean native_, boolean strictfp_, boolean synchronized_, String bodyDeclaration, String singleVariableDeclaration, String variableDeclarationStatement, String variableDeclarationExpression){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setVisibility(visibility);
setInheritance(inheritance);
setStatic(static_);
setTransient(transient_);
setVolatile(volatile_);
setNative(native_);
setStrictfp(strictfp_);
setSynchronized(synchronized_);
setBodyDeclaration(bodyDeclaration);
setSingleVariableDeclaration(singleVariableDeclaration);
setVariableDeclarationStatement(variableDeclarationStatement);
setVariableDeclarationExpression(variableDeclarationExpression);
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
VisibilityKind visibility;public void setVisibility(VisibilityKind v) {
  this.visibility = v;
}
public VisibilityKind getVisibility() {
  return this.visibility;
}
InheritanceKind inheritance;public void setInheritance(InheritanceKind v) {
  this.inheritance = v;
}
public InheritanceKind getInheritance() {
  return this.inheritance;
}
boolean static_;public void setStatic(boolean v) {
  this.static_ = v;
}
public boolean getStatic() {
  return this.static_;
}
boolean transient_;public void setTransient(boolean v) {
  this.transient_ = v;
}
public boolean getTransient() {
  return this.transient_;
}
boolean volatile_;public void setVolatile(boolean v) {
  this.volatile_ = v;
}
public boolean getVolatile() {
  return this.volatile_;
}
boolean native_;public void setNative(boolean v) {
  this.native_ = v;
}
public boolean getNative() {
  return this.native_;
}
boolean strictfp_;public void setStrictfp(boolean v) {
  this.strictfp_ = v;
}
public boolean getStrictfp() {
  return this.strictfp_;
}
boolean synchronized_;public void setSynchronized(boolean v) {
  this.synchronized_ = v;
}
public boolean getSynchronized() {
  return this.synchronized_;
}
@lintra.utils.Reference
String bodyDeclaration;public void setBodyDeclaration(String v) {
  this.bodyDeclaration = v;
}
public String getBodyDeclaration() {
  return this.bodyDeclaration;
}
@lintra.utils.Reference
String singleVariableDeclaration;public void setSingleVariableDeclaration(String v) {
  this.singleVariableDeclaration = v;
}
public String getSingleVariableDeclaration() {
  return this.singleVariableDeclaration;
}
@lintra.utils.Reference
String variableDeclarationStatement;public void setVariableDeclarationStatement(String v) {
  this.variableDeclarationStatement = v;
}
public String getVariableDeclarationStatement() {
  return this.variableDeclarationStatement;
}
@lintra.utils.Reference
String variableDeclarationExpression;public void setVariableDeclarationExpression(String v) {
  this.variableDeclarationExpression = v;
}
public String getVariableDeclarationExpression() {
  return this.variableDeclarationExpression;
}
public String toString() {
String s = "Modifier_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" visibility="+visibility;s+=" inheritance="+inheritance;s+=" static_="+static_;s+=" transient_="+transient_;s+=" volatile_="+volatile_;s+=" native_="+native_;s+=" strictfp_="+strictfp_;s+=" synchronized_="+synchronized_;s+=" bodyDeclaration="+bodyDeclaration;s+=" singleVariableDeclaration="+singleVariableDeclaration;s+=" variableDeclarationStatement="+variableDeclarationStatement;s+=" variableDeclarationExpression="+variableDeclarationExpression;return s;}}