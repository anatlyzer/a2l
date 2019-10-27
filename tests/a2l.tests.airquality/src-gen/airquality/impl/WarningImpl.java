/**
 */
package airquality.impl;

import airquality.AirqualityPackage;
import airquality.Date;
import airquality.Warning;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Warning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link airquality.impl.WarningImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link airquality.impl.WarningImpl#getPollutant <em>Pollutant</em>}</li>
 *   <li>{@link airquality.impl.WarningImpl#getDate <em>Date</em>}</li>
 *   <li>{@link airquality.impl.WarningImpl#getStation <em>Station</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WarningImpl extends MinimalEObjectImpl.Container implements Warning {
	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final double LEVEL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected double level = LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getPollutant() <em>Pollutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPollutant()
	 * @generated
	 * @ordered
	 */
	protected static final String POLLUTANT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPollutant() <em>Pollutant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPollutant()
	 * @generated
	 * @ordered
	 */
	protected String pollutant = POLLUTANT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDate() <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date;

	/**
	 * The default value of the '{@link #getStation() <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStation()
	 * @generated
	 * @ordered
	 */
	protected static final int STATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStation() <em>Station</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStation()
	 * @generated
	 * @ordered
	 */
	protected int station = STATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WarningImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AirqualityPackage.Literals.WARNING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLevel(double newLevel) {
		double oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.WARNING__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPollutant() {
		return pollutant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPollutant(String newPollutant) {
		String oldPollutant = pollutant;
		pollutant = newPollutant;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.WARNING__POLLUTANT, oldPollutant, pollutant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getDate() {
		return date;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDate(Date newDate, NotificationChain msgs) {
		Date oldDate = date;
		date = newDate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AirqualityPackage.WARNING__DATE, oldDate, newDate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDate(Date newDate) {
		if (newDate != date) {
			NotificationChain msgs = null;
			if (date != null)
				msgs = ((InternalEObject)date).eInverseRemove(this, AirqualityPackage.DATE__WARNING, Date.class, msgs);
			if (newDate != null)
				msgs = ((InternalEObject)newDate).eInverseAdd(this, AirqualityPackage.DATE__WARNING, Date.class, msgs);
			msgs = basicSetDate(newDate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.WARNING__DATE, newDate, newDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStation() {
		return station;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStation(int newStation) {
		int oldStation = station;
		station = newStation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.WARNING__STATION, oldStation, station));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AirqualityPackage.WARNING__DATE:
				if (date != null)
					msgs = ((InternalEObject)date).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AirqualityPackage.WARNING__DATE, null, msgs);
				return basicSetDate((Date)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AirqualityPackage.WARNING__DATE:
				return basicSetDate(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AirqualityPackage.WARNING__LEVEL:
				return getLevel();
			case AirqualityPackage.WARNING__POLLUTANT:
				return getPollutant();
			case AirqualityPackage.WARNING__DATE:
				return getDate();
			case AirqualityPackage.WARNING__STATION:
				return getStation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AirqualityPackage.WARNING__LEVEL:
				setLevel((Double)newValue);
				return;
			case AirqualityPackage.WARNING__POLLUTANT:
				setPollutant((String)newValue);
				return;
			case AirqualityPackage.WARNING__DATE:
				setDate((Date)newValue);
				return;
			case AirqualityPackage.WARNING__STATION:
				setStation((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AirqualityPackage.WARNING__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case AirqualityPackage.WARNING__POLLUTANT:
				setPollutant(POLLUTANT_EDEFAULT);
				return;
			case AirqualityPackage.WARNING__DATE:
				setDate((Date)null);
				return;
			case AirqualityPackage.WARNING__STATION:
				setStation(STATION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AirqualityPackage.WARNING__LEVEL:
				return level != LEVEL_EDEFAULT;
			case AirqualityPackage.WARNING__POLLUTANT:
				return POLLUTANT_EDEFAULT == null ? pollutant != null : !POLLUTANT_EDEFAULT.equals(pollutant);
			case AirqualityPackage.WARNING__DATE:
				return date != null;
			case AirqualityPackage.WARNING__STATION:
				return station != STATION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (level: ");
		result.append(level);
		result.append(", pollutant: ");
		result.append(pollutant);
		result.append(", station: ");
		result.append(station);
		result.append(')');
		return result.toString();
	}

} //WarningImpl
