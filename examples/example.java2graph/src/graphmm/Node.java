package graphmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Node  implements Serializable, IdentifiableElement, INode { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Node"; }
public Node() { }public Node(String id_,java.lang.String name, java.lang.String type, double size){
setId(id_);
setName(name);
setType(type);
setSize(size);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
java.lang.String type;public void setType(java.lang.String v) {
  this.type = v;
}
public java.lang.String getType() {
  return this.type;
}
double size;public void setSize(double v) {
  this.size = v;
}
public double getSize() {
  return this.size;
}
public String toString() {
String s = "Node_"+this.id;s+=" name="+name;s+=" type="+type;s+=" size="+size;return s;}}