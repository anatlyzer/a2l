package a2l.tests.dblp_v1.optimised;

import com.google.common.cache.Cache;
import dblp.DBLP.InProceedings;
import dblp.DBLP.Record;

public class DBLPv1GlobalContext extends a2l.runtime.DefaultGlobalContext {
public DBLPv1GlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }public void addAllInstancesObject(Object obj) {}
}