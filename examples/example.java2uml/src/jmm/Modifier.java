package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Modifier  implements Serializable, IdentifiableElement, IModifier, jmm.IASTNode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Modifier"; }
public Modifier() { }public Modifier(String objId_,InheritanceKind inheritance){
setId(objId_);
setInheritance(inheritance);
}
InheritanceKind inheritance;public void setInheritance(InheritanceKind v) {
  this.inheritance = v;
}
public InheritanceKind getInheritance() {
  return this.inheritance;
}
public String toString() {
String s = "Modifier_"+this.id;s+=" inheritance="+inheritance;return s;}}