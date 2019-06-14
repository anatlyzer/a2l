package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Class  implements Serializable, IdentifiableElement, IClass, umlmm.IEncapsulatedClassifier, umlmm.IBehavioredClassifier { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Class"; }
public Class() { }public Class(String objId_,java.lang.String name, String[] generalization, boolean isAbstract, String[] ownedAttribute, String[] interfaceRealization, String[] ownedOperation){
setId(objId_);
setName(name);
setGeneralization(generalization);
setIsAbstract(isAbstract);
setOwnedAttribute(ownedAttribute);
setInterfaceRealization(interfaceRealization);
setOwnedOperation(ownedOperation);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] generalization= new String[0];public void setGeneralization(String[] v) {
  this.generalization = v;
}
public String[] getGeneralization() {
  return this.generalization;
}
boolean isAbstract;public void setIsAbstract(boolean v) {
  this.isAbstract = v;
}
public boolean getIsAbstract() {
  return this.isAbstract;
}
@lintra.utils.Reference
String[] ownedAttribute= new String[0];public void setOwnedAttribute(String[] v) {
  this.ownedAttribute = v;
}
public String[] getOwnedAttribute() {
  return this.ownedAttribute;
}
@lintra.utils.Reference
String[] interfaceRealization= new String[0];public void setInterfaceRealization(String[] v) {
  this.interfaceRealization = v;
}
public String[] getInterfaceRealization() {
  return this.interfaceRealization;
}
@lintra.utils.Reference
String[] ownedOperation= new String[0];public void setOwnedOperation(String[] v) {
  this.ownedOperation = v;
}
public String[] getOwnedOperation() {
  return this.ownedOperation;
}
public String toString() {
String s = "Class_"+this.id;s+=" name="+name;s+=" generalization="+ java.util.Arrays.toString(generalization);s+=" isAbstract="+isAbstract;s+=" ownedAttribute="+ java.util.Arrays.toString(ownedAttribute);s+=" interfaceRealization="+ java.util.Arrays.toString(interfaceRealization);s+=" ownedOperation="+ java.util.Arrays.toString(ownedOperation);return s;}}