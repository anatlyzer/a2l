package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ITextElement extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setText(java.lang.String v);public java.lang.String getText();}