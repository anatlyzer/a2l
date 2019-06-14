/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JArray Type Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JArrayTypeRef#getContainedType <em>Contained Type</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJArrayTypeRef()
 * @model
 * @generated
 */
public interface JArrayTypeRef extends JTypeRef {
	/**
	 * Returns the value of the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Contained Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contained Type</em>' containment reference.
	 * @see #setContainedType(JTypeRef)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJArrayTypeRef_ContainedType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JTypeRef getContainedType();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JArrayTypeRef#getContainedType <em>Contained Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contained Type</em>' containment reference.
	 * @see #getContainedType()
	 * @generated
	 */
	void setContainedType(JTypeRef value);

} // JArrayTypeRef
