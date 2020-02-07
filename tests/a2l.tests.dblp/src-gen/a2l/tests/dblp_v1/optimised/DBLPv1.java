package a2l.tests.dblp_v1.optimised;

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

public class DBLPv1 implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp_v1.optimised.DBLPv1GlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public DBLPv1(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp_v1.optimised.DBLPv1GlobalContext global) {
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
dblp.DBLP.Author tmp12;
List<Record> get14;
boolean op15;
java.lang.String call16;
java.lang.String tmp17;
int op18;
int tmp19;
boolean tmp20;
boolean r21;if ( a instanceof dblp.DBLP.Author) {
tmp12 = (dblp.DBLP.Author)a;

	/* 23:18-23:27: a.records*/
	get14 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(tmp12.getRecords());

	r21 = false;

	for ( Record r13: get14) {
/* 23:40-23:71: r.oclIsTypeOf(MM!InProceedings)*/
	op15 = r13!= null && r13.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op15 == true) {
/* 23:86-23:116: r.booktitle().indexOf('ICMT')*/
	/* 23:86-23:100: r.booktitle()*/
	if ( r13 instanceof dblp.DBLP.InProceedings) {
call16 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)r13);
} else { throw new IllegalStateException();
}
	tmp17 = "ICMT";

	op18 = call16.indexOf(tmp17);

	tmp19 = 0;

	tmp20 = op18 >= tmp19;

	if ( tmp20) {
r21 = true;

	break;
}}}
	return r21 == true;
}
	return false;
}
	public java.lang.String helper_dblp_DBLP_InProceedings_booktitle(InProceedings self_){
java.lang.String get0;/* 18:62-18:75: self.bootitle*/
	get0 = self_.getBootitle();

	return get0;
}
	public boolean isTargetElement(java.lang.Object obj){
if ( obj == null ) return false;;

	if ( obj instanceof a2l.runtime.ResolveTempObject ) return true;;

	return OUTModel_PartialOutput_.belongsTo(obj);
}
	public IModel findModelDynamically(java.lang.Object obj){
if ( INModel_.belongsTo(obj)) return INModel_; 
 if ( OUTModel_.belongsTo(obj)) return OUTModel_;
throw new IllegalStateException();
}
	public a2l.tests.dblp_v1.optimised.DBLPv1 setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp_v1.optimised.DBLPv1 setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_icmt(dblp.DBLP.Author a){
dblp.AuthorInfo.Author out1;
java.lang.String get2;
List<Record> get4;
java.lang.String call5;
java.lang.String tmp6;
int op7;
int tmp8;
boolean tmp9;
boolean op10;
int r11;out1 = dblp.AuthorInfo.AuthorInfoFactory.eINSTANCE.createAuthor();

	OUTModel_PartialOutput_.write(out1);

	/* 26:12-26:18: a.name*/
	get2 = a.getName();

	/* 28:5-28:14: a.records*/
	get4 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Record>(a.getRecords());

	r11 = 0;

	for ( Record r3: get4) {
/* 29:18-29:49: r.oclIsTypeOf(MM!InProceedings)*/
	op10 = r3!= null && r3.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op10 == true) {
/* 30:19-30:49: r.booktitle().indexOf('ICMT')*/
	/* 30:19-30:33: r.booktitle()*/
	if ( r3 instanceof dblp.DBLP.InProceedings) {
call5 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)r3);
} else { throw new IllegalStateException();
}
	tmp6 = "ICMT";

	op7 = call5.indexOf(tmp6);

	tmp8 = 0;

	tmp9 = op7 >= tmp8;

	if ( tmp9 == true) {
r11++;
}}}
	out1.setName(get2);;

	boolean matched0 = false;
	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched1 = false;if ( check_icmt( e) )  {
create_icmt((dblp.DBLP.Author)e);
}

	numExecutions_++;
}}