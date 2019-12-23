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
javaslang.collection.List<AirMeasurement> op25;
int get26;
int get27;
boolean tmp28;
Date get29;
int get30;
Date get31;
int get32;
boolean tmp33;
boolean tmp34;
boolean tmp35;
Date get36;
int get37;
Date get38;
int get39;
boolean tmp40;
boolean tmp41;
boolean tmp42;
Date get43;
int get44;
Date get45;
int get46;
boolean tmp47;
boolean tmp48;
boolean tmp49;
Date get50;
int get51;
List<java.lang.Integer> r52;
int op53;
boolean tmp54;
boolean tmp55;
Date get56;
int get57;
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
boolean tmp69;
Date get70;
int get71;
Date get72;
int get73;
boolean tmp74;
boolean tmp75;
boolean tmp76;
Date get77;
int get78;
Date get79;
int get80;
boolean tmp81;
boolean tmp82;
boolean tmp83;
Date get84;
int get85;
int tmp86;
boolean tmp87;
boolean tmp88;
boolean tmp89;
Date get90;
int get91;
List<java.lang.Integer> r92;
int op93;
boolean tmp94;
boolean tmp95;
javaslang.collection.List<AirMeasurement> op98;
boolean tmp99;
int get100;
int get101;
boolean tmp102;
boolean tmp103;
boolean tmp104;
Date get105;
int get106;
Date get107;
int get108;
boolean tmp109;
boolean tmp110;
boolean tmp111;
Date get112;
int get113;
Date get114;
int get115;
boolean tmp116;
boolean tmp117;
boolean tmp118;
double get119;
List<java.lang.Double> r120;
double tmp121;
boolean tmp122;
int r123;
int tmp124;
boolean tmp125;
boolean tmp126;if ( m1 instanceof airquality.AirMeasurement) {
tmp17 = (airquality.AirMeasurement)m1;

	/* 22:28-22:39: m1.date.day*/
	/* 22:28-22:35: m1.date*/
	get18 = tmp17.getDate();

	get19 = get18.getDay();

	tmp20 = 1;

	tmp21 = get19 == tmp20;

	if ( tmp21) {
/* 28:10-28:22: m1.date.hour*/
	/* 28:10-28:17: m1.date*/
	get22 = tmp17.getDate();

	get23 = get22.getHour();

	/* 28:25-28:242: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)->first()*/
	/* null: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)*/
	/* 28:25-28:57: MM!AirMeasurement.allInstances()*/
	op25 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r52 = new java.util.ArrayList();

	for ( AirMeasurement m24: op25) {
/* 28:71-28:81: m1.station*/
	get26 = tmp17.getStation();

	/* 28:82-28:92: m.station*/
	get27 = m24.getStation();

	tmp28 = get26 == get27;

	/* 28:97-28:109: m1.date.year*/
	/* 28:97-28:104: m1.date*/
	get29 = tmp17.getDate();

	get30 = get29.getYear();

	/* 28:112-28:124: m.date.year*/
	/* 28:112-28:119: m.date*/
	get31 = m24.getDate();

	get32 = get31.getYear();

	tmp33 = get30 == get32;

	tmp35 = tmp28 && tmp33;

	/* 28:129-28:142: m1.date.month*/
	/* 28:129-28:136: m1.date*/
	get36 = tmp17.getDate();

	get37 = get36.getMonth();

	/* 28:145-28:158: m.date.month*/
	/* 28:145-28:152: m.date*/
	get38 = m24.getDate();

	get39 = get38.getMonth();

	tmp40 = get37 == get39;

	tmp42 = tmp35 && tmp40;

	/* 28:163-28:174: m1.date.day*/
	/* 28:163-28:170: m1.date*/
	get43 = tmp17.getDate();

	get44 = get43.getDay();

	/* 28:177-28:188: m.date.day*/
	/* 28:177-28:184: m.date*/
	get45 = m24.getDate();

	get46 = get45.getDay();

	tmp47 = get44 == get46;

	tmp49 = tmp42 && tmp47;

	if ( tmp49 == true) {
/* 28:204-28:215: m.date.hour*/
	/* 28:204-28:210: m.date*/
	get50 = m24.getDate();

	get51 = get50.getHour();

	r52.add(get51);}}
	a2l.runtime.stdlib.Collections.sort(r52, (p_) -> { 
return p_;
});
	op53 = r52.isEmpty() ? Integer.MAX_VALUE : r52.get(0);

	tmp54 = get23 == op53;

	tmp55 = tmp54;
} else { tmp55 = true;
}
	if ( tmp55) {
/* 29:10-29:24: m1.date.minute*/
	/* 29:10-29:17: m1.date*/
	get56 = tmp17.getDate();

	get57 = get56.getMinute();

	/* 29:27-29:264: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)->first()*/
	/* null: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)*/
	/* 29:27-29:59: MM!AirMeasurement.allInstances()*/
	op59 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r92 = new java.util.ArrayList();

	for ( AirMeasurement m58: op59) {
/* 29:73-29:83: m1.station*/
	get60 = tmp17.getStation();

	/* 29:84-29:94: m.station*/
	get61 = m58.getStation();

	tmp62 = get60 == get61;

	/* 29:99-29:111: m1.date.year*/
	/* 29:99-29:106: m1.date*/
	get63 = tmp17.getDate();

	get64 = get63.getYear();

	/* 29:114-29:126: m.date.year*/
	/* 29:114-29:121: m.date*/
	get65 = m58.getDate();

	get66 = get65.getYear();

	tmp67 = get64 == get66;

	tmp69 = tmp62 && tmp67;

	/* 29:131-29:144: m1.date.month*/
	/* 29:131-29:138: m1.date*/
	get70 = tmp17.getDate();

	get71 = get70.getMonth();

	/* 29:147-29:160: m.date.month*/
	/* 29:147-29:154: m.date*/
	get72 = m58.getDate();

	get73 = get72.getMonth();

	tmp74 = get71 == get73;

	tmp76 = tmp69 && tmp74;

	/* 29:165-29:176: m1.date.day*/
	/* 29:165-29:172: m1.date*/
	get77 = tmp17.getDate();

	get78 = get77.getDay();

	/* 29:179-29:190: m.date.day*/
	/* 29:179-29:186: m.date*/
	get79 = m58.getDate();

	get80 = get79.getDay();

	tmp81 = get78 == get80;

	tmp83 = tmp76 && tmp81;

	/* 29:195-29:207: m.date.hour*/
	/* 29:195-29:202: m.date*/
	get84 = m58.getDate();

	get85 = get84.getHour();

	tmp86 = 1;

	tmp87 = get85 < tmp86;

	tmp89 = tmp83 && tmp87;

	if ( tmp89 == true) {
/* 29:224-29:237: m.date.minute*/
	/* 29:224-29:230: m.date*/
	get90 = m58.getDate();

	get91 = get90.getMinute();

	r92.add(get91);}}
	a2l.runtime.stdlib.Collections.sort(r92, (p_) -> { 
return p_;
});
	op93 = r92.isEmpty() ? Integer.MAX_VALUE : r92.get(0);

	tmp94 = get57 == op93;

	tmp95 = tmp94;
} else { tmp95 = true;
}
	if ( tmp95) {
/* 32:10-32:42: MM!AirMeasurement.allInstances()*/
	op98 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r120 = new java.util.ArrayList();

	for ( AirMeasurement m397: op98) {
tmp99 = tmp17 != m397;

	/* 32:67-32:77: m1.station*/
	get100 = tmp17.getStation();

	/* 32:80-32:90: m3.station*/
	get101 = m397.getStation();

	tmp102 = get100 == get101;

	tmp104 = tmp99 && tmp102;

	/* 33:22-33:35: m1.date.month*/
	/* 33:22-33:29: m1.date*/
	get105 = tmp17.getDate();

	get106 = get105.getMonth();

	/* 33:38-33:51: m3.date.month*/
	/* 33:38-33:45: m3.date*/
	get107 = m397.getDate();

	get108 = get107.getMonth();

	tmp109 = get106 == get108;

	tmp111 = tmp104 && tmp109;

	/* 34:22-34:34: m1.date.year*/
	/* 34:22-34:29: m1.date*/
	get112 = tmp17.getDate();

	get113 = get112.getYear();

	/* 34:37-34:49: m3.date.year*/
	/* 34:37-34:44: m3.date*/
	get114 = m397.getDate();

	get115 = get114.getYear();

	tmp116 = get113 == get115;

	tmp118 = tmp111 && tmp116;

	if ( tmp118 == true) {
/* 35:32-35:37: m3.co*/
	get119 = m397.getCo();

	r120.add(get119);}}
	r123 = 0;

	for ( double coLevel96: r120) {
tmp121 = 4.5;

	tmp122 = coLevel96 >= tmp121;

	if ( tmp122 == true) {
r123++;
}}
	tmp124 = 10;

	tmp125 = r123 > tmp124;

	tmp126 = tmp125;
} else { tmp126 = true;
}
	return tmp126 == true;
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