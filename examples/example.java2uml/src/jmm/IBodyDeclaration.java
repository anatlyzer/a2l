package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IBodyDeclaration extends IdentifiableElement,jmm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setModifier(String v);public String getModifier();}