package relational;
import lintra2.blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IDatabase extends IdentifiableElement,relational.IModelElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setName(java.lang.String v);public java.lang.String getName();public void setUrl(java.lang.String v);public java.lang.String getUrl();public void setOwnedSchemas(String[] v);public String[] getOwnedSchemas();}