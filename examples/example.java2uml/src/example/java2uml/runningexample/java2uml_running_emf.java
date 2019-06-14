package example.java2uml.runningexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import org.eclipse.gmt.modisco.java.InheritanceKind;
import org.eclipse.gmt.modisco.java.InterfaceDeclaration;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.Type;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Generalization;
import org.eclipse.uml2.uml.Interface;

import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;
import lintra2.transfo.IMaster;
import lintra2.transfo.ITransformation;
import lintra2.transfo.TraceFunction;

public class java2uml_running_emf implements ITransformation {
	private IArea _area_CM;
	private IArea _area_UCD;
	IArea trgArea, cachingArea;

	public java2uml_running_emf(IArea _area_CM, IArea _area_UCD, IArea cachingArea) {
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

	protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) {
		return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString();
	}

	private java.util.concurrent.ConcurrentLinkedQueue<IPendingTask> pendingTasks = new java.util.concurrent.ConcurrentLinkedQueue<>();

	interface IPendingTask {
		public void execute() throws BlackboardException;
	}

	protected String get_UML_Id(org.eclipse.emf.ecore.EObject obj) {
		return org.eclipse.uml2.common.util.UML2Util.getXMIIdentifier((org.eclipse.emf.ecore.InternalEObject) obj);
	}

	class PendingTask_PackageableElement_packagedElement implements IPendingTask {
		private final org.eclipse.uml2.uml.Package tgt;
		private final Collection<String> objId;
		private final IArea area;

		public PendingTask_PackageableElement_packagedElement(org.eclipse.uml2.uml.Package tgt,
				Collection<String> objId, IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.getPackagedElements().addAll((Collection<org.eclipse.uml2.uml.PackageableElement>) area.readAll(objId));
		}
	}

	class PendingTask_Generalization_generalization implements IPendingTask {
		private final org.eclipse.uml2.uml.Classifier tgt;
		private final Collection<String> objId;
		private final IArea area;

		public PendingTask_Generalization_generalization(org.eclipse.uml2.uml.Classifier tgt, Collection<String> objId,
				IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.getGeneralizations().addAll((Collection<org.eclipse.uml2.uml.Generalization>) area.readAll(objId));
		}
	}

	class PendingTask_InterfaceRealization_interfaceRealization implements IPendingTask {
		private final org.eclipse.uml2.uml.BehavioredClassifier tgt;
		private final Collection<String> objId;
		private final IArea area;

		public PendingTask_InterfaceRealization_interfaceRealization(org.eclipse.uml2.uml.BehavioredClassifier tgt,
				Collection<String> objId, IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.getInterfaceRealizations()
					.addAll((Collection<org.eclipse.uml2.uml.InterfaceRealization>) area.readAll(objId));
		}
	}

	class PendingTask_Property_ownedAttribute implements IPendingTask {
		private final org.eclipse.uml2.uml.StructuredClassifier tgt;
		private final Collection<String> objId;
		private final IArea area;

		public PendingTask_Property_ownedAttribute(org.eclipse.uml2.uml.StructuredClassifier tgt,
				Collection<String> objId, IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.getOwnedAttributes().addAll((Collection<org.eclipse.uml2.uml.Property>) area.readAll(objId));
		}
	}

	class PendingTask_Operation_ownedOperation implements IPendingTask {
		private final org.eclipse.uml2.uml.Class tgt;
		private final Collection<String> objId;
		private final IArea area;

		public PendingTask_Operation_ownedOperation(org.eclipse.uml2.uml.Class tgt, Collection<String> objId,
				IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.getOwnedOperations().addAll((Collection<org.eclipse.uml2.uml.Operation>) area.readAll(objId));
		}
	}

	class PendingTask_Classifier_general implements IPendingTask {
		private final org.eclipse.uml2.uml.Generalization tgt;
		private final String objId;
		private final IArea area;

