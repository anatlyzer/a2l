/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;
import lintra.atlcompiler.javagen.JGenericTypeRef;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JavagenPackage;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JGeneric Type Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JGenericTypeRefImpl#getTypeParams <em>Type Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JGenericTypeRefImpl extends JTypeRefImpl implements JGenericTypeRef {
	/**
	 * The cached value of the '{@link #getTypeParams() <em>Type Params</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParams()
	 * @generated
	 * @ordered
	 */
	protected EList<JTypeRef> typeParams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JGenericTypeRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JGENERIC_TYPE_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JTypeRef> getTypeParams() {
		if (typeParams == null) {
			typeParams = new EObjectContainmentEList<JTypeRef>(JTypeRef.class, this, JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS);
		}
		return typeParams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS:
				return ((InternalEList<?>)getTypeParams()).basicRemove(otherEnd, msgs);
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
			case JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS:
				return getTypeParams();
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
			case JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS:
				getTypeParams().clear();
				getTypeParams().addAll((Collection<? extends JTypeRef>)newValue);
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
			case JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS:
				getTypeParams().clear();
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
			case JavagenPackage.JGENERIC_TYPE_REF__TYPE_PARAMS:
				return typeParams != null && !typeParams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JGenericTypeRefImpl
