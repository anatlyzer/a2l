package a2l.tests.findcouples.optimised;

import lintra2.transfo.IFootprint;

public class FindCouplesIMDbFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
return (o instanceof imdb.movies.Actor) || (o instanceof imdb.movies.Movie) || (o instanceof imdb.movies.Actress);
}}