		public PendingTask_Classifier_general(org.eclipse.uml2.uml.Generalization tgt, String objId, IArea area) {
			this.tgt = tgt;
			this.objId = objId;
			this.area = area;
		}

		public void execute() throws BlackboardException {
			tgt.setGeneral((org.eclipse.uml2.uml.Classifier) area.read(objId));
		}
	}

	public boolean check_Model2Model(java.lang.Object s1) throws BlackboardException {
		return s1 instanceof org.eclipse.gmt.modisco.java.Model;
	}

	public boolean check_Package2Package(java.lang.Object s1) throws BlackboardException {
		org.eclipse.gmt.modisco.java.Package tmp22;
		boolean get23;
		boolean tmp24;
		boolean tmp25;
		if (s1 instanceof org.eclipse.gmt.modisco.java.Package) {
			tmp22 = (org.eclipse.gmt.modisco.java.Package) s1;

			/* 26:18-26:26: s1.proxy */
			get23 = tmp22.isProxy();

			tmp24 = false;

			tmp25 = get23 == tmp24;

			return tmp25 == true;
		}
		return false;
	}

	public boolean check_Class2Class(java.lang.Object s1) throws BlackboardException {
		ClassDeclaration tmp55;
		boolean get56;
		boolean tmp57;
		boolean tmp58;
		if (s1 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
			tmp55 = (org.eclipse.gmt.modisco.java.ClassDeclaration) s1;

			/* 38:29-38:37: s1.proxy */
			get56 = tmp55.isProxy();

			tmp57 = false;

			tmp58 = get56 == tmp57;

			return tmp58 == true;
		}
		return false;
	}

	public boolean check_Interface2Interface(java.lang.Object s1) throws BlackboardException {
		InterfaceDeclaration tmp66;
		boolean get67;
		boolean tmp68;
		boolean tmp69;
		if (s1 instanceof org.eclipse.gmt.modisco.java.InterfaceDeclaration) {
			tmp66 = (org.eclipse.gmt.modisco.java.InterfaceDeclaration) s1;

			/* 67:33-67:41: s1.proxy */
			get67 = tmp66.isProxy();

			tmp68 = false;

			tmp69 = get67 == tmp68;

			return tmp69 == true;
		}
		return false;
	}

	public Generalization lazy_rule_createGeneralization(TypeAccess superClass) throws BlackboardException {
		Generalization gTgt62;
		Type get63;
		gTgt62 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createGeneralization();

		_area_UCD.getIdMapper().addMapping(gTgt62, TraceFunction.createUniqueId("createGeneralization"));

		/* 60:14-60:29: superClass.type */
		get63 = superClass.getType();

		boolean matched0 = false;
		if (check_Class2Class(get63)) {
			this.pendingTasks.add(new PendingTask_Classifier_general(gTgt62,
					TraceFunction.resolve(_area_CM.getIdMapper().getId(get63), 0, "Class2Class"), _area_UCD));
		} else if (check_Interface2Interface(get63)) {
			this.pendingTasks.add(new PendingTask_Classifier_general(gTgt62,
					TraceFunction.resolve(_area_CM.getIdMapper().getId(get63), 0, "Interface2Interface"), _area_UCD));
		}

		_area_UCD.write(gTgt62);

		return gTgt62;
	}

	public boolean isTargetElement(java.lang.Object obj) {
		return _area_UCD.getIdMapper().getId(obj) != null;
	}

