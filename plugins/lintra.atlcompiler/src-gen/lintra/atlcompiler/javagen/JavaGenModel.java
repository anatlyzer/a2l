/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Gen Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JavaGenModel#getLibTypes <em>Lib Types</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JavaGenModel#getMetaTypes <em>Meta Types</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JavaGenModel#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJavaGenModel()
 * @model
 * @generated
 */
public interface JavaGenModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Lib Types</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JLibType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lib Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lib Types</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJavaGenModel_LibTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JLibType> getLibTypes();

	/**
	 * Returns the value of the '<em><b>Meta Types</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JMetaType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Meta Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Meta Types</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJavaGenModel_MetaTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JMetaType> getMetaTypes();

	/**
	 * Returns the value of the '<em><b>Classes</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classes</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJavaGenModel_Classes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JClass> getClasses();

} // JavaGenModel
