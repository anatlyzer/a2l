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
dblp.DBLP.Proceedings tmp110;
boolean call111;if ( a instanceof dblp.DBLP.Proceedings) {
tmp110 = (dblp.DBLP.Proceedings)a;

	/* 120:30-120:48: a.isEditorAuthor()*/
	if ( tmp110 instanceof dblp.DBLP.Proceedings) {
call111 = helper_dblp_DBLP_Proceedings_isEditorAuthor((dblp.DBLP.Proceedings)tmp110);
} else { throw new IllegalStateException();
}
	return call111 == true;
}
	return false;
}
	public a2l.tests.bibtex.BibTeX.Author lazy_rule_toAuthor(dblp.DBLP.Author a){
a2l.tests.bibtex.BibTeX.Author a2112;
java.lang.String get113;a2112 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createAuthor();

	OUTModel_PartialOutput_.write(a2112);

	/* 131:13-131:19: a.name*/
	get113 = a.getName();

	a2112.setAuthor(get113);;

	return a2112;
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
boolean matched0 = false;if ( check_Book( o) )  {
itTmp7.add(o);
}
else if ( check_MasterThesis( o) )  {
itTmp7.add(o);
}
else if ( check_InCollection( o) )  {
itTmp7.add(o);
}
else if ( check_InProceedings( o) )  {
itTmp7.add(o);
}
else if ( check_Article( o) )  {
itTmp7.add(o);
}
else if ( check_PhDThesis( o) )  {
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

	if ( obj instanceof a2l.runtime.ResolveTempObject ) return true;;

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
List<java.lang.Object> itTmp24;b8 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createArticle();

	this.trace.put(a,b8);

	OUTModel_PartialOutput_.write(b8);

	/* 34:9-34:14: a.key*/
	get9 = a.getKey();

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

	b8.getAuthors().addAll(r23);

	numMatchedRuleExecutions_++;
}
	private void create_InProceedings(dblp.DBLP.InProceedings a){
a2l.tests.bibtex.BibTeX.InProceedings b25;
java.lang.String get26;
java.lang.String get27;
int get28;
java.lang.String op29;
List<dblp.DBLP.Author> get31;
a2l.tests.bibtex.BibTeX.Author call32;
List<a2l.tests.bibtex.BibTeX.Author> r33;
java.lang.String get34;
List<java.lang.Object> itTmp35;b25 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInProceedings();

	this.trace.put(a,b25);

	OUTModel_PartialOutput_.write(b25);

	/* 49:9-49:14: a.key*/
	get26 = a.getKey();

	/* 50:12-50:19: a.title*/
	get27 = a.getTitle();

	/* 51:11-51:28: a.year.toString()*/
	/* 51:11-51:17: a.year*/
	get28 = a.getYear();

	op29 = get28 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 52:14-52:23: a.authors*/
	get31 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r33 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author30: get31) {
/* 52:42-52:69: thisModule.toAuthor(author)*/
	call32 = lazy_rule_toAuthor(author30);

	r33.add(call32);
}
	/* 53:16-53:26: a.bootitle*/
	get34 = a.getBootitle();

	b25.setId(get26);;

	b25.setTitle(get27);;

	b25.setYear(op29);;

	itTmp35 = new ArrayList<Object>(r33.size());

	b25.getAuthors().addAll(r33);

	b25.setBooktitle(get34);;

	numMatchedRuleExecutions_++;
}
	private void create_MasterThesis(MastersThesis a){
MasterThesis b36;
java.lang.String get37;
java.lang.String get38;
int get39;
java.lang.String op40;
List<dblp.DBLP.Author> get42;
a2l.tests.bibtex.BibTeX.Author call43;
List<a2l.tests.bibtex.BibTeX.Author> r44;
School get45;
java.lang.String get46;
School get47;
boolean op48;
boolean tmp49;
java.lang.String tmp50;
java.lang.String r51;
List<java.lang.Object> itTmp52;b36 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createMasterThesis();

	this.trace.put(a,b36);

	OUTModel_PartialOutput_.write(b36);

	/* 60:9-60:14: a.key*/
	get37 = a.getKey();

	/* 61:12-61:19: a.title*/
	get38 = a.getTitle();

	/* 62:11-62:28: a.year.toString()*/
	/* 62:11-62:17: a.year*/
	get39 = a.getYear();

	op40 = get39 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 63:14-63:23: a.authors*/
	get42 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r44 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author41: get42) {
/* 63:42-63:69: thisModule.toAuthor(author)*/
	call43 = lazy_rule_toAuthor(author41);

	r44.add(call43);
}
	/* 64:13-68:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 64:20-64:45: a.school.oclIsUndefined()*/
	/* 64:20-64:28: a.school*/
	get47 = a.getSchool();

	op48 = get47== null;

	tmp49 = ! op48;

	r51 = "";

	if ( tmp49) {
/* 65:5-65:18: a.school.name*/
	/* 65:5-65:13: a.school*/
	get45 = a.getSchool();

	get46 = get45.getName();

	r51 = get46;
} else { tmp50 = "<unknown>";

r51 = tmp50;
}
	b36.setId(get37);;

	b36.setTitle(get38);;

	b36.setYear(op40);;

	itTmp52 = new ArrayList<Object>(r44.size());

	b36.getAuthors().addAll(r44);

	b36.setSchool(r51);;

	numMatchedRuleExecutions_++;
}
	private void create_InCollection(dblp.DBLP.InCollection a){
a2l.tests.bibtex.BibTeX.InCollection b53;
java.lang.String get54;
java.lang.String get55;
int get56;
java.lang.String op57;
List<dblp.DBLP.Author> get59;
a2l.tests.bibtex.BibTeX.Author call60;
List<a2l.tests.bibtex.BibTeX.Author> r61;
java.lang.String get62;
Publisher get63;
java.lang.String get64;
Publisher get65;
boolean op66;
boolean tmp67;
java.lang.String tmp68;
java.lang.String r69;
List<java.lang.Object> itTmp70;b53 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createInCollection();

	this.trace.put(a,b53);

	OUTModel_PartialOutput_.write(b53);

	/* 76:9-76:14: a.key*/
	get54 = a.getKey();

	/* 77:12-77:19: a.title*/
	get55 = a.getTitle();

	/* 78:11-78:28: a.year.toString()*/
	/* 78:11-78:17: a.year*/
	get56 = a.getYear();

	op57 = get56 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 79:14-79:23: a.authors*/
	get59 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r61 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author58: get59) {
/* 79:42-79:69: thisModule.toAuthor(author)*/
	call60 = lazy_rule_toAuthor(author58);

	r61.add(call60);
}
	/* 80:16-80:27: a.bookTitle*/
	get62 = a.getBookTitle();

	/* 81:16-85:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 81:23-81:51: a.publisher.oclIsUndefined()*/
	/* 81:23-81:34: a.publisher*/
	get65 = a.getPublisher();

	op66 = get65== null;

	tmp67 = ! op66;

	r69 = "";

	if ( tmp67) {
/* 82:5-82:21: a.publisher.name*/
	/* 82:5-82:16: a.publisher*/
	get63 = a.getPublisher();

	get64 = get63.getName();

	r69 = get64;
} else { tmp68 = "<unknown>";

r69 = tmp68;
}
	b53.setId(get54);;

	b53.setTitle(get55);;

	b53.setYear(op57);;

	itTmp70 = new ArrayList<Object>(r61.size());

	b53.getAuthors().addAll(r61);

	b53.setBooktitle(get62);;

	b53.setPublisher(r69);;

	numMatchedRuleExecutions_++;
}
	private void create_Book(dblp.DBLP.Book a){
a2l.tests.bibtex.BibTeX.Book b71;
java.lang.String get72;
java.lang.String get73;
int get74;
java.lang.String op75;
List<dblp.DBLP.Author> get77;
a2l.tests.bibtex.BibTeX.Author call78;
List<a2l.tests.bibtex.BibTeX.Author> r79;
Publisher get80;
java.lang.String get81;
Publisher get82;
boolean op83;
boolean tmp84;
java.lang.String tmp85;
java.lang.String r86;
List<java.lang.Object> itTmp87;b71 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createBook();

	this.trace.put(a,b71);

	OUTModel_PartialOutput_.write(b71);

	/* 92:9-92:14: a.key*/
	get72 = a.getKey();

	/* 93:12-93:19: a.title*/
	get73 = a.getTitle();

	/* 94:11-94:28: a.year.toString()*/
	/* 94:11-94:17: a.year*/
	get74 = a.getYear();

	op75 = get74 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 95:14-95:23: a.authors*/
	get77 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r79 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author76: get77) {
/* 95:42-95:69: thisModule.toAuthor(author)*/
	call78 = lazy_rule_toAuthor(author76);

	r79.add(call78);
}
	/* 96:16-100:9: if not a.publisher.oclIsUndefined() then
	a.publisher.name
else
	'<unknown>'
endif*/
	/* 96:23-96:51: a.publisher.oclIsUndefined()*/
	/* 96:23-96:34: a.publisher*/
	get82 = a.getPublisher();

	op83 = get82== null;

	tmp84 = ! op83;

	r86 = "";

	if ( tmp84) {
/* 97:5-97:21: a.publisher.name*/
	/* 97:5-97:16: a.publisher*/
	get80 = a.getPublisher();

	get81 = get80.getName();

	r86 = get81;
} else { tmp85 = "<unknown>";

r86 = tmp85;
}
	b71.setId(get72);;

	b71.setTitle(get73);;

	b71.setYear(op75);;

	itTmp87 = new ArrayList<Object>(r79.size());

	b71.getAuthors().addAll(r79);

	b71.setPublisher(r86);;

	numMatchedRuleExecutions_++;
}
	private void create_PhDThesis(dblp.DBLP.PhDThesis a){
a2l.tests.bibtex.BibTeX.PhDThesis b88;
java.lang.String get89;
java.lang.String get90;
int get91;
java.lang.String op92;
List<dblp.DBLP.Author> get94;
a2l.tests.bibtex.BibTeX.Author call95;
List<a2l.tests.bibtex.BibTeX.Author> r96;
School get97;
java.lang.String get98;
School get99;
boolean op100;
boolean tmp101;
java.lang.String tmp102;
java.lang.String r103;
List<java.lang.Object> itTmp104;b88 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createPhDThesis();

	this.trace.put(a,b88);

	OUTModel_PartialOutput_.write(b88);

	/* 107:9-107:14: a.key*/
	get89 = a.getKey();

	/* 108:12-108:19: a.title*/
	get90 = a.getTitle();

	/* 109:11-109:28: a.year.toString()*/
	/* 109:11-109:17: a.year*/
	get91 = a.getYear();

	op92 = get91 + "";

	/* null: a.authors->collect(author | thisModule.toAuthor(author))*/
	/* 110:14-110:23: a.authors*/
	get94 = new a2l.runtime.stdlib.FastIterableList<dblp.DBLP.Author>(a.getAuthors());

	r96 = new java.util.ArrayList();

	for ( dblp.DBLP.Author author93: get94) {
/* 110:42-110:69: thisModule.toAuthor(author)*/
	call95 = lazy_rule_toAuthor(author93);

	r96.add(call95);
}
	/* 111:13-115:9: if not a.school.oclIsUndefined() then
	a.school.name
else
	'<unknown>'
endif*/
	/* 111:20-111:45: a.school.oclIsUndefined()*/
	/* 111:20-111:28: a.school*/
	get99 = a.getSchool();

	op100 = get99== null;

	tmp101 = ! op100;

	r103 = "";

	if ( tmp101) {
/* 112:5-112:18: a.school.name*/
	/* 112:5-112:13: a.school*/
	get97 = a.getSchool();

	get98 = get97.getName();

	r103 = get98;
} else { tmp102 = "<unknown>";

r103 = tmp102;
}
	b88.setId(get89);;

	b88.setTitle(get90);;

	b88.setYear(op92);;

	itTmp104 = new ArrayList<Object>(r96.size());

	b88.getAuthors().addAll(r96);

	b88.setSchool(r103);;

	numMatchedRuleExecutions_++;
}
	private void create_Proceedings(dblp.DBLP.Proceedings a){
a2l.tests.bibtex.BibTeX.Proceedings b105;
java.lang.String get106;
java.lang.String get107;
int get108;
java.lang.String op109;b105 = a2l.tests.bibtex.BibTeX.BibTeXFactory.eINSTANCE.createProceedings();

	this.trace.put(a,b105);

	OUTModel_PartialOutput_.write(b105);

	/* 122:9-122:14: a.key*/
	get106 = a.getKey();

	/* 123:12-123:19: a.title*/
	get107 = a.getTitle();

	/* 124:11-124:28: a.year.toString()*/
	/* 124:11-124:17: a.year*/
	get108 = a.getYear();

	op109 = get108 + "";

	b105.setId(get106);;

	b105.setTitle(get107);;

	b105.setYear(op109);;

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