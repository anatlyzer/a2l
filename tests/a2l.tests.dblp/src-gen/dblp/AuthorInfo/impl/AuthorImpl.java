/**
 */
package dblp.AuthorInfo.impl;

import dblp.AuthorInfo.Author;
import dblp.AuthorInfo.AuthorInfoPackage;
import dblp.AuthorInfo.Conference;
import dblp.AuthorInfo.Journal;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#getName <em>Name</em>}</li>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#getNumOfPapers <em>Num Of Papers</em>}</li>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#isActive <em>Active</em>}</li>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#getPublishesInC <em>Publishes In C</em>}</li>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#getCoauthor <em>Coauthor</em>}</li>
 *   <li>{@link dblp.AuthorInfo.impl.AuthorImpl#getPublishesInJ <em>Publishes In J</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AuthorImpl extends MinimalEObjectImpl.Container implements Author {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNumOfPapers() <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfPapers()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_OF_PAPERS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNumOfPapers() <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfPapers()
	 * @generated
	 * @ordered
	 */
	protected int numOfPapers = NUM_OF_PAPERS_EDEFAULT;

	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPublishesInC() <em>Publishes In C</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishesInC()
	 * @generated
	 * @ordered
	 */
	protected EList<Conference> publishesInC;

	/**
	 * The cached value of the '{@link #getCoauthor() <em>Coauthor</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoauthor()
	 * @generated
	 * @ordered
	 */
	protected EList<Author> coauthor;

	/**
	 * The cached value of the '{@link #getPublishesInJ() <em>Publishes In J</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishesInJ()
	 * @generated
	 * @ordered
	 */
	protected EList<Journal> publishesInJ;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AuthorInfoPackage.Literals.AUTHOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuthorInfoPackage.AUTHOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNumOfPapers() {
		return numOfPapers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumOfPapers(int newNumOfPapers) {
		int oldNumOfPapers = numOfPapers;
		numOfPapers = newNumOfPapers;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuthorInfoPackage.AUTHOR__NUM_OF_PAPERS, oldNumOfPapers, numOfPapers));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AuthorInfoPackage.AUTHOR__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Conference> getPublishesInC() {
		if (publishesInC == null) {
			publishesInC = new EObjectResolvingEList<Conference>(Conference.class, this, AuthorInfoPackage.AUTHOR__PUBLISHES_IN_C);
		}
		return publishesInC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Author> getCoauthor() {
		if (coauthor == null) {
			coauthor = new EObjectResolvingEList<Author>(Author.class, this, AuthorInfoPackage.AUTHOR__COAUTHOR);
		}
		return coauthor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Journal> getPublishesInJ() {
		if (publishesInJ == null) {
			publishesInJ = new EObjectResolvingEList<Journal>(Journal.class, this, AuthorInfoPackage.AUTHOR__PUBLISHES_IN_J);
		}
		return publishesInJ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AuthorInfoPackage.AUTHOR__NAME:
				return getName();
			case AuthorInfoPackage.AUTHOR__NUM_OF_PAPERS:
				return getNumOfPapers();
			case AuthorInfoPackage.AUTHOR__ACTIVE:
				return isActive();
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_C:
				return getPublishesInC();
			case AuthorInfoPackage.AUTHOR__COAUTHOR:
				return getCoauthor();
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_J:
				return getPublishesInJ();
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
			case AuthorInfoPackage.AUTHOR__NAME:
				setName((String)newValue);
				return;
			case AuthorInfoPackage.AUTHOR__NUM_OF_PAPERS:
				setNumOfPapers((Integer)newValue);
				return;
			case AuthorInfoPackage.AUTHOR__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_C:
				getPublishesInC().clear();
				getPublishesInC().addAll((Collection<? extends Conference>)newValue);
				return;
			case AuthorInfoPackage.AUTHOR__COAUTHOR:
				getCoauthor().clear();
				getCoauthor().addAll((Collection<? extends Author>)newValue);
				return;
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_J:
				getPublishesInJ().clear();
				getPublishesInJ().addAll((Collection<? extends Journal>)newValue);
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
			case AuthorInfoPackage.AUTHOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AuthorInfoPackage.AUTHOR__NUM_OF_PAPERS:
				setNumOfPapers(NUM_OF_PAPERS_EDEFAULT);
				return;
			case AuthorInfoPackage.AUTHOR__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_C:
				getPublishesInC().clear();
				return;
			case AuthorInfoPackage.AUTHOR__COAUTHOR:
				getCoauthor().clear();
				return;
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_J:
				getPublishesInJ().clear();
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
			case AuthorInfoPackage.AUTHOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AuthorInfoPackage.AUTHOR__NUM_OF_PAPERS:
				return numOfPapers != NUM_OF_PAPERS_EDEFAULT;
			case AuthorInfoPackage.AUTHOR__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_C:
				return publishesInC != null && !publishesInC.isEmpty();
			case AuthorInfoPackage.AUTHOR__COAUTHOR:
				return coauthor != null && !coauthor.isEmpty();
			case AuthorInfoPackage.AUTHOR__PUBLISHES_IN_J:
				return publishesInJ != null && !publishesInJ.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", numOfPapers: ");
		result.append(numOfPapers);
		result.append(", active: ");
		result.append(active);
		result.append(')');
		return result.toString();
	}

} //AuthorImpl
