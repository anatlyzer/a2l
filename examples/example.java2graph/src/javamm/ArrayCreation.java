package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public  class ArrayCreation  implements Serializable, IdentifiableElement, IArrayCreation, javamm.IExpression { 
String id, trgId, modelName_;
public String getId() { 	return id;} public void setId(String id) {	this.id = id;}public String getTrgId() {	return trgId;}public void setTrgId(String trgId) {	this.trgId = trgId;}public String getModelName() {	return modelName_;}public void setModelName(String modelName) {	this.modelName_ = modelName;}@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "ArrayCreation"; }
public ArrayCreation() { }public ArrayCreation(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String[] dimensions, String initializer, String type){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setDimensions(dimensions);
setInitializer(initializer);
setType(type);
}
@lintra.utils.Reference
String[] comments= new String[0];public void setComments(String[] v) {
  this.comments = v;
}
public String[] getComments() {
  return this.comments;
}
@lintra.utils.Reference
String originalCompilationUnit;public void setOriginalCompilationUnit(String v) {
  this.originalCompilationUnit = v;
}
public String getOriginalCompilationUnit() {
  return this.originalCompilationUnit;
}
@lintra.utils.Reference
String originalClassFile;public void setOriginalClassFile(String v) {
  this.originalClassFile = v;
}
public String getOriginalClassFile() {
  return this.originalClassFile;
}
@lintra.utils.Reference
String[] dimensions= new String[0];public void setDimensions(String[] v) {
  this.dimensions = v;
}
public String[] getDimensions() {
  return this.dimensions;
}
@lintra.utils.Reference
String initializer;public void setInitializer(String v) {
  this.initializer = v;
}
public String getInitializer() {
  return this.initializer;
}
@lintra.utils.Reference
String type;public void setType(String v) {
  this.type = v;
}
public String getType() {
  return this.type;
}
public String toString() {
String s = "ArrayCreation_"+this.id;s+=" comments="+ java.util.Arrays.toString(comments);s+=" originalCompilationUnit="+originalCompilationUnit;s+=" originalClassFile="+originalClassFile;s+=" dimensions="+ java.util.Arrays.toString(dimensions);s+=" initializer="+initializer;s+=" type="+type;return s;}}