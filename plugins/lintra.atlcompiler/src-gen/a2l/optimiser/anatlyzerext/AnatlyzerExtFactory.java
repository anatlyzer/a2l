/**
 */
package a2l.optimiser.anatlyzerext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage
 * @generated
 */
public interface AnatlyzerExtFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnatlyzerExtFactory eINSTANCE = a2l.optimiser.anatlyzerext.impl.AnatlyzerExtFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Nav Ref As Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nav Ref As Set</em>'.
	 * @generated
	 */
	NavRefAsSet createNavRefAsSet();

	/**
	 * Returns a new object of class '<em>Mutable Iterator Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutable Iterator Exp</em>'.
	 * @generated
	 */
	MutableIteratorExp createMutableIteratorExp();

	/**
	 * Returns a new object of class '<em>Mutable Collection Operation Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mutable Collection Operation Call Exp</em>'.
	 * @generated
	 */
	MutableCollectionOperationCallExp createMutableCollectionOperationCallExp();

	/**
	 * Returns a new object of class '<em>Short Circuit Operator Call Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Short Circuit Operator Call Exp</em>'.
	 * @generated
	 */
	ShortCircuitOperatorCallExp createShortCircuitOperatorCallExp();

	/**
	 * Returns a new object of class '<em>Iterator Chain Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Chain Exp</em>'.
	 * @generated
	 */
	IteratorChainExp createIteratorChainExp();

	/**
	 * Returns a new object of class '<em>Iterator Chain Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Chain Element</em>'.
	 * @generated
	 */
	IteratorChainElement createIteratorChainElement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnatlyzerExtPackage getAnatlyzerExtPackage();

} //AnatlyzerExtFactory
