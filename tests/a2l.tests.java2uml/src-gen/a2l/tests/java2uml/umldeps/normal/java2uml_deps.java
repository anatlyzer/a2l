package a2l.tests.java2uml.umldeps.normal;

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
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.Type;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.PrimitiveType;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.Class;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.InheritanceKind;

public class java2uml_deps implements ITransformation, lintra2.transfo.ITransformation2{
private IModel CMModel_;
	private IOutputModel UCDModel_;
	private PartialOutputModel UCDModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.java2uml.umldeps.normal.java2uml_depsGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public java2uml_deps(a2l.runtime.InputExtent inputExtent,a2l.tests.java2uml.umldeps.normal.java2uml_depsGlobalContext global) {
this.inputExtent = inputExtent;
this.globalContext = global;
this.UCDModel_PartialOutput_ = new PartialOutputModel();
this.trace = global.createPartialTrace();; }protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }
protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) { javaslang.collection.List<T> list_result = globalContext.getFromAllInstancesCache(klass, () -> {javaslang.collection.List<T> CM = javaslang.collection.List.ofAll(CMModel_.allInstances()).  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
javaslang.collection.List<T> result = javaslang.collection.List.empty();
result = result.appendAll(CM);return result;

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
final Collection<? extends org.eclipse.emf.ecore.EObject> objects_UCD = (Collection<? extends org.eclipse.emf.ecore.EObject>)UCDModel_PartialOutput_.allInstances();for(org.eclipse.emf.ecore.EObject obj : objects_UCD) {		if (obj.eContainer() == null) {			UCDModel_.add(obj);		}}}

private java.util.ArrayList<IPendingTask> pendingTasks = new java.util.ArrayList<>();private java.util.ArrayList<IPendingTask> parallelPendingTasks = new java.util.ArrayList<>();interface IPendingTask { public void execute(a2l.runtime.GlobalTrace globalTrace); }

protected String get_UML_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.uml2.common.util.UML2Util.getXMIIdentifier((org.eclipse.emf.ecore.InternalEObject) obj); }

private static final class PendingTask_Package_packagedElement implements IPendingTask { 
private final org.eclipse.uml2.uml.Package tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Package_packagedElement(org.eclipse.uml2.uml.Package tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_Package_packagedElement(org.eclipse.uml2.uml.Package tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof org.eclipse.uml2.uml.PackageableElement) { result.add(tgt); }}
tgt.getPackagedElements().addAll((Collection<? extends org.eclipse.uml2.uml.PackageableElement>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof org.eclipse.uml2.uml.PackageableElement) { result.add(tgt); }   }}tgt.getPackagedElements().addAll((Collection<? extends org.eclipse.uml2.uml.PackageableElement>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Dependency_supplier implements IPendingTask { 
private final org.eclipse.uml2.uml.Dependency tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Dependency_supplier(org.eclipse.uml2.uml.Dependency tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_Dependency_supplier(org.eclipse.uml2.uml.Dependency tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof org.eclipse.uml2.uml.NamedElement) { result.add(tgt); }}
tgt.getSuppliers().addAll((Collection<? extends org.eclipse.uml2.uml.NamedElement>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof org.eclipse.uml2.uml.NamedElement) { result.add(tgt); }   }}tgt.getSuppliers().addAll((Collection<? extends org.eclipse.uml2.uml.NamedElement>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Dependency_client implements IPendingTask { 
private final org.eclipse.uml2.uml.Dependency tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Dependency_client(org.eclipse.uml2.uml.Dependency tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_Dependency_client(org.eclipse.uml2.uml.Dependency tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof org.eclipse.uml2.uml.NamedElement) { result.add(tgt); }}
tgt.getClients().addAll((Collection<? extends org.eclipse.uml2.uml.NamedElement>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof org.eclipse.uml2.uml.NamedElement) { result.add(tgt); }   }}tgt.getClients().addAll((Collection<? extends org.eclipse.uml2.uml.NamedElement>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}
private boolean check_Model2Model(java.lang.Object s1){
return s1 instanceof org.eclipse.gmt.modisco.java.Model;
}
	private boolean check_Package2Package(java.lang.Object s1){
org.eclipse.gmt.modisco.java.Package tmp134;
boolean get135;
boolean tmp136;
boolean tmp137;if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
tmp134 = (org.eclipse.gmt.modisco.java.Package)s1;

	/* 50:24-50:32: s1.proxy*/
	get135 = tmp134.isProxy();

	tmp136 = false;

	tmp137 = get135 == tmp136;

	return tmp137 == true;
}
	return false;
}
	private boolean check_Class2Class(java.lang.Object s1){
ClassDeclaration tmp154;
boolean get155;
boolean tmp156;
boolean tmp157;if ( s1 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
tmp154 = (org.eclipse.gmt.modisco.java.ClassDeclaration)s1;

	/* 66:33-66:41: s1.proxy*/
	get155 = tmp154.isProxy();

	tmp156 = false;

	tmp157 = get155 == tmp156;

	return tmp157 == true;
}
	return false;
}
	public Dependency lazy_rule_createGeneralizationDependency(ClassDeclaration class_){
Dependency gTgt158;
java.lang.String tmp159;
java.lang.String get160;
java.lang.String tmp161;
java.lang.String tmp162;
java.lang.String tmp163;
TypeAccess get164;
Type get165;
java.lang.String get166;
java.lang.String tmp167;
TypeAccess get168;
Type get169;gTgt158 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency();

	UCDModel_PartialOutput_.write(gTgt158);

	tmp159 = "generalization pointing from ";

	/* 76:49-76:59: class.name*/
	get160 = class_.getName();

	tmp161 = tmp159 + get160;

	tmp162 = " to ";

	tmp163 = tmp161 + tmp162;

	/* 76:71-76:97: class.superClass.type.name*/
	/* 76:71-76:92: class.superClass.type*/
	/* 76:71-76:87: class.superClass*/
	get164 = class_.getSuperClass();

	get165 = get164.getType();

	get166 = get165.getName();

	tmp167 = tmp163 + get166;

	/* 77:15-77:36: class.superClass.type*/
	/* 77:15-77:31: class.superClass*/
	get168 = class_.getSuperClass();

	get169 = get168.getType();

	gTgt158.setName(tmp167);;

	boolean matched0 = false;if ( check_Class2Class( get169) )  {
this.parallelPendingTasks.add( new PendingTask_Dependency_supplier(gTgt158,get169,UCDModel_, null) );
}

	boolean matched1 = false;if ( check_Class2Class( class_) )  {
this.parallelPendingTasks.add( new PendingTask_Dependency_client(gTgt158,class_,UCDModel_, null) );
}

	return gTgt158;
}
	public Dependency lazy_rule_createUsageDependency(FieldDeclaration field){
Dependency gTgt170;
java.lang.String tmp171;
java.lang.String tmp172;
java.lang.String tmp173;
java.lang.String tmp174;
java.lang.String tmp175;
TypeAccess get176;
Type get177;
java.lang.String get178;
java.lang.String tmp179;
TypeAccess get180;
Type get181;
javaslang.collection.List<ClassDeclaration> call183;
javaslang.collection.List<BodyDeclaration> get184;
boolean op185;
ClassDeclaration r186;gTgt170 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency();

	UCDModel_PartialOutput_.write(gTgt170);

	tmp171 = "field pointing from ";

	tmp172 = "xx";

	tmp173 = tmp171 + tmp172;

	tmp174 = " to ";

	tmp175 = tmp173 + tmp174;

	/* 86:52-86:72: field.type.type.name*/
	/* 86:52-86:67: field.type.type*/
	/* 86:52-86:62: field.type*/
	get176 = field.getType();

	get177 = get176.getType();

	get178 = get177.getName();

	tmp179 = tmp175 + get178;

	/* 87:16-87:31: field.type.type*/
	/* 87:16-87:26: field.type*/
	get180 = field.getType();

	get181 = get180.getType();

	/* 90:15-90:84: thisModule.allClasses->any(cd | cd.bodyDeclarations->includes(field))*/
	/* 90:15-90:36: thisModule.allClasses*/
	call183 = helper_global_allClasses();

	r186 = null;

	for ( ClassDeclaration cd182: call183) {
/* 90:47-90:83: cd.bodyDeclarations->includes(field)*/
	/* 90:47-90:66: cd.bodyDeclarations*/
	get184 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(cd182.getBodyDeclarations()));

	op185 = get184.contains(field);

	if ( op185) {
r186 = cd182;

	break;
}}
	gTgt170.setName(tmp179);;

	boolean matched2 = false;if ( check_Class2Class( get181) )  {
this.parallelPendingTasks.add( new PendingTask_Dependency_supplier(gTgt170,get181,UCDModel_, null) );
}

	boolean matched3 = false;if ( check_Class2Class( r186) )  {
this.parallelPendingTasks.add( new PendingTask_Dependency_client(gTgt170,r186,UCDModel_, null) );
}

	return gTgt170;
}
	public javaslang.collection.List<ClassDeclaration> helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage(org.eclipse.gmt.modisco.java.Package self_){
javaslang.collection.List<AbstractTypeDeclaration> get3;
boolean get4;
boolean tmp5;
boolean tmp6;
javaslang.collection.List<AbstractTypeDeclaration> r7;
boolean op8;
javaslang.collection.List<ClassDeclaration> r9;/* 16:2-16:102: self.ownedElements->select(e | e.proxy = false)->select(e | e.oclIsTypeOf(JMM!ClassDeclaration))*/
	/* 16:2-16:51: self.ownedElements->select(e | e.proxy = false)*/
	/* 16:2-16:20: self.ownedElements*/
	get3 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.AbstractTypeDeclaration>(self_.getOwnedElements()));

	r7 = javaslang.collection.List.empty();

	for ( AbstractTypeDeclaration e2: get3) {
/* 16:35-16:42: e.proxy*/
	get4 = e2.isProxy();

	tmp5 = false;

	tmp6 = get4 == tmp5;

	if ( tmp6 == true) {
r7 = r7.append(e2);
}}
	r9 = javaslang.collection.List.empty();

	for ( AbstractTypeDeclaration e1: r7) {
/* 16:66-16:101: e.oclIsTypeOf(JMM!ClassDeclaration)*/
	op8 = e1!= null && e1.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	if ( op8 == true) {
r9 = r9.append((org.eclipse.gmt.modisco.java.ClassDeclaration)e1);
}}
	return r9;
}
	public Type helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getSuperClass(ClassDeclaration self_){
java.lang.Object tmp10;
TypeAccess get11;
boolean op12;
TypeAccess get13;
Type get14;
TypeAccess get15;
Type get16;
boolean get17;
boolean tmp18;
boolean tmp19;
TypeAccess get20;
Type get21;
boolean op22;
boolean tmp23;
java.lang.Object tmp24;
Type r25;
Type r26;/* 19:3-26:8: if self.superClass.oclIsUndefined() then
	OclUndefined
else
	if self.superClass.type.proxy = false and self.superClass.type.oclIsTypeOf(JMM!ClassDeclaration) then
	self.superClass.type
else
	OclUndefined
endif
endif*/
	/* 19:6-19:38: self.superClass.oclIsUndefined()*/
	/* 19:6-19:21: self.superClass*/
	get11 = self_.getSuperClass();

	op12 = get11== null;

	r26 = null;

	if ( op12) {
tmp10 = null;

	r26 = (org.eclipse.gmt.modisco.java.Type)tmp10;
} else { /* 22:3-25:8: if self.superClass.type.proxy = false and self.superClass.type.oclIsTypeOf(JMM!ClassDeclaration) then
	self.superClass.type
else
	OclUndefined
endif*/
/* 22:7-22:33: self.superClass.type.proxy*/
/* 22:7-22:27: self.superClass.type*/
/* 22:7-22:22: self.superClass*/
get15 = self_.getSuperClass();

get16 = get15.getType();

get17 = get16.isProxy();

tmp18 = false;

tmp19 = get17 == tmp18;

/* 22:46-22:100: self.superClass.type.oclIsTypeOf(JMM!ClassDeclaration)*/
/* 22:46-22:66: self.superClass.type*/
/* 22:46-22:61: self.superClass*/
get20 = self_.getSuperClass();

get21 = get20.getType();

op22 = get21!= null && get21.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

tmp23 = tmp19 && op22;

r25 = null;

if ( tmp23) {
/* 23:8-23:28: self.superClass.type*/
	/* 23:8-23:23: self.superClass*/
	get13 = self_.getSuperClass();

	get14 = get13.getType();

	r25 = get14;
} else { tmp24 = null;

r25 = (org.eclipse.gmt.modisco.java.Type)tmp24;
}
r26 = r25;
}
	return r26;
}
	public javaslang.collection.List<FieldDeclaration> helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getRefClassFields(ClassDeclaration self_){
javaslang.collection.List<BodyDeclaration> get29;
boolean op30;
javaslang.collection.List<FieldDeclaration> r31;
TypeAccess get32;
Type get33;
boolean get34;
boolean tmp35;
boolean tmp36;
TypeAccess get37;
boolean call38;
boolean tmp39;
boolean tmp40;
TypeAccess get41;
Type get42;
boolean op43;
boolean tmp44;
javaslang.collection.List<FieldDeclaration> r45;/* 29:5-30:126: self.bodyDeclarations->select(e | e.oclIsTypeOf(JMM!FieldDeclaration))->select(e | e.type.type.proxy = false and not e.type.isPrimitiveType() and e.type.type.oclIsTypeOf(JMM!ClassDeclaration))*/
	/* 29:5-29:77: self.bodyDeclarations->select(e | e.oclIsTypeOf(JMM!FieldDeclaration))*/
	/* 29:5-29:26: self.bodyDeclarations*/
	get29 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(self_.getBodyDeclarations()));

	r31 = javaslang.collection.List.empty();

	for ( BodyDeclaration e28: get29) {
/* 29:41-29:76: e.oclIsTypeOf(JMM!FieldDeclaration)*/
	op30 = e28!= null && e28.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.FieldDeclaration.class;

	if ( op30 == true) {
r31 = r31.append((org.eclipse.gmt.modisco.java.FieldDeclaration)e28);
}}
	r45 = javaslang.collection.List.empty();

	for ( FieldDeclaration e27: r31) {
/* 30:17-30:34: e.type.type.proxy*/
	/* 30:17-30:28: e.type.type*/
	/* 30:17-30:23: e.type*/
	get32 = e27.getType();

	get33 = get32.getType();

	get34 = get33.isProxy();

	tmp35 = false;

	tmp36 = get34 == tmp35;

	/* 30:51-30:75: e.type.isPrimitiveType()*/
	/* 30:51-30:57: e.type*/
	get37 = e27.getType();

	if ( get37 instanceof org.eclipse.gmt.modisco.java.TypeAccess) {
call38 = helper_org_eclipse_gmt_modisco_java_TypeAccess_isPrimitiveType((org.eclipse.gmt.modisco.java.TypeAccess)get37);
} else { throw new IllegalStateException();
}
	tmp39 = ! call38;

	tmp40 = tmp36 && tmp39;

	/* 30:80-30:125: e.type.type.oclIsTypeOf(JMM!ClassDeclaration)*/
	/* 30:80-30:91: e.type.type*/
	/* 30:80-30:86: e.type*/
	get41 = e27.getType();

	get42 = get41.getType();

	op43 = get42!= null && get42.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	tmp44 = tmp40 && op43;

	if ( tmp44 == true) {
r45 = r45.append(e27);
}}
	return r45;
}
	public boolean helper_org_eclipse_gmt_modisco_java_TypeAccess_isPrimitiveType(TypeAccess self_){
boolean tmp46;
Type get47;
boolean op48;
Type get49;
java.lang.String get50;
Type cast51;
java.lang.String tmp52;
boolean tmp53;
Type get54;
java.lang.String get55;
Type cast56;
java.lang.String tmp57;
boolean tmp58;
boolean tmp59;
Type get60;
java.lang.String get61;
Type cast62;
java.lang.String tmp63;
boolean tmp64;
boolean tmp65;
Type get66;
java.lang.String get67;
Type cast68;
java.lang.String tmp69;
boolean tmp70;
boolean tmp71;
Type get72;
java.lang.String get73;
Type cast74;
java.lang.String tmp75;
boolean tmp76;
boolean tmp77;
Type get78;
java.lang.String get79;
Type cast80;
java.lang.String tmp81;
boolean tmp82;
boolean tmp83;
Type get84;
java.lang.String get85;
Type cast86;
java.lang.String tmp87;
boolean tmp88;
boolean tmp89;
Type get90;
java.lang.String get91;
Type cast92;
java.lang.String tmp93;
boolean tmp94;
boolean tmp95;
boolean r96;/* 33:2-39:7: if self.type.oclIsKindOf(JMM!PrimitiveType) then
	true
else
	self.type.name = 'String' or self.type.name = 'Integer' or self.type.name = 'Long' or self.type.name = 'Short' or self.type.name = 'Float' or self.type.name = 'Double' or self.type.name = 'Boolean' or self.type.name = 'Number'
endif*/
	/* 33:6-33:46: self.type.oclIsKindOf(JMM!PrimitiveType)*/
	/* 33:6-33:15: self.type*/
	get47 = self_.getType();

	op48 = get47 instanceof org.eclipse.gmt.modisco.java.PrimitiveType;

	r96 = false;

	if ( op48) {
tmp46 = true;

	r96 = tmp46;
} else { /* 35:4-35:18: self.type.name*/
/* 35:4-35:13: self.type*/
get49 = self_.getType();

cast51 = (org.eclipse.gmt.modisco.java.Type)get49;

get50 = cast51.getName();

tmp52 = "String";

tmp53 = get50. equals(tmp52);

/* 35:35-35:49: self.type.name*/
/* 35:35-35:44: self.type*/
get54 = self_.getType();

cast56 = (org.eclipse.gmt.modisco.java.Type)get54;

get55 = cast56.getName();

tmp57 = "Integer";

tmp58 = get55. equals(tmp57);

tmp59 = tmp53 || tmp58;

/* 36:7-36:21: self.type.name*/
/* 36:7-36:16: self.type*/
get60 = self_.getType();

cast62 = (org.eclipse.gmt.modisco.java.Type)get60;

get61 = cast62.getName();

tmp63 = "Long";

tmp64 = get61. equals(tmp63);

tmp65 = tmp59 || tmp64;

/* 36:36-36:50: self.type.name*/
/* 36:36-36:45: self.type*/
get66 = self_.getType();

cast68 = (org.eclipse.gmt.modisco.java.Type)get66;

get67 = cast68.getName();

tmp69 = "Short";

tmp70 = get67. equals(tmp69);

tmp71 = tmp65 || tmp70;

/* 37:7-37:21: self.type.name*/
/* 37:7-37:16: self.type*/
get72 = self_.getType();

cast74 = (org.eclipse.gmt.modisco.java.Type)get72;

get73 = cast74.getName();

tmp75 = "Float";

tmp76 = get73. equals(tmp75);

tmp77 = tmp71 || tmp76;

/* 37:37-37:51: self.type.name*/
/* 37:37-37:46: self.type*/
get78 = self_.getType();

cast80 = (org.eclipse.gmt.modisco.java.Type)get78;

get79 = cast80.getName();

tmp81 = "Double";

tmp82 = get79. equals(tmp81);

tmp83 = tmp77 || tmp82;

/* 38:7-38:21: self.type.name*/
/* 38:7-38:16: self.type*/
get84 = self_.getType();

cast86 = (org.eclipse.gmt.modisco.java.Type)get84;

get85 = cast86.getName();

tmp87 = "Boolean";

tmp88 = get85. equals(tmp87);

tmp89 = tmp83 || tmp88;

/* 38:39-38:53: self.type.name*/
/* 38:39-38:48: self.type*/
get90 = self_.getType();

cast92 = (org.eclipse.gmt.modisco.java.Type)get90;

get91 = cast92.getName();

tmp93 = "Number";

tmp94 = get91. equals(tmp93);

tmp95 = tmp89 || tmp94;

r96 = tmp95;
}
	return r96;
}
	public javaslang.collection.List<ClassDeclaration> helper_global_allClasses(){
javaslang.collection.List<ClassDeclaration> op0;/* 13:60-13:95: JMM!ClassDeclaration.allInstances()*/
	op0 = this.globalContext.getAllInstancesOf_ClassDeclaration();

	return op0;
}
	public boolean isTargetElement(java.lang.Object obj){
if ( obj == null ) return false;;

	return UCDModel_PartialOutput_.belongsTo(obj);
}
	public IModel findModelDynamically(java.lang.Object obj){
if ( CMModel_.belongsTo(obj)) return CMModel_; 
 if ( UCDModel_.belongsTo(obj)) return UCDModel_;
throw new IllegalStateException();
}
	public a2l.tests.java2uml.umldeps.normal.java2uml_deps setCM(IModel n){
CMModel_ = n;

	return this;
}
	public a2l.tests.java2uml.umldeps.normal.java2uml_deps setUCD(IOutputModel n){
UCDModel_ = n;

	n.addPartial(UCDModel_PartialOutput_);

	return this;
}
	private void create_Model2Model(org.eclipse.gmt.modisco.java.Model s1){
org.eclipse.uml2.uml.Model t197;
java.lang.String get98;
javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> get100;
boolean get101;
boolean tmp102;
boolean tmp103;
javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> r104;
List<java.lang.Object> itTmp105;t197 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createModel();

	this.trace.put(s1,t197);

	UCDModel_PartialOutput_.write(t197);

	/* 44:12-44:19: s1.name*/
	get98 = s1.getName();

	/* 45:23-45:70: s1.ownedElements->select(e | e.proxy = false)*/
	/* 45:23-45:39: s1.ownedElements*/
	get100 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.Package>(s1.getOwnedElements()));

	r104 = javaslang.collection.List.empty();

	for ( org.eclipse.gmt.modisco.java.Package e99: get100) {
/* 45:54-45:61: e.proxy*/
	get101 = e99.isProxy();

	tmp102 = false;

	tmp103 = get101 == tmp102;

	if ( tmp103 == true) {
r104 = r104.append(e99);
}}
	t197.setName(get98);;

	itTmp105 = new ArrayList<Object>();

	for ( java.lang.Object o: r104) {
boolean matched4 = false;if ( check_Package2Package( o) )  {
itTmp105.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t197,itTmp105,UCDModel_,null) );

	numMatchedRuleExecutions_++;
}
	private void create_Package2Package(org.eclipse.gmt.modisco.java.Package s1){
org.eclipse.uml2.uml.Package t1106;
java.lang.String get107;
javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> get110;
boolean get111;
boolean tmp112;
boolean tmp113;
javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> r114;
boolean op115;
javaslang.collection.List<org.eclipse.gmt.modisco.java.Package> r116;
javaslang.collection.List<ClassDeclaration> call117;
javaslang.collection.List<ClassDeclaration> call119;
java.lang.Object tmp120;
Type call121;
boolean op122;
Dependency call123;
Dependency r124;
javaslang.collection.List<Dependency> r125;
javaslang.collection.List<ClassDeclaration> call128;
javaslang.collection.List<FieldDeclaration> call129;
javaslang.collection.List<javaslang.collection.List<FieldDeclaration>> r130;
javaslang.collection.List<FieldDeclaration> op131;
Dependency call132;
javaslang.collection.List<Dependency> r133;
List<java.lang.Object> itTmp138;
List<java.lang.Object> itTmp139;
List<java.lang.Object> itTmp140;
java.util.Set<java.lang.Object> tgtElems141;
List<java.lang.Object> itTmp142;
java.util.Set<java.lang.Object> tgtElems143;t1106 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage();

	this.trace.put(s1,t1106);

	UCDModel_PartialOutput_.write(t1106);

	/* 52:12-52:19: s1.name*/
	get107 = s1.getName();

	/* 53:23-53:112: s1.ownedPackages->select(e | e.proxy = false)->select(e | e.oclIsTypeOf(JMM!Package))*/
	/* 53:23-53:70: s1.ownedPackages->select(e | e.proxy = false)*/
	/* 53:23-53:39: s1.ownedPackages*/
	get110 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.Package>(s1.getOwnedPackages()));

	r114 = javaslang.collection.List.empty();

	for ( org.eclipse.gmt.modisco.java.Package e109: get110) {
/* 53:54-53:61: e.proxy*/
	get111 = e109.isProxy();

	tmp112 = false;

	tmp113 = get111 == tmp112;

	if ( tmp113 == true) {
r114 = r114.append(e109);
}}
	r116 = javaslang.collection.List.empty();

	for ( org.eclipse.gmt.modisco.java.Package e108: r114) {
/* 53:85-53:111: e.oclIsTypeOf(JMM!Package)*/
	op115 = e108!= null && e108.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.Package.class;

	if ( op115 == true) {
r116 = r116.append((org.eclipse.gmt.modisco.java.Package)e108);
}}
	/* 54:23-54:53: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call117 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	/* 55:23-59:20: s1.allNonProxyClassesInPackage->collect(s2 | if s2.getSuperClass.oclIsUndefined() then
	OclUndefined
else
	thisModule.createGeneralizationDependency(s2)
endif)*/
	/* 55:23-55:53: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call119 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	r125 = javaslang.collection.List.empty();

	for ( ClassDeclaration s2118: call119) {
/* 56:26-59:19: if s2.getSuperClass.oclIsUndefined() then
	OclUndefined
else
	thisModule.createGeneralizationDependency(s2)
endif*/
	/* 56:29-56:62: s2.getSuperClass.oclIsUndefined()*/
	/* 56:29-56:45: s2.getSuperClass*/
	if ( s2118 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call121 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getSuperClass((org.eclipse.gmt.modisco.java.ClassDeclaration)s2118);
} else { throw new IllegalStateException();
}
	op122 = call121== null;

	r124 = null;

	if ( op122) {
tmp120 = null;

	r124 = (org.eclipse.uml2.uml.Dependency)tmp120;
} else { /* 58:20-58:65: thisModule.createGeneralizationDependency(s2)*/
call123 = lazy_rule_createGeneralizationDependency(s2118);

r124 = call123;
}
	r125 = r125.append(r124);
}
	/* 60:24-61:110: s1.allNonProxyClassesInPackage->collect(s2 | s2.getRefClassFields)->flatten()->collect(e | thisModule.createUsageDependency(e))*/
	/* 60:24-61:60: s1.allNonProxyClassesInPackage->collect(s2 | s2.getRefClassFields)->flatten()*/
	/* 60:24-61:47: s1.allNonProxyClassesInPackage->collect(s2 | s2.getRefClassFields)*/
	/* 60:24-60:54: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call128 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	r130 = javaslang.collection.List.empty();

	for ( ClassDeclaration s2127: call128) {
/* 61:26-61:46: s2.getRefClassFields*/
	if ( s2127 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call129 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getRefClassFields((org.eclipse.gmt.modisco.java.ClassDeclaration)s2127);
} else { throw new IllegalStateException();
}
	r130 = r130.append(call129);
}
	op131 = flatten(r130).map(x_ -> (org.eclipse.gmt.modisco.java.FieldDeclaration)x_);

	r133 = javaslang.collection.List.empty();

	for ( FieldDeclaration e126: op131) {
/* 61:74-61:109: thisModule.createUsageDependency(e)*/
	call132 = lazy_rule_createUsageDependency(e126);

	r133 = r133.append(call132);
}
	t1106.setName(get107);;

	itTmp138 = new ArrayList<Object>();

	for ( java.lang.Object o: r116) {
boolean matched5 = false;if ( check_Package2Package( o) )  {
itTmp138.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t1106,itTmp138,UCDModel_,null) );

	itTmp139 = new ArrayList<Object>();

	for ( java.lang.Object o: call117) {
boolean matched6 = false;if ( check_Class2Class( o) )  {
itTmp139.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t1106,itTmp139,UCDModel_,null) );

	itTmp140 = new ArrayList<Object>();

	tgtElems141 = new java.util.HashSet<>();

	for ( java.lang.Object o: r125) {
boolean matched7 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp140, tgtElems141, o);
}
	this.parallelPendingTasks.add( new PendingTask_Package_packagedElement(t1106,itTmp140,UCDModel_,tgtElems141) );

	itTmp142 = new ArrayList<Object>();

	tgtElems143 = new java.util.HashSet<>();

	for ( java.lang.Object o: r133) {
boolean matched8 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp142, tgtElems143, o);
}
	this.parallelPendingTasks.add( new PendingTask_Package_packagedElement(t1106,itTmp142,UCDModel_,tgtElems143) );

	numMatchedRuleExecutions_++;
}
	private void create_Class2Class(ClassDeclaration s1){
Class t1144;
java.lang.String get145;
java.lang.Object tmp146;
Modifier get147;
boolean op148;
Modifier get149;
InheritanceKind get150;
java.lang.String tmp151;
boolean tmp152;
boolean r153;t1144 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClass();

	this.trace.put(s1,t1144);

	UCDModel_PartialOutput_.write(t1144);

	/* 68:12-68:19: s1.name*/
	get145 = s1.getName();

	/* 69:18-69:115: if s1.modifier.oclIsUndefined() then
	OclUndefined
else
	s1.modifier.inheritance = 'abstract'
endif*/
	/* 69:21-69:49: s1.modifier.oclIsUndefined()*/
	/* 69:21-69:32: s1.modifier*/
	get147 = s1.getModifier();

	op148 = get147== null;

	r153 = false;

	if ( op148) {
tmp146 = null;

	r153 = (boolean)tmp146;
} else { /* 69:73-69:96: s1.modifier.inheritance*/
/* 69:73-69:84: s1.modifier*/
get149 = s1.getModifier();

get150 = get149.getInheritance();

tmp151 = "abstract";

tmp152 = get150. equals(tmp151);

r153 = tmp152;
}
	t1144.setName(get145);;

	t1144.setIsAbstract(r153);;

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched9 = false;if ( check_Model2Model( e) )  {
create_Model2Model((org.eclipse.gmt.modisco.java.Model)e);
}
else if ( check_Package2Package( e) )  {
create_Package2Package((org.eclipse.gmt.modisco.java.Package)e);
}
else if ( check_Class2Class( e) )  {
create_Class2Class((org.eclipse.gmt.modisco.java.ClassDeclaration)e);
}

	numExecutions_++;
}}