package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IGeneralization extends IdentifiableElement,umlmm.IDirectedRelationship { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setGeneral(String v);public String getGeneral();}