/**
 */
package airquality;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Air Measurement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link airquality.AirMeasurement#getPm2_5 <em>Pm2 5</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getPm10 <em>Pm10</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getO3 <em>O3</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getNo2 <em>No2</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getSo2 <em>So2</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getCo <em>Co</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getStation <em>Station</em>}</li>
 *   <li>{@link airquality.AirMeasurement#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @see airquality.AirqualityPackage#getAirMeasurement()
 * @model
 * @generated
 */
public interface AirMeasurement extends EObject {
	/**
	 * Returns the value of the '<em><b>Pm2 5</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pm2 5</em>' attribute.
	 * @see #setPm2_5(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_Pm2_5()
	 * @model
	 * @generated
	 */
	double getPm2_5();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getPm2_5 <em>Pm2 5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pm2 5</em>' attribute.
	 * @see #getPm2_5()
	 * @generated
	 */
	void setPm2_5(double value);

	/**
	 * Returns the value of the '<em><b>Pm10</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pm10</em>' attribute.
	 * @see #setPm10(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_Pm10()
	 * @model
	 * @generated
	 */
	double getPm10();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getPm10 <em>Pm10</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pm10</em>' attribute.
	 * @see #getPm10()
	 * @generated
	 */
	void setPm10(double value);

	/**
	 * Returns the value of the '<em><b>O3</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>O3</em>' attribute.
	 * @see #setO3(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_O3()
	 * @model
	 * @generated
	 */
	double getO3();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getO3 <em>O3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>O3</em>' attribute.
	 * @see #getO3()
	 * @generated
	 */
	void setO3(double value);

	/**
	 * Returns the value of the '<em><b>No2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No2</em>' attribute.
	 * @see #setNo2(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_No2()
	 * @model
	 * @generated
	 */
	double getNo2();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getNo2 <em>No2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No2</em>' attribute.
	 * @see #getNo2()
	 * @generated
	 */
	void setNo2(double value);

	/**
	 * Returns the value of the '<em><b>So2</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>So2</em>' attribute.
	 * @see #setSo2(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_So2()
	 * @model
	 * @generated
	 */
	double getSo2();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getSo2 <em>So2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>So2</em>' attribute.
	 * @see #getSo2()
	 * @generated
	 */
	void setSo2(double value);

	/**
	 * Returns the value of the '<em><b>Co</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Co</em>' attribute.
	 * @see #setCo(double)
	 * @see airquality.AirqualityPackage#getAirMeasurement_Co()
	 * @model
	 * @generated
	 */
	double getCo();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getCo <em>Co</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Co</em>' attribute.
	 * @see #getCo()
	 * @generated
	 */
	void setCo(double value);

	/**
	 * Returns the value of the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Station</em>' attribute.
	 * @see #setStation(int)
	 * @see airquality.AirqualityPackage#getAirMeasurement_Station()
	 * @model
	 * @generated
	 */
	int getStation();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getStation <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Station</em>' attribute.
	 * @see #getStation()
	 * @generated
	 */
	void setStation(int value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link airquality.Date#getMeasurement <em>Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' containment reference.
	 * @see #setDate(Date)
	 * @see airquality.AirqualityPackage#getAirMeasurement_Date()
	 * @see airquality.Date#getMeasurement
	 * @model opposite="measurement" containment="true" required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link airquality.AirMeasurement#getDate <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' containment reference.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

} // AirMeasurement
