package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IBodyDeclaration extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setAbstractTypeDeclaration(String v);public String getAbstractTypeDeclaration();public void setAnnotations(String[] v);public String[] getAnnotations();public void setAnonymousClassDeclarationOwner(String v);public String getAnonymousClassDeclarationOwner();public void setModifier(String v);public String getModifier();}