	public void create_Model2Model(org.eclipse.gmt.modisco.java.Model s1) throws BlackboardException {
		org.eclipse.uml2.uml.Model t10;
		java.lang.String get1;
		javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> get3;
		boolean get4;
		boolean tmp5;
		boolean tmp6;
		javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> r7;
		List<java.lang.String> itTmp8;
		t10 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createModel();

		_area_UCD.getIdMapper().addMapping(t10,
				TraceFunction.create(_area_CM.getIdMapper().getId(s1), 0, "Model2Model"));

		/* 18:12-18:19: s1.name */
		get1 = s1.getName();

		/* 19:23-19:70: s1.ownedElements->select(e | e.proxy = false) */
		/* 19:23-19:39: s1.ownedElements */
		get3 = javaslang.collection.List.ofAll(s1.getOwnedElements());

		r7 = javaslang.collection.List.empty();

		for (org.eclipse.gmt.modisco.java.Package e2 : get3) {
			/* 19:54-19:61: e.proxy */
			get4 = e2.isProxy();

			tmp5 = false;

			tmp6 = get4 == tmp5;

			if (tmp6 == true) {
				r7 = r7.append(e2);
			}
		}
		t10.setName(get1);

		itTmp8 = new ArrayList<String>();

		for (java.lang.Object o : r7) {
			boolean matched1 = false;
			if (check_Package2Package(o)) {
				itTmp8.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Package2Package"));
			}
		}
		this.pendingTasks.add(new PendingTask_PackageableElement_packagedElement(t10, itTmp8, _area_UCD));

		_area_UCD.write(t10);
	}

	public void create_Package2Package(org.eclipse.gmt.modisco.java.Package s1) throws BlackboardException {
		org.eclipse.uml2.uml.Package t19;
		java.lang.String get10;
		javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> get11;
		javaslang.collection.List<AbstractTypeDeclaration> get14;
		boolean get15;
		boolean tmp16;
		boolean tmp17;
		javaslang.collection.List<AbstractTypeDeclaration> r18;
		boolean op19;
		boolean tmp20;
		javaslang.collection.List<AbstractTypeDeclaration> r21;
		List<java.lang.String> itTmp26;
		List<java.lang.String> itTmp27;
		t19 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage();

		_area_UCD.getIdMapper().addMapping(t19,
				TraceFunction.create(_area_CM.getIdMapper().getId(s1), 0, "Package2Package"));

		/* 29:12-29:19: s1.name */
		get10 = s1.getName();

		/* 30:23-30:39: s1.ownedPackages */
		get11 = javaslang.collection.List.ofAll(s1.getOwnedPackages());

		/*
		 * 31:23-31:134: s1.ownedElements->select(e | e.proxy = false)->select(e
		 * | not e.oclIsTypeOf(JMM!AnnotationTypeDeclaration))
		 */
		/* 31:23-31:70: s1.ownedElements->select(e | e.proxy = false) */
		/* 31:23-31:39: s1.ownedElements */
		get14 = javaslang.collection.List.ofAll(s1.getOwnedElements());

		r18 = javaslang.collection.List.empty();

		for (AbstractTypeDeclaration e13 : get14) {
			/* 31:54-31:61: e.proxy */
			get15 = e13.isProxy();

			tmp16 = false;

			tmp17 = get15 == tmp16;

			if (tmp17 == true) {
				r18 = r18.append(e13);
			}
		}
		r21 = javaslang.collection.List.empty();

		for (AbstractTypeDeclaration e12 : r18) {
			/* 31:89-31:133: e.oclIsTypeOf(JMM!AnnotationTypeDeclaration) */
			op19 = e12 != null
					&& e12.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.AnnotationTypeDeclaration.class;

			tmp20 = !op19;

			if (tmp20 == true) {
				r21 = r21.append(e12);
			}
		}
		t19.setName(get10);

		itTmp26 = new ArrayList<String>();

		for (java.lang.Object o : get11) {
			boolean matched2 = false;
			if (check_Package2Package(o)) {
				itTmp26.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Package2Package"));
			}
		}
		this.pendingTasks.add(new PendingTask_PackageableElement_packagedElement(t19, itTmp26, _area_UCD));

		itTmp27 = new ArrayList<String>();

		for (java.lang.Object o : r21) {
			boolean matched3 = false;
			if (check_Interface2Interface(o)) {
				itTmp27.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Interface2Interface"));
			} else if (check_Class2Class(o)) {
				itTmp27.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Class2Class"));
			}
		}
		this.pendingTasks.add(new PendingTask_PackageableElement_packagedElement(t19, itTmp27, _area_UCD));

		_area_UCD.write(t19);
	}

