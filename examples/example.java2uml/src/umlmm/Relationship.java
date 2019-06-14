package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class Relationship  implements Serializable, IdentifiableElement, IRelationship, umlmm.IElement { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Relationship"; }
public Relationship() { }public Relationship(String objId_){
setId(objId_);
;
}
}