package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IAnnotationTypeMemberDeclaration extends IdentifiableElement,javamm.IBodyDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setDefault(String v);public String getDefault();public void setType(String v);public String getType();public void setUsages(String[] v);public String[] getUsages();}