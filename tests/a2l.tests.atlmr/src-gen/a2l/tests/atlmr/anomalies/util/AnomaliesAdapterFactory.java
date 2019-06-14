/**
 */
package a2l.tests.atlmr.anomalies.util;

import a2l.tests.atlmr.anomalies.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see a2l.tests.atlmr.anomalies.AnomaliesPackage
 * @generated
 */
public class AnomaliesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnomaliesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnomaliesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AnomaliesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnomaliesSwitch<Adapter> modelSwitch =
		new AnomaliesSwitch<Adapter>() {
			@Override
			public Adapter caseAnomaly(Anomaly object) {
				return createAnomalyAdapter();
			}
			@Override
			public Adapter caseAvoidStartImport(AvoidStartImport object) {
				return createAvoidStartImportAdapter();
			}
			@Override
			public Adapter caseConstantName(ConstantName object) {
				return createConstantNameAdapter();
			}
			@Override
			public Adapter caseAbbreviationAsWordInName(AbbreviationAsWordInName object) {
				return createAbbreviationAsWordInNameAdapter();
			}
			@Override
			public Adapter caseAbstractClassName(AbstractClassName object) {
				return createAbstractClassNameAdapter();
			}
			@Override
			public Adapter caseAvoidEscapedUnicodeCharacters(AvoidEscapedUnicodeCharacters object) {
				return createAvoidEscapedUnicodeCharactersAdapter();
			}
			@Override
			public Adapter caseLocalFinalVariableName(LocalFinalVariableName object) {
				return createLocalFinalVariableNameAdapter();
			}
			@Override
			public Adapter caseLocalVariableName(LocalVariableName object) {
				return createLocalVariableNameAdapter();
			}
			@Override
			public Adapter caseMemberName(MemberName object) {
				return createMemberNameAdapter();
			}
			@Override
			public Adapter caseMethodName(MethodName object) {
				return createMethodNameAdapter();
			}
			@Override
			public Adapter casePackageName(PackageName object) {
				return createPackageNameAdapter();
			}
			@Override
			public Adapter caseParameterName(ParameterName object) {
				return createParameterNameAdapter();
			}
			@Override
			public Adapter caseStaticVariableName(StaticVariableName object) {
				return createStaticVariableNameAdapter();
			}
			@Override
			public Adapter caseTypeName(TypeName object) {
				return createTypeNameAdapter();
			}
			@Override
			public Adapter caseUnusedImports(UnusedImports object) {
				return createUnusedImportsAdapter();
			}
			@Override
			public Adapter caseRedundantImport(RedundantImport object) {
				return createRedundantImportAdapter();
			}
			@Override
			public Adapter caseParameterNumber(ParameterNumber object) {
				return createParameterNumberAdapter();
			}
			@Override
			public Adapter caseRedundantModifier(RedundantModifier object) {
				return createRedundantModifierAdapter();
			}
			@Override
			public Adapter caseAvoidInlineConditionals(AvoidInlineConditionals object) {
				return createAvoidInlineConditionalsAdapter();
			}
			@Override
			public Adapter caseEqualsHashCode(EqualsHashCode object) {
				return createEqualsHashCodeAdapter();
			}
			@Override
			public Adapter caseHiddenField(HiddenField object) {
				return createHiddenFieldAdapter();
			}
			@Override
			public Adapter caseMissingSwitchDefault(MissingSwitchDefault object) {
				return createMissingSwitchDefaultAdapter();
			}
			@Override
			public Adapter caseRedundantThrows(RedundantThrows object) {
				return createRedundantThrowsAdapter();
			}
			@Override
			public Adapter caseSimplifyBooleanExpression(SimplifyBooleanExpression object) {
				return createSimplifyBooleanExpressionAdapter();
			}
			@Override
			public Adapter caseSimplifyBooleanReturn(SimplifyBooleanReturn object) {
				return createSimplifyBooleanReturnAdapter();
			}
			@Override
			public Adapter caseFinalClass(FinalClass object) {
				return createFinalClassAdapter();
			}
			@Override
			public Adapter caseInterfaceIsType(InterfaceIsType object) {
				return createInterfaceIsTypeAdapter();
			}
			@Override
			public Adapter caseVisibilityModifier(VisibilityModifier object) {
				return createVisibilityModifierAdapter();
			}
			@Override
			public Adapter caseLooseCoupling(LooseCoupling object) {
				return createLooseCouplingAdapter();
			}
			@Override
			public Adapter caseSignatureDeclareThrowsException(SignatureDeclareThrowsException object) {
				return createSignatureDeclareThrowsExceptionAdapter();
			}
			@Override
			public Adapter caseDefaultLabelNotLastInSwitchStmt(DefaultLabelNotLastInSwitchStmt object) {
				return createDefaultLabelNotLastInSwitchStmtAdapter();
			}
			@Override
			public Adapter caseEqualsNull(EqualsNull object) {
				return createEqualsNullAdapter();
			}
			@Override
			public Adapter caseCompareObjectsWithEquals(CompareObjectsWithEquals object) {
				return createCompareObjectsWithEqualsAdapter();
			}
			@Override
			public Adapter casePositionLiteralsFirstInComparisons(PositionLiteralsFirstInComparisons object) {
				return createPositionLiteralsFirstInComparisonsAdapter();
			}
			@Override
			public Adapter caseUseEqualsToCompareStrings(UseEqualsToCompareStrings object) {
				return createUseEqualsToCompareStringsAdapter();
			}
			@Override
			public Adapter caseIntegerInstantiation(IntegerInstantiation object) {
				return createIntegerInstantiationAdapter();
			}
			@Override
			public Adapter caseByteInstantiation(ByteInstantiation object) {
				return createByteInstantiationAdapter();
			}
			@Override
			public Adapter caseLongInstantiation(LongInstantiation object) {
				return createLongInstantiationAdapter();
			}
			@Override
			public Adapter caseBooleanInstantiation(BooleanInstantiation object) {
				return createBooleanInstantiationAdapter();
			}
			@Override
			public Adapter caseShortInstantiation(ShortInstantiation object) {
				return createShortInstantiationAdapter();
			}
			@Override
			public Adapter caseSimplifyStartsWith(SimplifyStartsWith object) {
				return createSimplifyStartsWithAdapter();
			}
			@Override
			public Adapter caseUnnecessaryReturn(UnnecessaryReturn object) {
				return createUnnecessaryReturnAdapter();
			}
			@Override
			public Adapter caseUnconditionalIfStatement(UnconditionalIfStatement object) {
				return createUnconditionalIfStatementAdapter();
			}
			@Override
			public Adapter caseUnnecessaryFinalModifier(UnnecessaryFinalModifier object) {
				return createUnnecessaryFinalModifierAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.Anomaly <em>Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.Anomaly
	 * @generated
	 */
	public Adapter createAnomalyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.AvoidStartImport <em>Avoid Start Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.AvoidStartImport
	 * @generated
	 */
	public Adapter createAvoidStartImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.ConstantName <em>Constant Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.ConstantName
	 * @generated
	 */
	public Adapter createConstantNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.AbbreviationAsWordInName <em>Abbreviation As Word In Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.AbbreviationAsWordInName
	 * @generated
	 */
	public Adapter createAbbreviationAsWordInNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.AbstractClassName <em>Abstract Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.AbstractClassName
	 * @generated
	 */
	public Adapter createAbstractClassNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.AvoidEscapedUnicodeCharacters <em>Avoid Escaped Unicode Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.AvoidEscapedUnicodeCharacters
	 * @generated
	 */
	public Adapter createAvoidEscapedUnicodeCharactersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.LocalFinalVariableName <em>Local Final Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.LocalFinalVariableName
	 * @generated
	 */
	public Adapter createLocalFinalVariableNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.LocalVariableName <em>Local Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.LocalVariableName
	 * @generated
	 */
	public Adapter createLocalVariableNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.MemberName <em>Member Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.MemberName
	 * @generated
	 */
	public Adapter createMemberNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.MethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.MethodName
	 * @generated
	 */
	public Adapter createMethodNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.PackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.PackageName
	 * @generated
	 */
	public Adapter createPackageNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.ParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.ParameterName
	 * @generated
	 */
	public Adapter createParameterNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.StaticVariableName <em>Static Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.StaticVariableName
	 * @generated
	 */
	public Adapter createStaticVariableNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.TypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.TypeName
	 * @generated
	 */
	public Adapter createTypeNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.UnusedImports <em>Unused Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.UnusedImports
	 * @generated
	 */
	public Adapter createUnusedImportsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.RedundantImport <em>Redundant Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.RedundantImport
	 * @generated
	 */
	public Adapter createRedundantImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.ParameterNumber <em>Parameter Number</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.ParameterNumber
	 * @generated
	 */
	public Adapter createParameterNumberAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.RedundantModifier <em>Redundant Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.RedundantModifier
	 * @generated
	 */
	public Adapter createRedundantModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.AvoidInlineConditionals <em>Avoid Inline Conditionals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.AvoidInlineConditionals
	 * @generated
	 */
	public Adapter createAvoidInlineConditionalsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.EqualsHashCode <em>Equals Hash Code</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.EqualsHashCode
	 * @generated
	 */
	public Adapter createEqualsHashCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.HiddenField <em>Hidden Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.HiddenField
	 * @generated
	 */
	public Adapter createHiddenFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.MissingSwitchDefault <em>Missing Switch Default</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.MissingSwitchDefault
	 * @generated
	 */
	public Adapter createMissingSwitchDefaultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.RedundantThrows <em>Redundant Throws</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.RedundantThrows
	 * @generated
	 */
	public Adapter createRedundantThrowsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.SimplifyBooleanExpression <em>Simplify Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.SimplifyBooleanExpression
	 * @generated
	 */
	public Adapter createSimplifyBooleanExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.SimplifyBooleanReturn <em>Simplify Boolean Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.SimplifyBooleanReturn
	 * @generated
	 */
	public Adapter createSimplifyBooleanReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.FinalClass <em>Final Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.FinalClass
	 * @generated
	 */
	public Adapter createFinalClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.InterfaceIsType <em>Interface Is Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.InterfaceIsType
	 * @generated
	 */
	public Adapter createInterfaceIsTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.VisibilityModifier <em>Visibility Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.VisibilityModifier
	 * @generated
	 */
	public Adapter createVisibilityModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.LooseCoupling <em>Loose Coupling</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.LooseCoupling
	 * @generated
	 */
	public Adapter createLooseCouplingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.SignatureDeclareThrowsException <em>Signature Declare Throws Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.SignatureDeclareThrowsException
	 * @generated
	 */
	public Adapter createSignatureDeclareThrowsExceptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.DefaultLabelNotLastInSwitchStmt <em>Default Label Not Last In Switch Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.DefaultLabelNotLastInSwitchStmt
	 * @generated
	 */
	public Adapter createDefaultLabelNotLastInSwitchStmtAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.EqualsNull <em>Equals Null</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.EqualsNull
	 * @generated
	 */
	public Adapter createEqualsNullAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.CompareObjectsWithEquals <em>Compare Objects With Equals</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.CompareObjectsWithEquals
	 * @generated
	 */
	public Adapter createCompareObjectsWithEqualsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.PositionLiteralsFirstInComparisons <em>Position Literals First In Comparisons</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.PositionLiteralsFirstInComparisons
	 * @generated
	 */
	public Adapter createPositionLiteralsFirstInComparisonsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.UseEqualsToCompareStrings <em>Use Equals To Compare Strings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.UseEqualsToCompareStrings
	 * @generated
	 */
	public Adapter createUseEqualsToCompareStringsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.IntegerInstantiation <em>Integer Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.IntegerInstantiation
	 * @generated
	 */
	public Adapter createIntegerInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.ByteInstantiation <em>Byte Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.ByteInstantiation
	 * @generated
	 */
	public Adapter createByteInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.LongInstantiation <em>Long Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.LongInstantiation
	 * @generated
	 */
	public Adapter createLongInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.BooleanInstantiation <em>Boolean Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.BooleanInstantiation
	 * @generated
	 */
	public Adapter createBooleanInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.ShortInstantiation <em>Short Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.ShortInstantiation
	 * @generated
	 */
	public Adapter createShortInstantiationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.SimplifyStartsWith <em>Simplify Starts With</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.SimplifyStartsWith
	 * @generated
	 */
	public Adapter createSimplifyStartsWithAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.UnnecessaryReturn <em>Unnecessary Return</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.UnnecessaryReturn
	 * @generated
	 */
	public Adapter createUnnecessaryReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.UnconditionalIfStatement <em>Unconditional If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.UnconditionalIfStatement
	 * @generated
	 */
	public Adapter createUnconditionalIfStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.atlmr.anomalies.UnnecessaryFinalModifier <em>Unnecessary Final Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.atlmr.anomalies.UnnecessaryFinalModifier
	 * @generated
	 */
	public Adapter createUnnecessaryFinalModifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //AnomaliesAdapterFactory
