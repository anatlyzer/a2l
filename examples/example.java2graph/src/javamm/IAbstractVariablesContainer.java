package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAbstractVariablesContainer extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(String v);public String getType();public void setFragments(String[] v);public String[] getFragments();}