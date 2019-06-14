package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClassifier extends IdentifiableElement,umlmm.INamespace,umlmm.IRedefinableElement,umlmm.IType,umlmm.ITemplateableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setGeneralization(String[] v);public String[] getGeneralization();public void setIsAbstract(boolean v);public boolean getIsAbstract();}