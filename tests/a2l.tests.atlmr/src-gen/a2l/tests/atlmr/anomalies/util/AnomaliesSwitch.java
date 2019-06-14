/**
 */
package a2l.tests.atlmr.anomalies.util;

import a2l.tests.atlmr.anomalies.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see a2l.tests.atlmr.anomalies.AnomaliesPackage
 * @generated
 */
public class AnomaliesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnomaliesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnomaliesSwitch() {
		if (modelPackage == null) {
			modelPackage = AnomaliesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnomaliesPackage.ANOMALY: {
				Anomaly anomaly = (Anomaly)theEObject;
				T result = caseAnomaly(anomaly);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.AVOID_START_IMPORT: {
				AvoidStartImport avoidStartImport = (AvoidStartImport)theEObject;
				T result = caseAvoidStartImport(avoidStartImport);
				if (result == null) result = caseAnomaly(avoidStartImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.CONSTANT_NAME: {
				ConstantName constantName = (ConstantName)theEObject;
				T result = caseConstantName(constantName);
				if (result == null) result = caseAnomaly(constantName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.ABBREVIATION_AS_WORD_IN_NAME: {
				AbbreviationAsWordInName abbreviationAsWordInName = (AbbreviationAsWordInName)theEObject;
				T result = caseAbbreviationAsWordInName(abbreviationAsWordInName);
				if (result == null) result = caseAnomaly(abbreviationAsWordInName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.ABSTRACT_CLASS_NAME: {
				AbstractClassName abstractClassName = (AbstractClassName)theEObject;
				T result = caseAbstractClassName(abstractClassName);
				if (result == null) result = caseAnomaly(abstractClassName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.AVOID_ESCAPED_UNICODE_CHARACTERS: {
				AvoidEscapedUnicodeCharacters avoidEscapedUnicodeCharacters = (AvoidEscapedUnicodeCharacters)theEObject;
				T result = caseAvoidEscapedUnicodeCharacters(avoidEscapedUnicodeCharacters);
				if (result == null) result = caseAnomaly(avoidEscapedUnicodeCharacters);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.LOCAL_FINAL_VARIABLE_NAME: {
				LocalFinalVariableName localFinalVariableName = (LocalFinalVariableName)theEObject;
				T result = caseLocalFinalVariableName(localFinalVariableName);
				if (result == null) result = caseAnomaly(localFinalVariableName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.LOCAL_VARIABLE_NAME: {
				LocalVariableName localVariableName = (LocalVariableName)theEObject;
				T result = caseLocalVariableName(localVariableName);
				if (result == null) result = caseAnomaly(localVariableName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.MEMBER_NAME: {
				MemberName memberName = (MemberName)theEObject;
				T result = caseMemberName(memberName);
				if (result == null) result = caseAnomaly(memberName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.METHOD_NAME: {
				MethodName methodName = (MethodName)theEObject;
				T result = caseMethodName(methodName);
				if (result == null) result = caseAnomaly(methodName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.PACKAGE_NAME: {
				PackageName packageName = (PackageName)theEObject;
				T result = casePackageName(packageName);
				if (result == null) result = caseAnomaly(packageName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.PARAMETER_NAME: {
				ParameterName parameterName = (ParameterName)theEObject;
				T result = caseParameterName(parameterName);
				if (result == null) result = caseAnomaly(parameterName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.STATIC_VARIABLE_NAME: {
				StaticVariableName staticVariableName = (StaticVariableName)theEObject;
				T result = caseStaticVariableName(staticVariableName);
				if (result == null) result = caseAnomaly(staticVariableName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.TYPE_NAME: {
				TypeName typeName = (TypeName)theEObject;
				T result = caseTypeName(typeName);
				if (result == null) result = caseAnomaly(typeName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.UNUSED_IMPORTS: {
				UnusedImports unusedImports = (UnusedImports)theEObject;
				T result = caseUnusedImports(unusedImports);
				if (result == null) result = caseAnomaly(unusedImports);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.REDUNDANT_IMPORT: {
				RedundantImport redundantImport = (RedundantImport)theEObject;
				T result = caseRedundantImport(redundantImport);
				if (result == null) result = caseAnomaly(redundantImport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.PARAMETER_NUMBER: {
				ParameterNumber parameterNumber = (ParameterNumber)theEObject;
				T result = caseParameterNumber(parameterNumber);
				if (result == null) result = caseAnomaly(parameterNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.REDUNDANT_MODIFIER: {
				RedundantModifier redundantModifier = (RedundantModifier)theEObject;
				T result = caseRedundantModifier(redundantModifier);
				if (result == null) result = caseAnomaly(redundantModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.AVOID_INLINE_CONDITIONALS: {
				AvoidInlineConditionals avoidInlineConditionals = (AvoidInlineConditionals)theEObject;
				T result = caseAvoidInlineConditionals(avoidInlineConditionals);
				if (result == null) result = caseAnomaly(avoidInlineConditionals);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.EQUALS_HASH_CODE: {
				EqualsHashCode equalsHashCode = (EqualsHashCode)theEObject;
				T result = caseEqualsHashCode(equalsHashCode);
				if (result == null) result = caseAnomaly(equalsHashCode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.HIDDEN_FIELD: {
				HiddenField hiddenField = (HiddenField)theEObject;
				T result = caseHiddenField(hiddenField);
				if (result == null) result = caseAnomaly(hiddenField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.MISSING_SWITCH_DEFAULT: {
				MissingSwitchDefault missingSwitchDefault = (MissingSwitchDefault)theEObject;
				T result = caseMissingSwitchDefault(missingSwitchDefault);
				if (result == null) result = caseAnomaly(missingSwitchDefault);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.REDUNDANT_THROWS: {
				RedundantThrows redundantThrows = (RedundantThrows)theEObject;
				T result = caseRedundantThrows(redundantThrows);
				if (result == null) result = caseAnomaly(redundantThrows);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.SIMPLIFY_BOOLEAN_EXPRESSION: {
				SimplifyBooleanExpression simplifyBooleanExpression = (SimplifyBooleanExpression)theEObject;
				T result = caseSimplifyBooleanExpression(simplifyBooleanExpression);
				if (result == null) result = caseAnomaly(simplifyBooleanExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.SIMPLIFY_BOOLEAN_RETURN: {
				SimplifyBooleanReturn simplifyBooleanReturn = (SimplifyBooleanReturn)theEObject;
				T result = caseSimplifyBooleanReturn(simplifyBooleanReturn);
				if (result == null) result = caseAnomaly(simplifyBooleanReturn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.FINAL_CLASS: {
				FinalClass finalClass = (FinalClass)theEObject;
				T result = caseFinalClass(finalClass);
				if (result == null) result = caseAnomaly(finalClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.INTERFACE_IS_TYPE: {
				InterfaceIsType interfaceIsType = (InterfaceIsType)theEObject;
				T result = caseInterfaceIsType(interfaceIsType);
				if (result == null) result = caseAnomaly(interfaceIsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.VISIBILITY_MODIFIER: {
				VisibilityModifier visibilityModifier = (VisibilityModifier)theEObject;
				T result = caseVisibilityModifier(visibilityModifier);
				if (result == null) result = caseAnomaly(visibilityModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.LOOSE_COUPLING: {
				LooseCoupling looseCoupling = (LooseCoupling)theEObject;
				T result = caseLooseCoupling(looseCoupling);
				if (result == null) result = caseAnomaly(looseCoupling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.SIGNATURE_DECLARE_THROWS_EXCEPTION: {
				SignatureDeclareThrowsException signatureDeclareThrowsException = (SignatureDeclareThrowsException)theEObject;
				T result = caseSignatureDeclareThrowsException(signatureDeclareThrowsException);
				if (result == null) result = caseAnomaly(signatureDeclareThrowsException);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT: {
				DefaultLabelNotLastInSwitchStmt defaultLabelNotLastInSwitchStmt = (DefaultLabelNotLastInSwitchStmt)theEObject;
				T result = caseDefaultLabelNotLastInSwitchStmt(defaultLabelNotLastInSwitchStmt);
				if (result == null) result = caseAnomaly(defaultLabelNotLastInSwitchStmt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.EQUALS_NULL: {
				EqualsNull equalsNull = (EqualsNull)theEObject;
				T result = caseEqualsNull(equalsNull);
				if (result == null) result = caseAnomaly(equalsNull);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.COMPARE_OBJECTS_WITH_EQUALS: {
				CompareObjectsWithEquals compareObjectsWithEquals = (CompareObjectsWithEquals)theEObject;
				T result = caseCompareObjectsWithEquals(compareObjectsWithEquals);
				if (result == null) result = caseAnomaly(compareObjectsWithEquals);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.POSITION_LITERALS_FIRST_IN_COMPARISONS: {
				PositionLiteralsFirstInComparisons positionLiteralsFirstInComparisons = (PositionLiteralsFirstInComparisons)theEObject;
				T result = casePositionLiteralsFirstInComparisons(positionLiteralsFirstInComparisons);
				if (result == null) result = caseAnomaly(positionLiteralsFirstInComparisons);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.USE_EQUALS_TO_COMPARE_STRINGS: {
				UseEqualsToCompareStrings useEqualsToCompareStrings = (UseEqualsToCompareStrings)theEObject;
				T result = caseUseEqualsToCompareStrings(useEqualsToCompareStrings);
				if (result == null) result = caseAnomaly(useEqualsToCompareStrings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.INTEGER_INSTANTIATION: {
				IntegerInstantiation integerInstantiation = (IntegerInstantiation)theEObject;
				T result = caseIntegerInstantiation(integerInstantiation);
				if (result == null) result = caseAnomaly(integerInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.BYTE_INSTANTIATION: {
				ByteInstantiation byteInstantiation = (ByteInstantiation)theEObject;
				T result = caseByteInstantiation(byteInstantiation);
				if (result == null) result = caseAnomaly(byteInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.LONG_INSTANTIATION: {
				LongInstantiation longInstantiation = (LongInstantiation)theEObject;
				T result = caseLongInstantiation(longInstantiation);
				if (result == null) result = caseAnomaly(longInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.BOOLEAN_INSTANTIATION: {
				BooleanInstantiation booleanInstantiation = (BooleanInstantiation)theEObject;
				T result = caseBooleanInstantiation(booleanInstantiation);
				if (result == null) result = caseAnomaly(booleanInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.SHORT_INSTANTIATION: {
				ShortInstantiation shortInstantiation = (ShortInstantiation)theEObject;
				T result = caseShortInstantiation(shortInstantiation);
				if (result == null) result = caseAnomaly(shortInstantiation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.SIMPLIFY_STARTS_WITH: {
				SimplifyStartsWith simplifyStartsWith = (SimplifyStartsWith)theEObject;
				T result = caseSimplifyStartsWith(simplifyStartsWith);
				if (result == null) result = caseAnomaly(simplifyStartsWith);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.UNNECESSARY_RETURN: {
				UnnecessaryReturn unnecessaryReturn = (UnnecessaryReturn)theEObject;
				T result = caseUnnecessaryReturn(unnecessaryReturn);
				if (result == null) result = caseAnomaly(unnecessaryReturn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.UNCONDITIONAL_IF_STATEMENT: {
				UnconditionalIfStatement unconditionalIfStatement = (UnconditionalIfStatement)theEObject;
				T result = caseUnconditionalIfStatement(unconditionalIfStatement);
				if (result == null) result = caseAnomaly(unconditionalIfStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case AnomaliesPackage.UNNECESSARY_FINAL_MODIFIER: {
				UnnecessaryFinalModifier unnecessaryFinalModifier = (UnnecessaryFinalModifier)theEObject;
				T result = caseUnnecessaryFinalModifier(unnecessaryFinalModifier);
				if (result == null) result = caseAnomaly(unnecessaryFinalModifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Anomaly</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Anomaly</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnomaly(Anomaly object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Avoid Start Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Avoid Start Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvoidStartImport(AvoidStartImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantName(ConstantName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abbreviation As Word In Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abbreviation As Word In Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbbreviationAsWordInName(AbbreviationAsWordInName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Class Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Class Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractClassName(AbstractClassName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Avoid Escaped Unicode Characters</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Avoid Escaped Unicode Characters</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvoidEscapedUnicodeCharacters(AvoidEscapedUnicodeCharacters object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Final Variable Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Final Variable Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalFinalVariableName(LocalFinalVariableName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Variable Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Variable Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalVariableName(LocalVariableName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Member Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Member Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMemberName(MemberName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodName(MethodName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageName(PackageName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterName(ParameterName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Variable Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Variable Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticVariableName(StaticVariableName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Name</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeName(TypeName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unused Imports</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unused Imports</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnusedImports(UnusedImports object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redundant Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redundant Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedundantImport(RedundantImport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Number</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterNumber(ParameterNumber object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redundant Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redundant Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedundantModifier(RedundantModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Avoid Inline Conditionals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Avoid Inline Conditionals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAvoidInlineConditionals(AvoidInlineConditionals object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Hash Code</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Hash Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualsHashCode(EqualsHashCode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Hidden Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hidden Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHiddenField(HiddenField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Missing Switch Default</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Missing Switch Default</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMissingSwitchDefault(MissingSwitchDefault object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redundant Throws</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redundant Throws</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedundantThrows(RedundantThrows object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simplify Boolean Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simplify Boolean Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimplifyBooleanExpression(SimplifyBooleanExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simplify Boolean Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simplify Boolean Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimplifyBooleanReturn(SimplifyBooleanReturn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Final Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Final Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalClass(FinalClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Is Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Is Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceIsType(InterfaceIsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visibility Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visibility Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisibilityModifier(VisibilityModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loose Coupling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loose Coupling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLooseCoupling(LooseCoupling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Signature Declare Throws Exception</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Signature Declare Throws Exception</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSignatureDeclareThrowsException(SignatureDeclareThrowsException object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Label Not Last In Switch Stmt</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Label Not Last In Switch Stmt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultLabelNotLastInSwitchStmt(DefaultLabelNotLastInSwitchStmt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Equals Null</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Equals Null</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEqualsNull(EqualsNull object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Compare Objects With Equals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Compare Objects With Equals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompareObjectsWithEquals(CompareObjectsWithEquals object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Position Literals First In Comparisons</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Position Literals First In Comparisons</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionLiteralsFirstInComparisons(PositionLiteralsFirstInComparisons object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Use Equals To Compare Strings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Use Equals To Compare Strings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUseEqualsToCompareStrings(UseEqualsToCompareStrings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerInstantiation(IntegerInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Byte Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Byte Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseByteInstantiation(ByteInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongInstantiation(LongInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanInstantiation(BooleanInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Short Instantiation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Short Instantiation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseShortInstantiation(ShortInstantiation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simplify Starts With</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simplify Starts With</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimplifyStartsWith(SimplifyStartsWith object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unnecessary Return</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unnecessary Return</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnnecessaryReturn(UnnecessaryReturn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unconditional If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unconditional If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnconditionalIfStatement(UnconditionalIfStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unnecessary Final Modifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unnecessary Final Modifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnnecessaryFinalModifier(UnnecessaryFinalModifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnomaliesSwitch
