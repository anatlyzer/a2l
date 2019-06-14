package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedItemAccess extends IdentifiableElement,javamm.IExpression,javamm.INamespaceAccess { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setElement(String v);public String getElement();public void setQualifier(String v);public String getQualifier();}