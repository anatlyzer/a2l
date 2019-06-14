/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Editor;
import dblp.DBLP.InProceedings;
import dblp.DBLP.Organization;
import dblp.DBLP.Publisher;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>In Proceedings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getBootitle <em>Bootitle</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getOrganization <em>Organization</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InProceedingsImpl#getPublisher <em>Publisher</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InProceedingsImpl extends RecordImpl implements InProceedings {
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
	 * The default value of the '{@link #getBootitle() <em>Bootitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBootitle()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOTITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBootitle() <em>Bootitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBootitle()
	 * @generated
	 * @ordered
	 */
	protected String bootitle = BOOTITLE_EDEFAULT;

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
	 * The default value of the '{@link #getFromPage() <em>From Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPage()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_PAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromPage() <em>From Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromPage()
	 * @generated
	 * @ordered
	 */
	protected int fromPage = FROM_PAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getToPage() <em>To Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPage()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_PAGE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToPage() <em>To Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToPage()
	 * @generated
	 * @ordered
	 */
	protected int toPage = TO_PAGE_EDEFAULT;

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
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

	/**
	 * The cached value of the '{@link #getOrganization() <em>Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrganization()
	 * @generated
	 * @ordered
	 */
	protected Organization organization;

	/**
	 * The cached value of the '{@link #getPublisher() <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublisher()
	 * @generated
	 * @ordered
	 */
	protected Publisher publisher;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InProceedingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.IN_PROCEEDINGS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBootitle() {
		return bootitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBootitle(String newBootitle) {
		String oldBootitle = bootitle;
		bootitle = newBootitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__BOOTITLE, oldBootitle, bootitle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFromPage() {
		return fromPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromPage(int newFromPage) {
		int oldFromPage = fromPage;
		fromPage = newFromPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__FROM_PAGE, oldFromPage, fromPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToPage() {
		return toPage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToPage(int newToPage) {
		int oldToPage = toPage;
		toPage = newToPage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__TO_PAGE, oldToPage, toPage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, DBLPPackage.IN_PROCEEDINGS__EDITORS);
		}
		return editors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization getOrganization() {
		if (organization != null && organization.eIsProxy()) {
			InternalEObject oldOrganization = (InternalEObject)organization;
			organization = (Organization)eResolveProxy(oldOrganization);
			if (organization != oldOrganization) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.IN_PROCEEDINGS__ORGANIZATION, oldOrganization, organization));
			}
		}
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization basicGetOrganization() {
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrganization(Organization newOrganization) {
		Organization oldOrganization = organization;
		organization = newOrganization;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__ORGANIZATION, oldOrganization, organization));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publisher getPublisher() {
		if (publisher != null && publisher.eIsProxy()) {
			InternalEObject oldPublisher = (InternalEObject)publisher;
			publisher = (Publisher)eResolveProxy(oldPublisher);
			if (publisher != oldPublisher) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.IN_PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
			}
		}
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publisher basicGetPublisher() {
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublisher(Publisher newPublisher) {
		Publisher oldPublisher = publisher;
		publisher = newPublisher;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.IN_PROCEEDINGS__TITLE:
				return getTitle();
			case DBLPPackage.IN_PROCEEDINGS__BOOTITLE:
				return getBootitle();
			case DBLPPackage.IN_PROCEEDINGS__YEAR:
				return getYear();
			case DBLPPackage.IN_PROCEEDINGS__FROM_PAGE:
				return getFromPage();
			case DBLPPackage.IN_PROCEEDINGS__TO_PAGE:
				return getToPage();
			case DBLPPackage.IN_PROCEEDINGS__MONTH:
				return getMonth();
			case DBLPPackage.IN_PROCEEDINGS__EDITORS:
				return getEditors();
			case DBLPPackage.IN_PROCEEDINGS__ORGANIZATION:
				if (resolve) return getOrganization();
				return basicGetOrganization();
			case DBLPPackage.IN_PROCEEDINGS__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DBLPPackage.IN_PROCEEDINGS__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__BOOTITLE:
				setBootitle((String)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__YEAR:
				setYear((Integer)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__FROM_PAGE:
				setFromPage((Integer)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__TO_PAGE:
				setToPage((Integer)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__MONTH:
				setMonth((String)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__ORGANIZATION:
				setOrganization((Organization)newValue);
				return;
			case DBLPPackage.IN_PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)newValue);
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
			case DBLPPackage.IN_PROCEEDINGS__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__BOOTITLE:
				setBootitle(BOOTITLE_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__FROM_PAGE:
				setFromPage(FROM_PAGE_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__TO_PAGE:
				setToPage(TO_PAGE_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DBLPPackage.IN_PROCEEDINGS__EDITORS:
				getEditors().clear();
				return;
			case DBLPPackage.IN_PROCEEDINGS__ORGANIZATION:
				setOrganization((Organization)null);
				return;
			case DBLPPackage.IN_PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)null);
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
			case DBLPPackage.IN_PROCEEDINGS__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.IN_PROCEEDINGS__BOOTITLE:
				return BOOTITLE_EDEFAULT == null ? bootitle != null : !BOOTITLE_EDEFAULT.equals(bootitle);
			case DBLPPackage.IN_PROCEEDINGS__YEAR:
				return year != YEAR_EDEFAULT;
			case DBLPPackage.IN_PROCEEDINGS__FROM_PAGE:
				return fromPage != FROM_PAGE_EDEFAULT;
			case DBLPPackage.IN_PROCEEDINGS__TO_PAGE:
				return toPage != TO_PAGE_EDEFAULT;
			case DBLPPackage.IN_PROCEEDINGS__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
			case DBLPPackage.IN_PROCEEDINGS__EDITORS:
				return editors != null && !editors.isEmpty();
			case DBLPPackage.IN_PROCEEDINGS__ORGANIZATION:
				return organization != null;
			case DBLPPackage.IN_PROCEEDINGS__PUBLISHER:
				return publisher != null;
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
		result.append(", bootitle: ");
		result.append(bootitle);
		result.append(", year: ");
		result.append(year);
		result.append(", fromPage: ");
		result.append(fromPage);
		result.append(", toPage: ");
		result.append(toPage);
		result.append(", month: ");
		result.append(month);
		result.append(')');
		return result.toString();
	}

} //InProceedingsImpl