	public void create_Class2Class(ClassDeclaration s1) throws BlackboardException {
		Class t128;
		java.lang.String get29;
		java.lang.Object tmp30;
		Modifier get31;
		boolean op32;
		Modifier get33;
		InheritanceKind get34;
		java.lang.String tmp35;
		boolean tmp36;
		boolean r37;
		java.lang.Object tmp38;
		TypeAccess get39;
		boolean op40;
		TypeAccess get41;
		Generalization call42;
		Generalization r43;
		javaslang.collection.List<TypeAccess> get44;
		javaslang.collection.List<BodyDeclaration> get46;
		boolean op47;
		javaslang.collection.List<FieldDeclaration> r48;
		javaslang.collection.List<BodyDeclaration> get50;
		boolean op51;
		boolean op52;
		boolean tmp53;
		javaslang.collection.List<BodyDeclaration> r54;
		List<java.lang.String> itTmp59;
		List<java.lang.String> itTmp60;
		List<java.lang.String> itTmp61;
		t128 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClass();

		_area_UCD.getIdMapper().addMapping(t128,
				TraceFunction.create(_area_CM.getIdMapper().getId(s1), 0, "Class2Class"));

		/* 41:12-41:19: s1.name */
		get29 = s1.getName();

		/*
		 * 42:18-42:115: if ( s1.modifier.oclIsUndefined() ) then OclUndefined
		 * else s1.modifier.inheritance = 'abstract' endif
		 */
		/* 42:21-42:49: s1.modifier.oclIsUndefined() */
		/* 42:21-42:32: s1.modifier */
		get31 = s1.getModifier();

		op32 = get31 == null;

		r37 = false;

		if (op32) {
			tmp30 = null;

			r37 = (boolean) tmp30;
		} else { /* 42:73-42:96: s1.modifier.inheritance */
			/* 42:73-42:84: s1.modifier */
			get33 = s1.getModifier();

			get34 = get33.getInheritance();

			tmp35 = "abstract";

			tmp36 = get34.equals(tmp35);

			r37 = tmp36;
		}
		/*
		 * 45:5-49:10: if ( s1.superClass.oclIsUndefined() ) then OclUndefined
		 * else thisModule.createGeneralization(s1.superClass) endif
		 */
		/* 45:8-45:38: s1.superClass.oclIsUndefined() */
		/* 45:8-45:21: s1.superClass */
		get39 = s1.getSuperClass();

		op40 = get39 == null;

		r43 = null;

		if (op40) {
			tmp38 = null;

			r43 = (org.eclipse.uml2.uml.Generalization) tmp38;
		} else { /*
					 * 48:6-48:52: thisModule.createGeneralization(s1.superClass)
					 */
			/* 48:38-48:51: s1.superClass */
			get41 = s1.getSuperClass();

			call42 = lazy_rule_createGeneralization(get41);

			r43 = call42;
		}
		/* 50:28-50:46: s1.superInterfaces */
		get44 = javaslang.collection.List.ofAll(s1.getSuperInterfaces());

		/*
		 * 51:22-51:92: s1.bodyDeclarations->select(e |
		 * e.oclIsTypeOf(JMM!FieldDeclaration))
		 */
		/* 51:22-51:41: s1.bodyDeclarations */
		get46 = javaslang.collection.List.ofAll(s1.getBodyDeclarations());

		r48 = javaslang.collection.List.empty();

		for (BodyDeclaration e45 : get46) {
			/* 51:56-51:91: e.oclIsTypeOf(JMM!FieldDeclaration) */
			op47 = e45 != null
					&& e45.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.FieldDeclaration.class;

			if (op47 == true) {
				r48 = r48.append((org.eclipse.gmt.modisco.java.FieldDeclaration) e45);
			}
		}
		/*
		 * 52:22-53:98: s1.bodyDeclarations->select(e |
		 * e.oclIsTypeOf(JMM!MethodDeclaration) or
		 * e.oclIsTypeOf(JMM!ConstructorDeclaration))
		 */
		/* 52:22-52:41: s1.bodyDeclarations */
		get50 = javaslang.collection.List.ofAll(s1.getBodyDeclarations());

		r54 = javaslang.collection.List.empty();

		for (BodyDeclaration e49 : get50) {
			/* 52:56-52:92: e.oclIsTypeOf(JMM!MethodDeclaration) */
			op51 = e49 != null
					&& e49.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.MethodDeclaration.class;

			/* 53:56-53:97: e.oclIsTypeOf(JMM!ConstructorDeclaration) */
			op52 = e49 != null
					&& e49.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ConstructorDeclaration.class;

			tmp53 = op51 || op52;

			if (tmp53 == true) {
				r54 = r54.append(e49);
			}
		}
		t128.setName(get29);

		t128.setIsAbstract(r37);

		boolean matched4 = false;
		if (isTargetElement(r43)) {
			if (r43 != null) {
				t128.getGeneralizations().add(r43);
			}
			;
		}

		itTmp59 = new ArrayList<String>();

		for (java.lang.Object o : get44) {
			boolean matched5 = false;
		}
		this.pendingTasks.add(new PendingTask_InterfaceRealization_interfaceRealization(t128, itTmp59, _area_UCD));

		itTmp60 = new ArrayList<String>();

		for (java.lang.Object o : r48) {
			boolean matched6 = false;
		}
		this.pendingTasks.add(new PendingTask_Property_ownedAttribute(t128, itTmp60, _area_UCD));

		itTmp61 = new ArrayList<String>();

		for (java.lang.Object o : r54) {
			boolean matched7 = false;
			if (check_Interface2Interface(o)) {
				itTmp61.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Interface2Interface"));
			} else if (check_Class2Class(o)) {
				itTmp61.add(TraceFunction.resolve(_area_CM.getIdMapper().getId(o), 0, "Class2Class"));
			}
		}
		this.pendingTasks.add(new PendingTask_Operation_ownedOperation(t128, itTmp61, _area_UCD));

		_area_UCD.write(t128);
	}

