/**
 */
package airquality;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see airquality.AirqualityFactory
 * @model kind="package"
 * @generated
 */
public interface AirqualityPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "airquality";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://airquality";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "airquality";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AirqualityPackage eINSTANCE = airquality.impl.AirqualityPackageImpl.init();

	/**
	 * The meta object id for the '{@link airquality.impl.AirMeasurementImpl <em>Air Measurement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see airquality.impl.AirMeasurementImpl
	 * @see airquality.impl.AirqualityPackageImpl#getAirMeasurement()
	 * @generated
	 */
	int AIR_MEASUREMENT = 0;

	/**
	 * The feature id for the '<em><b>Pm2 5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__PM2_5 = 0;

	/**
	 * The feature id for the '<em><b>Pm10</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__PM10 = 1;

	/**
	 * The feature id for the '<em><b>O3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__O3 = 2;

	/**
	 * The feature id for the '<em><b>No2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__NO2 = 3;

	/**
	 * The feature id for the '<em><b>So2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__SO2 = 4;

	/**
	 * The feature id for the '<em><b>Co</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__CO = 5;

	/**
	 * The feature id for the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__STATION = 6;

	/**
	 * The feature id for the '<em><b>Date</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT__DATE = 7;

	/**
	 * The number of structural features of the '<em>Air Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Air Measurement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AIR_MEASUREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link airquality.impl.WarningImpl <em>Warning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see airquality.impl.WarningImpl
	 * @see airquality.impl.AirqualityPackageImpl#getWarning()
	 * @generated
	 */
	int WARNING = 1;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING__LEVEL = 0;

	/**
	 * The feature id for the '<em><b>Pollutant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING__POLLUTANT = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING__DATE = 2;

	/**
	 * The feature id for the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING__STATION = 3;

	/**
	 * The number of structural features of the '<em>Warning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Warning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WARNING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link airquality.impl.DateImpl <em>Date</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see airquality.impl.DateImpl
	 * @see airquality.impl.AirqualityPackageImpl#getDate()
	 * @generated
	 */
	int DATE = 2;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__YEAR = 0;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__MONTH = 1;

	/**
	 * The feature id for the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__DAY = 2;

	/**
	 * The feature id for the '<em><b>Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__HOUR = 3;

	/**
	 * The feature id for the '<em><b>Minute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__MINUTE = 4;

	/**
	 * The feature id for the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__SECOND = 5;

	/**
	 * The feature id for the '<em><b>Warning</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__WARNING = 6;

	/**
	 * The feature id for the '<em><b>Measurement</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE__MEASUREMENT = 7;

	/**
	 * The number of structural features of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Date</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link airquality.AirMeasurement <em>Air Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Air Measurement</em>'.
	 * @see airquality.AirMeasurement
	 * @generated
	 */
	EClass getAirMeasurement();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getPm2_5 <em>Pm2 5</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pm2 5</em>'.
	 * @see airquality.AirMeasurement#getPm2_5()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_Pm2_5();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getPm10 <em>Pm10</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pm10</em>'.
	 * @see airquality.AirMeasurement#getPm10()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_Pm10();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getO3 <em>O3</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>O3</em>'.
	 * @see airquality.AirMeasurement#getO3()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_O3();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getNo2 <em>No2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>No2</em>'.
	 * @see airquality.AirMeasurement#getNo2()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_No2();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getSo2 <em>So2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>So2</em>'.
	 * @see airquality.AirMeasurement#getSo2()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_So2();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getCo <em>Co</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Co</em>'.
	 * @see airquality.AirMeasurement#getCo()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_Co();

	/**
	 * Returns the meta object for the attribute '{@link airquality.AirMeasurement#getStation <em>Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Station</em>'.
	 * @see airquality.AirMeasurement#getStation()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EAttribute getAirMeasurement_Station();

	/**
	 * Returns the meta object for the containment reference '{@link airquality.AirMeasurement#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Date</em>'.
	 * @see airquality.AirMeasurement#getDate()
	 * @see #getAirMeasurement()
	 * @generated
	 */
	EReference getAirMeasurement_Date();

	/**
	 * Returns the meta object for class '{@link airquality.Warning <em>Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Warning</em>'.
	 * @see airquality.Warning
	 * @generated
	 */
	EClass getWarning();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Warning#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see airquality.Warning#getLevel()
	 * @see #getWarning()
	 * @generated
	 */
	EAttribute getWarning_Level();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Warning#getPollutant <em>Pollutant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pollutant</em>'.
	 * @see airquality.Warning#getPollutant()
	 * @see #getWarning()
	 * @generated
	 */
	EAttribute getWarning_Pollutant();

	/**
	 * Returns the meta object for the containment reference '{@link airquality.Warning#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Date</em>'.
	 * @see airquality.Warning#getDate()
	 * @see #getWarning()
	 * @generated
	 */
	EReference getWarning_Date();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Warning#getStation <em>Station</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Station</em>'.
	 * @see airquality.Warning#getStation()
	 * @see #getWarning()
	 * @generated
	 */
	EAttribute getWarning_Station();

	/**
	 * Returns the meta object for class '{@link airquality.Date <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date</em>'.
	 * @see airquality.Date
	 * @generated
	 */
	EClass getDate();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see airquality.Date#getYear()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Year();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see airquality.Date#getMonth()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Month();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getDay <em>Day</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Day</em>'.
	 * @see airquality.Date#getDay()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Day();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getHour <em>Hour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hour</em>'.
	 * @see airquality.Date#getHour()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Hour();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getMinute <em>Minute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Minute</em>'.
	 * @see airquality.Date#getMinute()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Minute();

	/**
	 * Returns the meta object for the attribute '{@link airquality.Date#getSecond <em>Second</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Second</em>'.
	 * @see airquality.Date#getSecond()
	 * @see #getDate()
	 * @generated
	 */
	EAttribute getDate_Second();

	/**
	 * Returns the meta object for the container reference '{@link airquality.Date#getWarning <em>Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Warning</em>'.
	 * @see airquality.Date#getWarning()
	 * @see #getDate()
	 * @generated
	 */
	EReference getDate_Warning();

	/**
	 * Returns the meta object for the container reference '{@link airquality.Date#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Measurement</em>'.
	 * @see airquality.Date#getMeasurement()
	 * @see #getDate()
	 * @generated
	 */
	EReference getDate_Measurement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AirqualityFactory getAirqualityFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link airquality.impl.AirMeasurementImpl <em>Air Measurement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see airquality.impl.AirMeasurementImpl
		 * @see airquality.impl.AirqualityPackageImpl#getAirMeasurement()
		 * @generated
		 */
		EClass AIR_MEASUREMENT = eINSTANCE.getAirMeasurement();

		/**
		 * The meta object literal for the '<em><b>Pm2 5</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__PM2_5 = eINSTANCE.getAirMeasurement_Pm2_5();

		/**
		 * The meta object literal for the '<em><b>Pm10</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__PM10 = eINSTANCE.getAirMeasurement_Pm10();

		/**
		 * The meta object literal for the '<em><b>O3</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__O3 = eINSTANCE.getAirMeasurement_O3();

		/**
		 * The meta object literal for the '<em><b>No2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__NO2 = eINSTANCE.getAirMeasurement_No2();

		/**
		 * The meta object literal for the '<em><b>So2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__SO2 = eINSTANCE.getAirMeasurement_So2();

		/**
		 * The meta object literal for the '<em><b>Co</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__CO = eINSTANCE.getAirMeasurement_Co();

		/**
		 * The meta object literal for the '<em><b>Station</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AIR_MEASUREMENT__STATION = eINSTANCE.getAirMeasurement_Station();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AIR_MEASUREMENT__DATE = eINSTANCE.getAirMeasurement_Date();

		/**
		 * The meta object literal for the '{@link airquality.impl.WarningImpl <em>Warning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see airquality.impl.WarningImpl
		 * @see airquality.impl.AirqualityPackageImpl#getWarning()
		 * @generated
		 */
		EClass WARNING = eINSTANCE.getWarning();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WARNING__LEVEL = eINSTANCE.getWarning_Level();

		/**
		 * The meta object literal for the '<em><b>Pollutant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WARNING__POLLUTANT = eINSTANCE.getWarning_Pollutant();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WARNING__DATE = eINSTANCE.getWarning_Date();

		/**
		 * The meta object literal for the '<em><b>Station</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WARNING__STATION = eINSTANCE.getWarning_Station();

		/**
		 * The meta object literal for the '{@link airquality.impl.DateImpl <em>Date</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see airquality.impl.DateImpl
		 * @see airquality.impl.AirqualityPackageImpl#getDate()
		 * @generated
		 */
		EClass DATE = eINSTANCE.getDate();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__YEAR = eINSTANCE.getDate_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__MONTH = eINSTANCE.getDate_Month();

		/**
		 * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__DAY = eINSTANCE.getDate_Day();

		/**
		 * The meta object literal for the '<em><b>Hour</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__HOUR = eINSTANCE.getDate_Hour();

		/**
		 * The meta object literal for the '<em><b>Minute</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__MINUTE = eINSTANCE.getDate_Minute();

		/**
		 * The meta object literal for the '<em><b>Second</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE__SECOND = eINSTANCE.getDate_Second();

		/**
		 * The meta object literal for the '<em><b>Warning</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATE__WARNING = eINSTANCE.getDate_Warning();

		/**
		 * The meta object literal for the '<em><b>Measurement</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATE__MEASUREMENT = eINSTANCE.getDate_Measurement();

	}

} //AirqualityPackage
