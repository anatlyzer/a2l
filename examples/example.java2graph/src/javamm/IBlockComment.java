package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IBlockComment extends IdentifiableElement,javamm.IComment { 
public String getId();
public void setId(String id);
public String getTypeId();
}