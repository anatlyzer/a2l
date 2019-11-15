package a2l.tests.airquality.normal;

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
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.airquality.normal.AirQualityReportGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public AirQualityReport(a2l.runtime.InputExtent inputExtent,a2l.tests.airquality.normal.AirQualityReportGlobalContext global) {
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
javaslang.collection.List<AirMeasurement> r48;
Date get49;
int get50;
javaslang.collection.List<java.lang.Integer> r51;
javaslang.collection.List<java.lang.Integer> r52;
int op53;
boolean tmp54;
boolean tmp55;
Date get56;
int get57;
javaslang.collection.List<AirMeasurement> op60;
int get61;
int get62;
boolean tmp63;
Date get64;
int get65;
Date get66;
int get67;
boolean tmp68;
boolean tmp69;
Date get70;
int get71;
Date get72;
int get73;
boolean tmp74;
boolean tmp75;
Date get76;
int get77;
Date get78;
int get79;
boolean tmp80;
boolean tmp81;
Date get82;
int get83;
int tmp84;
boolean tmp85;
boolean tmp86;
javaslang.collection.List<AirMeasurement> r87;
Date get88;
int get89;
javaslang.collection.List<java.lang.Integer> r90;
javaslang.collection.List<java.lang.Integer> r91;
int op92;
boolean tmp93;
boolean tmp94;
javaslang.collection.List<AirMeasurement> op98;
boolean tmp99;
int get100;
int get101;
boolean tmp102;
boolean tmp103;
Date get104;
int get105;
Date get106;
int get107;
boolean tmp108;
boolean tmp109;
Date get110;
int get111;
Date get112;
int get113;
boolean tmp114;
boolean tmp115;
javaslang.collection.List<AirMeasurement> r116;
double get117;
javaslang.collection.List<java.lang.Double> r118;
double tmp119;
boolean tmp120;
javaslang.collection.List<java.lang.Double> r121;
int op122;
int tmp123;
boolean tmp124;
boolean tmp125;if ( m1 instanceof airquality.AirMeasurement) {
tmp17 = (airquality.AirMeasurement)m1;

	/* 22:28-22:39: m1.date.day*/
	/* 22:28-22:35: m1.date*/
	get18 = tmp17.getDate();

	get19 = get18.getDay();

	tmp20 = 1;

	tmp21 = get19 == tmp20;

	/* 28:10-28:22: m1.date.hour*/
	/* 28:10-28:17: m1.date*/
	get22 = tmp17.getDate();

	get23 = get22.getHour();

	/* 28:25-28:242: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)->sortedBy(v | v)->first()*/
	/* 28:25-28:233: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)->sortedBy(v | v)*/
	/* 28:25-28:216: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)->collect(m | m.date.hour)*/
	/* 28:25-28:190: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day)*/
	/* 28:25-28:57: MM!AirMeasurement.allInstances()*/
	op26 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r48 = javaslang.collection.List.empty();

	for ( AirMeasurement m225: op26) {
/* 28:71-28:81: m1.station*/
	get27 = tmp17.getStation();

	/* 28:82-28:92: m2.station*/
	get28 = m225.getStation();

	tmp29 = get27 == get28;

	/* 28:97-28:109: m1.date.year*/
	/* 28:97-28:104: m1.date*/
	get30 = tmp17.getDate();

	get31 = get30.getYear();

	/* 28:112-28:124: m2.date.year*/
	/* 28:112-28:119: m2.date*/
	get32 = m225.getDate();

	get33 = get32.getYear();

	tmp34 = get31 == get33;

	tmp35 = tmp29 && tmp34;

	/* 28:129-28:142: m1.date.month*/
	/* 28:129-28:136: m1.date*/
	get36 = tmp17.getDate();

	get37 = get36.getMonth();

	/* 28:145-28:158: m2.date.month*/
	/* 28:145-28:152: m2.date*/
	get38 = m225.getDate();

	get39 = get38.getMonth();

	tmp40 = get37 == get39;

	tmp41 = tmp35 && tmp40;

	/* 28:163-28:174: m1.date.day*/
	/* 28:163-28:170: m1.date*/
	get42 = tmp17.getDate();

	get43 = get42.getDay();

	/* 28:177-28:188: m2.date.day*/
	/* 28:177-28:184: m2.date*/
	get44 = m225.getDate();

	get45 = get44.getDay();

	tmp46 = get43 == get45;

	tmp47 = tmp41 && tmp46;

	if ( tmp47 == true) {
r48 = r48.append(m225);
}}
	r51 = javaslang.collection.List.empty();

	for ( AirMeasurement m24: r48) {
/* 28:204-28:215: m.date.hour*/
	/* 28:204-28:210: m.date*/
	get49 = m24.getDate();

	get50 = get49.getHour();

	r51 = r51.append(get50);
}
	r52 = javaslang.collection.List.empty();

	r52 = r51.sortBy((p_) -> { 
return p_;
});

	op53 = r52.isEmpty() ? Integer.MAX_VALUE : r52.get(0);

	tmp54 = get23 == op53;

	tmp55 = tmp21 && tmp54;

	/* 29:10-29:24: m1.date.minute*/
	/* 29:10-29:17: m1.date*/
	get56 = tmp17.getDate();

	get57 = get56.getMinute();

	/* 29:27-29:264: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)->sortedBy(v | v)->first()*/
	/* 29:27-29:255: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)->sortedBy(v | v)*/
	/* 29:27-29:238: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)->collect(m | m.date.minute)*/
	/* 29:27-29:210: MM!AirMeasurement.allInstances()->select(m2 | m1.station = m2.station and m1.date.year = m2.date.year and m1.date.month = m2.date.month and m1.date.day = m2.date.day and m2.date.hour < 1)*/
	/* 29:27-29:59: MM!AirMeasurement.allInstances()*/
	op60 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r87 = javaslang.collection.List.empty();

	for ( AirMeasurement m259: op60) {
/* 29:73-29:83: m1.station*/
	get61 = tmp17.getStation();

	/* 29:84-29:94: m2.station*/
	get62 = m259.getStation();

	tmp63 = get61 == get62;

	/* 29:99-29:111: m1.date.year*/
	/* 29:99-29:106: m1.date*/
	get64 = tmp17.getDate();

	get65 = get64.getYear();

	/* 29:114-29:126: m2.date.year*/
	/* 29:114-29:121: m2.date*/
	get66 = m259.getDate();

	get67 = get66.getYear();

	tmp68 = get65 == get67;

	tmp69 = tmp63 && tmp68;

	/* 29:131-29:144: m1.date.month*/
	/* 29:131-29:138: m1.date*/
	get70 = tmp17.getDate();

	get71 = get70.getMonth();

	/* 29:147-29:160: m2.date.month*/
	/* 29:147-29:154: m2.date*/
	get72 = m259.getDate();

	get73 = get72.getMonth();

	tmp74 = get71 == get73;

	tmp75 = tmp69 && tmp74;

	/* 29:165-29:176: m1.date.day*/
	/* 29:165-29:172: m1.date*/
	get76 = tmp17.getDate();

	get77 = get76.getDay();

	/* 29:179-29:190: m2.date.day*/
	/* 29:179-29:186: m2.date*/
	get78 = m259.getDate();

	get79 = get78.getDay();

	tmp80 = get77 == get79;

	tmp81 = tmp75 && tmp80;

	/* 29:195-29:207: m2.date.hour*/
	/* 29:195-29:202: m2.date*/
	get82 = m259.getDate();

	get83 = get82.getHour();

	tmp84 = 1;

	tmp85 = get83 < tmp84;

	tmp86 = tmp81 && tmp85;

	if ( tmp86 == true) {
r87 = r87.append(m259);
}}
	r90 = javaslang.collection.List.empty();

	for ( AirMeasurement m58: r87) {
/* 29:224-29:237: m.date.minute*/
	/* 29:224-29:230: m.date*/
	get88 = m58.getDate();

	get89 = get88.getMinute();

	r90 = r90.append(get89);
}
	r91 = javaslang.collection.List.empty();

	r91 = r90.sortBy((p_) -> { 
return p_;
});

	op92 = r91.isEmpty() ? Integer.MAX_VALUE : r91.get(0);

	tmp93 = get57 == op92;

	tmp94 = tmp55 && tmp93;

	/* 32:10-36:59: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)->collect(m3 | m3.co)->select(coLevel | coLevel >= 4.5)->size()*/
	/* 32:10-36:51: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)->collect(m3 | m3.co)->select(coLevel | coLevel >= 4.5)*/
	/* 32:10-35:39: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)->collect(m3 | m3.co)*/
	/* 32:10-34:50: MM!AirMeasurement.allInstances()->select(m2 | m1 <> m2 and m1.station = m2.station and m1.date.month = m2.date.month and m1.date.year = m2.date.year)*/
	/* 32:10-32:42: MM!AirMeasurement.allInstances()*/
	op98 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r116 = javaslang.collection.List.empty();

	for ( AirMeasurement m297: op98) {
tmp99 = tmp17 != m297;

	/* 32:67-32:77: m1.station*/
	get100 = tmp17.getStation();

	/* 32:80-32:90: m2.station*/
	get101 = m297.getStation();

	tmp102 = get100 == get101;

	tmp103 = tmp99 && tmp102;

	/* 33:22-33:35: m1.date.month*/
	/* 33:22-33:29: m1.date*/
	get104 = tmp17.getDate();

	get105 = get104.getMonth();

	/* 33:38-33:51: m2.date.month*/
	/* 33:38-33:45: m2.date*/
	get106 = m297.getDate();

	get107 = get106.getMonth();

	tmp108 = get105 == get107;

	tmp109 = tmp103 && tmp108;

	/* 34:22-34:34: m1.date.year*/
	/* 34:22-34:29: m1.date*/
	get110 = tmp17.getDate();

	get111 = get110.getYear();

	/* 34:37-34:49: m2.date.year*/
	/* 34:37-34:44: m2.date*/
	get112 = m297.getDate();

	get113 = get112.getYear();

	tmp114 = get111 == get113;

	tmp115 = tmp109 && tmp114;

	if ( tmp115 == true) {
r116 = r116.append(m297);
}}
	r118 = javaslang.collection.List.empty();

	for ( AirMeasurement m396: r116) {
/* 35:32-35:37: m3.co*/
	get117 = m396.getCo();

	r118 = r118.append(get117);
}
	r121 = javaslang.collection.List.empty();

	for ( double coLevel95: r118) {
tmp119 = 4.5;

	tmp120 = coLevel95 >= tmp119;

	if ( tmp120 == true) {
r121 = r121.append(coLevel95);
}}
	op122 = r121.size();

	tmp123 = 10;

	tmp124 = op122 > tmp123;

	tmp125 = tmp94 && tmp124;

	return tmp125 == true;
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
	public a2l.tests.airquality.normal.AirQualityReport setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.airquality.normal.AirQualityReport setOUT(IOutputModel n){
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

	this.trace.put(m1,w0);

	this.trace.put(m1,d21,"d2");

	OUTModel_PartialOutput_.write(w0);

	OUTModel_PartialOutput_.write(d21);

	tmp2 = 4.5;

	tmp3 = "co";

	/* 43:15-43:25: m1.station*/
	get4 = m1.getStation();

	w0.setLevel(tmp2);;

	w0.setPollutant(tmp3);;

	w0.setStation(get4);;

	boolean matched0 = false;
	w0.setDate(d21);;

	/* 47:12-47:24: m1.date.year*/
	/* 47:12-47:19: m1.date*/
	get5 = m1.getDate();

	get6 = get5.getYear();

	/* 48:13-48:26: m1.date.month*/
	/* 48:13-48:20: m1.date*/
	get7 = m1.getDate();

	get8 = get7.getMonth();

	/* 49:11-49:22: m1.date.day*/
	/* 49:11-49:18: m1.date*/
	get9 = m1.getDate();

	get10 = get9.getDay();

	/* 50:12-50:24: m1.date.hour*/
	/* 50:12-50:19: m1.date*/
	get11 = m1.getDate();

	get12 = get11.getHour();

	/* 51:14-51:28: m1.date.minute*/
	/* 51:14-51:21: m1.date*/
	get13 = m1.getDate();

	get14 = get13.getMinute();

	/* 52:14-52:28: m1.date.second*/
	/* 52:14-52:21: m1.date*/
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