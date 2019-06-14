package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IWildCardType extends IdentifiableElement,javamm.IType { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setUpperBound(boolean v);public boolean getUpperBound();public void setBound(String v);public String getBound();}