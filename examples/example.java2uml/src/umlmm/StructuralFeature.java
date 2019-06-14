package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class StructuralFeature  implements Serializable, IdentifiableElement, IStructuralFeature, umlmm.IFeature, umlmm.ITypedElement, umlmm.IMultiplicityElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "StructuralFeature"; }
public StructuralFeature() { }public StructuralFeature(String objId_,java.lang.String name){
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