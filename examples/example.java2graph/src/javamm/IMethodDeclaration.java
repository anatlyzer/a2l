package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IMethodDeclaration extends IdentifiableElement,javamm.IAbstractMethodDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExtraArrayDimensions(int v);public int getExtraArrayDimensions();public void setReturnType(String v);public String getReturnType();public void setRedefinedMethodDeclaration(String v);public String getRedefinedMethodDeclaration();public void setRedefinitions(String[] v);public String[] getRedefinitions();}