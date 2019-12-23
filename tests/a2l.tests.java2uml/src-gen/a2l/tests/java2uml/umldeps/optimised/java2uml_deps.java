package a2l.tests.java2uml.umldeps.optimised;

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
	private PartialOutputModel UCDModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public java2uml_deps(a2l.runtime.InputExtent inputExtent,a2l.tests.java2uml.umldeps.optimised.java2uml_depsGlobalContext global) {
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
org.eclipse.gmt.modisco.java.Package tmp142;
boolean get143;
boolean tmp144;
boolean tmp145;if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
tmp142 = (org.eclipse.gmt.modisco.java.Package)s1;

	/* 50:24-50:32: s1.proxy*/
	get143 = tmp142.isProxy();

	tmp144 = false;

	tmp145 = get143 == tmp144;

	return tmp145 == true;
}
	return false;
}
	private boolean check_Class2Class(java.lang.Object s1){
ClassDeclaration tmp162;
boolean get163;
boolean tmp164;
boolean tmp165;if ( s1 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
tmp162 = (org.eclipse.gmt.modisco.java.ClassDeclaration)s1;

	/* 69:33-69:41: s1.proxy*/
	get163 = tmp162.isProxy();

	tmp164 = false;

	tmp165 = get163 == tmp164;

	return tmp165 == true;
}
	return false;
}
	public Dependency lazy_rule_createGeneralizationDependency(ClassDeclaration class_){
Dependency gTgt166;
java.lang.String tmp167;
java.lang.String get168;
java.lang.String tmp169;
java.lang.String tmp170;
java.lang.String tmp171;
TypeAccess get172;
Type get173;
java.lang.String get174;
java.lang.String tmp175;
TypeAccess get176;
Type get177;
javaslang.collection.List<Type> tmp178;
javaslang.collection.List<ClassDeclaration> tmp179;
List<java.lang.Object> itTmp180;
List<java.lang.Object> itTmp181;gTgt166 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency();

	UCDModel_PartialOutput_.write(gTgt166);

	tmp167 = "generalization pointing from ";

	/* 79:49-79:59: class.name*/
	get168 = class_.getName();

	tmp169 = tmp167 + get168;

	tmp170 = " to ";

	tmp171 = tmp169 + tmp170;

	/* 79:71-79:97: class.superClass.type.name*/
	/* 79:71-79:92: class.superClass.type*/
	/* 79:71-79:87: class.superClass*/
	get172 = class_.getSuperClass();

	get173 = get172.getType();

	get174 = get173.getName();

	tmp175 = tmp171 + get174;

	/* 80:15-80:49: Sequence {class.superClass.type }*/
	/* 80:26-80:47: class.superClass.type*/
	/* 80:26-80:42: class.superClass*/
	get176 = class_.getSuperClass();

	get177 = get176.getType();

	tmp178 = javaslang.collection.List.of(get177);

	/* 86:13-86:31: Sequence {class }*/
	tmp179 = javaslang.collection.List.of(class_);

	gTgt166.setName(tmp175);;

	itTmp180 = new ArrayList<Object>();

	for ( java.lang.Object o: tmp178) {
boolean matched0 = false;if ( check_Class2Class( o) )  {
itTmp180.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_Dependency_supplier(gTgt166,itTmp180,UCDModel_,null) );

	itTmp181 = new ArrayList<Object>();

	for ( java.lang.Object o: tmp179) {
boolean matched1 = false;if ( check_Class2Class( o) )  {
itTmp181.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_Dependency_client(gTgt166,itTmp181,UCDModel_,null) );

	return gTgt166;
}
	public Dependency lazy_rule_createUsageDependency(FieldDeclaration field){
Dependency gTgt182;
java.lang.String tmp183;
java.lang.String tmp184;
java.lang.String tmp185;
java.lang.String tmp186;
java.lang.String tmp187;
TypeAccess get188;
Type get189;
java.lang.String get190;
java.lang.String tmp191;
TypeAccess get192;
Type get193;
javaslang.collection.List<Type> tmp194;
javaslang.collection.List<ClassDeclaration> call196;
List<BodyDeclaration> get197;
boolean op198;
List<ClassDeclaration> r199;
List<java.lang.Object> itTmp200;
List<java.lang.Object> itTmp201;gTgt182 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createDependency();

	UCDModel_PartialOutput_.write(gTgt182);

	tmp183 = "field pointing from ";

	tmp184 = "xx";

	tmp185 = tmp183 + tmp184;

	tmp186 = " to ";

	tmp187 = tmp185 + tmp186;

	/* 94:52-94:72: field.type.type.name*/
	/* 94:52-94:67: field.type.type*/
	/* 94:52-94:62: field.type*/
	get188 = field.getType();

	get189 = get188.getType();

	get190 = get189.getName();

	tmp191 = tmp187 + get190;

	/* 95:15-95:43: Sequence {field.type.type }*/
	/* 95:26-95:41: field.type.type*/
	/* 95:26-95:36: field.type*/
	get192 = field.getType();

	get193 = get192.getType();

	tmp194 = javaslang.collection.List.of(get193);

	/* null: thisModule.allClasses->select(cd | cd.bodyDeclarations->includes(field))*/
	/* 101:15-101:36: thisModule.allClasses*/
	call196 = helper_global_allClasses();

	r199 = new java.util.ArrayList();

	for ( ClassDeclaration cd195: call196) {
/* 101:50-101:86: cd.bodyDeclarations->includes(field)*/
	/* 101:50-101:69: cd.bodyDeclarations*/
	get197 = new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(cd195.getBodyDeclarations());

	op198 = get197.contains(field);

	if ( op198 == true) {
r199.add(cd195);
}}
	gTgt182.setName(tmp191);;

	itTmp200 = new ArrayList<Object>();

	for ( java.lang.Object o: tmp194) {
boolean matched2 = false;if ( check_Class2Class( o) )  {
itTmp200.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_Dependency_supplier(gTgt182,itTmp200,UCDModel_,null) );

	itTmp201 = new ArrayList<Object>();

	for ( java.lang.Object o: r199) {
boolean matched3 = false;if ( check_Class2Class( o) )  {
itTmp201.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_Dependency_client(gTgt182,itTmp201,UCDModel_,null) );

	return gTgt182;
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
boolean tmp24;
java.lang.Object tmp25;
Type r26;
Type r27;/* 19:3-26:8: if self.superClass.oclIsUndefined() then
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

	r27 = null;

	if ( op12) {
tmp10 = null;

	r27 = (org.eclipse.gmt.modisco.java.Type)tmp10;
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

tmp24 = tmp19 && op22;

r26 = null;

if ( tmp24) {
/* 23:8-23:28: self.superClass.type*/
	/* 23:8-23:23: self.superClass*/
	get13 = self_.getSuperClass();

	get14 = get13.getType();

	r26 = get14;
} else { tmp25 = null;

r26 = (org.eclipse.gmt.modisco.java.Type)tmp25;
}
r27 = r26;
}
	return r27;
}
	public javaslang.collection.List<FieldDeclaration> helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getRefClassFields(ClassDeclaration self_){
javaslang.collection.List<BodyDeclaration> get30;
boolean op31;
javaslang.collection.List<FieldDeclaration> r32;
TypeAccess get33;
Type get34;
boolean get35;
boolean tmp36;
boolean tmp37;
TypeAccess get38;
boolean call39;
boolean tmp40;
boolean tmp41;
boolean tmp42;
TypeAccess get43;
Type get44;
boolean op45;
boolean tmp46;
boolean tmp47;
javaslang.collection.List<FieldDeclaration> r48;/* 29:5-30:126: self.bodyDeclarations->select(e | e.oclIsTypeOf(JMM!FieldDeclaration))->select(e | e.type.type.proxy = false and not e.type.isPrimitiveType() and e.type.type.oclIsTypeOf(JMM!ClassDeclaration))*/
	/* 29:5-29:77: self.bodyDeclarations->select(e | e.oclIsTypeOf(JMM!FieldDeclaration))*/
	/* 29:5-29:26: self.bodyDeclarations*/
	get30 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(self_.getBodyDeclarations()));

	r32 = javaslang.collection.List.empty();

	for ( BodyDeclaration e29: get30) {
/* 29:41-29:76: e.oclIsTypeOf(JMM!FieldDeclaration)*/
	op31 = e29!= null && e29.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.FieldDeclaration.class;

	if ( op31 == true) {
r32 = r32.append((org.eclipse.gmt.modisco.java.FieldDeclaration)e29);
}}
	r48 = javaslang.collection.List.empty();

	for ( FieldDeclaration e28: r32) {
/* 30:17-30:34: e.type.type.proxy*/
	/* 30:17-30:28: e.type.type*/
	/* 30:17-30:23: e.type*/
	get33 = e28.getType();

	get34 = get33.getType();

	get35 = get34.isProxy();

	tmp36 = false;

	tmp37 = get35 == tmp36;

	/* 30:51-30:75: e.type.isPrimitiveType()*/
	/* 30:51-30:57: e.type*/
	get38 = e28.getType();

	if ( get38 instanceof org.eclipse.gmt.modisco.java.TypeAccess) {
call39 = helper_org_eclipse_gmt_modisco_java_TypeAccess_isPrimitiveType((org.eclipse.gmt.modisco.java.TypeAccess)get38);
} else { throw new IllegalStateException();
}
	tmp40 = ! call39;

	tmp42 = tmp37 && tmp40;

	/* 30:80-30:125: e.type.type.oclIsTypeOf(JMM!ClassDeclaration)*/
	/* 30:80-30:91: e.type.type*/
	/* 30:80-30:86: e.type*/
	get43 = e28.getType();

	get44 = get43.getType();

	op45 = get44!= null && get44.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	tmp47 = tmp42 && op45;

	if ( tmp47 == true) {
r48 = r48.append(e28);
}}
	return r48;
}
	public boolean helper_org_eclipse_gmt_modisco_java_TypeAccess_isPrimitiveType(TypeAccess self_){
boolean tmp49;
Type get50;
boolean op51;
Type get52;
java.lang.String get53;
Type cast54;
java.lang.String tmp55;
boolean tmp56;
Type get57;
java.lang.String get58;
Type cast59;
java.lang.String tmp60;
boolean tmp61;
boolean tmp62;
boolean tmp63;
Type get64;
java.lang.String get65;
Type cast66;
java.lang.String tmp67;
boolean tmp68;
boolean tmp69;
boolean tmp70;
Type get71;
java.lang.String get72;
Type cast73;
java.lang.String tmp74;
boolean tmp75;
boolean tmp76;
boolean tmp77;
Type get78;
java.lang.String get79;
Type cast80;
java.lang.String tmp81;
boolean tmp82;
boolean tmp83;
boolean tmp84;
Type get85;
java.lang.String get86;
Type cast87;
java.lang.String tmp88;
boolean tmp89;
boolean tmp90;
boolean tmp91;
Type get92;
java.lang.String get93;
Type cast94;
java.lang.String tmp95;
boolean tmp96;
boolean tmp97;
boolean tmp98;
Type get99;
java.lang.String get100;
Type cast101;
java.lang.String tmp102;
boolean tmp103;
boolean tmp104;
boolean tmp105;
boolean r106;/* 33:2-39:7: if self.type.oclIsKindOf(JMM!PrimitiveType) then
	true
else
	self.type.name = 'String' or self.type.name = 'Integer' or self.type.name = 'Long' or self.type.name = 'Short' or self.type.name = 'Float' or self.type.name = 'Double' or self.type.name = 'Boolean' or self.type.name = 'Number'
endif*/
	/* 33:6-33:46: self.type.oclIsKindOf(JMM!PrimitiveType)*/
	/* 33:6-33:15: self.type*/
	get50 = self_.getType();

	op51 = get50 instanceof org.eclipse.gmt.modisco.java.PrimitiveType;

	r106 = false;

	if ( op51) {
tmp49 = true;

	r106 = tmp49;
} else { /* 35:4-35:18: self.type.name*/
/* 35:4-35:13: self.type*/
get52 = self_.getType();

cast54 = (org.eclipse.gmt.modisco.java.Type)get52;

get53 = cast54.getName();

tmp55 = "String";

tmp56 = get53. equals(tmp55);

/* 35:35-35:49: self.type.name*/
/* 35:35-35:44: self.type*/
get57 = self_.getType();

cast59 = (org.eclipse.gmt.modisco.java.Type)get57;

get58 = cast59.getName();

tmp60 = "Integer";

tmp61 = get58. equals(tmp60);

tmp63 = tmp56 || tmp61;

/* 36:7-36:21: self.type.name*/
/* 36:7-36:16: self.type*/
get64 = self_.getType();

cast66 = (org.eclipse.gmt.modisco.java.Type)get64;

get65 = cast66.getName();

tmp67 = "Long";

tmp68 = get65. equals(tmp67);

tmp70 = tmp63 || tmp68;

/* 36:36-36:50: self.type.name*/
/* 36:36-36:45: self.type*/
get71 = self_.getType();

cast73 = (org.eclipse.gmt.modisco.java.Type)get71;

get72 = cast73.getName();

tmp74 = "Short";

tmp75 = get72. equals(tmp74);

tmp77 = tmp70 || tmp75;

/* 37:7-37:21: self.type.name*/
/* 37:7-37:16: self.type*/
get78 = self_.getType();

cast80 = (org.eclipse.gmt.modisco.java.Type)get78;

get79 = cast80.getName();

tmp81 = "Float";

tmp82 = get79. equals(tmp81);

tmp84 = tmp77 || tmp82;

/* 37:37-37:51: self.type.name*/
/* 37:37-37:46: self.type*/
get85 = self_.getType();

cast87 = (org.eclipse.gmt.modisco.java.Type)get85;

get86 = cast87.getName();

tmp88 = "Double";

tmp89 = get86. equals(tmp88);

tmp91 = tmp84 || tmp89;

/* 38:7-38:21: self.type.name*/
/* 38:7-38:16: self.type*/
get92 = self_.getType();

cast94 = (org.eclipse.gmt.modisco.java.Type)get92;

get93 = cast94.getName();

tmp95 = "Boolean";

tmp96 = get93. equals(tmp95);

tmp98 = tmp91 || tmp96;

/* 38:39-38:53: self.type.name*/
/* 38:39-38:48: self.type*/
get99 = self_.getType();

cast101 = (org.eclipse.gmt.modisco.java.Type)get99;

get100 = cast101.getName();

tmp102 = "Number";

tmp103 = get100. equals(tmp102);

tmp105 = tmp98 || tmp103;

r106 = tmp105;
}
	return r106;
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
	public a2l.tests.java2uml.umldeps.optimised.java2uml_deps setCM(IModel n){
CMModel_ = n;

	return this;
}
	public a2l.tests.java2uml.umldeps.optimised.java2uml_deps setUCD(IOutputModel n){
UCDModel_ = n;

	n.addPartial(UCDModel_PartialOutput_);

	return this;
}
	private void create_Model2Model(org.eclipse.gmt.modisco.java.Model s1){
org.eclipse.uml2.uml.Model t1107;
java.lang.String get108;
List<org.eclipse.gmt.modisco.java.Package> get110;
boolean get111;
boolean tmp112;
boolean tmp113;
List<org.eclipse.gmt.modisco.java.Package> r114;
List<java.lang.Object> itTmp115;t1107 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createModel();

	UCDModel_PartialOutput_.write(t1107);

	/* 44:12-44:19: s1.name*/
	get108 = s1.getName();

	/* null: s1.ownedElements->select(e | e.proxy = false)*/
	/* 45:23-45:39: s1.ownedElements*/
	get110 = new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.Package>(s1.getOwnedElements());

	r114 = new java.util.ArrayList();

	for ( org.eclipse.gmt.modisco.java.Package e109: get110) {
/* 45:54-45:61: e.proxy*/
	get111 = e109.isProxy();

	tmp112 = false;

	tmp113 = get111 == tmp112;

	if ( tmp113 == true) {
r114.add(e109);
}}
	t1107.setName(get108);;

	itTmp115 = new ArrayList<Object>();

	for ( java.lang.Object o: r114) {
boolean matched4 = false;if ( check_Package2Package( o) )  {
itTmp115.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t1107,itTmp115,UCDModel_,null) );

	numMatchedRuleExecutions_++;
}
	private void create_Package2Package(org.eclipse.gmt.modisco.java.Package s1){
org.eclipse.uml2.uml.Package t1116;
java.lang.String get117;
List<org.eclipse.gmt.modisco.java.Package> get120;
boolean get121;
boolean tmp122;
boolean tmp123;
List<org.eclipse.gmt.modisco.java.Package> r124;
boolean op125;
List<org.eclipse.gmt.modisco.java.Package> r126;
javaslang.collection.List<ClassDeclaration> call127;
javaslang.collection.List<ClassDeclaration> call129;
Type call130;
boolean op131;
boolean tmp132;
Dependency call133;
List<Dependency> r134;
javaslang.collection.List<ClassDeclaration> call137;
javaslang.collection.List<FieldDeclaration> call138;
List<FieldDeclaration> r139;
Dependency call140;
List<Dependency> r141;
List<java.lang.Object> itTmp146;
List<java.lang.Object> itTmp147;
List<java.lang.Object> itTmp148;
java.util.Set<java.lang.Object> tgtElems149;
List<java.lang.Object> itTmp150;
java.util.Set<java.lang.Object> tgtElems151;t1116 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createPackage();

	this.trace.put(s1,t1116);

	UCDModel_PartialOutput_.write(t1116);

	/* 52:12-52:19: s1.name*/
	get117 = s1.getName();

	/* null: s1.ownedPackages->select(e | e.proxy = false)->select(e | e.oclIsTypeOf(JMM!Package))*/
	/* null: s1.ownedPackages->select(e | e.proxy = false)*/
	/* 53:23-53:39: s1.ownedPackages*/
	get120 = new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.Package>(s1.getOwnedPackages());

	r124 = new java.util.ArrayList();

	for ( org.eclipse.gmt.modisco.java.Package e119: get120) {
/* 53:54-53:61: e.proxy*/
	get121 = e119.isProxy();

	tmp122 = false;

	tmp123 = get121 == tmp122;

	if ( tmp123 == true) {
r124.add(e119);
}}
	r126 = new java.util.ArrayList();

	for ( org.eclipse.gmt.modisco.java.Package e118: r124) {
/* 53:85-53:111: e.oclIsTypeOf(JMM!Package)*/
	op125 = e118!= null && e118.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.Package.class;

	if ( op125 == true) {
r126.add((org.eclipse.gmt.modisco.java.Package)e118);
}}
	/* 54:23-54:53: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call127 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	/* 55:23-55:53: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call129 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	r134 = new java.util.ArrayList();

	for ( ClassDeclaration s2128: call129) {
/* 56:27-56:60: s2.getSuperClass.oclIsUndefined()*/
	/* 56:27-56:43: s2.getSuperClass*/
	if ( s2128 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call130 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getSuperClass((org.eclipse.gmt.modisco.java.ClassDeclaration)s2128);
} else { throw new IllegalStateException();
}
	op131 = call130== null;

	tmp132 = ! op131;

	if ( tmp132 == true) {
/* 57:24-57:69: thisModule.createGeneralizationDependency(s2)*/
	call133 = lazy_rule_createGeneralizationDependency(s2128);

	r134.add(call133);}}
	/* null: s1.allNonProxyClassesInPackage.<IteratorChain>[collect-flatten]->collect(e | thisModule.createUsageDependency(e))*/
	/* 63:24-63:54: s1.allNonProxyClassesInPackage*/
	if ( s1 instanceof org.eclipse.gmt.modisco.java.Package) {
call137 = helper_org_eclipse_gmt_modisco_java_Package_allNonProxyClassesInPackage((org.eclipse.gmt.modisco.java.Package)s1);
} else { throw new IllegalStateException();
}
	r139 = new java.util.ArrayList();

	for ( ClassDeclaration s2136: call137) {
/* 64:26-64:46: s2.getRefClassFields*/
	if ( s2136 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call138 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_getRefClassFields((org.eclipse.gmt.modisco.java.ClassDeclaration)s2136);
} else { throw new IllegalStateException();
}
	com.google.common.collect.Iterables.addAll(r139,call138);
}
	r141 = new java.util.ArrayList();

	for ( FieldDeclaration e135: r139) {
/* 64:74-64:109: thisModule.createUsageDependency(e)*/
	call140 = lazy_rule_createUsageDependency(e135);

	r141.add(call140);
}
	t1116.setName(get117);;

	itTmp146 = new ArrayList<Object>();

	for ( java.lang.Object o: r126) {
boolean matched5 = false;if ( check_Package2Package( o) )  {
itTmp146.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t1116,itTmp146,UCDModel_,null) );

	itTmp147 = new ArrayList<Object>();

	for ( java.lang.Object o: call127) {
boolean matched6 = false;if ( check_Class2Class( o) )  {
itTmp147.add(o);
}
}
	this.pendingTasks.add( new PendingTask_Package_packagedElement(t1116,itTmp147,UCDModel_,null) );

	itTmp148 = new ArrayList<Object>();

	tgtElems149 = new java.util.HashSet<>();

	for ( java.lang.Object o: r134) {
boolean matched7 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp148, tgtElems149, o);
}
	this.parallelPendingTasks.add( new PendingTask_Package_packagedElement(t1116,itTmp148,UCDModel_,tgtElems149) );

	itTmp150 = new ArrayList<Object>();

	tgtElems151 = new java.util.HashSet<>();

	for ( java.lang.Object o: r141) {
boolean matched8 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp150, tgtElems151, o);
}
	this.parallelPendingTasks.add( new PendingTask_Package_packagedElement(t1116,itTmp150,UCDModel_,tgtElems151) );

	numMatchedRuleExecutions_++;
}
	private void create_Class2Class(ClassDeclaration s1){
Class t1152;
java.lang.String get153;
java.lang.Object tmp154;
Modifier get155;
boolean op156;
Modifier get157;
InheritanceKind get158;
java.lang.String tmp159;
boolean tmp160;
boolean r161;t1152 = org.eclipse.uml2.uml.UMLFactory.eINSTANCE.createClass();

	this.trace.put(s1,t1152);

	UCDModel_PartialOutput_.write(t1152);

	/* 71:12-71:19: s1.name*/
	get153 = s1.getName();

	/* 72:18-72:115: if s1.modifier.oclIsUndefined() then
	OclUndefined
else
	s1.modifier.inheritance = 'abstract'
endif*/
	/* 72:21-72:49: s1.modifier.oclIsUndefined()*/
	/* 72:21-72:32: s1.modifier*/
	get155 = s1.getModifier();

	op156 = get155== null;

	r161 = false;

	if ( op156) {
tmp154 = null;

	r161 = (boolean)tmp154;
} else { /* 72:73-72:96: s1.modifier.inheritance*/
/* 72:73-72:84: s1.modifier*/
get157 = s1.getModifier();

get158 = get157.getInheritance();

tmp159 = "abstract";

tmp160 = get158. equals(tmp159);

r161 = tmp160;
}
	t1152.setName(get153);;

	t1152.setIsAbstract(r161);;

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