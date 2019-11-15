/**
 */
package a2l.optimiser.anatlyzerext.impl;

import a2l.optimiser.anatlyzerext.AnatlyzerExtPackage;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import anatlyzer.atlext.OCL.Iterator;
import anatlyzer.atlext.OCL.impl.PropertyCallExpImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Chain Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl#getName <em>Name</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl#getPreChain <em>Pre Chain</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl#getChain <em>Chain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IteratorChainExpImpl extends PropertyCallExpImpl implements IteratorChainExp {
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
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected Iterator iterator;

	/**
	 * The cached value of the '{@link #getPreChain() <em>Pre Chain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreChain()
	 * @generated
	 * @ordered
	 */
	protected EList<IteratorChainElement> preChain;

	/**
	 * The cached value of the '{@link #getChain() <em>Chain</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChain()
	 * @generated
	 * @ordered
	 */
	protected EList<IteratorChainElement> chain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorChainExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnatlyzerExtPackage.Literals.ITERATOR_CHAIN_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterator getIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterator(Iterator newIterator, NotificationChain msgs) {
		Iterator oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR, oldIterator, newIterator);
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
	public void setIterator(Iterator newIterator) {
		if (newIterator != iterator) {
			NotificationChain msgs = null;
			if (iterator != null)
				msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR, null, msgs);
			if (newIterator != null)
				msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR, null, msgs);
			msgs = basicSetIterator(newIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR, newIterator, newIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IteratorChainElement> getPreChain() {
		if (preChain == null) {
			preChain = new EObjectContainmentEList<IteratorChainElement>(IteratorChainElement.class, this, AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN);
		}
		return preChain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IteratorChainElement> getChain() {
		if (chain == null) {
			chain = new EObjectContainmentEList<IteratorChainElement>(IteratorChainElement.class, this, AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN);
		}
		return chain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR:
				return basicSetIterator(null, msgs);
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN:
				return ((InternalEList<?>)getPreChain()).basicRemove(otherEnd, msgs);
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN:
				return ((InternalEList<?>)getChain()).basicRemove(otherEnd, msgs);
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
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__NAME:
				return getName();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR:
				return getIterator();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN:
				return getPreChain();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN:
				return getChain();
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
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__NAME:
				setName((String)newValue);
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR:
				setIterator((Iterator)newValue);
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN:
				getPreChain().clear();
				getPreChain().addAll((Collection<? extends IteratorChainElement>)newValue);
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN:
				getChain().clear();
				getChain().addAll((Collection<? extends IteratorChainElement>)newValue);
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
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR:
				setIterator((Iterator)null);
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN:
				getPreChain().clear();
				return;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN:
				getChain().clear();
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
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__ITERATOR:
				return iterator != null;
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__PRE_CHAIN:
				return preChain != null && !preChain.isEmpty();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP__CHAIN:
				return chain != null && !chain.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //IteratorChainExpImpl
