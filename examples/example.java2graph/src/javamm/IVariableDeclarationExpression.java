package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IVariableDeclarationExpression extends IdentifiableElement,javamm.IExpression,javamm.IAbstractVariablesContainer { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setModifier(String v);public String getModifier();public void setAnnotations(String[] v);public String[] getAnnotations();}