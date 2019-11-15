/**
 */
package a2l.optimiser.anatlyzerext.impl;

import a2l.optimiser.anatlyzerext.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnatlyzerExtFactoryImpl extends EFactoryImpl implements AnatlyzerExtFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnatlyzerExtFactory init() {
		try {
			AnatlyzerExtFactory theAnatlyzerExtFactory = (AnatlyzerExtFactory)EPackage.Registry.INSTANCE.getEFactory(AnatlyzerExtPackage.eNS_URI);
			if (theAnatlyzerExtFactory != null) {
				return theAnatlyzerExtFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnatlyzerExtFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnatlyzerExtFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnatlyzerExtPackage.NAV_REF_AS_SET: return createNavRefAsSet();
			case AnatlyzerExtPackage.MUTABLE_ITERATOR_EXP: return createMutableIteratorExp();
			case AnatlyzerExtPackage.MUTABLE_COLLECTION_OPERATION_CALL_EXP: return createMutableCollectionOperationCallExp();
			case AnatlyzerExtPackage.SHORT_CIRCUIT_OPERATOR_CALL_EXP: return createShortCircuitOperatorCallExp();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_EXP: return createIteratorChainExp();
			case AnatlyzerExtPackage.ITERATOR_CHAIN_ELEMENT: return createIteratorChainElement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NavRefAsSet createNavRefAsSet() {
		NavRefAsSetImpl navRefAsSet = new NavRefAsSetImpl();
		return navRefAsSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MutableIteratorExp createMutableIteratorExp() {
		MutableIteratorExpImpl mutableIteratorExp = new MutableIteratorExpImpl();
		return mutableIteratorExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MutableCollectionOperationCallExp createMutableCollectionOperationCallExp() {
		MutableCollectionOperationCallExpImpl mutableCollectionOperationCallExp = new MutableCollectionOperationCallExpImpl();
		return mutableCollectionOperationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShortCircuitOperatorCallExp createShortCircuitOperatorCallExp() {
		ShortCircuitOperatorCallExpImpl shortCircuitOperatorCallExp = new ShortCircuitOperatorCallExpImpl();
		return shortCircuitOperatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IteratorChainExp createIteratorChainExp() {
		IteratorChainExpImpl iteratorChainExp = new IteratorChainExpImpl();
		return iteratorChainExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IteratorChainElement createIteratorChainElement() {
		IteratorChainElementImpl iteratorChainElement = new IteratorChainElementImpl();
		return iteratorChainElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnatlyzerExtPackage getAnatlyzerExtPackage() {
		return (AnatlyzerExtPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnatlyzerExtPackage getPackage() {
		return AnatlyzerExtPackage.eINSTANCE;
	}

} //AnatlyzerExtFactoryImpl
