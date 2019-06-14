package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface ISchema extends IdentifiableElement,relational.IModelElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setOwnedTables(String[] v);public String[] getOwnedTables();public void setOwner(String v);public String getOwner();}