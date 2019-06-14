package linda.atlcompiler;

import static linda.atlcompiler.CreationHelpers.addStm;
import static linda.atlcompiler.CreationHelpers.createAssignment;
import static linda.atlcompiler.CreationHelpers.createCommentedList;
import static linda.atlcompiler.CreationHelpers.createForeach;
import static linda.atlcompiler.CreationHelpers.createParameter;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.createTextExp;
import static linda.atlcompiler.CreationHelpers.quote;
import static linda.atlcompiler.CreationHelpers.refVar;
import static linda.atlcompiler.CreationHelpers.toStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.compiler.AstAnnotations;
import a2l.compiler.OptimisationHints;
import a2l.compiler.OptimisationHints.CachedValue;
import a2l.compiler.OptimisationHints.Hotspot;
import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.errors.atl_error.NavigationProblem;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.EnumType;
import anatlyzer.atl.types.FloatType;
import anatlyzer.atl.types.IntegerType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.PrimitiveType;
import anatlyzer.atl.types.ReflectiveClass;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.types.UnionType;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.ATL.ATLPackage;
import anatlyzer.atlext.ATL.ActionBlock;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.BindingStat;
import anatlyzer.atlext.ATL.CalledRule;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.ExpressionStat;
import anatlyzer.atlext.ATL.ForStat;
import anatlyzer.atlext.ATL.IfStat;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleResolutionInfo;
import anatlyzer.atlext.ATL.RuleVariableDeclaration;
import anatlyzer.atlext.ATL.Statement;
import anatlyzer.atlext.ATL.StaticHelper;
import anatlyzer.atlext.OCL.BooleanExp;
import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.EnumLiteralExp;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.IntegerExp;
import anatlyzer.atlext.OCL.IterateExp;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.JavaBody;
import anatlyzer.atlext.OCL.LetExp;
import anatlyzer.atlext.OCL.MapExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OCLPackage;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.OclUndefinedExp;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.OrderedSetExp;
import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.SequenceExp;
import anatlyzer.atlext.OCL.SetExp;
import anatlyzer.atlext.OCL.StringExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JForeach;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JLoop;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.atlcompiler.javagen.LMatchCase;
import lintra.atlcompiler.javagen.LMatchObject;

public abstract class LindaCompiler extends BaseCompiler {

	// private JMethod currentCreateMethod;
	
	protected JMethod isTargetElementCheckMethod;
	protected JMethod getDriverDynamically;
	protected Set<String> targetMetamodelNames = new HashSet<>();
	
	// Weird, set by subclasses...
	protected OptimisationHints hints = new OptimisationHints();
	private JClass globalContextClass;
	
	
	public LindaCompiler(IAnalyserResult result, DriverConfiguration driverConfiguration) {
		super(result, driverConfiguration);
		targetMetamodelNames = ATLUtils.getModelInfo(model).stream().
				filter(m -> m.isOutput()).
				map(m -> m.getMetamodelName()).
				collect(Collectors.toSet());
	}
	
	@Override
	public String getBaseType(OclType type) {
		if ( ! (type instanceof OclModelElement) ) {
			throw new IllegalStateException();
		}
		return driverConfiguration.get(((OclModelElement) type).getModel().getName()).getBaseType();
	}
	
	
	@Override
	public void beforeModule(Module self) {
		typ = new LindaTyping(jmodel, model, driverConfiguration);
		ocl = new LindaOclCompiler(env, typ, gen, hints);
		
		tclass = JavagenFactory.eINSTANCE.createJClass();
		
		initTyping(typ, tclass);

		tclass.setPkg(basePkg);
		tclass.setName(self.getName());
		tclass.getImplements().add(typ.createTypeRef("ITransformation"));
		tclass.getImplements().add(typ.createTypeRef("ITransformation2"));

		createGlobalContext(self);
		String globalContextClassQName = this.globalContextClass.getPkg() + "." + this.globalContextClass.getName();
		
		
		// imports
		addImport(tclass, "java.util", "List");
		addImport(tclass, "java.util", "ArrayList");		
		addImport(tclass, "java.util", "Collection");
		addImport(tclass, "java.util", "Map");
		
		this.jmodel.getClasses().add(tclass);		

		ArrayList<String> constructorParams = new ArrayList<>();
		constructorParams.add("a2l.runtime.InputExtent inputExtent");
		constructorParams.add(globalContextClassQName + " global");
		ArrayList<String> constructorAssignments = new ArrayList<>();
		constructorAssignments.add("this.inputExtent = inputExtent");
		constructorAssignments.add("this.globalContext = global");
		for (ModelInfo m : ATLUtils.getModelInfo(model)) {
			if ( m.isOutput() ) {
				String partialModelName = ((LindaTyping) typ).getPartialOutputAreaName(m.getModelName());
				constructorAssignments.add("this." + partialModelName + " = new PartialOutputModel()");
				constructorAssignments.add("this." + "trace" + " = global.createPartialTrace();");
			}
		}
		
		
//		ArrayList<String> constructorParams = new ArrayList<>();
//		ArrayList<String> constructorAssignments = new ArrayList<>();
//		for (ModelInfo m : ATLUtils.getModelInfo(model)) {
//			JAttribute attr = JavagenFactory.eINSTANCE.createJAttribute();
//			
//			String areaName = ((LindaTyping) typ).getAreaName(m.getModelName());
//			
//			attr.setName(areaName);
//			attr.setType(typ.createTypeRef("IArea"));
//
//			constructorParams.add("IArea " + attr.getName());
//			constructorAssignments.add("this." + attr.getName() + " = " + attr.getName());
//			
//			tclass.getAttributes().add(attr);
//		}
//
//		
		String params = constructorParams.stream().collect(Collectors.joining(","));
		String assign = constructorAssignments.stream().collect(Collectors.joining(";\n"));
//		
//		// Generate fields, and the constructor. 
//		// This is not the cleanest way, only takes into account 1 source, 1 target
		String fieldsText = "a2l.runtime.InputExtent inputExtent;" +
				globalContextClassQName + " globalContext;" +
				"java.util.Map<Object, Object> trace = new java.util.HashMap<Object, Object>();";

		
//		String fieldsConstructor = "IArea trgArea, cachingArea;";
//		fieldsConstructor += "public " + tclass.getName() + "(" + params + ", IArea cachingArea" + ") {" + "\n" +
//			assign + ";\n this.cachingArea = cachingArea; }";

		String constructorText = "public " + tclass.getName() + "(" + params + ") {" + "\n" + assign + "; }";

		String utilities = "protected List<String> toList(String[] strings) { return java.util.Arrays.asList(strings); }" + "\n";
		
		utilities += createAllInstancesMethods();
//		utilities += "protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { " +
//					 "	return javaslang.collection.List.ofAll(srcArea.read(srcArea.size() + 1))." +
//					 "  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));" +
//					 "}";

		utilities += 
				//  // TODO: Allocate objects in ArrayList? 
			" private javaslang.collection.List<Object> flatten(Iterable<?> l) { " +
			"	ArrayList<Object> r = new ArrayList<Object>();" + 
			"   addFlatten(r, l); " +
			"   return javaslang.collection.List.ofAll(r); " +
			" }" +
			" private void addFlatten(ArrayList<Object> r, Iterable<?> l) { " +
			"   for(Object x : l) { " +
			"     if ( x instanceof Iterable ) { " + 
			"	    addFlatten(r, (Iterable<?>) x); " +
			"     } else { " +
			"	    r.add(x); " + 
			"     }" + 
			"   }" +
			" } ";		

// More inneficient way
//			"private javaslang.collection.List<Object> flatten(Iterable<?> l) {  " + 
//			"	javaslang.collection.List<Object> r = javaslang.collection.List.empty(); " +
//			"	for (Object object : l) { " +
//			"		if ( object instanceof Iterable ) { " +
//			"			r = r.appendAll(flatten((Iterable<Object>) object)); " +
//			"		} else { " +
//			"			r = r.append(object); " +
//			"		} " +
//			"	} " +
//			"	return r; " +
//			"}" 
			
			
			utilities += 
			"private javaslang.collection.Set<Object> flattenSet(Iterable<?> l) {  " + 
			"	javaslang.collection.Set<Object> r = javaslang.collection.HashSet.empty(); " +
			"	for (Object object : l) { " +
			"		if ( object instanceof Iterable ) { " +
			"			r = r.addAll(flattenSet((Iterable<Object>) object)); " +
			"		} else { " +
			"			r = r.add(object); " +
			"		} " +
			"	} " +
			"	return r; " +
			"}";
			
		// Transformation result class
		String trafoResultClass = "public static class TransformationResult { ";
				
		trafoResultClass +=	"}";
		
		tclass.setExtra(fieldsText + constructorText + utilities + trafoResultClass);
		
		driverConfiguration.configureTransformationClass(ctx(), tclass);
		
		// Configure rules before anything else
		// Create check methods

		// TODO: This should go in the superclass, but the subclass initializes tclass... 
		self.getElements().stream().filter(e -> e instanceof MatchedRule).forEach(m -> createCheckMethod((MatchedRule) m));
		self.getElements().stream().filter(e -> e instanceof LazyRule).forEach(m -> configureLazyRule((LazyRule) m));
		self.getElements().stream().filter(e -> e instanceof CalledRule).forEach(m -> configureCalledRule((CalledRule) m));
		self.getElements().stream().filter(e -> e instanceof ContextHelper).forEach(m -> configureContextHelper((ContextHelper) m));
		self.getElements().stream().filter(e -> e instanceof StaticHelper).forEach(m -> configureStaticHelper((StaticHelper) m));
	
		createIsTargetElementCheckMethod();
		createGetDriverDynamically();
		
	}

