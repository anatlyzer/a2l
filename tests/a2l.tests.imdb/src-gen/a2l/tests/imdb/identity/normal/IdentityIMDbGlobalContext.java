package a2l.tests.imdb.identity.normal;

import com.google.common.cache.Cache;
import imdb.movies.Movie;
import imdb.movies.MovieType;
import imdb.movies.Person;
import imdb.movies.Actor;
import imdb.movies.Actress;
import imdb.movies.Clique;
import imdb.movies.Couple;

public class IdentityIMDbGlobalContext extends a2l.runtime.DefaultGlobalContext {
public IdentityIMDbGlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }public void addAllInstancesObject(Object obj) {}
}