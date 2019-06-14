package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class Classifier  implements Serializable, IdentifiableElement, IClassifier, umlmm.INamespace, umlmm.IRedefinableElement, umlmm.IType, umlmm.ITemplateableElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Classifier"; }
public Classifier() { }public Classifier(String objId_,java.lang.String name, String[] generalization, boolean isAbstract){
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
}