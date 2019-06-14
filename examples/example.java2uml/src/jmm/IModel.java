package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModel extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedElements(String[] v);public String[] getOwnedElements();public void setName(java.lang.String v);public java.lang.String getName();}