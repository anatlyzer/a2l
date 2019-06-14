package example.uml2er.uml2er_distinct2;

import blackboard.IdentifiableElement;
import blackboard.IArea;
import blackboard.BlackboardException;
import transfo.ITransformation;
import transfo.IMaster;
import transfo.TraceFunction;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import simpleuml.IClass;
import simpleuml.IProperty;
import simpleuml.IPackage;
import er.ERModel;
import er.EntityType;
import er.IAttribute;
import er.IWeakReference;
import er.IStrongReference;
import er.Attribute;
import er.WeakReference;
import er.StrongReference;

public class UML2ERDistinct2 implements ITransformation{
IArea srcArea, trgArea, cachingArea;public UML2ERDistinct2(IArea srcArea, IArea trgArea, IArea cachingArea) {
this.srcArea = srcArea; this.trgArea = trgArea; this.cachingArea = cachingArea; }protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }
protected IdentifiableElement read(IArea area, String id) throws BlackboardException { return id == null ? null : area.read(id); }
protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { 	return javaslang.collection.List.ofAll(srcArea.read(srcArea.size() + 1)).  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));}private javaslang.collection.List<Object> flatten(Iterable<?> l) {  	javaslang.collection.List<Object> r = javaslang.collection.List.empty(); 	for (Object object : l) { 		if ( object instanceof Iterable ) { 			r = r.appendAll(flatten((Iterable<Object>) object)); 		} else { 			r = r.append(object); 		} 	} 	return r; }public boolean check_Package(IdentifiableElement s) throws BlackboardException{
return s instanceof IPackage;
}
	public boolean check_Class(IdentifiableElement s) throws BlackboardException{
return s instanceof IClass;
}
	public IAttribute lazy_rule_Attributes(IProperty s) throws BlackboardException{
Attribute t64;
java.lang.String get65;
java.lang.String get66;t64 = new Attribute();

	t64.setTrgId("ER");

	t64.setId(TraceFunction.createUniqueId("Attributes"));

	/* 56:12-56:18: s.name*/
	get65 = s.getName();

	/* 57:12-57:27: s.primitiveType*/
	get66 = s.getPrimitiveType();

	t64.setName(get65);

	t64.setType(get66);

	trgArea.write(t64);

	return t64;
}
	public IWeakReference lazy_rule_WeakReferences(IProperty s) throws BlackboardException{
WeakReference t67;
java.lang.String get68;
IClass get69;
java.lang.String id70;t67 = new WeakReference();

	t67.setTrgId("ER");

	t67.setId(TraceFunction.createUniqueId("WeakReferences"));

	/* 66:12-66:18: s.name*/
	get68 = s.getName();

	/* 67:12-67:25: s.complexType*/
	id70 = s.getComplexType();

	get69 = (IClass)read(srcArea, id70);

	t67.setName(get68);

	boolean matched0 = false;if ( check_Class( get69) )  {
t67.setType(TraceFunction.resolve(get69.getId(), 0, "Class") ) ;
}

	trgArea.write(t67);

	return t67;
}
	public IStrongReference lazy_rule_StrongReferences(IProperty s) throws BlackboardException{
StrongReference t71;
java.lang.String get72;
IClass get73;
java.lang.String id74;t71 = new StrongReference();

	t71.setTrgId("ER");

	t71.setId(TraceFunction.createUniqueId("StrongReferences"));

	/* 76:12-76:18: s.name*/
	get72 = s.getName();

	/* 77:12-77:25: s.complexType*/
	id74 = s.getComplexType();

	get73 = (IClass)read(srcArea, id74);

	t71.setName(get72);

	boolean matched1 = false;if ( check_Class( get73) )  {
t71.setType(TraceFunction.resolve(get73.getId(), 0, "Class") ) ;
}

	trgArea.write(t71);

	return t71;
}
	public javaslang.collection.List<IClass> helper_IClass_allClasses(IClass self_) throws BlackboardException{
javaslang.collection.List<IClass> get0;
java.lang.String[] id1;
javaslang.collection.List tmp2;
javaslang.collection.List<IClass> acc45;
javaslang.collection.Set<IClass> tmp6;
javaslang.collection.List<IClass> op7;
javaslang.collection.List<IClass> call8;
javaslang.collection.List<IClass> op9;/* 18:2-20:3: self.superClasses->iterate(e;acc:Sequence(SimpleUML!Class) = Sequence { } | acc->union(Set {e })->union(e.allClasses()))*/
	/* 18:2-18:19: self.superClasses*/
	id1 = self_.getSuperClasses();

	get0 = javaslang.collection.List.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<IClass>(srcArea.readAll( toList(id1) )));

	tmp2 = javaslang.collection.List.empty();

	acc45 = tmp2;

	for ( IClass e3: get0) {
/* 19:3-19:44: acc->union(Set {e })->union(e.allClasses())*/
	/* 19:3-19:21: acc->union(Set {e })*/
	/* 19:14-19:20: Set {e }*/
	tmp6 = javaslang.collection.HashSet.of(e3);

	op7 = acc45.appendAll(tmp6);

	/* 19:29-19:43: e.allClasses()*/
	if ( e3 instanceof IClass) {
call8 = helper_IClass_allClasses((IClass)e3);
} else { throw new IllegalStateException();
}
	op9 = op7.appendAll(call8);

	acc45 = op9;
}
	return acc45;
}
	public javaslang.collection.List<IProperty> helper_IClass_getAllProperties(IClass self_) throws BlackboardException{
javaslang.collection.List<IClass> call11;
javaslang.collection.List<IClass> op12;
javaslang.collection.List<IClass> op13;
javaslang.collection.List<IProperty> get14;
java.lang.String[] id15;
javaslang.collection.List<javaslang.collection.List<IProperty>> r16;
javaslang.collection.List<IProperty> op17;/* 23:2-23:85: self.allClasses().including(self).flatten()->collect(e | e.ownedProperty).flatten()*/
	/* 23:2-23:75: self.allClasses().including(self).flatten()->collect(e | e.ownedProperty)*/
	/* 23:2-23:45: self.allClasses().including(self).flatten()*/
	/* 23:2-23:35: self.allClasses().including(self)*/
	/* 23:2-23:19: self.allClasses()*/
	if ( self_ instanceof IClass) {
call11 = helper_IClass_allClasses((IClass)self_);
} else { throw new IllegalStateException();
}
	op12 = call11.append(self_);

	op13 = flatten(op12).map(x_ -> (IClass)x_);

	r16 = javaslang.collection.List.empty();

	for ( IClass e10: op13) {
/* 23:59-23:74: e.ownedProperty*/
	id15 = e10.getOwnedProperty();

	get14 = javaslang.collection.List.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<IProperty>(srcArea.readAll( toList(id15) )));

	r16 = r16.append(get14);
}
	op17 = flatten(r16).map(x_ -> (IProperty)x_);

	return op17;
}
	public javaslang.collection.List<IProperty> helper_IClass_getAllAttributes(IClass self_) throws BlackboardException{
javaslang.collection.List<IProperty> call19;
java.lang.String get20;
boolean op21;
boolean tmp22;
javaslang.collection.List<IProperty> r23;/* 27:2-27:78: self.getAllProperties()->select(e | not e.primitiveType.oclIsUndefined())*/
	/* 27:2-27:25: self.getAllProperties()*/
	if ( self_ instanceof IClass) {
call19 = helper_IClass_getAllProperties((IClass)self_);
} else { throw new IllegalStateException();
}
	r23 = javaslang.collection.List.empty();

	for ( IProperty e18: call19) {
/* 27:45-27:77: e.primitiveType.oclIsUndefined()*/
	/* 27:45-27:60: e.primitiveType*/
	get20 = e18.getPrimitiveType();

	op21 = get20== null;

	tmp22 = ! op21;

	if ( tmp22 == true) {
r23 = r23.append(e18);
}}
	return r23;
}
	public javaslang.collection.List<IProperty> helper_IClass_getAllNonContainmentReferences(IClass self_) throws BlackboardException{
javaslang.collection.List<IProperty> call25;
IClass get26;
java.lang.String id27;
boolean op28;
boolean tmp29;
boolean get30;
boolean tmp31;
boolean tmp32;
javaslang.collection.List<IProperty> r33;/* 31:2-31:100: self.getAllProperties()->select(e | not e.complexType.oclIsUndefined() and not e.isContainment)*/
	/* 31:2-31:25: self.getAllProperties()*/
	if ( self_ instanceof IClass) {
call25 = helper_IClass_getAllProperties((IClass)self_);
} else { throw new IllegalStateException();
}
	r33 = javaslang.collection.List.empty();

	for ( IProperty e24: call25) {
/* 31:45-31:75: e.complexType.oclIsUndefined()*/
	/* 31:45-31:58: e.complexType*/
	id27 = e24.getComplexType();

	get26 = (IClass)read(srcArea, id27);

	op28 = get26== null;

	tmp29 = ! op28;

	/* 31:84-31:99: e.isContainment*/
	get30 = e24.getIsContainment();

	tmp31 = ! get30;

	tmp32 = tmp29 && tmp31;

	if ( tmp32 == true) {
r33 = r33.append(e24);
}}
	return r33;
}
	public javaslang.collection.List<IProperty> helper_IClass_getAllContainmentReferences(IClass self_) throws BlackboardException{
javaslang.collection.List<IProperty> call35;
IClass get36;
java.lang.String id37;
boolean op38;
boolean tmp39;
boolean get40;
boolean tmp41;
javaslang.collection.List<IProperty> r42;/* 35:2-35:96: self.getAllProperties()->select(e | not e.complexType.oclIsUndefined() and e.isContainment)*/
	/* 35:2-35:25: self.getAllProperties()*/
	if ( self_ instanceof IClass) {
call35 = helper_IClass_getAllProperties((IClass)self_);
} else { throw new IllegalStateException();
}
	r42 = javaslang.collection.List.empty();

	for ( IProperty e34: call35) {
/* 35:45-35:75: e.complexType.oclIsUndefined()*/
	/* 35:45-35:58: e.complexType*/
	id37 = e34.getComplexType();

	get36 = (IClass)read(srcArea, id37);

	op38 = get36== null;

	tmp39 = ! op38;

	/* 35:80-35:95: e.isContainment*/
	get40 = e34.getIsContainment();

	tmp41 = tmp39 && get40;

	if ( tmp41 == true) {
r42 = r42.append(e34);
}}
	return r42;
}
	public boolean isTargetElement(IdentifiableElement obj){
return "ER".equals(obj.getTrgId());
}
	public void create_Package(IPackage s) throws BlackboardException{
ERModel t43;
javaslang.collection.List<IClass> get44;
java.lang.String[] id45;
List<java.lang.String> itTmp46;t43 = new ERModel();

	t43.setTrgId("ER");

	t43.setId(TraceFunction.create(s.getId(), 0,"Package"));

	/* 13:16-13:31: s.ownedElements*/
	id45 = s.getOwnedElements();

	get44 = javaslang.collection.List.ofAll(new uk.ac.ebi.utils.collections.TypeCastCollection<IClass>(srcArea.readAll( toList(id45) )));

	itTmp46 = new ArrayList<String>();

	for ( IdentifiableElement o: get44) {
boolean matched2 = false;if ( check_Class( o) )  {
itTmp46.add(TraceFunction.resolve(o.getId(), 0, "Class") );
}
}
	t43.setEntities(itTmp46.toArray(new String[itTmp46.size()]));

	trgArea.write(t43);
}
	public void create_Class(IClass s) throws BlackboardException{
EntityType t47;
java.lang.String get48;
javaslang.collection.List<IProperty> call50;
IAttribute call51;
javaslang.collection.List<IAttribute> r52;
javaslang.collection.List<IProperty> call54;
IWeakReference call55;
javaslang.collection.List<IWeakReference> r56;
javaslang.collection.List<IProperty> call58;
IStrongReference call59;
javaslang.collection.List<IStrongReference> r60;
javaslang.collection.List<java.lang.Object> tmp61;
List<java.lang.String> itTmp62;
javaslang.collection.List<IdentifiableElement> filterBinding63;t47 = new EntityType();

	t47.setTrgId("ER");

	t47.setId(TraceFunction.create(s.getId(), 0,"Class"));

	/* 43:12-43:18: s.name*/
	get48 = s.getName();

	/* 44:16-47:5: Sequence {s.getAllAttributes()->collect(e | thisModule.Attributes(e)), s.getAllNonContainmentReferences()->collect(e | thisModule.WeakReferences(e)), s.getAllContainmentReferences()->collect(e | thisModule.StrongReferences(e)) }*/
	/* 44:26-44:86: s.getAllAttributes()->collect(e | thisModule.Attributes(e))*/
	/* 44:26-44:46: s.getAllAttributes()*/
	if ( s instanceof IClass) {
call50 = helper_IClass_getAllAttributes((IClass)s);
} else { throw new IllegalStateException();
}
	r52 = javaslang.collection.List.empty();

	for ( IProperty e49: call50) {
/* 44:61-44:85: thisModule.Attributes(e)*/
	call51 = lazy_rule_Attributes(e49);

	r52 = r52.append(call51);
}
	/* 45:10-45:88: s.getAllNonContainmentReferences()->collect(e | thisModule.WeakReferences(e))*/
	/* 45:10-45:44: s.getAllNonContainmentReferences()*/
	if ( s instanceof IClass) {
call54 = helper_IClass_getAllNonContainmentReferences((IClass)s);
} else { throw new IllegalStateException();
}
	r56 = javaslang.collection.List.empty();

	for ( IProperty e53: call54) {
/* 45:59-45:87: thisModule.WeakReferences(e)*/
	call55 = lazy_rule_WeakReferences(e53);

	r56 = r56.append(call55);
}
	/* 46:10-46:87: s.getAllContainmentReferences()->collect(e | thisModule.StrongReferences(e))*/
	/* 46:10-46:41: s.getAllContainmentReferences()*/
	if ( s instanceof IClass) {
call58 = helper_IClass_getAllContainmentReferences((IClass)s);
} else { throw new IllegalStateException();
}
	r60 = javaslang.collection.List.empty();

	for ( IProperty e57: call58) {
/* 46:56-46:86: thisModule.StrongReferences(e)*/
	call59 = lazy_rule_StrongReferences(e57);

	r60 = r60.append(call59);
}
	tmp61 = javaslang.collection.List.of(r52,r56,r60);

	t47.setName(get48);

	itTmp62 = new ArrayList<String>();

	filterBinding63 = flatten(tmp61).filter(e_ -> e_ instanceof IdentifiableElement).map(e_ -> (IdentifiableElement) e_);

	for ( IdentifiableElement o: filterBinding63) {
boolean matched3 = false;if ( isTargetElement( o) )  {
itTmp62.add(o.getId());
}
}
	t47.setFeatures(itTmp62.toArray(new String[itTmp62.size()]));

	trgArea.write(t47);
}
	public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException{
for ( IdentifiableElement e: objs) {
boolean matched4 = false;if ( check_Package( e) )  {
create_Package((IPackage)e);
}
else if ( check_Class( e) )  {
create_Class((IClass)e);
}
}}}