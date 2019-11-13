package a2l.tests.java2uml.umldeps.optimised;

import com.google.common.cache.Cache;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.Type;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.PrimitiveType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Class;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.InheritanceKind;

public class java2uml_depsGlobalContext extends a2l.runtime.DefaultGlobalContext {
private Cache<ClassDeclaration, java.util.List<BodyDeclaration>> cache0_cd;public java2uml_depsGlobalContext() {
cache0_cd = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<ClassDeclaration, java.util.List<BodyDeclaration>>build();
allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }public java.util.List<BodyDeclaration> getcache0_cd(ClassDeclaration key, java.util.concurrent.Callable<java.util.List<BodyDeclaration>> closure) { try { return cache0_cd.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }private javaslang.collection.List<org.eclipse.gmt.modisco.java.ClassDeclaration> allInstancesOf_ClassDeclaration = javaslang.collection.List.empty();
public void addAllInstancesObject(Object obj) {if ( obj instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) { 
   allInstancesOf_ClassDeclaration = allInstancesOf_ClassDeclaration.prepend( (org.eclipse.gmt.modisco.java.ClassDeclaration) obj);
}}
public javaslang.collection.List<org.eclipse.gmt.modisco.java.ClassDeclaration> getAllInstancesOf_ClassDeclaration() {
  return allInstancesOf_ClassDeclaration;
}
}