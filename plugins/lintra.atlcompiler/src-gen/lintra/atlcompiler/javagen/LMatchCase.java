/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LMatch Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.LMatchCase#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.LMatchCase#getObj <em>Obj</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getLMatchCase()
 * @model
 * @generated
 */
public interface LMatchCase extends JBlock {
	/**
	 * Returns the value of the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predicate</em>' reference.
	 * @see #setPredicate(JMethod)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getLMatchCase_Predicate()
	 * @model required="true"
	 * @generated
	 */
	JMethod getPredicate();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.LMatchCase#getPredicate <em>Predicate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predicate</em>' reference.
	 * @see #getPredicate()
	 * @generated
	 */
	void setPredicate(JMethod value);

	/**
	 * Returns the value of the '<em><b>Obj</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obj</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obj</em>' containment reference.
	 * @see #setObj(JExpression)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getLMatchCase_Obj()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getObj();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.LMatchCase#getObj <em>Obj</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj</em>' containment reference.
	 * @see #getObj()
	 * @generated
	 */
	void setObj(JExpression value);

} // LMatchCase
