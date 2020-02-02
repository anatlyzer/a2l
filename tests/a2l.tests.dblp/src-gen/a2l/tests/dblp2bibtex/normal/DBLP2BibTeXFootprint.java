package a2l.tests.dblp2bibtex.normal;

import lintra2.transfo.IFootprint;

public class DBLP2BibTeXFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.dblp2bibtex.normal.DBLP2BibTeXGlobalContext context = (a2l.tests.dblp2bibtex.normal.DBLP2BibTeXGlobalContext) p_context;

	return (o instanceof dblp.DBLP.InProceedings) || (o instanceof dblp.DBLP.MastersThesis) || (o instanceof dblp.DBLP.Article) || (o instanceof dblp.DBLP.PhDThesis) || (o instanceof dblp.DBLP.InCollection) || (o instanceof dblp.DBLP.Proceedings) || (o instanceof dblp.DBLP.Book);
}}