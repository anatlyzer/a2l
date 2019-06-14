/**
 */
package lintra.atlcompiler.javagen.impl;

import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JavagenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JMeta Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JMetaTypeImpl#getQualifiedJavaName <em>Qualified Java Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JMetaTypeImpl extends JTypeImpl implements JMetaType {
	/**
	 * The default value of the '{@link #getQualifiedJavaName() <em>Qualified Java Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedJavaName()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIED_JAVA_NAME_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getQualifiedJavaName() <em>Qualified Java Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifiedJavaName()
	 * @generated
	 * @ordered
	 */
	protected String qualifiedJavaName = QUALIFIED_JAVA_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JMetaTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JMETA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQualifiedJavaName() {
		return qualifiedJavaName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQualifiedJavaName(String newQualifiedJavaName) {
		String oldQualifiedJavaName = qualifiedJavaName;
		qualifiedJavaName = newQualifiedJavaName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JMETA_TYPE__QUALIFIED_JAVA_NAME, oldQualifiedJavaName, qualifiedJavaName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JavagenPackage.JMETA_TYPE__QUALIFIED_JAVA_NAME:
				return getQualifiedJavaName();
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
			case JavagenPackage.JMETA_TYPE__QUALIFIED_JAVA_NAME:
				setQualifiedJavaName((String)newValue);
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
			case JavagenPackage.JMETA_TYPE__QUALIFIED_JAVA_NAME:
				setQualifiedJavaName(QUALIFIED_JAVA_NAME_EDEFAULT);
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
			case JavagenPackage.JMETA_TYPE__QUALIFIED_JAVA_NAME:
				return QUALIFIED_JAVA_NAME_EDEFAULT == null ? qualifiedJavaName != null : !QUALIFIED_JAVA_NAME_EDEFAULT.equals(qualifiedJavaName);
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
		result.append(" (qualifiedJavaName: ");
		result.append(qualifiedJavaName);
		result.append(')');
		return result.toString();
	}

} //JMetaTypeImpl
