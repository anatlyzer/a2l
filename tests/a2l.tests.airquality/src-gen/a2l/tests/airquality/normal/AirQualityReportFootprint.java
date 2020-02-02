package a2l.tests.airquality.normal;

import lintra2.transfo.IFootprint;

public class AirQualityReportFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.airquality.normal.AirQualityReportGlobalContext context = (a2l.tests.airquality.normal.AirQualityReportGlobalContext) p_context;

	return (o instanceof airquality.AirMeasurement);
}}