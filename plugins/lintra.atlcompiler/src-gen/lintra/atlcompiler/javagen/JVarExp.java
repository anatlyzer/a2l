/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JVar Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JVarExp#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJVarExp()
 * @model
 * @generated
 */
public interface JVarExp extends JExpression {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(JVariableDeclaration)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJVarExp_Reference()
	 * @model required="true"
	 * @generated
	 */
	JVariableDeclaration getReference();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JVarExp#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(JVariableDeclaration value);

} // JVarExp
