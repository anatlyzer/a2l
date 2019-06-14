/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JThis;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JavagenPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JClass</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getExtra <em>Extra</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getPkg <em>Pkg</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getExtends_ <em>Extends </em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getImports <em>Imports</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClassImpl#getThis_ <em>This </em>}</li>
 * </ul>
 *
 * @generated
 */
public class JClassImpl extends JTypeImpl implements JClass {
	/**
	 * The default value of the '{@link #getExtra() <em>Extra</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtra()
	 * @generated
	 * @ordered
	 */
	protected static final String EXTRA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExtra() <em>Extra</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtra()
	 * @generated
	 * @ordered
	 */
	protected String extra = EXTRA_EDEFAULT;

	/**
	 * The default value of the '{@link #getPkg() <em>Pkg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkg()
	 * @generated
	 * @ordered
	 */
	protected static final String PKG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPkg() <em>Pkg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkg()
	 * @generated
	 * @ordered
	 */
	protected String pkg = PKG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<JMethod> methods;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<JAttribute> attributes;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<JTypeRef> implements_;

	/**
	 * The cached value of the '{@link #getExtends_() <em>Extends </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends_()
	 * @generated
	 * @ordered
	 */
	protected JTypeRef extends_;

	/**
	 * The cached value of the '{@link #getImports() <em>Imports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImports()
	 * @generated
	 * @ordered
	 */
	protected EList<JType> imports;

	/**
	 * The cached value of the '{@link #getThis_() <em>This </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThis_()
	 * @generated
	 * @ordered
	 */
	protected JThis this_;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JCLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExtra() {
		return extra;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtra(String newExtra) {
		String oldExtra = extra;
		extra = newExtra;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__EXTRA, oldExtra, extra));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPkg() {
		return pkg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkg(String newPkg) {
		String oldPkg = pkg;
		pkg = newPkg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__PKG, oldPkg, pkg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JMethod> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<JMethod>(JMethod.class, this, JavagenPackage.JCLASS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JAttribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<JAttribute>(JAttribute.class, this, JavagenPackage.JCLASS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JTypeRef> getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectContainmentEList<JTypeRef>(JTypeRef.class, this, JavagenPackage.JCLASS__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JTypeRef getExtends_() {
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExtends_(JTypeRef newExtends_, NotificationChain msgs) {
		JTypeRef oldExtends_ = extends_;
		extends_ = newExtends_;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__EXTENDS_, oldExtends_, newExtends_);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExtends_(JTypeRef newExtends_) {
		if (newExtends_ != extends_) {
			NotificationChain msgs = null;
			if (extends_ != null)
				msgs = ((InternalEObject)extends_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCLASS__EXTENDS_, null, msgs);
			if (newExtends_ != null)
				msgs = ((InternalEObject)newExtends_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCLASS__EXTENDS_, null, msgs);
			msgs = basicSetExtends_(newExtends_, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__EXTENDS_, newExtends_, newExtends_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JType> getImports() {
		if (imports == null) {
			imports = new EObjectResolvingEList<JType>(JType.class, this, JavagenPackage.JCLASS__IMPORTS);
		}
		return imports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JThis getThis_() {
		return this_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThis_(JThis newThis_, NotificationChain msgs) {
		JThis oldThis_ = this_;
		this_ = newThis_;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__THIS_, oldThis_, newThis_);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThis_(JThis newThis_) {
		if (newThis_ != this_) {
			NotificationChain msgs = null;
			if (this_ != null)
				msgs = ((InternalEObject)this_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCLASS__THIS_, null, msgs);
			if (newThis_ != null)
				msgs = ((InternalEObject)newThis_).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JCLASS__THIS_, null, msgs);
			msgs = basicSetThis_(newThis_, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JCLASS__THIS_, newThis_, newThis_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JCLASS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCLASS__IMPLEMENTS:
				return ((InternalEList<?>)getImplements()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCLASS__EXTENDS_:
				return basicSetExtends_(null, msgs);
			case JavagenPackage.JCLASS__THIS_:
				return basicSetThis_(null, msgs);
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
			case JavagenPackage.JCLASS__EXTRA:
				return getExtra();
			case JavagenPackage.JCLASS__PKG:
				return getPkg();
			case JavagenPackage.JCLASS__METHODS:
				return getMethods();
			case JavagenPackage.JCLASS__ATTRIBUTES:
				return getAttributes();
			case JavagenPackage.JCLASS__IMPLEMENTS:
				return getImplements();
			case JavagenPackage.JCLASS__EXTENDS_:
				return getExtends_();
			case JavagenPackage.JCLASS__IMPORTS:
				return getImports();
			case JavagenPackage.JCLASS__THIS_:
				return getThis_();
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
			case JavagenPackage.JCLASS__EXTRA:
				setExtra((String)newValue);
				return;
			case JavagenPackage.JCLASS__PKG:
				setPkg((String)newValue);
				return;
			case JavagenPackage.JCLASS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends JMethod>)newValue);
				return;
			case JavagenPackage.JCLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends JAttribute>)newValue);
				return;
			case JavagenPackage.JCLASS__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection<? extends JTypeRef>)newValue);
				return;
			case JavagenPackage.JCLASS__EXTENDS_:
				setExtends_((JTypeRef)newValue);
				return;
			case JavagenPackage.JCLASS__IMPORTS:
				getImports().clear();
				getImports().addAll((Collection<? extends JType>)newValue);
				return;
			case JavagenPackage.JCLASS__THIS_:
				setThis_((JThis)newValue);
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
			case JavagenPackage.JCLASS__EXTRA:
				setExtra(EXTRA_EDEFAULT);
				return;
			case JavagenPackage.JCLASS__PKG:
				setPkg(PKG_EDEFAULT);
				return;
			case JavagenPackage.JCLASS__METHODS:
				getMethods().clear();
				return;
			case JavagenPackage.JCLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case JavagenPackage.JCLASS__IMPLEMENTS:
				getImplements().clear();
				return;
			case JavagenPackage.JCLASS__EXTENDS_:
				setExtends_((JTypeRef)null);
				return;
			case JavagenPackage.JCLASS__IMPORTS:
				getImports().clear();
				return;
			case JavagenPackage.JCLASS__THIS_:
				setThis_((JThis)null);
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
			case JavagenPackage.JCLASS__EXTRA:
				return EXTRA_EDEFAULT == null ? extra != null : !EXTRA_EDEFAULT.equals(extra);
			case JavagenPackage.JCLASS__PKG:
				return PKG_EDEFAULT == null ? pkg != null : !PKG_EDEFAULT.equals(pkg);
			case JavagenPackage.JCLASS__METHODS:
				return methods != null && !methods.isEmpty();
			case JavagenPackage.JCLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case JavagenPackage.JCLASS__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case JavagenPackage.JCLASS__EXTENDS_:
				return extends_ != null;
			case JavagenPackage.JCLASS__IMPORTS:
				return imports != null && !imports.isEmpty();
			case JavagenPackage.JCLASS__THIS_:
				return this_ != null;
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
		result.append(" (extra: ");
		result.append(extra);
		result.append(", pkg: ");
		result.append(pkg);
		result.append(')');
		return result.toString();
	}

} //JClassImpl
