package a2l.tests.dblp_v1.normal;

import lintra2.transfo.IFootprint;

public class DBLPv1Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof dblp.DBLP.Author);
}}