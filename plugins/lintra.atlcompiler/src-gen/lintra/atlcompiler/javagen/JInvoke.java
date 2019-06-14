/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JInvoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JInvoke#getName <em>Name</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JInvoke#getObj <em>Obj</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JInvoke#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJInvoke()
 * @model
 * @generated
 */
public interface JInvoke extends JExpression {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJInvoke_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JInvoke#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJInvoke_Obj()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JExpression getObj();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JInvoke#getObj <em>Obj</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obj</em>' containment reference.
	 * @see #getObj()
	 * @generated
	 */
	void setObj(JExpression value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJInvoke_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<JExpression> getArguments();

} // JInvoke
