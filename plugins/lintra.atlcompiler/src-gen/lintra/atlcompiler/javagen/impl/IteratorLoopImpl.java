/**
 */
package lintra.atlcompiler.javagen.impl;

import lintra.atlcompiler.javagen.IteratorLoop;
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
 * An implementation of the model object '<em><b>Iterator Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.IteratorLoopImpl#getIteratorVar <em>Iterator Var</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.IteratorLoopImpl#getIteratorInit <em>Iterator Init</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IteratorLoopImpl extends JLoopImpl implements IteratorLoop {
	/**
	 * The cached value of the '{@link #getIteratorVar() <em>Iterator Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorVar()
	 * @generated
	 * @ordered
	 */
	protected JVariableDeclaration iteratorVar;
	/**
	 * The cached value of the '{@link #getIteratorInit() <em>Iterator Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteratorInit()
	 * @generated
	 * @ordered
	 */
	protected JExpression iteratorInit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.ITERATOR_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVariableDeclaration getIteratorVar() {
		return iteratorVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteratorVar(JVariableDeclaration newIteratorVar, NotificationChain msgs) {
		JVariableDeclaration oldIteratorVar = iteratorVar;
		iteratorVar = newIteratorVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR, oldIteratorVar, newIteratorVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteratorVar(JVariableDeclaration newIteratorVar) {
		if (newIteratorVar != iteratorVar) {
			NotificationChain msgs = null;
			if (iteratorVar != null)
				msgs = ((InternalEObject)iteratorVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR, null, msgs);
			if (newIteratorVar != null)
				msgs = ((InternalEObject)newIteratorVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR, null, msgs);
			msgs = basicSetIteratorVar(newIteratorVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR, newIteratorVar, newIteratorVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JExpression getIteratorInit() {
		return iteratorInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIteratorInit(JExpression newIteratorInit, NotificationChain msgs) {
		JExpression oldIteratorInit = iteratorInit;
		iteratorInit = newIteratorInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT, oldIteratorInit, newIteratorInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteratorInit(JExpression newIteratorInit) {
		if (newIteratorInit != iteratorInit) {
			NotificationChain msgs = null;
			if (iteratorInit != null)
				msgs = ((InternalEObject)iteratorInit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT, null, msgs);
			if (newIteratorInit != null)
				msgs = ((InternalEObject)newIteratorInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT, null, msgs);
			msgs = basicSetIteratorInit(newIteratorInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT, newIteratorInit, newIteratorInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR:
				return basicSetIteratorVar(null, msgs);
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT:
				return basicSetIteratorInit(null, msgs);
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
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR:
				return getIteratorVar();
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT:
				return getIteratorInit();
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
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR:
				setIteratorVar((JVariableDeclaration)newValue);
				return;
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT:
				setIteratorInit((JExpression)newValue);
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
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR:
				setIteratorVar((JVariableDeclaration)null);
				return;
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT:
				setIteratorInit((JExpression)null);
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
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_VAR:
				return iteratorVar != null;
			case JavagenPackage.ITERATOR_LOOP__ITERATOR_INIT:
				return iteratorInit != null;
		}
		return super.eIsSet(featureID);
	}

} //IteratorLoopImpl
