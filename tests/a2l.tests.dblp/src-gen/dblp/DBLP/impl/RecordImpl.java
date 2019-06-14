/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.Author;
import dblp.DBLP.DBLPPackage;
import dblp.DBLP.Record;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.impl.RecordImpl#getEe <em>Ee</em>}</li>
 *   <li>{@link dblp.DBLP.impl.RecordImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link dblp.DBLP.impl.RecordImpl#getKey <em>Key</em>}</li>
 *   <li>{@link dblp.DBLP.impl.RecordImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link dblp.DBLP.impl.RecordImpl#getMdate <em>Mdate</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RecordImpl extends MinimalEObjectImpl.Container implements Record {
	/**
	 * The default value of the '{@link #getEe() <em>Ee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEe()
	 * @generated
	 * @ordered
	 */
	protected static final String EE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEe() <em>Ee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEe()
	 * @generated
	 * @ordered
	 */
	protected String ee = EE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected String url = URL_EDEFAULT;

	/**
	 * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected String key = KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList<Author> authors;

	/**
	 * The default value of the '{@link #getMdate() <em>Mdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMdate()
	 * @generated
	 * @ordered
	 */
	protected static final String MDATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMdate() <em>Mdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMdate()
	 * @generated
	 * @ordered
	 */
	protected String mdate = MDATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DBLPPackage.Literals.RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEe() {
		return ee;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEe(String newEe) {
		String oldEe = ee;
		ee = newEe;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.RECORD__EE, oldEe, ee));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.RECORD__URL, oldUrl, url));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(String newKey) {
		String oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.RECORD__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Author> getAuthors() {
		if (authors == null) {
			authors = new EObjectWithInverseResolvingEList.ManyInverse<Author>(Author.class, this, DBLPPackage.RECORD__AUTHORS, DBLPPackage.AUTHOR__RECORDS);
		}
		return authors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMdate() {
		return mdate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMdate(String newMdate) {
		String oldMdate = mdate;
		mdate = newMdate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DBLPPackage.RECORD__MDATE, oldMdate, mdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DBLPPackage.RECORD__AUTHORS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAuthors()).basicAdd(otherEnd, msgs);
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
			case DBLPPackage.RECORD__AUTHORS:
				return ((InternalEList<?>)getAuthors()).basicRemove(otherEnd, msgs);
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
			case DBLPPackage.RECORD__EE:
				return getEe();
			case DBLPPackage.RECORD__URL:
				return getUrl();
			case DBLPPackage.RECORD__KEY:
				return getKey();
			case DBLPPackage.RECORD__AUTHORS:
				return getAuthors();
			case DBLPPackage.RECORD__MDATE:
				return getMdate();
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
			case DBLPPackage.RECORD__EE:
				setEe((String)newValue);
				return;
			case DBLPPackage.RECORD__URL:
				setUrl((String)newValue);
				return;
			case DBLPPackage.RECORD__KEY:
				setKey((String)newValue);
				return;
			case DBLPPackage.RECORD__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection<? extends Author>)newValue);
				return;
			case DBLPPackage.RECORD__MDATE:
				setMdate((String)newValue);
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
			case DBLPPackage.RECORD__EE:
				setEe(EE_EDEFAULT);
				return;
			case DBLPPackage.RECORD__URL:
				setUrl(URL_EDEFAULT);
				return;
			case DBLPPackage.RECORD__KEY:
				setKey(KEY_EDEFAULT);
				return;
			case DBLPPackage.RECORD__AUTHORS:
				getAuthors().clear();
				return;
			case DBLPPackage.RECORD__MDATE:
				setMdate(MDATE_EDEFAULT);
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
			case DBLPPackage.RECORD__EE:
				return EE_EDEFAULT == null ? ee != null : !EE_EDEFAULT.equals(ee);
			case DBLPPackage.RECORD__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case DBLPPackage.RECORD__KEY:
				return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
			case DBLPPackage.RECORD__AUTHORS:
				return authors != null && !authors.isEmpty();
			case DBLPPackage.RECORD__MDATE:
				return MDATE_EDEFAULT == null ? mdate != null : !MDATE_EDEFAULT.equals(mdate);
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
		result.append(" (ee: ");
		result.append(ee);
		result.append(", url: ");
		result.append(url);
		result.append(", key: ");
		result.append(key);
		result.append(", mdate: ");
		result.append(mdate);
		result.append(')');
		return result.toString();
	}

} //RecordImpl
