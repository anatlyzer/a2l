/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JComment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JComment#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJComment()
 * @model
 * @generated
 */
public interface JComment extends JStatement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJComment_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JComment#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // JComment
