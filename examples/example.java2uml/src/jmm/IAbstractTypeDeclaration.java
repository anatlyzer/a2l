package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractTypeDeclaration extends IdentifiableElement,jmm.IBodyDeclaration,jmm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBodyDeclarations(String[] v);public String[] getBodyDeclarations();public void setSuperInterfaces(String[] v);public String[] getSuperInterfaces();}