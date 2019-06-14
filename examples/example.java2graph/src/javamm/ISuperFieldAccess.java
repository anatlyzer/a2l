package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISuperFieldAccess extends IdentifiableElement,javamm.IAbstractTypeQualifiedExpression { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setField(String v);public String getField();}