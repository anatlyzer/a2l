/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.Book;
import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Publisher;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getSeries <em>Series</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getEdition <em>Edition</em>}</li>
 *   <li>{@link dblp.DBLP.impl.BookImpl#getIsbn <em>Isbn</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BookImpl extends RecordImpl implements Book {
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
	protected static final String MONTH_EDEFAULT = "0";

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
	 * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected static final int VOLUME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected int volume = VOLUME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSeries() <em>Series</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeries()
	 * @generated
	 * @ordered
	 */
	protected static final String SERIES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSeries() <em>Series</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSeries()
	 * @generated
	 * @ordered
	 */
	protected String series = SERIES_EDEFAULT;

	/**
	 * The default value of the '{@link #getEdition() <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdition()
	 * @generated
	 * @ordered
	 */
	protected static final int EDITION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEdition() <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdition()
	 * @generated
	 * @ordered
	 */
	protected int edition = EDITION_EDEFAULT;

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
	protected BookImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.BOOK;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__YEAR, oldYear, year));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.BOOK__PUBLISHER, oldPublisher, publisher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__PUBLISHER, oldPublisher, publisher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__MONTH, oldMonth, month));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(int newVolume) {
		int oldVolume = volume;
		volume = newVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__VOLUME, oldVolume, volume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSeries() {
		return series;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSeries(String newSeries) {
		String oldSeries = series;
		series = newSeries;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__SERIES, oldSeries, series));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEdition() {
		return edition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdition(int newEdition) {
		int oldEdition = edition;
		edition = newEdition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__EDITION, oldEdition, edition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.BOOK__ISBN, oldIsbn, isbn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DBLPPackage.BOOK__TITLE:
				return getTitle();
			case DBLPPackage.BOOK__YEAR:
				return getYear();
			case DBLPPackage.BOOK__PUBLISHER:
				if (resolve) return getPublisher();
				return basicGetPublisher();
			case DBLPPackage.BOOK__MONTH:
				return getMonth();
			case DBLPPackage.BOOK__VOLUME:
				return getVolume();
			case DBLPPackage.BOOK__SERIES:
				return getSeries();
			case DBLPPackage.BOOK__EDITION:
				return getEdition();
			case DBLPPackage.BOOK__ISBN:
				return getIsbn();
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
			case DBLPPackage.BOOK__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.BOOK__YEAR:
				setYear((Integer)newValue);
				return;
			case DBLPPackage.BOOK__PUBLISHER:
				setPublisher((Publisher)newValue);
				return;
			case DBLPPackage.BOOK__MONTH:
				setMonth((String)newValue);
				return;
			case DBLPPackage.BOOK__VOLUME:
				setVolume((Integer)newValue);
				return;
			case DBLPPackage.BOOK__SERIES:
				setSeries((String)newValue);
				return;
			case DBLPPackage.BOOK__EDITION:
				setEdition((Integer)newValue);
				return;
			case DBLPPackage.BOOK__ISBN:
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
			case DBLPPackage.BOOK__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.BOOK__YEAR:
				setYear(YEAR_EDEFAULT);
				return;
			case DBLPPackage.BOOK__PUBLISHER:
				setPublisher((Publisher)null);
				return;
			case DBLPPackage.BOOK__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DBLPPackage.BOOK__VOLUME:
				setVolume(VOLUME_EDEFAULT);
				return;
			case DBLPPackage.BOOK__SERIES:
				setSeries(SERIES_EDEFAULT);
				return;
			case DBLPPackage.BOOK__EDITION:
				setEdition(EDITION_EDEFAULT);
				return;
			case DBLPPackage.BOOK__ISBN:
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
			case DBLPPackage.BOOK__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.BOOK__YEAR:
				return year != YEAR_EDEFAULT;
			case DBLPPackage.BOOK__PUBLISHER:
				return publisher != null;
			case DBLPPackage.BOOK__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
			case DBLPPackage.BOOK__VOLUME:
				return volume != VOLUME_EDEFAULT;
			case DBLPPackage.BOOK__SERIES:
				return SERIES_EDEFAULT == null ? series != null : !SERIES_EDEFAULT.equals(series);
			case DBLPPackage.BOOK__EDITION:
				return edition != EDITION_EDEFAULT;
			case DBLPPackage.BOOK__ISBN:
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
		result.append(", volume: ");
		result.append(volume);
		result.append(", series: ");
		result.append(series);
		result.append(", edition: ");
		result.append(edition);
		result.append(", isbn: ");
		result.append(isbn);
		result.append(')');
		return result.toString();
	}

} //BookImpl
