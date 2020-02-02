package a2l.tests.dblp_v2.optimised;

import lintra2.transfo.IFootprint;

public class DBLPv2Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext context = (a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext) p_context;

	return (o instanceof dblp.DBLP.Author);
}}