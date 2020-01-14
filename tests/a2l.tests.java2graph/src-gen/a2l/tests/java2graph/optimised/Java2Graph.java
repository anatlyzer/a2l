package a2l.tests.java2graph.optimised;

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
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.java2graph.optimised.Java2GraphGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public Java2Graph(a2l.runtime.InputExtent inputExtent,a2l.tests.java2graph.optimised.Java2GraphGlobalContext global) {
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
ClassDeclaration tmp31;
boolean tmp32;
Package get33;
boolean op34;
Package get35;
Package call36;
java.lang.String get37;
java.lang.String tmp38;
int op39;
int tmp40;
boolean tmp41;
boolean r42;if ( inn instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
tmp31 = (org.eclipse.gmt.modisco.java.ClassDeclaration)inn;

	/* 41:4-45:8: if inn.package.oclIsUndefined() then
	false
else
	inn.package.rootPackage().name.indexOf('java') < 0
endif*/
	/* 41:7-41:35: inn.package.oclIsUndefined()*/
	/* 41:7-41:18: inn.package*/
	get33 = tmp31.getPackage();

	op34 = get33== null;

	r42 = false;

	if ( op34) {
tmp32 = false;

	r42 = tmp32;
} else { /* 44:4-44:50: inn.package.rootPackage().name.indexOf('java')*/
/* 44:4-44:34: inn.package.rootPackage().name*/
/* 44:4-44:29: inn.package.rootPackage()*/
/* 44:4-44:15: inn.package*/
get35 = tmp31.getPackage();

if ( get35 instanceof org.eclipse.gmt.modisco.java.Package) {
call36 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)get35);
} else { throw new IllegalStateException();
}
get37 = call36.getName();

tmp38 = "java";

op39 = get37.indexOf(tmp38);

tmp40 = 0;

tmp41 = op39 < tmp40;

r42 = tmp41;
}
	return r42 == true;
}
	return false;
}
	private boolean check_toEdge(java.lang.Object fd){
FieldDeclaration tmp47;
TypeAccess get48;
Type get49;
Package call50;
Package call51;
java.lang.String get52;
java.lang.String tmp53;
int op54;
int tmp55;
boolean tmp56;
AbstractTypeDeclaration get57;
boolean op58;
AbstractTypeDeclaration get59;
Package get60;
ClassDeclaration cast61;
Package call62;
java.lang.String get63;
java.lang.String tmp64;
int op65;
int tmp66;
boolean tmp67;
AbstractTypeDeclaration get68;
Package get69;
ClassDeclaration cast70;
boolean op71;
boolean tmp72;
boolean tmp73;
boolean r74;
boolean tmp75;
boolean tmp76;
AbstractTypeDeclaration get77;
boolean op78;
boolean tmp79;
boolean tmp80;
boolean r81;
boolean tmp82;
boolean tmp83;
TypeAccess get84;
Type get85;
Package call86;
boolean op87;
boolean tmp88;
boolean tmp89;
boolean r90;
TypeAccess get91;
Type get92;
boolean op93;
TypeAccess get94;
Type get95;
boolean op96;
boolean tmp97;
boolean tmp98;
boolean r99;
TypeAccess get100;
boolean op101;
boolean tmp102;
boolean tmp103;
boolean r104;
boolean tmp105;
boolean r106;if ( fd instanceof org.eclipse.gmt.modisco.java.FieldDeclaration) {
tmp47 = (org.eclipse.gmt.modisco.java.FieldDeclaration)fd;

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
	fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration) and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
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
	get100 = tmp47.getType();

	op101 = get100== null;

	tmp102 = ! op101;

	r104 = false;

	if ( tmp102) {
/* 60:5-64:10: if not fd.type.type.oclIsUndefined() then
	fd.type.type.oclIsTypeOf(MM!ClassDeclaration)
else
	false
endif*/
	/* 60:12-60:41: fd.type.type.oclIsUndefined()*/
	/* 60:12-60:24: fd.type.type*/
	/* 60:12-60:19: fd.type*/
	get94 = tmp47.getType();

	get95 = get94.getType();

	op96 = get95== null;

	tmp97 = ! op96;

	r99 = false;

	if ( tmp97) {
/* 61:6-61:51: fd.type.type.oclIsTypeOf(MM!ClassDeclaration)*/
	/* 61:6-61:18: fd.type.type*/
	/* 61:6-61:13: fd.type*/
	get91 = tmp47.getType();

	get92 = get91.getType();

	op93 = get92!= null && get92.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	r99 = op93;
} else { tmp98 = false;

r99 = tmp98;
}
	r104 = r99;
} else { tmp103 = false;

r104 = tmp103;
}
	r106 = false;

	if ( r104) {
/* 68:4-85:9: if not fd.type.type.package().oclIsUndefined() then
	fd.type.type.package().rootPackage().name.indexOf('java') < 0 and if not fd.abstractTypeDeclaration.oclIsUndefined() then
	fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration) and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
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
	get84 = tmp47.getType();

	get85 = get84.getType();

	if ( get85 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call86 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_package((org.eclipse.gmt.modisco.java.ClassDeclaration)get85);
} else { throw new IllegalStateException();
}
	op87 = call86== null;

	tmp88 = ! op87;

	r90 = false;

	if ( tmp88) {
/* 69:5-69:62: fd.type.type.package().rootPackage().name.indexOf('java')*/
	/* 69:5-69:46: fd.type.type.package().rootPackage().name*/
	/* 69:5-69:41: fd.type.type.package().rootPackage()*/
	/* 69:5-69:27: fd.type.type.package()*/
	/* 69:5-69:17: fd.type.type*/
	/* 69:5-69:12: fd.type*/
	get48 = tmp47.getType();

	get49 = get48.getType();

	if ( get49 instanceof org.eclipse.gmt.modisco.java.ClassDeclaration) {
call50 = helper_org_eclipse_gmt_modisco_java_ClassDeclaration_package((org.eclipse.gmt.modisco.java.ClassDeclaration)get49);
} else { throw new IllegalStateException();
}
	if ( call50 instanceof org.eclipse.gmt.modisco.java.Package) {
call51 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)call50);
} else { throw new IllegalStateException();
}
	get52 = call51.getName();

	tmp53 = "java";

	op54 = get52.indexOf(tmp53);

	tmp55 = 0;

	tmp56 = op54 < tmp55;

	/* 69:71-82:10: if not fd.abstractTypeDeclaration.oclIsUndefined() then
	fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration) and if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif
else
	false
endif*/
	/* 70:7-70:50: fd.abstractTypeDeclaration.oclIsUndefined()*/
	/* 70:7-70:33: fd.abstractTypeDeclaration*/
	get77 = tmp47.getAbstractTypeDeclaration();

	op78 = get77== null;

	tmp79 = ! op78;

	r81 = false;

	if ( tmp79) {
/* 72:6-72:65: fd.abstractTypeDeclaration.oclIsTypeOf(MM!ClassDeclaration)*/
	/* 72:6-72:32: fd.abstractTypeDeclaration*/
	get57 = tmp47.getAbstractTypeDeclaration();

	op58 = get57!= null && get57.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.ClassDeclaration.class;

	/* 72:70-79:11: if not fd.abstractTypeDeclaration.package.oclIsUndefined() then
	fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java') < 0
else
	false
endif*/
	/* 74:12-74:63: fd.abstractTypeDeclaration.package.oclIsUndefined()*/
	/* 74:12-74:46: fd.abstractTypeDeclaration.package*/
	/* 74:12-74:38: fd.abstractTypeDeclaration*/
	get68 = tmp47.getAbstractTypeDeclaration();

	cast70 = (org.eclipse.gmt.modisco.java.ClassDeclaration)get68;

	get69 = cast70.getPackage();

	op71 = get69== null;

	tmp72 = ! op71;

	r74 = false;

	if ( tmp72) {
/* 75:7-76:24: fd.abstractTypeDeclaration.package.rootPackage().name.indexOf('java')*/
	/* 75:7-75:60: fd.abstractTypeDeclaration.package.rootPackage().name*/
	/* 75:7-75:55: fd.abstractTypeDeclaration.package.rootPackage()*/
	/* 75:7-75:41: fd.abstractTypeDeclaration.package*/
	/* 75:7-75:33: fd.abstractTypeDeclaration*/
	get59 = tmp47.getAbstractTypeDeclaration();

	cast61 = (org.eclipse.gmt.modisco.java.ClassDeclaration)get59;

	get60 = cast61.getPackage();

	if ( get60 instanceof org.eclipse.gmt.modisco.java.Package) {
call62 = helper_org_eclipse_gmt_modisco_java_Package_rootPackage((org.eclipse.gmt.modisco.java.Package)get60);
} else { throw new IllegalStateException();
}
	get63 = call62.getName();

	tmp64 = "java";

	op65 = get63.indexOf(tmp64);

	tmp66 = 0;

	tmp67 = op65 < tmp66;

	r74 = tmp67;
} else { tmp73 = false;

r74 = tmp73;
}
	tmp76 = op58 && r74;

	r81 = tmp76;
} else { tmp80 = false;

r81 = tmp80;
}
	tmp83 = tmp56 && r81;

	r90 = tmp83;
} else { tmp89 = false;

r90 = tmp89;
}
	r106 = r90;
} else { tmp105 = false;

r106 = tmp105;
}
	return r106 == true;
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
	public a2l.tests.java2graph.optimised.Java2Graph setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.java2graph.optimised.Java2Graph setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_toNode(ClassDeclaration inn){
Node out24;
java.lang.String get25;
java.lang.String call26;
List<BodyDeclaration> get28;
boolean op29;
int r30;out24 = GraphMM.GraphMMFactory.eINSTANCE.createNode();

	this.trace.put(inn,out24);

	OUTModel_PartialOutput_.write(out24);

	/* 49:12-49:20: inn.name*/
	get25 = inn.getName();

	/* 50:12-50:32: thisModule.type(inn)*/
	call26 = helper_global_type(inn);

	/* 51:12-51:32: inn.bodyDeclarations*/
	get28 = new a2l.runtime.stdlib.FastIterableList<org.eclipse.gmt.modisco.java.BodyDeclaration>(inn.getBodyDeclarations());

	r30 = 0;

	for ( BodyDeclaration bd27: get28) {
/* 51:48-52:38: bd.oclIsTypeOf(MM!FieldDeclaration)*/
	op29 = bd27!= null && bd27.eClass().getInstanceClass() == org.eclipse.gmt.modisco.java.FieldDeclaration.class;

	if ( op29 == true) {
r30++;
}}
	out24.setName(get25);;

	out24.setType(call26);;

	boolean matched0 = false;
	numMatchedRuleExecutions_++;
}
	private void create_toEdge(FieldDeclaration fd){
Edge e43;
AbstractTypeDeclaration get44;
TypeAccess get45;
Type get46;e43 = GraphMM.GraphMMFactory.eINSTANCE.createEdge();

	OUTModel_PartialOutput_.write(e43);

	/* 92:14-92:40: fd.abstractTypeDeclaration*/
	get44 = fd.getAbstractTypeDeclaration();

	/* 93:14-93:26: fd.type.type*/
	/* 93:14-93:21: fd.type*/
	get45 = fd.getType();

	get46 = get45.getType();

	boolean matched1 = false;if ( check_toNode( get44) )  {
this.parallelPendingTasks.add( new PendingTask_Edge_source(e43,get44,OUTModel_, null) );
}

	boolean matched2 = false;if ( check_toNode( get46) )  {
this.parallelPendingTasks.add( new PendingTask_Edge_target(e43,get46,OUTModel_, null) );
}

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched3 = false;if ( check_toNode( e) )  {
create_toNode((org.eclipse.gmt.modisco.java.ClassDeclaration)e);
}
else if ( check_toEdge( e) )  {
create_toEdge((org.eclipse.gmt.modisco.java.FieldDeclaration)e);
}

	numExecutions_++;
}}