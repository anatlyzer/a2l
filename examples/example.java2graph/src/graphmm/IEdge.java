package graphmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEdge extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setSource(String v);public String getSource();public void setTarget(String v);public String getTarget();}