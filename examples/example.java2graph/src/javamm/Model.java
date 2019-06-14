package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class Model  implements Serializable, IdentifiableElement, IModel { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "Model"; }
public Model() { }public Model(String id_,java.lang.String name, String[] ownedElements, String[] orphanTypes, String[] unresolvedItems, String[] compilationUnits, String[] classFiles, String[] archives){
setId(id_);
setName(name);
setOwnedElements(ownedElements);
setOrphanTypes(orphanTypes);
setUnresolvedItems(unresolvedItems);
setCompilationUnits(compilationUnits);
setClassFiles(classFiles);
setArchives(archives);
}
java.lang.String name;public void setName(java.lang.String v) {
  this.name = v;
}
public java.lang.String getName() {
  return this.name;
}
@lintra.utils.Reference
String[] ownedElements= new String[0];public void setOwnedElements(String[] v) {
  this.ownedElements = v;
}
public String[] getOwnedElements() {
  return this.ownedElements;
}
@lintra.utils.Reference
String[] orphanTypes= new String[0];public void setOrphanTypes(String[] v) {
  this.orphanTypes = v;
}
public String[] getOrphanTypes() {
  return this.orphanTypes;
}
@lintra.utils.Reference
String[] unresolvedItems= new String[0];public void setUnresolvedItems(String[] v) {
  this.unresolvedItems = v;
}
public String[] getUnresolvedItems() {
  return this.unresolvedItems;
}
@lintra.utils.Reference
String[] compilationUnits= new String[0];public void setCompilationUnits(String[] v) {
  this.compilationUnits = v;
}
public String[] getCompilationUnits() {
  return this.compilationUnits;
}
@lintra.utils.Reference
String[] classFiles= new String[0];public void setClassFiles(String[] v) {
  this.classFiles = v;
}
public String[] getClassFiles() {
  return this.classFiles;
}
@lintra.utils.Reference
String[] archives= new String[0];public void setArchives(String[] v) {
  this.archives = v;
}
public String[] getArchives() {
  return this.archives;
}
public String toString() {
String s = "Model_"+this.id;s+=" name="+name;s+=" ownedElements="+ java.util.Arrays.toString(ownedElements);s+=" orphanTypes="+ java.util.Arrays.toString(orphanTypes);s+=" unresolvedItems="+ java.util.Arrays.toString(unresolvedItems);s+=" compilationUnits="+ java.util.Arrays.toString(compilationUnits);s+=" classFiles="+ java.util.Arrays.toString(classFiles);s+=" archives="+ java.util.Arrays.toString(archives);return s;}}