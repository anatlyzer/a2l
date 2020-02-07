package a2l.tests.dblp2bibtex.normal;

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
	private PartialOutputModel OUTModel_PartialOutput_;a2l.runtime.InputExtent inputExtent;a2l.tests.dblp2bibtex.normal.DBLP2BibTeXGlobalContext globalContext;
a2l.runtime.GlobalTrace.PartialTrace trace = null;
int numExecutions_ = 0;
int numMatchedRuleExecutions_ = 0;
public DBLP2BibTeX(a2l.runtime.InputExtent inputExtent,a2l.tests.dblp2bibtex.normal.DBLP2BibTeXGlobalContext global) {
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
dblp.DBLP.Proceedings tmp120;
boolean call121;if ( a instanceof dblp.DBLP.Proceedings) {
tmp120 = (dblp.DBLP.Proceedings)a;

	/* 120:30-120:48: a.isEditorAuthor()*/
	if ( tmp120 instanceof dblp.DBLP.Proceedings) {
call121 = helper_dblp_DBLP_Proceedings_isEditorAuthor((dblp.DBLP.Proceedings)tmp120);
} else { throw new IllegalStateException();
}
	return call121 == true;
}
	return false;
}
	public a2l.tests.bibtex.BibTeX.Author lazy_rule_toAuthor(dblp.DBLP.Author a){
a2l.tests.bibtex.BibTeX.Author a2122;
java.lang.String get123;a2122 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createAuthor();

	OUTModel_PartialOutput_.write(a2122);

	/* 131:13-131:19: a.name*/
	get123 = a.getName();

	a2122.setAuthor(get123);;

	return a2122;
}
	public BibTeXFile called_rule_rootElement(){
BibTeXFile b0;
javaslang.collection.List<Record> op10;
List<java.lang.Object> itTmp11;b0 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createBibTeXFile();

	OUTModel_PartialOutput_.write(b0);

	/* 27:15-27:41: DBLP!Record.allInstances()*/
	op10 = this.globalContext.getAllInstancesOf_Record();

	itTmp11 = new ArrayList<Object>(op10.size());

	for ( java.lang.Object o: op10) {
boolean matched0 = false;if ( check_InCollection( o) )  {
itTmp11.add(o);
}
else if ( check_PhDThesis( o) )  {
itTmp11.add(o);
}
else if ( check_MasterThesis( o) )  {
itTmp11.add(o);
}
else if ( check_InProceedings( o) )  {
itTmp11.add(o);
}
else if ( check_Article( o) )  {
itTmp11.add(o);
}
else if ( check_Book( o) )  {
itTmp11.add(o);
}
else if ( check_Proceedings( o) )  {
itTmp11.add(o);
}
}
	this.parallelPendingTasks.add( new PendingTask_BibTeXFile_entries(b0,itTmp11,OUTModel_,null) );

	return b0;
}
	public boolean helper_dblp_DBLP_Proceedings_isEditorAuthor(dblp.DBLP.Proceedings self_){
javaslang.collection.List<Editor> get2;
javaslang.collection.List<dblp.DBLP.Author> op4;
java.lang.String get5;
java.lang.String get6;
boolean tmp7;
boolean r8;
boolean r9;/* 19:2-22:17: self.editors->exists(editor | DBLP!Author.allInstances()->exists(a2 | a2.name = editor.name))*/
	/* 19:2-19:14: self.editors*/
	get2 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Editor>(self_.getEditors()));

	r9 = false;

	for ( Editor editor1: get2) {
/* 20:3-22:16: DBLP!Author.allInstances()->exists(a2 | a2.name = editor.name)*/
	/* 20:3-20:29: DBLP!Author.allInstances()*/
	op4 = this.globalContext.getAllInstancesOf_Author();

	r8 = false;

	for ( dblp.DBLP.Author a23: op4) {
/* 21:4-21:11: a2.name*/
	get5 = a23.getName();

	/* 22:4-22:15: editor.name*/
	get6 = editor1.getName();

	tmp7 = get5. equals(get6);

	if ( tmp7) {
r8 = true;

	break;
}}
	if ( r8) {
r9 = true;

	break;
}}
	return r9;
}
	public void doEndpoint(){
called_rule_rootElement();
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
	public a2l.tests.dblp2bibtex.normal.DBLP2BibTeX setIN(IModel n){
INModel_ = n;

	return this;
}
	public a2l.tests.dblp2bibtex.normal.DBLP2BibTeX setOUT(IOutputModel n){
OUTModel_ = n;

	n.addPartial(OUTModel_PartialOutput_);

	return this;
}
	private void create_Article(dblp.DBLP.Article a){
a2l.tests.bibtex.BibTeX.Article b12;
java.lang.String get13;
java.lang.String get14;
int get15;
java.lang.String op16;
Journal get17;
java.lang.String get18;
Journal get19;
boolean op20;
boolean tmp21;
java.lang.String tmp22;
java.lang.String r23;
javaslang.collection.List<dblp.DBLP.Author> get25;
a2l.tests.bibtex.BibTeX.Author call26;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r27;
List<java.lang.Object> itTmp28;
List<a2l.tests.bibtex.BibTeX.Author> convList29;b12 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createArticle();

	this.trace.put(a,b12);

	OUTModel_PartialOutput_.write(b12);

	/* 34:9-34:14: a.key*/
	get13 = a.getKey();

	/* 35:12-35:19: a.title*/
	get14 = a.getTitle();

	/* 36:11-36:28: a.year.toString()*/
	/* 36:11-36:17: a.year*/
	get15 = a.getYear();

	op16 = get15 + "";

	/* 37:14-41:9: if not a.journal.oclIsUndefined() then
	a.journal.name
else
	'<unknown>'
endif*/
	/* 37:21-37:47: a.journal.oclIsUndefined()*/
	/* 37:21-37:30: a.journal*/
	get19 = a.getJournal();

	op20 = get19== null;

	tmp21 = ! op20;

	r23 = "";

	if ( tmp21) {
/* 38:5-38:19: a.journal.name*/
	/* 38:5-38:14: a.journal*/
	get17 = a.getJournal();

	get18 = get17.getName();

	r23 = get18;
} else { tmp22 = "<unknown>";

r23 = tmp22;
}
	/* 42:14-42:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 42:14-42:23: a.authors*/
	get25 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r27 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author24: get25) {
/* 42:42-42:69: thisModule.toAuthor(author)*/
	call26 = lazy_rule_toAuthor(author24);

	r27 = r27.append(call26);
}
	b12.setId(get13);;

	b12.setTitle(get14);;

	b12.setYear(op16);;

	b12.setJournal(r23);;

	itTmp28 = new ArrayList<Object>(r27.size());

	convList29 = r27.toJavaList();

	b12.getAuthors().addAll(convList29);

	numMatchedRuleExecutions_++;
}
	private void create_InProceedings(dblp.DBLP.InProceedings a){
a2l.tests.bibtex.BibTeX.InProceedings b30;
java.lang.String get31;
java.lang.String get32;
int get33;
java.lang.String op34;
javaslang.collection.List<dblp.DBLP.Author> get36;
a2l.tests.bibtex.BibTeX.Author call37;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r38;
java.lang.String get39;
List<java.lang.Object> itTmp40;
List<a2l.tests.bibtex.BibTeX.Author> convList41;b30 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInProceedings();

	this.trace.put(a,b30);

	OUTModel_PartialOutput_.write(b30);

	/* 49:9-49:14: a.key*/
	get31 = a.getKey();

	/* 50:12-50:19: a.title*/
	get32 = a.getTitle();

	/* 51:11-51:28: a.year.toString()*/
	/* 51:11-51:17: a.year*/
	get33 = a.getYear();

	op34 = get33 + "";

	/* 52:14-52:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 52:14-52:23: a.authors*/
	get36 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r38 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author35: get36) {
/* 52:42-52:69: thisModule.toAuthor(author)*/
	call37 = lazy_rule_toAuthor(author35);

	r38 = r38.append(call37);
}
	/* 53:16-53:26: a.bootitle*/
	get39 = a.getBootitle();

	b30.setId(get31);;

	b30.setTitle(get32);;

	b30.setYear(op34);;

	itTmp40 = new ArrayList<Object>(r38.size());

	convList41 = r38.toJavaList();

	b30.getAuthors().addAll(convList41);

	b30.setBooktitle(get39);;

	numMatchedRuleExecutions_++;
}
	private void create_MasterThesis(MastersThesis a){
MasterThesis b42;
java.lang.String get43;
java.lang.String get44;
int get45;
java.lang.String op46;
javaslang.collection.List<dblp.DBLP.Author> get48;
a2l.tests.bibtex.BibTeX.Author call49;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r50;
School get51;
java.lang.String get52;
School get53;
boolean op54;
boolean tmp55;
java.lang.String tmp56;
java.lang.String r57;
List<java.lang.Object> itTmp58;
List<a2l.tests.bibtex.BibTeX.Author> convList59;b42 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createMasterThesis();

	this.trace.put(a,b42);

	OUTModel_PartialOutput_.write(b42);

	/* 60:9-60:14: a.key*/
	get43 = a.getKey();

	/* 61:12-61:19: a.title*/
	get44 = a.getTitle();

	/* 62:11-62:28: a.year.toString()*/
	/* 62:11-62:17: a.year*/
	get45 = a.getYear();

	op46 = get45 + "";

	/* 63:14-63:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 63:14-63:23: a.authors*/
	get48 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r50 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author47: get48) {
/* 63:42-63:69: thisModule.toAuthor(author)*/
	call49 = lazy_rule_toAuthor(author47);

	r50 = r50.append(call49);
}
	/* 64:13-68:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 64:20-64:45: a.school.oclIsUndefined()*/
	/* 64:20-64:28: a.school*/
	get53 = a.getSchool();

	op54 = get53== null;

	tmp55 = ! op54;

	r57 = "";

	if ( tmp55) {
/* 65:5-65:18: a.school.name*/
	/* 65:5-65:13: a.school*/
	get51 = a.getSchool();

	get52 = get51.getName();

	r57 = get52;
} else { tmp56 = "<unknown>";

r57 = tmp56;
}
	b42.setId(get43);;

	b42.setTitle(get44);;

	b42.setYear(op46);;

	itTmp58 = new ArrayList<Object>(r50.size());

	convList59 = r50.toJavaList();

	b42.getAuthors().addAll(convList59);

	b42.setSchool(r57);;

	numMatchedRuleExecutions_++;
}
	private void create_InCollection(dblp.DBLP.InCollection a){
a2l.tests.bibtex.BibTeX.InCollection b60;
java.lang.String get61;
java.lang.String get62;
int get63;
java.lang.String op64;
javaslang.collection.List<dblp.DBLP.Author> get66;
a2l.tests.bibtex.BibTeX.Author call67;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r68;
java.lang.String get69;
Publisher get70;
java.lang.String get71;
Publisher get72;
boolean op73;
boolean tmp74;
java.lang.String tmp75;
java.lang.String r76;
List<java.lang.Object> itTmp77;
List<a2l.tests.bibtex.BibTeX.Author> convList78;b60 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInCollection();

	this.trace.put(a,b60);

	OUTModel_PartialOutput_.write(b60);

	/* 76:9-76:14: a.key*/
	get61 = a.getKey();

	/* 77:12-77:19: a.title*/
	get62 = a.getTitle();

	/* 78:11-78:28: a.year.toString()*/
	/* 78:11-78:17: a.year*/
	get63 = a.getYear();

	op64 = get63 + "";

	/* 79:14-79:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 79:14-79:23: a.authors*/
	get66 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r68 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author65: get66) {
/* 79:42-79:69: thisModule.toAuthor(author)*/
	call67 = lazy_rule_toAuthor(author65);

	r68 = r68.append(call67);
}
	/* 80:16-80:27: a.bookTitle*/
	get69 = a.getBookTitle();

	/* 81:16-85:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 81:23-81:51: a.publisher.oclIsUndefined()*/
	/* 81:23-81:34: a.publisher*/
	get72 = a.getPublisher();

	op73 = get72== null;

	tmp74 = ! op73;

	r76 = "";

	if ( tmp74) {
/* 82:5-82:21: a.publisher.name*/
	/* 82:5-82:16: a.publisher*/
	get70 = a.getPublisher();

	get71 = get70.getName();

	r76 = get71;
} else { tmp75 = "<unknown>";

r76 = tmp75;
}
	b60.setId(get61);;

	b60.setTitle(get62);;

	b60.setYear(op64);;

	itTmp77 = new ArrayList<Object>(r68.size());

	convList78 = r68.toJavaList();

	b60.getAuthors().addAll(convList78);

	b60.setBooktitle(get69);;

	b60.setPublisher(r76);;

	numMatchedRuleExecutions_++;
}
	private void create_Book(dblp.DBLP.Book a){
a2l.tests.bibtex.BibTeX.Book b79;
java.lang.String get80;
java.lang.String get81;
int get82;
java.lang.String op83;
javaslang.collection.List<dblp.DBLP.Author> get85;
a2l.tests.bibtex.BibTeX.Author call86;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r87;
Publisher get88;
java.lang.String get89;
Publisher get90;
boolean op91;
boolean tmp92;
java.lang.String tmp93;
java.lang.String r94;
List<java.lang.Object> itTmp95;
List<a2l.tests.bibtex.BibTeX.Author> convList96;b79 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createBook();

	this.trace.put(a,b79);

	OUTModel_PartialOutput_.write(b79);

	/* 92:9-92:14: a.key*/
	get80 = a.getKey();

	/* 93:12-93:19: a.title*/
	get81 = a.getTitle();

	/* 94:11-94:28: a.year.toString()*/
	/* 94:11-94:17: a.year*/
	get82 = a.getYear();

	op83 = get82 + "";

	/* 95:14-95:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 95:14-95:23: a.authors*/
	get85 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r87 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author84: get85) {
/* 95:42-95:69: thisModule.toAuthor(author)*/
	call86 = lazy_rule_toAuthor(author84);

	r87 = r87.append(call86);
}
	/* 96:16-100:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 96:23-96:51: a.publisher.oclIsUndefined()*/
	/* 96:23-96:34: a.publisher*/
	get90 = a.getPublisher();

	op91 = get90== null;

	tmp92 = ! op91;

	r94 = "";

	if ( tmp92) {
/* 97:5-97:21: a.publisher.name*/
	/* 97:5-97:16: a.publisher*/
	get88 = a.getPublisher();

	get89 = get88.getName();

	r94 = get89;
} else { tmp93 = "<unknown>";

r94 = tmp93;
}
	b79.setId(get80);;

	b79.setTitle(get81);;

	b79.setYear(op83);;

	itTmp95 = new ArrayList<Object>(r87.size());

	convList96 = r87.toJavaList();

	b79.getAuthors().addAll(convList96);

	b79.setPublisher(r94);;

	numMatchedRuleExecutions_++;
}
	private void create_PhDThesis(dblp.DBLP.PhDThesis a){
a2l.tests.bibtex.BibTeX.PhDThesis b97;
java.lang.String get98;
java.lang.String get99;
int get100;
java.lang.String op101;
javaslang.collection.List<dblp.DBLP.Author> get103;
a2l.tests.bibtex.BibTeX.Author call104;
javaslang.collection.List<a2l.tests.bibtex.BibTeX.Author> r105;
School get106;
java.lang.String get107;
School get108;
boolean op109;
boolean tmp110;
java.lang.String tmp111;
java.lang.String r112;
List<java.lang.Object> itTmp113;
List<a2l.tests.bibtex.BibTeX.Author> convList114;b97 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createPhDThesis();

	this.trace.put(a,b97);

	OUTModel_PartialOutput_.write(b97);

	/* 107:9-107:14: a.key*/
	get98 = a.getKey();

	/* 108:12-108:19: a.title*/
	get99 = a.getTitle();

	/* 109:11-109:28: a.year.toString()*/
	/* 109:11-109:17: a.year*/
	get100 = a.getYear();

	op101 = get100 + "";

	/* 110:14-110:70: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 110:14-110:23: a.authors*/
	get103 = javaslang.collection.List.ofAll(new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors()));

	r105 = javaslang.collection.List.empty();

	for ( dblp.DBLP.Author author102: get103) {
/* 110:42-110:69: thisModule.toAuthor(author)*/
	call104 = lazy_rule_toAuthor(author102);

	r105 = r105.append(call104);
}
	/* 111:13-115:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 111:20-111:45: a.school.oclIsUndefined()*/
	/* 111:20-111:28: a.school*/
	get108 = a.getSchool();

	op109 = get108== null;

	tmp110 = ! op109;

	r112 = "";

	if ( tmp110) {
/* 112:5-112:18: a.school.name*/
	/* 112:5-112:13: a.school*/
	get106 = a.getSchool();

	get107 = get106.getName();

	r112 = get107;
} else { tmp111 = "<unknown>";

r112 = tmp111;
}
	b97.setId(get98);;

	b97.setTitle(get99);;

	b97.setYear(op101);;

	itTmp113 = new ArrayList<Object>(r105.size());

	convList114 = r105.toJavaList();

	b97.getAuthors().addAll(convList114);

	b97.setSchool(r112);;

	numMatchedRuleExecutions_++;
}
	private void create_Proceedings(dblp.DBLP.Proceedings a){
a2l.tests.bibtex.BibTeX.Proceedings b115;
java.lang.String get116;
java.lang.String get117;
int get118;
java.lang.String op119;b115 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createProceedings();

	this.trace.put(a,b115);

	OUTModel_PartialOutput_.write(b115);

	/* 122:9-122:14: a.key*/
	get116 = a.getKey();

	/* 123:12-123:19: a.title*/
	get117 = a.getTitle();

	/* 124:11-124:28: a.year.toString()*/
	/* 124:11-124:17: a.year*/
	get118 = a.getYear();

	op119 = get118 + "";

	b115.setId(get116);;

	b115.setTitle(get117);;

	b115.setYear(op119);;

	numMatchedRuleExecutions_++;
}
	public void transform(Collection<java.lang.Object> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( java.lang.Object e: objs) {
this.transform(e);}}
	public void transform(java.lang.Object e) throws BlackboardException{
boolean matched1 = false;if ( check_Article( e) )  {
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