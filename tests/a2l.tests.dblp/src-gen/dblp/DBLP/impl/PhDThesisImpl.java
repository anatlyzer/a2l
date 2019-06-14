/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.DBLPPackage;
import dblp.DBLP.PhDThesis;
import dblp.DBLP.School;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ph DThesis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.PhDThesisImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.PhDThesisImpl#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.impl.PhDThesisImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.impl.PhDThesisImpl#getSchool <em>School</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhDThesisImpl extends RecordImpl implements PhDThesis {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected String title = TITLE_EDEFAULT;

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
	protected static final String MONTH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMonth() <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMonth()
	 * @generated
	 * @ordered
	 */
	protected String month = MONTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSchool() <em>School</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchool()
	 * @generated
	 * @ordered
	 */
	protected School school;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhDThesisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.PH_DTHESIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTitle(String newTitle) {
		String oldTitle = title;
		title = newTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PH_DTHESIS__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getYear() {
		return year;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYear(int newYear) {
		int oldYear = year;
		year = newYear;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PH_DTHESIS__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMonth(String newMonth) {
		String oldMonth = month;
		month = newMonth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PH_DTHESIS__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public School getSchool() {
		if (school != null && school.eIsProxy()) {
			InternalEObject oldSchool = (InternalEObject)school;
			school = (School)eResolveProxy(oldSchool);
			if (school != oldSchool) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.PH_DTHESIS__SCHOOL, oldSchool, school));
			}
		}
		return school;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public School basicGetSchool() {
		return school;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchool(School newSchool) {
		School oldSchool = school;
		school = newSchool;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PH_DTHESIS__SCHOOL, oldSchool, school));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.PH_DTHESIS__TITLE:
				return getTitle();
			case DBLPPackage.PH_DTHESIS__YEAR:
				return getYear();
			case DBLPPackage.PH_DTHESIS__MONTH:
				return getMonth();
			case DBLPPackage.PH_DTHESIS__SCHOOL:
				if (resolve) return getSchool();
				return basicGetSchool();
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
			case DBLPPackage.PH_DTHESIS__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.PH_DTHESIS__YEAR:
				setYear((Integer)newValue);
				return;
			case DBLPPackage.PH_DTHESIS__MONTH:
				setMonth((String)newValue);
				return;
			case DBLPPackage.PH_DTHESIS__SCHOOL:
				setSchool((School)newValue);
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
			case DBLPPackage.PH_DTHESIS__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.PH_DTHESIS__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.PH_DTHESIS__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DBLPPackage.PH_DTHESIS__SCHOOL:
				setSchool((School)null);
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
			case DBLPPackage.PH_DTHESIS__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.PH_DTHESIS__YEAR:
				return year != YEAR_EDEFAULT;
			case DBLPPackage.PH_DTHESIS__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
			case DBLPPackage.PH_DTHESIS__SCHOOL:
				return school != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (title: ");
		result.append(title);
		result.append(", year: ");
		result.append(year);
		result.append(", month: ");
		result.append(month);
		result.append(')');
		return result.toString();
	}

} //PhDThesisImpl
