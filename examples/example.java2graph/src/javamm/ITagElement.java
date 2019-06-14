package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITagElement extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setTagName(java.lang.String v);public java.lang.String getTagName();public void setFragments(String[] v);public String[] getFragments();}