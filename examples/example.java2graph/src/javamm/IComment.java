package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IComment extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setContent(java.lang.String v);public java.lang.String getContent();public void setEnclosedByParent(boolean v);public boolean getEnclosedByParent();public void setPrefixOfParent(boolean v);public boolean getPrefixOfParent();}