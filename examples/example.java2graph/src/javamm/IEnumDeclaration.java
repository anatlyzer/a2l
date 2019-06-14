package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IEnumDeclaration extends IdentifiableElement,javamm.IAbstractTypeDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setEnumConstants(String[] v);public String[] getEnumConstants();}