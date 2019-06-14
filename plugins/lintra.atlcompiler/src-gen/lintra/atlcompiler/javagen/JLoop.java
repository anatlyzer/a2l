/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JLoop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JLoop#getLoopVar <em>Loop Var</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJLoop()
 * @model
 * @generated
 */
public interface JLoop extends JStatement, JBlock {
	/**
	 * Returns the value of the '<em><b>Loop Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Var</em>' containment reference.
	 * @see #setLoopVar(JVariableDeclaration)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJLoop_LoopVar()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JVariableDeclaration getLoopVar();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JLoop#getLoopVar <em>Loop Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Var</em>' containment reference.
	 * @see #getLoopVar()
	 * @generated
	 */
	void setLoopVar(JVariableDeclaration value);

} // JLoop
