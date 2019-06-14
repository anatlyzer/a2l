package linda.atlcompiler;

import static linda.atlcompiler.CreationHelpers.addStm;
import static linda.atlcompiler.CreationHelpers.createSimpleIf;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.quote;
import static linda.atlcompiler.CreationHelpers.refVar;
import static linda.atlcompiler.CreationHelpers.toStr;
import static linda.atlcompiler.CreationHelpers.createSimpleIf;
import static linda.atlcompiler.CreationHelpers.createAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;

import a2l.anatlyzerext.visitor.AbstractAnatlyzerExtVisitor;
import a2l.compiler.A2LOptimiser.Optimisation;
import a2l.compiler.FootprintGenerator;
import a2l.compiler.RunnerGenerator;
import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.driver.JavaslangDriver;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.model.TypeUtils;
import anatlyzer.atl.model.TypingModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.types.Unknown;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.CalledRule;
import anatlyzer.atlext.ATL.ContextHelper;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.InPattern;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.ATL.OutPattern;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleVariableDeclaration;
import anatlyzer.atlext.ATL.StaticHelper;
import anatlyzer.atlext.OCL.Attribute;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.JavaBody;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclFeature;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.Operation;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.processing.AbstractVisitor;
import anatlyzer.atlext.processing.AbstractVisitor.VisitingActions;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.ICompilationContext.IInitializer;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JLoop;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JText;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.atlcompiler.javagen.LMatchCase;
import lintra.atlcompiler.javagen.LMatchObject;
import lintra.lingen.LinGen;

public abstract class BaseCompiler extends AbstractAnatlyzerExtVisitor {
	protected IAnalyserResult result;
	protected ATLModel model;

	// Must be initialized by the subclasses
	protected CompilationEnv env;
	protected IOclCompiler ocl;
	protected ITyping typ;
	protected GenCompiler gen;

	protected JavaGenModel jmodel;
	protected JClass tclass;
	
	//
	protected HashMap<MatchedRule, JMethod> ruleToCreateMethod = new HashMap<>();
	protected HashMap<MatchedRule, JMethod> ruleToCheckMethod = new HashMap<>();

	
	protected String basePkg;
	protected DriverConfiguration driverConfiguration;
	
	
	public BaseCompiler(IAnalyserResult result, DriverConfiguration driverConfiguration) {
		this.result = result;
		this.model  = result.getATLModel();
		this.driverConfiguration = driverConfiguration;
		
		// Pre-processing steps
		new NormalizeForEachPattern(this.model).perform();
		
		env = new CompilationEnv(result, driverConfiguration);
		gen = new GenCompiler();
	}
	
	public RunnerGenerator getRunnerGenerator() {
		return new RunnerGenerator(result, driverConfiguration);
	}

	public FootprintGenerator getFootprintGenerator() {
		return new FootprintGenerator(result, driverConfiguration);
	}
		
	/**
	 * Rewrites the ATL AST or do annotations for later phases
	 * @param opts 
	 */
	public void atlOptimize(Set<? extends Optimisation> opts) {
		// Does nothing, subclases should override if needed
	}

	
	public JavaGenModel compile(String basePkg) {
		this.basePkg = basePkg;
		this.jmodel = JavagenFactory.eINSTANCE.createJavaGenModel();
	
		analyseTargetModelElementUsage(model);
		
		startVisiting(model.getModule());
		
		return jmodel;
	}
	
	private void analyseTargetModelElementUsage(ATLModel model) {
		List<OutPatternElement> opes = model.allObjectsOf(OutPatternElement.class);
		for(Binding b : model.allObjectsOf(Binding.class)) {
			Type t = b.getValue().getInferredType();
			Rule ruleOfBinding = ATLUtils.getRule(b);
			
			// Is a rule called for the binding? This rule needs to put their objects there
			// Well, a lazy rule can be called from a helper... The safest way is to put it the partial model? That might be enough
			
//			List<Metaclass> metaclasses = TypingModel.getInvolvedMetaclassesOfType(t);
//			for (Metaclass metaclass : metaclasses) {
//				
//			}
		}
	}

	public IAnalyserResult getAnalysisResult() {
		return result;
	}
	
	// Ordering of helpers and rules
	public VisitingActions preModule(anatlyzer.atlext.ATL.Module self) { 
		return actions("libraries", "inModels", "outModels", 
				filter("getHelpers", self), filter("getRules", self));
	} 
			
