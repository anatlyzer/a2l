package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IForeignKey extends IdentifiableElement,relational.IModelElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setForeignTable(String v);public String getForeignTable();public void setSourceTable(String v);public String getSourceTable();}