/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.ATL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lazy Matched Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.LazyMatchedRule#isIsUnique <em>Is Unique</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getLazyMatchedRule()
 * @model
 * @generated
 */
public interface LazyMatchedRule extends MatchedRule {
	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Unique</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage#getLazyMatchedRule_IsUnique()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.ATL.LazyMatchedRule#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

} // LazyMatchedRule
