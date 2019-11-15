/**
 */
package a2l.optimiser.anatlyzerext.impl;

import a2l.optimiser.anatlyzerext.AnatlyzerExtFactory;
import a2l.optimiser.anatlyzerext.AnatlyzerExtPackage;
import a2l.optimiser.anatlyzerext.IteratorChainElement;
import a2l.optimiser.anatlyzerext.IteratorChainExp;
import a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp;
import a2l.optimiser.anatlyzerext.MutableIteratorExp;
import a2l.optimiser.anatlyzerext.NavRefAsSet;
import a2l.optimiser.anatlyzerext.ShortCircuitOperatorCallExp;
import anatlyzer.atl.types.TypesPackage;
import anatlyzer.atlext.ATL.ATLPackage;

import anatlyzer.atlext.OCL.OCLPackage;

import anatlyzer.atlext.OCL2.OCL2Package;
import anatlyzer.atlext.PrimitiveTypes.PrimitiveTypesPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnatlyzerExtPackageImpl extends EPackageImpl implements AnatlyzerExtPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass navRefAsSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutableIteratorExpEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutableCollectionOperationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortCircuitOperatorCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorChainExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorChainElementEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnatlyzerExtPackageImpl() {
		super(eNS_URI, AnatlyzerExtFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AnatlyzerExtPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnatlyzerExtPackage init() {
		if (isInited) return (AnatlyzerExtPackage)EPackage.Registry.INSTANCE.getEPackage(AnatlyzerExtPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAnatlyzerExtPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AnatlyzerExtPackageImpl theAnatlyzerExtPackage = registeredAnatlyzerExtPackage instanceof AnatlyzerExtPackageImpl ? (AnatlyzerExtPackageImpl)registeredAnatlyzerExtPackage : new AnatlyzerExtPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		ATLPackage.eINSTANCE.eClass();
		OCLPackage.eINSTANCE.eClass();
		PrimitiveTypesPackage.eINSTANCE.eClass();
		OCL2Package.eINSTANCE.eClass();
		TypesPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theAnatlyzerExtPackage.createPackageContents();

		// Initialize created meta-data
		theAnatlyzerExtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnatlyzerExtPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnatlyzerExtPackage.eNS_URI, theAnatlyzerExtPackage);
		return theAnatlyzerExtPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNavRefAsSet() {
		return navRefAsSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMutableIteratorExp() {
		return mutableIteratorExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMutableCollectionOperationCallExp() {
		return mutableCollectionOperationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getShortCircuitOperatorCallExp() {
		return shortCircuitOperatorCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratorChainExp() {
		return iteratorChainExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteratorChainExp_Name() {
		return (EAttribute)iteratorChainExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorChainExp_Iterator() {
		return (EReference)iteratorChainExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorChainExp_PreChain() {
		return (EReference)iteratorChainExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorChainExp_Chain() {
		return (EReference)iteratorChainExpEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratorChainElement() {
		return iteratorChainElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIteratorChainElement_Name() {
		return (EAttribute)iteratorChainElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorChainElement_Iterator() {
		return (EReference)iteratorChainElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorChainElement_Body() {
		return (EReference)iteratorChainElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnatlyzerExtFactory getAnatlyzerExtFactory() {
		return (AnatlyzerExtFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		navRefAsSetEClass = createEClass(NAV_REF_AS_SET);

		mutableIteratorExpEClass = createEClass(MUTABLE_ITERATOR_EXP);

		mutableCollectionOperationCallExpEClass = createEClass(MUTABLE_COLLECTION_OPERATION_CALL_EXP);

		shortCircuitOperatorCallExpEClass = createEClass(SHORT_CIRCUIT_OPERATOR_CALL_EXP);

		iteratorChainExpEClass = createEClass(ITERATOR_CHAIN_EXP);
		createEAttribute(iteratorChainExpEClass, ITERATOR_CHAIN_EXP__NAME);
		createEReference(iteratorChainExpEClass, ITERATOR_CHAIN_EXP__ITERATOR);
		createEReference(iteratorChainExpEClass, ITERATOR_CHAIN_EXP__PRE_CHAIN);
		createEReference(iteratorChainExpEClass, ITERATOR_CHAIN_EXP__CHAIN);

		iteratorChainElementEClass = createEClass(ITERATOR_CHAIN_ELEMENT);
		createEAttribute(iteratorChainElementEClass, ITERATOR_CHAIN_ELEMENT__NAME);
		createEReference(iteratorChainElementEClass, ITERATOR_CHAIN_ELEMENT__ITERATOR);
		createEReference(iteratorChainElementEClass, ITERATOR_CHAIN_ELEMENT__BODY);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		OCLPackage theOCLPackage = (OCLPackage)EPackage.Registry.INSTANCE.getEPackage(OCLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		navRefAsSetEClass.getESuperTypes().add(theOCLPackage.getNavigationOrAttributeCallExp());
		mutableIteratorExpEClass.getESuperTypes().add(theOCLPackage.getIteratorExp());
		mutableCollectionOperationCallExpEClass.getESuperTypes().add(theOCLPackage.getCollectionOperationCallExp());
		shortCircuitOperatorCallExpEClass.getESuperTypes().add(theOCLPackage.getOperatorCallExp());
		iteratorChainExpEClass.getESuperTypes().add(theOCLPackage.getPropertyCallExp());

		// Initialize classes, features, and operations; add parameters
		initEClass(navRefAsSetEClass, NavRefAsSet.class, "NavRefAsSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mutableIteratorExpEClass, MutableIteratorExp.class, "MutableIteratorExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mutableCollectionOperationCallExpEClass, MutableCollectionOperationCallExp.class, "MutableCollectionOperationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shortCircuitOperatorCallExpEClass, ShortCircuitOperatorCallExp.class, "ShortCircuitOperatorCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(iteratorChainExpEClass, IteratorChainExp.class, "IteratorChainExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIteratorChainExp_Name(), ecorePackage.getEString(), "name", null, 1, 1, IteratorChainExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorChainExp_Iterator(), theOCLPackage.getIterator(), null, "iterator", null, 1, 1, IteratorChainExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorChainExp_PreChain(), this.getIteratorChainElement(), null, "preChain", null, 0, -1, IteratorChainExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorChainExp_Chain(), this.getIteratorChainElement(), null, "chain", null, 0, -1, IteratorChainExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iteratorChainElementEClass, IteratorChainElement.class, "IteratorChainElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIteratorChainElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, IteratorChainElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorChainElement_Iterator(), theOCLPackage.getIterator(), null, "iterator", null, 0, 1, IteratorChainElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorChainElement_Body(), theOCLPackage.getOclExpression(), null, "body", null, 1, 1, IteratorChainElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AnatlyzerExtPackageImpl
