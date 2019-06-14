/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JReturn</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JReturn#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJReturn()
 * @model
 * @generated
 */
public interface JReturn extends JStatement {
	/**
	 * Returns the value of the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' containment reference.
	 * @see #setResult(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJReturn_Result()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getResult();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JReturn#getResult <em>Result</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' containment reference.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(JExpression value);

} // JReturn
