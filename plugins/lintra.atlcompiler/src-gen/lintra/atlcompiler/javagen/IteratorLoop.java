/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iterator Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorVar <em>Iterator Var</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorInit <em>Iterator Init</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getIteratorLoop()
 * @model
 * @generated
 */
public interface IteratorLoop extends JLoop {
	/**
	 * Returns the value of the '<em><b>Iterator Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator Var</em>' containment reference.
	 * @see #setIteratorVar(JVariableDeclaration)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getIteratorLoop_IteratorVar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JVariableDeclaration getIteratorVar();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorVar <em>Iterator Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator Var</em>' containment reference.
	 * @see #getIteratorVar()
	 * @generated
	 */
	void setIteratorVar(JVariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Iterator Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator Init</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator Init</em>' containment reference.
	 * @see #setIteratorInit(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getIteratorLoop_IteratorInit()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getIteratorInit();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorInit <em>Iterator Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator Init</em>' containment reference.
	 * @see #getIteratorInit()
	 * @generated
	 */
	void setIteratorInit(JExpression value);

} // IteratorLoop
