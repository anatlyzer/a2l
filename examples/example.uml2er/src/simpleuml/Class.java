package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Class  implements Serializable, IdentifiableElement, IClass, simpleuml.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Class"; }
public Class() { }public Class(String objId_,java.lang.String name, String[] ownedProperty, String[] superClasses){
setId(objId_);
setName(name);
setOwnedProperty(ownedProperty);
setSuperClasses(superClasses);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] ownedProperty= new String[0];public void setOwnedProperty(String[] v) {
  this.ownedProperty = v;
}
public String[] getOwnedProperty() {
  return this.ownedProperty;
}
@lintra.utils.Reference
String[] superClasses= new String[0];public void setSuperClasses(String[] v) {
  this.superClasses = v;
}
public String[] getSuperClasses() {
  return this.superClasses;
}
public String toString() {
String s = "Class_"+this.id;s+=" name="+name;s+=" ownedProperty="+ java.util.Arrays.toString(ownedProperty);s+=" superClasses="+ java.util.Arrays.toString(superClasses);return s;}}