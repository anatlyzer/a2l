package a2l.tests.dblp2bibtex.optimised;

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
import dblp.DBLP.Record;
import a2l.tests.bibtex.BibTeX.BibTeXFile;
import dblp.DBLP.Editor;
import dblp.DBLP.Journal;
import dblp.DBLP.MastersThesis;
import a2l.tests.bibtex.BibTeX.MasterThesis;
import dblp.DBLP.School;
import dblp.DBLP.Publisher;

public class DBLP2BibTeX implements ITransformation, lintra2.transfo.ITransformation2{
private IModel INModel_;
	private IOutputModel OUTModel_;
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public DBLP2BibTeX(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXGlobalContext global) {
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
private static final class PendingTask_BibTeXFile_entries implements IPendingTask { 
private final a2l.tests.bibtex.BibTeX.BibTeXFile tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_BibTeXFile_entries(a2l.tests.bibtex.BibTeX.BibTeXFile tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_BibTeXFile_entries(a2l.tests.bibtex.BibTeX.BibTeXFile tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof a2l.tests.bibtex.BibTeX.BibTeXEntry) { result.add(tgt); }}
tgt.getEntries().addAll((Collection<? extends a2l.tests.bibtex.BibTeX.BibTeXEntry>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof a2l.tests.bibtex.BibTeX.BibTeXEntry) { result.add(tgt); }   }}tgt.getEntries().addAll((Collection<? extends a2l.tests.bibtex.BibTeX.BibTeXEntry>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private static final class PendingTask_AuthoredEntry_authors implements IPendingTask { 
private final a2l.tests.bibtex.BibTeX.AuthoredEntry tgt;
private final Collection<Object> objId;
private final a2l.runtime.IModel area;
private final java.util.Set<? extends Object> tgtElems;
public PendingTask_AuthoredEntry_authors(a2l.tests.bibtex.BibTeX.AuthoredEntry tgt, Collection<Object> objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;
}
public PendingTask_AuthoredEntry_authors(a2l.tests.bibtex.BibTeX.AuthoredEntry tgt, Object objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {
	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;
}
public void execute(a2l.runtime.GlobalTrace globalTrace) {
if (tgtElems == null) {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {Object tgt = getTrace(object, globalTrace);  if (tgt instanceof a2l.tests.bibtex.BibTeX.Author) { result.add(tgt); }}
tgt.getAuthors().addAll((Collection<? extends a2l.tests.bibtex.BibTeX.Author>)result);}else {ArrayList<Object> result = new ArrayList<>(objId.size());for (Object object : objId) {  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }  else {          Object tgt = getTrace(object, globalTrace);          if (tgt instanceof a2l.tests.bibtex.BibTeX.Author) { result.add(tgt); }   }}tgt.getAuthors().addAll((Collection<? extends a2l.tests.bibtex.BibTeX.Author>)result);} }
private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) { return globalTrace.get(object);}
private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {         if (object instanceof a2l.runtime.ResolveTempObject) {             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());         } return object;}
}

private boolean check_Article(java.lang.Object a){
return a instanceof dblp.DBLP.Article;
}
	private boolean check_InProceedings(java.lang.Object a){
return a instanceof dblp.DBLP.InProceedings;
}
	private boolean check_MasterThesis(java.lang.Object a){
return a instanceof dblp.DBLP.MastersThesis;
}
	private boolean check_InCollection(java.lang.Object a){
return a instanceof dblp.DBLP.InCollection;
}
	private boolean check_Book(java.lang.Object a){
return a instanceof dblp.DBLP.Book;
}
	private boolean check_PhDThesis(java.lang.Object a){
return a instanceof dblp.DBLP.PhDThesis;
}
	private boolean check_Proceedings(java.lang.Object a){
dblp.DBLP.Proceedings tmp116;
boolean call117;if ( a instanceof dblp.DBLP.Proceedings) {
tmp116 = (dblp.DBLP.Proceedings)a;

	/* 120:30-120:48: a.isEditorAuthor()*/
	if ( tmp116 instanceof dblp.DBLP.Proceedings) {
call117 = helper_dblp_DBLP_Proceedings_isEditorAuthor((dblp.DBLP.Proceedings)tmp116);
} else { throw new IllegalStateException();
}
	return call117 == true;
}
	return false;
}
	public a2l.tests.bibtex.BibTeX.Author lazy_rule_toAuthor(dblp.DBLP.Author a){
a2l.tests.bibtex.BibTeX.Author a2118;
java.lang.String get119;a2118 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createAuthor();

	OUTModel_PartialOutput_.write(a2118);

	/* 131:13-131:19: a.name*/
	get119 = a.getName();

	a2118.setAuthor(get119);;

	return a2118;
}
	public BibTeXFile called_rule_rootElement(){
BibTeXFile b0;
javaslang.collection.List<Record> op6;
List<java.lang.Object> itTmp7;b0 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createBibTeXFile();

	OUTModel_PartialOutput_.write(b0);

	/* 27:15-27:41: DBLP!Record.allInstances()*/
	op6 = this.globalContext.getAllInstancesOf_Record();

	itTmp7 = new ArrayList<Object>(op6.size());

	for ( java.lang.Object o: op6) {
boolean matched0 = false;if ( check_InCollection( o) )  {
itTmp7.add(o);
}
else if ( check_Article( o) )  {
itTmp7.add(o);
}
else if ( check_Book( o) )  {
itTmp7.add(o);
}
else if ( check_MasterThesis( o) )  {
itTmp7.add(o);
}
else if ( check_PhDThesis( o) )  {
itTmp7.add(o);
}
else if ( check_InProceedings( o) )  {
itTmp7.add(o);
}
else if ( check_Proceedings( o) )  {
itTmp7.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_BibTeXFile_entries(b0,itTmp7,OUTModel_,null) );

	return b0;
}
	public boolean helper_dblp_DBLP_Proceedings_isEditorAuthor(dblp.DBLP.Proceedings self_){
javaslang.collection.List<Editor> get2;
boolean op3;
java.lang.String get4;
boolean r5;/* 19:2-22:17: self.editors->exists(editor | <allInstancesIndexed: DBLP!Author.allInstances()->exists(a2 | a2.name = editor.name)>)*/
	/* 19:2-19:14: self.editors*/
	get2 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Editor>(self_.getEditors()));

	r5 = false;

	for ( Editor editor1: get2) {
/* null: <allInstancesIndexed: DBLP!Author.allInstances()->exists(a2 | a2.name = editor.name)>*/
	/* 22:4-22:15: editor.name*/
	get4 = editor1.getName();

	op3 = this.globalContext.getValueOf_Author_name(get4);

	if ( op3) {
r5 = true;

	break;
}}
	return r5;
}
	public void doEndpoint(){
called_rule_rootElement();
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
	public a2l.tests.dblp2bibtex.optimised.DBLP2BibTeX setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp2bibtex.optimised.DBLP2BibTeX setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_Article(dblp.DBLP.Article a){
a2l.tests.bibtex.BibTeX.Article b8;
java.lang.String get9;
java.lang.String get10;
int get11;
java.lang.String op12;
Journal get13;
java.lang.String get14;
Journal get15;
boolean op16;
boolean tmp17;
java.lang.String tmp18;
java.lang.String r19;
List<dblp.DBLP.Author> get21;
a2l.tests.bibtex.BibTeX.Author call22;
List<a2l.tests.bibtex.BibTeX.Author> r23;
List<java.lang.Object> itTmp24;
java.util.Set<java.lang.Object> tgtElems25;b8 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createArticle();

	this.trace.put(a,b8);

	OUTModel_PartialOutput_.write(b8);

	/* 34:9-34:16: a.title*/
	get9 = a.getTitle();

	/* 35:12-35:19: a.title*/
	get10 = a.getTitle();

	/* 36:11-36:28: a.year.toString()*/
	/* 36:11-36:17: a.year*/
	get11 = a.getYear();

	op12 = get11 + "";

	/* 37:14-41:9: if not a.journal.oclIsUndefined() then
	a.journal.name
else
	'<unknown>'
endif*/
	/* 37:21-37:47: a.journal.oclIsUndefined()*/
	/* 37:21-37:30: a.journal*/
	get15 = a.getJournal();

	op16 = get15== null;

	tmp17 = ! op16;

	r19 = "";

	if ( tmp17) {
/* 38:5-38:19: a.journal.name*/
	/* 38:5-38:14: a.journal*/
	get13 = a.getJournal();

	get14 = get13.getName();

	r19 = get14;
} else { tmp18 = "<unknown>";

r19 = tmp18;
}
	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 42:14-42:23: a.authors*/
	get21 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r23 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author20: get21) {
/* 42:42-42:69: thisModule.toAuthor(author)*/
	call22 = lazy_rule_toAuthor(author20);

	r23.add(call22);
}
	b8.setId(get9);;

	b8.setTitle(get10);;

	b8.setYear(op12);;

	b8.setJournal(r19);;

	itTmp24 = new ArrayList<Object>(r23.size());

	tgtElems25 = new java.util.HashSet<>();

	for ( java.lang.Object o: r23) {
boolean matched1 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp24, tgtElems25, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b8,itTmp24,OUTModel_,tgtElems25) );

	numMatchedRuleExecutions_++;
}
	private void create_InProceedings(dblp.DBLP.InProceedings a){
a2l.tests.bibtex.BibTeX.InProceedings b26;
java.lang.String get27;
java.lang.String get28;
int get29;
java.lang.String op30;
List<dblp.DBLP.Author> get32;
a2l.tests.bibtex.BibTeX.Author call33;
List<a2l.tests.bibtex.BibTeX.Author> r34;
java.lang.String get35;
List<java.lang.Object> itTmp36;
java.util.Set<java.lang.Object> tgtElems37;b26 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInProceedings();

	this.trace.put(a,b26);

	OUTModel_PartialOutput_.write(b26);

	/* 49:9-49:16: a.title*/
	get27 = a.getTitle();

	/* 50:12-50:19: a.title*/
	get28 = a.getTitle();

	/* 51:11-51:28: a.year.toString()*/
	/* 51:11-51:17: a.year*/
	get29 = a.getYear();

	op30 = get29 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 52:14-52:23: a.authors*/
	get32 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r34 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author31: get32) {
/* 52:42-52:69: thisModule.toAuthor(author)*/
	call33 = lazy_rule_toAuthor(author31);

	r34.add(call33);
}
	/* 53:16-53:26: a.bootitle*/
	get35 = a.getBootitle();

