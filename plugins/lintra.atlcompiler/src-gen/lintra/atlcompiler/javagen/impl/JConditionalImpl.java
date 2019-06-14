/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JavagenPackage;

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
 * An implementation of the model object '<em><b>JConditional</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JConditionalImpl#getConditions <em>Conditions</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JConditionalImpl#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JConditionalImpl extends JStatementImpl implements JConditional {
	/**
	 * The cached value of the '{@link #getConditions() <em>Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<JConditionalBlock> conditions;

	/**
	 * The cached value of the '{@link #getElse() <em>Else</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElse()
	 * @generated
	 * @ordered
	 */
	protected JConditionalBlock else_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JConditionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JCONDITIONAL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JConditionalBlock> getConditions() {
		if (conditions == null) {
			conditions = new EObjectContainmentEList<JConditionalBlock>(JConditionalBlock.class, this, JavagenPackage.JCONDITIONAL__CONDITIONS);
		}
		return conditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JConditionalBlock getElse() {
		return else_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElse(JConditionalBlock newElse, NotificationChain msgs) {
		JConditionalBlock oldElse = else_;
		else_ = newElse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JCONDITIONAL__ELSE, oldElse, newElse);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElse(JConditionalBlock newElse) {
		if (newElse != else_) {
			NotificationChain msgs = null;
			if (else_ != null)
				msgs = ((InternalEObject)else_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCONDITIONAL__ELSE, null, msgs);
			if (newElse != null)
				msgs = ((InternalEObject)newElse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCONDITIONAL__ELSE, null, msgs);
			msgs = basicSetElse(newElse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JCONDITIONAL__ELSE, newElse, newElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JCONDITIONAL__CONDITIONS:
				return ((InternalEList<?>)getConditions()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCONDITIONAL__ELSE:
				return basicSetElse(null, msgs);
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
			case JavagenPackage.JCONDITIONAL__CONDITIONS:
				return getConditions();
			case JavagenPackage.JCONDITIONAL__ELSE:
				return getElse();
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
			case JavagenPackage.JCONDITIONAL__CONDITIONS:
				getConditions().clear();
				getConditions().addAll((Collection<? extends JConditionalBlock>)newValue);
				return;
			case JavagenPackage.JCONDITIONAL__ELSE:
				setElse((JConditionalBlock)newValue);
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
			case JavagenPackage.JCONDITIONAL__CONDITIONS:
				getConditions().clear();
				return;
			case JavagenPackage.JCONDITIONAL__ELSE:
				setElse((JConditionalBlock)null);
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
			case JavagenPackage.JCONDITIONAL__CONDITIONS:
				return conditions != null && !conditions.isEmpty();
			case JavagenPackage.JCONDITIONAL__ELSE:
				return else_ != null;
		}
		return super.eIsSet(featureID);
	}

} //JConditionalImpl
