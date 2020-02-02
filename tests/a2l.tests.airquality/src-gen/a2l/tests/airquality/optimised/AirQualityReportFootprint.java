package a2l.tests.airquality.optimised;

import lintra2.transfo.IFootprint;

public class AirQualityReportFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.airquality.optimised.AirQualityReportGlobalContext context = (a2l.tests.airquality.optimised.AirQualityReportGlobalContext) p_context;

	return (o instanceof airquality.AirMeasurement);
}}