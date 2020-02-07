package a2l.tests.imdb.identity.optimised;

import lintra2.transfo.IFootprint;

public class IdentityIMDbFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o, a2l.runtime.IGlobalContext p_context){
a2l.tests.imdb.identity.optimised.IdentityIMDbGlobalContext context = (a2l.tests.imdb.identity.optimised.IdentityIMDbGlobalContext) p_context;

	return (o instanceof imdb.movies.Clique) || (o instanceof imdb.movies.Actress) || (o instanceof imdb.movies.Couple) || (o instanceof imdb.movies.Actor) || (o instanceof imdb.movies.Movie);
}}