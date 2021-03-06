package a2l.compiler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import a2l.anatlyzerext.visitor.AbstractAnatlyzerExtVisitor;
import a2l.compiler.A2LOptimiser.Optimisation;
import a2l.compiler.OptimisationHints.IndexedValue;
import a2l.compiler.OptimisationHints.IndexedValue.IndexType;
import a2l.optimiser.anatlyzerext.AllInstancesIndexed;
import a2l.optimiser.anatlyzerext.AnatlyzerExtFactory;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import a2l.optimiser.anatlyzerext.ShortCircuitOperatorCallExp;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.graph.AbstractPathVisitor;
import anatlyzer.atl.graph.ForStatNode;
import anatlyzer.atl.graph.LoopNode;
import anatlyzer.atl.graph.PathGenerator;
import anatlyzer.atl.graph.ProblemPath;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.InPattern;
import anatlyzer.atlext.ATL.LocatedElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleResolutionInfo;
import anatlyzer.atlext.ATL.Unit;
import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LoopExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OCLFactory;
import anatlyzer.atlext.OCL.OCLPackage;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.ResolveTempResolution;
import anatlyzer.atlext.OCL.VariableExp;
import anatlyzer.atlext.processing.AbstractVisitor;
import linda.atlcompiler.LindaCompiler;

public class A2LOptimiser extends AbstractVisitor {

	public static enum Optimisation {
		REFERENCE_AS_SET,
		MUTABLE_COLLECTIONS,
		FOLD_ITERATOR,
		PATH_BASED_CACHING,
		
		RULE_OPTIMISATION_SORT_FILTERS, 
		RULE_OPTIMISATION_AVOID_UNUSED_TRACE,
		
		SHORT_CIRCUIT
	}
	
	private IAnalyserResult result;
	private HashSet<Optimisation> optimisations;
	private List<IReplacement> replacements = new ArrayList<>();
	
	public A2LOptimiser(IAnalyserResult result) {
		this.result = result;
		this.optimisations = new HashSet<>();
		// By default not optimisations
		// Collections.addAll(optimisations, Optimisation.values());
	}

	public A2LOptimiser withOptimisations(Optimisation... opts) {
		Collections.addAll(optimisations, opts);
		return this;
	}

	public A2LOptimiser withOptimisations(Set<? extends Optimisation> opts) {
		optimisations.addAll(opts);
		return this;
	}

	public boolean isEnabled(Optimisation opt) {
		return optimisations.contains(opt);
	}

	@Override
	public void inNavigationOrAttributeCallExp(NavigationOrAttributeCallExp self) {
		// TODO Auto-generated method stub
		super.inNavigationOrAttributeCallExp(self);
	}

	public OptimisationHints run() {
		startVisiting(result.getATLModel().getRoot());
		
		replacements.forEach(IReplacement::doReplacement);
		
		OptimisationHints hints;
		if ( isEnabled(Optimisation.PATH_BASED_CACHING) ) {
			// This is using a second pass
			hints = new PathDependenCachingOptimisation().run(result.getATLModel());
		} else {
			hints = new OptimisationHints(); // Empty
		}
		
		hints.addDependencyInfo(getDependencyInfo(result));
		
		return hints;
	}

	
	private Map<OutPatternElement, List<Rule>> getDependencyInfo(IAnalyserResult result) {
		ATLModel model = result.getATLModel();
		List<Rule> rules = model.allObjectsOf(Rule.class);
		Map<OutPatternElement, List<Rule>> deps = new HashMap<>();

		for (Rule r : rules) {
			for(OutPatternElement e : r.getOutPattern().getElements()) {
				for (Binding b : e.getBindings()) {
					for (RuleResolutionInfo rri : b.getResolvedBy()) {
						OutPatternElement ope = rri.getRule().getOutPattern().getElements().get(0);
						deps.computeIfAbsent(ope, k -> new ArrayList<>());
						deps.get(ope).add(r);
					}
										
					TreeIterator<EObject> it = b.getValue().eAllContents();
					while (it.hasNext()) {
						EObject obj = it.next();
						if (obj instanceof OperationCallExp) {
							OperationCallExp op = (OperationCallExp) obj;
							if ("resolveTemp".equals(op.getOperationName())) {
								for (ResolveTempResolution rr : op.getResolveTempResolvedBy()) {
									OutPatternElement ope = rr.getElement();
									deps.computeIfAbsent(ope, k -> new ArrayList<>());
									deps.get(ope).add(r);
								}
							}
						}
					}
				}
			}
		}
				
		return deps;
	}
	
