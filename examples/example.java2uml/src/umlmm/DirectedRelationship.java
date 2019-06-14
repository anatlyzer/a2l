package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class DirectedRelationship  implements Serializable, IdentifiableElement, IDirectedRelationship, umlmm.IRelationship { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "DirectedRelationship"; }
public DirectedRelationship() { }public DirectedRelationship(String objId_){
setId(objId_);
;
}
}