package example.java2uml.runningexample;

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
import jmm.IModel;
import umlmm.Model;
import jmm.IPackage;
import umlmm.Package;
import jmm.IAbstractTypeDeclaration;
import jmm.IAnnotationTypeDeclaration;
import jmm.IClassDeclaration;
import umlmm.Class;
import jmm.IModifier;
import jmm.InheritanceKind;
import jmm.ITypeAccess;
import umlmm.IGeneralization;
import jmm.IBodyDeclaration;
import jmm.IFieldDeclaration;
import jmm.IMethodDeclaration;
import jmm.IConstructorDeclaration;
import umlmm.Generalization;
import jmm.IType;
import jmm.IInterfaceDeclaration;
import umlmm.Interface;

public class java2uml_running implements ITransformation {
	private IArea _area_CM;
	private IArea _area_UCD;
	IArea trgArea, cachingArea;

	public java2uml_running(IArea _area_CM, IArea _area_UCD, IArea cachingArea) {
		this._area_CM = _area_CM;
		this._area_UCD = _area_UCD;
		this.cachingArea = cachingArea;
	}

	protected List<String> toList(String[] strings) {
		return java.util.Arrays.asList(strings);
	}

	protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException {
		javaslang.collection.List<T> CM = javaslang.collection.List.ofAll(_area_CM.read(_area_CM.size() + 1))
				.filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
		javaslang.collection.List<T> result = javaslang.collection.List.empty();
		result = result.appendAll(CM);
		return result;

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

	protected IdentifiableElement read(IArea area, String id) throws BlackboardException {
		return id == null ? null : area.read(id);
	}

	public boolean check_Model2Model(IdentifiableElement s1) throws BlackboardException {
		return s1 instanceof jmm.IModel;
	}

	public boolean check_Package2Package(IdentifiableElement s1) throws BlackboardException {
		IPackage tmp25;
		boolean get26;
		boolean tmp27;
		boolean tmp28;
		if (s1 instanceof jmm.IPackage) {
			tmp25 = (jmm.IPackage) s1;

			/* 26:18-26:26: s1.proxy */
			get26 = tmp25.getProxy();

			tmp27 = false;

			tmp28 = get26 == tmp27;

			return tmp28 == true;
		}
		return false;
	}

	public boolean check_Class2Class(IdentifiableElement s1) throws BlackboardException {
		IClassDeclaration tmp65;
		boolean get66;
		boolean tmp67;
		boolean tmp68;
		if (s1 instanceof jmm.IClassDeclaration) {
			tmp65 = (jmm.IClassDeclaration) s1;

			/* 38:29-38:37: s1.proxy */
			get66 = tmp65.getProxy();

			tmp67 = false;

			tmp68 = get66 == tmp67;

			return tmp68 == true;
		}
		return false;
	}

	public boolean check_Interface2Interface(IdentifiableElement s1) throws BlackboardException {
		IInterfaceDeclaration tmp77;
		boolean get78;
		boolean tmp79;
		boolean tmp80;
		if (s1 instanceof jmm.IInterfaceDeclaration) {
			tmp77 = (jmm.IInterfaceDeclaration) s1;

			/* 67:33-67:41: s1.proxy */
			get78 = tmp77.getProxy();

			tmp79 = false;

			tmp80 = get78 == tmp79;

			return tmp80 == true;
		}
		return false;
	}

	public IGeneralization lazy_rule_createGeneralization(ITypeAccess superClass) throws BlackboardException {
		Generalization gTgt72;
		IType get73;
		java.lang.String id74;
		gTgt72 = new umlmm.Generalization();

		gTgt72.setTrgId("UMLMM");

		gTgt72.setId(TraceFunction.createUniqueId("createGeneralization"));

		/* 60:14-60:29: superClass.type */
		id74 = superClass.getType();

		get73 = (jmm.IType) read(_area_CM, id74);

		boolean matched0 = false;
		if (check_Class2Class(get73)) {
			gTgt72.setGeneral(TraceFunction.resolve(get73.getId(), 0, "Class2Class"));
		} else if (check_Interface2Interface(get73)) {
			gTgt72.setGeneral(TraceFunction.resolve(get73.getId(), 0, "Interface2Interface"));
		}

		_area_UCD.write(gTgt72);

		return gTgt72;
	}

	public boolean isTargetElement(IdentifiableElement obj) {
		return "UMLMM".equals(obj.getTrgId());
	}

	public void create_Model2Model(IModel s1) throws BlackboardException {
		Model t10;
		java.lang.String get1;
		javaslang.collection.List<IPackage> get3;
		java.lang.String[] id4;
		boolean get5;
		boolean tmp6;
		boolean tmp7;
		javaslang.collection.List<IPackage> r8;
		List<java.lang.String> itTmp9;
		t10 = new umlmm.Model();

		t10.setTrgId("UMLMM");

		t10.setId(TraceFunction.create(s1.getId(), 0, "Model2Model"));

		/* 18:12-18:19: s1.name */
		get1 = s1.getName();

		/* 19:23-19:70: s1.ownedElements->select(e | e.proxy = false) */
		/* 19:23-19:39: s1.ownedElements */
		id4 = s1.getOwnedElements();

		get3 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.IPackage>(_area_CM.readAll(toList(id4))));

		r8 = javaslang.collection.List.empty();

		for (IPackage e2 : get3) {
			/* 19:54-19:61: e.proxy */
			get5 = e2.getProxy();

			tmp6 = false;

			tmp7 = get5 == tmp6;

			if (tmp7 == true) {
				r8 = r8.append(e2);
			}
		}
		t10.setName(get1);

		itTmp9 = new ArrayList<String>();

		for (IdentifiableElement o : r8) {
			boolean matched1 = false;
			if (check_Package2Package(o)) {
				itTmp9.add(TraceFunction.resolve(o.getId(), 0, "Package2Package"));
			}
		}
		t10.setPackagedElement(itTmp9.toArray(new String[itTmp9.size()]));

		_area_UCD.write(t10);
	}

