package a2l.tests.findcouples.lintra;

import lintra2.blackboard.IdentifiableElement;
import lintra2.blackboard.IArea;
import lintra2.blackboard.BlackboardException;
import lintra2.transfo.ITransformation;
import lintra2.transfo.IMaster;
import lintra2.transfo.TraceFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import imdb.movies.Person;
import imdb.movies.Couple;
import imdb.movies.Movie;
import imdb.movies.MovieType;
import imdb.movies.Actor;
import imdb.movies.Actress;

public class FindCouplesIMDb implements ITransformation, lintra2.transfo.ITransformation2{
private IArea _area_IN;
	private IArea _area_OUT;IArea trgArea, cachingArea;public FindCouplesIMDb(IArea _area_IN,IArea _area_OUT, IArea cachingArea) {
this._area_IN = _area_IN;
this._area_OUT = _area_OUT;
 this.cachingArea = cachingArea; }protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }
protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { javaslang.collection.List<T> IN = javaslang.collection.List.ofAll(_area_IN.read(_area_IN.size() + 1)).  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
javaslang.collection.List<T> result = javaslang.collection.List.empty();
result = result.appendAll(IN);return result;

}
 private javaslang.collection.List<Object> flatten(Iterable<?> l) { 	ArrayList<Object> r = new ArrayList<Object>();   addFlatten(r, l);    return javaslang.collection.List.ofAll(r);  } private void addFlatten(ArrayList<Object> r, Iterable<?> l) {    for(Object x : l) {      if ( x instanceof Iterable ) { 	    addFlatten(r, (Iterable<?>) x);      } else { 	    r.add(x);      }   } } private javaslang.collection.Set<Object> flattenSet(Iterable<?> l) {  	javaslang.collection.Set<Object> r = javaslang.collection.HashSet.empty(); 	for (Object object : l) { 		if ( object instanceof Iterable ) { 			r = r.addAll(flattenSet((Iterable<Object>) object)); 		} else { 			r = r.add(object); 		} 	} 	return r; }
protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString(); }

Collection<org.eclipse.emf.ecore.EObject> rootOfOUT = java.util.Collections.synchronizedList(new ArrayList<org.eclipse.emf.ecore.EObject>());public void postprocessing() throws BlackboardException { for (IPendingTask tasks : pendingTasks) {			tasks.execute();}
// TODO: Pass the number of threads explicitly to postprocessing
java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(8);final Collection objects_OUT = _area_OUT.read(_area_OUT.size());try { myPool.submit(() -> {objects_OUT.parallelStream().forEach(object -> {		org.eclipse.emf.ecore.EObject obj = (org.eclipse.emf.ecore.EObject) object;		if (obj.eContainer() == null) {			rootOfOUT.add(obj);		}  });}).get();} catch (InterruptedException | java.util.concurrent.ExecutionException e) { throw new RuntimeException(e); }}
public void writeOUT(org.eclipse.emf.ecore.resource.Resource r) {   for(org.eclipse.emf.ecore.EObject o : rootOfOUT) {      r.getContents().add(o);   }}
private java.util.concurrent.ConcurrentLinkedQueue<IPendingTask> pendingTasks = new java.util.concurrent.ConcurrentLinkedQueue<>();interface IPendingTask { public void execute() throws BlackboardException; }
class PendingTask_Movie_persons implements IPendingTask { 
private final imdb.movies.Movie tgt;
private final Collection<String> objId;
private final IArea area;
public PendingTask_Movie_persons(imdb.movies.Movie tgt, Collection<String> objId, IArea area) {
	this.tgt = tgt; this.objId = objId; this.area = area;
}
public PendingTask_Movie_persons(imdb.movies.Movie tgt, String objId, IArea area) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area;
}
public void execute() throws BlackboardException  {
tgt.getPersons().addAll((Collection<imdb.movies.Person>)area.readAll(objId));}
}

