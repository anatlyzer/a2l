package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IBehavioredClassifier extends IdentifiableElement,umlmm.IClassifier { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setInterfaceRealization(String[] v);public String[] getInterfaceRealization();}