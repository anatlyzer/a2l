package a2l.tests.dblp_v2.optimised;

import lintra2.transfo.IFootprint;

public class DBLPv2Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof dblp.DBLP.Author);
}}