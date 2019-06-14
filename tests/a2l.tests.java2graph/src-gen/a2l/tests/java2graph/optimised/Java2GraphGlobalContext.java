package a2l.tests.java2graph.optimised;

import com.google.common.cache.Cache;
import org.eclipse.gmt.modisco.java.Package;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.InheritanceKind;
import GraphMM.Node;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import GraphMM.Edge;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.Type;

public class Java2GraphGlobalContext extends a2l.runtime.DefaultGlobalContext {
public Java2GraphGlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }public void addAllInstancesObject(Object obj) {}
}