	public List<Helper> getHelpers(anatlyzer.atlext.ATL.Module self) {
		LinkedList<Helper> helpers = new LinkedList<Helper>();
		for (ModuleElement me : self.getElements()) {
			if ( me instanceof Helper && !AnalyserUtils.isAddedEOperation(me) && !isSkipped(me)) {
				helpers.addLast((Helper) me);				
			}
		}
		return helpers;
	}

	private boolean isSkipped(ModuleElement me) {
		if (me instanceof Helper && ATLUtils.getHelperName((Helper) me).equals("oclAsType"))
			return true;
		return false;
	}

	public List<Rule> getRules(anatlyzer.atlext.ATL.Module self) {
		ArrayList<Rule> rules = new ArrayList<Rule>();
		for (ModuleElement me : self.getElements()) {
			if ( me instanceof Rule ) 
				rules.add((Rule) me);
		}
		return rules;
	}
	// end-of ordering of helpers and rules
	
	public void configureContextHelper(ContextHelper self) {
		if ( ATLUtils.getHelperBody(self) instanceof JavaBody ) 
			return;
		
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		JTypeRef ctxTypeRef = typ.createTypeRef(self.getContextType());
		method.setName("helper_" + CreationHelpers.toStr(ctxTypeRef).replace(".", "_") + "_" + ATLUtils.getHelperName(self));
		gen.helperToMethod.put(self, method);
		tclass.getMethods().add(method);
		
		// Add the "self" variable
		method.getParameters().add( CreationHelpers.createParameter("self_", typ.createTypeRef(self.getContextType())) );
		
		// Add the regular parameters
		List<JParameter> params = ATLUtils.getHelperArguments(self).stream().map(p -> {
			return createParameterInEnv(p, typ.createTypeRef(p.getInferredType()));
		}).collect(Collectors.toList());

		method.getParameters().addAll(params);
		
		// Set the return type
		method.setReturnType(typ.createTypeRef(ATLUtils.getHelperReturnType(self).getInferredType()));
				
		ATLUtils.findSelfReferences(self).forEach(selfVar -> env.bind(selfVar, method.getParameters().get(0)));
		
		// Create the body
		// Delayed to the "in" method, when the helper has been translated
	}
	
	@Override
	public void beforeContextHelper(ContextHelper self) {
		JMethod method = gen.helperToMethod.get(self);
		// Put "self" in scope...
		env.pushBlock(method);
		// TODO: env should support the creation of new scopes for variables
	}

	@Override
	public void afterContextHelper(ContextHelper self) {
		env.popBlock();
	}
	
	@Override
	public void beforeStaticHelper(StaticHelper self) {
		JMethod method = gen.helperToMethod.get(self);
		env.pushBlock(method);
	}

	@Override
	public void afterStaticHelper(StaticHelper self) {
		env.popBlock();
	}
	
	@Override
	public void inContextHelper(ContextHelper self) {
		OclExpression body = ATLUtils.getBody(self);
		if ( body instanceof JavaBody ) {
			System.err.println("Helper " + ATLUtils.getHelperName(self) + " is implemented in Java.");
			return;
		}
		
		JMethod method = gen.helperToMethod.get(self);
		
		List<JStatement> stmts = env.getStatements(body);
		JVariableDeclaration returnVar = env.getVar(body);
		
		method.getStatements().addAll(stmts);
		
		
		generateHelperReturnMethod(self, method, returnVar);		
	}

	private void generateHelperReturnMethod(Helper self, JMethod method, JVariableDeclaration returnVar) {
		String castReturnType = "";
		
		Type returnType = ATLUtils.getHelperReturnType(self).getInferredType();
		Type inferred   = self.getInferredReturnType();
		if ( inferred instanceof CollectionType && returnType instanceof CollectionType ) {
			// If the declared type is a supertype of the inferred (it is more general than needed)
			// then we need to somehow cast. 
			Type containedInferred = ((CollectionType) inferred).getContainedType();
			Type containedReturned = ((CollectionType) returnType).getContainedType();
			
			if ( isSuperType(containedReturned, containedInferred) ) {
				castReturnType = ".map(x_ -> " + cast(containedInferred) + "x_)";
			}
			
		}
		
		method.getStatements().add( createText("return " + returnVar.getName() + castReturnType) );
	}
	