	private void createGlobalContext(Module self) {
		this.globalContextClass = JavagenFactory.eINSTANCE.createJClass();
		this.jmodel.getClasses().add(globalContextClass);
		
		typ.createLibType("com.google.common.cache", "Cache");
		typ.createLibType("a2l.runtime", "DefaultGlobalContext");
		addImport(globalContextClass, "com.google.common.cache", "Cache");

		globalContextClass.setPkg(basePkg);
		globalContextClass.setName(self.getName() + "GlobalContext");
		globalContextClass.setExtends_(typ.createTypeRef("a2l.runtime.DefaultGlobalContext"));		
		
		List<String> initializations = new ArrayList<String>();
		List<String> methods = new ArrayList<String>();

		/**
		 * Generate one attribute like this:
		 * 
		 * 	public com.google.common.cache.Cache<Person, javaslang.collection.Set<Movie>> personMovies = com.google.common.cache.CacheBuilder.newBuilder()
		 *	//.maximumSize(10_000)			
		 *	.concurrencyLevel(12).<Person, javaslang.collection.Set<Movie>>build();
 		 *
		 */		
		for(Hotspot h : hints.getHotspots()) {
			if ( h instanceof CachedValue ) {
				CachedValue cv = ((CachedValue) h);
				
				boolean isMutable = AstAnnotations.isMutable(cv.getCachedExpression());

				JTypeRef keyType = typ.createTypeRef(cv.getKeyType());
				JTypeRef valueType = typ.createTypeRef(cv.getValueType(), isMutable);				
				
				String cacheName = cv.getCacheSiteName();
				JAttribute attr = JavagenFactory.eINSTANCE.createJAttribute();
				attr.setName(cacheName);
				attr.setType(typ.createParamNTypeRef(typ.getType("com.google.common.cache.Cache"), keyType, valueType ));
				globalContextClass.getAttributes().add(attr);

				// Beware that this only works when the typeRefs are fully contained in the javamodel with the correct typing
				String keyTypeStr   = JavaGenerator.textOf(keyType);
				String valueTypeStr = JavaGenerator.textOf(valueType);
				
				String init = attr.getName() + " = " + "com.google.common.cache.CacheBuilder.newBuilder()" +
						".concurrencyLevel(Runtime.getRuntime().availableProcessors()).<" + keyTypeStr + ", " + valueTypeStr + ">build();";
				
				initializations.add(init);
				
				// Create an access method
								
				String methodName = "get" + cv.getCacheSiteName(); 
				
				methods.add("public " + valueTypeStr + " " + methodName + "(" + keyTypeStr + " key, java.util.concurrent.Callable<" + valueTypeStr + "> closure) { "
						+ "try { return " + attr.getName() + ".get(key, closure); } catch (java.util.concurrent.ExecutionException e) { throw new IllegalStateException(); } }");
				
			}
		}
		
		String params = "";
		String assign = initializations.stream().collect(Collectors.joining("\n"));

		
		// Having a global cache is not the best idea in a concurrent world, but we keep it as a default thing
		
		String allInstancesCache = "private Cache<java.lang.Class<?>, javaslang.collection.List<?>> allInstancesCache; " + "\n" + 
				"	@SuppressWarnings(\"unchecked\")	public <T> javaslang.collection.List<T> getFromAllInstancesCache(java.lang.Class<T> key, java.util.concurrent.Callable<javaslang.collection.List<T>> closure) { " + 
				" try { " +
				"  return (javaslang.collection.List<T>) allInstancesCache.get(key, closure); " +
				" } catch (java.util.concurrent.ExecutionException e) { " +
				"   throw new IllegalStateException(); " +
				" } " +
				"}";
		
		String allInstancesInit = "allInstancesCache = com.google.common.cache.CacheBuilder.newBuilder().concurrencyLevel(12).build();";
		assign += "\n" + allInstancesInit;
				
		for (JTypeRef typeRef : getAllInstancesUsages()) {			
			String metaType = getQualifiedJavaMetaType(typeRef);
			allInstancesCache += "private javaslang.collection.List<" + metaType + "> allInstancesOf_" + typeRef.getType().getName() + " = javaslang.collection.List.empty();\n";
		}
		
		allInstancesCache += "public void addAllInstancesObject(Object obj) {";
		for (JTypeRef typeRef : getAllInstancesUsages()) {
			String metaType = getQualifiedJavaMetaType(typeRef);
			allInstancesCache += "if ( obj instanceof " + metaType + ") { \n";
			allInstancesCache += "   allInstancesOf_" + typeRef.getType().getName() + " = allInstancesOf_" + typeRef.getType().getName() + ".prepend( (" + metaType + ") obj);\n" ;
			allInstancesCache += "}";
		}
		allInstancesCache += "}\n";
		
		
		for (JTypeRef typeRef : getAllInstancesUsages()) {
			String metaType = getQualifiedJavaMetaType(typeRef);
			allInstancesCache += "public javaslang.collection.List<" + metaType + "> " + getAllInstancesMethodAccess(typeRef.getType()) + "() {\n";
			allInstancesCache += "  return allInstancesOf_" + typeRef.getType().getName() + ";\n";
			allInstancesCache += "}\n";
		}
		
		String constructorText = "public " + globalContextClass.getName() + "(" + params + ") {" + "\n" + assign + "; }";
		globalContextClass.setExtra(constructorText + 
				methods.stream().collect(Collectors.joining("\n")) + "\n" +
				allInstancesCache);
	}

