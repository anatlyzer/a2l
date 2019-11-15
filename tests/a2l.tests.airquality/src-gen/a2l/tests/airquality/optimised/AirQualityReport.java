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
Date get35;
int get36;
Date get37;
int get38;
boolean tmp39;
boolean tmp40;
Date get41;
int get42;
Date get43;
int get44;
boolean tmp45;
boolean tmp46;
Date get47;
int get48;
List<java.lang.Integer> r49;
int op50;
boolean tmp51;
boolean tmp52;
Date get53;
int get54;
javaslang.collection.List<AirMeasurement> op56;
int get57;
int get58;
boolean tmp59;
Date get60;
int get61;
Date get62;
int get63;
boolean tmp64;
boolean tmp65;
Date get66;
int get67;
Date get68;
int get69;
boolean tmp70;
boolean tmp71;
Date get72;
int get73;
Date get74;
int get75;
boolean tmp76;
boolean tmp77;
Date get78;
int get79;
int tmp80;
boolean tmp81;
boolean tmp82;
Date get83;
int get84;
List<java.lang.Integer> r85;
int op86;
boolean tmp87;
boolean tmp88;
javaslang.collection.List<AirMeasurement> op91;
boolean tmp92;
int get93;
int get94;
boolean tmp95;
boolean tmp96;
Date get97;
int get98;
Date get99;
int get100;
boolean tmp101;
boolean tmp102;
Date get103;
int get104;
Date get105;
int get106;
boolean tmp107;
boolean tmp108;
double get109;
List<java.lang.Double> r110;
double tmp111;
boolean tmp112;
int r113;
int tmp114;
boolean tmp115;
boolean tmp116;if ( m1 instanceof airquality.AirMeasurement) {
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

	r49 = new java.util.ArrayList();

	for ( AirMeasurement m24: op25) {
/* 28:71-28:81: m1.station*/
	get26 = tmp17.getStation();

	/* 28:82-28:92: m.station*/
	get27 = m24.getStation();

	tmp28 = get26 == get27;

	if ( tmp28) {
/* 28:97-28:109: m1.date.year*/
	/* 28:97-28:104: m1.date*/
	get29 = tmp17.getDate();

	get30 = get29.getYear();

	/* 28:112-28:124: m.date.year*/
	/* 28:112-28:119: m.date*/
	get31 = m24.getDate();

	get32 = get31.getYear();

	tmp33 = get30 == get32;

	tmp34 = tmp33;
} else { tmp34 = true;
}
	if ( tmp34) {
/* 28:129-28:142: m1.date.month*/
	/* 28:129-28:136: m1.date*/
	get35 = tmp17.getDate();

	get36 = get35.getMonth();

	/* 28:145-28:158: m.date.month*/
	/* 28:145-28:152: m.date*/
	get37 = m24.getDate();

	get38 = get37.getMonth();

	tmp39 = get36 == get38;

	tmp40 = tmp39;
} else { tmp40 = true;
}
	if ( tmp40) {
/* 28:163-28:174: m1.date.day*/
	/* 28:163-28:170: m1.date*/
	get41 = tmp17.getDate();

	get42 = get41.getDay();

	/* 28:177-28:188: m.date.day*/
	/* 28:177-28:184: m.date*/
	get43 = m24.getDate();

	get44 = get43.getDay();

	tmp45 = get42 == get44;

	tmp46 = tmp45;
} else { tmp46 = true;
}
	if ( tmp46 == true) {
/* 28:204-28:215: m.date.hour*/
	/* 28:204-28:210: m.date*/
	get47 = m24.getDate();

	get48 = get47.getHour();

	r49.add(get48);}}
	a2l.runtime.stdlib.Collections.sort(r49, (p_) -> { 
return p_;
});
	op50 = r49.isEmpty() ? Integer.MAX_VALUE : r49.get(0);

	tmp51 = get23 == op50;

	tmp52 = tmp51;
} else { tmp52 = true;
}
	if ( tmp52) {
/* 29:10-29:24: m1.date.minute*/
	/* 29:10-29:17: m1.date*/
	get53 = tmp17.getDate();

	get54 = get53.getMinute();

	/* 29:27-29:264: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)->first()*/
	/* null: MM!AirMeasurement.allInstances().<IteratorChain>[select-collect]->sortedBy(v | v)*/
	/* 29:27-29:59: MM!AirMeasurement.allInstances()*/
	op56 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r85 = new java.util.ArrayList();

	for ( AirMeasurement m55: op56) {
/* 29:73-29:83: m1.station*/
	get57 = tmp17.getStation();

	/* 29:84-29:94: m.station*/
	get58 = m55.getStation();

	tmp59 = get57 == get58;

	if ( tmp59) {
/* 29:99-29:111: m1.date.year*/
	/* 29:99-29:106: m1.date*/
	get60 = tmp17.getDate();

	get61 = get60.getYear();

	/* 29:114-29:126: m.date.year*/
	/* 29:114-29:121: m.date*/
	get62 = m55.getDate();

	get63 = get62.getYear();

	tmp64 = get61 == get63;

	tmp65 = tmp64;
} else { tmp65 = true;
}
	if ( tmp65) {
/* 29:131-29:144: m1.date.month*/
	/* 29:131-29:138: m1.date*/
	get66 = tmp17.getDate();

	get67 = get66.getMonth();

	/* 29:147-29:160: m.date.month*/
	/* 29:147-29:154: m.date*/
	get68 = m55.getDate();

	get69 = get68.getMonth();

	tmp70 = get67 == get69;

	tmp71 = tmp70;
} else { tmp71 = true;
}
	if ( tmp71) {
/* 29:165-29:176: m1.date.day*/
	/* 29:165-29:172: m1.date*/
	get72 = tmp17.getDate();

	get73 = get72.getDay();

	/* 29:179-29:190: m.date.day*/
	/* 29:179-29:186: m.date*/
	get74 = m55.getDate();

	get75 = get74.getDay();

	tmp76 = get73 == get75;

	tmp77 = tmp76;
} else { tmp77 = true;
}
	if ( tmp77) {
/* 29:195-29:207: m.date.hour*/
	/* 29:195-29:202: m.date*/
	get78 = m55.getDate();

	get79 = get78.getHour();

	tmp80 = 1;

	tmp81 = get79 < tmp80;

	tmp82 = tmp81;
} else { tmp82 = true;
}
	if ( tmp82 == true) {
/* 29:224-29:237: m.date.minute*/
	/* 29:224-29:230: m.date*/
	get83 = m55.getDate();

	get84 = get83.getMinute();

	r85.add(get84);}}
	a2l.runtime.stdlib.Collections.sort(r85, (p_) -> { 
return p_;
});
	op86 = r85.isEmpty() ? Integer.MAX_VALUE : r85.get(0);

	tmp87 = get54 == op86;

	tmp88 = tmp87;
} else { tmp88 = true;
}
	if ( tmp88) {
/* 32:10-32:42: MM!AirMeasurement.allInstances()*/
	op91 = this.globalContext.getAllInstancesOf_AirMeasurement();

	r110 = new java.util.ArrayList();

	for ( AirMeasurement m390: op91) {
tmp92 = tmp17 != m390;

	if ( tmp92) {
/* 32:67-32:77: m1.station*/
	get93 = tmp17.getStation();

	/* 32:80-32:90: m3.station*/
	get94 = m390.getStation();

	tmp95 = get93 == get94;

	tmp96 = tmp95;
} else { tmp96 = true;
}
	if ( tmp96) {
/* 33:22-33:35: m1.date.month*/
	/* 33:22-33:29: m1.date*/
	get97 = tmp17.getDate();

	get98 = get97.getMonth();

	/* 33:38-33:51: m3.date.month*/
	/* 33:38-33:45: m3.date*/
	get99 = m390.getDate();

	get100 = get99.getMonth();

	tmp101 = get98 == get100;

	tmp102 = tmp101;
} else { tmp102 = true;
}
	if ( tmp102) {
/* 34:22-34:34: m1.date.year*/
	/* 34:22-34:29: m1.date*/
	get103 = tmp17.getDate();

	get104 = get103.getYear();

	/* 34:37-34:49: m3.date.year*/
	/* 34:37-34:44: m3.date*/
	get105 = m390.getDate();

	get106 = get105.getYear();

	tmp107 = get104 == get106;

	tmp108 = tmp107;
} else { tmp108 = true;
}
	if ( tmp108 == true) {
/* 35:32-35:37: m3.co*/
	get109 = m390.getCo();

	r110.add(get109);}}
	r113 = 0;

	for ( double coLevel89: r110) {
tmp111 = 4.5;

	tmp112 = coLevel89 >= tmp111;

	if ( tmp112 == true) {
r113++;
}}
	tmp114 = 10;

	tmp115 = r113 > tmp114;

	tmp116 = tmp115;
} else { tmp116 = true;
}
	return tmp116 == true;
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