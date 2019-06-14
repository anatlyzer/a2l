/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JTypeRef;
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
 * An implementation of the model object '<em><b>JMethod</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JMethodImpl#getName <em>Name</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JMethodImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JMethodImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JMethodImpl#getThrows_ <em>Throws </em>}</li>
 * </ul>
 *
 * @generated
 */
public class JMethodImpl extends JBlockImpl implements JMethod {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JParameter> parameters;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected JTypeRef returnType;

	/**
	 * The cached value of the '{@link #getThrows_() <em>Throws </em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThrows_()
	 * @generated
	 * @ordered
	 */
	protected EList<JTypeRef> throws_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JMethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JMETHOD;
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
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JMETHOD__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<JParameter>(JParameter.class, this, JavagenPackage.JMETHOD__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTypeRef getReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(JTypeRef newReturnType, NotificationChain msgs) {
		JTypeRef oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JMETHOD__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(JTypeRef newReturnType) {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JMETHOD__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JMETHOD__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JMETHOD__RETURN_TYPE, newReturnType, newReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JTypeRef> getThrows_() {
		if (throws_ == null) {
			throws_ = new EObjectContainmentEList<JTypeRef>(JTypeRef.class, this, JavagenPackage.JMETHOD__THROWS_);
		}
		return throws_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JMETHOD__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JMETHOD__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case JavagenPackage.JMETHOD__THROWS_:
				return ((InternalEList<?>)getThrows_()).basicRemove(otherEnd, msgs);
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
			case JavagenPackage.JMETHOD__NAME:
				return getName();
			case JavagenPackage.JMETHOD__PARAMETERS:
				return getParameters();
			case JavagenPackage.JMETHOD__RETURN_TYPE:
				return getReturnType();
			case JavagenPackage.JMETHOD__THROWS_:
				return getThrows_();
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
			case JavagenPackage.JMETHOD__NAME:
				setName((String)newValue);
				return;
			case JavagenPackage.JMETHOD__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JParameter>)newValue);
				return;
			case JavagenPackage.JMETHOD__RETURN_TYPE:
				setReturnType((JTypeRef)newValue);
				return;
			case JavagenPackage.JMETHOD__THROWS_:
				getThrows_().clear();
				getThrows_().addAll((Collection<? extends JTypeRef>)newValue);
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
			case JavagenPackage.JMETHOD__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JavagenPackage.JMETHOD__PARAMETERS:
				getParameters().clear();
				return;
			case JavagenPackage.JMETHOD__RETURN_TYPE:
				setReturnType((JTypeRef)null);
				return;
			case JavagenPackage.JMETHOD__THROWS_:
				getThrows_().clear();
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
			case JavagenPackage.JMETHOD__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JavagenPackage.JMETHOD__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case JavagenPackage.JMETHOD__RETURN_TYPE:
				return returnType != null;
			case JavagenPackage.JMETHOD__THROWS_:
				return throws_ != null && !throws_.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} //JMethodImpl
