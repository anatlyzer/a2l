/**
 */
package a2l.optimiser.anatlyzerext;

import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.PropertyCallExp;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Chain Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getName <em>Name</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getIterator <em>Iterator</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getPreChain <em>Pre Chain</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getChain <em>Chain</em>}</li>
 * </ul>
 *
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainExp()
 * @model
 * @generated
 */
public interface IteratorChainExp extends PropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainExp_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(Iterator)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainExp_Iterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Iterator getIterator();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(Iterator value);

	/**
	 * Returns the value of the '<em><b>Pre Chain</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.optimiser.anatlyzerext.IteratorChainElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Chain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Chain</em>' containment reference list.
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainExp_PreChain()
	 * @model containment="true"
	 * @generated
	 */
	EList<IteratorChainElement> getPreChain();

	/**
	 * Returns the value of the '<em><b>Chain</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.optimiser.anatlyzerext.IteratorChainElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chain</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chain</em>' containment reference list.
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainExp_Chain()
	 * @model containment="true"
	 * @generated
	 */
	EList<IteratorChainElement> getChain();

} // IteratorChainExp
