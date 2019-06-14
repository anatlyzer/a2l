/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JMethod</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JMethod#getName <em>Name</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JMethod#getParameters <em>Parameters</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JMethod#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JMethod#getThrows_ <em>Throws </em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMethod()
 * @model
 * @generated
 */
public interface JMethod extends JBlock {
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
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMethod_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JMethod#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JParameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMethod_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<JParameter> getParameters();

	/**
	 * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Return Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Return Type</em>' containment reference.
	 * @see #setReturnType(JTypeRef)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMethod_ReturnType()
	 * @model containment="true"
	 * @generated
	 */
	JTypeRef getReturnType();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JMethod#getReturnType <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Return Type</em>' containment reference.
	 * @see #getReturnType()
	 * @generated
	 */
	void setReturnType(JTypeRef value);

	/**
	 * Returns the value of the '<em><b>Throws </b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JTypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Throws </em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Throws </em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMethod_Throws_()
	 * @model containment="true"
	 * @generated
	 */
	EList<JTypeRef> getThrows_();

} // JMethod
