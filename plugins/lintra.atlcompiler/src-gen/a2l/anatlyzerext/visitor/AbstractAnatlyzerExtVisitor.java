package a2l.anatlyzerext.visitor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

@SuppressWarnings("unchecked")
public class AbstractAnatlyzerExtVisitor  extends anatlyzer.atlext.processing.AbstractVisitor {
	protected boolean _debug = false;
	protected EObject current;
	
	public VisitingActions preIteratorChainElement(a2l.optimiser.anatlyzerext.IteratorChainElement self) { return new VisitingActions("body"); } 
	public void inIteratorChainElement(a2l.optimiser.anatlyzerext.IteratorChainElement self) { if ( _debug ) System.out.println("Visiting IteratorChainElement"); }
	public void beforeIteratorChainElement(a2l.optimiser.anatlyzerext.IteratorChainElement self) { }
	public void afterIteratorChainElement(a2l.optimiser.anatlyzerext.IteratorChainElement self) { }
	public VisitingActions preMutableCollectionOperationCallExp(a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp self) { return new VisitingActions("annotations" , "type" , "source" , "arguments" , "resolveTempResolvedBy"); } 
	public void inMutableCollectionOperationCallExp(a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp self) { if ( _debug ) System.out.println("Visiting MutableCollectionOperationCallExp"); }
	public void beforeMutableCollectionOperationCallExp(a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp self) { }
	public void afterMutableCollectionOperationCallExp(a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp self) { }
	public VisitingActions preMutableIteratorExp(a2l.optimiser.anatlyzerext.MutableIteratorExp self) { return new VisitingActions("annotations" , "type" , "source" , "body" , "iterators"); } 
	public void inMutableIteratorExp(a2l.optimiser.anatlyzerext.MutableIteratorExp self) { if ( _debug ) System.out.println("Visiting MutableIteratorExp"); }
	public void beforeMutableIteratorExp(a2l.optimiser.anatlyzerext.MutableIteratorExp self) { }
	public void afterMutableIteratorExp(a2l.optimiser.anatlyzerext.MutableIteratorExp self) { }
	public VisitingActions preIteratorChainExp(a2l.optimiser.anatlyzerext.IteratorChainExp self) { return new VisitingActions("annotations" , "type" , "source" , "iterator" , "chain"); } 
	public void inIteratorChainExp(a2l.optimiser.anatlyzerext.IteratorChainExp self) { if ( _debug ) System.out.println("Visiting IteratorChainExp"); }
	public void beforeIteratorChainExp(a2l.optimiser.anatlyzerext.IteratorChainExp self) { }
	public void afterIteratorChainExp(a2l.optimiser.anatlyzerext.IteratorChainExp self) { }
	public VisitingActions preNavRefAsSet(a2l.optimiser.anatlyzerext.NavRefAsSet self) { return new VisitingActions("annotations" , "type" , "source"); } 
	public void inNavRefAsSet(a2l.optimiser.anatlyzerext.NavRefAsSet self) { if ( _debug ) System.out.println("Visiting NavRefAsSet"); }
	public void beforeNavRefAsSet(a2l.optimiser.anatlyzerext.NavRefAsSet self) { }
	public void afterNavRefAsSet(a2l.optimiser.anatlyzerext.NavRefAsSet self) { }
		
	protected VisitingActions actions(Object... things) {
		return new VisitingActions(things);
	}

	public void startVisiting(EObject init) {
		visit(init);
	}	
	
	public EObject getCurrent() { return current; }
	public void setCurrent(EObject o) { current = o; }
	