	b26.setId(get27);;

	b26.setTitle(get28);;

	b26.setYear(op30);;

	itTmp36 = new ArrayList<Object>(r34.size());

	tgtElems37 = new java.util.HashSet<>();

	for ( java.lang.Object o: r34) {
boolean matched2 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp36, tgtElems37, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b26,itTmp36,OUTModel_,tgtElems37) );

	b26.setBooktitle(get35);;

	numMatchedRuleExecutions_++;
}
	private void create_MasterThesis(MastersThesis a){
MasterThesis b38;
java.lang.String get39;
java.lang.String get40;
int get41;
java.lang.String op42;
List<dblp.DBLP.Author> get44;
a2l.tests.bibtex.BibTeX.Author call45;
List<a2l.tests.bibtex.BibTeX.Author> r46;
School get47;
java.lang.String get48;
School get49;
boolean op50;
boolean tmp51;
java.lang.String tmp52;
java.lang.String r53;
List<java.lang.Object> itTmp54;
java.util.Set<java.lang.Object> tgtElems55;b38 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createMasterThesis();

	this.trace.put(a,b38);

	OUTModel_PartialOutput_.write(b38);

	/* 60:9-60:16: a.title*/
	get39 = a.getTitle();

	/* 61:12-61:19: a.title*/
	get40 = a.getTitle();

	/* 62:11-62:28: a.year.toString()*/
	/* 62:11-62:17: a.year*/
	get41 = a.getYear();

	op42 = get41 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 63:14-63:23: a.authors*/
	get44 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r46 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author43: get44) {
/* 63:42-63:69: thisModule.toAuthor(author)*/
	call45 = lazy_rule_toAuthor(author43);

	r46.add(call45);
}
	/* 64:13-68:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 64:20-64:45: a.school.oclIsUndefined()*/
	/* 64:20-64:28: a.school*/
	get49 = a.getSchool();

	op50 = get49== null;

	tmp51 = ! op50;

	r53 = "";

	if ( tmp51) {
/* 65:5-65:18: a.school.name*/
	/* 65:5-65:13: a.school*/
	get47 = a.getSchool();

	get48 = get47.getName();

	r53 = get48;
} else { tmp52 = "<unknown>";

r53 = tmp52;
}
	b38.setId(get39);;

	b38.setTitle(get40);;

	b38.setYear(op42);;

	itTmp54 = new ArrayList<Object>(r46.size());

	tgtElems55 = new java.util.HashSet<>();

	for ( java.lang.Object o: r46) {
boolean matched3 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp54, tgtElems55, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b38,itTmp54,OUTModel_,tgtElems55) );

	b38.setSchool(r53);;

	numMatchedRuleExecutions_++;
}
	private void create_InCollection(dblp.DBLP.InCollection a){
a2l.tests.bibtex.BibTeX.InCollection b56;
java.lang.String get57;
java.lang.String get58;
int get59;
java.lang.String op60;
List<dblp.DBLP.Author> get62;
a2l.tests.bibtex.BibTeX.Author call63;
List<a2l.tests.bibtex.BibTeX.Author> r64;
java.lang.String get65;
Publisher get66;
java.lang.String get67;
Publisher get68;
boolean op69;
boolean tmp70;
java.lang.String tmp71;
java.lang.String r72;
List<java.lang.Object> itTmp73;
java.util.Set<java.lang.Object> tgtElems74;b56 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInCollection();

	this.trace.put(a,b56);

	OUTModel_PartialOutput_.write(b56);

	/* 76:9-76:16: a.title*/
	get57 = a.getTitle();

	/* 77:12-77:19: a.title*/
	get58 = a.getTitle();

	/* 78:11-78:28: a.year.toString()*/
	/* 78:11-78:17: a.year*/
	get59 = a.getYear();

	op60 = get59 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 79:14-79:23: a.authors*/
	get62 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r64 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author61: get62) {
/* 79:42-79:69: thisModule.toAuthor(author)*/
	call63 = lazy_rule_toAuthor(author61);

	r64.add(call63);
}
	/* 80:16-80:27: a.bookTitle*/
	get65 = a.getBookTitle();

	/* 81:16-85:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 81:23-81:51: a.publisher.oclIsUndefined()*/
	/* 81:23-81:34: a.publisher*/
	get68 = a.getPublisher();

	op69 = get68== null;

	tmp70 = ! op69;

	r72 = "";

	if ( tmp70) {
/* 82:5-82:21: a.publisher.name*/
	/* 82:5-82:16: a.publisher*/
	get66 = a.getPublisher();

	get67 = get66.getName();

	r72 = get67;
} else { tmp71 = "<unknown>";

r72 = tmp71;
}
	b56.setId(get57);;

	b56.setTitle(get58);;

	b56.setYear(op60);;

	itTmp73 = new ArrayList<Object>(r64.size());

	tgtElems74 = new java.util.HashSet<>();

	for ( java.lang.Object o: r64) {
boolean matched4 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp73, tgtElems74, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b56,itTmp73,OUTModel_,tgtElems74) );

	b56.setBooktitle(get65);;

	b56.setPublisher(r72);;

	numMatchedRuleExecutions_++;
}
	private void create_Book(dblp.DBLP.Book a){
a2l.tests.bibtex.BibTeX.Book b75;
java.lang.String get76;
java.lang.String get77;
int get78;
java.lang.String op79;
List<dblp.DBLP.Author> get81;
a2l.tests.bibtex.BibTeX.Author call82;
List<a2l.tests.bibtex.BibTeX.Author> r83;
Publisher get84;
java.lang.String get85;
Publisher get86;
boolean op87;
boolean tmp88;
java.lang.String tmp89;
java.lang.String r90;
List<java.lang.Object> itTmp91;
java.util.Set<java.lang.Object> tgtElems92;b75 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createBook();

	this.trace.put(a,b75);

	OUTModel_PartialOutput_.write(b75);

	/* 92:9-92:16: a.title*/
	get76 = a.getTitle();

	/* 93:12-93:19: a.title*/
	get77 = a.getTitle();

	/* 94:11-94:28: a.year.toString()*/
	/* 94:11-94:17: a.year*/
	get78 = a.getYear();

	op79 = get78 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 95:14-95:23: a.authors*/
	get81 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r83 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author80: get81) {
/* 95:42-95:69: thisModule.toAuthor(author)*/
	call82 = lazy_rule_toAuthor(author80);

	r83.add(call82);
}
	/* 96:16-100:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 96:23-96:51: a.publisher.oclIsUndefined()*/
	/* 96:23-96:34: a.publisher*/
	get86 = a.getPublisher();

	op87 = get86== null;

	tmp88 = ! op87;

	r90 = "";

	if ( tmp88) {
/* 97:5-97:21: a.publisher.name*/
	/* 97:5-97:16: a.publisher*/
	get84 = a.getPublisher();

	get85 = get84.getName();

	r90 = get85;
} else { tmp89 = "<unknown>";

r90 = tmp89;
}
	b75.setId(get76);;

	b75.setTitle(get77);;

	b75.setYear(op79);;

	itTmp91 = new ArrayList<Object>(r83.size());

	tgtElems92 = new java.util.HashSet<>();

	for ( java.lang.Object o: r83) {
boolean matched5 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp91, tgtElems92, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b75,itTmp91,OUTModel_,tgtElems92) );

	b75.setPublisher(r90);;

	numMatchedRuleExecutions_++;
}
	private void create_PhDThesis(dblp.DBLP.PhDThesis a){
a2l.tests.bibtex.BibTeX.PhDThesis b93;
java.lang.String get94;
java.lang.String get95;
int get96;
java.lang.String op97;
List<dblp.DBLP.Author> get99;
a2l.tests.bibtex.BibTeX.Author call100;
List<a2l.tests.bibtex.BibTeX.Author> r101;
School get102;
java.lang.String get103;
School get104;
boolean op105;
boolean tmp106;
java.lang.String tmp107;
java.lang.String r108;
List<java.lang.Object> itTmp109;
java.util.Set<java.lang.Object> tgtElems110;b93 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createPhDThesis();

	this.trace.put(a,b93);

	OUTModel_PartialOutput_.write(b93);

	/* 107:9-107:16: a.title*/
	get94 = a.getTitle();

	/* 108:12-108:19: a.title*/
	get95 = a.getTitle();

	/* 109:11-109:28: a.year.toString()*/
	/* 109:11-109:17: a.year*/
	get96 = a.getYear();

	op97 = get96 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 110:14-110:23: a.authors*/
	get99 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r101 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author98: get99) {
/* 110:42-110:69: thisModule.toAuthor(author)*/
	call100 = lazy_rule_toAuthor(author98);

	r101.add(call100);
}
	/* 111:13-115:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 111:20-111:45: a.school.oclIsUndefined()*/
	/* 111:20-111:28: a.school*/
	get104 = a.getSchool();

	op105 = get104== null;

	tmp106 = ! op105;

	r108 = "";

	if ( tmp106) {
/* 112:5-112:18: a.school.name*/
	/* 112:5-112:13: a.school*/
	get102 = a.getSchool();

	get103 = get102.getName();

	r108 = get103;
} else { tmp107 = "<unknown>";

r108 = tmp107;
}
	b93.setId(get94);;

	b93.setTitle(get95);;

	b93.setYear(op97);;

	itTmp109 = new ArrayList<Object>(r101.size());

	tgtElems110 = new java.util.HashSet<>();

	for ( java.lang.Object o: r101) {
boolean matched6 = false;
	a2l.runtime.RuntimeUtils.addToBindingTemporal(itTmp109, tgtElems110, o);
}
	this.parallelPendingTasks.add( new PendingTask_AuthoredEntry_authors(b93,itTmp109,OUTModel_,tgtElems110) );

	b93.setSchool(r108);;

	numMatchedRuleExecutions_++;
}
	private void create_Proceedings(dblp.DBLP.Proceedings a){
a2l.tests.bibtex.BibTeX.Proceedings b111;
java.lang.String get112;
java.lang.String get113;
int get114;
java.lang.String op115;b111 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createProceedings();

	this.trace.put(a,b111);

	OUTModel_PartialOutput_.write(b111);

	/* 122:9-122:16: a.title*/
	get112 = a.getTitle();

	/* 123:12-123:19: a.title*/
	get113 = a.getTitle();

	/* 124:11-124:28: a.year.toString()*/
	/* 124:11-124:17: a.year*/
	get114 = a.getYear();

	op115 = get114 + "";

	b111.setId(get112);;

	b111.setTitle(get113);;

	b111.setYear(op115);;

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched7 = false;if ( check_Article( e) )  {
create_Article((dblp.DBLP.Article)e);
}
else if ( check_InProceedings( e) )  {
create_InProceedings((dblp.DBLP.InProceedings)e);
}
else if ( check_MasterThesis( e) )  {
create_MasterThesis((dblp.DBLP.MastersThesis)e);
}
else if ( check_InCollection( e) )  {
create_InCollection((dblp.DBLP.InCollection)e);
}
else if ( check_Book( e) )  {
create_Book((dblp.DBLP.Book)e);
}
else if ( check_PhDThesis( e) )  {
create_PhDThesis((dblp.DBLP.PhDThesis)e);
}
else if ( check_Proceedings( e) )  {
create_Proceedings((dblp.DBLP.Proceedings)e);
}

	numExecutions_++;
}}