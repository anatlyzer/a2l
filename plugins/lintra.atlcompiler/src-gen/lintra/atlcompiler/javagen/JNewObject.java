/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JNew Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JNewObject#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JNewObject#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJNewObject()
 * @model
 * @generated
 */
public interface JNewObject extends JExpression {
	/**
	 * Returns the value of the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Ref</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Ref</em>' containment reference.
	 * @see #setTypeRef(JTypeRef)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJNewObject_TypeRef()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JTypeRef getTypeRef();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JNewObject#getTypeRef <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Ref</em>' containment reference.
	 * @see #getTypeRef()
	 * @generated
	 */
	void setTypeRef(JTypeRef value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJNewObject_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JExpression> getArguments();

} // JNewObject
