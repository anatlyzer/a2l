/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Editor;
import dblp.DBLP.Organization;
import dblp.DBLP.Proceedings;
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
 * An implementation of the model object '<em><b>Proceedings</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getSponsoredBy <em>Sponsored By</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ProceedingsImpl#getIsbn <em>Isbn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProceedingsImpl extends RecordImpl implements Proceedings {
	/**
	 * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String TITLE_EDEFAULT = "";

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
	 * The cached value of the '{@link #getEditors() <em>Editors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEditors()
	 * @generated
	 * @ordered
	 */
	protected EList<Editor> editors;

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
	 * The cached value of the '{@link #getSponsoredBy() <em>Sponsored By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSponsoredBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Organization> sponsoredBy;

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
	 * The default value of the '{@link #getIsbn() <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsbn()
	 * @generated
	 * @ordered
	 */
	protected static final String ISBN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIsbn() <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIsbn()
	 * @generated
	 * @ordered
	 */
	protected String isbn = ISBN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProceedingsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.PROCEEDINGS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, DBLPPackage.PROCEEDINGS__EDITORS);
		}
		return editors;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__PUBLISHER, oldPublisher, publisher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Organization> getSponsoredBy() {
		if (sponsoredBy == null) {
			sponsoredBy = new EObjectResolvingEList<Organization>(Organization.class, this, DBLPPackage.PROCEEDINGS__SPONSORED_BY);
		}
		return sponsoredBy;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsbn(String newIsbn) {
		String oldIsbn = isbn;
		isbn = newIsbn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.PROCEEDINGS__ISBN, oldIsbn, isbn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.PROCEEDINGS__TITLE:
				return getTitle();
			case DBLPPackage.PROCEEDINGS__YEAR:
				return getYear();
			case DBLPPackage.PROCEEDINGS__EDITORS:
				return getEditors();
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				return getSponsoredBy();
			case DBLPPackage.PROCEEDINGS__MONTH:
				return getMonth();
			case DBLPPackage.PROCEEDINGS__ISBN:
				return getIsbn();
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
			case DBLPPackage.PROCEEDINGS__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__YEAR:
				setYear((Integer)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				getSponsoredBy().clear();
				getSponsoredBy().addAll((Collection<? extends Organization>)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__MONTH:
				setMonth((String)newValue);
				return;
			case DBLPPackage.PROCEEDINGS__ISBN:
				setIsbn((String)newValue);
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
			case DBLPPackage.PROCEEDINGS__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.PROCEEDINGS__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.PROCEEDINGS__EDITORS:
				getEditors().clear();
				return;
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				setPublisher((Publisher)null);
				return;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				getSponsoredBy().clear();
				return;
			case DBLPPackage.PROCEEDINGS__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DBLPPackage.PROCEEDINGS__ISBN:
				setIsbn(ISBN_EDEFAULT);
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
			case DBLPPackage.PROCEEDINGS__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.PROCEEDINGS__YEAR:
				return year != YEAR_EDEFAULT;
			case DBLPPackage.PROCEEDINGS__EDITORS:
				return editors != null && !editors.isEmpty();
			case DBLPPackage.PROCEEDINGS__PUBLISHER:
				return publisher != null;
			case DBLPPackage.PROCEEDINGS__SPONSORED_BY:
				return sponsoredBy != null && !sponsoredBy.isEmpty();
			case DBLPPackage.PROCEEDINGS__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
			case DBLPPackage.PROCEEDINGS__ISBN:
				return ISBN_EDEFAULT == null ? isbn != null : !ISBN_EDEFAULT.equals(isbn);
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
		result.append(", isbn: ");
		result.append(isbn);
		result.append(')');
		return result.toString();
	}

} //ProceedingsImpl