	/**
	 * Checks if t1 is a supertype of t2.
	 * @param t1
	 * @param t2
	 * @return
	 */
	public boolean isSuperType(Type t1, Type t2) {
		if ( t1 instanceof Metaclass && t2 instanceof Metaclass ) {
			EClass m1 = ((Metaclass ) t1).getKlass();
			EClass m2 = ((Metaclass ) t2).getKlass();
			if ( m1 == m2 )
				return false;
			return m1.isSuperTypeOf(m2);
				
		}
		return false;
	}
	
	public void configureStaticHelper(StaticHelper self) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("helper_global_" + ATLUtils.getHelperName(self));
		gen.helperToMethod.put(self, method);
		tclass.getMethods().add(method);

		// Add the regular parameters
		List<JParameter> params = ATLUtils.getHelperArguments(self).stream().map(p -> {
			JParameter param = createParameterInEnv(p, typ.createTypeRef(p.getInferredType()));
			return param;
		}).collect(Collectors.toList());

		method.getParameters().addAll(params);
		
		// Set the return type
		method.setReturnType(typ.createTypeRef(ATLUtils.getHelperReturnType(self).getInferredType()));		
	}

	public JParameter createParameterInEnv(VariableDeclaration var, JTypeRef typeref) {
		JParameter param = CreationHelpers.createParameter(sanitize(var.getVarName()), typeref);
		env.bind(var, param);
		return param;
	}
	
	private String sanitize(String varName) {
		return LinGen.sanitize(varName);
	}

	@Override
	public void inStaticHelper(StaticHelper self) {
		// Same as context helper
		OclExpression body = ATLUtils.getBody(self);

		JMethod method = gen.helperToMethod.get(self);
		
		List<JStatement> stmts = env.getStatements(body);
		JVariableDeclaration returnVar = env.getVar(body);
		
		method.getStatements().addAll(stmts);
		
		generateHelperReturnMethod(self, method, returnVar);		
	}
		
	protected void addImport(JClass tclass, String pkg, String name) {
		tclass.getImports().add(typ.getType(pkg + "." + name));
	}
	
	public abstract String getBaseType(OclType type);

	@Override
	public VisitingActions preMatchedRule(MatchedRule self) {
		return actions(
				"annotations",
				// method("configureInPattern", self), 				
				// "inPattern", // It is disabled to invoke it explicitly from the corresponding method				
				method("configureOutPattern", self), 
				"variables",
				"outPattern" , 
				"actionBlock");
	}	

	public void configureInPattern(MatchedRule self) {
		JMethod method = ruleToCheckMethod.get(self);
		if ( method == null ) throw new IllegalStateException();
		env.pushBlock(method);				
	}
	
	public void configureOutPattern(MatchedRule self) {		
		JMethod method = ruleToCreateMethod.get(self);
		if ( method == null ) throw new IllegalStateException();
		env.pushBlock(method);		
	}

	public void beforeMatchedRule(MatchedRule self) {
		JMethod createMethod = JavagenFactory.eINSTANCE.createJMethod();
		createMethod.setName("create_" + self.getName());
		tclass.getMethods().add(createMethod);
		createMethod.getParameters().add( 
				CreationHelpers.createParameter(self.getInPattern().getElements().get(0).getVarName(), 
				typ.createMetaTypeRef((Metaclass) self.getInPattern().getElements().get(0).getInferredType() )) );

		JParameter inElement = createMethod.getParameters().get(0);

		env.bind(self.getInPattern().getElements().get(0), inElement);
		
		// Initialize local variables ("using" block)
		for (RuleVariableDeclaration usingVar : self.getVariables()) {
			JVariableDeclaration var = gen.addLocalVar(createMethod, usingVar.getVarName(), typ.createTypeRef(usingVar.getInitExpression().getInferredType()) );
			env.bind(usingVar, var);			
		}
		
//		// Create out pattern variables, so that they are available in the do block
//		JTypeRef typeOut = typ.createMetaTypeImplRef((Metaclass) self.getOutPattern().getElements().get(0).getInferredType());
//		JVariableDeclaration outVar = gen.addLocalVar(createMethod, "out", typeOut);	
//		env.bind(self.getOutPattern().getElements().get(0), outVar);
		createOutElements(self, createMethod, false);
		
		// Set the ids now before the objects are actually used (could also be done more compactly by implementing another version of createOutElements)
		for (int i = 0; i < self.getOutPattern().getElements().size(); i++) {
			OutPatternElement ope = self.getOutPattern().getElements().get(i);			
			
			addStm(createMethod, env.getDriver(ope).compileTraceGeneration(self, self.getInPattern().getElements().get(0), ope, ctx()));
			// addStm(createMethod, outVar.getName() + ".setId(" + "TraceFunction.create(" + inElement.getName() + ".getId(), " + i + "," + quote(self.getName()) + "))");
		}

		
		ruleToCreateMethod.put(self, createMethod);
	}
	
	public void configureLazyRule(LazyRule self) {		
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("lazy_rule_" + self.getName());
		method.getThrows_().add(typ.createTypeRef("BlackboardException"));
		gen.lazyRuleToMethod.put(self, method);
		tclass.getMethods().add(method);
	}

	@Override
	public void beforeLazyRule(LazyRule self) {		
		JMethod method = gen.lazyRuleToMethod.get(self);
		env.pushBlock(method);

		// Add the regular parameters
		List<JParameter> params = self.getInPattern().getElements().stream().map(p -> {
			return createParameterInEnv(p, typ.createTypeRef(p.getInferredType()));
		}).collect(Collectors.toList());

		method.getParameters().addAll(params);
		
		// Set the return type
		Type returnType = self.getOutPattern().getElements().get(0).getInferredType();
		method.setReturnType(typ.createTypeRef(returnType));

		createOutElements(self, method, true);
	}
	
	private void createOutElements(Rule self, JMethod method, boolean setId) {
		for (OutPatternElement out : self.getOutPattern().getElements()) {
			JTypeRef typeOut = typ.createMetaTypeImplRef((Metaclass) out.getInferredType());
			JVariableDeclaration outVar = gen.addLocalVar(method, out.getVarName(), typeOut);
			env.bind(out, outVar);
			
		
			List<JStatement> stms = env.getDriver(out).compileObjectCreation((Metaclass) out.getInferredType(), outVar, ctx());
			
			// addStm(method, createAssignment(outVar, "new " + toStr(typeOut) + "()") );
			addStm(method, stms);
			
			if ( setId ) {
				// Generate a unique id. This could be made more flexible passing a closure

				addStm(method, env.getDriver(out).compileTraceGeneration(self, null, out, ctx()) );
				// addStm(method, outVar.getName() + ".setId(" + "TraceFunction.createUniqueId(" + quote(self.getName()) + "))");
			}
		}
	}

	protected void writeToTgtArea(Rule self, JMethod createMethod) {
		// Finally, write to the trgArea
		for (int i = 0; i < self.getOutPattern().getElements().size(); i++) {
			OutPatternElement ope = self.getOutPattern().getElements().get(i);
			JVariableDeclaration outVar = env.getVar(ope);
			
			String tgtArea = ((LindaTyping) typ).getPartialOutputModelFieldName(ope);
			
			addStm(createMethod, tgtArea + ".write(" + outVar.getName()+ ")");
		}
	}
	
	@Override
	public void afterLazyRule(LazyRule self) {
		env.popBlock();
	}
	
	@Override
	public void afterCalledRule(CalledRule self) {
		env.popBlock();
	}
	
	public void configureCalledRule(CalledRule self) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("called_rule_" + self.getName());
		method.getThrows_().add(typ.createTypeRef("BlackboardException"));
		gen.calledRuleToMethod.put(self, method);
		tclass.getMethods().add(method);
		
		// Add the regular parameters
		List<JParameter> params = self.getParameters().stream().map(p -> {
			return createParameterInEnv(p, typ.createTypeRef(p.getInferredType()));
		}).collect(Collectors.toList());

		method.getParameters().addAll(params);
		
		// Set the return type
		Type returnType = self.getOutPattern().getElements().get(0).getInferredType();
		method.setReturnType(typ.createTypeRef(returnType));

		
		createOutElements(self, method, true);
	}
	
	@Override
	public void beforeCalledRule(CalledRule self) {
		JMethod method = gen.calledRuleToMethod.get(self);		
		env.pushBlock(method);
	}
	
	@Override
	public void inLazyRule(LazyRule self) {
		JMethod method = gen.lazyRuleToMethod.get(self);

		// Write before the bindings to make sure that we can check target model elements querying the target model
		writeToTgtArea(self, method);
		
		for (OutPatternElement ope : self.getOutPattern().getElements()) {
			JVariableDeclaration outVar = env.getVar(ope);			
			translateBindings(method, outVar, ope);
		}
		
		JVariableDeclaration returnVar = env.getVar( self.getOutPattern().getElements().get(0) );
		method.getStatements().add( createText("return " + returnVar.getName()) );		
	}

	@Override
	public void inCalledRule(CalledRule self) {
		JMethod method = gen.calledRuleToMethod.get(self);

		// Write before the bindings to make sure that we can check target model elements querying the target model
		writeToTgtArea(self, method);
		
		for (OutPatternElement ope : self.getOutPattern().getElements()) {
			JVariableDeclaration outVar = env.getVar(ope);			
			translateBindings(method, outVar, ope);
		}		
		
		JVariableDeclaration returnVar = env.getVar( self.getOutPattern().getElements().get(0) );
		method.getStatements().add( createText("return " + returnVar.getName()) );	
		// TODO: Check the variable in the do block which is returned
	}
	
	protected abstract void translateBindings(JMethod createMethod, JVariableDeclaration outVar, OutPatternElement ope);

	
	
	protected JMethod createCheckMethod(MatchedRule self) {
		JMethod checkMethod = JavagenFactory.eINSTANCE.createJMethod();
		checkMethod.setName("check_" + self.getName());
		tclass.getMethods().add(checkMethod);
		ruleToCheckMethod.put(self, checkMethod);
		return checkMethod;
	}
	
	protected JMethod completeCheckMethod(MatchedRule self) {
		JMethod checkMethod = ruleToCheckMethod.get(self);

		env.copyScope();
		env.pushBlock(checkMethod);
				
		checkMethod.setReturnType(typ.createTypeRef("boolean"));
		checkMethod.getParameters().add( 
				CreationHelpers.createParameter(self.getInPattern().getElements().get(0).getVarName(), 
					typ.createTypeRef(getTransformInputType())));
				// typ.createTypeRef(getBaseType(self.getInPattern().getElements().get(0).getType())) ));

		InPatternElement firstIPE = self.getInPattern().getElements().get(0);
		
		JTypeRef objTypeIfMatched = typ.createMetaTypeRef( (Metaclass) firstIPE.getInferredType() );;
		JTypeRef objTypeIfMatched2 = typ.createMetaTypeRef( (Metaclass) firstIPE.getInferredType() );;
		
		JVariableDeclaration param = checkMethod.getParameters().get(0);
		
		String kindOfCheck = param.getName() + " instanceof " + toStr(objTypeIfMatched);
		
		OclExpression filter = self.getInPattern().getFilter();
		if ( filter != null ) {
			List<JStatement> filterStatements = new ArrayList<JStatement>();
			
			// The attached block could the be "if"
			JVariableDeclaration newVar = gen.addLocalVar(checkMethod, "tmp", objTypeIfMatched2);
			env.rebind(firstIPE, newVar);
			
			JAssignment assignment = createAssignment(newVar, "(" + toStr(objTypeIfMatched2) + ")" + param.getName());
			
			// Apply the in pattern to generate the OCL expression
			configureInPattern(self);
			startVisiting(self.getInPattern());
			env.popBlock();
			
			filterStatements.add(assignment);
			filterStatements.addAll( env.getStatements(filter) );
			filterStatements.add( createText("return " + env.getVar(filter).getName() + " == true") );
			
			JConditional ifStm = createSimpleIf(kindOfCheck, filterStatements);

			addStm(checkMethod, ifStm);
			addStm(checkMethod, "return false");
		} else {		
			addStm(checkMethod, "return " + kindOfCheck);
		}
	
		env.popBlock();
		env.closeScope();
		
		return checkMethod;
	}
	
	public abstract String getTransformInputType();
	
	// Trace handling
	
	protected JMethod get(HashMap<MatchedRule, JMethod> ruleToMethod, MatchedRule r) {
		if ( ! ruleToMethod.containsKey(r) ) {
			throw new IllegalStateException("No method for " + r.getName());
		}
		return ruleToMethod.get(r);
	}

	protected String cast(Type t) {
		return "(" + typ.getType(t) + ")";
	}	

	//
	
	protected void assertNotNull(Object o) {
		if ( o == null )
			throw new IllegalStateException();
	}
	
	protected ICompilationContext ctx() {
		Context ctx = new ICompilationContext.Context(env, typ, gen, new JavaslangDriver(), (IInitializer) this.ocl);
		return ctx;
	}

}
