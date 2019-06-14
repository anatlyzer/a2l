package linda.atlcompiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import a2l.anatlyzerext.visitor.AbstractAnatlyzerExtVisitor;
import a2l.compiler.ATLExtSerializer;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.TypesFactory;
import anatlyzer.atl.util.ATLCopier;
import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.Pair;
import anatlyzer.atlext.ATL.ATLFactory;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.CalledRule;
import anatlyzer.atlext.ATL.ForEachOutPatternElement;
import anatlyzer.atlext.ATL.InPattern;
import anatlyzer.atlext.ATL.LazyRule;
import anatlyzer.atlext.ATL.OutPattern;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleVariableDeclaration;
import anatlyzer.atlext.ATL.SimpleInPatternElement;
import anatlyzer.atlext.ATL.SimpleOutPatternElement;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.OCLFactory;
import anatlyzer.atlext.OCL.OclType;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.Parameter;
import anatlyzer.atlext.OCL.SequenceType;
import anatlyzer.atlext.OCL.VariableDeclaration;
import anatlyzer.atlext.OCL.VariableExp;
import anatlyzer.atlext.processing.AbstractVisitor;

public class NormalizeForEachPattern extends AbstractAnatlyzerExtVisitor {

	private ATLModel model;
	private ArrayList<EObject> toDelete;
	private ArrayList<CalledRule> toAdd0;
	private ArrayList<Pair<Rule, RuleVariableDeclaration>> toAdd;
	
	public NormalizeForEachPattern(ATLModel model) {
		this.model = model;
		this.toDelete = new ArrayList<EObject>();
		this.toAdd0   = new ArrayList<>();
		this.toAdd    = new ArrayList<>();
	}
	
	public void perform() {
		startVisiting(model.getModule());
		toDelete.forEach(o -> EcoreUtil.delete(o));
		toAdd.forEach(p -> p._1.getVariables().add(p._2));
		toAdd0.forEach(r -> model.getModule().getElements().add(r));
		
		System.out.println("NORMALIZATION");
		System.out.println("--------------");
		System.out.println(ATLExtSerializer.serialize(model.getModule()));
	}

	@Override
	public void inForEachOutPatternElement(ForEachOutPatternElement self) {
		Rule r = ATLUtils.getContainer(self, Rule.class);
	
		// Create called rule
		CalledRule lazyRule = ATLFactory.eINSTANCE.createCalledRule();
		lazyRule.setName("foreach_pattern" + r.getName() + "_" + self.getVarName());
		
		Parameter sip = OCLFactory.eINSTANCE.createParameter();;
		sip.setType( ATLUtils.getOclType(self.getIterator().getInferredType()) );
		sip.setVarName( self.getIterator().getVarName() );
		sip.setInferredType(self.getIterator().getInferredType());
		
		lazyRule.getParameters().add(sip);
		
		Set<VariableDeclaration> externalVars = self.getBindings().stream().flatMap(b -> {
			return ATLUtils.findAllVarExp(b.getValue()).stream().
					map(v -> v.getReferredVariable()).
					filter(v -> v != self.getIterator()).
					filter(v -> ! EcoreUtil.isAncestor(self, v)).
					filter(v -> ! v.getVarName().equals("thisModule"));
		}).collect(Collectors.toSet());
		
		HashMap<VariableDeclaration, Parameter> varMapping = new HashMap<VariableDeclaration, Parameter>();
		for (VariableDeclaration vd : externalVars) {
			Parameter p = OCLFactory.eINSTANCE.createParameter();;
			p.setType( ATLUtils.getOclType(vd.getInferredType()) );
			p.setVarName( vd.getVarName() );			
			lazyRule.getParameters().add(p);
			
			varMapping.put(vd, p);
		}
		
		OutPattern outPat = ATLFactory.eINSTANCE.createOutPattern();
		SimpleOutPatternElement sope = ATLFactory.eINSTANCE.createSimpleOutPatternElement();
		outPat.getElements().add(sope);
		sope.setVarName(self.getVarName());
		sope.setType( (OclType) ATLCopier.copySingleElement(self.getType()) );
		sope.setInferredType(self.getType().getInferredType());
		lazyRule.setOutPattern(outPat);
		
		List<Binding> newBindings = self.getBindings().stream().map(b -> {
			return (Binding) new ATLCopier(b).
				bind(self.getIterator(), sip).
				bindAll(varMapping).
				copy();			
		}).collect(Collectors.toList());
		
		sope.getBindings().addAll(newBindings);
		
		toAdd0.add(lazyRule);
		
		// Create variable declaration		
		RuleVariableDeclaration var = ATLFactory.eINSTANCE.createRuleVariableDeclaration();
		var.setVarName(self.getVarName());
		SequenceType seqType = OCLFactory.eINSTANCE.createSequenceType();
		
		anatlyzer.atl.types.SequenceType seqTypeInferred = TypesFactory.eINSTANCE.createSequenceType();
		seqTypeInferred.setContainedType( self.getType().getInferredType() );
		seqTypeInferred.setMultivalued(true);
		
		seqType.setInferredType(seqTypeInferred);
		seqType.setElementType( (OclType) ATLCopier.copySingleElement(self.getType()) );
		var.setType( seqType );
		
		IteratorExp collectExp = OCLFactory.eINSTANCE.createIteratorExp();
		collectExp.setSource( self.getCollection() );
		collectExp.setName("collect");
		collectExp.setInferredType( seqTypeInferred );
		
		Iterator it = OCLFactory.eINSTANCE.createIterator();
		it.setInferredType( self.getIterator().getInferredType() );
		it.setVarName("_it4distinct_");
		collectExp.getIterators().add(it);
		
		VariableDeclaration varDcl = OCLFactory.eINSTANCE.createVariableDeclaration();
		varDcl.setVarName("thisModule");
		OperationCallExp lazyRuleCall = OCLFactory.eINSTANCE.createOperationCallExp();
		lazyRuleCall.setOperationName(lazyRule.getName());
		lazyRuleCall.setInferredType( self.getType().getInferredType() );
		VariableExp refThisModule = OCLFactory.eINSTANCE.createVariableExp();
		refThisModule.setReferredVariable(varDcl);
		lazyRuleCall.setSource(refThisModule);
		lazyRuleCall.setStaticResolver(lazyRule);
		
		VariableExp exp = OCLFactory.eINSTANCE.createVariableExp();
		exp.setInferredType( it.getInferredType() );
		exp.setReferredVariable(it);
		lazyRuleCall.getArguments().add(exp);
		for (VariableDeclaration vd : externalVars) {
			VariableExp refToExternal = OCLFactory.eINSTANCE.createVariableExp();
			refToExternal.setInferredType( vd.getInferredType() );
			refToExternal.setReferredVariable( vd );
			lazyRuleCall.getArguments().add(refToExternal);
		}		

		collectExp.setBody(lazyRuleCall);
		
		var.setInitExpression( collectExp );
		
		// Replace usages of the original output pattern 
		for (VariableExp vexp : new ArrayList<>(self.getVariableExp()) ) {
			vexp.setReferredVariable(var);
		}
		
		// Remove the output pattern
		toAdd.add(new Pair<Rule, RuleVariableDeclaration>(r, var));
		toDelete.add(self);
	}
	
	
}
