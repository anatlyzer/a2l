/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Editor;
import dblp.DBLP.InCollection;
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
 * An implementation of the model object '<em><b>In Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getBookTitle <em>Book Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getSponsoredBy <em>Sponsored By</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.impl.InCollectionImpl#getMonth <em>Month</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InCollectionImpl extends RecordImpl implements InCollection {
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
	 * The default value of the '{@link #getBookTitle() <em>Book Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBookTitle()
	 * @generated
	 * @ordered
	 */
	protected static final String BOOK_TITLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBookTitle() <em>Book Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBookTitle()
	 * @generated
	 * @ordered
	 */
	protected String bookTitle = BOOK_TITLE_EDEFAULT;

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
	 * The cached value of the '{@link #getSponsoredBy() <em>Sponsored By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSponsoredBy()
	 * @generated
	 * @ordered
	 */
	protected Organization sponsoredBy;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.IN_COLLECTION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__TITLE, oldTitle, title));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBookTitle(String newBookTitle) {
		String oldBookTitle = bookTitle;
		bookTitle = newBookTitle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__BOOK_TITLE, oldBookTitle, bookTitle));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Editor> getEditors() {
		if (editors == null) {
			editors = new EObjectResolvingEList<Editor>(Editor.class, this, DBLPPackage.IN_COLLECTION__EDITORS);
		}
		return editors;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__FROM_PAGE, oldFromPage, fromPage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__TO_PAGE, oldToPage, toPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization getSponsoredBy() {
		if (sponsoredBy != null && sponsoredBy.eIsProxy()) {
			InternalEObject oldSponsoredBy = (InternalEObject)sponsoredBy;
			sponsoredBy = (Organization)eResolveProxy(oldSponsoredBy);
			if (sponsoredBy != oldSponsoredBy) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.IN_COLLECTION__SPONSORED_BY, oldSponsoredBy, sponsoredBy));
			}
		}
		return sponsoredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization basicGetSponsoredBy() {
		return sponsoredBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSponsoredBy(Organization newSponsoredBy) {
		Organization oldSponsoredBy = sponsoredBy;
		sponsoredBy = newSponsoredBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__SPONSORED_BY, oldSponsoredBy, sponsoredBy));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.IN_COLLECTION__PUBLISHER, oldPublisher, publisher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__PUBLISHER, oldPublisher, publisher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.IN_COLLECTION__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.IN_COLLECTION__TITLE:
				return getTitle();
			case DBLPPackage.IN_COLLECTION__BOOK_TITLE:
				return getBookTitle();
			case DBLPPackage.IN_COLLECTION__YEAR:
				return getYear();
			case DBLPPackage.IN_COLLECTION__EDITORS:
				return getEditors();
			case DBLPPackage.IN_COLLECTION__FROM_PAGE:
				return getFromPage();
			case DBLPPackage.IN_COLLECTION__TO_PAGE:
				return getToPage();
			case DBLPPackage.IN_COLLECTION__SPONSORED_BY:
				if (resolve) return getSponsoredBy();
				return basicGetSponsoredBy();
			case DBLPPackage.IN_COLLECTION__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
			case DBLPPackage.IN_COLLECTION__MONTH:
				return getMonth();
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
			case DBLPPackage.IN_COLLECTION__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__BOOK_TITLE:
				setBookTitle((String)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__YEAR:
				setYear((Integer)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__EDITORS:
				getEditors().clear();
				getEditors().addAll((Collection<? extends Editor>)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__FROM_PAGE:
				setFromPage((Integer)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__TO_PAGE:
				setToPage((Integer)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__SPONSORED_BY:
				setSponsoredBy((Organization)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__PUBLISHER:
				setPublisher((Publisher)newValue);
				return;
			case DBLPPackage.IN_COLLECTION__MONTH:
				setMonth((String)newValue);
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
			case DBLPPackage.IN_COLLECTION__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.IN_COLLECTION__BOOK_TITLE:
				setBookTitle(BOOK_TITLE_EDEFAULT);
				return;
			case DBLPPackage.IN_COLLECTION__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.IN_COLLECTION__EDITORS:
				getEditors().clear();
				return;
			case DBLPPackage.IN_COLLECTION__FROM_PAGE:
				setFromPage(FROM_PAGE_EDEFAULT);
				return;
			case DBLPPackage.IN_COLLECTION__TO_PAGE:
				setToPage(TO_PAGE_EDEFAULT);
				return;
			case DBLPPackage.IN_COLLECTION__SPONSORED_BY:
				setSponsoredBy((Organization)null);
				return;
			case DBLPPackage.IN_COLLECTION__PUBLISHER:
				setPublisher((Publisher)null);
				return;
			case DBLPPackage.IN_COLLECTION__MONTH:
				setMonth(MONTH_EDEFAULT);
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
			case DBLPPackage.IN_COLLECTION__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.IN_COLLECTION__BOOK_TITLE:
				return BOOK_TITLE_EDEFAULT == null ? bookTitle != null : !BOOK_TITLE_EDEFAULT.equals(bookTitle);
			case DBLPPackage.IN_COLLECTION__YEAR:
				return year != YEAR_EDEFAULT;
			case DBLPPackage.IN_COLLECTION__EDITORS:
				return editors != null && !editors.isEmpty();
			case DBLPPackage.IN_COLLECTION__FROM_PAGE:
				return fromPage != FROM_PAGE_EDEFAULT;
			case DBLPPackage.IN_COLLECTION__TO_PAGE:
				return toPage != TO_PAGE_EDEFAULT;
			case DBLPPackage.IN_COLLECTION__SPONSORED_BY:
				return sponsoredBy != null;
			case DBLPPackage.IN_COLLECTION__PUBLISHER:
				return publisher != null;
			case DBLPPackage.IN_COLLECTION__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
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
		result.append(", bookTitle: ");
		result.append(bookTitle);
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

} //InCollectionImpl
