package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class ModelElement  implements Serializable, IdentifiableElement, IModelElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ModelElement"; }
public ModelElement() { }public ModelElement(String objId_,java.lang.String comment){
setId(objId_);
setComment(comment);
}
java.lang.String comment;public void setComment(java.lang.String v) {
  this.comment = v;
}
public java.lang.String getComment() {
  return this.comment;
}
}