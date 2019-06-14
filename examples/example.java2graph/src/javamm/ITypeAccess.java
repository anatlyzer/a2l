package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITypeAccess extends IdentifiableElement,javamm.IExpression,javamm.INamespaceAccess { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(String v);public String getType();public void setQualifier(String v);public String getQualifier();}