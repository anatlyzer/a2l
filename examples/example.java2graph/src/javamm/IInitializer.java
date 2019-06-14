package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IInitializer extends IdentifiableElement,javamm.IBodyDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();}