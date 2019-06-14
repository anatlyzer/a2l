package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModifier extends IdentifiableElement,javamm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setVisibility(VisibilityKind v);public VisibilityKind getVisibility();public void setInheritance(InheritanceKind v);public InheritanceKind getInheritance();public void setStatic(boolean v);public boolean getStatic();public void setTransient(boolean v);public boolean getTransient();public void setVolatile(boolean v);public boolean getVolatile();public void setNative(boolean v);public boolean getNative();public void setStrictfp(boolean v);public boolean getStrictfp();public void setSynchronized(boolean v);public boolean getSynchronized();public void setBodyDeclaration(String v);public String getBodyDeclaration();public void setSingleVariableDeclaration(String v);public String getSingleVariableDeclaration();public void setVariableDeclarationStatement(String v);public String getVariableDeclarationStatement();public void setVariableDeclarationExpression(String v);public String getVariableDeclarationExpression();}