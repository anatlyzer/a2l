package a2l.tests.dblp_v1.normal;

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
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp_v1.normal.DBLPv1GlobalContext globalContext;java.util.Map<Object, Object> trace = new java.util.HashMap<Object, Object>();public DBLPv1(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp_v1.normal.DBLPv1GlobalContext global) {
this.inputExtent = inputExtent;
this.globalContext = global;
this.OUTModel_PartialOutput_ = new PartialOutputModel();
this.trace = global.createPartialTrace();; }protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }
protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { javaslang.collection.List<T> list_result = globalContext.getFromAllInstancesCache(klass, () -> {javaslang.collection.List<T> IN = javaslang.collection.List.ofAll(INModel_.allInstances()).  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));
javaslang.collection.List<T> result = javaslang.collection.List.empty();
result = result.appendAll(IN);return result;

});return list_result;}
 private javaslang.collection.List<Object> flatten(Iterable<?> l) { 	ArrayList<Object> r = new ArrayList<Object>();   addFlatten(r, l);    return javaslang.collection.List.ofAll(r);  } private void addFlatten(ArrayList<Object> r, Iterable<?> l) {    for(Object x : l) {      if ( x instanceof Iterable ) { 	    addFlatten(r, (Iterable<?>) x);      } else { 	    r.add(x);      }   } } private javaslang.collection.Set<Object> flattenSet(Iterable<?> l) {  	javaslang.collection.Set<Object> r = javaslang.collection.HashSet.empty(); 	for (Object object : l) { 		if ( object instanceof Iterable ) { 			r = r.addAll(flattenSet((Iterable<Object>) object)); 		} else { 			r = r.add(object); 		} 	} 	return r; }public static class TransformationResult { }
protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString(); }

@Override public void doSequentialPostprocessing() {   for (IPendingTask tasks : pendingTasks) {			tasks.execute(this.globalContext.getGlobalTrace());  }}
@Override public void doPostprocessing() { doSequentialPostprocessing(); doParallelPostprocessing(); }
@Override public void doParallelPostprocessing() { 
  for (IPendingTask tasks : parallelPendingTasks) {			tasks.execute(this.globalContext.getGlobalTrace());  }final Collection<? extends org.eclipse.emf.ecore.EObject> objects_OUT = (Collection<? extends org.eclipse.emf.ecore.EObject>)OUTModel_PartialOutput_.allInstances();for(org.eclipse.emf.ecore.EObject obj : objects_OUT) {		if (obj.eContainer() == null) {         synchronized(OUTModel_) {			OUTModel_.add(obj);		  }		}}}

private java.util.ArrayList<IPendingTask> pendingTasks = new java.util.ArrayList<>();private java.util.ArrayList<IPendingTask> parallelPendingTasks = new java.util.ArrayList<>();interface IPendingTask { public void execute(a2l.runtime.GlobalTrace globalTrace); }public boolean check_icmt(java.lang.Object a) throws BlackboardException{
dblp.DBLP.Author tmp15;
javaslang.collection.List<Record> get18;
boolean op19;
javaslang.collection.List<InProceedings> r20;
java.lang.String call21;
java.lang.String tmp22;
int op23;
int tmp24;
boolean tmp25;
boolean r26;if ( a instanceof dblp.DBLP.Author) {
tmp15 = (dblp.DBLP.Author)a;

	/* 23:18-23:120: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))->exists(ip | ip.booktitle().indexOf('ICMT') >= 0)*/
	/* 23:18-23:72: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))*/
	/* 23:18-23:27: a.records*/
	get18 = javaslang.collection.List.ofAll(tmp15.getRecords());

	r20 = javaslang.collection.List.empty();

	for ( Record r17: get18) {
/* 23:40-23:71: r.oclIsTypeOf(MM!InProceedings)*/
	op19 = r17!= null && r17.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op19 == true) {
r20 = r20.append((dblp.DBLP.InProceedings)r17);
}}
	r26 = false;

	for ( InProceedings ip16: r20) {
/* 23:86-23:116: ip.booktitle().indexOf('ICMT')*/
	/* 23:86-23:100: ip.booktitle()*/
	if ( ip16 instanceof dblp.DBLP.InProceedings) {
call21 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)ip16);
} else { throw new IllegalStateException();
}
	tmp22 = "ICMT";

	op23 = call21.indexOf(tmp22);

	tmp24 = 0;

	tmp25 = op23 >= tmp24;

	if ( tmp25) {
r26 = true;

	break;
}}
	return r26 == true;
}
	return false;
}
	public java.lang.String helper_dblp_DBLP_InProceedings_booktitle(InProceedings self_) throws BlackboardException{
java.lang.String get0;/* 18:62-18:75: self.bootitle*/
	get0 = self_.getBootitle();

	return get0;
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
	public a2l.tests.dblp_v1.normal.DBLPv1 setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp_v1.normal.DBLPv1 setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	public void create_icmt(dblp.DBLP.Author a) throws BlackboardException{
dblp.AuthorInfo.Author out1;
java.lang.String get2;
javaslang.collection.List<Record> get5;
boolean op6;
javaslang.collection.List<InProceedings> r7;
java.lang.String call8;
java.lang.String tmp9;
int op10;
int tmp11;
boolean tmp12;
javaslang.collection.List<InProceedings> r13;
int op14;out1 = dblp.AuthorInfo.AuthorInfoFactory.eINSTANCE.createAuthor();

	this.trace.put(a,out1);

	OUTModel_PartialOutput_.write(out1);

	/* 26:12-26:18: a.name*/
	get2 = a.getName();

	/* 28:5-31:13: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))->select(ip | ip.booktitle().indexOf('ICMT') >= 0)->size()*/
	/* 28:5-30:53: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))->select(ip | ip.booktitle().indexOf('ICMT') >= 0)*/
	/* 28:5-29:50: a.records->select(r | r.oclIsTypeOf(MM!InProceedings))*/
	/* 28:5-28:14: a.records*/
	get5 = javaslang.collection.List.ofAll(a.getRecords());

	r7 = javaslang.collection.List.empty();

	for ( Record r4: get5) {
/* 29:18-29:49: r.oclIsTypeOf(MM!InProceedings)*/
	op6 = r4!= null && r4.eClass().getInstanceClass() == dblp.DBLP.InProceedings.class;

	if ( op6 == true) {
r7 = r7.append((dblp.DBLP.InProceedings)r4);
}}
	r13 = javaslang.collection.List.empty();

	for ( InProceedings ip3: r7) {
/* 30:19-30:49: ip.booktitle().indexOf('ICMT')*/
	/* 30:19-30:33: ip.booktitle()*/
	if ( ip3 instanceof dblp.DBLP.InProceedings) {
call8 = helper_dblp_DBLP_InProceedings_booktitle((dblp.DBLP.InProceedings)ip3);
} else { throw new IllegalStateException();
}
	tmp9 = "ICMT";

	op10 = call8.indexOf(tmp9);

	tmp11 = 0;

	tmp12 = op10 >= tmp11;

	if ( tmp12 == true) {
r13 = r13.append(ip3);
}}
	op14 = r13.size();

	out1.setName(get2);;

	out1.setNumOfPapers(op14);;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched0 = false;if ( check_icmt( e) )  {
create_icmt((dblp.DBLP.Author)e);
}
}}