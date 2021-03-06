package a2l.tests.findcouples.optimised;

import lintra2.blackboard.IdentifiableElement;
import lintra2.blackboard.IArea;
import lintra2.blackboard.BlackboardException;
import lintra2.transfo.ITransformation;
import lintra2.transfo.IMaster;
import lintra2.transfo.TraceFunction;
import a2l.runtime.IModel;
import a2l.runtime.IModel.IOutputModel;
import a2l.runtime.PartialOutputModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import imdb.movies.Person;
import imdb.movies.Movie;
import imdb.movies.Couple;
import imdb.movies.MovieType;
import imdb.movies.Actor;
import imdb.movies.Actress;

public class FindCouplesIMDb implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.findcouples.optimised.FindCouplesIMDbGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public FindCouplesIMDb(a2l.runtime.InputExtent inputExtent,a2l.tests.findcouples.optimised.FindCouplesIMDbGlobalContext global) {
this.inputExtent = inputExtent;
this.globalContext = global;
this.OUTModel_PartialOutput_ = new PartialOutputModel();
this.trace = global.createPartialTrace();; }protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }
protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) { javaslang.collection.List<T> list_result = globalContext.getFromAllInstancesCache(klass, () -> {javaslang.collection.List<T> IN = javaslang.collection.List.ofAll(INModel_.allInstances()).  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
javaslang.collection.List<T> result = javaslang.collection.List.empty();
result = result.appendAll(IN);return result;

});return list_result;}
 private javaslang.collection.List<Object> flatten(Iterable<?> l) { 	ArrayList<Object> r = new ArrayList<Object>();   addFlatten(r, l);    return javaslang.collection.List.ofAll(r);  } private void addFlatten(ArrayList<Object> r, Iterable<?> l) {    for(Object x : l) {      if ( x instanceof Iterable ) { 	    addFlatten(r, (Iterable<?>) x);      } else { 	    r.add(x);      }   } } private javaslang.collection.Set<Object> flattenSet(Iterable<?> l) {  	javaslang.collection.Set<Object> r = javaslang.collection.HashSet.empty(); 	for (Object object : l) { 		if ( object instanceof Iterable ) { 			r = r.addAll(flattenSet((Iterable<Object>) object)); 		} else { 			r = r.add(object); 		} 	} 	return r; }public int getNumExecutions() { return numExecutions_; }
public int getNumMatchedRuleExecutions() { return numMatchedRuleExecutions_; }
public static class TransformationResult { }
protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString(); }

@Override public void doSequentialPostprocessing() {   for (IPendingTask tasks : pendingTasks) {			tasks.execute(this.globalContext.getGlobalTrace());  }}
@Override public void doPostprocessing() { doSequentialPostprocessing(); doParallelPostprocessing(); }
@Override public void doParallelPostprocessing() { 
  for (IPendingTask tasks : parallelPendingTasks) {			tasks.execute(this.globalContext.getGlobalTrace());  }}
@Override public void doSequentialCleanup() { 
final Collection<? extends org.eclipse.emf.ecore.EObject> objects_OUT = (Collection<? extends org.eclipse.emf.ecore.EObject>)OUTModel_PartialOutput_.allInstances();for(org.eclipse.emf.ecore.EObject obj : objects_OUT) {		if (obj.eContainer() == null) {			OUTModel_.add(obj);		}}}

