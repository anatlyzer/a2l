package graphmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Edge  implements Serializable, IdentifiableElement, IEdge { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Edge"; }
public Edge() { }public Edge(String id_,String source, String target){
setId(id_);
setSource(source);
setTarget(target);
}
@lintra.utils.Reference
String source;public void setSource(String v) {
  this.source = v;
}
public String getSource() {
  return this.source;
}
@lintra.utils.Reference
String target;public void setTarget(String v) {
  this.target = v;
}
public String getTarget() {
  return this.target;
}
public String toString() {
String s = "Edge_"+this.id;s+=" source="+source;s+=" target="+target;return s;}}