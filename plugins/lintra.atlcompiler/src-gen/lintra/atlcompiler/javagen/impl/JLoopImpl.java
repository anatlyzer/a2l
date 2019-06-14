/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JLoop;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;
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
 * An implementation of the model object '<em><b>JLoop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JLoopImpl#getLocalVars <em>Local Vars</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JLoopImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JLoopImpl#getLoopVar <em>Loop Var</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JLoopImpl extends JStatementImpl implements JLoop {
	/**
	 * The cached value of the '{@link #getLocalVars() <em>Local Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalVars()
	 * @generated
	 * @ordered
	 */
	protected EList<JVariableDeclaration> localVars;

	/**
	 * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<JStatement> statements;

	/**
	 * The cached value of the '{@link #getLoopVar() <em>Loop Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopVar()
	 * @generated
	 * @ordered
	 */
	protected JVariableDeclaration loopVar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JLOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JVariableDeclaration> getLocalVars() {
		if (localVars == null) {
			localVars = new EObjectContainmentEList<JVariableDeclaration>(JVariableDeclaration.class, this, JavagenPackage.JLOOP__LOCAL_VARS);
		}
		return localVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JStatement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<JStatement>(JStatement.class, this, JavagenPackage.JLOOP__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JVariableDeclaration getLoopVar() {
		return loopVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopVar(JVariableDeclaration newLoopVar, NotificationChain msgs) {
		JVariableDeclaration oldLoopVar = loopVar;
		loopVar = newLoopVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, JavagenPackage.JLOOP__LOOP_VAR, oldLoopVar, newLoopVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopVar(JVariableDeclaration newLoopVar) {
		if (newLoopVar != loopVar) {
			NotificationChain msgs = null;
			if (loopVar != null)
				msgs = ((InternalEObject)loopVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JLOOP__LOOP_VAR, null, msgs);
			if (newLoopVar != null)
				msgs = ((InternalEObject)newLoopVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JavagenPackage.JLOOP__LOOP_VAR, null, msgs);
			msgs = basicSetLoopVar(newLoopVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, JavagenPackage.JLOOP__LOOP_VAR, newLoopVar, newLoopVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JLOOP__LOCAL_VARS:
				return ((InternalEList<?>)getLocalVars()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JLOOP__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JLOOP__LOOP_VAR:
				return basicSetLoopVar(null, msgs);
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
			case JavagenPackage.JLOOP__LOCAL_VARS:
				return getLocalVars();
			case JavagenPackage.JLOOP__STATEMENTS:
				return getStatements();
			case JavagenPackage.JLOOP__LOOP_VAR:
				return getLoopVar();
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
			case JavagenPackage.JLOOP__LOCAL_VARS:
				getLocalVars().clear();
				getLocalVars().addAll((Collection<? extends JVariableDeclaration>)newValue);
				return;
			case JavagenPackage.JLOOP__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends JStatement>)newValue);
				return;
			case JavagenPackage.JLOOP__LOOP_VAR:
				setLoopVar((JVariableDeclaration)newValue);
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
			case JavagenPackage.JLOOP__LOCAL_VARS:
				getLocalVars().clear();
				return;
			case JavagenPackage.JLOOP__STATEMENTS:
				getStatements().clear();
				return;
			case JavagenPackage.JLOOP__LOOP_VAR:
				setLoopVar((JVariableDeclaration)null);
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
			case JavagenPackage.JLOOP__LOCAL_VARS:
				return localVars != null && !localVars.isEmpty();
			case JavagenPackage.JLOOP__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case JavagenPackage.JLOOP__LOOP_VAR:
				return loopVar != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == JBlock.class) {
			switch (derivedFeatureID) {
				case JavagenPackage.JLOOP__LOCAL_VARS: return JavagenPackage.JBLOCK__LOCAL_VARS;
				case JavagenPackage.JLOOP__STATEMENTS: return JavagenPackage.JBLOCK__STATEMENTS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == JBlock.class) {
			switch (baseFeatureID) {
				case JavagenPackage.JBLOCK__LOCAL_VARS: return JavagenPackage.JLOOP__LOCAL_VARS;
				case JavagenPackage.JBLOCK__STATEMENTS: return JavagenPackage.JLOOP__STATEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //JLoopImpl
