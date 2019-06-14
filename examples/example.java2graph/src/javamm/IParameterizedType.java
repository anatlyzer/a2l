package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IParameterizedType extends IdentifiableElement,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setType(String v);public String getType();public void setTypeArguments(String[] v);public String[] getTypeArguments();}