	private static final Set<String> shortcircuits = new HashSet<String>();
	static {
		shortcircuits.add("or");
		shortcircuits.add("and");
	}
	
	@Override
	public void inOperatorCallExp(OperatorCallExp self) {
		if (! shortcircuits.contains(self.getOperationName()))
			return;		
		
		replacements.add(() -> {		
			ShortCircuitOperatorCallExp operator = AnatlyzerExtFactory.eINSTANCE.createShortCircuitOperatorCallExp();
			operator.setOperationName(self.getOperationName());
			
			EcoreUtil.replace(self, operator);
			
			operator.setSource(self.getSource());
			operator.getArguments().addAll(self.getArguments());
			operator.setInferredType(self.getInferredType());
			operator.setFileLocation(self.getFileLocation());
			operator.setNoCastedType(self.getNoCastedType());
		});
	}

	@Override
	public void inCollectionOperationCallExp(CollectionOperationCallExp self) {
		// Do not execute this optimisation, it fails for findCouples
		if ( isEnabled(Optimisation.REFERENCE_AS_SET) ) { 
			// obj.property->asSet
			if ( isAsSet(self) && isReferenceAccess(self.getSource()) ) {
				NavigationOrAttributeCallExp nav = (NavigationOrAttributeCallExp) self.getSource();
				
				NavRefAsSet navSet = AnatlyzerExtFactory.eINSTANCE.createNavRefAsSet();
				navSet.setName(nav.getName());
				navSet.setSource(nav.getSource());
				navSet.setInferredType(self.getInferredType());
				navSet.setUsedFeature(nav.getUsedFeature());
				
				EcoreUtil.replace(self, navSet);
			}
		}
		
		if ( isEnabled(Optimisation.FOLD_ITERATOR) ) {			
			// select->...->size()
			if ( self.getOperationName().equals("size")) {
				List<OclExpression> chainList = getSourceChain(self);
				LinkedList<IteratorExp> selects = new LinkedList<IteratorExp>();
				LinkedList<OclExpression> rest    = new LinkedList<OclExpression>();
				
				computeStartingIterator(chainList, "select", selects, rest);
				
				if ( selects.size() > 0 ) {
					// Apply the optimisation
					
					// We know it is safe not to convert the source to a immutable var
					rest.forEach(AstAnnotations::markMutable);
					
					IteratorExp originalSelect = selects.getLast();
					Iterator originalIterator = originalSelect.getIterators().get(0);
					
					IteratorChainExp chain = AnatlyzerExtFactory.eINSTANCE.createIteratorChainExp();
					chain.setName("select-count");
					chain.setIterator(originalIterator);
					chain.setSource(rest.getFirst());
					
					addToChain(selects, originalIterator, chain.getChain());					
					//addToChain(selects, originalSelect.getIterators().get(0), chain.getChain());					
				
					EcoreUtil.replace(self, chain);
					
					optimisationApplied(self, Optimisation.FOLD_ITERATOR);
				}
			}  else if ( self.getOperationName().equals("flatten") ) {
				// Detect [select]->collect->collect->flatten->[asSet]
				List<OclExpression> chainList = getSourceChain(self);
				LinkedList<IteratorExp> selects = new LinkedList<IteratorExp>();
				LinkedList<IteratorExp> collects = new LinkedList<IteratorExp>();
				LinkedList<OclExpression> rest0    = new LinkedList<OclExpression>();
				LinkedList<OclExpression> rest    = new LinkedList<OclExpression>();
				
				computeStartingIterator(chainList, "collect", collects, rest0);				
				computeStartingIterator(rest0, "select", selects, rest);
				
				if ( collects.size() > 0 ) {
					// The source is mutable
					rest0.forEach(AstAnnotations::markMutable);
					rest.forEach(AstAnnotations::markMutable);
					
					IteratorExp original = selects.isEmpty() ? (IteratorExp) collects.getFirst() : selects.getLast();
					
					IteratorChainExp chain = AnatlyzerExtFactory.eINSTANCE.createIteratorChainExp();
					chain.setName("collect-flatten");
					chain.setIterator(original.getIterators().get(0));
					chain.setSource(rest.getFirst());
					
					// TODO: if it complemented by asSet, then change the inferred type
					chain.setInferredType(self.getInferredType());
					
					EcoreUtil.replace(self, chain);
					
					// All iterator variables point now to the same location
					addToChain(selects, chain.getIterator(), chain.getPreChain());					
					
					List<IteratorExp> firstCollect = Collections.singletonList((IteratorExp) collects.get(0));
					MutableCollectionOptimiser optimiser = new MutableCollectionOptimiser();
					optimiser.tryOptimise(firstCollect.get(0).getBody(), true);
					addToChain(firstCollect, chain.getIterator(), chain.getChain());
				
					for(int i = 1; i < collects.size(); i++) {
						// May I need the iterator here?
						IteratorExp aCollect = (IteratorExp) collects.get(i);
						IteratorChainElement chainCollect = AnatlyzerExtFactory.eINSTANCE.createIteratorChainElement();
						chainCollect.setIterator(aCollect.getIterators().get(0));
						chainCollect.setBody(aCollect.getBody());					
						
						// TODO: If this doesn't succeed in optimising the body then we need a conversion toList to allow addAll
						optimiser.tryOptimise(aCollect.getBody(), true);
					}
					
				
					optimisationApplied(self, Optimisation.FOLD_ITERATOR);
				} 
			}
			
		}
		
	}

