package a2l.tests.dblp_v2.normal;

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
import dblp.DBLP.InProceedings;
import dblp.DBLP.Record;

public class DBLPv2 implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp_v2.normal.DBLPv2GlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public DBLPv2(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp_v2.normal.DBLPv2GlobalContext global) {
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
private boolean check_icmt(java.lang.Object a){
dblp.DBLP.Author tmp23;
javaslang.collection.List<Record> get26;
boolean op27;
javaslang.collection.List<InProceedings> r28;
java.lang.String call29;
java.lang.String tmp30;
int op31;
int tmp32;
boolean tmp33;
boolean r34;if ( a instanceof dblp.DBLP.Author) {
tmp23 = (dblp.DBLP.Author)a;

	/* 26:18-26:120: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))->exists(ip | ip.booktitle().indexOf('ICMT') >= 0)*/
	/* 26:18-26:72: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))*/
	/* 26:18-26:27: a.records*/
	get26 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(tmp23.getRecords()));

	r28 = javaslang.collection.List.empty();

	for ( Record r25: get26) {
/* 26:40-26:71: r.oclIsTypeOf(MM!InProceedings)*/
	op27 = r25!= null && r25.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op27 == true) {
r28 = r28.append((dblp.DBLP.InProceedings)r25);
}}
	r34 = false;

	for ( InProceedings ip24: r28) {
/* 26:86-26:116: ip.booktitle().indexOf('ICMT')*/
	/* 26:86-26:100: ip.booktitle()*/
	if ( ip24 instanceof dblp.DBLP.InProceedings) {
call29 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)ip24);
} else { throw new IllegalStateException();
}
	tmp30 = "ICMT";

	op31 = call29.indexOf(tmp30);

	tmp32 = 0;

	tmp33 = op31 >= tmp32;

	if ( tmp33) {
r34 = true;

	break;
}}
	return r34 == true;
}
	return false;
}
	public java.lang.String helper_dblp_DBLP_InProceedings_booktitle(InProceedings self_){
java.lang.String get0;/* 17:62-17:75: self.bootitle*/
	get0 = self_.getBootitle();

	return get0;
}
	public int helper_dblp_DBLP_InProceedings_year(InProceedings self_){
int get1;/* 19:58-19:67: self.year*/
	get1 = self_.getYear();

	return get1;
}
	public boolean helper_dblp_DBLP_Author_active(dblp.DBLP.Author self_){
javaslang.collection.List<Record> get4;
boolean op5;
javaslang.collection.List<InProceedings> r6;
java.lang.String call7;
java.lang.String tmp8;
int op9;
int tmp10;
boolean tmp11;
int call12;
int tmp13;
boolean tmp14;
boolean tmp15;
javaslang.collection.List<InProceedings> r16;
int op17;
int tmp18;
boolean tmp19;/* 22:2-22:134: self.records->select(r | r.oclIsTypeOf(MM!InProceedings))->select(ip | ip.booktitle().indexOf('ICMT') >= 0 and ip.year() > 2008)->size()*/
	/* 22:2-22:126: self.records->select(r | r.oclIsTypeOf(MM!InProceedings))->select(ip | ip.booktitle().indexOf('ICMT') >= 0 and ip.year() > 2008)*/
	/* 22:2-22:59: self.records->select(r | r.oclIsTypeOf(MM!InProceedings))*/
	/* 22:2-22:14: self.records*/
	get4 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(self_.getRecords()));

	r6 = javaslang.collection.List.empty();

	for ( Record r3: get4) {
/* 22:27-22:58: r.oclIsTypeOf(MM!InProceedings)*/
	op5 = r3!= null && r3.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op5 == true) {
r6 = r6.append((dblp.DBLP.InProceedings)r3);
}}
	r16 = javaslang.collection.List.empty();

	for ( InProceedings ip2: r6) {
/* 22:73-22:103: ip.booktitle().indexOf('ICMT')*/
	/* 22:73-22:87: ip.booktitle()*/
	if ( ip2 instanceof dblp.DBLP.InProceedings) {
call7 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)ip2);
} else { throw new IllegalStateException();
}
	tmp8 = "ICMT";

	op9 = call7.indexOf(tmp8);

	tmp10 = 0;

	tmp11 = op9 >= tmp10;

	/* 22:111-22:120: ip.year()*/
	if ( ip2 instanceof dblp.DBLP.InProceedings) {
call12 = helper_dblp_DBLP_InProceedings_year((dblp.DBLP.InProceedings)ip2);
} else { throw new IllegalStateException();
}
	tmp13 = 2008;

	tmp14 = call12 > tmp13;

	tmp15 = tmp11 && tmp14;

	if ( tmp15 == true) {
r16 = r16.append(ip2);
}}
	op17 = r16.size();

	tmp18 = 0;

	tmp19 = op17 > tmp18;

	return tmp19;
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
	public a2l.tests.dblp_v2.normal.DBLPv2 setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp_v2.normal.DBLPv2 setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_icmt(dblp.DBLP.Author a){
dblp.AuthorInfo.Author out20;
java.lang.String get21;
boolean call22;out20 = dblp.AuthorInfo.AuthorInfoFactory.eINSTANCE.createAuthor();

	this.trace.put(a,out20);

	OUTModel_PartialOutput_.write(out20);

	/* 29:12-29:18: a.name*/
	get21 = a.getName();

	/* 30:14-30:24: a.active()*/
	if ( a instanceof dblp.DBLP.Author) {
call22 = helper_dblp_DBLP_Author_active((dblp.DBLP.Author)a);
} else { throw new IllegalStateException();
}
	out20.setName(get21);;

	out20.setActive(call22);;

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched0 = false;if ( check_icmt( e) )  {
create_icmt((dblp.DBLP.Author)e);
}

	numExecutions_++;
}}