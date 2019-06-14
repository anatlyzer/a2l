/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Library#getHelpers <em>Helpers</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getLibrary()
 * @model
 * @generated
 */
public interface Library extends Unit {
	/**
	 * Returns the value of the '<em><b>Helpers</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Helper}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Helper#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helpers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helpers</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getLibrary_Helpers()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.Helper#getLibrary
	 * @model opposite="library" containment="true"
	 * @generated
	 */
	EList<Helper> getHelpers();

} // Library
