package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IVariableDeclaration extends IdentifiableElement,javamm.INamedElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setExtraArrayDimensions(int v);public int getExtraArrayDimensions();public void setInitializer(String v);public String getInitializer();public void setUsageInVariableAccess(String[] v);public String[] getUsageInVariableAccess();}