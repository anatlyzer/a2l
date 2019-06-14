package a2l.tests.dblp_v2.normal;

import lintra2.transfo.IFootprint;

public class DBLPv2Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof dblp.DBLP.Author) {
return true;
}else if ( o instanceof dblp.DBLP.InProceedings) {
return true;
} else { return false;
}}}