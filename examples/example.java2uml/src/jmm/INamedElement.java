package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface INamedElement extends IdentifiableElement,jmm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setProxy(boolean v);public boolean getProxy();public void setName(java.lang.String v);public java.lang.String getName();}