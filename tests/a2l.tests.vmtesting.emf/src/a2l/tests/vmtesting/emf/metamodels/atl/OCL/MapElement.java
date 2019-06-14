/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;

import a2l.tests.vmtesting.emf.metamodels.atl.ATL.LocatedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getMap <em>Map</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getKey <em>Key</em>}</li>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapElement()
 * @model
 * @generated
 */
public interface MapElement extends LocatedElement {
	/**
	 * Returns the value of the '<em><b>Map</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapExp#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Map</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Map</em>' container reference.
	 * @see #setMap(MapExp)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapElement_Map()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapExp#getElements
	 * @model opposite="elements" required="true" transient="false" ordered="false"
	 * @generated
	 */
	MapExp getMap();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getMap <em>Map</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Map</em>' container reference.
	 * @see #getMap()
	 * @generated
	 */
	void setMap(MapExp value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' containment reference.
	 * @see #setKey(OclExpression)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapElement_Key()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getKey();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getKey <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' containment reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(OclExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(OclExpression)
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapElement_Value()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OclExpression getValue();

	/**
	 * Sets the value of the '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(OclExpression value);

} // MapElement
