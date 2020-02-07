package a2l.tests.findcouples.optimised;

import lintra2.transfo.IFootprint;

public class FindCouplesIMDbFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.findcouples.optimised.FindCouplesIMDbGlobalContext context = (a2l.tests.findcouples.optimised.FindCouplesIMDbGlobalContext) p_context;

	return (o instanceof imdb.movies.Actress) || (o instanceof imdb.movies.Actor) || (o instanceof imdb.movies.Movie);
}}