	private String getQualifiedJavaMetaType(JTypeRef typeRef) {
		String metaType;
		JType jtype = typeRef.getType();
		if (jtype instanceof JMetaType ) {
			// This is probably always true
			
			// Doesn't work
			// tclass.getImports().add(typ.getType(((JMetaType) jtype).getQualifiedJavaName()));
			metaType = ((JMetaType) jtype).getQualifiedJavaName();
		} else {				
			metaType   = JavaGenerator.textOf(typeRef.getType());
		}
		return metaType;
	}
	
	public static String getAllInstancesMethodAccess(JType type) {
		return "getAllInstancesOf_" + type.getName();
	}

	private Set<JTypeRef> getAllInstancesUsages() {
		Set<JTypeRef> usages = new HashSet<JTypeRef>(); // only reference identity for JTypeRef :-(
		Set<EClass> used = new HashSet<EClass>();
		
		List<OperationCallExp> operations = this.model.allObjectsOf(OperationCallExp.class);
		for (OperationCallExp operationCallExp : operations) {
			if ( operationCallExp.getOperationName().equals("allInstances") ) {
				OclExpression source = operationCallExp.getSource();
				if ( source instanceof OclModelElement ) {
					OclModelElement me = (OclModelElement) source;
					EClass c = ((Metaclass) me.getInferredType()).getKlass();
					
					if ( used.contains(c))
						continue;
					
					usages.add(typ.createTypeRef(me.getInferredType()));
					used.add(c);
				}
			}
		}
		
		return usages;
	}
	
	private String createAllInstancesMethods() {		
//		String m = "protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { " +
//				 "	return javaslang.collection.List.ofAll(srcArea.read(srcArea.size() + 1))." +
//				 "  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));" +
//				 "}";
		
		List<ModelInfo> inputs = ATLUtils.getModelInfo(model).stream().filter(m -> m.isInput()).collect(Collectors.toList());		
		String instances = inputs.stream().map(m -> {
			String areaName = ((LindaTyping) typ).getAreaName(m.getModelName());
			return "javaslang.collection.List<T> " + m.getModelName() + " = " + 
					"javaslang.collection.List.ofAll(" + areaName + ".allInstances())." +
					"  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e));";
		}).collect(Collectors.joining("\n"));
		
		String result = "javaslang.collection.List<T> result = javaslang.collection.List.empty();\n";
		result += inputs.stream().map(m -> "result = result.appendAll(" + m.getModelName() + ");").collect(Collectors.joining("\n"));
		result += "return result;\n";
		
		String generalAllInstances = "protected <T> javaslang.collection.List<T> getAllInstances(java.lang.Class<T> klass) throws BlackboardException { " +
				"javaslang.collection.List<T> list_result = globalContext.getFromAllInstancesCache(klass, () -> {" + 
					instances + "\n" + result + "\n" +
				"});" +
				"return list_result;" + 
			"}";
		
		// Compute all specific allInstancesFrom methods
		String specificAllInstances = getAnalysisResult().getATLModel().allObjectsOf(OperationCallExp.class).stream().
			filter(o -> o.getOperationName().equals("allInstancesFrom") && (o.getSource() instanceof OclModelElement)).
			map(o -> ((StringExp) o.getArguments().get(0)).getStringSymbol()).
			distinct().
			map(this::createAllInstancesFrom).collect(Collectors.joining("\n"));
		
		return generalAllInstances + "\n" + specificAllInstances;
	}
	
	protected String createAllInstancesFrom(String modelName) {
		String postfix = "From" + modelName;

		String areaName = ((LindaTyping) typ).getAreaName(modelName);
		String instancesColl = "javaslang.collection.List<T> " + modelName + " = " + 
				"javaslang.collection.List.ofAll(" + areaName + ".allInstances())." +
				"  filter(e -> klass.isInstance(e)).map(e -> klass.cast(e))";

		
		return "protected <T> javaslang.collection.List<T> getAllInstances" + postfix + "(java.lang.Class<T> klass) throws BlackboardException { " +
				instancesColl + ";" + 
				"return " + modelName + ";" +
			"}";
		
	}
	