	protected void visitIteratorChainElement(a2l.optimiser.anatlyzerext.IteratorChainElement this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		VisitingActions v = visitor.preIteratorChainElement(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeIteratorChainElement(this_);
		
		visitActions(v, this_);		
					
		visitor.inIteratorChainElement(this_);
		visitor.afterIteratorChainElement(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitMutableCollectionOperationCallExp(a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		VisitingActions v = visitor.preMutableCollectionOperationCallExp(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeMutableCollectionOperationCallExp(this_);
		
		visitActions(v, this_);		
					
		visitor.inMutableCollectionOperationCallExp(this_);
		visitor.afterMutableCollectionOperationCallExp(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitMutableIteratorExp(a2l.optimiser.anatlyzerext.MutableIteratorExp this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		VisitingActions v = visitor.preMutableIteratorExp(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeMutableIteratorExp(this_);
		
		visitActions(v, this_);		
					
		visitor.inMutableIteratorExp(this_);
		visitor.afterMutableIteratorExp(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitIteratorChainExp(a2l.optimiser.anatlyzerext.IteratorChainExp this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		VisitingActions v = visitor.preIteratorChainExp(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeIteratorChainExp(this_);
		
		visitActions(v, this_);		
					
		visitor.inIteratorChainExp(this_);
		visitor.afterIteratorChainExp(this_);
		visitor.setCurrent(pop);	
	} 
	protected void visitNavRefAsSet(a2l.optimiser.anatlyzerext.NavRefAsSet this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		VisitingActions v = visitor.preNavRefAsSet(this_);
		if ( v == null ) {
			return;
		}
	
		EObject pop = visitor.getCurrent();
		visitor.setCurrent(this_);
		visitor.beforeNavRefAsSet(this_);
		
		visitActions(v, this_);		
					
		visitor.inNavRefAsSet(this_);
		visitor.afterNavRefAsSet(this_);
		visitor.setCurrent(pop);	
	} 
		
	private void visitActions(VisitingActions v, EObject this_) {
		AbstractAnatlyzerExtVisitor visitor = this;
		
		for(VisitingAction va : v.getActions(this_)) {
			if ( va.isMethodCall() ) {
				va.performMethodCall();		
			} else if ( va.isFilter() ) {
				Object res = va.performMethodCall();
				if ( res instanceof java.util.Collection ) {
					for(Object o : (java.util.Collection<?>) res) {
						visit((EObject) o);
					}
				} else {
					visit((EObject) res);
				}
			} else if ( va.isReference() ) {
				EReference r = va.getEReference();
				
				Object refObj   = this_.eGet(r);
				if ( refObj == null ) continue;
				if ( refObj instanceof java.util.Collection ) {
					for(Object o : (java.util.Collection<?>) refObj) {
						visit((EObject) o);
					}
				} else {
					visit((EObject) refObj);
				}
			}
		}
	
	}
	
	protected void visit(EObject obj) {	
	if ( obj.eClass().getName().equals("IteratorChainElement") ) { visitIteratorChainElement((a2l.optimiser.anatlyzerext.IteratorChainElement) obj); return; }
	if ( obj.eClass().getName().equals("MutableCollectionOperationCallExp") ) { visitMutableCollectionOperationCallExp((a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp) obj); return; }
	if ( obj.eClass().getName().equals("MutableIteratorExp") ) { visitMutableIteratorExp((a2l.optimiser.anatlyzerext.MutableIteratorExp) obj); return; }
	if ( obj.eClass().getName().equals("IteratorChainExp") ) { visitIteratorChainExp((a2l.optimiser.anatlyzerext.IteratorChainExp) obj); return; }
	if ( obj.eClass().getName().equals("NavRefAsSet") ) { visitNavRefAsSet((a2l.optimiser.anatlyzerext.NavRefAsSet) obj); return; }
		
	   super.visit(obj);

	}
	
	protected void unknownClassOf(EObject obj) {
		throw new IllegalStateException("Cannot handle class: " + obj.eClass().getName());	
	}
	
	//
	// Framework code inlined as a template
	//

	

	private java.util.HashMap<String, java.lang.reflect.Method> allMethods = null;
	public java.util.HashMap<String, java.lang.reflect.Method> getAllMethods() {
		if ( allMethods == null ) {
			allMethods = new java.util.HashMap<String, java.lang.reflect.Method>();
			for(java.lang.reflect.Method m : this.getClass().getMethods()) {
				allMethods.put(getMethodKey(m.getName(), m.getParameterCount()), m);
			}
		}
		return allMethods;
	}
	
	private final String getMethodKey(String name, int paramCount) {
		return name + "/" + paramCount;
	}
	
	public VisitingAction method(String methodName, Object... arguments) {
		String key = getMethodKey(methodName, arguments.length);
		if ( getAllMethods().containsKey(key) ) {
			return new VisitingAction(this, getAllMethods().get(key), arguments);			
		}
		
		throw new RuntimeException("No method " + methodName + " found in " + this.getClass().getName());
	}

	public VisitingAction filter(String methodName, Object... arguments) {
		String key = getMethodKey(methodName, arguments.length);
		if ( getAllMethods().containsKey(key) ) {
			return VisitingAction.createFilter(this, getAllMethods().get(key), arguments);
		}
		
		throw new RuntimeException("No method " + methodName + " found in " + this.getClass().getName());
	}

	public static class DelegatedVisitor extends AbstractAnatlyzerExtVisitor {
		private anatlyzer.atlext.processing.AbstractVisitor delegate;
		public DelegatedVisitor(anatlyzer.atlext.processing.AbstractVisitor delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public EObject getCurrent() { return delegate.getCurrent(); }
		@Override
		public void setCurrent(EObject o) { delegate.setCurrent(o); }
			
		public void inLocatedElement(anatlyzer.atlext.ATL.LocatedElement self) { delegate.inLocatedElement(self); }
		public void beforeLocatedElement(anatlyzer.atlext.ATL.LocatedElement self) { delegate.beforeLocatedElement(self); }
		public void afterLocatedElement(anatlyzer.atlext.ATL.LocatedElement self)  { delegate.afterLocatedElement(self); }
		public void inUnit(anatlyzer.atlext.ATL.Unit self) { delegate.inUnit(self); }
		public void beforeUnit(anatlyzer.atlext.ATL.Unit self) { delegate.beforeUnit(self); }
		public void afterUnit(anatlyzer.atlext.ATL.Unit self)  { delegate.afterUnit(self); }
		public void inLibrary(anatlyzer.atlext.ATL.Library self) { delegate.inLibrary(self); }
		public void beforeLibrary(anatlyzer.atlext.ATL.Library self) { delegate.beforeLibrary(self); }
		public void afterLibrary(anatlyzer.atlext.ATL.Library self)  { delegate.afterLibrary(self); }
		public void inQuery(anatlyzer.atlext.ATL.Query self) { delegate.inQuery(self); }
		public void beforeQuery(anatlyzer.atlext.ATL.Query self) { delegate.beforeQuery(self); }
		public void afterQuery(anatlyzer.atlext.ATL.Query self)  { delegate.afterQuery(self); }
		public void inModule(anatlyzer.atlext.ATL.Module self) { delegate.inModule(self); }
		public void beforeModule(anatlyzer.atlext.ATL.Module self) { delegate.beforeModule(self); }
		public void afterModule(anatlyzer.atlext.ATL.Module self)  { delegate.afterModule(self); }
		public void inModuleElement(anatlyzer.atlext.ATL.ModuleElement self) { delegate.inModuleElement(self); }
		public void beforeModuleElement(anatlyzer.atlext.ATL.ModuleElement self) { delegate.beforeModuleElement(self); }
		public void afterModuleElement(anatlyzer.atlext.ATL.ModuleElement self)  { delegate.afterModuleElement(self); }
		public void inHelper(anatlyzer.atlext.ATL.Helper self) { delegate.inHelper(self); }
		public void beforeHelper(anatlyzer.atlext.ATL.Helper self) { delegate.beforeHelper(self); }
		public void afterHelper(anatlyzer.atlext.ATL.Helper self)  { delegate.afterHelper(self); }
		public void inStaticHelper(anatlyzer.atlext.ATL.StaticHelper self) { delegate.inStaticHelper(self); }
		public void beforeStaticHelper(anatlyzer.atlext.ATL.StaticHelper self) { delegate.beforeStaticHelper(self); }
		public void afterStaticHelper(anatlyzer.atlext.ATL.StaticHelper self)  { delegate.afterStaticHelper(self); }
		public void inContextHelper(anatlyzer.atlext.ATL.ContextHelper self) { delegate.inContextHelper(self); }
		public void beforeContextHelper(anatlyzer.atlext.ATL.ContextHelper self) { delegate.beforeContextHelper(self); }
		public void afterContextHelper(anatlyzer.atlext.ATL.ContextHelper self)  { delegate.afterContextHelper(self); }
		public void inRule(anatlyzer.atlext.ATL.Rule self) { delegate.inRule(self); }
		public void beforeRule(anatlyzer.atlext.ATL.Rule self) { delegate.beforeRule(self); }
		public void afterRule(anatlyzer.atlext.ATL.Rule self)  { delegate.afterRule(self); }
		public void inStaticRule(anatlyzer.atlext.ATL.StaticRule self) { delegate.inStaticRule(self); }
		public void beforeStaticRule(anatlyzer.atlext.ATL.StaticRule self) { delegate.beforeStaticRule(self); }
		public void afterStaticRule(anatlyzer.atlext.ATL.StaticRule self)  { delegate.afterStaticRule(self); }
		public void inModuleCallable(anatlyzer.atlext.ATL.ModuleCallable self) { delegate.inModuleCallable(self); }
		public void beforeModuleCallable(anatlyzer.atlext.ATL.ModuleCallable self) { delegate.beforeModuleCallable(self); }
		public void afterModuleCallable(anatlyzer.atlext.ATL.ModuleCallable self)  { delegate.afterModuleCallable(self); }
		public void inCallable(anatlyzer.atlext.ATL.Callable self) { delegate.inCallable(self); }
		public void beforeCallable(anatlyzer.atlext.ATL.Callable self) { delegate.beforeCallable(self); }
		public void afterCallable(anatlyzer.atlext.ATL.Callable self)  { delegate.afterCallable(self); }
		public void inRuleWithPattern(anatlyzer.atlext.ATL.RuleWithPattern self) { delegate.inRuleWithPattern(self); }
		public void beforeRuleWithPattern(anatlyzer.atlext.ATL.RuleWithPattern self) { delegate.beforeRuleWithPattern(self); }
		public void afterRuleWithPattern(anatlyzer.atlext.ATL.RuleWithPattern self)  { delegate.afterRuleWithPattern(self); }
		public void inMatchedRule(anatlyzer.atlext.ATL.MatchedRule self) { delegate.inMatchedRule(self); }
		public void beforeMatchedRule(anatlyzer.atlext.ATL.MatchedRule self) { delegate.beforeMatchedRule(self); }
		public void afterMatchedRule(anatlyzer.atlext.ATL.MatchedRule self)  { delegate.afterMatchedRule(self); }
		public void inLazyRule(anatlyzer.atlext.ATL.LazyRule self) { delegate.inLazyRule(self); }
		public void beforeLazyRule(anatlyzer.atlext.ATL.LazyRule self) { delegate.beforeLazyRule(self); }
		public void afterLazyRule(anatlyzer.atlext.ATL.LazyRule self)  { delegate.afterLazyRule(self); }
		public void inCalledRule(anatlyzer.atlext.ATL.CalledRule self) { delegate.inCalledRule(self); }
		public void beforeCalledRule(anatlyzer.atlext.ATL.CalledRule self) { delegate.beforeCalledRule(self); }
		public void afterCalledRule(anatlyzer.atlext.ATL.CalledRule self)  { delegate.afterCalledRule(self); }
		public void inInPattern(anatlyzer.atlext.ATL.InPattern self) { delegate.inInPattern(self); }
		public void beforeInPattern(anatlyzer.atlext.ATL.InPattern self) { delegate.beforeInPattern(self); }
		public void afterInPattern(anatlyzer.atlext.ATL.InPattern self)  { delegate.afterInPattern(self); }
		public void inOutPattern(anatlyzer.atlext.ATL.OutPattern self) { delegate.inOutPattern(self); }
		public void beforeOutPattern(anatlyzer.atlext.ATL.OutPattern self) { delegate.beforeOutPattern(self); }
		public void afterOutPattern(anatlyzer.atlext.ATL.OutPattern self)  { delegate.afterOutPattern(self); }
		public void inDropPattern(anatlyzer.atlext.ATL.DropPattern self) { delegate.inDropPattern(self); }
		public void beforeDropPattern(anatlyzer.atlext.ATL.DropPattern self) { delegate.beforeDropPattern(self); }
		public void afterDropPattern(anatlyzer.atlext.ATL.DropPattern self)  { delegate.afterDropPattern(self); }
		public void inPatternElement(anatlyzer.atlext.ATL.PatternElement self) { delegate.inPatternElement(self); }
		public void beforePatternElement(anatlyzer.atlext.ATL.PatternElement self) { delegate.beforePatternElement(self); }
		public void afterPatternElement(anatlyzer.atlext.ATL.PatternElement self)  { delegate.afterPatternElement(self); }
		public void inInPatternElement(anatlyzer.atlext.ATL.InPatternElement self) { delegate.inInPatternElement(self); }
		public void beforeInPatternElement(anatlyzer.atlext.ATL.InPatternElement self) { delegate.beforeInPatternElement(self); }
		public void afterInPatternElement(anatlyzer.atlext.ATL.InPatternElement self)  { delegate.afterInPatternElement(self); }
		public void inSimpleInPatternElement(anatlyzer.atlext.ATL.SimpleInPatternElement self) { delegate.inSimpleInPatternElement(self); }
		public void beforeSimpleInPatternElement(anatlyzer.atlext.ATL.SimpleInPatternElement self) { delegate.beforeSimpleInPatternElement(self); }
		public void afterSimpleInPatternElement(anatlyzer.atlext.ATL.SimpleInPatternElement self)  { delegate.afterSimpleInPatternElement(self); }
		public void inOutPatternElement(anatlyzer.atlext.ATL.OutPatternElement self) { delegate.inOutPatternElement(self); }
		public void beforeOutPatternElement(anatlyzer.atlext.ATL.OutPatternElement self) { delegate.beforeOutPatternElement(self); }
		public void afterOutPatternElement(anatlyzer.atlext.ATL.OutPatternElement self)  { delegate.afterOutPatternElement(self); }
		public void inSimpleOutPatternElement(anatlyzer.atlext.ATL.SimpleOutPatternElement self) { delegate.inSimpleOutPatternElement(self); }
		public void beforeSimpleOutPatternElement(anatlyzer.atlext.ATL.SimpleOutPatternElement self) { delegate.beforeSimpleOutPatternElement(self); }
		public void afterSimpleOutPatternElement(anatlyzer.atlext.ATL.SimpleOutPatternElement self)  { delegate.afterSimpleOutPatternElement(self); }
		public void inForEachOutPatternElement(anatlyzer.atlext.ATL.ForEachOutPatternElement self) { delegate.inForEachOutPatternElement(self); }
		public void beforeForEachOutPatternElement(anatlyzer.atlext.ATL.ForEachOutPatternElement self) { delegate.beforeForEachOutPatternElement(self); }
		public void afterForEachOutPatternElement(anatlyzer.atlext.ATL.ForEachOutPatternElement self)  { delegate.afterForEachOutPatternElement(self); }
		public void inBinding(anatlyzer.atlext.ATL.Binding self) { delegate.inBinding(self); }
		public void beforeBinding(anatlyzer.atlext.ATL.Binding self) { delegate.beforeBinding(self); }
		public void afterBinding(anatlyzer.atlext.ATL.Binding self)  { delegate.afterBinding(self); }
		public void inRuleVariableDeclaration(anatlyzer.atlext.ATL.RuleVariableDeclaration self) { delegate.inRuleVariableDeclaration(self); }
		public void beforeRuleVariableDeclaration(anatlyzer.atlext.ATL.RuleVariableDeclaration self) { delegate.beforeRuleVariableDeclaration(self); }
		public void afterRuleVariableDeclaration(anatlyzer.atlext.ATL.RuleVariableDeclaration self)  { delegate.afterRuleVariableDeclaration(self); }
		public void inLibraryRef(anatlyzer.atlext.ATL.LibraryRef self) { delegate.inLibraryRef(self); }
		public void beforeLibraryRef(anatlyzer.atlext.ATL.LibraryRef self) { delegate.beforeLibraryRef(self); }
		public void afterLibraryRef(anatlyzer.atlext.ATL.LibraryRef self)  { delegate.afterLibraryRef(self); }
		public void inActionBlock(anatlyzer.atlext.ATL.ActionBlock self) { delegate.inActionBlock(self); }
		public void beforeActionBlock(anatlyzer.atlext.ATL.ActionBlock self) { delegate.beforeActionBlock(self); }
		public void afterActionBlock(anatlyzer.atlext.ATL.ActionBlock self)  { delegate.afterActionBlock(self); }
		public void inStatement(anatlyzer.atlext.ATL.Statement self) { delegate.inStatement(self); }
		public void beforeStatement(anatlyzer.atlext.ATL.Statement self) { delegate.beforeStatement(self); }
		public void afterStatement(anatlyzer.atlext.ATL.Statement self)  { delegate.afterStatement(self); }
		public void inExpressionStat(anatlyzer.atlext.ATL.ExpressionStat self) { delegate.inExpressionStat(self); }
		public void beforeExpressionStat(anatlyzer.atlext.ATL.ExpressionStat self) { delegate.beforeExpressionStat(self); }
		public void afterExpressionStat(anatlyzer.atlext.ATL.ExpressionStat self)  { delegate.afterExpressionStat(self); }
		public void inBindingStat(anatlyzer.atlext.ATL.BindingStat self) { delegate.inBindingStat(self); }
		public void beforeBindingStat(anatlyzer.atlext.ATL.BindingStat self) { delegate.beforeBindingStat(self); }
		public void afterBindingStat(anatlyzer.atlext.ATL.BindingStat self)  { delegate.afterBindingStat(self); }
		public void inIfStat(anatlyzer.atlext.ATL.IfStat self) { delegate.inIfStat(self); }
		public void beforeIfStat(anatlyzer.atlext.ATL.IfStat self) { delegate.beforeIfStat(self); }
		public void afterIfStat(anatlyzer.atlext.ATL.IfStat self)  { delegate.afterIfStat(self); }
		public void inForStat(anatlyzer.atlext.ATL.ForStat self) { delegate.inForStat(self); }
		public void beforeForStat(anatlyzer.atlext.ATL.ForStat self) { delegate.beforeForStat(self); }
		public void afterForStat(anatlyzer.atlext.ATL.ForStat self)  { delegate.afterForStat(self); }
		public void inStringToStringMap(java.util.Map.Entry self) { delegate.inStringToStringMap(self); }
		public void beforeStringToStringMap(java.util.Map.Entry self) { delegate.beforeStringToStringMap(self); }
		public void afterStringToStringMap(java.util.Map.Entry self)  { delegate.afterStringToStringMap(self); }
		public void inCallableParameter(anatlyzer.atlext.ATL.CallableParameter self) { delegate.inCallableParameter(self); }
		public void beforeCallableParameter(anatlyzer.atlext.ATL.CallableParameter self) { delegate.beforeCallableParameter(self); }
		public void afterCallableParameter(anatlyzer.atlext.ATL.CallableParameter self)  { delegate.afterCallableParameter(self); }
		public void inRuleResolutionInfo(anatlyzer.atlext.ATL.RuleResolutionInfo self) { delegate.inRuleResolutionInfo(self); }
		public void beforeRuleResolutionInfo(anatlyzer.atlext.ATL.RuleResolutionInfo self) { delegate.beforeRuleResolutionInfo(self); }
		public void afterRuleResolutionInfo(anatlyzer.atlext.ATL.RuleResolutionInfo self)  { delegate.afterRuleResolutionInfo(self); }
		public void inOclExpression(anatlyzer.atlext.OCL.OclExpression self) { delegate.inOclExpression(self); }
		public void beforeOclExpression(anatlyzer.atlext.OCL.OclExpression self) { delegate.beforeOclExpression(self); }
		public void afterOclExpression(anatlyzer.atlext.OCL.OclExpression self)  { delegate.afterOclExpression(self); }
		public void inVariableExp(anatlyzer.atlext.OCL.VariableExp self) { delegate.inVariableExp(self); }
		public void beforeVariableExp(anatlyzer.atlext.OCL.VariableExp self) { delegate.beforeVariableExp(self); }
		public void afterVariableExp(anatlyzer.atlext.OCL.VariableExp self)  { delegate.afterVariableExp(self); }
		public void inSuperExp(anatlyzer.atlext.OCL.SuperExp self) { delegate.inSuperExp(self); }
		public void beforeSuperExp(anatlyzer.atlext.OCL.SuperExp self) { delegate.beforeSuperExp(self); }
		public void afterSuperExp(anatlyzer.atlext.OCL.SuperExp self)  { delegate.afterSuperExp(self); }
		public void inPrimitiveExp(anatlyzer.atlext.OCL.PrimitiveExp self) { delegate.inPrimitiveExp(self); }
		public void beforePrimitiveExp(anatlyzer.atlext.OCL.PrimitiveExp self) { delegate.beforePrimitiveExp(self); }
		public void afterPrimitiveExp(anatlyzer.atlext.OCL.PrimitiveExp self)  { delegate.afterPrimitiveExp(self); }
		public void inStringExp(anatlyzer.atlext.OCL.StringExp self) { delegate.inStringExp(self); }
		public void beforeStringExp(anatlyzer.atlext.OCL.StringExp self) { delegate.beforeStringExp(self); }
		public void afterStringExp(anatlyzer.atlext.OCL.StringExp self)  { delegate.afterStringExp(self); }
		public void inBooleanExp(anatlyzer.atlext.OCL.BooleanExp self) { delegate.inBooleanExp(self); }
		public void beforeBooleanExp(anatlyzer.atlext.OCL.BooleanExp self) { delegate.beforeBooleanExp(self); }
		public void afterBooleanExp(anatlyzer.atlext.OCL.BooleanExp self)  { delegate.afterBooleanExp(self); }
		public void inNumericExp(anatlyzer.atlext.OCL.NumericExp self) { delegate.inNumericExp(self); }
		public void beforeNumericExp(anatlyzer.atlext.OCL.NumericExp self) { delegate.beforeNumericExp(self); }
		public void afterNumericExp(anatlyzer.atlext.OCL.NumericExp self)  { delegate.afterNumericExp(self); }
		public void inRealExp(anatlyzer.atlext.OCL.RealExp self) { delegate.inRealExp(self); }
		public void beforeRealExp(anatlyzer.atlext.OCL.RealExp self) { delegate.beforeRealExp(self); }
		public void afterRealExp(anatlyzer.atlext.OCL.RealExp self)  { delegate.afterRealExp(self); }
		public void inIntegerExp(anatlyzer.atlext.OCL.IntegerExp self) { delegate.inIntegerExp(self); }
		public void beforeIntegerExp(anatlyzer.atlext.OCL.IntegerExp self) { delegate.beforeIntegerExp(self); }
		public void afterIntegerExp(anatlyzer.atlext.OCL.IntegerExp self)  { delegate.afterIntegerExp(self); }
		public void inCollectionExp(anatlyzer.atlext.OCL.CollectionExp self) { delegate.inCollectionExp(self); }
		public void beforeCollectionExp(anatlyzer.atlext.OCL.CollectionExp self) { delegate.beforeCollectionExp(self); }
		public void afterCollectionExp(anatlyzer.atlext.OCL.CollectionExp self)  { delegate.afterCollectionExp(self); }
		public void inBagExp(anatlyzer.atlext.OCL.BagExp self) { delegate.inBagExp(self); }
		public void beforeBagExp(anatlyzer.atlext.OCL.BagExp self) { delegate.beforeBagExp(self); }
		public void afterBagExp(anatlyzer.atlext.OCL.BagExp self)  { delegate.afterBagExp(self); }
		public void inOrderedSetExp(anatlyzer.atlext.OCL.OrderedSetExp self) { delegate.inOrderedSetExp(self); }
		public void beforeOrderedSetExp(anatlyzer.atlext.OCL.OrderedSetExp self) { delegate.beforeOrderedSetExp(self); }
		public void afterOrderedSetExp(anatlyzer.atlext.OCL.OrderedSetExp self)  { delegate.afterOrderedSetExp(self); }
		public void inSequenceExp(anatlyzer.atlext.OCL.SequenceExp self) { delegate.inSequenceExp(self); }
		public void beforeSequenceExp(anatlyzer.atlext.OCL.SequenceExp self) { delegate.beforeSequenceExp(self); }
		public void afterSequenceExp(anatlyzer.atlext.OCL.SequenceExp self)  { delegate.afterSequenceExp(self); }
		public void inSetExp(anatlyzer.atlext.OCL.SetExp self) { delegate.inSetExp(self); }
		public void beforeSetExp(anatlyzer.atlext.OCL.SetExp self) { delegate.beforeSetExp(self); }
		public void afterSetExp(anatlyzer.atlext.OCL.SetExp self)  { delegate.afterSetExp(self); }
		public void inTupleExp(anatlyzer.atlext.OCL.TupleExp self) { delegate.inTupleExp(self); }
		public void beforeTupleExp(anatlyzer.atlext.OCL.TupleExp self) { delegate.beforeTupleExp(self); }
		public void afterTupleExp(anatlyzer.atlext.OCL.TupleExp self)  { delegate.afterTupleExp(self); }
		public void inTuplePart(anatlyzer.atlext.OCL.TuplePart self) { delegate.inTuplePart(self); }
		public void beforeTuplePart(anatlyzer.atlext.OCL.TuplePart self) { delegate.beforeTuplePart(self); }
		public void afterTuplePart(anatlyzer.atlext.OCL.TuplePart self)  { delegate.afterTuplePart(self); }
		public void inMapExp(anatlyzer.atlext.OCL.MapExp self) { delegate.inMapExp(self); }
		public void beforeMapExp(anatlyzer.atlext.OCL.MapExp self) { delegate.beforeMapExp(self); }
		public void afterMapExp(anatlyzer.atlext.OCL.MapExp self)  { delegate.afterMapExp(self); }
		public void inMapElement(anatlyzer.atlext.OCL.MapElement self) { delegate.inMapElement(self); }
		public void beforeMapElement(anatlyzer.atlext.OCL.MapElement self) { delegate.beforeMapElement(self); }
		public void afterMapElement(anatlyzer.atlext.OCL.MapElement self)  { delegate.afterMapElement(self); }
		public void inEnumLiteralExp(anatlyzer.atlext.OCL.EnumLiteralExp self) { delegate.inEnumLiteralExp(self); }
		public void beforeEnumLiteralExp(anatlyzer.atlext.OCL.EnumLiteralExp self) { delegate.beforeEnumLiteralExp(self); }
		public void afterEnumLiteralExp(anatlyzer.atlext.OCL.EnumLiteralExp self)  { delegate.afterEnumLiteralExp(self); }
		public void inOclUndefinedExp(anatlyzer.atlext.OCL.OclUndefinedExp self) { delegate.inOclUndefinedExp(self); }
		public void beforeOclUndefinedExp(anatlyzer.atlext.OCL.OclUndefinedExp self) { delegate.beforeOclUndefinedExp(self); }
		public void afterOclUndefinedExp(anatlyzer.atlext.OCL.OclUndefinedExp self)  { delegate.afterOclUndefinedExp(self); }
		public void inPropertyCallExp(anatlyzer.atlext.OCL.PropertyCallExp self) { delegate.inPropertyCallExp(self); }
		public void beforePropertyCallExp(anatlyzer.atlext.OCL.PropertyCallExp self) { delegate.beforePropertyCallExp(self); }
		public void afterPropertyCallExp(anatlyzer.atlext.OCL.PropertyCallExp self)  { delegate.afterPropertyCallExp(self); }
		public void inNavigationOrAttributeCallExp(anatlyzer.atlext.OCL.NavigationOrAttributeCallExp self) { delegate.inNavigationOrAttributeCallExp(self); }
		public void beforeNavigationOrAttributeCallExp(anatlyzer.atlext.OCL.NavigationOrAttributeCallExp self) { delegate.beforeNavigationOrAttributeCallExp(self); }
		public void afterNavigationOrAttributeCallExp(anatlyzer.atlext.OCL.NavigationOrAttributeCallExp self)  { delegate.afterNavigationOrAttributeCallExp(self); }
		public void inOperationCallExp(anatlyzer.atlext.OCL.OperationCallExp self) { delegate.inOperationCallExp(self); }
		public void beforeOperationCallExp(anatlyzer.atlext.OCL.OperationCallExp self) { delegate.beforeOperationCallExp(self); }
		public void afterOperationCallExp(anatlyzer.atlext.OCL.OperationCallExp self)  { delegate.afterOperationCallExp(self); }
		public void inOperatorCallExp(anatlyzer.atlext.OCL.OperatorCallExp self) { delegate.inOperatorCallExp(self); }
		public void beforeOperatorCallExp(anatlyzer.atlext.OCL.OperatorCallExp self) { delegate.beforeOperatorCallExp(self); }
		public void afterOperatorCallExp(anatlyzer.atlext.OCL.OperatorCallExp self)  { delegate.afterOperatorCallExp(self); }
		public void inCollectionOperationCallExp(anatlyzer.atlext.OCL.CollectionOperationCallExp self) { delegate.inCollectionOperationCallExp(self); }
		public void beforeCollectionOperationCallExp(anatlyzer.atlext.OCL.CollectionOperationCallExp self) { delegate.beforeCollectionOperationCallExp(self); }
		public void afterCollectionOperationCallExp(anatlyzer.atlext.OCL.CollectionOperationCallExp self)  { delegate.afterCollectionOperationCallExp(self); }
		public void inLoopExp(anatlyzer.atlext.OCL.LoopExp self) { delegate.inLoopExp(self); }
		public void beforeLoopExp(anatlyzer.atlext.OCL.LoopExp self) { delegate.beforeLoopExp(self); }
		public void afterLoopExp(anatlyzer.atlext.OCL.LoopExp self)  { delegate.afterLoopExp(self); }
		public void inIterateExp(anatlyzer.atlext.OCL.IterateExp self) { delegate.inIterateExp(self); }
		public void beforeIterateExp(anatlyzer.atlext.OCL.IterateExp self) { delegate.beforeIterateExp(self); }
		public void afterIterateExp(anatlyzer.atlext.OCL.IterateExp self)  { delegate.afterIterateExp(self); }
		public void inIteratorExp(anatlyzer.atlext.OCL.IteratorExp self) { delegate.inIteratorExp(self); }
		public void beforeIteratorExp(anatlyzer.atlext.OCL.IteratorExp self) { delegate.beforeIteratorExp(self); }
		public void afterIteratorExp(anatlyzer.atlext.OCL.IteratorExp self)  { delegate.afterIteratorExp(self); }
		public void inLetExp(anatlyzer.atlext.OCL.LetExp self) { delegate.inLetExp(self); }
		public void beforeLetExp(anatlyzer.atlext.OCL.LetExp self) { delegate.beforeLetExp(self); }
		public void afterLetExp(anatlyzer.atlext.OCL.LetExp self)  { delegate.afterLetExp(self); }
		public void inIfExp(anatlyzer.atlext.OCL.IfExp self) { delegate.inIfExp(self); }
		public void beforeIfExp(anatlyzer.atlext.OCL.IfExp self) { delegate.beforeIfExp(self); }
		public void afterIfExp(anatlyzer.atlext.OCL.IfExp self)  { delegate.afterIfExp(self); }
		public void inVariableDeclaration(anatlyzer.atlext.OCL.VariableDeclaration self) { delegate.inVariableDeclaration(self); }
		public void beforeVariableDeclaration(anatlyzer.atlext.OCL.VariableDeclaration self) { delegate.beforeVariableDeclaration(self); }
		public void afterVariableDeclaration(anatlyzer.atlext.OCL.VariableDeclaration self)  { delegate.afterVariableDeclaration(self); }
		public void inIterator(anatlyzer.atlext.OCL.Iterator self) { delegate.inIterator(self); }
		public void beforeIterator(anatlyzer.atlext.OCL.Iterator self) { delegate.beforeIterator(self); }
		public void afterIterator(anatlyzer.atlext.OCL.Iterator self)  { delegate.afterIterator(self); }
		public void inParameter(anatlyzer.atlext.OCL.Parameter self) { delegate.inParameter(self); }
		public void beforeParameter(anatlyzer.atlext.OCL.Parameter self) { delegate.beforeParameter(self); }
		public void afterParameter(anatlyzer.atlext.OCL.Parameter self)  { delegate.afterParameter(self); }
		public void inCollectionType(anatlyzer.atlext.OCL.CollectionType self) { delegate.inCollectionType(self); }
		public void beforeCollectionType(anatlyzer.atlext.OCL.CollectionType self) { delegate.beforeCollectionType(self); }
		public void afterCollectionType(anatlyzer.atlext.OCL.CollectionType self)  { delegate.afterCollectionType(self); }
		public void inOclType(anatlyzer.atlext.OCL.OclType self) { delegate.inOclType(self); }
		public void beforeOclType(anatlyzer.atlext.OCL.OclType self) { delegate.beforeOclType(self); }
		public void afterOclType(anatlyzer.atlext.OCL.OclType self)  { delegate.afterOclType(self); }
		public void inPrimitive(anatlyzer.atlext.OCL.Primitive self) { delegate.inPrimitive(self); }
		public void beforePrimitive(anatlyzer.atlext.OCL.Primitive self) { delegate.beforePrimitive(self); }
		public void afterPrimitive(anatlyzer.atlext.OCL.Primitive self)  { delegate.afterPrimitive(self); }
		public void inStringType(anatlyzer.atlext.OCL.StringType self) { delegate.inStringType(self); }
		public void beforeStringType(anatlyzer.atlext.OCL.StringType self) { delegate.beforeStringType(self); }
		public void afterStringType(anatlyzer.atlext.OCL.StringType self)  { delegate.afterStringType(self); }
		public void inBooleanType(anatlyzer.atlext.OCL.BooleanType self) { delegate.inBooleanType(self); }
		public void beforeBooleanType(anatlyzer.atlext.OCL.BooleanType self) { delegate.beforeBooleanType(self); }
		public void afterBooleanType(anatlyzer.atlext.OCL.BooleanType self)  { delegate.afterBooleanType(self); }
		public void inNumericType(anatlyzer.atlext.OCL.NumericType self) { delegate.inNumericType(self); }
		public void beforeNumericType(anatlyzer.atlext.OCL.NumericType self) { delegate.beforeNumericType(self); }
		public void afterNumericType(anatlyzer.atlext.OCL.NumericType self)  { delegate.afterNumericType(self); }
		public void inIntegerType(anatlyzer.atlext.OCL.IntegerType self) { delegate.inIntegerType(self); }
		public void beforeIntegerType(anatlyzer.atlext.OCL.IntegerType self) { delegate.beforeIntegerType(self); }
		public void afterIntegerType(anatlyzer.atlext.OCL.IntegerType self)  { delegate.afterIntegerType(self); }
		public void inRealType(anatlyzer.atlext.OCL.RealType self) { delegate.inRealType(self); }
		public void beforeRealType(anatlyzer.atlext.OCL.RealType self) { delegate.beforeRealType(self); }
		public void afterRealType(anatlyzer.atlext.OCL.RealType self)  { delegate.afterRealType(self); }
		public void inBagType(anatlyzer.atlext.OCL.BagType self) { delegate.inBagType(self); }
		public void beforeBagType(anatlyzer.atlext.OCL.BagType self) { delegate.beforeBagType(self); }
		public void afterBagType(anatlyzer.atlext.OCL.BagType self)  { delegate.afterBagType(self); }
		public void inOrderedSetType(anatlyzer.atlext.OCL.OrderedSetType self) { delegate.inOrderedSetType(self); }
		public void beforeOrderedSetType(anatlyzer.atlext.OCL.OrderedSetType self) { delegate.beforeOrderedSetType(self); }
		public void afterOrderedSetType(anatlyzer.atlext.OCL.OrderedSetType self)  { delegate.afterOrderedSetType(self); }
		public void inSequenceType(anatlyzer.atlext.OCL.SequenceType self) { delegate.inSequenceType(self); }
		public void beforeSequenceType(anatlyzer.atlext.OCL.SequenceType self) { delegate.beforeSequenceType(self); }
		public void afterSequenceType(anatlyzer.atlext.OCL.SequenceType self)  { delegate.afterSequenceType(self); }
		public void inSetType(anatlyzer.atlext.OCL.SetType self) { delegate.inSetType(self); }
		public void beforeSetType(anatlyzer.atlext.OCL.SetType self) { delegate.beforeSetType(self); }
		public void afterSetType(anatlyzer.atlext.OCL.SetType self)  { delegate.afterSetType(self); }
		public void inOclAnyType(anatlyzer.atlext.OCL.OclAnyType self) { delegate.inOclAnyType(self); }
		public void beforeOclAnyType(anatlyzer.atlext.OCL.OclAnyType self) { delegate.beforeOclAnyType(self); }
		public void afterOclAnyType(anatlyzer.atlext.OCL.OclAnyType self)  { delegate.afterOclAnyType(self); }
		public void inTupleType(anatlyzer.atlext.OCL.TupleType self) { delegate.inTupleType(self); }
		public void beforeTupleType(anatlyzer.atlext.OCL.TupleType self) { delegate.beforeTupleType(self); }
		public void afterTupleType(anatlyzer.atlext.OCL.TupleType self)  { delegate.afterTupleType(self); }
		public void inTupleTypeAttribute(anatlyzer.atlext.OCL.TupleTypeAttribute self) { delegate.inTupleTypeAttribute(self); }
		public void beforeTupleTypeAttribute(anatlyzer.atlext.OCL.TupleTypeAttribute self) { delegate.beforeTupleTypeAttribute(self); }
		public void afterTupleTypeAttribute(anatlyzer.atlext.OCL.TupleTypeAttribute self)  { delegate.afterTupleTypeAttribute(self); }
		public void inOclModelElement(anatlyzer.atlext.OCL.OclModelElement self) { delegate.inOclModelElement(self); }
		public void beforeOclModelElement(anatlyzer.atlext.OCL.OclModelElement self) { delegate.beforeOclModelElement(self); }
		public void afterOclModelElement(anatlyzer.atlext.OCL.OclModelElement self)  { delegate.afterOclModelElement(self); }
		public void inMapType(anatlyzer.atlext.OCL.MapType self) { delegate.inMapType(self); }
		public void beforeMapType(anatlyzer.atlext.OCL.MapType self) { delegate.beforeMapType(self); }
		public void afterMapType(anatlyzer.atlext.OCL.MapType self)  { delegate.afterMapType(self); }
		public void inOclFeatureDefinition(anatlyzer.atlext.OCL.OclFeatureDefinition self) { delegate.inOclFeatureDefinition(self); }
		public void beforeOclFeatureDefinition(anatlyzer.atlext.OCL.OclFeatureDefinition self) { delegate.beforeOclFeatureDefinition(self); }
		public void afterOclFeatureDefinition(anatlyzer.atlext.OCL.OclFeatureDefinition self)  { delegate.afterOclFeatureDefinition(self); }
		public void inOclContextDefinition(anatlyzer.atlext.OCL.OclContextDefinition self) { delegate.inOclContextDefinition(self); }
		public void beforeOclContextDefinition(anatlyzer.atlext.OCL.OclContextDefinition self) { delegate.beforeOclContextDefinition(self); }
		public void afterOclContextDefinition(anatlyzer.atlext.OCL.OclContextDefinition self)  { delegate.afterOclContextDefinition(self); }
		public void inOclFeature(anatlyzer.atlext.OCL.OclFeature self) { delegate.inOclFeature(self); }
		public void beforeOclFeature(anatlyzer.atlext.OCL.OclFeature self) { delegate.beforeOclFeature(self); }
		public void afterOclFeature(anatlyzer.atlext.OCL.OclFeature self)  { delegate.afterOclFeature(self); }
		public void inAttribute(anatlyzer.atlext.OCL.Attribute self) { delegate.inAttribute(self); }
		public void beforeAttribute(anatlyzer.atlext.OCL.Attribute self) { delegate.beforeAttribute(self); }
		public void afterAttribute(anatlyzer.atlext.OCL.Attribute self)  { delegate.afterAttribute(self); }
		public void inOperation(anatlyzer.atlext.OCL.Operation self) { delegate.inOperation(self); }
		public void beforeOperation(anatlyzer.atlext.OCL.Operation self) { delegate.beforeOperation(self); }
		public void afterOperation(anatlyzer.atlext.OCL.Operation self)  { delegate.afterOperation(self); }
		public void inOclModel(anatlyzer.atlext.OCL.OclModel self) { delegate.inOclModel(self); }
		public void beforeOclModel(anatlyzer.atlext.OCL.OclModel self) { delegate.beforeOclModel(self); }
		public void afterOclModel(anatlyzer.atlext.OCL.OclModel self)  { delegate.afterOclModel(self); }
		public void inTypedElement(anatlyzer.atlext.OCL.TypedElement self) { delegate.inTypedElement(self); }
		public void beforeTypedElement(anatlyzer.atlext.OCL.TypedElement self) { delegate.beforeTypedElement(self); }
		public void afterTypedElement(anatlyzer.atlext.OCL.TypedElement self)  { delegate.afterTypedElement(self); }
		public void inResolveTempResolution(anatlyzer.atlext.OCL.ResolveTempResolution self) { delegate.inResolveTempResolution(self); }
		public void beforeResolveTempResolution(anatlyzer.atlext.OCL.ResolveTempResolution self) { delegate.beforeResolveTempResolution(self); }
		public void afterResolveTempResolution(anatlyzer.atlext.OCL.ResolveTempResolution self)  { delegate.afterResolveTempResolution(self); }
		public void inJavaBody(anatlyzer.atlext.OCL.JavaBody self) { delegate.inJavaBody(self); }
		public void beforeJavaBody(anatlyzer.atlext.OCL.JavaBody self) { delegate.beforeJavaBody(self); }
		public void afterJavaBody(anatlyzer.atlext.OCL.JavaBody self)  { delegate.afterJavaBody(self); }
		public void inGetAppliedStereotypesBody(anatlyzer.atlext.OCL.GetAppliedStereotypesBody self) { delegate.inGetAppliedStereotypesBody(self); }
		public void beforeGetAppliedStereotypesBody(anatlyzer.atlext.OCL.GetAppliedStereotypesBody self) { delegate.beforeGetAppliedStereotypesBody(self); }
		public void afterGetAppliedStereotypesBody(anatlyzer.atlext.OCL.GetAppliedStereotypesBody self)  { delegate.afterGetAppliedStereotypesBody(self); }
		
			
	}
		
}
