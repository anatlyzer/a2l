/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JConditional Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JConditionalBlock#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJConditionalBlock()
 * @model
 * @generated
 */
public interface JConditionalBlock extends JBlock {
	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference.
	 * @see #setExpr(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJConditionalBlock_Expr()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getExpr();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JConditionalBlock#getExpr <em>Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expr</em>' containment reference.
	 * @see #getExpr()
	 * @generated
	 */
	void setExpr(JExpression value);

} // JConditionalBlock
