package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ILabeledStatement extends IdentifiableElement,javamm.INamedElement,javamm.IStatement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setBody(String v);public String getBody();public void setUsagesInBreakStatements(String[] v);public String[] getUsagesInBreakStatements();public void setUsagesInContinueStatements(String[] v);public String[] getUsagesInContinueStatements();}