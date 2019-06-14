/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JBlock</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JBlock#getLocalVars <em>Local Vars</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JBlock#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJBlock()
 * @model abstract="true"
 * @generated
 */
public interface JBlock extends EObject {
	/**
	 * Returns the value of the '<em><b>Local Vars</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Vars</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJBlock_LocalVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<JVariableDeclaration> getLocalVars();

	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJBlock_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JStatement> getStatements();

} // JBlock
