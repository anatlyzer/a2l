package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISingleVariableDeclaration extends IdentifiableElement,javamm.IVariableDeclaration { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setModifier(String v);public String getModifier();public void setVarargs(boolean v);public boolean getVarargs();public void setType(String v);public String getType();public void setAnnotations(String[] v);public String[] getAnnotations();public void setMethodDeclaration(String v);public String getMethodDeclaration();public void setCatchClause(String v);public String getCatchClause();public void setEnhancedForStatement(String v);public String getEnhancedForStatement();}