package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Interface  implements Serializable, IdentifiableElement, IInterface, umlmm.IClassifier { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Interface"; }
public Interface() { }public Interface(String objId_,java.lang.String name, String[] generalization, boolean isAbstract){
setId(objId_);
setName(name);
setGeneralization(generalization);
setIsAbstract(isAbstract);
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
public String toString() {
String s = "Interface_"+this.id;s+=" name="+name;s+=" generalization="+ java.util.Arrays.toString(generalization);s+=" isAbstract="+isAbstract;return s;}}