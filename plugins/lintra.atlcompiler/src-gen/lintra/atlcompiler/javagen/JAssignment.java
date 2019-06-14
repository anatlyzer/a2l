/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JAssignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JAssignment#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JAssignment#getRightPart <em>Right Part</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJAssignment()
 * @model
 * @generated
 */
public interface JAssignment extends JText {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(JVariableDeclaration)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJAssignment_Declaration()
	 * @model required="true"
	 * @generated
	 */
	JVariableDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JAssignment#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(JVariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Right Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Part</em>' containment reference.
	 * @see #setRightPart(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJAssignment_RightPart()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getRightPart();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JAssignment#getRightPart <em>Right Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Part</em>' containment reference.
	 * @see #getRightPart()
	 * @generated
	 */
	void setRightPart(JExpression value);

} // JAssignment