	@Override
	public void inModule(Module self) {
		
		JMethod transformMethod = JavagenFactory.eINSTANCE.createJMethod();
		transformMethod.setName("transform");
		transformMethod.getParameters().add( createParameter("objs", typ.createParamTypeRef("Collection", getTransformInputType())) );
		transformMethod.getParameters().add( createParameter("masterNextTransfo", typ.createTypeRef("IMaster")) );
		JParameter objs = transformMethod.getParameters().get(0);
		transformMethod.getThrows_().add(typ.createTypeRef("BlackboardException"));
		
		JForeach forObj = createForeach("e", objs, typ.createTypeRef(getTransformInputType()));
		
		JInvoke invoke = JavagenFactory.eINSTANCE.createJInvoke();
		invoke.setName("transform");
		invoke.setObj(CreationHelpers.refToThis(tclass));
		invoke.getArguments().add(CreationHelpers.refVar(forObj.getLoopVar()));
		
		forObj.getStatements().add(CreationHelpers.createExpresionStatement(invoke));
		
//		transformMethod.getStatements().add(assign);
		transformMethod.getStatements().add(forObj);
		
		tclass.getMethods().add(transformMethod);		

	
		// Transform method for a single object
		JMethod transformMethodSingle = JavagenFactory.eINSTANCE.createJMethod();
		transformMethodSingle.setName("transform");
		transformMethodSingle.getParameters().add( createParameter("e", typ.createTypeRef(getTransformInputType())) );
		transformMethodSingle.getThrows_().add(typ.createTypeRef("BlackboardException"));
		
		LMatchObject match = createMainMatcher(self, transformMethodSingle.getParameters().get(0));
		transformMethodSingle.getStatements().add( match );
		

		tclass.getMethods().add(transformMethodSingle);		
	}
	
	protected LMatchObject createMainMatcher(Module self, JVariableDeclaration matchVariable) {
		LMatchObject match = JavagenFactory.eINSTANCE.createLMatchObject();		
		
		for (ModuleElement e : self.getElements()) {
			if ( e instanceof MatchedRule ) {
				MatchedRule r = (MatchedRule) e;
				JMethod createMethod = get(ruleToCreateMethod, r);
				
				JMethod checkPredicate = ruleToCheckMethod.get(r);
				assertNotNull(checkPredicate);
				
				LMatchCase matchCase = JavagenFactory.eINSTANCE.createLMatchCase();
				matchCase.setObj( refVar(matchVariable) );
				matchCase.setPredicate( checkPredicate );

				matchCase.getStatements().add( createText(
						createMethod.getName() + "(" + cast(r.getInPattern().getElements().get(0).getInferredType()) + matchVariable.getName() + ")" ) );

				match.getCases().add(matchCase);
			}
		}
		return match;
	}
	
	
	protected abstract void createIsTargetElementCheckMethod();
	protected abstract void createGetDriverDynamically();
	
	
	@Override
	public void inContextHelper(ContextHelper self) {
		OclExpression body = ATLUtils.getBody(self);
		if ( body instanceof JavaBody ) {
			System.err.println("Helper " + ATLUtils.getHelperName(self) + " is implemented in Java.");
			return;
		}
		super.inContextHelper(self);
		JMethod method = gen.helperToMethod.get(self);
		method.getThrows_().add(typ.createTypeRef("BlackboardException"));
	}
	
	@Override
	public void inStaticHelper(StaticHelper self) {
		super.inStaticHelper(self);
		JMethod method = gen.helperToMethod.get(self);
		method.getThrows_().add(typ.createTypeRef("BlackboardException"));
	}
	
	/**
	 * The createMethod returns void because for rules with more than one output element
	 * it should return a list of elements. If we want a "writeAll" strategy, we have
	 * to return a list always.
	 */
	@Override
	public void inMatchedRule(MatchedRule self) {
		// Complete check method in a generic way...
		completeCheckMethod(self);
		// Add the exception declaration
		ruleToCheckMethod.get(self).getThrows_().add(typ.createTypeRef("BlackboardException"));
		JMethod createMethod = ruleToCreateMethod.get(self);

		// Write before the bindings to make sure that we can check target model elements querying the target model
		writeToTgtArea(self, createMethod);

		
		// Complete the create method
		createMethod.getThrows_().add(typ.createTypeRef("BlackboardException"));
		
		// Fill local variables ("using" block)
		for (RuleVariableDeclaration usingVar : self.getVariables()) {
			JVariableDeclaration var = env.getVar(usingVar);
			addStm(createMethod, env.getStatements(usingVar.getInitExpression()));
			addStm(createMethod, createAssignment(var, env.getVar(usingVar.getInitExpression()).getName()));
		}

		// Do bindings
		for (int i = 0; i < self.getOutPattern().getElements().size(); i++) {
			OutPatternElement ope = self.getOutPattern().getElements().get(i);
			
			JVariableDeclaration outVar = env.getVar(ope);
			// Creation of target elements
			// Could be delegated to factory methods to enable extensibility
			
			// This is already done in beforeMatchedRule
			// JTypeRef typeOut = outVar.getType();
			// addStm(createMethod, createAssignment(outVar, "new " + toStr(typeOut) + "()") );
			
			translateBindings(createMethod, outVar, ope);
		}
		
		if ( self.getActionBlock() != null ) {
			for (Statement stm : self.getActionBlock().getStatements()) {
				addStm(createMethod, env.getStatements(stm));
			}
		}

	}