private java.util.ArrayList<IPendingTask> pendingTasks = new java.util.ArrayList<>();private java.util.ArrayList<IPendingTask> parallelPendingTasks = new java.util.ArrayList<>();interface IPendingTask { public void execute(a2l.runtime.GlobalTrace globalTrace); }
private static final class PendingTask_Movie_persons implements IPendingTask { 
private final imdb.movies.Movie tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Movie_persons(imdb.movies.Movie tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_Movie_persons(imdb.movies.Movie tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof imdb.movies.Person) { result.add(tgt); }}
tgt.getPersons().addAll((Collection<? extends imdb.movies.Person>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof imdb.movies.Person) { result.add(tgt); }   }}tgt.getPersons().addAll((Collection<? extends imdb.movies.Person>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Person_movies implements IPendingTask { 
private final imdb.movies.Person tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Person_movies(imdb.movies.Person tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_Person_movies(imdb.movies.Person tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof imdb.movies.Movie) { result.add(tgt); }}
tgt.getMovies().addAll((Collection<? extends imdb.movies.Movie>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof imdb.movies.Movie) { result.add(tgt); }   }}tgt.getMovies().addAll((Collection<? extends imdb.movies.Movie>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Couple_p1 implements IPendingTask { 
private final imdb.movies.Couple tgt;
private final Object objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Couple_p1(imdb.movies.Couple tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems != null && tgtElems.contains(objId)) { tgt.setP1((imdb.movies.Person)getTargetResolveTempOrSame(objId, globalTrace)); } else {tgt.setP1((imdb.movies.Person)getTrace(objId, globalTrace));}}
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Couple_p2 implements IPendingTask { 
private final imdb.movies.Couple tgt;
private final Object objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Couple_p2(imdb.movies.Couple tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems != null && tgtElems.contains(objId)) { tgt.setP2((imdb.movies.Person)getTargetResolveTempOrSame(objId, globalTrace)); } else {tgt.setP2((imdb.movies.Person)getTrace(objId, globalTrace));}}
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private boolean check_movie(java.lang.Object m1){
return m1 instanceof imdb.movies.Movie;
}
	private boolean check_actor(java.lang.Object p1){
return p1 instanceof imdb.movies.Actor;
}
	private boolean check_actress(java.lang.Object p1){
return p1 instanceof imdb.movies.Actress;
}
	public Couple called_rule_createCouple(Person person1, Person person2){
Couple c0;c0 = imdb.movies.MoviesFactory.eINSTANCE.createCouple();

	OUTModel_PartialOutput_.write(c0);

	boolean matched0 = false;if ( check_actress( person1) )  {
this.parallelPendingTasks.add( new PendingTask_Couple_p1(c0,person1,OUTModel_, null) );
}
else if ( check_actor( person1) )  {
this.parallelPendingTasks.add( new PendingTask_Couple_p1(c0,person1,OUTModel_, null) );
}

	boolean matched1 = false;if ( check_actress( person2) )  {
this.parallelPendingTasks.add( new PendingTask_Couple_p2(c0,person2,OUTModel_, null) );
}
else if ( check_actor( person2) )  {
this.parallelPendingTasks.add( new PendingTask_Couple_p2(c0,person2,OUTModel_, null) );
}

	return c0;
}
	public javaslang.collection.Set<Person> helper_global_coactor(Person p1){
List<Movie> get2;
List<Person> get3;
List<Person> r4;
javaslang.collection.Set<Person> op5;/* 23:55-23:108: p1.movies.<IteratorChain>[collect-flatten]->asSet()*/
	/* 23:55-23:64: p1.movies*/
	get2 = new a2l.runtime.stdlib.FastIterableList<imdb.movies.Movie>(p1.getMovies());

	r4 = new java.util.ArrayList();

	for ( Movie m1: get2) {
/* 23:78-23:87: m.persons*/
	get3 = new a2l.runtime.stdlib.FastIterableList<imdb.movies.Person>(m1.getPersons());

	r4.addAll(get3);}
	op5 = javaslang.collection.HashSet.ofAll(r4);

	return op5;
}
	public boolean helper_global_areCouple(Person p1, Person p2){
javaslang.collection.Set<Movie> get6;
javaslang.collection.Set<Movie> get7;
javaslang.collection.Set<Movie> op8;
int op9;
int tmp10;
boolean tmp11;/* 25:64-25:126: p1<NavRefAsSet>.movies->intersection(p2<NavRefAsSet>.movies)->size()*/
	/* 25:65-25:117: p1<NavRefAsSet>.movies->intersection(p2<NavRefAsSet>.movies)*/
	get6 = this.globalContext.getcache0_p1(p1, () -> { 
/* null: p1<NavRefAsSet>.movies*/
return javaslang.collection.HashSet.ofAll(new a2l.runtime.stdlib.FastIterableList<imdb.movies.Movie>(p1.getMovies()));
});

	get7 = this.globalContext.getcache1_p2(p2, () -> { 
/* null: p2<NavRefAsSet>.movies*/
return javaslang.collection.HashSet.ofAll(new a2l.runtime.stdlib.FastIterableList<imdb.movies.Movie>(p2.getMovies()));
});

	op8 = get6.intersect(get7);

	op9 = op8.size();

	tmp10 = 3;

	tmp11 = op9 > tmp10;

	return tmp11;
}
	public boolean isTargetElement(java.lang.Object obj){
if ( obj == null ) return false;;

	if ( obj instanceof a2l.runtime.ResolveTempObject ) return true;;

	return OUTModel_PartialOutput_.belongsTo(obj);
}
	public IModel findModelDynamically(java.lang.Object obj){
if ( INModel_.belongsTo(obj)) return INModel_; 
 if ( OUTModel_.belongsTo(obj)) return OUTModel_;
throw new IllegalStateException();
}
	public a2l.tests.findcouples.optimised.FindCouplesIMDb setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.findcouples.optimised.FindCouplesIMDb setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_movie(Movie m1){
Movie m212;
java.lang.String get13;
double get14;
MovieType get15;
int get16;
List<Person> get17;
List<java.lang.Object> itTmp18;m212 = imdb.movies.MoviesFactory.eINSTANCE.createMovie();

	this.trace.put(m1,m212);

	OUTModel_PartialOutput_.write(m212);

	/* 32:13-32:21: m1.title*/
	get13 = m1.getTitle();

	/* 33:14-33:23: m1.rating*/
	get14 = m1.getRating();

	/* 34:12-34:19: m1.type*/
	get15 = m1.getType();

	/* 35:12-35:19: m1.year*/
	get16 = m1.getYear();

	/* 36:15-36:25: m1.persons*/
	get17 = new a2l.runtime.stdlib.FastIterableList<imdb.movies.Person>(m1.getPersons());

	m212.setTitle(get13);;

	m212.setRating(get14);;

	m212.setType(get15);;

	m212.setYear(get16);;

	itTmp18 = new ArrayList<Object>(get17.size());

	for ( java.lang.Object o: get17) {
boolean matched2 = false;if ( check_actress( o) )  {
itTmp18.add(o);
}
else if ( check_actor( o) )  {
itTmp18.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Movie_persons(m212,itTmp18,OUTModel_,null) );

	numMatchedRuleExecutions_++;
}
	private void create_actor(Actor p1){
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
boolean tmp31;
Couple call32;
List<java.lang.Object> itTmp33;p219 = imdb.movies.MoviesFactory.eINSTANCE.createActor();

	this.trace.put(p1,p219);

	OUTModel_PartialOutput_.write(p219);

	/* 45:12-45:19: p1.name*/
	get20 = p1.getName();

	/* 46:14-46:23: p1.movies*/
	get21 = new a2l.runtime.stdlib.FastIterableList<imdb.movies.Movie>(p1.getMovies());

	p219.setName(get20);;

	itTmp33 = new ArrayList<Object>(get21.size());

	for ( java.lang.Object o: get21) {
boolean matched3 = false;if ( check_movie( o) )  {
itTmp33.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Person_movies(p219,itTmp33,OUTModel_,null) );

	/* 49:3-53:4: for (coauthor in thisModule.coactor(p1)) {
if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); } }}*/
	/* 49:20-49:42: thisModule.coactor(p1)*/
	call23 = helper_global_coactor(p1);

	for ( Person coauthor22: call23) {
/* 50:4-52:5: if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); }*/
	/* 50:8-50:42: thisModule.areCouple(p1, coauthor)*/
	call24 = helper_global_areCouple(p1,coauthor22);

	/* 50:47-50:79: p1.name.compareTo(coauthor.name)*/
	/* 50:47-50:54: p1.name*/
	get25 = p1.getName();

	/* 50:65-50:78: coauthor.name*/
	get26 = coauthor22.getName();

	op27 = get25.compareTo(get26);

	tmp28 = 0;

	tmp29 = op27 < tmp28;

	tmp31 = call24 && tmp29;

	if ( tmp31) {
/* 51:5-51:43: thisModule.createCouple(p1, coauthor);*/
	/* 51:5-51:42: thisModule.createCouple(p1, coauthor)*/
	call32 = called_rule_createCouple(p1,coauthor22);
}}
	numMatchedRuleExecutions_++;
}
	private void create_actress(Actress p1){
Actress p234;
java.lang.String get35;
List<Movie> get36;
javaslang.collection.Set<Person> call38;
boolean call39;
java.lang.String get40;
java.lang.String get41;
int op42;
int tmp43;
boolean tmp44;
boolean tmp45;
boolean tmp46;
Couple call47;
List<java.lang.Object> itTmp48;p234 = imdb.movies.MoviesFactory.eINSTANCE.createActress();

	this.trace.put(p1,p234);

	OUTModel_PartialOutput_.write(p234);

	/* 62:12-62:19: p1.name*/
	get35 = p1.getName();

	/* 63:14-63:23: p1.movies*/
	get36 = new a2l.runtime.stdlib.FastIterableList<imdb.movies.Movie>(p1.getMovies());

	p234.setName(get35);;

	itTmp48 = new ArrayList<Object>(get36.size());

	for ( java.lang.Object o: get36) {
boolean matched4 = false;if ( check_movie( o) )  {
itTmp48.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Person_movies(p234,itTmp48,OUTModel_,null) );

	/* 66:3-70:4: for (coauthor in thisModule.coactor(p1)) {
if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); } }}*/
	/* 66:20-66:42: thisModule.coactor(p1)*/
	call38 = helper_global_coactor(p1);

	for ( Person coauthor37: call38) {
/* 67:4-69:5: if ( thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 ) {
   thisModule.createCouple(p1, coauthor); }*/
	/* 67:8-67:42: thisModule.areCouple(p1, coauthor)*/
	call39 = helper_global_areCouple(p1,coauthor37);

	/* 67:48-67:80: p1.name.compareTo(coauthor.name)*/
	/* 67:48-67:55: p1.name*/
	get40 = p1.getName();

	/* 67:66-67:79: coauthor.name*/
	get41 = coauthor37.getName();

	op42 = get40.compareTo(get41);

	tmp43 = 0;

	tmp44 = op42 < tmp43;

	tmp46 = call39 && tmp44;

	if ( tmp46) {
/* 68:5-68:43: thisModule.createCouple(p1, coauthor);*/
	/* 68:5-68:42: thisModule.createCouple(p1, coauthor)*/
	call47 = called_rule_createCouple(p1,coauthor37);
}}
	numMatchedRuleExecutions_++;
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

	numExecutions_++;
}}