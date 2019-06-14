/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binding Stat</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getSource <em>Source</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getPropertyName <em>Property Name</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#isIsAssignment <em>Is Assignment</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getBindingStat()
 * @model
 * @generated
 */
public interface BindingStat extends Statement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(OclExpression)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getBindingStat_Source()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getSource();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Property Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Name</em>' attribute.
	 * @see #setPropertyName(String)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getBindingStat_PropertyName()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getPropertyName();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getPropertyName <em>Property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Name</em>' attribute.
	 * @see #getPropertyName()
	 * @generated
	 */
	void setPropertyName(String value);

	/**
	 * Returns the value of the '<em><b>Is Assignment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Assignment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Assignment</em>' attribute.
	 * @see #setIsAssignment(boolean)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getBindingStat_IsAssignment()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAssignment();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#isIsAssignment <em>Is Assignment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Assignment</em>' attribute.
	 * @see #isIsAssignment()
	 * @generated
	 */
	void setIsAssignment(boolean value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getBindingStat_Value()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.BindingStat#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

} // BindingStat