	protected void translateBindings(JMethod createMethod, JVariableDeclaration outVar, OutPatternElement ope) {
		for (Binding binding : ope.getBindings()) {
			addStm(createMethod, getStatements(binding.getValue()));
		}
		
		IMetaDriver driver = env.getDriver(ope);
		for (Binding binding : ope.getBindings()) {
			OclExpression right = binding.getValue();
	
			
			// The type checking code needs to take account that a binding may have a
			// union type in the right part
			// Type rightType = ATLUtils.getUnderlyingBindingRightType(binding);
			Type rightType = binding.getValue().getInferredType();
			
			EStructuralFeature feature = (EStructuralFeature) binding.getWrittenFeature();
			
						
			// String setterAccess = ocl.getSetter(feature);
			
			// TODO: Handle the case of collections of primitive types
			if ( rightType instanceof PrimitiveType || rightType instanceof EnumType ) {
				JVariableDeclaration rightVar = getVar(right);
				rightVar = makeCoercions(binding, rightVar, createMethod);
				
				addStm(createMethod, driver.compileSetValue(outVar, feature, rightVar, rightType, ctx()));
				
				// addStm(createMethod, outVar.getName() + "." + setterAccess + "(" + rightVar.getName() + ")");
			} else {				
				if ( binding.getValue().getInferredType() instanceof CollectionType ) {
					JVariableDeclaration tmpVar = gen.addLocalVar(createMethod, "itTmp", typ.createParamTypeRef("List", "Object"));										
					addStm(createMethod, createAssignment(tmpVar, "new ArrayList<Object>()"));
					
					String baseType = getTransformInputType();
					
					JVariableDeclaration forEachVar = getVar(right);

					// First, flatten if needed. Once flattened, automatically filter to IdentifiableElement. Otherwise, filter if needed
					if ( bindingValueRequiresFlattening(binding.getValue()) ) { 
						JVariableDeclaration newFiltering = gen.addLocalVar(createMethod, "filterBinding", typ.createParamTypeRef("javaslang.collection.List", baseType ));					
						addStm(createMethod, createAssignment(newFiltering, "flatten(" + forEachVar.getName() + 
								")" +
								".filter(e_ -> e_ instanceof " + baseType + ").map(e_ -> (" + baseType + ") e_)"));
						// TODO: I'm not convinced that we need the filtering. That made sense when it was IdentifiableElement, but when it is Object is it just a wast of time.
						// TODO: Create a proper auxiliary flattening function
						forEachVar = newFiltering;
					} else {					
						if ( bindingValueRequiresFiltering(binding.getValue()) ) {
							JVariableDeclaration newFiltering = gen.addLocalVar(createMethod, "filterBinding", typ.createParamTypeRef("javaslang.collection.List", baseType));					
							addStm(createMethod, createAssignment(newFiltering, forEachVar.getName() + ".filter(e_ -> e_ instanceof " + baseType + ").map(e_ -> (" + baseType + ") e_)"));
							// TODO: I'm not convinced that we need the filtering. That made sense when it was IdentifiableElement, but when it is Object is it just a wast of time.
							forEachVar = newFiltering;
						}
					}
					
					// The most flexible type is IdentifiableElement. We do not here specific object features
					//JForeach foreach = createForeach("o", forEachVar, typ.createTypeRef(((CollectionType) right.getInferredType()).getContainedType()));
					JForeach foreach = createForeach("o", forEachVar, typ.createTypeRef(baseType)); 

					JVariableDeclaration tmpTargetElements;
					Supplier<List<JStatement>> onTargetElement = null;
					if ( typeContainsTargetElements(binding.getValue().getInferredType())) {
						tmpTargetElements = gen.addLocalVar(createMethod, "tgtElems", typ.createParamTypeRef("java.util.Set", "Object"));
						addStm(createMethod, createAssignment(tmpTargetElements, createTextExp("new java.util.HashSet<>()")));
						
						onTargetElement = () -> {
							// Not clear how to do this. Could be a set value or adding to a collection
							// For the moment, we add the id to a collection
							Type ctype = ((CollectionType) right.getInferredType()).getContainedType();
							if ( ctype instanceof Metaclass ) {													
								// String tgtIdMapper = ((LindaTyping) typ).getTgtAreaName(ope) + ".getIdMapper()";
								IMetaDriver targetDriver = env.getDriver((Metaclass) ctype);

								
								String expForBinding = targetDriver.toBinding(foreach.getLoopVar(), null);
								return Collections.singletonList(createText("a2l.runtime.RuntimeUtils.addToBindingTemporal(" + tmpVar.getName() + ", " + tmpTargetElements.getName() + ", " + expForBinding + ")"));
								
								//String expForBinding = targetDriver.toBinding(foreach.getLoopVar(), null);
								//return Collections.singletonList( createText(tmpVar.getName() + ".add(" + expForBinding + ")") );
							}else {
								String dynCall = "findModelDynamically(" + foreach.getLoopVar().getName() + ").forBinding(" + foreach.getLoopVar().getName() + ", null)";
								return Collections.singletonList(createText("a2l.runtime.RuntimeUtils.addToBindingTemporal(" + tmpVar.getName() + ", " + tmpTargetElements.getName() + ", " + dynCall + ")"));
								
								//String dynCall = "findModelDynamically(" + foreach.getLoopVar().getName() + ").forBinding(" + foreach.getLoopVar().getName() + ", null)";
								//return Collections.singletonList( createText(tmpVar.getName() + ".add(" + dynCall + ")") );
							}

							// return Collections.singletonList( createText(tmpVar.getName() + ".add(" + genGetIdCall(foreach.getLoopVar()) + ")") );							
						};
					} else {
						tmpTargetElements = null;
					}

					resolveBinding(foreach, binding, foreach.getLoopVar(), (r) -> {
						// TODO: Move trace id generation to the driver??
						Type ctype = ((CollectionType) right.getInferredType()).getContainedType();
						if ( ctype instanceof Metaclass ) {						
							//String idMapper = env.getDriver((Metaclass) ctype).compileGetSourceIdMapper(right, ctx());
							//String traceId = "TraceFunction.resolve(" + idMapper + ".getId(" + foreach.getLoopVar().getName() + ")" + ", 0, " + quote(r.getName()) + ")";
							IMetaDriver srcDriver = env.getDriver((Metaclass) ctype);
							String expForBinding = srcDriver.toBinding(foreach.getLoopVar(), r);
							return createText(tmpVar.getName() + ".add(" + expForBinding + ")");
						}else {
							// The idea is: find the model dynamically and let the model return the proper value to resolve the binding
							// TODO: This is not going to work if we have mixed drivers in the expression, this is limitation
							String dynCall = "findModelDynamically(" + foreach.getLoopVar().getName() + ").forBinding(" + foreach.getLoopVar().getName() + "," + quote(r.getName()) + ")";
							return createText(tmpVar.getName() + ".add(" + dynCall + ")");
							
							// For Lintra it used to be:
							// String dynCall = "findModelDynamically(" + foreach.getLoopVar().getName() + ").forBinding(" + foreach.getLoopVar().getName() + ")";
							// return createText(tmpVar.getName() + ".add(" + "TraceFunction.resolve(" + dynCall + ", 0, " + quote(r.getName()) + ") )");														
						}
						
					}, onTargetElement);
					
					
					addStm(createMethod, foreach);
					addStm(createMethod, driver.compileMultiValuedBindingResolution(binding, outVar, tmpVar, tmpTargetElements, ctx()));
				} else {
					Supplier<List<JStatement>> onTargetElement = null;
					if ( typeContainsTargetElements(binding.getValue().getInferredType())) {
						onTargetElement = () -> {
							return driver.compileSetValue(outVar, feature, getVar(right), right.getInferredType(), ctx());
						};
					}

					// MONO-VALUED: This is the default resolution for mono-valued binding
					resolveBinding(createMethod, binding, getVar(right), (r) -> {
						return driver.defaultBindingResolution(binding, r, outVar, ctx());
					}, onTargetElement);	
				}
			}
		}
	}

	private String genGetIdCall(JVariableDeclaration objVar) {
		return objVar.getName() + ".getId()";
	}

	private boolean bindingValueRequiresFiltering(OclExpression value) {
		Type type = value.getInferredType();
		if ( type instanceof CollectionType ) {
			return ((CollectionType) type).getContainedType() instanceof UnionType;
		}
		return false;
	}

	private boolean bindingValueRequiresFlattening(OclExpression value) {
		Type type = value.getInferredType();
		if ( type instanceof CollectionType ) {
			// TODO: Check if it is possible that there is a union type with collection types inside
			// with union types inside with...
			// In this case, this does not cover all cases
			return TypingModel.allPossibleTypes(((CollectionType) type).getContainedType()).stream().anyMatch(t -> t instanceof CollectionType);
			
			// return ((CollectionType) type).getContainedType() instanceof CollectionType;
		}
		return false;
	}

