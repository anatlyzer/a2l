package a2l.tests.dblp2bibtex.normal;

import com.google.common.cache.Cache;
import dblp.DBLP.Record;
import a2l.tests.bibtex.BibTeX.BibTeXFile;
import dblp.DBLP.Editor;
import dblp.DBLP.Journal;
import dblp.DBLP.MastersThesis;
import a2l.tests.bibtex.BibTeX.MasterThesis;
import dblp.DBLP.School;
import dblp.DBLP.Publisher;

public class DBLP2BibTeXGlobalContext extends a2l.runtime.DefaultGlobalContext {
public DBLP2BibTeXGlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }private javaslang.collection.List<dblp.DBLP.Author> allInstancesOf_Author = javaslang.collection.List.empty();
private javaslang.collection.List<dblp.DBLP.Record> allInstancesOf_Record = javaslang.collection.List.empty();
public void addAllInstancesObject(Object obj) {if ( obj instanceof dblp.DBLP.Record) { 
   allInstancesOf_Record = allInstancesOf_Record.prepend( (dblp.DBLP.Record) obj);
}if ( obj instanceof dblp.DBLP.Author) { 
   allInstancesOf_Author = allInstancesOf_Author.prepend( (dblp.DBLP.Author) obj);
}}
public javaslang.collection.List<dblp.DBLP.Record> getAllInstancesOf_Record() {
  return allInstancesOf_Record;
}
public javaslang.collection.List<dblp.DBLP.Author> getAllInstancesOf_Author() {
  return allInstancesOf_Author;
}
}