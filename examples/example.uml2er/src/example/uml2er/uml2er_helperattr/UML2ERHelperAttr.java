package example.uml2er.uml2er_helperattr;

import blackboard.IdentifiableElement;
import blackboard.IArea;
import blackboard.BlackboardException;
import transfo.ITransformation;
import transfo.IMaster;
import transfo.TraceFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import simpleuml.IClass;
import simpleuml.IProperty;
import simpleuml.IPackage;
import er.ERModel;
import er.EntityType;
import er.IAttribute;
import er.IWeakReference;
import er.IStrongReference;
import er.Attribute;
import er.WeakReference;
import er.StrongReference;

public class UML2ERHelperAttr implements ITransformation {
	IArea srcArea, trgArea, cachingArea;

	public UML2ERHelperAttr(IArea srcArea, IArea trgArea, IArea cachingArea) {
		this.srcArea = srcArea;
		this.trgArea = trgArea;
		this.cachingArea = cachingArea;
	}

	protected List<String> toList(String[] strings) {
		return java.util.Arrays.asList(strings);
	}

	protected IdentifiableElement read(IArea area, String id) throws BlackboardException {
		return id == null ? null : area.read(id);
	}

	protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException {
		return javaslang.collection.List.ofAll(srcArea.read(srcArea.size() + 1)).filter(e -> klass.isInstance(e))
				.map(e -> klass.cast(e));
	}

	private javaslang.collection.List<Object> flatten(Iterable<?> l) {
		javaslang.collection.List<Object> r = javaslang.collection.List.empty();
		for (Object object : l) {
			if (object instanceof Iterable) {
				r = r.appendAll(flatten((Iterable<Object>) object));
			} else {
				r = r.append(object);
			}
		}
		return r;
	}

	public boolean check_Package(IdentifiableElement s) throws BlackboardException {
		return s instanceof IPackage;
	}

	public boolean check_Class(IdentifiableElement s) throws BlackboardException {
		return s instanceof IClass;
	}

	public IAttribute lazy_rule_Attributes(IProperty s) throws BlackboardException {
		Attribute t52;
		java.lang.String get53;
		java.lang.String get54;
		t52 = new Attribute();

		t52.setTrgId("ER");

		t52.setId(TraceFunction.createUniqueId("Attributes"));

		/* 65:12-65:18: s.name */
		get53 = s.getName();

		/* 66:12-66:27: s.primitiveType */
		get54 = s.getPrimitiveType();

		t52.setName(get53);

		t52.setType(get54);

		trgArea.write(t52);

		return t52;
	}

	public IWeakReference lazy_rule_WeakReferences(IProperty s) throws BlackboardException {
		WeakReference t55;
		java.lang.String get56;
		IClass get57;
		java.lang.String id58;
		t55 = new WeakReference();

		t55.setTrgId("ER");

		t55.setId(TraceFunction.createUniqueId("WeakReferences"));

		/* 75:12-75:18: s.name */
		get56 = s.getName();

		/* 76:12-76:25: s.complexType */
		id58 = s.getComplexType();

		get57 = (IClass) read(srcArea, id58);

		t55.setName(get56);

		boolean matched0 = false;
		if (check_Class(get57)) {
			t55.setType(TraceFunction.resolve(get57.getId(), 0, "Class"));
		}

		trgArea.write(t55);

		return t55;
	}

	public IStrongReference lazy_rule_StrongReferences(IProperty s) throws BlackboardException {
		StrongReference t59;
		java.lang.String get60;
		IClass get61;
		java.lang.String id62;
		t59 = new StrongReference();

		t59.setTrgId("ER");

		t59.setId(TraceFunction.createUniqueId("StrongReferences"));

		/* 85:12-85:18: s.name */
		get60 = s.getName();

		/* 86:12-86:25: s.complexType */
		id62 = s.getComplexType();

		get61 = (IClass) read(srcArea, id62);

		t59.setName(get60);

		boolean matched1 = false;
		if (check_Class(get61)) {
			t59.setType(TraceFunction.resolve(get61.getId(), 0, "Class"));
		}

		trgArea.write(t59);

		return t59;
	}

	public javaslang.collection.List<IClass> helper_IClass_allClasses(IClass self_) throws BlackboardException {
		javaslang.collection.List<IClass> get0;
		java.lang.String[] id1;
		javaslang.collection.List tmp2;
		javaslang.collection.List<IClass> acc45;
		javaslang.collection.Set<IClass> tmp6;
		javaslang.collection.List<IClass> op7;
		javaslang.collection.List<IClass> call8;
		javaslang.collection.List<IClass> op9;/*
												 * 18:2-20:3:
												 * self.superClasses->iterate(e;
												 * acc:Sequence(SimpleUML!Class)
												 * = Sequence { } |
												 * acc->union(Set {e
												 * })->union(e.allClasses))
												 */
		/* 18:2-18:19: self.superClasses */
		id1 = self_.getSuperClasses();

		get0 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<IClass>(srcArea.readAll(toList(id1))));