	public void create_Package2Package(IPackage s1) throws BlackboardException {
		Package t110;
		java.lang.String get11;
		javaslang.collection.List<IPackage> get12;
		java.lang.String[] id13;
		javaslang.collection.List<IAbstractTypeDeclaration> get16;
		java.lang.String[] id17;
		boolean get18;
		boolean tmp19;
		boolean tmp20;
		javaslang.collection.List<IAbstractTypeDeclaration> r21;
		boolean op22;
		boolean tmp23;
		javaslang.collection.List<IAbstractTypeDeclaration> r24;
		List<java.lang.String> itTmp29;
		List<java.lang.String> itTmp30;
		t110 = new umlmm.Package();

		t110.setTrgId("UMLMM");

		t110.setId(TraceFunction.create(s1.getId(), 0, "Package2Package"));

		/* 29:12-29:19: s1.name */
		get11 = s1.getName();

		/* 30:23-30:39: s1.ownedPackages */
		id13 = s1.getOwnedPackages();

		get12 = javaslang.collection.List.ofAll(
				new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.IPackage>(_area_CM.readAll(toList(id13))));

		/*
		 * 31:23-31:134: s1.ownedElements->select(e | e.proxy = false)->select(e
		 * | not e.oclIsTypeOf(JMM!AnnotationTypeDeclaration))
		 */
		/* 31:23-31:70: s1.ownedElements->select(e | e.proxy = false) */
		/* 31:23-31:39: s1.ownedElements */
		id17 = s1.getOwnedElements();

		get16 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.IAbstractTypeDeclaration>(
						_area_CM.readAll(toList(id17))));

		r21 = javaslang.collection.List.empty();

		for (IAbstractTypeDeclaration e15 : get16) {
			/* 31:54-31:61: e.proxy */
			get18 = e15.getProxy();

			tmp19 = false;

			tmp20 = get18 == tmp19;

			if (tmp20 == true) {
				r21 = r21.append(e15);
			}
		}
		r24 = javaslang.collection.List.empty();

		for (IAbstractTypeDeclaration e14 : r21) {
			/* 31:89-31:133: e.oclIsTypeOf(JMM!AnnotationTypeDeclaration) */
			op22 = e14 != null && "AnnotationTypeDeclaration".equals(e14.getTypeId());

			tmp23 = !op22;

			if (tmp23 == true) {
				r24 = r24.append(e14);
			}
		}
		t110.setName(get11);

		itTmp29 = new ArrayList<String>();

