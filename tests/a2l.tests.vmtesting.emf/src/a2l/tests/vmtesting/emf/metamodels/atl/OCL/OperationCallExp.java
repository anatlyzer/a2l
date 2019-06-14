/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OperationCallExp#getArguments <em>Arguments</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OperationCallExp#getOperationName <em>Operation Name</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getOperationCallExp()
 * @model
 * @generated
 */
public interface OperationCallExp extends PropertyCallExp {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression#getParentOperation <em>Parent Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getOperationCallExp_Arguments()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression#getParentOperation
	 * @model opposite="parentOperation" containment="true"
	 * @generated
	 */
	EList<OclExpression> getArguments();

	/**
	 * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Name</em>' attribute.
	 * @see #setOperationName(String)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getOperationCallExp_OperationName()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getOperationName();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OperationCallExp#getOperationName <em>Operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Name</em>' attribute.
	 * @see #getOperationName()
	 * @generated
	 */
	void setOperationName(String value);

} // OperationCallExp
