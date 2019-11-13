package a2l.tests.airquality.normal;

import lintra2.transfo.IFootprint;

public class AirQualityReportFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof airquality.AirMeasurement) {
return true;
}else if ( o instanceof airquality.Date) {
return true;
}else if ( o instanceof airquality.Warning) {
return true;
} else { return false;
}}}