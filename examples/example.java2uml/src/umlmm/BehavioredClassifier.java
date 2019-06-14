package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class BehavioredClassifier  implements Serializable, IdentifiableElement, IBehavioredClassifier, umlmm.IClassifier { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "BehavioredClassifier"; }
public BehavioredClassifier() { }public BehavioredClassifier(String objId_,java.lang.String name, String[] generalization, boolean isAbstract, String[] interfaceRealization){
setId(objId_);
setName(name);
setGeneralization(generalization);
setIsAbstract(isAbstract);
setInterfaceRealization(interfaceRealization);
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
String[] interfaceRealization= new String[0];public void setInterfaceRealization(String[] v) {
  this.interfaceRealization = v;
}
public String[] getInterfaceRealization() {
  return this.interfaceRealization;
}
}