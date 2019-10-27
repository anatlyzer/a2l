/**
 */
package airquality;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Date</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link airquality.Date#getYear <em>Year</em>}</li>
 *   <li>{@link airquality.Date#getMonth <em>Month</em>}</li>
 *   <li>{@link airquality.Date#getDay <em>Day</em>}</li>
 *   <li>{@link airquality.Date#getHour <em>Hour</em>}</li>
 *   <li>{@link airquality.Date#getMinute <em>Minute</em>}</li>
 *   <li>{@link airquality.Date#getSecond <em>Second</em>}</li>
 *   <li>{@link airquality.Date#getWarning <em>Warning</em>}</li>
 *   <li>{@link airquality.Date#getMeasurement <em>Measurement</em>}</li>
 * </ul>
 *
 * @see airquality.AirqualityPackage#getDate()
 * @model
 * @generated
 */
public interface Date extends EObject {
	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(int)
	 * @see airquality.AirqualityPackage#getDate_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link airquality.Date#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see #setMonth(int)
	 * @see airquality.AirqualityPackage#getDate_Month()
	 * @model
	 * @generated
	 */
	int getMonth();

	/**
	 * Sets the value of the '{@link airquality.Date#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(int value);

	/**
	 * Returns the value of the '<em><b>Day</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Day</em>' attribute.
	 * @see #setDay(int)
	 * @see airquality.AirqualityPackage#getDate_Day()
	 * @model
	 * @generated
	 */
	int getDay();

	/**
	 * Sets the value of the '{@link airquality.Date#getDay <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day</em>' attribute.
	 * @see #getDay()
	 * @generated
	 */
	void setDay(int value);

	/**
	 * Returns the value of the '<em><b>Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hour</em>' attribute.
	 * @see #setHour(int)
	 * @see airquality.AirqualityPackage#getDate_Hour()
	 * @model
	 * @generated
	 */
	int getHour();

	/**
	 * Sets the value of the '{@link airquality.Date#getHour <em>Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hour</em>' attribute.
	 * @see #getHour()
	 * @generated
	 */
	void setHour(int value);

	/**
	 * Returns the value of the '<em><b>Minute</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minute</em>' attribute.
	 * @see #setMinute(int)
	 * @see airquality.AirqualityPackage#getDate_Minute()
	 * @model
	 * @generated
	 */
	int getMinute();

	/**
	 * Sets the value of the '{@link airquality.Date#getMinute <em>Minute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minute</em>' attribute.
	 * @see #getMinute()
	 * @generated
	 */
	void setMinute(int value);

	/**
	 * Returns the value of the '<em><b>Second</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Second</em>' attribute.
	 * @see #setSecond(int)
	 * @see airquality.AirqualityPackage#getDate_Second()
	 * @model
	 * @generated
	 */
	int getSecond();

	/**
	 * Sets the value of the '{@link airquality.Date#getSecond <em>Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Second</em>' attribute.
	 * @see #getSecond()
	 * @generated
	 */
	void setSecond(int value);

	/**
	 * Returns the value of the '<em><b>Warning</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link airquality.Warning#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning</em>' container reference.
	 * @see #setWarning(Warning)
	 * @see airquality.AirqualityPackage#getDate_Warning()
	 * @see airquality.Warning#getDate
	 * @model opposite="date" transient="false"
	 * @generated
	 */
	Warning getWarning();

	/**
	 * Sets the value of the '{@link airquality.Date#getWarning <em>Warning</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning</em>' container reference.
	 * @see #getWarning()
	 * @generated
	 */
	void setWarning(Warning value);

	/**
	 * Returns the value of the '<em><b>Measurement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link airquality.AirMeasurement#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Measurement</em>' container reference.
	 * @see #setMeasurement(AirMeasurement)
	 * @see airquality.AirqualityPackage#getDate_Measurement()
	 * @see airquality.AirMeasurement#getDate
	 * @model opposite="date" transient="false"
	 * @generated
	 */
	AirMeasurement getMeasurement();

	/**
	 * Sets the value of the '{@link airquality.Date#getMeasurement <em>Measurement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Measurement</em>' container reference.
	 * @see #getMeasurement()
	 * @generated
	 */
	void setMeasurement(AirMeasurement value);

} // Date
