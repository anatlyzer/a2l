package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IArrayCreation extends IdentifiableElement,javamm.IExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setDimensions(String[] v);public String[] getDimensions();public void setInitializer(String v);public String getInitializer();public void setType(String v);public String getType();}