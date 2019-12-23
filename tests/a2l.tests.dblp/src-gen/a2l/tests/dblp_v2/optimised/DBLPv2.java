package a2l.tests.dblp_v2.optimised;

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
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public DBLPv2(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp_v2.optimised.DBLPv2GlobalContext global) {
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
dblp.DBLP.Author tmp21;
List<Record> get23;
boolean op24;
java.lang.String call25;
java.lang.String tmp26;
int op27;
int tmp28;
boolean tmp29;
boolean r30;if ( a instanceof dblp.DBLP.Author) {
tmp21 = (dblp.DBLP.Author)a;

	/* 26:18-26:27: a.records*/
	get23 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(tmp21.getRecords());

	r30 = false;

	for ( Record r22: get23) {
/* 26:40-26:71: r.oclIsTypeOf(MM!InProceedings)*/
	op24 = r22!= null && r22.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op24 == true) {
/* 26:86-26:116: r.booktitle().indexOf('ICMT')*/
	/* 26:86-26:100: r.booktitle()*/
	if ( r22 instanceof dblp.DBLP.InProceedings) {
call25 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)r22);
} else { throw new IllegalStateException();
}
	tmp26 = "ICMT";

	op27 = call25.indexOf(tmp26);

	tmp28 = 0;

	tmp29 = op27 >= tmp28;

	if ( tmp29) {
r30 = true;

	break;
}}}
	return r30 == true;
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
List<Record> get3;
java.lang.String call4;
java.lang.String tmp5;
int op6;
int tmp7;
boolean tmp8;
int call9;
int tmp10;
boolean tmp11;
boolean tmp12;
boolean tmp13;
boolean op14;
int r15;
int tmp16;
boolean tmp17;/* 22:2-22:14: self.records*/
	get3 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(self_.getRecords());

	r15 = 0;

	for ( Record r2: get3) {
/* 22:27-22:58: r.oclIsTypeOf(MM!InProceedings)*/
	op14 = r2!= null && r2.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op14 == true) {
/* 22:73-22:103: r.booktitle().indexOf('ICMT')*/
	/* 22:73-22:87: r.booktitle()*/
	if ( r2 instanceof dblp.DBLP.InProceedings) {
call4 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)r2);
} else { throw new IllegalStateException();
}
	tmp5 = "ICMT";

	op6 = call4.indexOf(tmp5);

	tmp7 = 0;

	tmp8 = op6 >= tmp7;

	/* 22:111-22:120: r.year()*/
	if ( r2 instanceof dblp.DBLP.InProceedings) {
call9 = helper_dblp_DBLP_InProceedings_year((dblp.DBLP.InProceedings)r2);
} else { throw new IllegalStateException();
}
	tmp10 = 2008;

	tmp11 = call9 > tmp10;

	tmp13 = tmp8 && tmp11;

	if ( tmp13 == true) {
r15++;
}}}
	tmp16 = 0;

	tmp17 = r15 > tmp16;

	return tmp17;
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
	public a2l.tests.dblp_v2.optimised.DBLPv2 setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp_v2.optimised.DBLPv2 setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_icmt(dblp.DBLP.Author a){
dblp.AuthorInfo.Author out18;
java.lang.String get19;
boolean call20;out18 = dblp.AuthorInfo.AuthorInfoFactory.eINSTANCE.createAuthor();

	OUTModel_PartialOutput_.write(out18);

	/* 29:12-29:18: a.name*/
	get19 = a.getName();

	/* 30:14-30:24: a.active()*/
	if ( a instanceof dblp.DBLP.Author) {
call20 = helper_dblp_DBLP_Author_active((dblp.DBLP.Author)a);
} else { throw new IllegalStateException();
}
	out18.setName(get19);;

	out18.setActive(call20);;

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