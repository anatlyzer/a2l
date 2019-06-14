/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.Article;
import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Journal;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getNumber <em>Number</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getJournal <em>Journal</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getVolume <em>Volume</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.impl.ArticleImpl#getYear <em>Year</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArticleImpl extends RecordImpl implements Article {
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
	 * The default value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumber() <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumber()
	 * @generated
	 * @ordered
	 */
	protected int number = NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getJournal() <em>Journal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJournal()
	 * @generated
	 * @ordered
	 */
	protected Journal journal;

	/**
	 * The default value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected static final String VOLUME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVolume() <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVolume()
	 * @generated
	 * @ordered
	 */
	protected String volume = VOLUME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArticleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.ARTICLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__TITLE, oldTitle, title));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__FROM_PAGE, oldFromPage, fromPage));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__TO_PAGE, oldToPage, toPage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumber(int newNumber) {
		int oldNumber = number;
		number = newNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__NUMBER, oldNumber, number));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Journal getJournal() {
		if (journal != null && journal.eIsProxy()) {
			InternalEObject oldJournal = (InternalEObject)journal;
			journal = (Journal)eResolveProxy(oldJournal);
			if (journal != oldJournal) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DBLPPackage.ARTICLE__JOURNAL, oldJournal, journal));
			}
		}
		return journal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Journal basicGetJournal() {
		return journal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJournal(Journal newJournal, NotificationChain msgs) {
		Journal oldJournal = journal;
		journal = newJournal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__JOURNAL, oldJournal, newJournal);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJournal(Journal newJournal) {
		if (newJournal != journal) {
			NotificationChain msgs = null;
			if (journal != null)
				msgs = ((InternalEObject)journal).eInverseRemove(this, DBLPPackage.JOURNAL__ARTICLES, Journal.class, msgs);
			if (newJournal != null)
				msgs = ((InternalEObject)newJournal).eInverseAdd(this, DBLPPackage.JOURNAL__ARTICLES, Journal.class, msgs);
			msgs = basicSetJournal(newJournal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__JOURNAL, newJournal, newJournal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVolume() {
		return volume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVolume(String newVolume) {
		String oldVolume = volume;
		volume = newVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__VOLUME, oldVolume, volume));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__MONTH, oldMonth, month));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.ARTICLE__YEAR, oldYear, year));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DBLPPackage.ARTICLE__JOURNAL:
				if (journal != null)
					msgs = ((InternalEObject)journal).eInverseRemove(this, DBLPPackage.JOURNAL__ARTICLES, Journal.class, msgs);
				return basicSetJournal((Journal)otherEnd, msgs);
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
			case DBLPPackage.ARTICLE__JOURNAL:
				return basicSetJournal(null, msgs);
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
			case DBLPPackage.ARTICLE__TITLE:
				return getTitle();
			case DBLPPackage.ARTICLE__FROM_PAGE:
				return getFromPage();
			case DBLPPackage.ARTICLE__TO_PAGE:
				return getToPage();
			case DBLPPackage.ARTICLE__NUMBER:
				return getNumber();
			case DBLPPackage.ARTICLE__JOURNAL:
				if (resolve) return getJournal();
				return basicGetJournal();
			case DBLPPackage.ARTICLE__VOLUME:
				return getVolume();
			case DBLPPackage.ARTICLE__MONTH:
				return getMonth();
			case DBLPPackage.ARTICLE__YEAR:
				return getYear();
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
			case DBLPPackage.ARTICLE__TITLE:
				setTitle((String)newValue);
				return;
			case DBLPPackage.ARTICLE__FROM_PAGE:
				setFromPage((Integer)newValue);
				return;
			case DBLPPackage.ARTICLE__TO_PAGE:
				setToPage((Integer)newValue);
				return;
			case DBLPPackage.ARTICLE__NUMBER:
				setNumber((Integer)newValue);
				return;
			case DBLPPackage.ARTICLE__JOURNAL:
				setJournal((Journal)newValue);
				return;
			case DBLPPackage.ARTICLE__VOLUME:
				setVolume((String)newValue);
				return;
			case DBLPPackage.ARTICLE__MONTH:
				setMonth((String)newValue);
				return;
			case DBLPPackage.ARTICLE__YEAR:
				setYear((Integer)newValue);
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
			case DBLPPackage.ARTICLE__TITLE:
				setTitle(TITLE_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__FROM_PAGE:
				setFromPage(FROM_PAGE_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__TO_PAGE:
				setToPage(TO_PAGE_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__NUMBER:
				setNumber(NUMBER_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__JOURNAL:
				setJournal((Journal)null);
				return;
			case DBLPPackage.ARTICLE__VOLUME:
				setVolume(VOLUME_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__MONTH:
				setMonth(MONTH_EDEFAULT);
				return;
			case DBLPPackage.ARTICLE__YEAR:
				setYear(YEAR_EDEFAULT);
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
			case DBLPPackage.ARTICLE__TITLE:
				return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
			case DBLPPackage.ARTICLE__FROM_PAGE:
				return fromPage != FROM_PAGE_EDEFAULT;
			case DBLPPackage.ARTICLE__TO_PAGE:
				return toPage != TO_PAGE_EDEFAULT;
			case DBLPPackage.ARTICLE__NUMBER:
				return number != NUMBER_EDEFAULT;
			case DBLPPackage.ARTICLE__JOURNAL:
				return journal != null;
			case DBLPPackage.ARTICLE__VOLUME:
				return VOLUME_EDEFAULT == null ? volume != null : !VOLUME_EDEFAULT.equals(volume);
			case DBLPPackage.ARTICLE__MONTH:
				return MONTH_EDEFAULT == null ? month != null : !MONTH_EDEFAULT.equals(month);
			case DBLPPackage.ARTICLE__YEAR:
				return year != YEAR_EDEFAULT;
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
		result.append(", fromPage: ");
		result.append(fromPage);
		result.append(", toPage: ");
		result.append(toPage);
		result.append(", number: ");
		result.append(number);
		result.append(", volume: ");
		result.append(volume);
		result.append(", month: ");
		result.append(month);
		result.append(", year: ");
		result.append(year);
		result.append(')');
		return result.toString();
	}

} //ArticleImpl
