package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITypeAccess extends IdentifiableElement,jmm.IExpression,jmm.INamespaceAccess { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(String v);public String getType();}