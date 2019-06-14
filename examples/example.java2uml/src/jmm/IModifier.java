package jmm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IModifier extends IdentifiableElement,jmm.IASTNode { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setInheritance(InheritanceKind v);public InheritanceKind getInheritance();}