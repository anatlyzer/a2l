package a2l.tests.dblp_v1.optimised;

import lintra2.transfo.IFootprint;

public class DBLPv1Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof dblp.DBLP.Author) {
return true;
}else if ( o instanceof dblp.DBLP.InProceedings) {
return true;
} else { return false;
}}}