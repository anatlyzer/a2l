package a2l.tests.java2graph.normal;

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
import org.eclipse.gmt.modisco.java.Package;
import org.eclipse.gmt.modisco.java.ClassDeclaration;
import org.eclipse.gmt.modisco.java.Modifier;
import org.eclipse.gmt.modisco.java.InheritanceKind;
import GraphMM.Node;
import org.eclipse.gmt.modisco.java.BodyDeclaration;
import org.eclipse.gmt.modisco.java.FieldDeclaration;
import GraphMM.Edge;
import org.eclipse.gmt.modisco.java.AbstractTypeDeclaration;
import org.eclipse.gmt.modisco.java.TypeAccess;
import org.eclipse.gmt.modisco.java.Type;

public class Java2Graph implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.java2graph.normal.Java2GraphGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public Java2Graph(a2l.runtime.InputExtent inputExtent,a2l.tests.java2graph.normal.Java2GraphGlobalContext global) {
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
private static final class PendingTask_Edge_source implements IPendingTask { 
private final GraphMM.Edge tgt;
private final Object objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Edge_source(GraphMM.Edge tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems != null && tgtElems.contains(objId)) { tgt.setSource((GraphMM.Node)getTargetResolveTempOrSame(objId, globalTrace)); } else {tgt.setSource((GraphMM.Node)getTrace(objId, globalTrace));}}
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_Edge_target implements IPendingTask { 
private final GraphMM.Edge tgt;
private final Object objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Edge_target(GraphMM.Edge tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems != null && tgtElems.contains(objId)) { tgt.setTarget((GraphMM.Node)getTargetResolveTempOrSame(objId, globalTrace)); } else {tgt.setTarget((GraphMM.Node)getTrace(objId, globalTrace));}}
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private boolean check_toNode(java.lang.Object inn){
ClassDeclaration tmp32;
boolean tmp33;
Package get34;
boolean op35;
Package get36;
Package call37;
java.lang.String get38;
java.lang.String tmp39;
int op40;
int tmp41;
boolean tmp42;
boolean r43;if ( inn instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
tmp32 = (org.eclipse.gmt.modisco.java.ClassDeclaration)inn;

	/* 41:4-45:8: if inn.package.oclIsUndefined() then
	false
else
	inn.package.rootPackage().name.indexOf('java') < 0
endif*/
	/* 41:7-41:35: inn.package.oclIsUndefined()*/
	/* 41:7-41:18: inn.package*/
	get34 = tmp32.getPackage();

	op35 = get34== null;

	r43 = false;

	if ( op35) {
tmp33 = false;

	r43 = tmp33;
} else { /* 44:4-44:50: inn.package.rootPackage().name.indexOf('java')*/
/* 44:4-44:34: inn.package.rootPackage().name*/
/* 44:4-44:29: inn.package.rootPackage()*/
/* 44:4-44:15: inn.package*/
get36 = tmp32.getPackage();

if ( get36 instanceof org.eclipse.gmt.modisco.java.Package) {
call37 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)get36);
} else { throw new IllegalStateException();
}
get38 = call37.getName();

tmp39 = "java";

op40 = get38.indexOf(tmp39);

tmp41 = 0;

tmp42 = op40 < tmp41;

r43 = tmp42;
}
	return r43 == true;
}
	return false;
}
	private boolean check_toEdge(java.lang.Object fd){
FieldDeclaration tmp48;
TypeAccess get49;
Type get50;
Package call51;
Package call52;
java.lang.String get53;
java.lang.String tmp54;
int op55;
int tmp56;
boolean tmp57;
boolean tmp58;
AbstractTypeDeclaration get59;
Package get60;
Package call61;
java.lang.String get62;
java.lang.String tmp63;
int op64;
int tmp65;
boolean tmp66;
AbstractTypeDeclaration get67;
Package get68;
boolean op69;
boolean tmp70;
boolean tmp71;
boolean r72;
boolean tmp73;
AbstractTypeDeclaration get74;
boolean op75;
boolean tmp76;
boolean tmp77;
boolean r78;
boolean tmp79;
TypeAccess get80;
Type get81;
Package call82;
boolean op83;
boolean tmp84;
boolean tmp85;
boolean r86;
TypeAccess get87;
Type get88;
boolean op89;
TypeAccess get90;
Type get91;
boolean op92;
boolean tmp93;
boolean tmp94;
boolean r95;
TypeAccess get96;
boolean op97;
boolean tmp98;
boolean tmp99;
boolean r100;
boolean tmp101;
boolean r102;if ( fd instanceof org.eclipse.gmt.modisco.java.FieldDeclaration) {
tmp48 = (org.eclipse.gmt.modisco.java.FieldDeclaration)fd;

	/* 59:4-88:8: if if not fd.type.oclIsUndefined() then
	if not fd.type.type.oclIsUndefined() then
	fd.type.type.oclIsTypeOf(MM!ClassDeclaration)
else
	false
endif
else
	false
endif then
	if not fd.type.type.package().oclIsUndefined() then
	fd.type.type.package().rootPackage().name.indexOf('java') < 0 and if not fd.abstractTypeDeclaration.oclIsUndefined() then
	true and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif
else
	false
endif
else
	false
endif
else
	false
endif*/
	/* 59:8-67:9: if not fd.type.oclIsUndefined() then
	if not fd.type.type.oclIsUndefined() then
	fd.type.type.oclIsTypeOf(MM!ClassDeclaration)
else
	false
endif
else
	false
endif*/
	/* 59:15-59:39: fd.type.oclIsUndefined()*/
	/* 59:15-59:22: fd.type*/
	get96 = tmp48.getType();

	op97 = get96== null;

	tmp98 = ! op97;

	r100 = false;

	if ( tmp98) {
/* 60:5-64:10: if not fd.type.type.oclIsUndefined() then
	fd.type.type.oclIsTypeOf(MM!ClassDeclaration)
else
	false
endif*/
	/* 60:12-60:41: fd.type.type.oclIsUndefined()*/
	/* 60:12-60:24: fd.type.type*/
	/* 60:12-60:19: fd.type*/
	get90 = tmp48.getType();

	get91 = get90.getType();

	op92 = get91== null;

	tmp93 = ! op92;

	r95 = false;

	if ( tmp93) {
/* 61:6-61:51: fd.type.type.oclIsTypeOf(MM!ClassDeclaration)*/
	/* 61:6-61:18: fd.type.type*/
	/* 61:6-61:13: fd.type*/
	get87 = tmp48.getType();

	get88 = get87.getType();

	op89 = get88!= null && get88.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	r95 = op89;
} else { tmp94 = false;

r95 = tmp94;
}
	r100 = r95;
} else { tmp99 = false;

r100 = tmp99;
}
	r102 = false;

	if ( r100) {
/* 68:4-85:9: if not fd.type.type.package().oclIsUndefined() then
	fd.type.type.package().rootPackage().name.indexOf('java') < 0 and if not fd.abstractTypeDeclaration.oclIsUndefined() then
	true and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif
else
	false
endif
else
	false
endif*/
	/* 68:11-68:50: fd.type.type.package().oclIsUndefined()*/
	/* 68:11-68:33: fd.type.type.package()*/
	/* 68:11-68:23: fd.type.type*/
	/* 68:11-68:18: fd.type*/
	get80 = tmp48.getType();

	get81 = get80.getType();

	if ( get81 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call82 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_package((org.eclipse.gmt.modisco.java.ClassDeclaration)get81);
} else { throw new IllegalStateException();
}
	op83 = call82== null;

	tmp84 = ! op83;

	r86 = false;

	if ( tmp84) {
/* 69:5-69:62: fd.type.type.package().rootPackage().name.indexOf('java')*/
	/* 69:5-69:46: fd.type.type.package().rootPackage().name*/
	/* 69:5-69:41: fd.type.type.package().rootPackage()*/
	/* 69:5-69:27: fd.type.type.package()*/
	/* 69:5-69:17: fd.type.type*/
	/* 69:5-69:12: fd.type*/
	get49 = tmp48.getType();

	get50 = get49.getType();

	if ( get50 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call51 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_package((org.eclipse.gmt.modisco.java.ClassDeclaration)get50);
} else { throw new IllegalStateException();
}
	if ( call51 instanceof org.eclipse.gmt.modisco.java.Package) {
call52 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)call51);
} else { throw new IllegalStateException();
}
	get53 = call52.getName();

	tmp54 = "java";

	op55 = get53.indexOf(tmp54);

	tmp56 = 0;

	tmp57 = op55 < tmp56;

	/* 69:71-82:10: if not fd.abstractTypeDeclaration.oclIsUndefined() then
	true and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif
else
	false
endif*/
	/* 70:7-70:50: fd.abstractTypeDeclaration.oclIsUndefined()*/
	/* 70:7-70:33: fd.abstractTypeDeclaration*/
	get74 = tmp48.getAbstractTypeDeclaration();

	op75 = get74== null;

	tmp76 = ! op75;

	r78 = false;

	if ( tmp76) {
tmp58 = true;

	/* 73:15-79:11: if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif*/
	/* 74:12-74:63: fd.abstractTypeDeclaration.package.oclIsUndefined()*/
	/* 74:12-74:46: fd.abstractTypeDeclaration.package*/
	/* 74:12-74:38: fd.abstractTypeDeclaration*/
	get67 = tmp48.getAbstractTypeDeclaration();

	get68 = get67.getPackage();

	op69 = get68== null;

	tmp70 = ! op69;

	r72 = false;

	if ( tmp70) {
/* 75:7-76:24: fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java')*/
	/* 75:7-75:60: fd.abstractTypeDeclaration.package.rootPackage().name*/
	/* 75:7-75:55: fd.abstractTypeDeclaration.package.rootPackage()*/
	/* 75:7-75:41: fd.abstractTypeDeclaration.package*/
	/* 75:7-75:33: fd.abstractTypeDeclaration*/
	get59 = tmp48.getAbstractTypeDeclaration();

	get60 = get59.getPackage();

	if ( get60 instanceof org.eclipse.gmt.modisco.java.Package) {
call61 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)get60);
} else { throw new IllegalStateException();
}
	get62 = call61.getName();

	tmp63 = "java";

	op64 = get62.indexOf(tmp63);

	tmp65 = 0;

	tmp66 = op64 < tmp65;

	r72 = tmp66;
} else { tmp71 = false;

r72 = tmp71;
}
	tmp73 = tmp58 && r72;

	r78 = tmp73;
} else { tmp77 = false;

r78 = tmp77;
}
	tmp79 = tmp57 && r78;

	r86 = tmp79;
} else { tmp85 = false;

r86 = tmp85;
}
	r102 = r86;
} else { tmp101 = false;

r102 = tmp101;
}
	return r102 == true;
}
	return false;
}
	public Package helper_org_eclipse_gmt_modisco_java_Package_rootPackage(Package self_){
Package get0;
boolean op1;
Package get2;
Package call3;
Package r4;/* 18:2-18:82: if self.package.oclIsUndefined() then
	self
else
	self.package.rootPackage()
endif*/
	/* 18:5-18:34: self.package.oclIsUndefined()*/
	/* 18:5-18:17: self.package*/
	get0 = self_.getPackage();

	op1 = get0== null;

	r4 = null;

	if ( op1) {
r4 = self_;
} else { /* 18:50-18:76: self.package.rootPackage()*/
/* 18:50-18:62: self.package*/
get2 = self_.getPackage();

if ( get2 instanceof org.eclipse.gmt.modisco.java.Package) {
call3 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)get2);
} else { throw new IllegalStateException();
}
r4 = call3;
}
	return r4;
}
	public Package helper_org_eclipse_gmt_modisco_java_ClassDeclaration_package(ClassDeclaration self_){
Package get5;/* 21:2-21:14: self.package*/
	get5 = self_.getPackage();

	return get5;
}
	public java.lang.String helper_global_type(ClassDeclaration cd){
java.lang.String tmp6;
Modifier get7;
InheritanceKind get8;
InheritanceKind tmp9;
boolean tmp10;
java.lang.String tmp11;
Modifier get12;
InheritanceKind get13;
InheritanceKind tmp14;
boolean tmp15;
java.lang.String tmp16;
java.lang.String r17;
java.lang.String r18;
Modifier get19;
boolean op20;
boolean tmp21;
java.lang.String tmp22;
java.lang.String r23;/* 24:2-36:7: if not cd.modifier.oclIsUndefined() then
	if cd.modifier.inheritance = #final then
	'F'
else
	if cd.modifier.inheritance = #abstract then
	'A'
else
	'N'
endif
endif
else
	'N'
endif*/
	/* 24:9-24:37: cd.modifier.oclIsUndefined()*/
	/* 24:9-24:20: cd.modifier*/
	get19 = cd.getModifier();

	op20 = get19== null;

	tmp21 = ! op20;

	r23 = "";

	if ( tmp21) {
/* 25:3-33:8: if cd.modifier.inheritance = #final then
	'F'
else
	if cd.modifier.inheritance = #abstract then
	'A'
else
	'N'
endif
endif*/
	/* 25:6-25:29: cd.modifier.inheritance*/
	/* 25:6-25:17: cd.modifier*/
	get7 = cd.getModifier();

	get8 = get7.getInheritance();

	tmp9 = org.eclipse.gmt.modisco.java.InheritanceKind.FINAL;

	tmp10 = get8. equals(tmp9);

	r18 = "";

	if ( tmp10) {
tmp6 = "F";

	r18 = tmp6;
} else { /* 28:4-32:9: if cd.modifier.inheritance = #abstract then
	'A'
else
	'N'
endif*/
/* 28:7-28:30: cd.modifier.inheritance*/
/* 28:7-28:18: cd.modifier*/
get12 = cd.getModifier();

get13 = get12.getInheritance();

tmp14 = org.eclipse.gmt.modisco.java.InheritanceKind.ABSTRACT;

tmp15 = get13. equals(tmp14);

r17 = "";

if ( tmp15) {
tmp11 = "A";

	r17 = tmp11;
} else { tmp16 = "N";

r17 = tmp16;
}
r18 = r17;
}
	r23 = r18;
} else { tmp22 = "N";

r23 = tmp22;
}
	return r23;
}
	public boolean isTargetElement(java.lang.Object obj){
if ( obj == null ) return false;;

	return OUTModel_PartialOutput_.belongsTo(obj);
}
	public IModel findModelDynamically(java.lang.Object obj){
if ( INModel_.belongsTo(obj)) return INModel_; 
 if ( OUTModel_.belongsTo(obj)) return OUTModel_;
throw new IllegalStateException();
}
	public a2l.tests.java2graph.normal.Java2Graph setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.java2graph.normal.Java2Graph setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_toNode(ClassDeclaration inn){
Node out24;
java.lang.String get25;
java.lang.String call26;
javaslang.collection.List<BodyDeclaration> get28;
boolean op29;
javaslang.collection.List<FieldDeclaration> r30;
int op31;out24 = GraphMM.GraphMMFactory.eINSTANCE.createNode();

	this.trace.put(inn,out24);

	OUTModel_PartialOutput_.write(out24);

	/* 49:12-49:20: inn.name*/
	get25 = inn.getName();

	/* 50:12-50:32: thisModule.type(inn)*/
	call26 = helper_global_type(inn);

	/* 51:12-52:49: inn.bodyDeclarations->select(bd | bd.oclIsTypeOf(MM!FieldDeclaration))->size()*/
	/* 51:12-52:39: inn.bodyDeclarations->select(bd | bd.oclIsTypeOf(MM!FieldDeclaration))*/
	/* 51:12-51:32: inn.bodyDeclarations*/
	get28 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(inn.getBodyDeclarations()));

	r30 = javaslang.collection.List.empty();

	for ( BodyDeclaration bd27: get28) {
/* 51:48-52:38: bd.oclIsTypeOf(MM!FieldDeclaration)*/
	op29 = bd27!= null && bd27.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.FieldDeclaration.class;

	if ( op29 == true) {
r30 = r30.append((org.eclipse.gmt.modisco.java.FieldDeclaration)bd27);
}}
	op31 = r30.size();

	out24.setName(get25);;

	out24.setType(call26);;

	out24.setSize(op31);;

	numMatchedRuleExecutions_++;
}
	private void create_toEdge(FieldDeclaration fd){
Edge e44;
AbstractTypeDeclaration get45;
TypeAccess get46;
Type get47;e44 = GraphMM.GraphMMFactory.eINSTANCE.createEdge();

	this.trace.put(fd,e44);

	OUTModel_PartialOutput_.write(e44);

	/* 92:14-92:40: fd.abstractTypeDeclaration*/
	get45 = fd.getAbstractTypeDeclaration();

	/* 93:14-93:26: fd.type.type*/
	/* 93:14-93:21: fd.type*/
	get46 = fd.getType();

	get47 = get46.getType();

	boolean matched0 = false;if ( check_toNode( get45) )  {
this.parallelPendingTasks.add( new PendingTask_Edge_source(e44,get45,OUTModel_, null) );
}

	boolean matched1 = false;if ( check_toNode( get47) )  {
this.parallelPendingTasks.add( new PendingTask_Edge_target(e44,get47,OUTModel_, null) );
}

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched2 = false;if ( check_toNode( e) )  {
create_toNode((org.eclipse.gmt.modisco.java.ClassDeclaration)e);
}
else if ( check_toEdge( e) )  {
create_toEdge((org.eclipse.gmt.modisco.java.FieldDeclaration)e);
}

	numExecutions_++;
}}