	public void create_Interface2Interface(InterfaceDeclaration s1) throws BlackboardException {
		Interface t164;
		java.lang.String get65;
		t164 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createInterface();

		_area_UCD.getIdMapper().addMapping(t164,
				TraceFunction.create(_area_CM.getIdMapper().getId(s1), 0, "Interface2Interface"));

		/* 70:12-70:19: s1.name */
		get65 = s1.getName();

		t164.setName(get65);

		_area_UCD.write(t164);
	}

	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException {
		for (java.lang.Object e : objs) {
			boolean matched8 = false;
			if (check_Model2Model(e)) {
				create_Model2Model((org.eclipse.gmt.modisco.java.Model) e);
			} else if (check_Package2Package(e)) {
				create_Package2Package((org.eclipse.gmt.modisco.java.Package) e);
			} else if (check_Class2Class(e)) {
				create_Class2Class((org.eclipse.gmt.modisco.java.ClassDeclaration) e);
			} else if (check_Interface2Interface(e)) {
				create_Interface2Interface((org.eclipse.gmt.modisco.java.InterfaceDeclaration) e);
			}
		}
	}
	
	public Resource postprocessing() throws BlackboardException {
		for (IPendingTask tasks : pendingTasks) {
			tasks.execute();
		}
		
		ResourceSet rs = new ResourceSetImpl();
		Resource res = rs.createResource(URI.createFileURI("test.xmi"));
		Collection objects = _area_UCD.read(_area_UCD.size());
		for (Object object : objects) {
			EObject obj = (EObject) object;
			if ( obj.eContainer() == null ) {
				res.getContents().add(obj);
			}
		}
		
		return res;
	}	
}