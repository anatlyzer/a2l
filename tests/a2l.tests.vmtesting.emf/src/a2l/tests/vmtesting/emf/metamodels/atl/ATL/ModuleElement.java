/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Module Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.ModuleElement#getModule <em>Module</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getModuleElement()
 * @model abstract="true"
 * @generated
 */
public interface ModuleElement extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Module</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Module#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Module</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Module</em>' container reference.
	 * @see #setModule(Module)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getModuleElement_Module()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.Module#getElements
	 * @model opposite="elements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Module getModule();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.ModuleElement#getModule <em>Module</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module</em>' container reference.
	 * @see #getModule()
	 * @generated
	 */
	void setModule(Module value);

} // ModuleElement
