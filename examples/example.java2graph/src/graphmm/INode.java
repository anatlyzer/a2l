package graphmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface INode extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setType(java.lang.String v);public java.lang.String getType();public void setSize(double v);public double getSize();}