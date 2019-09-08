package linda.atlcompiler;

import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.compiler.OptimisationHints;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import anatlyzer.atlext.ATL.BindingStat;
import anatlyzer.atlext.ATL.ForStat;
import anatlyzer.atlext.ATL.IfStat;
import anatlyzer.atlext.OCL.BooleanExp;
import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.EnumLiteralExp;
import anatlyzer.atlext.OCL.IfExp;
import anatlyzer.atlext.OCL.IntegerExp;
import anatlyzer.atlext.OCL.IterateExp;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LetExp;
import anatlyzer.atlext.OCL.MapExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclModelElement;
import anatlyzer.atlext.OCL.OclUndefinedExp;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.OrderedSetExp;
import anatlyzer.atlext.OCL.SequenceExp;
import anatlyzer.atlext.OCL.SetExp;
import anatlyzer.atlext.OCL.StringExp;
import anatlyzer.atlext.OCL.TupleExp;
import anatlyzer.atlext.OCL.VariableDeclaration;

public interface IOclCompiler {

	void inNavigationExp(NavigationOrAttributeCallExp self, boolean onSubtypes);
	void inAttributeCall(NavigationOrAttributeCallExp self);
	void inTupleAccess(NavigationOrAttributeCallExp self);	
	void beforeIteratorExp(IteratorExp self);
	void inIteratorExp(IteratorExp self);

	void prepareIterateVariable(IterateExp self);
	void inIterateExp(IterateExp self);
	void inOperatorCallExp(OperatorCallExp self);
	void inOperationCallExp(OperationCallExp self);
	void inThisModuleCall(OperationCallExp self);
	void inThisModuleCall(NavigationOrAttributeCallExp self);
	void inBuiltInOperationCallExp(OperationCallExp self);
	void inBuiltInAttributeCallExp(NavigationOrAttributeCallExp self);
	void inCollectionOperationCallExp(CollectionOperationCallExp self);

	void inIfExp(IfExp self);

	void inBooleanExp(BooleanExp self);
	void inStringExp(StringExp self);
	void inIntegerExp(IntegerExp self);
	void inEnumLiteralExp(EnumLiteralExp self);
	void inOclUndefined(OclUndefinedExp self);

	void inLetExpVarDcl(VariableDeclaration self);
	void inLetExp(LetExp self);

	void inSequenceExp(SequenceExp self);
	void inSetExp(SetExp self);
	void inOrderedSetExp(OrderedSetExp self);
	void inMapExp(MapExp self);
	void inTupleExp(TupleExp self);
	
	void inOclModelElement(OclModelElement self);

	// This is ATL specific
	void inLazyRuleCall(OperationCallExp self);
	void inCalledRuleCall(OperationCallExp self);
	
	void prepareForStatVariable(ForStat self);
	void inForStat(ForStat self);
	void inIfStat(IfStat self);
	// void inBindingStat(BindingStat self);
	
	
	// Optimization-related classes
	
	void inNavRefAsSet(NavRefAsSet self);
	void inMutableIteratorExp(MutableIteratorExp self);
	void inMutableCollectionOperationCallExp(MutableCollectionOperationCallExp self);
	void inIteratorChainExp(IteratorChainExp self);
	void beforeIteratorChainExp(IteratorChainExp self);
	
	
//	String getSetter(EStructuralFeature writtenFeature);
//	String getGetter(EStructuralFeature writtenFeature);
}
