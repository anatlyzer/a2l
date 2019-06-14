/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JForeach</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JForeach#getCollection <em>Collection</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJForeach()
 * @model
 * @generated
 */
public interface JForeach extends JLoop {
	/**
	 * Returns the value of the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection</em>' containment reference.
	 * @see #setCollection(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJForeach_Collection()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getCollection();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JForeach#getCollection <em>Collection</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection</em>' containment reference.
	 * @see #getCollection()
	 * @generated
	 */
	void setCollection(JExpression value);

} // JForeach
