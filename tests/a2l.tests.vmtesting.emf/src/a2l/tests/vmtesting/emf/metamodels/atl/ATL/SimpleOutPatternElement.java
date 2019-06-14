/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Out Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.SimpleOutPatternElement#getReverseBindings <em>Reverse Bindings</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getSimpleOutPatternElement()
 * @model
 * @generated
 */
public interface SimpleOutPatternElement extends OutPatternElement {
	/**
	 * Returns the value of the '<em><b>Reverse Bindings</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse Bindings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse Bindings</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getSimpleOutPatternElement_ReverseBindings()
	 * @model containment="true"
	 * @generated
	 */
	EList<OclExpression> getReverseBindings();

} // SimpleOutPatternElement
