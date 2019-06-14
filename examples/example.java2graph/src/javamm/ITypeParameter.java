package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITypeParameter extends IdentifiableElement,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBounds(String[] v);public String[] getBounds();}