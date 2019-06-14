package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class EncapsulatedClassifier  implements Serializable, IdentifiableElement, IEncapsulatedClassifier, umlmm.IStructuredClassifier { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "EncapsulatedClassifier"; }
public EncapsulatedClassifier() { }public EncapsulatedClassifier(String objId_,java.lang.String name, String[] generalization, boolean isAbstract, String[] ownedAttribute){
setId(objId_);
setName(name);
setGeneralization(generalization);
setIsAbstract(isAbstract);
setOwnedAttribute(ownedAttribute);
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
}