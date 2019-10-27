/**
 */
package airquality;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Warning</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link airquality.Warning#getLevel <em>Level</em>}</li>
 *   <li>{@link airquality.Warning#getPollutant <em>Pollutant</em>}</li>
 *   <li>{@link airquality.Warning#getDate <em>Date</em>}</li>
 *   <li>{@link airquality.Warning#getStation <em>Station</em>}</li>
 * </ul>
 *
 * @see airquality.AirqualityPackage#getWarning()
 * @model
 * @generated
 */
public interface Warning extends EObject {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * The default value is <code>"0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(double)
	 * @see airquality.AirqualityPackage#getWarning_Level()
	 * @model default="0.0"
	 * @generated
	 */
	double getLevel();

	/**
	 * Sets the value of the '{@link airquality.Warning#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(double value);

	/**
	 * Returns the value of the '<em><b>Pollutant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pollutant</em>' attribute.
	 * @see #setPollutant(String)
	 * @see airquality.AirqualityPackage#getWarning_Pollutant()
	 * @model
	 * @generated
	 */
	String getPollutant();

	/**
	 * Sets the value of the '{@link airquality.Warning#getPollutant <em>Pollutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pollutant</em>' attribute.
	 * @see #getPollutant()
	 * @generated
	 */
	void setPollutant(String value);

	/**
	 * Returns the value of the '<em><b>Date</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link airquality.Date#getWarning <em>Warning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Date</em>' containment reference.
	 * @see #setDate(Date)
	 * @see airquality.AirqualityPackage#getWarning_Date()
	 * @see airquality.Date#getWarning
	 * @model opposite="warning" containment="true" required="true"
	 * @generated
	 */
	Date getDate();

	/**
	 * Sets the value of the '{@link airquality.Warning#getDate <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Date</em>' containment reference.
	 * @see #getDate()
	 * @generated
	 */
	void setDate(Date value);

	/**
	 * Returns the value of the '<em><b>Station</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Station</em>' attribute.
	 * @see #setStation(int)
	 * @see airquality.AirqualityPackage#getWarning_Station()
	 * @model
	 * @generated
	 */
	int getStation();

	/**
	 * Sets the value of the '{@link airquality.Warning#getStation <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Station</em>' attribute.
	 * @see #getStation()
	 * @generated
	 */
	void setStation(int value);

} // Warning
