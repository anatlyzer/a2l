package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class PackageableElement  implements Serializable, IdentifiableElement, IPackageableElement, umlmm.INamedElement, umlmm.IParameterableElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "PackageableElement"; }
public PackageableElement() { }public PackageableElement(String objId_,java.lang.String name){
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