	private void computeStartingIterator(List<OclExpression> chainList, String iteratorName, List<IteratorExp> selects, List<OclExpression> rest) {
		for (OclExpression exp : chainList) {
			if ( isIteratorExp(exp, iteratorName) ) {
				// Must be at the beginning
				if ( rest.size() != 0 ) {
					break;
				}
				selects.add((IteratorExp) exp);
			} else {
				rest.add(exp);
			}
		}
	}

	private static void optimisationApplied(OclExpression self, Optimisation opt) {
		System.out.println("Applied " + opt + " over " + self);
	}

	private boolean isReferenceAccess(OclExpression source) {
		if ( source instanceof NavigationOrAttributeCallExp ) {
			return ((NavigationOrAttributeCallExp) source).getUsedFeature() instanceof EReference;
		}
		return false;
	}

	private boolean isAsSet(CollectionOperationCallExp self) {
		return self.getOperationName().equals("asSet");
	}
	
	

	///
	/// Mutable collection
	///
	/// The idea here is to find a point in the AST in which the expression doesn't escape
	/// and thus it is fine to use mutable collection
	/// To be on the safe side, if there is a let or iterate expressions we don't apply the optimisation
	
	@Override
	public void inBinding(Binding self) {
		if ( isEnabled(Optimisation.MUTABLE_COLLECTIONS) ) {
			MutableCollectionOptimiser optimiser = new MutableCollectionOptimiser();
			optimiser.tryOptimise(self.getValue());
		}
	}
	
