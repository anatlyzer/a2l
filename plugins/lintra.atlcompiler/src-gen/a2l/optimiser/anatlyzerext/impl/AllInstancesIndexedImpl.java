/**
 */
package a2l.optimiser.anatlyzerext.impl;

import a2l.optimiser.anatlyzerext.AllInstancesIndexed;
import a2l.optimiser.anatlyzerext.AnatlyzerExtPackage;

import anatlyzer.atlext.OCL.IteratorExp;
import anatlyzer.atlext.OCL.impl.OclExpressionImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>All Instances Indexed</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.AllInstancesIndexedImpl#getOriginal <em>Original</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.AllInstancesIndexedImpl#getOptimisationHint <em>Optimisation Hint</em>}</li>
 *   <li>{@link a2l.optimiser.anatlyzerext.impl.AllInstancesIndexedImpl#getIndexType <em>Index Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AllInstancesIndexedImpl extends OclExpressionImpl implements AllInstancesIndexed {
	/**
	 * The cached value of the '{@link #getOriginal() <em>Original</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginal()
	 * @generated
	 * @ordered
	 */
	protected IteratorExp original;

	/**
	 * The default value of the '{@link #getOptimisationHint() <em>Optimisation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimisationHint()
	 * @generated
	 * @ordered
	 */
	protected static final Object OPTIMISATION_HINT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOptimisationHint() <em>Optimisation Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOptimisationHint()
	 * @generated
	 * @ordered
	 */
	protected Object optimisationHint = OPTIMISATION_HINT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected static final String INDEX_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIndexType() <em>Index Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndexType()
	 * @generated
	 * @ordered
	 */
	protected String indexType = INDEX_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AllInstancesIndexedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnatlyzerExtPackage.Literals.ALL_INSTANCES_INDEXED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IteratorExp getOriginal() {
		return original;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOriginal(IteratorExp newOriginal, NotificationChain msgs) {
		IteratorExp oldOriginal = original;
		original = newOriginal;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL, oldOriginal, newOriginal);
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
	public void setOriginal(IteratorExp newOriginal) {
		if (newOriginal != original) {
			NotificationChain msgs = null;
			if (original != null)
				msgs = ((InternalEObject)original).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL, null, msgs);
			if (newOriginal != null)
				msgs = ((InternalEObject)newOriginal).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL, null, msgs);
			msgs = basicSetOriginal(newOriginal, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL, newOriginal, newOriginal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getOptimisationHint() {
		return optimisationHint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOptimisationHint(Object newOptimisationHint) {
		Object oldOptimisationHint = optimisationHint;
		optimisationHint = newOptimisationHint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__OPTIMISATION_HINT, oldOptimisationHint, optimisationHint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIndexType() {
		return indexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIndexType(String newIndexType) {
		String oldIndexType = indexType;
		indexType = newIndexType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__INDEX_TYPE, oldIndexType, indexType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL:
				return basicSetOriginal(null, msgs);
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
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL:
				return getOriginal();
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__OPTIMISATION_HINT:
				return getOptimisationHint();
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__INDEX_TYPE:
				return getIndexType();
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
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL:
				setOriginal((IteratorExp)newValue);
				return;
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__OPTIMISATION_HINT:
				setOptimisationHint(newValue);
				return;
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__INDEX_TYPE:
				setIndexType((String)newValue);
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
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL:
				setOriginal((IteratorExp)null);
				return;
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__OPTIMISATION_HINT:
				setOptimisationHint(OPTIMISATION_HINT_EDEFAULT);
				return;
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__INDEX_TYPE:
				setIndexType(INDEX_TYPE_EDEFAULT);
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
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__ORIGINAL:
				return original != null;
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__OPTIMISATION_HINT:
				return OPTIMISATION_HINT_EDEFAULT == null ? optimisationHint != null : !OPTIMISATION_HINT_EDEFAULT.equals(optimisationHint);
			case AnatlyzerExtPackage.ALL_INSTANCES_INDEXED__INDEX_TYPE:
				return INDEX_TYPE_EDEFAULT == null ? indexType != null : !INDEX_TYPE_EDEFAULT.equals(indexType);
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
		result.append(" (optimisationHint: ");
		result.append(optimisationHint);
		result.append(", indexType: ");
		result.append(indexType);
		result.append(')');
		return result.toString();
	}

} //AllInstancesIndexedImpl
