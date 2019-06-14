/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;

import a2l.tests.vmtesting.emf.metamodels.atl.OCL.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.RuleVariableDeclaration#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getRuleVariableDeclaration()
 * @model
 * @generated
 */
public interface RuleVariableDeclaration extends VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.Rule#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' container reference.
	 * @see #setRule(Rule)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getRuleVariableDeclaration_Rule()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.Rule#getVariables
	 * @model opposite="variables" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.RuleVariableDeclaration#getRule <em>Rule</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' container reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

} // RuleVariableDeclaration
