/**
 */
package a2l.optimiser.anatlyzerext;

import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>All Instances Indexed</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getOriginal <em>Original</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getOptimisationHint <em>Optimisation Hint</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getAllInstancesIndexed()
 * @model
 * @generated
 */
public interface AllInstancesIndexed extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Original</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Original</em>' containment reference.
	 * @see #setOriginal(IteratorExp)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getAllInstancesIndexed_Original()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IteratorExp getOriginal();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getOriginal <em>Original</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Original</em>' containment reference.
	 * @see #getOriginal()
	 * @generated
	 */
	void setOriginal(IteratorExp value);

	/**
	 * Returns the value of the '<em><b>Optimisation Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optimisation Hint</em>' attribute.
	 * @see #setOptimisationHint(Object)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getAllInstancesIndexed_OptimisationHint()
	 * @model required="true" transient="true"
	 * @generated
	 */
	Object getOptimisationHint();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getOptimisationHint <em>Optimisation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optimisation Hint</em>' attribute.
	 * @see #getOptimisationHint()
	 * @generated
	 */
	void setOptimisationHint(Object value);

	/**
	 * Returns the value of the '<em><b>Index Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index Type</em>' attribute.
	 * @see #setIndexType(String)
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#getAllInstancesIndexed_IndexType()
	 * @model required="true"
	 * @generated
	 */
	String getIndexType();

	/**
	 * Sets the value of the '{@link a2l.optimiser.anatlyzerext.AllInstancesIndexed#getIndexType <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index Type</em>' attribute.
	 * @see #getIndexType()
	 * @generated
	 */
	void setIndexType(String value);

} // AllInstancesIndexed
