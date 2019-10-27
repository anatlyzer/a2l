package a2l.tests.imdb.identity.normal;

import lintra2.transfo.IFootprint;

public class IdentityIMDbFootprint implements IFootprint{

public boolean inGlobal(java.lang.Object o){
if ( o instanceof imdb.movies.Movie) {
return true;
}else if ( o instanceof imdb.movies.Actor) {
return true;
}else if ( o instanceof imdb.movies.Couple) {
return true;
}else if ( o instanceof imdb.movies.Actress) {
return true;
}else if ( o instanceof imdb.movies.Clique) {
return true;
} else { return false;
}}}