class PendingTask_Person_movies implements IPendingTask { 
private final imdb.movies.Person tgt;
private final Collection<String> objId;
private final IArea area;
public PendingTask_Person_movies(imdb.movies.Person tgt, Collection<String> objId, IArea area) {
	this.tgt = tgt; this.objId = objId; this.area = area;
}
public PendingTask_Person_movies(imdb.movies.Person tgt, String objId, IArea area) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area;
}
public void execute() throws BlackboardException  {
tgt.getMovies().addAll((Collection<imdb.movies.Movie>)area.readAll(objId));}
}

class PendingTask_Couple_p1 implements IPendingTask { 
private final imdb.movies.Couple tgt;
private final String objId;
private final IArea area;
public PendingTask_Couple_p1(imdb.movies.Couple tgt, String objId, IArea area) {
	this.tgt = tgt; this.objId = objId; this.area = area;
}
public void execute() throws BlackboardException  {
tgt.setP1((imdb.movies.Person)area.read(objId));}
}

class PendingTask_Couple_p2 implements IPendingTask { 
private final imdb.movies.Couple tgt;
private final String objId;
private final IArea area;
public PendingTask_Couple_p2(imdb.movies.Couple tgt, String objId, IArea area) {
	this.tgt = tgt; this.objId = objId; this.area = area;
}
public void execute() throws BlackboardException  {
tgt.setP2((imdb.movies.Person)area.read(objId));}
}
public boolean check_movie(java.lang.Object m1) throws BlackboardException{
return m1 instanceof imdb.movies.Movie;
}
	public boolean check_actor(java.lang.Object p1) throws BlackboardException{
return p1 instanceof imdb.movies.Actor;
}
	public boolean check_actress(java.lang.Object p1) throws BlackboardException{
return p1 instanceof imdb.movies.Actress;
}
	public Couple called_rule_createCouple(Person person1, Person person2) throws BlackboardException{
Couple c0;c0 = imdb.movies.MoviesFactory.eINSTANCE.createCouple();

	_area_OUT.getIdMapper().addMapping(c0,TraceFunction.createUniqueId("createCouple"));

	boolean matched0 = false;if ( check_actress( person1) )  {
this.pendingTasks.add( new PendingTask_Couple_p1(c0,TraceFunction.resolve(_area_IN.getIdMapper().getId(person1), 0, "actress"),_area_OUT) );
}
else if ( check_actor( person1) )  {
this.pendingTasks.add( new PendingTask_Couple_p1(c0,TraceFunction.resolve(_area_IN.getIdMapper().getId(person1), 0, "actor"),_area_OUT) );
}

	boolean matched1 = false;if ( check_actress( person2) )  {
this.pendingTasks.add( new PendingTask_Couple_p2(c0,TraceFunction.resolve(_area_IN.getIdMapper().getId(person2), 0, "actress"),_area_OUT) );
}
else if ( check_actor( person2) )  {
this.pendingTasks.add( new PendingTask_Couple_p2(c0,TraceFunction.resolve(_area_IN.getIdMapper().getId(person2), 0, "actor"),_area_OUT) );
}

	_area_OUT.write(c0);

	return c0;
}
	public javaslang.collection.Set<Person> helper_global_coactor(Person p1) throws BlackboardException{
List<Movie> get2;
List<Person> get3;
List<Person> r4;
javaslang.collection.Set<Person> op5;/* 25:55-25:108: p1.movies.<IteratorChain>[collect-flatten]->asSet()*/
	/* 25:55-25:64: p1.movies*/
	get2 = p1.getMovies();

	r4 = new java.util.ArrayList();

	for ( Movie m1: get2) {
/* 25:78-25:87: m.persons*/
	get3 = m1.getPersons();

	r4.addAll(get3);}
	op5 = javaslang.collection.HashSet.ofAll(r4);

	return op5;
}
	public boolean helper_global_areCouple(Person p1, Person p2) throws BlackboardException{
javaslang.collection.Set<Movie> get6;
javaslang.collection.Set<Movie> get7;
javaslang.collection.Set<Movie> op8;
int op9;
int tmp10;
boolean tmp11;/* 27:64-27:126: p1<NavRefAsSet>.movies->intersection(p2<NavRefAsSet>.movies)->size()*/
	/* 27:65-27:117: p1<NavRefAsSet>.movies->intersection(p2<NavRefAsSet>.movies)*/
	/* null: p1<NavRefAsSet>.movies*/
	get6 = javaslang.collection.HashSet.ofAll(p1.getMovies());

	/* null: p2<NavRefAsSet>.movies*/
	get7 = javaslang.collection.HashSet.ofAll(p2.getMovies());

	op8 = get6.intersect(get7);

	op9 = op8.size();

	tmp10 = 3;

	tmp11 = op9 > tmp10;

	return tmp11;
}
	public boolean isTargetElement(java.lang.Object obj){
if ( obj == null ) return false;;

	return _area_OUT.getIdMapper().belongsTo(obj);
}
	public lintra2.blackboard.IdMapper findDriverDynamically(java.lang.Object obj){
if ( _area_IN.getIdMapper().belongsTo(obj)) return _area_IN.getIdMapper(); 
 if ( _area_OUT.getIdMapper().belongsTo(obj)) return _area_OUT.getIdMapper();
throw new IllegalStateException();
}
	public void create_movie(Movie m1) throws BlackboardException{
Movie m212;
java.lang.String get13;
double get14;
MovieType get15;
int get16;
List<Person> get17;
List<java.lang.String> itTmp18;m212 = imdb.movies.MoviesFactory.eINSTANCE.createMovie();

	_area_OUT.getIdMapper().addMapping(m212,TraceFunction.create(_area_IN.getIdMapper().getId(m1), 0,"movie"));

	/* 34:13-34:21: m1.title*/
	get13 = m1.getTitle();

	/* 35:14-35:23: m1.rating*/
	get14 = m1.getRating();

	/* 36:12-36:19: m1.type*/
	get15 = m1.getType();

	/* 37:12-37:19: m1.year*/
	get16 = m1.getYear();

	/* 38:15-38:25: m1.persons*/
	get17 = m1.getPersons();

	m212.setTitle(get13);;

	m212.setRating(get14);;

	m212.setType(get15);;

	m212.setYear(get16);;

	itTmp18 = new ArrayList<String>();

	for ( java.lang.Object o: get17) {
boolean matched2 = false;if ( check_actress( o) )  {
itTmp18.add(TraceFunction.resolve(_area_IN.getIdMapper().getId(o), 0, "actress"));
}
else if ( check_actor( o) )  {
itTmp18.add(TraceFunction.resolve(_area_IN.getIdMapper().getId(o), 0, "actor"));
}
}
	this.pendingTasks.add( new PendingTask_Movie_persons(m212,itTmp18,_area_OUT) );

	_area_OUT.write(m212);
}
	public void create_actor(Actor p1) throws BlackboardException{
Actor p219;
java.lang.String get20;
List<Movie> get21;
javaslang.collection.Set<Person> call23;
boolean call24;
java.lang.String get25;
java.lang.String get26;
int op27;
int tmp28;
boolean tmp29;
boolean tmp30;
Couple call31;
List<java.lang.String> itTmp32;p219 = imdb.movies.MoviesFactory.eINSTANCE.createActor();

	_area_OUT.getIdMapper().addMapping(p219,TraceFunction.create(_area_IN.getIdMapper().getId(p1), 0,"actor"));

	/* 47:12-47:19: p1.name*/
	get20 = p1.getName();

	/* 48:14-48:23: p1.movies*/
	get21 = p1.getMovies();

	p219.setName(get20);;

	itTmp32 = new ArrayList<String>();

	for ( java.lang.Object o: get21) {
boolean matched3 = false;if ( check_movie( o) )  {
itTmp32.add(TraceFunction.resolve(_area_IN.getIdMapper().getId(o), 0, "movie"));
}
}
	this.pendingTasks.add( new PendingTask_Person_movies(p219,itTmp32,_area_OUT) );

	/* 51:3-55:4: for (coauthor in thisModule.coactor(p1)) {
if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); } }}*/
	/* 51:20-51:42: thisModule.coactor(p1)*/
	call23 = helper_global_coactor(p1);

	for ( Person coauthor22: call23) {
/* 52:4-54:5: if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); }*/
	/* 52:8-52:42: thisModule.areCouple(p1, coauthor)*/
	call24 = helper_global_areCouple(p1,coauthor22);

	/* 52:47-52:79: p1.name.compareTo(coauthor.name)*/
	/* 52:47-52:54: p1.name*/
	get25 = p1.getName();

	/* 52:65-52:78: coauthor.name*/
	get26 = coauthor22.getName();

	op27 = get25.compareTo(get26);

	tmp28 = 0;

	tmp29 = op27 < tmp28;

	tmp30 = call24 && tmp29;

	if ( tmp30) {
/* 53:5-53:43: thisModule.createCouple(p1, coauthor);*/
	/* 53:5-53:42: thisModule.createCouple(p1, coauthor)*/
	call31 = called_rule_createCouple(p1,coauthor22);
}}
	_area_OUT.write(p219);
}
	public void create_actress(Actress p1) throws BlackboardException{
Actress p233;
java.lang.String get34;
List<Movie> get35;
javaslang.collection.Set<Person> call37;
boolean call38;
java.lang.String get39;
java.lang.String get40;
int op41;
int tmp42;
boolean tmp43;
boolean tmp44;
Couple call45;
List<java.lang.String> itTmp46;p233 = imdb.movies.MoviesFactory.eINSTANCE.createActress();

	_area_OUT.getIdMapper().addMapping(p233,TraceFunction.create(_area_IN.getIdMapper().getId(p1), 0,"actress"));

	/* 64:12-64:19: p1.name*/
	get34 = p1.getName();

	/* 65:14-65:23: p1.movies*/
	get35 = p1.getMovies();

	p233.setName(get34);;

	itTmp46 = new ArrayList<String>();

	for ( java.lang.Object o: get35) {
boolean matched4 = false;if ( check_movie( o) )  {
itTmp46.add(TraceFunction.resolve(_area_IN.getIdMapper().getId(o), 0, "movie"));
}
}
	this.pendingTasks.add( new PendingTask_Person_movies(p233,itTmp46,_area_OUT) );

	/* 68:3-72:4: for (coauthor in thisModule.coactor(p1)) {
if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); } }}*/
	/* 68:20-68:42: thisModule.coactor(p1)*/
	call37 = helper_global_coactor(p1);

	for ( Person coauthor36: call37) {
/* 69:4-71:5: if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); }*/
	/* 69:8-69:42: thisModule.areCouple(p1, coauthor)*/
	call38 = helper_global_areCouple(p1,coauthor36);

	/* 69:48-69:80: p1.name.compareTo(coauthor.name)*/
	/* 69:48-69:55: p1.name*/
	get39 = p1.getName();

	/* 69:66-69:79: coauthor.name*/
	get40 = coauthor36.getName();

	op41 = get39.compareTo(get40);

	tmp42 = 0;

	tmp43 = op41 < tmp42;

	tmp44 = call38 && tmp43;

	if ( tmp44) {
/* 70:5-70:43: thisModule.createCouple(p1, coauthor);*/
	/* 70:5-70:42: thisModule.createCouple(p1, coauthor)*/
	call45 = called_rule_createCouple(p1,coauthor36);
}}
	_area_OUT.write(p233);
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched5 = false;if ( check_movie( e) )  {
create_movie((imdb.movies.Movie)e);
}
else if ( check_actor( e) )  {
create_actor((imdb.movies.Actor)e);
}
else if ( check_actress( e) )  {
create_actress((imdb.movies.Actress)e);
}
}}