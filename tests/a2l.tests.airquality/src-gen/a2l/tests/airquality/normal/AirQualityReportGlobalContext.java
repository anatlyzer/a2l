package a2l.tests.airquality.normal;

import com.google.common.cache.Cache;
import airquality.AirMeasurement;
import airquality.Warning;
import airquality.Date;

public class AirQualityReportGlobalContext extends a2l.runtime.DefaultGlobalContext {
public AirQualityReportGlobalContext() {

allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();; }
private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; 
	@SuppressWarnings("unchecked")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) {  try {   return (javaslang.collection.List<T>) allInstancesCache.get(key, closure);  } catch (java.util.concurrent.ExecutionException e) {    throw new IllegalStateException();  } }private javaslang.collection.List<airquality.AirMeasurement> allInstancesOf_AirMeasurement = javaslang.collection.List.empty();
public void addAllInstancesObject(Object obj) {if ( obj instanceof airquality.AirMeasurement) { 
   allInstancesOf_AirMeasurement = allInstancesOf_AirMeasurement.prepend( (airquality.AirMeasurement) obj);
}}
public javaslang.collection.List<airquality.AirMeasurement> getAllInstancesOf_AirMeasurement() {
  return allInstancesOf_AirMeasurement;
}
}