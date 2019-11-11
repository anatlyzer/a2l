/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;
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
 * An implementation of the model object '<em><b>JBlock</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JBlockImpl#getLocalVars <em>Local Vars</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JBlockImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class JBlockImpl extends MinimalEObjectImpl.Container implements JBlock {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JBLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JVariableDeclaration> getLocalVars() {
		if (localVars == null) {
			localVars = new EObjectContainmentEList<JVariableDeclaration>(JVariableDeclaration.class, this, JavagenPackage.JBLOCK__LOCAL_VARS);
		}
		return localVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<JStatement> getStatements() {
		if (statements == null) {
			statements = new EObjectContainmentEList<JStatement>(JStatement.class, this, JavagenPackage.JBLOCK__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JBLOCK__LOCAL_VARS:
				return ((InternalEList<?>)getLocalVars()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JBLOCK__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
			case JavagenPackage.JBLOCK__LOCAL_VARS:
				return getLocalVars();
			case JavagenPackage.JBLOCK__STATEMENTS:
				return getStatements();
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
			case JavagenPackage.JBLOCK__LOCAL_VARS:
				getLocalVars().clear();
				getLocalVars().addAll((Collection<? extends JVariableDeclaration>)newValue);
				return;
			case JavagenPackage.JBLOCK__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends JStatement>)newValue);
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
			case JavagenPackage.JBLOCK__LOCAL_VARS:
				getLocalVars().clear();
				return;
			case JavagenPackage.JBLOCK__STATEMENTS:
				getStatements().clear();
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
			case JavagenPackage.JBLOCK__LOCAL_VARS:
				return localVars != null && !localVars.isEmpty();
			case JavagenPackage.JBLOCK__STATEMENTS:
				return statements != null && !statements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //JBlockImpl
