package a2l.tests.dblp_v1;

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

import org.eclipse.emf.common.util.EList;

import dblp.DBLP.InProceedings;
import dblp.DBLP.Record;

public class DBLPv1_ManuallyOptimised implements ITransformation, lintra2.transfo.ITransformation2 {
	private IArea _area_IN;
	private IArea _area_OUT;
	IArea trgArea, cachingArea;

	public DBLPv1_ManuallyOptimised(IArea _area_IN, IArea _area_OUT, IArea cachingArea) {
		this._area_IN = _area_IN;
		this._area_OUT = _area_OUT;
		this.cachingArea = cachingArea;
	}

	protected List<String> toList(String[] strings) {
		return java.util.Arrays.asList(strings);
	}

	protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException {
		javaslang.collection.List<T> IN = javaslang.collection.List.ofAll(_area_IN.read(_area_IN.size() + 1))
				.filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
		javaslang.collection.List<T> result = javaslang.collection.List.empty();
		result = result.appendAll(IN);
		return result;

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

	protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) {
		return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString();
	}

	Collection<org.eclipse.emf.ecore.EObject> rootOfOUT = java.util.Collections
			.synchronizedList(new ArrayList<org.eclipse.emf.ecore.EObject>());

	public void postprocessing() throws BlackboardException {
		for (IPendingTask tasks : pendingTasks) {
			tasks.execute();
		}
		// TODO: Pass the number of threads explicitly to postprocessing
		java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(8);
		final Collection objects_OUT = _area_OUT.read(_area_OUT.size());
		try {
			myPool.submit(() -> {
				objects_OUT.parallelStream().forEach(object -> {
					org.eclipse.emf.ecore.EObject obj = (org.eclipse.emf.ecore.EObject) object;
					if (obj.eContainer() == null) {
						rootOfOUT.add(obj);
					}
				});
			}).get();
		} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
			throw new RuntimeException(e);
		}
	}

	public void writeOUT(org.eclipse.emf.ecore.resource.Resource r) {
		for (org.eclipse.emf.ecore.EObject o : rootOfOUT) {
			r.getContents().add(o);
		}
	}

	private java.util.concurrent.ConcurrentLinkedQueue<IPendingTask> pendingTasks = new java.util.concurrent.ConcurrentLinkedQueue<>();

	interface IPendingTask {
		public void execute() throws BlackboardException;
	}

	public boolean check_icmt(java.lang.Object a) throws BlackboardException {
		dblp.DBLP.Author tmp15;
		List<Record> get18;
		boolean op19;
		ArrayList<InProceedings> r20;
		java.lang.String call21;
		java.lang.String tmp22;
		int op23;
		int tmp24;
		boolean tmp25;
		boolean r26;
		if (a instanceof dblp.DBLP.Author) {
			tmp15 = (dblp.DBLP.Author) a;

			/*
			 * 21:18-21:120: a.records->select(r |
			 * r.oclIsTypeOf(MM!InProceedings))->exists(ip |
			 * ip.booktitle().indexOf('ICMT') >= 0)
			 */
			/*
			 * 21:18-21:72: a.records->select(r |
			 * r.oclIsTypeOf(MM!InProceedings))
			 */
			/* 21:18-21:27: a.records */
			//get18 = javaslang.collection.List.ofAll(tmp15.getRecords());
			get18 = tmp15.getRecords();

			r20 = new ArrayList<dblp.DBLP.InProceedings>(); //javaslang.collection.List.empty();

			for (Record r17 : get18) {
				/* 21:40-21:71: r.oclIsTypeOf(MM!InProceedings) */
				op19 = r17 != null && r17.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

				if (op19 == true) {
					//r20 = r20.append((dblp.DBLP.InProceedings) r17);
					r20.add((InProceedings) r17);
				}
			}
			r26 = false;

			for (InProceedings ip16 : r20) {
				/* 21:86-21:116: ip.booktitle().indexOf('ICMT') */
				/* 21:86-21:100: ip.booktitle() */
				if (ip16 instanceof dblp.DBLP.InProceedings) {
					call21 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings) ip16);
				} else {
					throw new IllegalStateException();
				}
				tmp22 = "ICMT";

				op23 = call21.indexOf(tmp22);

				tmp24 = 0;

				tmp25 = op23 >= tmp24;

				if (tmp25) {
					r26 = true;

					break;
				}
			}
			return r26 == true;
		}
		return false;
	}

	public java.lang.String helper_dblp_DBLP_InProceedings_booktitle(InProceedings self_) throws BlackboardException {
		java.lang.String get0;/* 16:62-16:75: self.bootitle */
		get0 = self_.getBootitle();

		return get0;
	}

	public boolean isTargetElement(java.lang.Object obj) {
		if (obj == null)
			return false;
		;

		return _area_OUT.getIdMapper().belongsTo(obj);
	}

	public lintra2.blackboard.IdMapper findDriverDynamically(java.lang.Object obj) {
		if (_area_IN.getIdMapper().belongsTo(obj))
			return _area_IN.getIdMapper();
		if (_area_OUT.getIdMapper().belongsTo(obj))
			return _area_OUT.getIdMapper();
		throw new IllegalStateException();
	}

	public void create_icmt(dblp.DBLP.Author a) throws BlackboardException {
		dblp.AuthorInfo.Author out1;
		java.lang.String get2;
		List<Record> get5;
		boolean op6;
		ArrayList<InProceedings> r7;
		java.lang.String call8;
		java.lang.String tmp9;
		int op10;
		int tmp11;
		boolean tmp12;
		javaslang.collection.List<InProceedings> r13;
		int op14;
		out1 = dblp.AuthorInfo.AuthorInfoFactory.eINSTANCE.createAuthor();

		//_area_OUT.getIdMapper().addMapping(out1, TraceFunction.create(_area_IN.getIdMapper().getId(a), 0, "icmt"));

		/* 24:12-24:18: a.name */
		get2 = a.getName();

		/*
		 * 25:20-25:130: a.records->select(r |
		 * r.oclIsTypeOf(MM!InProceedings))->select(ip |
		 * ip.booktitle().indexOf('ICMT') >= 0)->size()
		 */
		/*
		 * 25:20-25:122: a.records->select(r |
		 * r.oclIsTypeOf(MM!InProceedings))->select(ip |
		 * ip.booktitle().indexOf('ICMT') >= 0)
		 */
		/*
		 * 25:20-25:74: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))
		 */
		/* 25:20-25:29: a.records */
		//get5 = javaslang.collection.List.ofAll(a.getRecords());
		get5 = a.getRecords();

		//r7 = javaslang.collection.List.empty();
		r7 = new ArrayList<dblp.DBLP.InProceedings>();

		for (Record r4 : get5) {
			/* 25:42-25:73: r.oclIsTypeOf(MM!InProceedings) */
			op6 = r4 != null && r4.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

			if (op6 == true) {
				//r7 = r7.append((dblp.DBLP.InProceedings) r4);
				r7.add((dblp.DBLP.InProceedings) r4);
			}
		}
		r13 = javaslang.collection.List.empty();

		for (InProceedings ip3 : r7) {
			/* 25:88-25:118: ip.booktitle().indexOf('ICMT') */
			/* 25:88-25:102: ip.booktitle() */
			if (ip3 instanceof dblp.DBLP.InProceedings) {
				call8 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings) ip3);
			} else {
				throw new IllegalStateException();
			}
			tmp9 = "ICMT";

			op10 = call8.indexOf(tmp9);

			tmp11 = 0;

			tmp12 = op10 >= tmp11;

			if (tmp12 == true) {
				r13 = r13.append(ip3);
			}
		}
		op14 = r13.size();

		out1.setName(get2);
		;

		out1.setNumOfPapers(op14);
		;

		//_area_OUT.write(out1);
	}

	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (java.lang.Object e : objs) {
			this.transform(e);
		}
	}

	public void transform(java.lang.Object e) throws BlackboardException {
		boolean matched0 = false;
		if (check_icmt(e)) {
			create_icmt((dblp.DBLP.Author) e);
		}
	}
}