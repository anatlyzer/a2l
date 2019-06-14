/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Map Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapExp#getElements <em>Elements</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapExp()
 * @model
 * @generated
 */
public interface MapExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getMap <em>Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getMapExp_Elements()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.MapElement#getMap
	 * @model opposite="map" containment="true"
	 * @generated
	 */
	EList<MapElement> getElements();

} // MapExp
