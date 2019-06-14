/**
 */
package a2l.tests.atlmr.anomalies.impl;

import a2l.tests.atlmr.anomalies.*;

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
public class AnomaliesFactoryImpl extends EFactoryImpl implements AnomaliesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnomaliesFactory init() {
		try {
			AnomaliesFactory theAnomaliesFactory = (AnomaliesFactory)EPackage.Registry.INSTANCE.getEFactory(AnomaliesPackage.eNS_URI);
			if (theAnomaliesFactory != null) {
				return theAnomaliesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnomaliesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnomaliesFactoryImpl() {
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
			case AnomaliesPackage.AVOID_START_IMPORT: return createAvoidStartImport();
			case AnomaliesPackage.CONSTANT_NAME: return createConstantName();
			case AnomaliesPackage.ABBREVIATION_AS_WORD_IN_NAME: return createAbbreviationAsWordInName();
			case AnomaliesPackage.ABSTRACT_CLASS_NAME: return createAbstractClassName();
			case AnomaliesPackage.AVOID_ESCAPED_UNICODE_CHARACTERS: return createAvoidEscapedUnicodeCharacters();
			case AnomaliesPackage.LOCAL_FINAL_VARIABLE_NAME: return createLocalFinalVariableName();
			case AnomaliesPackage.LOCAL_VARIABLE_NAME: return createLocalVariableName();
			case AnomaliesPackage.MEMBER_NAME: return createMemberName();
			case AnomaliesPackage.METHOD_NAME: return createMethodName();
			case AnomaliesPackage.PACKAGE_NAME: return createPackageName();
			case AnomaliesPackage.PARAMETER_NAME: return createParameterName();
			case AnomaliesPackage.STATIC_VARIABLE_NAME: return createStaticVariableName();
			case AnomaliesPackage.TYPE_NAME: return createTypeName();
			case AnomaliesPackage.UNUSED_IMPORTS: return createUnusedImports();
			case AnomaliesPackage.REDUNDANT_IMPORT: return createRedundantImport();
			case AnomaliesPackage.PARAMETER_NUMBER: return createParameterNumber();
			case AnomaliesPackage.REDUNDANT_MODIFIER: return createRedundantModifier();
			case AnomaliesPackage.AVOID_INLINE_CONDITIONALS: return createAvoidInlineConditionals();
			case AnomaliesPackage.EQUALS_HASH_CODE: return createEqualsHashCode();
			case AnomaliesPackage.HIDDEN_FIELD: return createHiddenField();
			case AnomaliesPackage.MISSING_SWITCH_DEFAULT: return createMissingSwitchDefault();
			case AnomaliesPackage.REDUNDANT_THROWS: return createRedundantThrows();
			case AnomaliesPackage.SIMPLIFY_BOOLEAN_EXPRESSION: return createSimplifyBooleanExpression();
			case AnomaliesPackage.SIMPLIFY_BOOLEAN_RETURN: return createSimplifyBooleanReturn();
			case AnomaliesPackage.FINAL_CLASS: return createFinalClass();
			case AnomaliesPackage.INTERFACE_IS_TYPE: return createInterfaceIsType();
			case AnomaliesPackage.VISIBILITY_MODIFIER: return createVisibilityModifier();
			case AnomaliesPackage.LOOSE_COUPLING: return createLooseCoupling();
			case AnomaliesPackage.SIGNATURE_DECLARE_THROWS_EXCEPTION: return createSignatureDeclareThrowsException();
			case AnomaliesPackage.DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT: return createDefaultLabelNotLastInSwitchStmt();
			case AnomaliesPackage.EQUALS_NULL: return createEqualsNull();
			case AnomaliesPackage.COMPARE_OBJECTS_WITH_EQUALS: return createCompareObjectsWithEquals();
			case AnomaliesPackage.POSITION_LITERALS_FIRST_IN_COMPARISONS: return createPositionLiteralsFirstInComparisons();
			case AnomaliesPackage.USE_EQUALS_TO_COMPARE_STRINGS: return createUseEqualsToCompareStrings();
			case AnomaliesPackage.INTEGER_INSTANTIATION: return createIntegerInstantiation();
			case AnomaliesPackage.BYTE_INSTANTIATION: return createByteInstantiation();
			case AnomaliesPackage.LONG_INSTANTIATION: return createLongInstantiation();
			case AnomaliesPackage.BOOLEAN_INSTANTIATION: return createBooleanInstantiation();
			case AnomaliesPackage.SHORT_INSTANTIATION: return createShortInstantiation();
			case AnomaliesPackage.SIMPLIFY_STARTS_WITH: return createSimplifyStartsWith();
			case AnomaliesPackage.UNNECESSARY_RETURN: return createUnnecessaryReturn();
			case AnomaliesPackage.UNCONDITIONAL_IF_STATEMENT: return createUnconditionalIfStatement();
			case AnomaliesPackage.UNNECESSARY_FINAL_MODIFIER: return createUnnecessaryFinalModifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvoidStartImport createAvoidStartImport() {
		AvoidStartImportImpl avoidStartImport = new AvoidStartImportImpl();
		return avoidStartImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantName createConstantName() {
		ConstantNameImpl constantName = new ConstantNameImpl();
		return constantName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbbreviationAsWordInName createAbbreviationAsWordInName() {
		AbbreviationAsWordInNameImpl abbreviationAsWordInName = new AbbreviationAsWordInNameImpl();
		return abbreviationAsWordInName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractClassName createAbstractClassName() {
		AbstractClassNameImpl abstractClassName = new AbstractClassNameImpl();
		return abstractClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvoidEscapedUnicodeCharacters createAvoidEscapedUnicodeCharacters() {
		AvoidEscapedUnicodeCharactersImpl avoidEscapedUnicodeCharacters = new AvoidEscapedUnicodeCharactersImpl();
		return avoidEscapedUnicodeCharacters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalFinalVariableName createLocalFinalVariableName() {
		LocalFinalVariableNameImpl localFinalVariableName = new LocalFinalVariableNameImpl();
		return localFinalVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocalVariableName createLocalVariableName() {
		LocalVariableNameImpl localVariableName = new LocalVariableNameImpl();
		return localVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberName createMemberName() {
		MemberNameImpl memberName = new MemberNameImpl();
		return memberName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodName createMethodName() {
		MethodNameImpl methodName = new MethodNameImpl();
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageName createPackageName() {
		PackageNameImpl packageName = new PackageNameImpl();
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterName createParameterName() {
		ParameterNameImpl parameterName = new ParameterNameImpl();
		return parameterName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticVariableName createStaticVariableName() {
		StaticVariableNameImpl staticVariableName = new StaticVariableNameImpl();
		return staticVariableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeName createTypeName() {
		TypeNameImpl typeName = new TypeNameImpl();
		return typeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnusedImports createUnusedImports() {
		UnusedImportsImpl unusedImports = new UnusedImportsImpl();
		return unusedImports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundantImport createRedundantImport() {
		RedundantImportImpl redundantImport = new RedundantImportImpl();
		return redundantImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterNumber createParameterNumber() {
		ParameterNumberImpl parameterNumber = new ParameterNumberImpl();
		return parameterNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundantModifier createRedundantModifier() {
		RedundantModifierImpl redundantModifier = new RedundantModifierImpl();
		return redundantModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvoidInlineConditionals createAvoidInlineConditionals() {
		AvoidInlineConditionalsImpl avoidInlineConditionals = new AvoidInlineConditionalsImpl();
		return avoidInlineConditionals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualsHashCode createEqualsHashCode() {
		EqualsHashCodeImpl equalsHashCode = new EqualsHashCodeImpl();
		return equalsHashCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HiddenField createHiddenField() {
		HiddenFieldImpl hiddenField = new HiddenFieldImpl();
		return hiddenField;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MissingSwitchDefault createMissingSwitchDefault() {
		MissingSwitchDefaultImpl missingSwitchDefault = new MissingSwitchDefaultImpl();
		return missingSwitchDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedundantThrows createRedundantThrows() {
		RedundantThrowsImpl redundantThrows = new RedundantThrowsImpl();
		return redundantThrows;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplifyBooleanExpression createSimplifyBooleanExpression() {
		SimplifyBooleanExpressionImpl simplifyBooleanExpression = new SimplifyBooleanExpressionImpl();
		return simplifyBooleanExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplifyBooleanReturn createSimplifyBooleanReturn() {
		SimplifyBooleanReturnImpl simplifyBooleanReturn = new SimplifyBooleanReturnImpl();
		return simplifyBooleanReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FinalClass createFinalClass() {
		FinalClassImpl finalClass = new FinalClassImpl();
		return finalClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterfaceIsType createInterfaceIsType() {
		InterfaceIsTypeImpl interfaceIsType = new InterfaceIsTypeImpl();
		return interfaceIsType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityModifier createVisibilityModifier() {
		VisibilityModifierImpl visibilityModifier = new VisibilityModifierImpl();
		return visibilityModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LooseCoupling createLooseCoupling() {
		LooseCouplingImpl looseCoupling = new LooseCouplingImpl();
		return looseCoupling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignatureDeclareThrowsException createSignatureDeclareThrowsException() {
		SignatureDeclareThrowsExceptionImpl signatureDeclareThrowsException = new SignatureDeclareThrowsExceptionImpl();
		return signatureDeclareThrowsException;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultLabelNotLastInSwitchStmt createDefaultLabelNotLastInSwitchStmt() {
		DefaultLabelNotLastInSwitchStmtImpl defaultLabelNotLastInSwitchStmt = new DefaultLabelNotLastInSwitchStmtImpl();
		return defaultLabelNotLastInSwitchStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualsNull createEqualsNull() {
		EqualsNullImpl equalsNull = new EqualsNullImpl();
		return equalsNull;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompareObjectsWithEquals createCompareObjectsWithEquals() {
		CompareObjectsWithEqualsImpl compareObjectsWithEquals = new CompareObjectsWithEqualsImpl();
		return compareObjectsWithEquals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionLiteralsFirstInComparisons createPositionLiteralsFirstInComparisons() {
		PositionLiteralsFirstInComparisonsImpl positionLiteralsFirstInComparisons = new PositionLiteralsFirstInComparisonsImpl();
		return positionLiteralsFirstInComparisons;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseEqualsToCompareStrings createUseEqualsToCompareStrings() {
		UseEqualsToCompareStringsImpl useEqualsToCompareStrings = new UseEqualsToCompareStringsImpl();
		return useEqualsToCompareStrings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerInstantiation createIntegerInstantiation() {
		IntegerInstantiationImpl integerInstantiation = new IntegerInstantiationImpl();
		return integerInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ByteInstantiation createByteInstantiation() {
		ByteInstantiationImpl byteInstantiation = new ByteInstantiationImpl();
		return byteInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongInstantiation createLongInstantiation() {
		LongInstantiationImpl longInstantiation = new LongInstantiationImpl();
		return longInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanInstantiation createBooleanInstantiation() {
		BooleanInstantiationImpl booleanInstantiation = new BooleanInstantiationImpl();
		return booleanInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortInstantiation createShortInstantiation() {
		ShortInstantiationImpl shortInstantiation = new ShortInstantiationImpl();
		return shortInstantiation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimplifyStartsWith createSimplifyStartsWith() {
		SimplifyStartsWithImpl simplifyStartsWith = new SimplifyStartsWithImpl();
		return simplifyStartsWith;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnnecessaryReturn createUnnecessaryReturn() {
		UnnecessaryReturnImpl unnecessaryReturn = new UnnecessaryReturnImpl();
		return unnecessaryReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnconditionalIfStatement createUnconditionalIfStatement() {
		UnconditionalIfStatementImpl unconditionalIfStatement = new UnconditionalIfStatementImpl();
		return unconditionalIfStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnnecessaryFinalModifier createUnnecessaryFinalModifier() {
		UnnecessaryFinalModifierImpl unnecessaryFinalModifier = new UnnecessaryFinalModifierImpl();
		return unnecessaryFinalModifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnomaliesPackage getAnomaliesPackage() {
		return (AnomaliesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AnomaliesPackage getPackage() {
		return AnomaliesPackage.eINSTANCE;
	}

} //AnomaliesFactoryImpl
