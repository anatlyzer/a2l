package a2l.tests.findcouples.optimised;

import com.google.common.cache.Cache;
import imdb.movies.Movie;
import imdb.movies.Person;
import imdb.movies.Couple;
import imdb.movies.MovieType;
import imdb.movies.Actor;
import imdb.movies.Actress;

public class FindCouplesIMDbGlobalContext extends a2l.runtime.DefaultGlobalContext {
private Cache<Movie, java.util.List<Person>> cache8_m;
	private Cache<Person, javaslang.collection.Set<Movie>> cache6_p2;
	private Cache<Person, java.util.List<Movie>> cache9_p1;
	private Cache<Person, javaslang.collection.Set<Movie>> cache7_p1;public FindCouplesIMDbGlobalContext() {
cache8_m = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Movie, java.util.List<Person>>build();
cache6_p2 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, javaslang.collection.Set<Movie>>build();
cache9_p1 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, java.util.List<Movie>>build();
cache7_p1 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, javaslang.collection.Set<Movie>>build();
allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }public java.util.List<Person> getcache8_m(Movie key, java.util.concurrent.Callable<java.util.List<Person>> closure) { try { return cache8_m.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public javaslang.collection.Set<Movie> getcache6_p2(Person key, java.util.concurrent.Callable<javaslang.collection.Set<Movie>> closure) { try { return cache6_p2.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public java.util.List<Movie> getcache9_p1(Person key, java.util.concurrent.Callable<java.util.List<Movie>> closure) { try { return cache9_p1.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public javaslang.collection.Set<Movie> getcache7_p1(Person key, java.util.concurrent.Callable<javaslang.collection.Set<Movie>> closure) { try { return cache7_p1.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }public void addAllInstancesObject(Object obj) {}
}