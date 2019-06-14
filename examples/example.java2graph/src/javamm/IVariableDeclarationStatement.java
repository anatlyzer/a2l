package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IVariableDeclarationStatement extends IdentifiableElement,javamm.IStatement,javamm.IAbstractVariablesContainer { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExtraArrayDimensions(int v);public int getExtraArrayDimensions();public void setModifier(String v);public String getModifier();public void setAnnotations(String[] v);public String[] getAnnotations();}