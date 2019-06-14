package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class AnnotationTypeDeclaration  implements Serializable, IdentifiableElement, IAnnotationTypeDeclaration, jmm.IAbstractTypeDeclaration { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AnnotationTypeDeclaration"; }
public AnnotationTypeDeclaration() { }public AnnotationTypeDeclaration(String objId_,boolean proxy, java.lang.String name, String modifier, String[] bodyDeclarations, String[] superInterfaces){
setId(objId_);
setProxy(proxy);
setName(name);
setModifier(modifier);
setBodyDeclarations(bodyDeclarations);
setSuperInterfaces(superInterfaces);
}
boolean proxy;public void setProxy(boolean v) {
  this.proxy = v;
}
public boolean getProxy() {
  return this.proxy;
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String modifier;public void setModifier(String v) {
  this.modifier = v;
}
public String getModifier() {
  return this.modifier;
}
@lintra.utils.Reference
String[] bodyDeclarations= new String[0];public void setBodyDeclarations(String[] v) {
  this.bodyDeclarations = v;
}
public String[] getBodyDeclarations() {
  return this.bodyDeclarations;
}
@lintra.utils.Reference
String[] superInterfaces= new String[0];public void setSuperInterfaces(String[] v) {
  this.superInterfaces = v;
}
public String[] getSuperInterfaces() {
  return this.superInterfaces;
}
public String toString() {
String s = "AnnotationTypeDeclaration_"+this.id;s+=" proxy="+proxy;s+=" name="+name;s+=" modifier="+modifier;s+=" bodyDeclarations="+ java.util.Arrays.toString(bodyDeclarations);s+=" superInterfaces="+ java.util.Arrays.toString(superInterfaces);return s;}}