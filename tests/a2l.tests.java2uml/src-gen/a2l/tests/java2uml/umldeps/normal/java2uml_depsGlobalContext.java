package a2l.tests.java2uml.umldeps.normal;

import com.google.common.cache.Cache;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.Type;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.PrimitiveType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Class;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.InheritanceKind;

public class java2uml_depsGlobalContext extends a2l.runtime.DefaultGlobalContext {
public java2uml_depsGlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }private javaslang.collection.List<ClassDeclaration> allInstancesOf_ClassDeclaration = javaslang.collection.List.empty();
public void addAllInstancesObject(Object obj) {if ( obj instanceof ClassDeclaration) { 
   allInstancesOf_ClassDeclaration = allInstancesOf_ClassDeclaration.prepend( (ClassDeclaration) obj);
}}
public javaslang.collection.List<ClassDeclaration> getAllInstancesOf_ClassDeclaration() {
  return allInstancesOf_ClassDeclaration;
}
}