	// TODO: This can be done better by iterating over all sub-expressions and finding the largest expression
	// in which the optimisation is applicable
	@Override
	public void inInPattern(InPattern self) {
		if ( isEnabled(Optimisation.MUTABLE_COLLECTIONS) ) {
			if ( self.getFilter() != null ) { 
				MutableCollectionOptimiser optimiser = new MutableCollectionOptimiser();
				optimiser.tryOptimise(self.getFilter());
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void inIteratorExp(IteratorExp self) {
		if ( isEnabled(Optimisation.FOLD_ITERATOR) ) {
			// Pattern: select1->...->select2->collect3->...collect4		
			if (self.getName().equals("collect")) {
				EObject container = self.eContainer();
				if (container instanceof IteratorExp && ((IteratorExp) container).getName().equals("collect"))
					return;
				
				
				// For the pattern above, This gives: collect3, select2, select1, {sources-of-the-last-select}
				List<OclExpression> chainList = getSourceChain(self);
				chainList.add(0, self);
				ArrayList<IteratorExp> selects = new ArrayList<IteratorExp>();
				ArrayList<IteratorExp> collects = new ArrayList<IteratorExp>();
				ArrayList<OclExpression> rest0    = new ArrayList<OclExpression>();
				ArrayList<OclExpression> rest    = new ArrayList<OclExpression>();
				
				computeStartingIterator(chainList, "collect", collects, rest0); // collects = collect3, rest0 = select2, select1, {sources-of-the-last-select} 
				computeStartingIterator(rest0, "select", selects, rest); // selects = select2, select1 | rest = {sources-of-the-last-select}
				if (selects.isEmpty())
					return;
				
				// The source is mutable
				rest0.forEach(AstAnnotations::markMutable);
				rest.forEach(AstAnnotations::markMutable);
				
				IteratorExp original = collects.isEmpty() ? (IteratorExp) selects.get(0) : collects.get(collects.size() - 1);
								
				IteratorChainExp chain = AnatlyzerExtFactory.eINSTANCE.createIteratorChainExp();
				chain.setName("select-collect");
				chain.setIterator(original.getIterators().get(0));
				chain.setSource(rest.get(0));

				chain.setInferredType(self.getInferredType());
				
				EcoreUtil.replace(self, chain);
				
				// All iterator variables point now to the same location
				addToChain(selects, chain.getIterator(), chain.getPreChain());					

				// This is similar to select-collect-flatten
				List<IteratorExp> firstCollect = Collections.singletonList((IteratorExp) collects.get(collects.size() - 1));
				MutableCollectionOptimiser optimiser = new MutableCollectionOptimiser();
				optimiser.tryOptimise(firstCollect.get(0).getBody(), true);
				addToChain(firstCollect, chain.getIterator(), chain.getChain());
			
				for(int i = collects.size() - 2; i >= 0 ; i--) {
					// May I need the iterator here?
					IteratorExp aCollect = (IteratorExp) collects.get(i);
					
					optimiser.tryOptimise(aCollect.getBody(), true);
					//addToChain(Collections.singletonList(aCollect), chain.getIterator(), chain.getChain());

					IteratorChainElement chainCollect = AnatlyzerExtFactory.eINSTANCE.createIteratorChainElement();
					chainCollect.setIterator(aCollect.getIterators().get(0));
					chainCollect.setBody(aCollect.getBody());					
					
					chain.getChain().add(chainCollect);
					
					// TODO: If this doesn't succeed in optimising the body then we need a conversion toList to allow addAll
				}
				
			
				optimisationApplied(self, Optimisation.FOLD_ITERATOR);							
			} 			
			// Pattern: select()->exist()
			else if ( self.getName().equals("exists") ) {
				if ( self.getSource() instanceof IteratorExp && ((IteratorExp) self.getSource()).getName().equals("select")) {
					IteratorExp selectIteratorExp = (IteratorExp) self.getSource();
					
					// We know it is safe not to convert the source to a immutable var
					AstAnnotations.markMutable(selectIteratorExp.getSource());					
					
					// This is mutable by default, no problem here, we don't return a collection
					IteratorChainExp chain = AnatlyzerExtFactory.eINSTANCE.createIteratorChainExp();
					chain.setName("select-exists");
					chain.setSource(selectIteratorExp.getSource());
					
					EcoreUtil.replace(self, chain);
					
					// Take the select iterator
					Iterator it = selectIteratorExp.getIterators().get(0);
					chain.setIterator(it);
					
					// Point the variableExps to the same iterator
					OclExpression existsBody = replaceIteratorVariable(self, it);
					
					IteratorChainElement select = AnatlyzerExtFactory.eINSTANCE.createIteratorChainElement();
					select.setBody(selectIteratorExp.getBody());
					IteratorChainElement exists = AnatlyzerExtFactory.eINSTANCE.createIteratorChainElement();
					exists.setBody(existsBody);
					
					
					chain.getChain().add(select);
					chain.getChain().add(exists);		
					
					optimisationApplied(self, Optimisation.FOLD_ITERATOR);
					
				}			
			}
			
			
		}
	}

	private void addToChain(List<? extends IteratorExp> iteratorsToAdd, Iterator sourceIterator, List<IteratorChainElement> chain) {
		for (IteratorExp itExp : iteratorsToAdd) {
			replaceIteratorVariable(itExp, sourceIterator);	
		
			IteratorChainElement aSelect = AnatlyzerExtFactory.eINSTANCE.createIteratorChainElement();
			aSelect.setName(itExp.getName());
			aSelect.setBody(itExp.getBody());
			
			chain.add(aSelect);
		}
	}

	private OclExpression replaceIteratorVariable(IteratorExp self, Iterator it) {
		OclExpression body = self.getBody();
		for (VariableExp variableExp : ATLUtils.findAllVarExp(body)) {
			// First condition may happen in the iterator has already been stolen
			if ( self.getIterators().size() > 0 && variableExp.getReferredVariable() == self.getIterators().get(0) ) {
				variableExp.setReferredVariable(it);
			}
		}
		return body;
	}
	
	private boolean isIteratorExp(OclExpression exp, String name) {
		return exp instanceof IteratorExp && ((IteratorExp) exp).getName().equals(name);
	}

	public List<OclExpression> getSourceChain(PropertyCallExp exp) {
		ArrayList<OclExpression> chain = new ArrayList<OclExpression>();
		OclExpression src = exp.getSource();
		while ( src instanceof PropertyCallExp ) {
			chain.add(src);
			src = ((PropertyCallExp) src).getSource();
		}
		chain.add(src);
		return chain;
	}
	
	
	public static class MutableCollectionOptimiser extends AbstractVisitor {
		List<IReplacement> replacements = new ArrayList<>();
		private boolean optimisationPossible = true;
		private boolean safeBodyExpression;

		public boolean tryOptimise(OclExpression value) {
			return tryOptimise(value, false);
		}
	
		public boolean tryOptimise(OclExpression value, boolean safeBodyExpression) {
			this.optimisationPossible = true;
			this.safeBodyExpression = safeBodyExpression;
			startVisiting(value);
			if ( optimisationPossible  ) {
				replacements.forEach(IReplacement::doReplacement);
				
				if ( replacements.size() > 0 ) {
					optimisationApplied(value, Optimisation.MUTABLE_COLLECTIONS);
				}
			}
			
			return replacements.size() > 0;
		}
		
		@Override
		protected void unknownClassOf(EObject obj) {
			// Do nothing
		}
		
		@Override
		public void inIteratorExp(IteratorExp self) {
			if ( checkNonOptimisable(self) ) 
				return;
			
			add(self, (_obj) -> {
				MutableIteratorExp mIterator = AnatlyzerExtFactory.eINSTANCE.createMutableIteratorExp();
				mIterator.setName(self.getName());
				mIterator.setBody(self.getBody());
				mIterator.getIterators().addAll(self.getIterators());
				mIterator.setSource(self.getSource());
				mIterator.setInferredType(self.getInferredType());
				mIterator.setImplicitlyCasted(self.isImplicitlyCasted());
				return mIterator;
			});
		}
		
		/**
		 * A expression should not cross "boundaries" like: 
		 *    function(expr)
		 *    return value
		 *    let
		 *    iterate
		 */
		private boolean checkNonOptimisable(OclExpression self) {
			if (safeBodyExpression)
				return false;
			
			EStructuralFeature f = self.eContainingFeature();
			boolean nonoptimisable = 
					f == OCLPackage.Literals.OPERATION_CALL_EXP__ARGUMENTS || 
					f == OCLPackage.Literals.OPERATION__BODY ||
					f == OCLPackage.Literals.ATTRIBUTE__INIT_EXPRESSION ||
					f == OCLPackage.Literals.VARIABLE_DECLARATION__INIT_EXPRESSION;
			if ( nonoptimisable ) 
				this.optimisationPossible = false;
			return nonoptimisable;
		}

		@Override
		public void inNavigationOrAttributeCallExp(NavigationOrAttributeCallExp self) {
			if ( self.getInferredType() instanceof CollectionType ) {
				add(new MutationAnnotationReplacement(self));
			}
		}
		
		private void add(EObject source, Function<EObject, EObject> replacement) {
			this.replacements.add(new Replacement(source, replacement));
		}

		private void add(MutationAnnotationReplacement r) {
			this.replacements.add(r);
		}

	}
	
	public static interface IReplacement {
		public void doReplacement();
	}
	
	public static class Replacement implements IReplacement {
		private EObject source;
		private Function<EObject, EObject> setup;

		public Replacement(EObject source, Function<EObject, EObject> setup) {
			this.source = source;
			this.setup  = setup;
		}
		
		public void doReplacement() {
			EObject target = setup.apply(source);
			EcoreUtil.replace(source, target);
		}
	}
	
	public static class MutationAnnotationReplacement implements IReplacement {
		private LocatedElement source;

		public MutationAnnotationReplacement(LocatedElement source) {
			this.source = source;
		}
		
		@Override
		public void doReplacement() {
			AstAnnotations.markMutable(source);		
		}
	}

	
	// Other optimisation
	// This is for path-based caching
	public static class PathDependenCachingOptimisation extends AbstractAnatlyzerExtVisitor {

		//private HashSet<OclExpression> hotspots = new HashSet<OclExpression>();
				
		public OptimisationHints run(ATLModel model) {
			OptimisationHints hints = new OptimisationHints();		
			findHotspots(model, hints);			
			return hints;
		}
		
		private boolean containsHeavyOperation(OclExpression expr) {
			return ATLUtils.findElement(expr, (e) -> e instanceof NavRefAsSet || e instanceof IteratorChainExp).isPresent();
		}

		/**
		 * If we have a basic hot-spot like obj.feature, we try to expand it
		 * to e.g., obj.feature->select->... because we know that the result of the
		 * expression will always be the same because it starts with the same feature.
		 * 
		 * There are constraints, like the operations involved can't have parameters or
		 * the closures can't have cross references to external variables.
		 */
		private OclExpression getMaximalExpression(OclExpression exp) {
			if ( exp.eContainingFeature() == OCLPackage.Literals.PROPERTY_CALL_EXP__SOURCE ) {
				OclExpression c = (OclExpression) exp.eContainer();
				if ( c instanceof OperationCallExp && ((OperationCallExp) c).getArguments().isEmpty()) {				
					return getMaximalExpression(c);
				} else if ( c instanceof NavigationOrAttributeCallExp ) {
					return getMaximalExpression(c);
				} else if ( c instanceof IteratorExp ) {
					List<VariableExp> vars = ATLUtils.findAllVarExp( ((IteratorExp) c).getBody() );
					if ( vars.isEmpty() ) {
						return getMaximalExpression(c);
					}
				}				
			}			
			return exp;
		}

		private void findHotspots(ATLModel model, OptimisationHints hints) {
			HashSet<OperationCallExp> allInstancesAlreadyHandled = new HashSet<OperationCallExp>();
			
			List<NavigationOrAttributeCallExp> navs = model.allObjectsOf(NavigationOrAttributeCallExp.class);
			for (NavigationOrAttributeCallExp nav : navs) {
				EStructuralFeature f = (EStructuralFeature) nav.getUsedFeature();
				if ( f != null && f.isMany() && f instanceof EReference ) { //&& ((EReference) f).getEOpposite() != null ) {
					// Construct a path
					ProblemPath path = new PathGenerator().generatePath(nav);
					boolean hasLoops = new LoopFinder().hasLoops(path);
				
					if ( hasLoops )	{
						OclExpression oclExpression = nav.getSource();
						OclExpression maximalExpression = getMaximalExpression(oclExpression);
						if ( LindaCompiler.countExpressionNodes(maximalExpression) > 2 || containsHeavyOperation(maximalExpression)) {
							hints.addHotspot(new OptimisationHints.CachedValue(maximalExpression, oclExpression));
							AstAnnotations.markCacheable(maximalExpression);			
						}						
					}
				} else if (f != null && !f.isMany() && f instanceof EAttribute ) {
					// Tries to find comparision that can be optimised with a hashmap
					// X.allInstances()->select(x | x.name = <value>)  => hashMap
					// X.allInstances()->exists(x | x.name = <value>)  => set
					
					if ( nav.eContainer() instanceof OperatorCallExp && ((OperationCallExp) nav.eContainer()).getOperationName().equals("=")) {
						OperationCallExp operatorCall = (OperationCallExp) nav.eContainer();
						if (!(operatorCall.eContainingFeature() == OCLPackage.Literals.LOOP_EXP__BODY) || !(operatorCall.eContainer() instanceof IteratorExp)) {
							continue;
						}
						
						IteratorExp loop = (IteratorExp) operatorCall.eContainer();
						if (!(loop.getName().equals("select") || loop.getName().equals("exists"))) 
							continue;
						
						if (!(loop.getSource() instanceof OperationCallExp && ((OperationCallExp) loop.getSource()).getOperationName().equals("allInstances"))) {
							continue;
						}
						
						// At this point we know that it has the allInstances()->select/exists(x| <operator>) structure
						
						List<VariableExp> sourceVars = ATLUtils.findAllVarExp(operatorCall.getSource());
						List<VariableExp> argVars = ATLUtils.findAllVarExp(operatorCall.getArguments().get(0));
						int source_pointing = 0;
						int arg_pointing = 0;
						
						for (VariableExp variableExp : sourceVars) {
							if (variableExp.getReferredVariable() != loop.getIterators().get(0)) {
								source_pointing = -1;
								break;
							} else {
								source_pointing++;
							}
						}
						
						for (VariableExp variableExp : argVars) {
							if (variableExp.getReferredVariable() != loop.getIterators().get(0)) {
								arg_pointing = -1;
								break;
							} else {
								arg_pointing++;
							}
						}
						
						OclExpression preprocessedKeyExp;
						OclExpression dynamicKeyExp;
						if (source_pointing <= 0 && arg_pointing <= 0) {
							// Nothing is pointing to the allInstances variable
							continue;
						} else if (source_pointing > 0 && arg_pointing > 0) {
							// We can't handle this
							continue;
						} else if (source_pointing > 0) {
							preprocessedKeyExp = operatorCall.getSource();
							dynamicKeyExp = operatorCall.getArguments().get(0);
						} else if (arg_pointing > 0) {
							preprocessedKeyExp = operatorCall.getArguments().get(0);
							dynamicKeyExp = operatorCall.getSource();
						} else {
							// fallback
							continue;
						}

						OperationCallExp allInstances = ((OperationCallExp) loop.getSource());	
						if (!(allInstances.getSource() instanceof OclModelElement))
							continue;
						
						if (allInstancesAlreadyHandled.contains(allInstances))
							continue;

						ProblemPath path = new PathGenerator().generatePath(allInstances);
						boolean hasLoops = new LoopFinder().hasLoops(path);
						if (hasLoops) {
							// This structure is in a hotpath, so we optimise							
							OclModelElement elem = (OclModelElement) allInstances.getSource();
							Metaclass m = (Metaclass) elem.getInferredType();
							IndexType type = loop.getName().equals("select") ? IndexType.MAP_LIST : IndexType.SET;
							IndexedValue hint = new OptimisationHints.IndexedValue(type, allInstances, preprocessedKeyExp, dynamicKeyExp, m, nav.getName());
							hints.addHotspot(hint);
							allInstancesAlreadyHandled.add(allInstances);
							
							AllInstancesIndexed newAllInstances = AnatlyzerExtFactory.eINSTANCE.createAllInstancesIndexed();
							EcoreUtil.replace(loop, newAllInstances);
							newAllInstances.setOriginal(loop);
							newAllInstances.setOptimisationHint(hint);
							newAllInstances.setIndexType(loop.getName());
						}

					}						
					
				}
				
				
			}			
		}		
	}
	
	public static class LoopFinder extends AbstractPathVisitor {
		private boolean hasLoops = false;

		public boolean hasLoops(ProblemPath path) {
			this.bottomUp(path);
			return hasLoops;
		}
		
		@Override
		public boolean visit(LoopNode node) {
			hasLoops = true;
			return false;
		}
		
		@Override
		public boolean visit(ForStatNode node) {
			hasLoops = true;
			return false;
		}
	}
	
}

