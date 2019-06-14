package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractTypeDeclaration extends IdentifiableElement,javamm.IBodyDeclaration,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBodyDeclarations(String[] v);public String[] getBodyDeclarations();public void setCommentsBeforeBody(String[] v);public String[] getCommentsBeforeBody();public void setCommentsAfterBody(String[] v);public String[] getCommentsAfterBody();public void setPackage(String v);public String getPackage();public void setSuperInterfaces(String[] v);public String[] getSuperInterfaces();}