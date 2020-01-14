package a2l.tests.airquality.normal;

import lintra2.transfo.IFootprint;

public class AirQualityReportFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof airquality.AirMeasurement);
}}