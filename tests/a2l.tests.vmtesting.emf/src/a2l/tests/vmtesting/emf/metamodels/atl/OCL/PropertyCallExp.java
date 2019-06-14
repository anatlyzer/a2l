/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.PropertyCallExp#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getPropertyCallExp()
 * @model abstract="true"
 * @generated
 */
public interface PropertyCallExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression#getAppliedProperty <em>Applied Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OclExpression)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getPropertyCallExp_Source()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression#getAppliedProperty
	 * @model opposite="appliedProperty" containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getSource();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.PropertyCallExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OclExpression value);

} // PropertyCallExp
