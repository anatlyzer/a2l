package javamm;
import blackboard.IdentifiableElement;
import java.io.Serializable;
@SuppressWarnings("serial")public abstract class AbstractMethodInvocation  implements Serializable, IdentifiableElement, IAbstractMethodInvocation, javamm.IASTNode { 
@Override public Object clone() throws CloneNotSupportedException { return super.clone(); }public String getTypeId() { return "AbstractMethodInvocation"; }
public AbstractMethodInvocation() { }public AbstractMethodInvocation(String id_,String[] comments, String originalCompilationUnit, String originalClassFile, String method, String[] arguments, String[] typeArguments){
setId(id_);
setComments(comments);
setOriginalCompilationUnit(originalCompilationUnit);
setOriginalClassFile(originalClassFile);
setMethod(method);
setArguments(arguments);
setTypeArguments(typeArguments);
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
String method;public void setMethod(String v) {
  this.method = v;
}
public String getMethod() {
  return this.method;
}
@lintra.utils.Reference
String[] arguments= new String[0];public void setArguments(String[] v) {
  this.arguments = v;
}
public String[] getArguments() {
  return this.arguments;
}
@lintra.utils.Reference
String[] typeArguments= new String[0];public void setTypeArguments(String[] v) {
  this.typeArguments = v;
}
public String[] getTypeArguments() {
  return this.typeArguments;
}
}