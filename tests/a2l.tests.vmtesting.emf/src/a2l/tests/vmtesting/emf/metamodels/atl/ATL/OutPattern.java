/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Out Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPattern#getRule <em>Rule</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPattern#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getOutPattern()
 * @model
 * @generated
 */
public interface OutPattern extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Rule#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getOutPattern_Rule()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.Rule#getOutPattern
	 * @model opposite="outPattern" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPattern#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPatternElement}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPatternElement#getOutPattern <em>Out Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getOutPattern_Elements()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPatternElement#getOutPattern
	 * @model opposite="outPattern" containment="true" required="true"
	 * @generated
	 */
	EList<OutPatternElement> getElements();

} // OutPattern
