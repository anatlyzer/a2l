package a2l.tests.imdb.identity.normal;

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
import imdb.movies.Movie;
import imdb.movies.MovieType;
import imdb.movies.Person;
import imdb.movies.Actor;
import imdb.movies.Actress;
import imdb.movies.Clique;
import imdb.movies.Couple;

public class IdentityIMDb implements ITransformation, lintra2.transfo.ITransformation2 {
	private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;
	a2l.runtime.InputExtent inputExtent;
	a2l.tests.imdb.identity.normal.IdentityIMDbGlobalContext globalContext;
	a2l.runtime.GlobalTrace.PartialTrace trace = null;

	public IdentityIMDb(a2l.runtime.InputExtent inputExtent,
			a2l.tests.imdb.identity.normal.IdentityIMDbGlobalContext global) {
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
	}

	@Override
	public void doSequentialCleanup() {
		final Collection<? extends org.eclipse.emf.ecore.EObject> objects_OUT = (Collection<? extends org.eclipse.emf.ecore.EObject>) OUTModel_PartialOutput_
				.allInstances();
		for (org.eclipse.emf.ecore.EObject obj : objects_OUT) {
			if (obj.eContainer() == null) {
				OUTModel_.add(obj);
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

	final class PendingTask_Group_commonMovies implements IPendingTask {
		private final imdb.movies.Group tgt;
		private final Collection<Object> objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Group_commonMovies(imdb.movies.Group tgt, Collection<Object> objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public PendingTask_Group_commonMovies(imdb.movies.Group tgt, Object objId, a2l.runtime.IModel area,
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
				tgt.getCommonMovies().addAll((Collection<? extends imdb.movies.Movie>) result);
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
				tgt.getCommonMovies().addAll((Collection<? extends imdb.movies.Movie>) result);
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

	final class PendingTask_Clique_persons implements IPendingTask {
		private final imdb.movies.Clique tgt;
		private final Collection<Object> objId;
		private final a2l.runtime.IModel area;
		private final java.util.Set<? extends Object> tgtElems;

		public PendingTask_Clique_persons(imdb.movies.Clique tgt, Collection<Object> objId, a2l.runtime.IModel area,
				java.util.Set<? extends Object> tgtElems) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
			this.tgtElems = tgtElems;
		}

		public PendingTask_Clique_persons(imdb.movies.Clique tgt, Object objId, a2l.runtime.IModel area,
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

	public boolean check_clique(java.lang.Object c1) throws BlackboardException {
		return c1 instanceof imdb.movies.Clique;
	}

	public boolean check_couple(java.lang.Object c1) throws BlackboardException {
		return c1 instanceof imdb.movies.Couple;
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

	public a2l.tests.imdb.identity.normal.IdentityIMDb setIN(IModel n) {
		INModel_ = n;

		return this;
	}

	public a2l.tests.imdb.identity.normal.IdentityIMDb setOUT(IOutputModel n) {
		OUTModel_ = n;

		n.addPartial(OUTModel_PartialOutput_);

		return this;
	}

	public void create_movie(Movie m1) throws BlackboardException {
		Movie m20;
		java.lang.String get1;
		double get2;
		MovieType get3;
		int get4;
		javaslang.collection.List<Person> get5;
		List<java.lang.Object> itTmp6;
		m20 = imdb.movies.MoviesFactory.eINSTANCE.createMovie();

		this.trace.put(m1, m20);

		OUTModel_PartialOutput_.write(m20);

		/* 21:13-21:21: m1.title */
		get1 = m1.getTitle();

		/* 22:14-22:23: m1.rating */
		get2 = m1.getRating();

		/* 23:12-23:19: m1.type */
		get3 = m1.getType();

		/* 24:12-24:19: m1.year */
		get4 = m1.getYear();

		/* 25:15-25:25: m1.persons */
		get5 = javaslang.collection.List.ofAll(m1.getPersons());

		m20.setTitle(get1);
		;

		m20.setRating(get2);
		;

		m20.setType(get3);
		;

		m20.setYear(get4);
		;

		itTmp6 = new ArrayList<Object>();

		for (java.lang.Object o : get5) {
			boolean matched0 = false;
			if (check_actor(o)) {
				itTmp6.add(o);
			} else if (check_actress(o)) {
				itTmp6.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Movie_persons(m20, itTmp6, OUTModel_, null));
	}

	public void create_actor(Actor p1) throws BlackboardException {
		Actor p27;
		java.lang.String get8;
		javaslang.collection.List<Movie> get9;
		List<java.lang.Object> itTmp10;
		p27 = imdb.movies.MoviesFactory.eINSTANCE.createActor();

		this.trace.put(p1, p27);

		OUTModel_PartialOutput_.write(p27);

		/* 34:12-34:19: p1.name */
		get8 = p1.getName();

		/* 35:14-35:23: p1.movies */
		get9 = javaslang.collection.List.ofAll(p1.getMovies());

		p27.setName(get8);
		;

		itTmp10 = new ArrayList<Object>();

		for (java.lang.Object o : get9) {
			boolean matched1 = false;
			if (check_movie(o)) {
				itTmp10.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Person_movies(p27, itTmp10, OUTModel_, null));
	}

	public void create_actress(Actress p1) throws BlackboardException {
		Actress p211;
		java.lang.String get12;
		javaslang.collection.List<Movie> get13;
		List<java.lang.Object> itTmp14;
		p211 = imdb.movies.MoviesFactory.eINSTANCE.createActress();

		this.trace.put(p1, p211);

		OUTModel_PartialOutput_.write(p211);

		/* 44:12-44:19: p1.name */
		get12 = p1.getName();

		/* 45:14-45:23: p1.movies */
		get13 = javaslang.collection.List.ofAll(p1.getMovies());

		p211.setName(get12);
		;

		itTmp14 = new ArrayList<Object>();

		for (java.lang.Object o : get13) {
			boolean matched2 = false;
			if (check_movie(o)) {
				itTmp14.add(o);
			}
		}
		this.pendingTasks.add(new PendingTask_Person_movies(p211, itTmp14, OUTModel_, null));
	}

	public void create_clique(Clique c1) throws BlackboardException {
		Clique c215;
		double get16;
		javaslang.collection.List<Movie> get17;
		javaslang.collection.List<Person> get18;
		List<java.lang.Object> itTmp19;
		List<java.lang.Object> itTmp20;
		c215 = imdb.movies.MoviesFactory.eINSTANCE.createClique();

		this.trace.put(c1, c215);

		OUTModel_PartialOutput_.write(c215);

		/* 54:17-54:29: c1.avgRating */
		get16 = c1.getAvgRating();

		/* 55:20-55:35: c1.commonMovies */
		get17 = javaslang.collection.List.ofAll(c1.getCommonMovies());

		/* 56:15-56:25: c1.persons */
		get18 = javaslang.collection.List.ofAll(c1.getPersons());

		c215.setAvgRating(get16);
		;

		itTmp19 = new ArrayList<Object>();

		for (java.lang.Object o : get17) {
			boolean matched3 = false;
			if (check_movie(o)) {
				itTmp19.add(o);
			}
		}
		this.parallelPendingTasks.add(new PendingTask_Group_commonMovies(c215, itTmp19, OUTModel_, null));

		itTmp20 = new ArrayList<Object>();

		for (java.lang.Object o : get18) {
			boolean matched4 = false;
			if (check_actor(o)) {
				itTmp20.add(o);
			} else if (check_actress(o)) {
				itTmp20.add(o);
			}
		}
		this.parallelPendingTasks.add(new PendingTask_Clique_persons(c215, itTmp20, OUTModel_, null));
	}

	public void create_couple(Couple c1) throws BlackboardException {
		Couple c221;
		double get22;
		javaslang.collection.List<Movie> get23;
		Person get24;
		Person get25;
		List<java.lang.Object> itTmp26;
		c221 = imdb.movies.MoviesFactory.eINSTANCE.createCouple();

		this.trace.put(c1, c221);

		OUTModel_PartialOutput_.write(c221);

		/* 65:17-65:29: c1.avgRating */
		get22 = c1.getAvgRating();

		/* 66:20-66:35: c1.commonMovies */
		get23 = javaslang.collection.List.ofAll(c1.getCommonMovies());

		/* 67:10-67:15: c1.p1 */
		get24 = c1.getP1();

		/* 68:10-68:15: c1.p2 */
		get25 = c1.getP2();

		c221.setAvgRating(get22);
		;

		itTmp26 = new ArrayList<Object>();

		for (java.lang.Object o : get23) {
			boolean matched5 = false;
			if (check_movie(o)) {
				itTmp26.add(o);
			}
		}
		this.parallelPendingTasks.add(new PendingTask_Group_commonMovies(c221, itTmp26, OUTModel_, null));

		boolean matched6 = false;
		if (check_actor(get24)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p1(c221, get24, OUTModel_, null));
		} else if (check_actress(get24)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p1(c221, get24, OUTModel_, null));
		}

		boolean matched7 = false;
		if (check_actor(get25)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p2(c221, get25, OUTModel_, null));
		} else if (check_actress(get25)) {
			this.parallelPendingTasks.add(new PendingTask_Couple_p2(c221, get25, OUTModel_, null));
		}
	}

	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (java.lang.Object e : objs) {
			this.transform(e);
		}
	}

	public void transform(java.lang.Object e) throws BlackboardException {
		boolean matched8 = false;
		if (check_movie(e)) {
			create_movie((imdb.movies.Movie) e);
		} else if (check_actor(e)) {
			create_actor((imdb.movies.Actor) e);
		} else if (check_actress(e)) {
			create_actress((imdb.movies.Actress) e);
		} else if (check_clique(e)) {
			create_clique((imdb.movies.Clique) e);
		} else if (check_couple(e)) {
			create_couple((imdb.movies.Couple) e);
		}
	}
}