package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IUnresolvedLabeledStatement extends IdentifiableElement,javamm.ILabeledStatement,javamm.IUnresolvedItem { 
public String getId();
public void setId(String id);
public String getTypeId();
}