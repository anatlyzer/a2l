/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Pattern Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPatternElement#getMapsTo <em>Maps To</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPatternElement#getInPattern <em>In Pattern</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPatternElement#getModels <em>Models</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getInPatternElement()
 * @model abstract="true"
 * @generated
 */
public interface InPatternElement extends PatternElement {
	/**
	 * Returns the value of the '<em><b>Maps To</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPatternElement#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Maps To</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maps To</em>' reference.
	 * @see #setMapsTo(OutPatternElement)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getInPatternElement_MapsTo()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.OutPatternElement#getSourceElement
	 * @model opposite="sourceElement" required="true" ordered="false"
	 * @generated
	 */
	OutPatternElement getMapsTo();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPatternElement#getMapsTo <em>Maps To</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maps To</em>' reference.
	 * @see #getMapsTo()
	 * @generated
	 */
	void setMapsTo(OutPatternElement value);

	/**
	 * Returns the value of the '<em><b>In Pattern</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPattern#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Pattern</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Pattern</em>' container reference.
	 * @see #setInPattern(InPattern)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getInPatternElement_InPattern()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPattern#getElements
	 * @model opposite="elements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	InPattern getInPattern();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.InPatternElement#getInPattern <em>In Pattern</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Pattern</em>' container reference.
	 * @see #getInPattern()
	 * @generated
	 */
	void setInPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>Models</b></em>' reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.OclModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getInPatternElement_Models()
	 * @model ordered="false"
	 * @generated
	 */
	EList<OclModel> getModels();

} // InPatternElement