/**
 */
package a2l.optimiser.anatlyzerext;

import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.OclExpression;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Chain Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getName <em>Name</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getIterator <em>Iterator</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainElement()
 * @model
 * @generated
 */
public interface IteratorChainElement extends EObject {
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
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getName <em>Name</em>}' attribute.
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
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainElement_Iterator()
	 * @model containment="true"
	 * @generated
	 */
	Iterator getIterator();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(Iterator value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(OclExpression)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getIteratorChainElement_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	OclExpression getBody();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(OclExpression value);

} // IteratorChainElement
