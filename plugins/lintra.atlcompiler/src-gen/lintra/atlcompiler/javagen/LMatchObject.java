/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>LMatch Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.LMatchObject#getCases <em>Cases</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getLMatchObject()
 * @model
 * @generated
 */
public interface LMatchObject extends JStatement {
	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.LMatchCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getLMatchObject_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<LMatchCase> getCases();

} // LMatchObject
