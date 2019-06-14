/**
 */
package lintra.atlcompiler.javagen.impl;

import java.util.Collection;

import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClosure;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>JClosure</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClosureImpl#getLocalVars <em>Local Vars</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClosureImpl#getStatements <em>Statements</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.impl.JClosureImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class JClosureImpl extends JExpressionImpl implements JClosure {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<JParameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JClosureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JavagenPackage.Literals.JCLOSURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JVariableDeclaration> getLocalVars() {
		if (localVars == null) {
			localVars = new EObjectContainmentEList<JVariableDeclaration>(JVariableDeclaration.class, this, JavagenPackage.JCLOSURE__LOCAL_VARS);
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
			statements = new EObjectContainmentEList<JStatement>(JStatement.class, this, JavagenPackage.JCLOSURE__STATEMENTS);
		}
		return statements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<JParameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<JParameter>(JParameter.class, this, JavagenPackage.JCLOSURE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JavagenPackage.JCLOSURE__LOCAL_VARS:
				return ((InternalEList<?>)getLocalVars()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCLOSURE__STATEMENTS:
				return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
			case JavagenPackage.JCLOSURE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case JavagenPackage.JCLOSURE__LOCAL_VARS:
				return getLocalVars();
			case JavagenPackage.JCLOSURE__STATEMENTS:
				return getStatements();
			case JavagenPackage.JCLOSURE__PARAMETERS:
				return getParameters();
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
			case JavagenPackage.JCLOSURE__LOCAL_VARS:
				getLocalVars().clear();
				getLocalVars().addAll((Collection<? extends JVariableDeclaration>)newValue);
				return;
			case JavagenPackage.JCLOSURE__STATEMENTS:
				getStatements().clear();
				getStatements().addAll((Collection<? extends JStatement>)newValue);
				return;
			case JavagenPackage.JCLOSURE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends JParameter>)newValue);
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
			case JavagenPackage.JCLOSURE__LOCAL_VARS:
				getLocalVars().clear();
				return;
			case JavagenPackage.JCLOSURE__STATEMENTS:
				getStatements().clear();
				return;
			case JavagenPackage.JCLOSURE__PARAMETERS:
				getParameters().clear();
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
			case JavagenPackage.JCLOSURE__LOCAL_VARS:
				return localVars != null && !localVars.isEmpty();
			case JavagenPackage.JCLOSURE__STATEMENTS:
				return statements != null && !statements.isEmpty();
			case JavagenPackage.JCLOSURE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
				case JavagenPackage.JCLOSURE__LOCAL_VARS: return JavagenPackage.JBLOCK__LOCAL_VARS;
				case JavagenPackage.JCLOSURE__STATEMENTS: return JavagenPackage.JBLOCK__STATEMENTS;
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
				case JavagenPackage.JBLOCK__LOCAL_VARS: return JavagenPackage.JCLOSURE__LOCAL_VARS;
				case JavagenPackage.JBLOCK__STATEMENTS: return JavagenPackage.JCLOSURE__STATEMENTS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //JClosureImpl