	private boolean typeContainsTargetElements(Type type) {
		if ( type instanceof CollectionType ) {
			return typeContainsTargetElements( ((CollectionType) type).getContainedType());
		} else if ( type instanceof UnionType ) {
			return TypingModel.allPossibleTypes(type).stream().anyMatch(t -> typeContainsTargetElements(t));
		} else if ( type instanceof Metaclass ) {
			return targetMetamodelNames.contains( ((Metaclass) type).getModel().getName());
		}
		return false;
	}

	/**
	 * This method makes the necessary coercions for a primitive binding, if needed.
	 * 
	 * @param binding
	 * @param rightVar
	 * @param createMethod
	 * @return A new variable with the value that will be assigned to the left part of the binding.
	 *         As a side effect it adds the necessary statement to the method
	 */
	private JVariableDeclaration makeCoercions(Binding binding, JVariableDeclaration rightVar, JMethod method) {
		Type leftType  = binding.getLeftType();
		Type rightType = binding.getValue().getInferredType();
		
		if ( leftType instanceof IntegerType && rightType instanceof FloatType ) {
			JVariableDeclaration tmpVar = gen.addLocalVar(method, "coercion", typ.createTypeRef(leftType));					
			addStm(method, createAssignment(tmpVar, "(int) " + rightVar.getName()));
			return tmpVar;
		}
		
		return rightVar;
	}

	public void translateBindingStat(BindingStat self) {
		// Analyse the different cases according the source value
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getValue()));
		
		JVariableDeclaration valueVar = env.getVar(self.getValue());

		// Is it a local variable declared in the using part?
		if ( self.getSource() instanceof VariableExp ) {
			stms.add( createAssignment(env.getVar(self.getSource()), valueVar.getName()));
		
		// Is it an assignment to a feature of a target element
		} else if ( self.getSource() instanceof NavigationOrAttributeCallExp ) {
			NavigationOrAttributeCallExp nav = (NavigationOrAttributeCallExp) self.getSource();
			
			EStructuralFeature f = (EStructuralFeature) nav.getUsedFeature();
			// String setterAccess = ocl.getSetter(f);
			
			JVariableDeclaration outVar = env.getVar(((VariableExp) nav.getSource()).getReferredVariable());

			IMetaDriver driver = env.getDriver(self.getSource());
			
			stms.addAll(driver.compileSetValue(outVar, f, valueVar, nav.getInferredType(), ctx()));

			
//			if ( nav.getInferredType() instanceof CollectionType )  {
//				// stms.add(outVar.getName() + "." + setterAccess + "(" + tmpVar.getName() + ".toArray(" + "new String[" + tmpVar.getName() + ".size()]" + "))");				
//				// stms.add(createText(outVar.getName() + "." + setterAccess + "(" + valueVar.getName() + ".toArray(" + "new String[" + valueVar.getName() + ".size()]" + "))"));
//				stms.add(createText(outVar.getName() + "." + setterAccess + "(" + valueVar.getName() + ".map(x -> x.getId()).toJavaArray(String.class))"));
//			} else {
//				stms.add(createText(outVar.getName() + "." + setterAccess + "(" + valueVar.getName() + ".getId())"));				
//			}			
		} else {
			throw new UnsupportedOperationException();
		}
		
		env.bind(self, stms);
	}
	
	@Override
	public void inNavigationOrAttributeCallExp(NavigationOrAttributeCallExp self) {
		if ( isThisModuleCall(self)) {
			ocl.inThisModuleCall(self);
		} else if ( self.getUsedFeature() != null || self.getSubtypeFeatures().size() > 0 ) {
			// If the call is in a do block, in the left part of an assignment like: 
			//        thisModule.methodsList <- t.getMethodsList();
			// then skip it because it will be handled by the rule for imperative assignments 
			if ( self.eContainingFeature() == ATLPackage.Literals.BINDING_STAT__SOURCE ) {
				// Just skip
			} else if ( isReadOfTargetFeature(self) ) {
				readTargetFeature(self);
			} else {					
				ocl.inNavigationExp(self, ! self.getSubtypeFeatures().isEmpty());
			}
		} else if ( isBuiltinAttribute(self) ) {
			ocl.inBuiltInAttributeCallExp(self);
		} else {
			ocl.inAttributeCall(self);
		}
	}

	@Override
	public void inNavRefAsSet(NavRefAsSet self) {
		ocl.inNavRefAsSet(self);
	}
	
	@Override
	public void inMutableIteratorExp(MutableIteratorExp self) {
		ocl.inMutableIteratorExp(self);
	}
	
	@Override
	public void inMutableCollectionOperationCallExp(MutableCollectionOperationCallExp self) {
		ocl.inMutableCollectionOperationCallExp(self);
	}
	
	private void readTargetFeature(NavigationOrAttributeCallExp self) {
		String tgtArea = ((LindaTyping) typ).getPartialOutputModelFieldName(self);
		
		EStructuralFeature f = (EStructuralFeature) self.getUsedFeature();
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "get", typ.createTypeRef(self.getInferredType()));		
		JVariableDeclaration srcVar = env.getVar(self.getSource());
		
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getSource()));

		IMetaDriver driver = env.getDriver(self.getSource());
		
		((LindaOclCompiler) this.ocl).generateGetterCode(self, f, driver, null, newVar, stms);
		
		
