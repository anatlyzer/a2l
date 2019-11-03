package a2l.tests.findcouples.normal;

import lintra2.transfo.IFootprint;

public class FindCouplesIMDbFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof imdb.movies.Actor) {
return true;
}else if ( o instanceof imdb.movies.Actress) {
return true;
}else if ( o instanceof imdb.movies.Movie) {
return true;
}else if ( o instanceof imdb.movies.Couple) {
return true;
}else if ( o instanceof imdb.movies.Person) {
return true;
} else { return false;
}}}