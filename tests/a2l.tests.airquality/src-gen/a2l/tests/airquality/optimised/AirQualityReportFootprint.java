package a2l.tests.airquality.optimised;

import lintra2.transfo.IFootprint;

public class AirQualityReportFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof airquality.AirMeasurement);
}}