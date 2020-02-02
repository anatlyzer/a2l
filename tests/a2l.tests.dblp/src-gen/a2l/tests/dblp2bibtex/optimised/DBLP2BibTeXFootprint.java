package a2l.tests.dblp2bibtex.optimised;

import lintra2.transfo.IFootprint;
import dblp.DBLP.Author;

public class DBLP2BibTeXFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXGlobalContext context = (a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXGlobalContext) p_context;

	if ( o instanceof dblp.DBLP.Book) {
return true;
}else if ( o instanceof dblp.DBLP.PhDThesis) {
return true;
}else if ( o instanceof dblp.DBLP.Proceedings) {
return true;
}else if ( o instanceof dblp.DBLP.InProceedings) {
return true;
}else if ( o instanceof dblp.DBLP.InCollection) {
return true;
}else if ( o instanceof dblp.DBLP.MastersThesis) {
return true;
}else if ( o instanceof dblp.DBLP.Article) {
return true;
} else { if ( o instanceof dblp.DBLP.Author) {
Author c0;
java.lang.String get120;c0 = (dblp.DBLP.Author)o;

	/* 21:4-21:11: a2.name*/
	get120 = c0.getName();

	context.setValueOf_Author_name(get120);
}
return false;
}}}