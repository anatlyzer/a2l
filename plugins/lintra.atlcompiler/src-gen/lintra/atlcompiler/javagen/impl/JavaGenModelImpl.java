/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JLibType;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Java Gen Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JavaGenModelImpl#getLibTypes <em>Lib Types</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JavaGenModelImpl#getMetaTypes <em>Meta Types</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JavaGenModelImpl#getClasses <em>Classes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JavaGenModelImpl extends MinimalEObjectImpl.Container implements JavaGenModel {
	/**
	 * The cached value of the '{@link #getLibTypes() <em>Lib Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JLibType> libTypes;

	/**
	 * The cached value of the '{@link #getMetaTypes() <em>Meta Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<JMetaType> metaTypes;

	/**
	 * The cached value of the '{@link #getClasses() <em>Classes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<JClass> classes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JavaGenModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JAVA_GEN_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JLibType> getLibTypes() {
		if (libTypes == null) {
			libTypes = new EObjectContainmentEList<JLibType>(JLibType.class, this, JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES);
		}
		return libTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JMetaType> getMetaTypes() {
		if (metaTypes == null) {
			metaTypes = new EObjectContainmentEList<JMetaType>(JMetaType.class, this, JavagenPackage.JAVA_GEN_MODEL__META_TYPES);
		}
		return metaTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JClass> getClasses() {
		if (classes == null) {
			classes = new EObjectContainmentEList<JClass>(JClass.class, this, JavagenPackage.JAVA_GEN_MODEL__CLASSES);
		}
		return classes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES:
				return ((InternalEList<?>)getLibTypes()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JAVA_GEN_MODEL__META_TYPES:
				return ((InternalEList<?>)getMetaTypes()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JAVA_GEN_MODEL__CLASSES:
				return ((InternalEList<?>)getClasses()).basicRemove(otherEnd, msgs);
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
			case JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES:
				return getLibTypes();
			case JavagenPackage.JAVA_GEN_MODEL__META_TYPES:
				return getMetaTypes();
			case JavagenPackage.JAVA_GEN_MODEL__CLASSES:
				return getClasses();
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
			case JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES:
				getLibTypes().clear();
				getLibTypes().addAll((Collection<? extends JLibType>)newValue);
				return;
			case JavagenPackage.JAVA_GEN_MODEL__META_TYPES:
				getMetaTypes().clear();
				getMetaTypes().addAll((Collection<? extends JMetaType>)newValue);
				return;
			case JavagenPackage.JAVA_GEN_MODEL__CLASSES:
				getClasses().clear();
				getClasses().addAll((Collection<? extends JClass>)newValue);
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
			case JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES:
				getLibTypes().clear();
				return;
			case JavagenPackage.JAVA_GEN_MODEL__META_TYPES:
				getMetaTypes().clear();
				return;
			case JavagenPackage.JAVA_GEN_MODEL__CLASSES:
				getClasses().clear();
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
			case JavagenPackage.JAVA_GEN_MODEL__LIB_TYPES:
				return libTypes != null && !libTypes.isEmpty();
			case JavagenPackage.JAVA_GEN_MODEL__META_TYPES:
				return metaTypes != null && !metaTypes.isEmpty();
			case JavagenPackage.JAVA_GEN_MODEL__CLASSES:
				return classes != null && !classes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JavaGenModelImpl
