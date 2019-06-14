/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.StringExp#getStringSymbol <em>String Symbol</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getStringExp()
 * @model
 * @generated
 */
public interface StringExp extends PrimitiveExp {
	/**
	 * Returns the value of the '<em><b>String Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Symbol</em>' attribute.
	 * @see #setStringSymbol(String)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getStringExp_StringSymbol()
	 * @model unique="false" dataType="a2l.tests.vmtesting.emf.metamodels.atl.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getStringSymbol();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.StringExp#getStringSymbol <em>String Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Symbol</em>' attribute.
	 * @see #getStringSymbol()
	 * @generated
	 */
	void setStringSymbol(String value);

} // StringExp
