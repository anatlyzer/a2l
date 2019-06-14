/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JConditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JConditional#getConditions <em>Conditions</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JConditional#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJConditional()
 * @model
 * @generated
 */
public interface JConditional extends JStatement {
	/**
	 * Returns the value of the '<em><b>Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JConditionalBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conditions</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJConditional_Conditions()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<JConditionalBlock> getConditions();

	/**
	 * Returns the value of the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else</em>' containment reference.
	 * @see #setElse(JConditionalBlock)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJConditional_Else()
	 * @model containment="true"
	 * @generated
	 */
	JConditionalBlock getElse();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JConditional#getElse <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else</em>' containment reference.
	 * @see #getElse()
	 * @generated
	 */
	void setElse(JConditionalBlock value);

} // JConditional