//		String getter = driver.compileGetterExpression(srcVar, f);
//		if ( f instanceof EAttribute ) {
//			stms.add( createAssignment(newVar, getter) );
//		} else {
//			if ( f.isMany() ) {
//				JVariableDeclaration idVar = gen.addLocalVar(env.currentBlock(), "id", typ.createArrayTypeRef("String"));
//				stms.add( createAssignment(idVar, getter));
//				stms.add( createAssignment(newVar, 
//						castList(self.getInferredType(), tgtArea + ".readAll( toList(" + idVar.getName() + ") )") )); 	
//			} else {
//				JVariableDeclaration idVar = gen.addLocalVar(env.currentBlock(), "id", typ.createTypeRef("String"));
//				stms.add( createAssignment(idVar, getter));
//				stms.add( createAssignment(newVar, 
//						cast(self.getInferredType()) + "read(" + tgtArea + ", " + idVar.getName() + ")" )); 	
//			}
//		}
//		

		
		env.bind(self, newVar, stms);		
	}
	// Copied from LindaOclCompiler just for readTargetFeature
	private String castList(Type t, String colExp) {
		String s = "new uk.ac.ebi.utils.collections.TypeCastCollection<" + typ.getType(((CollectionType) t).getContainedType())+ ">(" + colExp + ")";;
		
		return "javaslang.collection.List.ofAll(" + s+ ")";	
	}


	private boolean isReadOfTargetFeature(NavigationOrAttributeCallExp self) {
		// Reads to target features are only allowed in action blocks
		ActionBlock action = ATLUtils.getContainer(self, ActionBlock.class);
		if ( action == null )
			return false; 
		
		if ( self.getSource() instanceof VariableExp ) {
			VariableExp v = (VariableExp) self.getSource();
			return v.getReferredVariable() instanceof OutPatternElement;
		} else if ( self.getSource() instanceof NavigationOrAttributeCallExp ) {
			return isReadOfTargetFeature((NavigationOrAttributeCallExp) self.getSource());
		}
		return false;
	}

	@Override
	public void inOperatorCallExp(OperatorCallExp self) {
		ocl.inOperatorCallExp(self);
	}

	
	@Override
	public void beforeForStat(ForStat self) {
		ocl.prepareForStatVariable(self);
	}
	
	/** Not clear that stats methods should be part of the OCL interface */
	@Override
	public void inForStat(ForStat self) {
		ocl.inForStat(self);
	}
	
	@Override
	public void inIfStat(IfStat self) {
		ocl.inIfStat(self);
	}
	
	@Override
	public void inExpressionStat(ExpressionStat self) {
		List<JStatement> stms = createCommentedList(self);
		stms.addAll(env.getStatements(self.getExpression()));
		
		env.bind(self, stms);		
	}
	
	@Override
	public void inBindingStat(BindingStat self) {
		// TODO: Put in "imperative part module" or something
		translateBindingStat(self);
	}
	
	
	
	@Override
	public void inStringExp(StringExp self) {
		ocl.inStringExp(self);
	}
	
	@Override
	public void inIntegerExp(IntegerExp self) {
		ocl.inIntegerExp(self);
	}
	
	@Override
	public void inSequenceExp(SequenceExp self) {
		ocl.inSequenceExp(self);
	}
	
	@Override
	public void inSetExp(SetExp self) {
		ocl.inSetExp(self);
	}
	
	@Override
	public void inOrderedSetExp(OrderedSetExp self) {
		ocl.inOrderedSetExp(self);
	}
	
	@Override
	public void inMapExp(MapExp self) {
		ocl.inMapExp(self);
	}
	
	@Override
	public void inEnumLiteralExp(EnumLiteralExp self) {
		ocl.inEnumLiteralExp(self);
	}
	
	@Override
	public VisitingActions preIteratorExp(IteratorExp self) {
		return actions("source", "iterators", "body");
	}
	
	@Override
	public VisitingActions preMutableIteratorExp(MutableIteratorExp self) {
		return actions("source", "iterators", "body");
	}
	
	@Override
	public void beforeIteratorExp(IteratorExp self) {
		ocl.beforeIteratorExp(self);
	}
	
	@Override
	public void beforeMutableIteratorExp(MutableIteratorExp self) {
		// Same thing as immutable, does all the preparation
		ocl.beforeIteratorExp(self);
	}
	
	@Override
	public void inIteratorExp(IteratorExp self) {
		ocl.inIteratorExp(self);
	}
	
	@Override
	public VisitingActions preIteratorChainExp(IteratorChainExp self) {
		return actions("source" , "iterator", "chain");
	}
	
	@Override
	public void beforeIteratorChainExp(IteratorChainExp self) {
		ocl.beforeIteratorChainExp(self);
	}
	
	@Override
	public void inIteratorChainExp(IteratorChainExp self) {	
		ocl.inIteratorChainExp(self);
	}
	
	@Override
	public VisitingActions preIterateExp(IterateExp self) {
		return actions("source", "iterators" , "result", "type" , method("prepareIterateVariable", self),"body" );
	}
	
	public void prepareIterateVariable(IterateExp self) {
		ocl.prepareIterateVariable(self);
	}
	
	@Override
	public void inIterateExp(IterateExp self) {
		ocl.inIterateExp(self);
	}
	
	@Override
	public void inBooleanExp(BooleanExp self) {
		ocl.inBooleanExp(self);
	}
	
	@Override
	public void inOclUndefinedExp(OclUndefinedExp self) {
		ocl.inOclUndefined(self);
	}

	@Override
	public void inIfExp(IfExp self) {
		ocl.inIfExp(self);
	}

	@Override
	public void inOclModelElement(OclModelElement self) {
		ocl.inOclModelElement(self);
	}
	
	@Override
	public void inOperationCallExp(OperationCallExp self) {
		if ( isThisModuleCall(self)) {
			if ( self.getStaticResolver() instanceof LazyRule ) {
				ocl.inLazyRuleCall(self);
			} else if ( self.getStaticResolver() instanceof CalledRule ) {
				ocl.inCalledRuleCall(self);
			} else {
				if ( self.getOperationName().equals("resolveTemp") ) {
					handleResolveTemp(self);
				} else {
					ocl.inThisModuleCall(self);
				}
			}
		} else {		
			// TODO: How to handle an operation which is partly defined as a helper
			// and partly as an attribute or implemented in the meta-model??
			if ( isJavaOperation(self) ) {
				env.getDriver(self.getSource()).compileJavaOperation(self, ctx());
			} else if ( isBuiltinOperation(self) ) {
				ocl.inBuiltInOperationCallExp(self);
			} else {
				ocl.inOperationCallExp(self);			
			}
		}
	}
	
	private boolean isBuiltinAttribute(NavigationOrAttributeCallExp self) {
		return self.getSource().getInferredType() instanceof ReflectiveClass;
	}

	private boolean isJavaOperation(OperationCallExp self) {
		return  self.getSource().getInferredType() instanceof Metaclass 
				&& self.getStaticResolver() != null   
				&& env.getDriver(self.getSource()).checkIsJavaOperation(self);
	}
	
	private boolean isBuiltinOperation(OperationCallExp self) {
		return self.getDynamicResolvers().isEmpty() && 
				self.getProblems().stream().noneMatch(p -> p instanceof NavigationProblem);
	}
	
	private boolean isThisModuleCall(PropertyCallExp self) {
		OclExpression op = self.getSource();
		return (op instanceof VariableExp) && ((VariableExp) op).getReferredVariable().getVarName().equals("thisModule");
	}

	@Override
	public void inCollectionOperationCallExp(CollectionOperationCallExp self) {
		ocl.inCollectionOperationCallExp(self);
	}
	
	public VisitingActions preLetExp(anatlyzer.atlext.OCL.LetExp self) { return actions("type" , "variable", "in_"); } 
	
	@Override
	public void inLetExp(LetExp self) {
		ocl.inLetExp(self);
	}
	
	@Override
	public void inVariableDeclaration(VariableDeclaration self) {
		if ( self.eContainingFeature() == OCLPackage.Literals.LET_EXP__VARIABLE ) {
			ocl.inLetExpVarDcl(self);
		}
	}
	
	protected void resolveBinding(JBlock block, Binding binding, JVariableDeclaration rightVar, Function<MatchedRule, JStatement> onMatch, Supplier<List<JStatement>> onTargetElement) {		
		LMatchObject match = resolveObjectWithRules(block.getStatements(), binding.getResolvedBy(), rightVar, (r) -> Arrays.asList(onMatch.apply(r)));
		if ( onTargetElement != null ) {
			// This means it is a pure target assignment. No need to check target element existence.
			if ( binding.getResolvedBy().isEmpty() ) {
				addStm(block, onTargetElement.get());								
			} else {
				LMatchCase matchCase = JavagenFactory.eINSTANCE.createLMatchCase();
				// Must be first one, to avoid checking filters on target elements which may yield
				// to unwanted exceptions when the source and the target models are the same
				// (e.g., the "instanceof" part of the filter is passed but the filter queries the parent of the object)
				match.getCases().add(0, matchCase);	
		
				matchCase.setObj( refVar(rightVar) );
				matchCase.setPredicate( isTargetElementCheckMethod );
		
				addStm(matchCase, onTargetElement.get());				
			}
			
		}
	}
	
	protected LMatchObject resolveObjectWithRules(List<JStatement> stms, Collection<? extends RuleResolutionInfo> resolvingRules, JVariableDeclaration rightVar, Function<MatchedRule, List<JStatement>> onMatch) {		
		LMatchObject match = JavagenFactory.eINSTANCE.createLMatchObject();
		stms.add(match);
		
		for (RuleResolutionInfo rri : resolvingRules) {
			assertNotNull(rri.getRule());
			LMatchCase matchCase = JavagenFactory.eINSTANCE.createLMatchCase();
			match.getCases().add(matchCase);

			JMethod checkPredicate = ruleToCheckMethod.get(rri.getRule());
			assertNotNull(checkPredicate);
			
			matchCase.setObj( refVar(rightVar) );
			matchCase.setPredicate( checkPredicate );

			addStm(matchCase, onMatch.apply(rri.getRule()));
//			addStm(matchCase, outVar.getName() + ".set" + featAccess + "(" + 
//					"TraceFunction.resolve(" + rightVar.getName() + ".getId(), " + quote(rri.getRule().getName()) + ")");
			
		}
		
		return match;
	}
	
	private void handleResolveTemp(OperationCallExp self) {
		List<JStatement> stms = createCommentedList(self);
		JVariableDeclaration newVar = gen.addLocalVar(env.currentBlock(), "resolveTemp", typ.createTypeRef(self.getInferredType()));		
		
		JVariableDeclaration inElement = env.getVar(self.getArguments().get(0));
		
		final String opeName;
		if ( self.getArguments().get(1) instanceof StringExp ) {
			 opeName = ((StringExp) self.getArguments().get(1)).getStringSymbol();
		} else {
			throw new UnsupportedTranslation("ResolvedTemp translation only works if the output pattern is given as a string", self);
		}

		stms.addAll(env.getStatements(self.getArguments().get(0)));
		
		// This is to make sure that the result variable is initialized.
		// The alternative is to throw an exception if there is no match... 
		stms.add(createAssignment(newVar, "null"));
		
		resolveObjectWithRules(stms, self.getResolveTempResolvedBy(), inElement, (r) -> {
			OutPatternElement ope = getResolveTempOutpatternElement(r, opeName);
			JTypeRef opeType = typ.createMetaTypeImplRef((Metaclass) ope.getInferredType());
			int i = ope.getOutPattern().getElements().indexOf(ope);
			
			env.bind(ope, newVar);
			env.bind(r.getInPattern().getElements().get(0), inElement);
			
			IMetaDriver driver = env.getDriver(ope);

			List<JStatement> stmsResolveTemp = driver.compileObjectCreation((Metaclass) ope.getInferredType(), newVar, ctx());
			stmsResolveTemp.addAll(driver.compileTraceGeneration(r, r.getInPattern().getElements().get(0), ope, ctx()) );
			
			return stmsResolveTemp;
			
			// In the original Lintra compiler:			
			//			return Arrays.asList( 
			//					createAssignment(newVar, "new " + toStr(opeType) + "()"), 				
			//					createText(newVar.getName() + ".setId(" + "TraceFunction.create(" + inElement.getName() + ".getId(), " + i + "," + quote(r.getName()) + "))"),
			//					createText(newVar.getName() + ".setTrgId(" + quote( ((Metaclass) ope.getInferredType()).getModel().getName()) + ")")					
			//					);
				
		});		

		env.bind(self, newVar, stms);		
	}

	private OutPatternElement getResolveTempOutpatternElement(MatchedRule r, String opeName) {
		return r.getOutPattern().getElements().stream().
				filter(e -> e.getVarName().equals(opeName)).
				findAny().
				orElseThrow(() -> new UnsupportedTranslation("Cannot find output pattern element " + opeName + " in " + r.getName(), r));
	}

	// OCL Rules

	@Override
	public void inVariableExp(VariableExp self) {
		if ( self.getReferredVariable().getVarName().equals("thisModule"))
			return; // could bind "this"
		
		env.bind(self, getVar(self.getReferredVariable()), new ArrayList<JStatement>());
	}
		
	// 
	// Internal trace handling
	// 

	public JVariableDeclaration getVar(EObject e) {
		return env.getVar(e);
	}
	
	public List<JStatement> getStatements(EObject e) {
		return env.getStatements(e);
	}
	
	//
	// Adaptation methods between Lintra version
	//
	
	public String getTransformInputType() {
		return "IdentifiableElement";
	}
	
	protected void initTyping(ITyping typ, JClass tclass) {
		typ.createLibType("blackboard", "IdentifiableElement");
		typ.createLibType("blackboard", "IArea");		
		typ.createLibType("blackboard", "BlackboardException");		
		
		typ.createLibType("transfo", "ITransformation");
		typ.createLibType("transfo", "ITransformation2");
		typ.createLibType("transfo", "IMaster");
		typ.createLibType("transfo", "TraceFunction");
		
		addImport(tclass, "blackboard", "IdentifiableElement");
		addImport(tclass, "blackboard", "IArea");		
		addImport(tclass, "blackboard", "BlackboardException");		
		
		addImport(tclass, "transfo", "ITransformation");
		addImport(tclass, "transfo", "IMaster");
		addImport(tclass, "transfo", "TraceFunction");
	}

}