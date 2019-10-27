/**
 */
package airquality.impl;

import airquality.AirMeasurement;
import airquality.AirqualityPackage;
import airquality.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Air Measurement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getPm2_5 <em>Pm2 5</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getPm10 <em>Pm10</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getO3 <em>O3</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getNo2 <em>No2</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getSo2 <em>So2</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getCo <em>Co</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getStation <em>Station</em>}</li>
 *   <li>{@link airquality.impl.AirMeasurementImpl#getDate <em>Date</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AirMeasurementImpl extends MinimalEObjectImpl.Container implements AirMeasurement {
	/**
	 * The default value of the '{@link #getPm2_5() <em>Pm2 5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPm2_5()
	 * @generated
	 * @ordered
	 */
	protected static final double PM2_5_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPm2_5() <em>Pm2 5</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPm2_5()
	 * @generated
	 * @ordered
	 */
	protected double pm2_5 = PM2_5_EDEFAULT;

	/**
	 * The default value of the '{@link #getPm10() <em>Pm10</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPm10()
	 * @generated
	 * @ordered
	 */
	protected static final double PM10_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPm10() <em>Pm10</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPm10()
	 * @generated
	 * @ordered
	 */
	protected double pm10 = PM10_EDEFAULT;

	/**
	 * The default value of the '{@link #getO3() <em>O3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getO3()
	 * @generated
	 * @ordered
	 */
	protected static final double O3_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getO3() <em>O3</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getO3()
	 * @generated
	 * @ordered
	 */
	protected double o3 = O3_EDEFAULT;

	/**
	 * The default value of the '{@link #getNo2() <em>No2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNo2()
	 * @generated
	 * @ordered
	 */
	protected static final double NO2_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNo2() <em>No2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNo2()
	 * @generated
	 * @ordered
	 */
	protected double no2 = NO2_EDEFAULT;

	/**
	 * The default value of the '{@link #getSo2() <em>So2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSo2()
	 * @generated
	 * @ordered
	 */
	protected static final double SO2_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getSo2() <em>So2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSo2()
	 * @generated
	 * @ordered
	 */
	protected double so2 = SO2_EDEFAULT;

	/**
	 * The default value of the '{@link #getCo() <em>Co</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCo()
	 * @generated
	 * @ordered
	 */
	protected static final double CO_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCo() <em>Co</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCo()
	 * @generated
	 * @ordered
	 */
	protected double co = CO_EDEFAULT;

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
	 * The cached value of the '{@link #getDate() <em>Date</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDate()
	 * @generated
	 * @ordered
	 */
	protected Date date;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AirMeasurementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AirqualityPackage.Literals.AIR_MEASUREMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPm2_5() {
		return pm2_5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPm2_5(double newPm2_5) {
		double oldPm2_5 = pm2_5;
		pm2_5 = newPm2_5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__PM2_5, oldPm2_5, pm2_5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getPm10() {
		return pm10;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPm10(double newPm10) {
		double oldPm10 = pm10;
		pm10 = newPm10;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__PM10, oldPm10, pm10));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getO3() {
		return o3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setO3(double newO3) {
		double oldO3 = o3;
		o3 = newO3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__O3, oldO3, o3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getNo2() {
		return no2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNo2(double newNo2) {
		double oldNo2 = no2;
		no2 = newNo2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__NO2, oldNo2, no2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getSo2() {
		return so2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSo2(double newSo2) {
		double oldSo2 = so2;
		so2 = newSo2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__SO2, oldSo2, so2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getCo() {
		return co;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCo(double newCo) {
		double oldCo = co;
		co = newCo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__CO, oldCo, co));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__STATION, oldStation, station));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__DATE, oldDate, newDate);
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
				msgs = ((InternalEObject)date).eInverseRemove(this, AirqualityPackage.DATE__MEASUREMENT, Date.class, msgs);
			if (newDate != null)
				msgs = ((InternalEObject)newDate).eInverseAdd(this, AirqualityPackage.DATE__MEASUREMENT, Date.class, msgs);
			msgs = basicSetDate(newDate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AirqualityPackage.AIR_MEASUREMENT__DATE, newDate, newDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
				if (date != null)
					msgs = ((InternalEObject)date).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AirqualityPackage.AIR_MEASUREMENT__DATE, null, msgs);
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
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
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
			case AirqualityPackage.AIR_MEASUREMENT__PM2_5:
				return getPm2_5();
			case AirqualityPackage.AIR_MEASUREMENT__PM10:
				return getPm10();
			case AirqualityPackage.AIR_MEASUREMENT__O3:
				return getO3();
			case AirqualityPackage.AIR_MEASUREMENT__NO2:
				return getNo2();
			case AirqualityPackage.AIR_MEASUREMENT__SO2:
				return getSo2();
			case AirqualityPackage.AIR_MEASUREMENT__CO:
				return getCo();
			case AirqualityPackage.AIR_MEASUREMENT__STATION:
				return getStation();
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
				return getDate();
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
			case AirqualityPackage.AIR_MEASUREMENT__PM2_5:
				setPm2_5((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__PM10:
				setPm10((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__O3:
				setO3((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__NO2:
				setNo2((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__SO2:
				setSo2((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__CO:
				setCo((Double)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__STATION:
				setStation((Integer)newValue);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
				setDate((Date)newValue);
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
			case AirqualityPackage.AIR_MEASUREMENT__PM2_5:
				setPm2_5(PM2_5_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__PM10:
				setPm10(PM10_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__O3:
				setO3(O3_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__NO2:
				setNo2(NO2_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__SO2:
				setSo2(SO2_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__CO:
				setCo(CO_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__STATION:
				setStation(STATION_EDEFAULT);
				return;
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
				setDate((Date)null);
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
			case AirqualityPackage.AIR_MEASUREMENT__PM2_5:
				return pm2_5 != PM2_5_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__PM10:
				return pm10 != PM10_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__O3:
				return o3 != O3_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__NO2:
				return no2 != NO2_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__SO2:
				return so2 != SO2_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__CO:
				return co != CO_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__STATION:
				return station != STATION_EDEFAULT;
			case AirqualityPackage.AIR_MEASUREMENT__DATE:
				return date != null;
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
		result.append(" (pm2_5: ");
		result.append(pm2_5);
		result.append(", pm10: ");
		result.append(pm10);
		result.append(", o3: ");
		result.append(o3);
		result.append(", no2: ");
		result.append(no2);
		result.append(", so2: ");
		result.append(so2);
		result.append(", co: ");
		result.append(co);
		result.append(", station: ");
		result.append(station);
		result.append(')');
		return result.toString();
	}

} //AirMeasurementImpl
