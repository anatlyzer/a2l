package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractMethodDeclaration extends IdentifiableElement,javamm.IBodyDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();public void setParameters(String[] v);public String[] getParameters();public void setThrownExceptions(String[] v);public String[] getThrownExceptions();public void setTypeParameters(String[] v);public String[] getTypeParameters();public void setUsagesInDocComments(String[] v);public String[] getUsagesInDocComments();public void setUsages(String[] v);public String[] getUsages();}