/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Unit#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Unit#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getUnit()
 * @model
 * @generated
 */
public interface Unit extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Libraries</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.LibraryRef}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.LibraryRef#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Libraries</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Libraries</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getUnit_Libraries()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.LibraryRef#getUnit
	 * @model opposite="unit" containment="true" ordered="false"
	 * @generated
	 */
	EList<LibraryRef> getLibraries();

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
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getUnit_Name()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Unit#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Unit
