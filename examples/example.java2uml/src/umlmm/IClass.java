package umlmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IClass extends IdentifiableElement,umlmm.IEncapsulatedClassifier,umlmm.IBehavioredClassifier { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setOwnedOperation(String[] v);public String[] getOwnedOperation();}