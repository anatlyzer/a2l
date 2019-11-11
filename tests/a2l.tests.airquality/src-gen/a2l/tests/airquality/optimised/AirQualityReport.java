package a2l.tests.airquality.optimised;

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
import airquality.AirMeasurement;
import airquality.Warning;
import airquality.Date;

public class AirQualityReport implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.airquality.optimised.AirQualityReportGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public AirQualityReport(a2l.runtime.InputExtent inputExtent,a2l.tests.airquality.optimised.AirQualityReportGlobalContext global) {
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
private static final class PendingTask_Warning_date implements IPendingTask { 
private final airquality.Warning tgt;
private final Object objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_Warning_date(airquality.Warning tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems != null && tgtElems.contains(objId)) { tgt.setDate((airquality.Date)getTargetResolveTempOrSame(objId, globalTrace)); } else {tgt.setDate((airquality.Date)getTrace(objId, globalTrace));}}
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private boolean check_highCO(java.lang.Object m1){
AirMeasurement tmp17;
Date get18;
int get19;
int tmp20;
boolean tmp21;
Date get22;
int get23;
javaslang.collection.List<AirMeasurement> op26;
int get27;
int get28;
boolean tmp29;
Date get30;
int get31;
Date get32;
int get33;
boolean tmp34;
boolean tmp35;
Date get36;
int get37;
Date get38;
int get39;
boolean tmp40;
boolean tmp41;
Date get42;
int get43;
Date get44;
int get45;
boolean tmp46;
boolean tmp47;
List<AirMeasurement> r48;
Date get49;
int get50;
List<java.lang.Integer> r51;
int op52;
boolean tmp53;
boolean tmp54;
Date get55;
int get56;
javaslang.collection.List<AirMeasurement> op59;
int get60;
int get61;
boolean tmp62;
Date get63;
int get64;
Date get65;
int get66;
boolean tmp67;
boolean tmp68;
Date get69;
int get70;
Date get71;
int get72;
boolean tmp73;
boolean tmp74;
Date get75;
int get76;
Date get77;
int get78;
boolean tmp79;
boolean tmp80;
Date get81;
int get82;
int tmp83;
boolean tmp84;
boolean tmp85;
List<AirMeasurement> r86;
Date get87;
int get88;
List<java.lang.Integer> r89;
int op90;
boolean tmp91;
boolean tmp92;
javaslang.collection.List<AirMeasurement> op96;
boolean tmp97;
int get98;
int get99;
boolean tmp100;
boolean tmp101;
Date get102;
int get103;
Date get104;
int get105;
boolean tmp106;
boolean tmp107;
Date get108;
int get109;
Date get110;
int get111;
boolean tmp112;
boolean tmp113;
javaslang.collection.List<AirMeasurement> r114;
double get115;
javaslang.collection.List<java.lang.Double> r116;
double tmp117;
boolean tmp118;
int r119;
int tmp120;
boolean tmp121;
boolean tmp122;if ( m1 instanceof airquality.AirMeasurement) {
tmp17 = (airquality.AirMeasurement)m1;

	/* 21:28-21:39: m1.date.day*/
	/* 21:28-21:35: m1.date*/
	get18 = tmp17.getDate();

	get19 = get18.getDay();

	tmp20 = 1;

	tmp21 = get19 == tmp20;

	/* 27:10-27:22: m1.date.hour*/
	/* 27:10-27:17: m1.date*/
	get22 = tmp17.getDate();

	get23 = get22.getHour();

	/* 27:25-27:242: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)->sortedBy(v | v)->first()*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)->sortedBy(v | v)*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)*/
	/* 27:25-27:57: MM!AirMeasurement.allInstances()*/
	op26 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r48 = new java.util.ArrayList();

	for ( AirMeasurement m225: op26) {
/* 27:71-27:81: m1.station*/
	get27 = tmp17.getStation();

	/* 27:82-27:92: m2.station*/
	get28 = m225.getStation();

	tmp29 = get27 == get28;

	/* 27:97-27:109: m1.date.year*/
	/* 27:97-27:104: m1.date*/
	get30 = tmp17.getDate();

	get31 = get30.getYear();

	/* 27:112-27:124: m2.date.year*/
	/* 27:112-27:119: m2.date*/
	get32 = m225.getDate();

	get33 = get32.getYear();

	tmp34 = get31 == get33;

	tmp35 = tmp29 && tmp34;

	/* 27:129-27:142: m1.date.month*/
	/* 27:129-27:136: m1.date*/
	get36 = tmp17.getDate();

	get37 = get36.getMonth();

	/* 27:145-27:158: m2.date.month*/
	/* 27:145-27:152: m2.date*/
	get38 = m225.getDate();

	get39 = get38.getMonth();

	tmp40 = get37 == get39;

	tmp41 = tmp35 && tmp40;

	/* 27:163-27:174: m1.date.day*/
	/* 27:163-27:170: m1.date*/
	get42 = tmp17.getDate();

	get43 = get42.getDay();

	/* 27:177-27:188: m2.date.day*/
	/* 27:177-27:184: m2.date*/
	get44 = m225.getDate();

	get45 = get44.getDay();

	tmp46 = get43 == get45;

	tmp47 = tmp41 && tmp46;

	if ( tmp47 == true) {
r48.add(m225);
}}
	r51 = new java.util.ArrayList();

	for ( AirMeasurement m24: r48) {
/* 27:204-27:215: m.date.hour*/
	/* 27:204-27:210: m.date*/
	get49 = m24.getDate();

	get50 = get49.getHour();

	r51.add(get50);
}
	a2l.runtime.stdlib.Collections.sort(r51, (p_) -> { 
return p_;
});
	op52 = r51.isEmpty() ? Integer.MAX_VALUE : r51.get(0);

	tmp53 = get23 == op52;

	tmp54 = tmp21 && tmp53;

	/* 28:10-28:24: m1.date.minute*/
	/* 28:10-28:17: m1.date*/
	get55 = tmp17.getDate();

	get56 = get55.getMinute();

	/* 28:27-28:264: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)->sortedBy(v | v)->first()*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)->sortedBy(v | v)*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)*/
	/* null: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)*/
	/* 28:27-28:59: MM!AirMeasurement.allInstances()*/
	op59 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r86 = new java.util.ArrayList();

	for ( AirMeasurement m258: op59) {
/* 28:73-28:83: m1.station*/
	get60 = tmp17.getStation();

	/* 28:84-28:94: m2.station*/
	get61 = m258.getStation();

	tmp62 = get60 == get61;

	/* 28:99-28:111: m1.date.year*/
	/* 28:99-28:106: m1.date*/
	get63 = tmp17.getDate();

	get64 = get63.getYear();

	/* 28:114-28:126: m2.date.year*/
	/* 28:114-28:121: m2.date*/
	get65 = m258.getDate();

	get66 = get65.getYear();

	tmp67 = get64 == get66;

	tmp68 = tmp62 && tmp67;

	/* 28:131-28:144: m1.date.month*/
	/* 28:131-28:138: m1.date*/
	get69 = tmp17.getDate();

	get70 = get69.getMonth();

	/* 28:147-28:160: m2.date.month*/
	/* 28:147-28:154: m2.date*/
	get71 = m258.getDate();

	get72 = get71.getMonth();

	tmp73 = get70 == get72;

	tmp74 = tmp68 && tmp73;

	/* 28:165-28:176: m1.date.day*/
	/* 28:165-28:172: m1.date*/
	get75 = tmp17.getDate();

	get76 = get75.getDay();

	/* 28:179-28:190: m2.date.day*/
	/* 28:179-28:186: m2.date*/
	get77 = m258.getDate();

	get78 = get77.getDay();

	tmp79 = get76 == get78;

	tmp80 = tmp74 && tmp79;

	/* 28:195-28:207: m2.date.hour*/
	/* 28:195-28:202: m2.date*/
	get81 = m258.getDate();

	get82 = get81.getHour();

	tmp83 = 1;

	tmp84 = get82 < tmp83;

	tmp85 = tmp80 && tmp84;

	if ( tmp85 == true) {
r86.add(m258);
}}
	r89 = new java.util.ArrayList();

	for ( AirMeasurement m57: r86) {
/* 28:224-28:237: m.date.minute*/
	/* 28:224-28:230: m.date*/
	get87 = m57.getDate();

	get88 = get87.getMinute();

	r89.add(get88);
}
	a2l.runtime.stdlib.Collections.sort(r89, (p_) -> { 
return p_;
});
	op90 = r89.isEmpty() ? Integer.MAX_VALUE : r89.get(0);

	tmp91 = get56 == op90;

	tmp92 = tmp54 && tmp91;

	/* 31:10-34:39: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)->collect(m3 | m3.co)*/
	/* 31:10-33:50: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)*/
	/* 31:10-31:42: MM!AirMeasurement.allInstances()*/
	op96 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r114 = javaslang.collection.List.empty();

	for ( AirMeasurement m295: op96) {
tmp97 = tmp17 != m295;

	/* 31:67-31:77: m1.station*/
	get98 = tmp17.getStation();

	/* 31:80-31:90: m2.station*/
	get99 = m295.getStation();

	tmp100 = get98 == get99;

	tmp101 = tmp97 && tmp100;

	/* 32:22-32:35: m1.date.month*/
	/* 32:22-32:29: m1.date*/
	get102 = tmp17.getDate();

	get103 = get102.getMonth();

	/* 32:38-32:51: m2.date.month*/
	/* 32:38-32:45: m2.date*/
	get104 = m295.getDate();

	get105 = get104.getMonth();

	tmp106 = get103 == get105;

	tmp107 = tmp101 && tmp106;

	/* 33:22-33:34: m1.date.year*/
	/* 33:22-33:29: m1.date*/
	get108 = tmp17.getDate();

	get109 = get108.getYear();

	/* 33:37-33:49: m2.date.year*/
	/* 33:37-33:44: m2.date*/
	get110 = m295.getDate();

	get111 = get110.getYear();

	tmp112 = get109 == get111;

	tmp113 = tmp107 && tmp112;

	if ( tmp113 == true) {
r114 = r114.append(m295);
}}
	r116 = javaslang.collection.List.empty();

	for ( AirMeasurement m394: r114) {
/* 34:32-34:37: m3.co*/
	get115 = m394.getCo();

	r116 = r116.append(get115);
}
	r119 = 0;

	for ( double coLevel93: r116) {
tmp117 = 4.5;

	tmp118 = coLevel93 >= tmp117;

	if ( tmp118 == true) {
r119++;
}}
	tmp120 = 10;

	tmp121 = r119 > tmp120;

	tmp122 = tmp92 && tmp121;

	return tmp122 == true;
}
	return false;
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
	public a2l.tests.airquality.optimised.AirQualityReport setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.airquality.optimised.AirQualityReport setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_highCO(AirMeasurement m1){
Warning w0;
Date d21;
double tmp2;
java.lang.String tmp3;
int get4;
Date get5;
int get6;
Date get7;
int get8;
Date get9;
int get10;
Date get11;
int get12;
Date get13;
int get14;
Date get15;
int get16;w0 = airquality.AirqualityFactory.eINSTANCE.createWarning();

	d21 = airquality.AirqualityFactory.eINSTANCE.createDate();

	OUTModel_PartialOutput_.write(w0);

	OUTModel_PartialOutput_.write(d21);

	tmp2 = 4.5;

	tmp3 = "co";

	/* 40:15-40:25: m1.station*/
	get4 = m1.getStation();

	w0.setLevel(tmp2);;

	w0.setPollutant(tmp3);;

	w0.setStation(get4);;

	boolean matched0 = false;
	w0.setDate(d21);;

	/* 44:12-44:24: m1.date.year*/
	/* 44:12-44:19: m1.date*/
	get5 = m1.getDate();

	get6 = get5.getYear();

	/* 45:13-45:26: m1.date.month*/
	/* 45:13-45:20: m1.date*/
	get7 = m1.getDate();

	get8 = get7.getMonth();

	/* 46:11-46:22: m1.date.day*/
	/* 46:11-46:18: m1.date*/
	get9 = m1.getDate();

	get10 = get9.getDay();

	/* 47:12-47:24: m1.date.hour*/
	/* 47:12-47:19: m1.date*/
	get11 = m1.getDate();

	get12 = get11.getHour();

	/* 48:14-48:28: m1.date.minute*/
	/* 48:14-48:21: m1.date*/
	get13 = m1.getDate();

	get14 = get13.getMinute();

	/* 49:14-49:28: m1.date.second*/
	/* 49:14-49:21: m1.date*/
	get15 = m1.getDate();

	get16 = get15.getSecond();

	d21.setYear(get6);;

	d21.setMonth(get8);;

	d21.setDay(get10);;

	d21.setHour(get12);;

	d21.setMinute(get14);;

	d21.setSecond(get16);;

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched1 = false;if ( check_highCO( e) )  {
create_highCO((airquality.AirMeasurement)e);
}

	numExecutions_++;
}}