		tmp2 = javaslang.collection.List.empty();

		acc45 = tmp2;

		for (IClass e3 : get0) {
			/* 19:3-19:42: acc->union(Set {e })->union(e.allClasses) */
			/* 19:3-19:21: acc->union(Set {e }) */
			/* 19:14-19:20: Set {e } */
			tmp6 = javaslang.collection.HashSet.of(e3);

			op7 = acc45.appendAll(tmp6);

			/* 19:29-19:41: e.allClasses */
			if (e3 instanceof IClass) {
				call8 = helper_IClass_allClasses((IClass) e3);
			} else {
				throw new IllegalStateException();
			}
			op9 = op7.appendAll(call8);

			acc45 = op9;
		}
		return acc45;
	}

	public javaslang.collection.List<IProperty> helper_IClass_getAllProperties(IClass self_)
			throws BlackboardException {
		javaslang.collection.List<IClass> call11;
		javaslang.collection.List<IClass> op12;
		javaslang.collection.List<IClass> op13;
		javaslang.collection.List<IProperty> get14;
		java.lang.String[] id15;
		javaslang.collection.List<javaslang.collection.List<IProperty>> r16;
		javaslang.collection.List<IProperty> op17;/*
													 * 23:2-23:83:
													 * self.allClasses.including
													 * (self).flatten()->collect
													 * (e |
													 * e.ownedProperty).flatten(
													 * )
													 */
		/*
		 * 23:2-23:73: self.allClasses.including(self).flatten()->collect(e |
		 * e.ownedProperty)
		 */
		/* 23:2-23:43: self.allClasses.including(self).flatten() */
		/* 23:2-23:33: self.allClasses.including(self) */
		/* 23:2-23:17: self.allClasses */
		if (self_ instanceof IClass) {
			call11 = helper_IClass_allClasses((IClass) self_);
		} else {
			throw new IllegalStateException();
		}
		op12 = call11.append(self_);

		op13 = flatten(op12).map(x_ -> (IClass) x_);

		r16 = javaslang.collection.List.empty();

		for (IClass e10 : op13) {
			/* 23:57-23:72: e.ownedProperty */
			id15 = e10.getOwnedProperty();

			get14 = javaslang.collection.List.ofAll(
					new uk.ac.ebi.utils.collections.TypeCastCollection<IProperty>(srcArea.readAll(toList(id15))));

			r16 = r16.append(get14);
		}
		op17 = flatten(r16).map(x_ -> (IProperty) x_);

		return op17;
	}

	public boolean isTargetElement(IdentifiableElement obj) {
		return "ER".equals(obj.getTrgId());
	}

	public void create_Package(IPackage s) throws BlackboardException {
		ERModel t18;
		javaslang.collection.List<IClass> get19;
		java.lang.String[] id20;
		List<java.lang.String> itTmp21;
		t18 = new ERModel();

		t18.setTrgId("ER");

		t18.setId(TraceFunction.create(s.getId(), 0, "Package"));

		/* 13:16-13:31: s.ownedElements */
		id20 = s.getOwnedElements();

		get19 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<IClass>(srcArea.readAll(toList(id20))));

		itTmp21 = new ArrayList<String>();

		for (IdentifiableElement o : get19) {
			boolean matched2 = false;
			if (check_Class(o)) {
				itTmp21.add(TraceFunction.resolve(o.getId(), 0, "Class"));
			}
		}
		t18.setEntities(itTmp21.toArray(new String[itTmp21.size()]));

		trgArea.write(t18);
	}

	public void create_Class(IClass s) throws BlackboardException {
		EntityType t22;
		java.lang.String get23;
		javaslang.collection.List<IProperty> call25;
		IAttribute call26;
		java.lang.String get27;
		boolean op28;
		boolean tmp29;
		IWeakReference call30;
		IClass get31;
		java.lang.String id32;
		boolean op33;
		boolean tmp34;
		boolean get35;
		boolean tmp36;
		boolean tmp37;
		IStrongReference call38;
		IClass get39;
		java.lang.String id40;
		boolean op41;
		boolean tmp42;
		boolean get43;
		boolean tmp44;
		java.lang.Object tmp45;
		IStrongReference r46;
		IdentifiableElement r47;
		IdentifiableElement r48;
		javaslang.collection.List<IdentifiableElement> r49;
		List<java.lang.String> itTmp50;
		javaslang.collection.List<IdentifiableElement> filterBinding51;
		t22 = new EntityType();

		t22.setTrgId("ER");

		t22.setId(TraceFunction.create(s.getId(), 0, "Class"));

		/* 43:12-43:18: s.name */
		get23 = s.getName();

		/*
		 * 47:16-56:15: s.getAllProperties->collect(e | if ( not
		 * e.primitiveType.oclIsUndefined() ) then thisModule.Attributes(e) else
		 * if ( not e.complexType.oclIsUndefined() and not e.isContainment )
		 * then thisModule.WeakReferences(e) else if ( not
		 * e.complexType.oclIsUndefined() and e.isContainment ) then
		 * thisModule.StrongReferences(e) else OclUndefined endif endif endif)
		 */
		/* 47:16-47:34: s.getAllProperties */
		if (s instanceof IClass) {
			call25 = helper_IClass_getAllProperties((IClass) s);
		} else {
			throw new IllegalStateException();
		}
		r49 = javaslang.collection.List.empty();

		for (IProperty e24 : call25) {
			/*
			 * 48:8-56:13: if ( not e.primitiveType.oclIsUndefined() ) then
			 * thisModule.Attributes(e) else if ( not
			 * e.complexType.oclIsUndefined() and not e.isContainment ) then
			 * thisModule.WeakReferences(e) else if ( not
			 * e.complexType.oclIsUndefined() and e.isContainment ) then
			 * thisModule.StrongReferences(e) else OclUndefined endif endif
			 * endif
			 */
			/* 48:16-48:48: e.primitiveType.oclIsUndefined() */
			/* 48:16-48:31: e.primitiveType */
			get27 = e24.getPrimitiveType();

			op28 = get27 == null;

			tmp29 = !op28;

			r48 = null;

			if (tmp29) {
				/* 49:14-49:38: thisModule.Attributes(e) */
				call26 = lazy_rule_Attributes(e24);

				r48 = call26;
			} else { /*
						 * 50:10-55:15: if ( not e.complexType.oclIsUndefined()
						 * and not e.isContainment ) then
						 * thisModule.WeakReferences(e) else if ( not
						 * e.complexType.oclIsUndefined() and e.isContainment )
						 * then thisModule.StrongReferences(e) else OclUndefined
						 * endif endif
						 */
				/* 50:18-50:48: e.complexType.oclIsUndefined() */
				/* 50:18-50:31: e.complexType */
				id32 = e24.getComplexType();

				get31 = (IClass) read(srcArea, id32);

				op33 = get31 == null;

				tmp34 = !op33;

				/* 50:57-50:72: e.isContainment */
				get35 = e24.getIsContainment();

				tmp36 = !get35;

				tmp37 = tmp34 && tmp36;

				r47 = null;

				if (tmp37) {
					/* 51:16-51:44: thisModule.WeakReferences(e) */
					call30 = lazy_rule_WeakReferences(e24);

					r47 = call30;
				} else { /*
							 * 53:12-54:72: if ( not
							 * e.complexType.oclIsUndefined() and
							 * e.isContainment ) then
							 * thisModule.StrongReferences(e) else OclUndefined
							 * endif
							 */
					/* 53:19-53:49: e.complexType.oclIsUndefined() */
					/* 53:19-53:32: e.complexType */
					id40 = e24.getComplexType();

					get39 = (IClass) read(srcArea, id40);

					op41 = get39 == null;

					tmp42 = !op41;

					/* 53:54-53:69: e.isContainment */
					get43 = e24.getIsContainment();

					tmp44 = tmp42 && get43;

					r46 = null;

					if (tmp44) {
						/* 54:18-54:48: thisModule.StrongReferences(e) */
						call38 = lazy_rule_StrongReferences(e24);

						r46 = call38;
					} else {
						tmp45 = null;

						r46 = (IStrongReference) tmp45;
					}
					r47 = r46;
				}
				r48 = r47;
			}
			r49 = r49.append(r48);
		}
		t22.setName(get23);

		itTmp50 = new ArrayList<String>();

		filterBinding51 = r49.filter(e_ -> e_ instanceof IdentifiableElement).map(e_ -> (IdentifiableElement) e_);

		for (IdentifiableElement o : filterBinding51) {
			boolean matched3 = false;
			if (isTargetElement(o)) {
				itTmp50.add(o.getId());
			}
		}
		t22.setFeatures(itTmp50.toArray(new String[itTmp50.size()]));

		trgArea.write(t22);
	}

	public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (IdentifiableElement e : objs) {
			boolean matched4 = false;
			if (check_Package(e)) {
				create_Package((IPackage) e);
			} else if (check_Class(e)) {
				create_Class((IClass) e);
			}
		}
	}
}