package a2l.tests.findcouples.normal;

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
import imdb.movies.Couple;
import imdb.movies.Movie;
import imdb.movies.MovieType;
import imdb.movies.Actor;
import imdb.movies.Actress;

public class FindCouplesIMDb implements ITransformation, lintra2.transfo.ITransformation2 {
	private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;
	a2l.runtime.InputExtent inputExtent;
	a2l.tests.findcouples.normal.FindCouplesIMDbGlobalContext globalContext;
	a2l.runtime.GlobalTrace.PartialTrace trace = null;

	public FindCouplesIMDb(a2l.runtime.InputExtent inputExtent,
			a2l.tests.findcouples.normal.FindCouplesIMDbGlobalContext global) {
		this.inputExtent = inputExtent;
		this.globalContext = global;
		this.OUTModel_PartialOutput_ = new PartialOutputModel();
		this.trace = global.createPartialTrace();
		;
	}

	protected List<String> toList(String[] strings) {
		return java.util.Arrays.asList(strings);
	}

	protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException {
		javaslang.collection.List<T> list_result = globalContext.getFromAllInstancesCache(klass, () -> {
			javaslang.collection.List<T> IN = javaslang.collection.List.ofAll(INModel_.allInstances())
					.filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
			javaslang.collection.List<T> result = javaslang.collection.List.empty();
			result = result.appendAll(IN);
			return result;

		});
		return list_result;
	}

	private javaslang.collection.List<Object> flatten(Iterable<?> l) {
		ArrayList<Object> r = new ArrayList<Object>();
		addFlatten(r, l);
		return javaslang.collection.List.ofAll(r);
	}

	private void addFlatten(ArrayList<Object> r, Iterable<?> l) {
		for (Object x : l) {
			if (x instanceof Iterable) {
				addFlatten(r, (Iterable<?>) x);
			} else {
				r.add(x);
			}
		}
	}

	private javaslang.collection.Set<Object> flattenSet(Iterable<?> l) {
		javaslang.collection.Set<Object> r = javaslang.collection.HashSet.empty();
		for (Object object : l) {
			if (object instanceof Iterable) {
				r = r.addAll(flattenSet((Iterable<Object>) object));
			} else {
				r = r.add(object);
			}
		}
		return r;
	}

	public static class TransformationResult {
	}

	protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) {
		return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString();
	}

	@Override
	public void doSequentialPostprocessing() {
		for (IPendingTask tasks : pendingTasks) {
			tasks.execute(this.globalContext.getGlobalTrace());
		}
	}

	@Override
	public void doPostprocessing() {
		doSequentialPostprocessing();
		doParallelPostprocessing();
	}

	@Override
	public void doParallelPostprocessing() {
		for (IPendingTask tasks : parallelPendingTasks) {
			tasks.execute(this.globalContext.getGlobalTrace());
		}
		final Collection<? extends org.eclipse.emf.ecore.EObject> objects_OUT = (Collection<? extends org.eclipse.emf.ecore.EObject>) OUTModel_PartialOutput_
				.allInstances();
		for (org.eclipse.emf.ecore.EObject obj : objects_OUT) {
			if (obj.eContainer() == null) {
				synchronized (OUTModel_) {
					OUTModel_.add(obj);
				}
			}
		}
	}

	private java.util.ArrayList<IPendingTask> pendingTasks = new java.util.ArrayList<>();
	private java.util.ArrayList<IPendingTask> parallelPendingTasks = new java.util.ArrayList<>();

	interface IPendingTask {
		public void execute(a2l.runtime.GlobalTrace globalTrace);
	}

	final class PendingTask_Movie_persons implements IPendingTask {
		private final imdb.movies.Movie tgt;
		private final Collection<Object> objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Movie_persons(imdb.movies.Movie tgt, Collection<Object> objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public PendingTask_Movie_persons(imdb.movies.Movie tgt, Object objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = java.util.Collections.singletonList(objId);
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public void execute(a2l.runtime.GlobalTrace globalTrace) {
			if (tgtElems == null) {
				ArrayList<Object> result = new ArrayList<>(objId.size());
				for (Object object : objId) {
					Object tgt = getTrace(object, globalTrace);
					if (tgt instanceof imdb.movies.Person) {
						result.add(tgt);
					}
				}
				tgt.getPersons().addAll((Collection<? extends imdb.movies.Person>) result);
			} else {
				ArrayList<Object> result = new ArrayList<>(objId.size());
				for (Object object : objId) {
					if (tgtElems.contains(object)) {
						result.add(getTargetResolveTempOrSame(object, globalTrace));
					} else {
						Object tgt = getTrace(object, globalTrace);
						if (tgt instanceof imdb.movies.Person) {
							result.add(tgt);
						}
					}
				}
				tgt.getPersons().addAll((Collection<? extends imdb.movies.Person>) result);
			}
		}

		private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) {
			return globalTrace.get(object);
		}

		private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {
			if (object instanceof a2l.runtime.ResolveTempObject) {
				a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;
				return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());
			}
			return object;
		}
	}

	final class PendingTask_Person_movies implements IPendingTask {
		private final imdb.movies.Person tgt;
		private final Collection<Object> objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Person_movies(imdb.movies.Person tgt, Collection<Object> objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public PendingTask_Person_movies(imdb.movies.Person tgt, Object objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = java.util.Collections.singletonList(objId);
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public void execute(a2l.runtime.GlobalTrace globalTrace) {
			if (tgtElems == null) {
				ArrayList<Object> result = new ArrayList<>(objId.size());
				for (Object object : objId) {
					Object tgt = getTrace(object, globalTrace);
					if (tgt instanceof imdb.movies.Movie) {
						result.add(tgt);
					}
				}
				tgt.getMovies().addAll((Collection<? extends imdb.movies.Movie>) result);
			} else {
				ArrayList<Object> result = new ArrayList<>(objId.size());
				for (Object object : objId) {
					if (tgtElems.contains(object)) {
						result.add(getTargetResolveTempOrSame(object, globalTrace));
					} else {
						Object tgt = getTrace(object, globalTrace);
						if (tgt instanceof imdb.movies.Movie) {
							result.add(tgt);
						}
					}
				}
				tgt.getMovies().addAll((Collection<? extends imdb.movies.Movie>) result);
			}
		}

		private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) {
			return globalTrace.get(object);
		}

		private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {
			if (object instanceof a2l.runtime.ResolveTempObject) {
				a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;
				return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());
			}
			return object;
		}
	}

	final class PendingTask_Couple_p1 implements IPendingTask {
		private final imdb.movies.Couple tgt;
		private final Object objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Couple_p1(imdb.movies.Couple tgt, Object objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public void execute(a2l.runtime.GlobalTrace globalTrace) {
			if (tgtElems != null && tgtElems.contains(objId)) {
				tgt.setP1((imdb.movies.Person) getTargetResolveTempOrSame(objId, globalTrace));
			} else {
				tgt.setP1((imdb.movies.Person) getTrace(objId, globalTrace));
			}
		}

		private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) {
			return globalTrace.get(object);
		}

		private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {
			if (object instanceof a2l.runtime.ResolveTempObject) {
				a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;
				return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());
			}
			return object;
		}
	}

	final class PendingTask_Couple_p2 implements IPendingTask {
		private final imdb.movies.Couple tgt;
		private final Object objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Couple_p2(imdb.movies.Couple tgt, Object objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public void execute(a2l.runtime.GlobalTrace globalTrace) {
			if (tgtElems != null && tgtElems.contains(objId)) {
				tgt.setP2((imdb.movies.Person) getTargetResolveTempOrSame(objId, globalTrace));
			} else {
				tgt.setP2((imdb.movies.Person) getTrace(objId, globalTrace));
			}
		}

		private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) {
			return globalTrace.get(object);
		}

		private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {
			if (object instanceof a2l.runtime.ResolveTempObject) {
				a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;
				return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());
			}
			return object;
		}
	}

	public boolean check_movie(java.lang.Object m1) throws BlackboardException {
		return m1 instanceof imdb.movies.Movie;
	}

	public boolean check_actor(java.lang.Object p1) throws BlackboardException {
		return p1 instanceof imdb.movies.Actor;
	}

	public boolean check_actress(java.lang.Object p1) throws BlackboardException {
		return p1 instanceof imdb.movies.Actress;
	}

	public Couple called_rule_createCouple(Person person1, Person person2) throws BlackboardException {
		Couple c0;
		c0 = imdb.movies.MoviesFactory.eINSTANCE.createCouple();

		OUTModel_PartialOutput_.write(c0);

		boolean matched0 = false;
		if (check_actor(person1)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p1(c0, person1, OUTModel_, null));
		} else if (check_actress(person1)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p1(c0, person1, OUTModel_, null));
		}

		boolean matched1 = false;
		if (check_actor(person2)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p2(c0, person2, OUTModel_, null));
		} else if (check_actress(person2)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p2(c0, person2, OUTModel_, null));
		}

		return c0;
	}

	public javaslang.collection.Set<Person> helper_global_coactor(Person p1) throws BlackboardException {
		javaslang.collection.List<Movie> get2;
		javaslang.collection.List<Person> get3;
		javaslang.collection.List<javaslang.collection.List<Person>> r4;
		javaslang.collection.List<Person> op5;
		javaslang.collection.Set<Person> op6;/* 23:55-23:108: p1.movies->collect(m | m.persons)->flatten()->asSet() */
		/* 23:55-23:99: p1.movies->collect(m | m.persons)->flatten() */
		/* 23:55-23:88: p1.movies->collect(m | m.persons) */
		/* 23:55-23:64: p1.movies */
		get2 = javaslang.collection.List.ofAll(p1.getMovies());

		r4 = javaslang.collection.List.empty();

		for (Movie m1 : get2) {
			/* 23:78-23:87: m.persons */
			get3 = javaslang.collection.List.ofAll(m1.getPersons());

			r4 = r4.append(get3);
		}
		op5 = flatten(r4).map(x_ -> (imdb.movies.Person) x_);

		op6 = javaslang.collection.HashSet.ofAll(op5);

		return op6;
	}

	public boolean helper_global_areCouple(Person p1, Person p2) throws BlackboardException {
		javaslang.collection.List<Movie> get7;
		javaslang.collection.Set<Movie> op8;
		javaslang.collection.List<Movie> get9;
		javaslang.collection.Set<Movie> op10;
		javaslang.collection.Set<Movie> op11;
		int op12;
		int tmp13;
		boolean tmp14;/* 25:64-25:126: p1.movies->asSet()->intersection(p2.movies->asSet())->size() */
		/* 25:65-25:117: p1.movies->asSet()->intersection(p2.movies->asSet()) */
		/* 25:65-25:83: p1.movies->asSet() */
		/* 25:65-25:74: p1.movies */
		get7 = javaslang.collection.List.ofAll(p1.getMovies());

		op8 = javaslang.collection.HashSet.ofAll(get7);

		/* 25:98-25:116: p2.movies->asSet() */
		/* 25:98-25:107: p2.movies */
		get9 = javaslang.collection.List.ofAll(p2.getMovies());

		op10 = javaslang.collection.HashSet.ofAll(get9);

		op11 = op8.intersect(op10);

		op12 = op11.size();

		tmp13 = 3;

		tmp14 = op12 > tmp13;

		return tmp14;
	}

	public boolean isTargetElement(java.lang.Object obj) {
		if (obj == null)
			return false;
		;

		return OUTModel_PartialOutput_.belongsTo(obj);
	}

	public IModel findModelDynamically(java.lang.Object obj) {
		if (INModel_.belongsTo(obj))
			return INModel_;
		if (OUTModel_.belongsTo(obj))
			return OUTModel_;
		throw new IllegalStateException();
	}

	public a2l.tests.findcouples.normal.FindCouplesIMDb setIN(IModel n) {
		INModel_ = n;

		return this;
	}

	public a2l.tests.findcouples.normal.FindCouplesIMDb setOUT(IOutputModel n) {
		OUTModel_ = n;

		n.addPartial(OUTModel_PartialOutput_);

		return this;
	}

	public void create_movie(Movie m1) throws BlackboardException {
		Movie m215;
		java.lang.String get16;
		double get17;
		MovieType get18;
		int get19;
		javaslang.collection.List<Person> get20;
		List<java.lang.Object> itTmp21;
		m215 = imdb.movies.MoviesFactory.eINSTANCE.createMovie();

		this.trace.put(m1, m215);

		OUTModel_PartialOutput_.write(m215);

		/* 32:13-32:21: m1.title */
		get16 = m1.getTitle();

		/* 33:14-33:23: m1.rating */
		get17 = m1.getRating();

		/* 34:12-34:19: m1.type */
		get18 = m1.getType();

		/* 35:12-35:19: m1.year */
		get19 = m1.getYear();

		/* 36:15-36:25: m1.persons */
		get20 = javaslang.collection.List.ofAll(m1.getPersons());

		m215.setTitle(get16);
		;

		m215.setRating(get17);
		;

		m215.setType(get18);
		;

		m215.setYear(get19);
		;

		itTmp21 = new ArrayList<Object>();

		for (java.lang.Object o : get20) {
			boolean matched2 = false;
			if (check_actor(o)) {
				itTmp21.add(o);
			} else if (check_actress(o)) {
				itTmp21.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Movie_persons(m215, itTmp21, OUTModel_, null));
	}

	public void create_actor(Actor p1) throws BlackboardException {
		Actor p222;
		java.lang.String get23;
		javaslang.collection.List<Movie> get24;
		javaslang.collection.Set<Person> call26;
		boolean call27;
		java.lang.String get28;
		java.lang.String get29;
		int op30;
		int tmp31;
		boolean tmp32;
		boolean tmp33;
		Couple call34;
		List<java.lang.Object> itTmp35;
		p222 = imdb.movies.MoviesFactory.eINSTANCE.createActor();

		this.trace.put(p1, p222);

		OUTModel_PartialOutput_.write(p222);

		/* 45:12-45:19: p1.name */
		get23 = p1.getName();

		/* 46:14-46:23: p1.movies */
		get24 = javaslang.collection.List.ofAll(p1.getMovies());

		p222.setName(get23);
		;

		itTmp35 = new ArrayList<Object>();

		for (java.lang.Object o : get24) {
			boolean matched3 = false;
			if (check_movie(o)) {
				itTmp35.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Person_movies(p222, itTmp35, OUTModel_, null));

		/*
		 * 49:3-53:4: for (coauthor in thisModule.coactor(p1)) { if (
		 * thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 )
		 * { thisModule.createCouple(p1, coauthor); } }}
		 */
		/* 49:20-49:42: thisModule.coactor(p1) */
		call26 = helper_global_coactor(p1);

		for (Person coauthor25 : call26) {
			/*
			 * 50:4-52:5: if ( thisModule.areCouple(p1, coauthor) and
			 * p1.name.compareTo(coauthor.name) < 0 ) { thisModule.createCouple(p1,
			 * coauthor); }
			 */
			/* 50:8-50:42: thisModule.areCouple(p1, coauthor) */
			call27 = helper_global_areCouple(p1, coauthor25);

			/* 50:47-50:79: p1.name.compareTo(coauthor.name) */
			/* 50:47-50:54: p1.name */
			get28 = p1.getName();

			/* 50:65-50:78: coauthor.name */
			get29 = coauthor25.getName();

			op30 = get28.compareTo(get29);

			tmp31 = 0;

			tmp32 = op30 < tmp31;

			tmp33 = call27 && tmp32;

			if (tmp33) {
				/* 51:5-51:43: thisModule.createCouple(p1, coauthor); */
				/* 51:5-51:42: thisModule.createCouple(p1, coauthor) */
				call34 = called_rule_createCouple(p1, coauthor25);
			}
		}
	}

	public void create_actress(Actress p1) throws BlackboardException {
		Actress p236;
		java.lang.String get37;
		javaslang.collection.List<Movie> get38;
		javaslang.collection.Set<Person> call40;
		boolean call41;
		java.lang.String get42;
		java.lang.String get43;
		int op44;
		int tmp45;
		boolean tmp46;
		boolean tmp47;
		Couple call48;
		List<java.lang.Object> itTmp49;
		p236 = imdb.movies.MoviesFactory.eINSTANCE.createActress();

		this.trace.put(p1, p236);

		OUTModel_PartialOutput_.write(p236);

		/* 62:12-62:19: p1.name */
		get37 = p1.getName();

		/* 63:14-63:23: p1.movies */
		get38 = javaslang.collection.List.ofAll(p1.getMovies());

		p236.setName(get37);
		;

		itTmp49 = new ArrayList<Object>();

		for (java.lang.Object o : get38) {
			boolean matched4 = false;
			if (check_movie(o)) {
				itTmp49.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Person_movies(p236, itTmp49, OUTModel_, null));

		/*
		 * 66:3-70:4: for (coauthor in thisModule.coactor(p1)) { if (
		 * thisModule.areCouple(p1, coauthor) and p1.name.compareTo(coauthor.name) < 0 )
		 * { thisModule.createCouple(p1, coauthor); } }}
		 */
		/* 66:20-66:42: thisModule.coactor(p1) */
		call40 = helper_global_coactor(p1);

		for (Person coauthor39 : call40) {
			/*
			 * 67:4-69:5: if ( thisModule.areCouple(p1, coauthor) and
			 * p1.name.compareTo(coauthor.name) < 0 ) { thisModule.createCouple(p1,
			 * coauthor); }
			 */
			/* 67:8-67:42: thisModule.areCouple(p1, coauthor) */
			call41 = helper_global_areCouple(p1, coauthor39);

			/* 67:48-67:80: p1.name.compareTo(coauthor.name) */
			/* 67:48-67:55: p1.name */
			get42 = p1.getName();

			/* 67:66-67:79: coauthor.name */
			get43 = coauthor39.getName();

			op44 = get42.compareTo(get43);

			tmp45 = 0;

			tmp46 = op44 < tmp45;

			tmp47 = call41 && tmp46;

			if (tmp47) {
				/* 68:5-68:43: thisModule.createCouple(p1, coauthor); */
				/* 68:5-68:42: thisModule.createCouple(p1, coauthor) */
				call48 = called_rule_createCouple(p1, coauthor39);
			}
		}
	}

	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (java.lang.Object e : objs) {
			this.transform(e);
		}
	}

	public void transform(java.lang.Object e) throws BlackboardException {
		boolean matched5 = false;
		if (check_movie(e)) {
			create_movie((imdb.movies.Movie) e);
		} else if (check_actor(e)) {
			create_actor((imdb.movies.Actor) e);
		} else if (check_actress(e)) {
			create_actress((imdb.movies.Actress) e);
		}
	}
}