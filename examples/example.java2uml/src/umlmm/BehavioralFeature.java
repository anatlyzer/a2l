package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class BehavioralFeature  implements Serializable, IdentifiableElement, IBehavioralFeature, umlmm.INamespace, umlmm.IFeature { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "BehavioralFeature"; }
public BehavioralFeature() { }public BehavioralFeature(String objId_,java.lang.String name){
setId(objId_);
setName(name);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
}