		for (IdentifiableElement o : get12) {
			boolean matched2 = false;
			if (check_Package2Package(o)) {
				itTmp29.add(TraceFunction.resolve(o.getId(), 0, "Package2Package"));
			}
		}
		t110.setPackagedElement(itTmp29.toArray(new String[itTmp29.size()]));

		itTmp30 = new ArrayList<String>();

		for (IdentifiableElement o : r24) {
			boolean matched3 = false;
			if (check_Class2Class(o)) {
				itTmp30.add(TraceFunction.resolve(o.getId(), 0, "Class2Class"));
			} else if (check_Interface2Interface(o)) {
				itTmp30.add(TraceFunction.resolve(o.getId(), 0, "Interface2Interface"));
			}
		}
		t110.setPackagedElement(itTmp30.toArray(new String[itTmp30.size()]));

		_area_UCD.write(t110);
	}

	public void create_Class2Class(IClassDeclaration s1) throws BlackboardException {
		Class t131;
		java.lang.String get32;
		java.lang.Object tmp33;
		IModifier get34;
		java.lang.String id35;
		boolean op36;
		IModifier get37;
		java.lang.String id38;
		InheritanceKind get39;
		java.lang.String tmp40;
		boolean tmp41;
		boolean r42;
		java.lang.Object tmp43;
		ITypeAccess get44;
		java.lang.String id45;
		boolean op46;
		ITypeAccess get47;
		java.lang.String id48;
		IGeneralization call49;
		IGeneralization r50;
		javaslang.collection.List<ITypeAccess> get51;
		java.lang.String[] id52;
		javaslang.collection.List<IBodyDeclaration> get54;
		java.lang.String[] id55;
		boolean op56;
		javaslang.collection.List<IFieldDeclaration> r57;
		javaslang.collection.List<IBodyDeclaration> get59;
		java.lang.String[] id60;
		boolean op61;
		boolean op62;
		boolean tmp63;
		javaslang.collection.List<IBodyDeclaration> r64;
		List<java.lang.String> itTmp69;
		List<java.lang.String> itTmp70;
		List<java.lang.String> itTmp71;
		t131 = new umlmm.Class();

		t131.setTrgId("UMLMM");

		t131.setId(TraceFunction.create(s1.getId(), 0, "Class2Class"));

		/* 41:12-41:19: s1.name */
		get32 = s1.getName();

		/*
		 * 42:18-42:115: if ( s1.modifier.oclIsUndefined() ) then OclUndefined
		 * else s1.modifier.inheritance = 'abstract' endif
		 */
		/* 42:21-42:49: s1.modifier.oclIsUndefined() */
		/* 42:21-42:32: s1.modifier */
		id35 = s1.getModifier();

		get34 = (jmm.IModifier) read(_area_CM, id35);

		op36 = get34 == null;

		r42 = false;

		if (op36) {
			tmp33 = null;

			r42 = (boolean) tmp33;
		} else { /* 42:73-42:96: s1.modifier.inheritance */
			/* 42:73-42:84: s1.modifier */
			id38 = s1.getModifier();

			get37 = (jmm.IModifier) read(_area_CM, id38);

			get39 = get37.getInheritance();

			tmp40 = "abstract";

			tmp41 = get39.equals(tmp40);

			r42 = tmp41;
		}
		/*
		 * 45:5-49:10: if ( s1.superClass.oclIsUndefined() ) then OclUndefined
		 * else thisModule.createGeneralization(s1.superClass) endif
		 */
		/* 45:8-45:38: s1.superClass.oclIsUndefined() */
		/* 45:8-45:21: s1.superClass */
		id45 = s1.getSuperClass();

		get44 = (jmm.ITypeAccess) read(_area_CM, id45);

		op46 = get44 == null;

		r50 = null;

		if (op46) {
			tmp43 = null;

			r50 = (umlmm.IGeneralization) tmp43;
		} else { /*
					 * 48:6-48:52: thisModule.createGeneralization(s1.superClass)
					 */
			/* 48:38-48:51: s1.superClass */
			id48 = s1.getSuperClass();

			get47 = (jmm.ITypeAccess) read(_area_CM, id48);

			call49 = lazy_rule_createGeneralization(get47);

			r50 = call49;
		}
		/* 50:28-50:46: s1.superInterfaces */
		id52 = s1.getSuperInterfaces();

		get51 = javaslang.collection.List.ofAll(
				new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.ITypeAccess>(_area_CM.readAll(toList(id52))));

		/*
		 * 51:22-51:92: s1.bodyDeclarations->select(e |
		 * e.oclIsTypeOf(JMM!FieldDeclaration))
		 */
		/* 51:22-51:41: s1.bodyDeclarations */
		id55 = s1.getBodyDeclarations();

		get54 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.IBodyDeclaration>(
						_area_CM.readAll(toList(id55))));

		r57 = javaslang.collection.List.empty();

		for (IBodyDeclaration e53 : get54) {
			/* 51:56-51:91: e.oclIsTypeOf(JMM!FieldDeclaration) */
			op56 = e53 != null && "FieldDeclaration".equals(e53.getTypeId());

			if (op56 == true) {
				r57 = r57.append((jmm.IFieldDeclaration) e53);
			}
		}
		/*
		 * 52:22-53:98: s1.bodyDeclarations->select(e |
		 * e.oclIsTypeOf(JMM!MethodDeclaration) or
		 * e.oclIsTypeOf(JMM!ConstructorDeclaration))
		 */
		/* 52:22-52:41: s1.bodyDeclarations */
		id60 = s1.getBodyDeclarations();

		get59 = javaslang.collection.List
				.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<jmm.IBodyDeclaration>(
						_area_CM.readAll(toList(id60))));

		r64 = javaslang.collection.List.empty();

		for (IBodyDeclaration e58 : get59) {
			/* 52:56-52:92: e.oclIsTypeOf(JMM!MethodDeclaration) */
			op61 = e58 != null && "MethodDeclaration".equals(e58.getTypeId());

			/* 53:56-53:97: e.oclIsTypeOf(JMM!ConstructorDeclaration) */
			op62 = e58 != null && "ConstructorDeclaration".equals(e58.getTypeId());

			tmp63 = op61 || op62;

			if (tmp63 == true) {
				r64 = r64.append(e58);
			}
		}
		t131.setName(get32);

		t131.setIsAbstract(r42);

		boolean matched4 = false;
		if (isTargetElement(r50)) {
			t131.setGeneralization(new String[] { r50.getId() });
		}

		itTmp69 = new ArrayList<String>();

		for (IdentifiableElement o : get51) {
			boolean matched5 = false;
		}
		t131.setInterfaceRealization(itTmp69.toArray(new String[itTmp69.size()]));

		itTmp70 = new ArrayList<String>();

		for (IdentifiableElement o : r57) {
			boolean matched6 = false;
		}
		t131.setOwnedAttribute(itTmp70.toArray(new String[itTmp70.size()]));

		itTmp71 = new ArrayList<String>();

		for (IdentifiableElement o : r64) {
			boolean matched7 = false;
			if (check_Class2Class(o)) {
				itTmp71.add(TraceFunction.resolve(o.getId(), 0, "Class2Class"));
			} else if (check_Interface2Interface(o)) {
				itTmp71.add(TraceFunction.resolve(o.getId(), 0, "Interface2Interface"));
			}
		}
		t131.setOwnedOperation(itTmp71.toArray(new String[itTmp71.size()]));

		_area_UCD.write(t131);
	}

	public void create_Interface2Interface(IInterfaceDeclaration s1) throws BlackboardException {
		Interface t175;
		java.lang.String get76;
		t175 = new umlmm.Interface();

		t175.setTrgId("UMLMM");

		t175.setId(TraceFunction.create(s1.getId(), 0, "Interface2Interface"));

		/* 70:12-70:19: s1.name */
		get76 = s1.getName();

		t175.setName(get76);

		_area_UCD.write(t175);
	}

	public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (IdentifiableElement e : objs) {
			boolean matched8 = false;
			if (check_Model2Model(e)) {
				create_Model2Model((jmm.IModel) e);
			} else if (check_Package2Package(e)) {
				create_Package2Package((jmm.IPackage) e);
			} else if (check_Class2Class(e)) {
				create_Class2Class((jmm.IClassDeclaration) e);
			} else if (check_Interface2Interface(e)) {
				create_Interface2Interface((jmm.IInterfaceDeclaration) e);
			}
		}
	}
}