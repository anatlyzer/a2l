/**
 */
package a2l.optimiser.anatlyzerext.util;

import a2l.optimiser.anatlyzerext.*;

import anatlyzer.atlext.ATL.LocatedElement;

import anatlyzer.atlext.OCL.CollectionOperationCallExp;
import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.LoopExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.OperatorCallExp;
import anatlyzer.atlext.OCL.PropertyCallExp;
import anatlyzer.atlext.OCL.TypedElement;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage
 * @generated
 */
public class AnatlyzerExtSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnatlyzerExtPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnatlyzerExtSwitch() {
		if (modelPackage == null) {
			modelPackage = AnatlyzerExtPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnatlyzerExtPackage.NAV_REF_AS_SET: {
				NavRefAsSet navRefAsSet = (NavRefAsSet)theEObject;
				T result = caseNavRefAsSet(navRefAsSet);
				if (result == null) result = caseNavigationOrAttributeCallExp(navRefAsSet);
				if (result == null) result = casePropertyCallExp(navRefAsSet);
				if (result == null) result = caseOclExpression(navRefAsSet);
				if (result == null) result = caseLocatedElement(navRefAsSet);
				if (result == null) result = caseTypedElement(navRefAsSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.MUTABLE_ITERATOR_EXP: {
				MutableIteratorExp mutableIteratorExp = (MutableIteratorExp)theEObject;
				T result = caseMutableIteratorExp(mutableIteratorExp);
				if (result == null) result = caseIteratorExp(mutableIteratorExp);
				if (result == null) result = caseLoopExp(mutableIteratorExp);
				if (result == null) result = casePropertyCallExp(mutableIteratorExp);
				if (result == null) result = caseOclExpression(mutableIteratorExp);
				if (result == null) result = caseLocatedElement(mutableIteratorExp);
				if (result == null) result = caseTypedElement(mutableIteratorExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.MUTABLE_COLLECTION_OPERATION_CALL_EXP: {
				MutableCollectionOperationCallExp mutableCollectionOperationCallExp = (MutableCollectionOperationCallExp)theEObject;
				T result = caseMutableCollectionOperationCallExp(mutableCollectionOperationCallExp);
				if (result == null) result = caseCollectionOperationCallExp(mutableCollectionOperationCallExp);
				if (result == null) result = caseOperationCallExp(mutableCollectionOperationCallExp);
				if (result == null) result = casePropertyCallExp(mutableCollectionOperationCallExp);
				if (result == null) result = caseOclExpression(mutableCollectionOperationCallExp);
				if (result == null) result = caseLocatedElement(mutableCollectionOperationCallExp);
				if (result == null) result = caseTypedElement(mutableCollectionOperationCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.SHORT_CIRCUIT_OPERATOR_CALL_EXP: {
				ShortCircuitOperatorCallExp shortCircuitOperatorCallExp = (ShortCircuitOperatorCallExp)theEObject;
				T result = caseShortCircuitOperatorCallExp(shortCircuitOperatorCallExp);
				if (result == null) result = caseOperatorCallExp(shortCircuitOperatorCallExp);
				if (result == null) result = caseOperationCallExp(shortCircuitOperatorCallExp);
				if (result == null) result = casePropertyCallExp(shortCircuitOperatorCallExp);
				if (result == null) result = caseOclExpression(shortCircuitOperatorCallExp);
				if (result == null) result = caseLocatedElement(shortCircuitOperatorCallExp);
				if (result == null) result = caseTypedElement(shortCircuitOperatorCallExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP: {
				IteratorChainExp iteratorChainExp = (IteratorChainExp)theEObject;
				T result = caseIteratorChainExp(iteratorChainExp);
				if (result == null) result = casePropertyCallExp(iteratorChainExp);
				if (result == null) result = caseOclExpression(iteratorChainExp);
				if (result == null) result = caseLocatedElement(iteratorChainExp);
				if (result == null) result = caseTypedElement(iteratorChainExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.ITERATOR_CHAIN_ELEMENT: {
				IteratorChainElement iteratorChainElement = (IteratorChainElement)theEObject;
				T result = caseIteratorChainElement(iteratorChainElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED: {
				AllInstancesIndexed allInstancesIndexed = (AllInstancesIndexed)theEObject;
				T result = caseAllInstancesIndexed(allInstancesIndexed);
				if (result == null) result = caseOclExpression(allInstancesIndexed);
				if (result == null) result = caseLocatedElement(allInstancesIndexed);
				if (result == null) result = caseTypedElement(allInstancesIndexed);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nav Ref As Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nav Ref As Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavRefAsSet(NavRefAsSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutable Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutable Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutableIteratorExp(MutableIteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutable Collection Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutable Collection Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutableCollectionOperationCallExp(MutableCollectionOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Short Circuit Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Short Circuit Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShortCircuitOperatorCallExp(ShortCircuitOperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Chain Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Chain Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorChainExp(IteratorChainExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Chain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Chain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorChainElement(IteratorChainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Instances Indexed</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Instances Indexed</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllInstancesIndexed(AllInstancesIndexed object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Located Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocatedElement(LocatedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclExpression(OclExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyCallExp(PropertyCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Navigation Or Attribute Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Navigation Or Attribute Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNavigationOrAttributeCallExp(NavigationOrAttributeCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopExp(LoopExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorExp(IteratorExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationCallExp(OperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Operation Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionOperationCallExp(CollectionOperationCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operator Call Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperatorCallExp(OperatorCallExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnatlyzerExtSwitch
