package simpleuml;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Property  implements Serializable, IdentifiableElement, IProperty, simpleuml.INamedElement { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Property"; }
public Property() { }public Property(String objId_,java.lang.String name, java.lang.String primitiveType, String complexType, boolean isContainment){
setId(objId_);
setName(name);
setPrimitiveType(primitiveType);
setComplexType(complexType);
setIsContainment(isContainment);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
java.lang.String primitiveType;public void setPrimitiveType(java.lang.String v) {
  this.primitiveType = v;
}
public java.lang.String getPrimitiveType() {
  return this.primitiveType;
}
@lintra.utils.Reference
String complexType;public void setComplexType(String v) {
  this.complexType = v;
}
public String getComplexType() {
  return this.complexType;
}
boolean isContainment;public void setIsContainment(boolean v) {
  this.isContainment = v;
}
public boolean getIsContainment() {
  return this.isContainment;
}
public String toString() {
String s = "Property_"+this.id;s+=" name="+name;s+=" primitiveType="+primitiveType;s+=" complexType="+complexType;s+=" isContainment="+isContainment;return s;}}