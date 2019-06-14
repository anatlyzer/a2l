package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClassDeclaration extends IdentifiableElement,javamm.ITypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setSuperClass(String v);public String getSuperClass();}