package a2l.tests.dblp_v1.optimised;

import lintra2.transfo.IFootprint;

public class DBLPv1Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.dblp_v1.optimised.DBLPv1GlobalContext context = (a2l.tests.dblp_v1.optimised.DBLPv1GlobalContext) p_context;

	return (o instanceof dblp.DBLP.Author);
}}