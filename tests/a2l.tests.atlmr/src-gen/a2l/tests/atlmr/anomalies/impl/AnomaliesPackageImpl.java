/**
 */
package a2l.tests.atlmr.anomalies.impl;

import a2l.tests.atlmr.anomalies.AbbreviationAsWordInName;
import a2l.tests.atlmr.anomalies.AbstractClassName;
import a2l.tests.atlmr.anomalies.AnomaliesFactory;
import a2l.tests.atlmr.anomalies.AnomaliesPackage;
import a2l.tests.atlmr.anomalies.Anomaly;
import a2l.tests.atlmr.anomalies.AvoidEscapedUnicodeCharacters;
import a2l.tests.atlmr.anomalies.AvoidInlineConditionals;
import a2l.tests.atlmr.anomalies.AvoidStartImport;
import a2l.tests.atlmr.anomalies.BooleanInstantiation;
import a2l.tests.atlmr.anomalies.ByteInstantiation;
import a2l.tests.atlmr.anomalies.CompareObjectsWithEquals;
import a2l.tests.atlmr.anomalies.ConstantName;
import a2l.tests.atlmr.anomalies.DefaultLabelNotLastInSwitchStmt;
import a2l.tests.atlmr.anomalies.EqualsHashCode;
import a2l.tests.atlmr.anomalies.EqualsNull;
import a2l.tests.atlmr.anomalies.FinalClass;
import a2l.tests.atlmr.anomalies.HiddenField;
import a2l.tests.atlmr.anomalies.IntegerInstantiation;
import a2l.tests.atlmr.anomalies.InterfaceIsType;
import a2l.tests.atlmr.anomalies.LocalFinalVariableName;
import a2l.tests.atlmr.anomalies.LocalVariableName;
import a2l.tests.atlmr.anomalies.LongInstantiation;
import a2l.tests.atlmr.anomalies.LooseCoupling;
import a2l.tests.atlmr.anomalies.MemberName;
import a2l.tests.atlmr.anomalies.MethodName;
import a2l.tests.atlmr.anomalies.MissingSwitchDefault;
import a2l.tests.atlmr.anomalies.PackageName;
import a2l.tests.atlmr.anomalies.ParameterName;
import a2l.tests.atlmr.anomalies.ParameterNumber;
import a2l.tests.atlmr.anomalies.PositionLiteralsFirstInComparisons;
import a2l.tests.atlmr.anomalies.RedundantImport;
import a2l.tests.atlmr.anomalies.RedundantModifier;
import a2l.tests.atlmr.anomalies.RedundantThrows;
import a2l.tests.atlmr.anomalies.ShortInstantiation;
import a2l.tests.atlmr.anomalies.SignatureDeclareThrowsException;
import a2l.tests.atlmr.anomalies.SimplifyBooleanExpression;
import a2l.tests.atlmr.anomalies.SimplifyBooleanReturn;
import a2l.tests.atlmr.anomalies.SimplifyStartsWith;
import a2l.tests.atlmr.anomalies.StaticVariableName;
import a2l.tests.atlmr.anomalies.TypeName;
import a2l.tests.atlmr.anomalies.UnconditionalIfStatement;
import a2l.tests.atlmr.anomalies.UnnecessaryFinalModifier;
import a2l.tests.atlmr.anomalies.UnnecessaryReturn;
import a2l.tests.atlmr.anomalies.UnusedImports;
import a2l.tests.atlmr.anomalies.UseEqualsToCompareStrings;
import a2l.tests.atlmr.anomalies.VisibilityModifier;

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
public class AnomaliesPackageImpl extends EPackageImpl implements AnomaliesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass anomalyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass avoidStartImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abbreviationAsWordInNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractClassNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass avoidEscapedUnicodeCharactersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localFinalVariableNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass localVariableNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass memberNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass staticVariableNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeNameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unusedImportsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redundantImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterNumberEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redundantModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass avoidInlineConditionalsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalsHashCodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hiddenFieldEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missingSwitchDefaultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redundantThrowsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplifyBooleanExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplifyBooleanReturnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass finalClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceIsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass visibilityModifierEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass looseCouplingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signatureDeclareThrowsExceptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultLabelNotLastInSwitchStmtEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass equalsNullEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compareObjectsWithEqualsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionLiteralsFirstInComparisonsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useEqualsToCompareStringsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass byteInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortInstantiationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplifyStartsWithEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unnecessaryReturnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unconditionalIfStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unnecessaryFinalModifierEClass = null;

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
	 * @see a2l.tests.atlmr.anomalies.AnomaliesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnomaliesPackageImpl() {
		super(eNS_URI, AnomaliesFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AnomaliesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnomaliesPackage init() {
		if (isInited) return (AnomaliesPackage)EPackage.Registry.INSTANCE.getEPackage(AnomaliesPackage.eNS_URI);

		// Obtain or create and register package
		AnomaliesPackageImpl theAnomaliesPackage = (AnomaliesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AnomaliesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AnomaliesPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theAnomaliesPackage.createPackageContents();

		// Initialize created meta-data
		theAnomaliesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnomaliesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AnomaliesPackage.eNS_URI, theAnomaliesPackage);
		return theAnomaliesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnomaly() {
		return anomalyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnomaly_Trace() {
		return (EReference)anomalyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnomaly_Description() {
		return (EAttribute)anomalyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvoidStartImport() {
		return avoidStartImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantName() {
		return constantNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbbreviationAsWordInName() {
		return abbreviationAsWordInNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractClassName() {
		return abstractClassNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvoidEscapedUnicodeCharacters() {
		return avoidEscapedUnicodeCharactersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalFinalVariableName() {
		return localFinalVariableNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLocalVariableName() {
		return localVariableNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMemberName() {
		return memberNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodName() {
		return methodNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageName() {
		return packageNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterName() {
		return parameterNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStaticVariableName() {
		return staticVariableNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeName() {
		return typeNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnusedImports() {
		return unusedImportsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedundantImport() {
		return redundantImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterNumber() {
		return parameterNumberEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedundantModifier() {
		return redundantModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAvoidInlineConditionals() {
		return avoidInlineConditionalsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualsHashCode() {
		return equalsHashCodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHiddenField() {
		return hiddenFieldEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMissingSwitchDefault() {
		return missingSwitchDefaultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedundantThrows() {
		return redundantThrowsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplifyBooleanExpression() {
		return simplifyBooleanExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplifyBooleanReturn() {
		return simplifyBooleanReturnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFinalClass() {
		return finalClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceIsType() {
		return interfaceIsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVisibilityModifier() {
		return visibilityModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLooseCoupling() {
		return looseCouplingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSignatureDeclareThrowsException() {
		return signatureDeclareThrowsExceptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultLabelNotLastInSwitchStmt() {
		return defaultLabelNotLastInSwitchStmtEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEqualsNull() {
		return equalsNullEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompareObjectsWithEquals() {
		return compareObjectsWithEqualsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionLiteralsFirstInComparisons() {
		return positionLiteralsFirstInComparisonsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseEqualsToCompareStrings() {
		return useEqualsToCompareStringsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerInstantiation() {
		return integerInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getByteInstantiation() {
		return byteInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongInstantiation() {
		return longInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanInstantiation() {
		return booleanInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShortInstantiation() {
		return shortInstantiationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplifyStartsWith() {
		return simplifyStartsWithEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnnecessaryReturn() {
		return unnecessaryReturnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnconditionalIfStatement() {
		return unconditionalIfStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnnecessaryFinalModifier() {
		return unnecessaryFinalModifierEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnomaliesFactory getAnomaliesFactory() {
		return (AnomaliesFactory)getEFactoryInstance();
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
		anomalyEClass = createEClass(ANOMALY);
		createEReference(anomalyEClass, ANOMALY__TRACE);
		createEAttribute(anomalyEClass, ANOMALY__DESCRIPTION);

		avoidStartImportEClass = createEClass(AVOID_START_IMPORT);

		constantNameEClass = createEClass(CONSTANT_NAME);

		abbreviationAsWordInNameEClass = createEClass(ABBREVIATION_AS_WORD_IN_NAME);

		abstractClassNameEClass = createEClass(ABSTRACT_CLASS_NAME);

		avoidEscapedUnicodeCharactersEClass = createEClass(AVOID_ESCAPED_UNICODE_CHARACTERS);

		localFinalVariableNameEClass = createEClass(LOCAL_FINAL_VARIABLE_NAME);

		localVariableNameEClass = createEClass(LOCAL_VARIABLE_NAME);

		memberNameEClass = createEClass(MEMBER_NAME);

		methodNameEClass = createEClass(METHOD_NAME);

		packageNameEClass = createEClass(PACKAGE_NAME);

		parameterNameEClass = createEClass(PARAMETER_NAME);

		staticVariableNameEClass = createEClass(STATIC_VARIABLE_NAME);

		typeNameEClass = createEClass(TYPE_NAME);

		unusedImportsEClass = createEClass(UNUSED_IMPORTS);

		redundantImportEClass = createEClass(REDUNDANT_IMPORT);

		parameterNumberEClass = createEClass(PARAMETER_NUMBER);

		redundantModifierEClass = createEClass(REDUNDANT_MODIFIER);

		avoidInlineConditionalsEClass = createEClass(AVOID_INLINE_CONDITIONALS);

		equalsHashCodeEClass = createEClass(EQUALS_HASH_CODE);

		hiddenFieldEClass = createEClass(HIDDEN_FIELD);

		missingSwitchDefaultEClass = createEClass(MISSING_SWITCH_DEFAULT);

		redundantThrowsEClass = createEClass(REDUNDANT_THROWS);

		simplifyBooleanExpressionEClass = createEClass(SIMPLIFY_BOOLEAN_EXPRESSION);

		simplifyBooleanReturnEClass = createEClass(SIMPLIFY_BOOLEAN_RETURN);

		finalClassEClass = createEClass(FINAL_CLASS);

		interfaceIsTypeEClass = createEClass(INTERFACE_IS_TYPE);

		visibilityModifierEClass = createEClass(VISIBILITY_MODIFIER);

		looseCouplingEClass = createEClass(LOOSE_COUPLING);

		signatureDeclareThrowsExceptionEClass = createEClass(SIGNATURE_DECLARE_THROWS_EXCEPTION);

		defaultLabelNotLastInSwitchStmtEClass = createEClass(DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT);

		equalsNullEClass = createEClass(EQUALS_NULL);

		compareObjectsWithEqualsEClass = createEClass(COMPARE_OBJECTS_WITH_EQUALS);

		positionLiteralsFirstInComparisonsEClass = createEClass(POSITION_LITERALS_FIRST_IN_COMPARISONS);

		useEqualsToCompareStringsEClass = createEClass(USE_EQUALS_TO_COMPARE_STRINGS);

		integerInstantiationEClass = createEClass(INTEGER_INSTANTIATION);

		byteInstantiationEClass = createEClass(BYTE_INSTANTIATION);

		longInstantiationEClass = createEClass(LONG_INSTANTIATION);

		booleanInstantiationEClass = createEClass(BOOLEAN_INSTANTIATION);

		shortInstantiationEClass = createEClass(SHORT_INSTANTIATION);

		simplifyStartsWithEClass = createEClass(SIMPLIFY_STARTS_WITH);

		unnecessaryReturnEClass = createEClass(UNNECESSARY_RETURN);

		unconditionalIfStatementEClass = createEClass(UNCONDITIONAL_IF_STATEMENT);

		unnecessaryFinalModifierEClass = createEClass(UNNECESSARY_FINAL_MODIFIER);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		avoidStartImportEClass.getESuperTypes().add(this.getAnomaly());
		constantNameEClass.getESuperTypes().add(this.getAnomaly());
		abbreviationAsWordInNameEClass.getESuperTypes().add(this.getAnomaly());
		abstractClassNameEClass.getESuperTypes().add(this.getAnomaly());
		avoidEscapedUnicodeCharactersEClass.getESuperTypes().add(this.getAnomaly());
		localFinalVariableNameEClass.getESuperTypes().add(this.getAnomaly());
		localVariableNameEClass.getESuperTypes().add(this.getAnomaly());
		memberNameEClass.getESuperTypes().add(this.getAnomaly());
		methodNameEClass.getESuperTypes().add(this.getAnomaly());
		packageNameEClass.getESuperTypes().add(this.getAnomaly());
		parameterNameEClass.getESuperTypes().add(this.getAnomaly());
		staticVariableNameEClass.getESuperTypes().add(this.getAnomaly());
		typeNameEClass.getESuperTypes().add(this.getAnomaly());
		unusedImportsEClass.getESuperTypes().add(this.getAnomaly());
		redundantImportEClass.getESuperTypes().add(this.getAnomaly());
		parameterNumberEClass.getESuperTypes().add(this.getAnomaly());
		redundantModifierEClass.getESuperTypes().add(this.getAnomaly());
		avoidInlineConditionalsEClass.getESuperTypes().add(this.getAnomaly());
		equalsHashCodeEClass.getESuperTypes().add(this.getAnomaly());
		hiddenFieldEClass.getESuperTypes().add(this.getAnomaly());
		missingSwitchDefaultEClass.getESuperTypes().add(this.getAnomaly());
		redundantThrowsEClass.getESuperTypes().add(this.getAnomaly());
		simplifyBooleanExpressionEClass.getESuperTypes().add(this.getAnomaly());
		simplifyBooleanReturnEClass.getESuperTypes().add(this.getAnomaly());
		finalClassEClass.getESuperTypes().add(this.getAnomaly());
		interfaceIsTypeEClass.getESuperTypes().add(this.getAnomaly());
		visibilityModifierEClass.getESuperTypes().add(this.getAnomaly());
		looseCouplingEClass.getESuperTypes().add(this.getAnomaly());
		signatureDeclareThrowsExceptionEClass.getESuperTypes().add(this.getAnomaly());
		defaultLabelNotLastInSwitchStmtEClass.getESuperTypes().add(this.getAnomaly());
		equalsNullEClass.getESuperTypes().add(this.getAnomaly());
		compareObjectsWithEqualsEClass.getESuperTypes().add(this.getAnomaly());
		positionLiteralsFirstInComparisonsEClass.getESuperTypes().add(this.getAnomaly());
		useEqualsToCompareStringsEClass.getESuperTypes().add(this.getAnomaly());
		integerInstantiationEClass.getESuperTypes().add(this.getAnomaly());
		byteInstantiationEClass.getESuperTypes().add(this.getAnomaly());
		longInstantiationEClass.getESuperTypes().add(this.getAnomaly());
		booleanInstantiationEClass.getESuperTypes().add(this.getAnomaly());
		shortInstantiationEClass.getESuperTypes().add(this.getAnomaly());
		simplifyStartsWithEClass.getESuperTypes().add(this.getAnomaly());
		unnecessaryReturnEClass.getESuperTypes().add(this.getAnomaly());
		unconditionalIfStatementEClass.getESuperTypes().add(this.getAnomaly());
		unnecessaryFinalModifierEClass.getESuperTypes().add(this.getAnomaly());

		// Initialize classes, features, and operations; add parameters
		initEClass(anomalyEClass, Anomaly.class, "Anomaly", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnomaly_Trace(), ecorePackage.getEObject(), null, "trace", null, 0, -1, Anomaly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnomaly_Description(), ecorePackage.getEString(), "description", null, 0, 1, Anomaly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(avoidStartImportEClass, AvoidStartImport.class, "AvoidStartImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constantNameEClass, ConstantName.class, "ConstantName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abbreviationAsWordInNameEClass, AbbreviationAsWordInName.class, "AbbreviationAsWordInName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractClassNameEClass, AbstractClassName.class, "AbstractClassName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(avoidEscapedUnicodeCharactersEClass, AvoidEscapedUnicodeCharacters.class, "AvoidEscapedUnicodeCharacters", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localFinalVariableNameEClass, LocalFinalVariableName.class, "LocalFinalVariableName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(localVariableNameEClass, LocalVariableName.class, "LocalVariableName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(memberNameEClass, MemberName.class, "MemberName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodNameEClass, MethodName.class, "MethodName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(packageNameEClass, PackageName.class, "PackageName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterNameEClass, ParameterName.class, "ParameterName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(staticVariableNameEClass, StaticVariableName.class, "StaticVariableName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeNameEClass, TypeName.class, "TypeName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unusedImportsEClass, UnusedImports.class, "UnusedImports", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(redundantImportEClass, RedundantImport.class, "RedundantImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterNumberEClass, ParameterNumber.class, "ParameterNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(redundantModifierEClass, RedundantModifier.class, "RedundantModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(avoidInlineConditionalsEClass, AvoidInlineConditionals.class, "AvoidInlineConditionals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalsHashCodeEClass, EqualsHashCode.class, "EqualsHashCode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hiddenFieldEClass, HiddenField.class, "HiddenField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(missingSwitchDefaultEClass, MissingSwitchDefault.class, "MissingSwitchDefault", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(redundantThrowsEClass, RedundantThrows.class, "RedundantThrows", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simplifyBooleanExpressionEClass, SimplifyBooleanExpression.class, "SimplifyBooleanExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simplifyBooleanReturnEClass, SimplifyBooleanReturn.class, "SimplifyBooleanReturn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(finalClassEClass, FinalClass.class, "FinalClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(interfaceIsTypeEClass, InterfaceIsType.class, "InterfaceIsType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(visibilityModifierEClass, VisibilityModifier.class, "VisibilityModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(looseCouplingEClass, LooseCoupling.class, "LooseCoupling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(signatureDeclareThrowsExceptionEClass, SignatureDeclareThrowsException.class, "SignatureDeclareThrowsException", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(defaultLabelNotLastInSwitchStmtEClass, DefaultLabelNotLastInSwitchStmt.class, "DefaultLabelNotLastInSwitchStmt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(equalsNullEClass, EqualsNull.class, "EqualsNull", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compareObjectsWithEqualsEClass, CompareObjectsWithEquals.class, "CompareObjectsWithEquals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(positionLiteralsFirstInComparisonsEClass, PositionLiteralsFirstInComparisons.class, "PositionLiteralsFirstInComparisons", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(useEqualsToCompareStringsEClass, UseEqualsToCompareStrings.class, "UseEqualsToCompareStrings", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerInstantiationEClass, IntegerInstantiation.class, "IntegerInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(byteInstantiationEClass, ByteInstantiation.class, "ByteInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(longInstantiationEClass, LongInstantiation.class, "LongInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanInstantiationEClass, BooleanInstantiation.class, "BooleanInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(shortInstantiationEClass, ShortInstantiation.class, "ShortInstantiation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(simplifyStartsWithEClass, SimplifyStartsWith.class, "SimplifyStartsWith", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unnecessaryReturnEClass, UnnecessaryReturn.class, "UnnecessaryReturn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unconditionalIfStatementEClass, UnconditionalIfStatement.class, "UnconditionalIfStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unnecessaryFinalModifierEClass, UnnecessaryFinalModifier.class, "UnnecessaryFinalModifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AnomaliesPackageImpl
