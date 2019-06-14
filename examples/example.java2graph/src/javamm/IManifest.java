package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public interface IManifest extends IdentifiableElement { 
public String getId();
public void setId(String id);
public String getTypeId();
public void setMainAttributes(String[] v);public String[] getMainAttributes();public void setEntryAttributes(String[] v);public String[] getEntryAttributes();}