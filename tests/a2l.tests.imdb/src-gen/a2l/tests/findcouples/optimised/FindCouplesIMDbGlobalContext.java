package a2l.tests.findcouples.optimised;

import com.google.common.cache.Cache;
import imdb.movies.Person;
import imdb.movies.Movie;
import imdb.movies.Couple;
import imdb.movies.MovieType;
import imdb.movies.Actor;
import imdb.movies.Actress;

public class FindCouplesIMDbGlobalContext extends a2l.runtime.DefaultGlobalContext {
private Cache<Person, javaslang.collection.Set<Movie>> cache18_p1;
	private Cache<Person, java.util.List<Movie>> cache17_p1;
	private Cache<Movie, java.util.List<Person>> cache16_m;
	private Cache<Person, javaslang.collection.Set<Movie>> cache19_p2;public FindCouplesIMDbGlobalContext() {
cache18_p1 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, javaslang.collection.Set<Movie>>build();
cache17_p1 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, java.util.List<Movie>>build();
cache16_m = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Movie, java.util.List<Person>>build();
cache19_p2 = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(Runtime.getRuntime().availableProcessors()).<Person, javaslang.collection.Set<Movie>>build();
allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }public javaslang.collection.Set<Movie> getcache18_p1(Person key, java.util.concurrent.Callable<javaslang.collection.Set<Movie>> closure) { try { return cache18_p1.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public java.util.List<Movie> getcache17_p1(Person key, java.util.concurrent.Callable<java.util.List<Movie>> closure) { try { return cache17_p1.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public java.util.List<Person> getcache16_m(Movie key, java.util.concurrent.Callable<java.util.List<Person>> closure) { try { return cache16_m.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
public javaslang.collection.Set<Movie> getcache19_p2(Person key, java.util.concurrent.Callable<javaslang.collection.Set<Movie>> closure) { try { return cache19_p2.get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }public void addAllInstancesObject(Object obj) {}
}