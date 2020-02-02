package a2l.tests.dblp_v1.normal;

import lintra2.transfo.IFootprint;

public class DBLPv1Footprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.dblp_v1.normal.DBLPv1GlobalContext context = (a2l.tests.dblp_v1.normal.DBLPv1GlobalContext) p_context;

	return (o instanceof dblp.DBLP.Author);
}}