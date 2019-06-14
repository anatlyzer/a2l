package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAnonymousClassDeclaration extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBodyDeclarations(String[] v);public String[] getBodyDeclarations();public void setClassInstanceCreation(String v);public String getClassInstanceCreation();}