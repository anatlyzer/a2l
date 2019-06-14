package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEnumConstantDeclaration extends IdentifiableElement,javamm.IBodyDeclaration,javamm.IVariableDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setAnonymousClassDeclaration(String v);public String getAnonymousClassDeclaration();public void setArguments(String[] v);public String[] getArguments();}