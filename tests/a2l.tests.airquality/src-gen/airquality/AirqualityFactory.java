/**
 */
package airquality;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see airquality.AirqualityPackage
 * @generated
 */
public interface AirqualityFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AirqualityFactory eINSTANCE = airquality.impl.AirqualityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Air Measurement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Air Measurement</em>'.
	 * @generated
	 */
	AirMeasurement createAirMeasurement();

	/**
	 * Returns a new object of class '<em>Warning</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Warning</em>'.
	 * @generated
	 */
	Warning createWarning();

	/**
	 * Returns a new object of class '<em>Date</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Date</em>'.
	 * @generated
	 */
	Date createDate();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AirqualityPackage getAirqualityPackage();

} //AirqualityFactory
