/**
 */
package airquality.impl;

import airquality.AirMeasurement;
import airquality.AirqualityPackage;
import airquality.Date;
import airquality.Warning;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Date</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link airquality.impl.DateImpl#getYear <em>Year</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getDay <em>Day</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getHour <em>Hour</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getMinute <em>Minute</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getSecond <em>Second</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getWarning <em>Warning</em>}</li>
 *   <li>{@link airquality.impl.DateImpl#getMeasurement <em>Measurement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DateImpl extends MinimalEObjectImpl.Container implements Date {
	/**
	 * The default value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected static final int YEAR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getYear() <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYear()
	 * @generated
	 * @ordered
	 */
	protected int year = YEAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected static final int MONTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected int month = MONTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getDay() <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDay()
	 * @generated
	 * @ordered
	 */
	protected static final int DAY_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDay() <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDay()
	 * @generated
	 * @ordered
	 */
	protected int day = DAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHour() <em>Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHour()
	 * @generated
	 * @ordered
	 */
	protected static final int HOUR_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHour() <em>Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHour()
	 * @generated
	 * @ordered
	 */
	protected int hour = HOUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinute() <em>Minute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinute()
	 * @generated
	 * @ordered
	 */
	protected static final int MINUTE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMinute() <em>Minute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinute()
	 * @generated
	 * @ordered
	 */
	protected int minute = MINUTE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSecond() <em>Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecond()
	 * @generated
	 * @ordered
	 */
	protected static final int SECOND_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSecond() <em>Second</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecond()
	 * @generated
	 * @ordered
	 */
	protected int second = SECOND_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AirqualityPackage.Literals.DATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setYear(int newYear) {
		int oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMonth(int newMonth) {
		int oldMonth = month;
		month = newMonth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getDay() {
		return day;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDay(int newDay) {
		int oldDay = day;
		day = newDay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__DAY, oldDay, day));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHour() {
		return hour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHour(int newHour) {
		int oldHour = hour;
		hour = newHour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__HOUR, oldHour, hour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMinute() {
		return minute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinute(int newMinute) {
		int oldMinute = minute;
		minute = newMinute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__MINUTE, oldMinute, minute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSecond() {
		return second;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSecond(int newSecond) {
		int oldSecond = second;
		second = newSecond;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__SECOND, oldSecond, second));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Warning getWarning() {
		if (eContainerFeatureID() != AirqualityPackage.DATE__WARNING) return null;
		return (Warning)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWarning(Warning newWarning, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newWarning, AirqualityPackage.DATE__WARNING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWarning(Warning newWarning) {
		if (newWarning != eInternalContainer() || (eContainerFeatureID() != AirqualityPackage.DATE__WARNING && newWarning != null)) {
			if (EcoreUtil.isAncestor(this, newWarning))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newWarning != null)
				msgs = ((InternalEObject)newWarning).eInverseAdd(this, AirqualityPackage.WARNING__DATE, Warning.class, msgs);
			msgs = basicSetWarning(newWarning, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__WARNING, newWarning, newWarning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AirMeasurement getMeasurement() {
		if (eContainerFeatureID() != AirqualityPackage.DATE__MEASUREMENT) return null;
		return (AirMeasurement)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeasurement(AirMeasurement newMeasurement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMeasurement, AirqualityPackage.DATE__MEASUREMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMeasurement(AirMeasurement newMeasurement) {
		if (newMeasurement != eInternalContainer() || (eContainerFeatureID() != AirqualityPackage.DATE__MEASUREMENT && newMeasurement != null)) {
			if (EcoreUtil.isAncestor(this, newMeasurement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMeasurement != null)
				msgs = ((InternalEObject)newMeasurement).eInverseAdd(this, AirqualityPackage.AIR_MEASUREMENT__DATE, AirMeasurement.class, msgs);
			msgs = basicSetMeasurement(newMeasurement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.DATE__MEASUREMENT, newMeasurement, newMeasurement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AirqualityPackage.DATE__WARNING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetWarning((Warning)otherEnd, msgs);
			case AirqualityPackage.DATE__MEASUREMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMeasurement((AirMeasurement)otherEnd, msgs);
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
			case AirqualityPackage.DATE__WARNING:
				return basicSetWarning(null, msgs);
			case AirqualityPackage.DATE__MEASUREMENT:
				return basicSetMeasurement(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AirqualityPackage.DATE__WARNING:
				return eInternalContainer().eInverseRemove(this, AirqualityPackage.WARNING__DATE, Warning.class, msgs);
			case AirqualityPackage.DATE__MEASUREMENT:
				return eInternalContainer().eInverseRemove(this, AirqualityPackage.AIR_MEASUREMENT__DATE, AirMeasurement.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AirqualityPackage.DATE__YEAR:
				return getYear();
			case AirqualityPackage.DATE__MONTH:
				return getMonth();
			case AirqualityPackage.DATE__DAY:
				return getDay();
			case AirqualityPackage.DATE__HOUR:
				return getHour();
			case AirqualityPackage.DATE__MINUTE:
				return getMinute();
			case AirqualityPackage.DATE__SECOND:
				return getSecond();
			case AirqualityPackage.DATE__WARNING:
				return getWarning();
			case AirqualityPackage.DATE__MEASUREMENT:
				return getMeasurement();
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
			case AirqualityPackage.DATE__YEAR:
				setYear((Integer)newValue);
				return;
			case AirqualityPackage.DATE__MONTH:
				setMonth((Integer)newValue);
				return;
			case AirqualityPackage.DATE__DAY:
				setDay((Integer)newValue);
				return;
			case AirqualityPackage.DATE__HOUR:
				setHour((Integer)newValue);
				return;
			case AirqualityPackage.DATE__MINUTE:
				setMinute((Integer)newValue);
				return;
			case AirqualityPackage.DATE__SECOND:
				setSecond((Integer)newValue);
				return;
			case AirqualityPackage.DATE__WARNING:
				setWarning((Warning)newValue);
				return;
			case AirqualityPackage.DATE__MEASUREMENT:
				setMeasurement((AirMeasurement)newValue);
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
			case AirqualityPackage.DATE__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case AirqualityPackage.DATE__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case AirqualityPackage.DATE__DAY:
				setDay(DAY_EDEFAULT);
				return;
			case AirqualityPackage.DATE__HOUR:
				setHour(HOUR_EDEFAULT);
				return;
			case AirqualityPackage.DATE__MINUTE:
				setMinute(MINUTE_EDEFAULT);
				return;
			case AirqualityPackage.DATE__SECOND:
				setSecond(SECOND_EDEFAULT);
				return;
			case AirqualityPackage.DATE__WARNING:
				setWarning((Warning)null);
				return;
			case AirqualityPackage.DATE__MEASUREMENT:
				setMeasurement((AirMeasurement)null);
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
			case AirqualityPackage.DATE__YEAR:
				return year != YEAR_EDEFAULT;
			case AirqualityPackage.DATE__MONTH:
				return month != MONTH_EDEFAULT;
			case AirqualityPackage.DATE__DAY:
				return day != DAY_EDEFAULT;
			case AirqualityPackage.DATE__HOUR:
				return hour != HOUR_EDEFAULT;
			case AirqualityPackage.DATE__MINUTE:
				return minute != MINUTE_EDEFAULT;
			case AirqualityPackage.DATE__SECOND:
				return second != SECOND_EDEFAULT;
			case AirqualityPackage.DATE__WARNING:
				return getWarning() != null;
			case AirqualityPackage.DATE__MEASUREMENT:
				return getMeasurement() != null;
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
		result.append(" (year: ");
		result.append(year);
		result.append(", month: ");
		result.append(month);
		result.append(", day: ");
		result.append(day);
		result.append(", hour: ");
		result.append(hour);
		result.append(", minute: ");
		result.append(minute);
		result.append(", second: ");
		result.append(second);
		result.append(')');
		return result.toString();
	}

} //DateImpl
