/**
 */
package lintra.atlcompiler.javagen.impl;

import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JAssignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JAssignmentImpl#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JAssignmentImpl#getRightPart <em>Right Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JAssignmentImpl extends JTextImpl implements JAssignment {
	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected JVariableDeclaration declaration;

	/**
	 * The cached value of the '{@link #getRightPart() <em>Right Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightPart()
	 * @generated
	 * @ordered
	 */
	protected JExpression rightPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVariableDeclaration getDeclaration() {
		if (declaration != null && declaration.eIsProxy()) {
			InternalEObject oldDeclaration = (InternalEObject)declaration;
			declaration = (JVariableDeclaration)eResolveProxy(oldDeclaration);
			if (declaration != oldDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, JavagenPackage.JASSIGNMENT__DECLARATION, oldDeclaration, declaration));
			}
		}
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVariableDeclaration basicGetDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(JVariableDeclaration newDeclaration) {
		JVariableDeclaration oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JASSIGNMENT__DECLARATION, oldDeclaration, declaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JExpression getRightPart() {
		return rightPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightPart(JExpression newRightPart, NotificationChain msgs) {
		JExpression oldRightPart = rightPart;
		rightPart = newRightPart;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JASSIGNMENT__RIGHT_PART, oldRightPart, newRightPart);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightPart(JExpression newRightPart) {
		if (newRightPart != rightPart) {
			NotificationChain msgs = null;
			if (rightPart != null)
				msgs = ((InternalEObject)rightPart).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JASSIGNMENT__RIGHT_PART, null, msgs);
			if (newRightPart != null)
				msgs = ((InternalEObject)newRightPart).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JASSIGNMENT__RIGHT_PART, null, msgs);
			msgs = basicSetRightPart(newRightPart, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JASSIGNMENT__RIGHT_PART, newRightPart, newRightPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JASSIGNMENT__RIGHT_PART:
				return basicSetRightPart(null, msgs);
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
			case JavagenPackage.JASSIGNMENT__DECLARATION:
				if (resolve) return getDeclaration();
				return basicGetDeclaration();
			case JavagenPackage.JASSIGNMENT__RIGHT_PART:
				return getRightPart();
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
			case JavagenPackage.JASSIGNMENT__DECLARATION:
				setDeclaration((JVariableDeclaration)newValue);
				return;
			case JavagenPackage.JASSIGNMENT__RIGHT_PART:
				setRightPart((JExpression)newValue);
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
			case JavagenPackage.JASSIGNMENT__DECLARATION:
				setDeclaration((JVariableDeclaration)null);
				return;
			case JavagenPackage.JASSIGNMENT__RIGHT_PART:
				setRightPart((JExpression)null);
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
			case JavagenPackage.JASSIGNMENT__DECLARATION:
				return declaration != null;
			case JavagenPackage.JASSIGNMENT__RIGHT_PART:
				return rightPart != null;
		}
		return super.eIsSet(featureID);
	}

} //JAssignmentImpl
