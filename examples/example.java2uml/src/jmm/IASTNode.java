package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IASTNode extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
}