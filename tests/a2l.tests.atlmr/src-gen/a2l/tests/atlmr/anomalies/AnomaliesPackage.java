/**
 */
package a2l.tests.atlmr.anomalies;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see a2l.tests.atlmr.anomalies.AnomaliesFactory
 * @model kind="package"
 * @generated
 */
public interface AnomaliesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "anomalies";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://atlanmod.checkstyles.org";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "anomalies";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnomaliesPackage eINSTANCE = a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl.init();

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AnomalyImpl <em>Anomaly</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AnomalyImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAnomaly()
	 * @generated
	 */
	int ANOMALY = 0;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANOMALY__TRACE = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANOMALY__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANOMALY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Anomaly</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANOMALY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidStartImportImpl <em>Avoid Start Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AvoidStartImportImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidStartImport()
	 * @generated
	 */
	int AVOID_START_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_START_IMPORT__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_START_IMPORT__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Avoid Start Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_START_IMPORT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Avoid Start Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_START_IMPORT_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.ConstantNameImpl <em>Constant Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.ConstantNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getConstantName()
	 * @generated
	 */
	int CONSTANT_NAME = 2;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Constant Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constant Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AbbreviationAsWordInNameImpl <em>Abbreviation As Word In Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AbbreviationAsWordInNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAbbreviationAsWordInName()
	 * @generated
	 */
	int ABBREVIATION_AS_WORD_IN_NAME = 3;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABBREVIATION_AS_WORD_IN_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABBREVIATION_AS_WORD_IN_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Abbreviation As Word In Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABBREVIATION_AS_WORD_IN_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abbreviation As Word In Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABBREVIATION_AS_WORD_IN_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AbstractClassNameImpl <em>Abstract Class Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AbstractClassNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAbstractClassName()
	 * @generated
	 */
	int ABSTRACT_CLASS_NAME = 4;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CLASS_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CLASS_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Abstract Class Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CLASS_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Abstract Class Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_CLASS_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidEscapedUnicodeCharactersImpl <em>Avoid Escaped Unicode Characters</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AvoidEscapedUnicodeCharactersImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidEscapedUnicodeCharacters()
	 * @generated
	 */
	int AVOID_ESCAPED_UNICODE_CHARACTERS = 5;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_ESCAPED_UNICODE_CHARACTERS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_ESCAPED_UNICODE_CHARACTERS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Avoid Escaped Unicode Characters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_ESCAPED_UNICODE_CHARACTERS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Avoid Escaped Unicode Characters</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_ESCAPED_UNICODE_CHARACTERS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.LocalFinalVariableNameImpl <em>Local Final Variable Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.LocalFinalVariableNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLocalFinalVariableName()
	 * @generated
	 */
	int LOCAL_FINAL_VARIABLE_NAME = 6;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FINAL_VARIABLE_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FINAL_VARIABLE_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Local Final Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FINAL_VARIABLE_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Final Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_FINAL_VARIABLE_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.LocalVariableNameImpl <em>Local Variable Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.LocalVariableNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLocalVariableName()
	 * @generated
	 */
	int LOCAL_VARIABLE_NAME = 7;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Local Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Local Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_VARIABLE_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.MemberNameImpl <em>Member Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.MemberNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMemberName()
	 * @generated
	 */
	int MEMBER_NAME = 8;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Member Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Member Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.MethodNameImpl <em>Method Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.MethodNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMethodName()
	 * @generated
	 */
	int METHOD_NAME = 9;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Method Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Method Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.PackageNameImpl <em>Package Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.PackageNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getPackageName()
	 * @generated
	 */
	int PACKAGE_NAME = 10;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Package Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Package Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.ParameterNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getParameterName()
	 * @generated
	 */
	int PARAMETER_NAME = 11;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Parameter Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.StaticVariableNameImpl <em>Static Variable Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.StaticVariableNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getStaticVariableName()
	 * @generated
	 */
	int STATIC_VARIABLE_NAME = 12;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VARIABLE_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VARIABLE_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Static Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VARIABLE_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Static Variable Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATIC_VARIABLE_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.TypeNameImpl <em>Type Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.TypeNameImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getTypeName()
	 * @generated
	 */
	int TYPE_NAME = 13;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Type Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Type Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NAME_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.UnusedImportsImpl <em>Unused Imports</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.UnusedImportsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnusedImports()
	 * @generated
	 */
	int UNUSED_IMPORTS = 14;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNUSED_IMPORTS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNUSED_IMPORTS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Unused Imports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNUSED_IMPORTS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unused Imports</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNUSED_IMPORTS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantImportImpl <em>Redundant Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.RedundantImportImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantImport()
	 * @generated
	 */
	int REDUNDANT_IMPORT = 15;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_IMPORT__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_IMPORT__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Redundant Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_IMPORT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Redundant Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_IMPORT_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.ParameterNumberImpl <em>Parameter Number</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.ParameterNumberImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getParameterNumber()
	 * @generated
	 */
	int PARAMETER_NUMBER = 16;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NUMBER__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NUMBER__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Parameter Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NUMBER_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter Number</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_NUMBER_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantModifierImpl <em>Redundant Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.RedundantModifierImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantModifier()
	 * @generated
	 */
	int REDUNDANT_MODIFIER = 17;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_MODIFIER__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_MODIFIER__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Redundant Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_MODIFIER_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Redundant Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_MODIFIER_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidInlineConditionalsImpl <em>Avoid Inline Conditionals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.AvoidInlineConditionalsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidInlineConditionals()
	 * @generated
	 */
	int AVOID_INLINE_CONDITIONALS = 18;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_INLINE_CONDITIONALS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_INLINE_CONDITIONALS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Avoid Inline Conditionals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_INLINE_CONDITIONALS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Avoid Inline Conditionals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVOID_INLINE_CONDITIONALS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.EqualsHashCodeImpl <em>Equals Hash Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.EqualsHashCodeImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getEqualsHashCode()
	 * @generated
	 */
	int EQUALS_HASH_CODE = 19;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_HASH_CODE__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_HASH_CODE__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Equals Hash Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_HASH_CODE_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equals Hash Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_HASH_CODE_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.HiddenFieldImpl <em>Hidden Field</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.HiddenFieldImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getHiddenField()
	 * @generated
	 */
	int HIDDEN_FIELD = 20;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDDEN_FIELD__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDDEN_FIELD__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Hidden Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDDEN_FIELD_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hidden Field</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HIDDEN_FIELD_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.MissingSwitchDefaultImpl <em>Missing Switch Default</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.MissingSwitchDefaultImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMissingSwitchDefault()
	 * @generated
	 */
	int MISSING_SWITCH_DEFAULT = 21;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_SWITCH_DEFAULT__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_SWITCH_DEFAULT__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Missing Switch Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_SWITCH_DEFAULT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Missing Switch Default</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_SWITCH_DEFAULT_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantThrowsImpl <em>Redundant Throws</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.RedundantThrowsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantThrows()
	 * @generated
	 */
	int REDUNDANT_THROWS = 22;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_THROWS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_THROWS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Redundant Throws</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_THROWS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Redundant Throws</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUNDANT_THROWS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyBooleanExpressionImpl <em>Simplify Boolean Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.SimplifyBooleanExpressionImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyBooleanExpression()
	 * @generated
	 */
	int SIMPLIFY_BOOLEAN_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_EXPRESSION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_EXPRESSION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Simplify Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_EXPRESSION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simplify Boolean Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_EXPRESSION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyBooleanReturnImpl <em>Simplify Boolean Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.SimplifyBooleanReturnImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyBooleanReturn()
	 * @generated
	 */
	int SIMPLIFY_BOOLEAN_RETURN = 24;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_RETURN__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_RETURN__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Simplify Boolean Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_RETURN_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simplify Boolean Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_BOOLEAN_RETURN_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.FinalClassImpl <em>Final Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.FinalClassImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getFinalClass()
	 * @generated
	 */
	int FINAL_CLASS = 25;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_CLASS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_CLASS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Final Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_CLASS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Final Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FINAL_CLASS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.InterfaceIsTypeImpl <em>Interface Is Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.InterfaceIsTypeImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getInterfaceIsType()
	 * @generated
	 */
	int INTERFACE_IS_TYPE = 26;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_IS_TYPE__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_IS_TYPE__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Interface Is Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_IS_TYPE_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Interface Is Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERFACE_IS_TYPE_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.VisibilityModifierImpl <em>Visibility Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.VisibilityModifierImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getVisibilityModifier()
	 * @generated
	 */
	int VISIBILITY_MODIFIER = 27;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_MODIFIER__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_MODIFIER__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Visibility Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_MODIFIER_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Visibility Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_MODIFIER_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.LooseCouplingImpl <em>Loose Coupling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.LooseCouplingImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLooseCoupling()
	 * @generated
	 */
	int LOOSE_COUPLING = 28;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOSE_COUPLING__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOSE_COUPLING__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Loose Coupling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOSE_COUPLING_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Loose Coupling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOSE_COUPLING_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.SignatureDeclareThrowsExceptionImpl <em>Signature Declare Throws Exception</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.SignatureDeclareThrowsExceptionImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSignatureDeclareThrowsException()
	 * @generated
	 */
	int SIGNATURE_DECLARE_THROWS_EXCEPTION = 29;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_DECLARE_THROWS_EXCEPTION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_DECLARE_THROWS_EXCEPTION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Signature Declare Throws Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_DECLARE_THROWS_EXCEPTION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Signature Declare Throws Exception</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNATURE_DECLARE_THROWS_EXCEPTION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.DefaultLabelNotLastInSwitchStmtImpl <em>Default Label Not Last In Switch Stmt</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.DefaultLabelNotLastInSwitchStmtImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getDefaultLabelNotLastInSwitchStmt()
	 * @generated
	 */
	int DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT = 30;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Default Label Not Last In Switch Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Default Label Not Last In Switch Stmt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.EqualsNullImpl <em>Equals Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.EqualsNullImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getEqualsNull()
	 * @generated
	 */
	int EQUALS_NULL = 31;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_NULL__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_NULL__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Equals Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_NULL_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Equals Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALS_NULL_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.CompareObjectsWithEqualsImpl <em>Compare Objects With Equals</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.CompareObjectsWithEqualsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getCompareObjectsWithEquals()
	 * @generated
	 */
	int COMPARE_OBJECTS_WITH_EQUALS = 32;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_OBJECTS_WITH_EQUALS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_OBJECTS_WITH_EQUALS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Compare Objects With Equals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_OBJECTS_WITH_EQUALS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Compare Objects With Equals</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPARE_OBJECTS_WITH_EQUALS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.PositionLiteralsFirstInComparisonsImpl <em>Position Literals First In Comparisons</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.PositionLiteralsFirstInComparisonsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getPositionLiteralsFirstInComparisons()
	 * @generated
	 */
	int POSITION_LITERALS_FIRST_IN_COMPARISONS = 33;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_LITERALS_FIRST_IN_COMPARISONS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_LITERALS_FIRST_IN_COMPARISONS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Position Literals First In Comparisons</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_LITERALS_FIRST_IN_COMPARISONS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Position Literals First In Comparisons</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_LITERALS_FIRST_IN_COMPARISONS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.UseEqualsToCompareStringsImpl <em>Use Equals To Compare Strings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.UseEqualsToCompareStringsImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUseEqualsToCompareStrings()
	 * @generated
	 */
	int USE_EQUALS_TO_COMPARE_STRINGS = 34;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUALS_TO_COMPARE_STRINGS__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUALS_TO_COMPARE_STRINGS__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Use Equals To Compare Strings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUALS_TO_COMPARE_STRINGS_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Use Equals To Compare Strings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_EQUALS_TO_COMPARE_STRINGS_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.IntegerInstantiationImpl <em>Integer Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.IntegerInstantiationImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getIntegerInstantiation()
	 * @generated
	 */
	int INTEGER_INSTANTIATION = 35;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INSTANTIATION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INSTANTIATION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Integer Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INSTANTIATION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Integer Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INSTANTIATION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.ByteInstantiationImpl <em>Byte Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.ByteInstantiationImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getByteInstantiation()
	 * @generated
	 */
	int BYTE_INSTANTIATION = 36;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_INSTANTIATION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_INSTANTIATION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Byte Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_INSTANTIATION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Byte Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BYTE_INSTANTIATION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.LongInstantiationImpl <em>Long Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.LongInstantiationImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLongInstantiation()
	 * @generated
	 */
	int LONG_INSTANTIATION = 37;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_INSTANTIATION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_INSTANTIATION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Long Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_INSTANTIATION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Long Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LONG_INSTANTIATION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.BooleanInstantiationImpl <em>Boolean Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.BooleanInstantiationImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getBooleanInstantiation()
	 * @generated
	 */
	int BOOLEAN_INSTANTIATION = 38;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANTIATION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANTIATION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Boolean Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANTIATION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Boolean Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_INSTANTIATION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.ShortInstantiationImpl <em>Short Instantiation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.ShortInstantiationImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getShortInstantiation()
	 * @generated
	 */
	int SHORT_INSTANTIATION = 39;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_INSTANTIATION__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_INSTANTIATION__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Short Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_INSTANTIATION_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Short Instantiation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHORT_INSTANTIATION_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyStartsWithImpl <em>Simplify Starts With</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.SimplifyStartsWithImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyStartsWith()
	 * @generated
	 */
	int SIMPLIFY_STARTS_WITH = 40;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_STARTS_WITH__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_STARTS_WITH__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Simplify Starts With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_STARTS_WITH_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Simplify Starts With</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLIFY_STARTS_WITH_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.UnnecessaryReturnImpl <em>Unnecessary Return</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.UnnecessaryReturnImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnnecessaryReturn()
	 * @generated
	 */
	int UNNECESSARY_RETURN = 41;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_RETURN__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_RETURN__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Unnecessary Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_RETURN_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unnecessary Return</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_RETURN_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.UnconditionalIfStatementImpl <em>Unconditional If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.UnconditionalIfStatementImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnconditionalIfStatement()
	 * @generated
	 */
	int UNCONDITIONAL_IF_STATEMENT = 42;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCONDITIONAL_IF_STATEMENT__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCONDITIONAL_IF_STATEMENT__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Unconditional If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCONDITIONAL_IF_STATEMENT_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unconditional If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNCONDITIONAL_IF_STATEMENT_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.tests.atlmr.anomalies.impl.UnnecessaryFinalModifierImpl <em>Unnecessary Final Modifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.tests.atlmr.anomalies.impl.UnnecessaryFinalModifierImpl
	 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnnecessaryFinalModifier()
	 * @generated
	 */
	int UNNECESSARY_FINAL_MODIFIER = 43;

	/**
	 * The feature id for the '<em><b>Trace</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_FINAL_MODIFIER__TRACE = ANOMALY__TRACE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_FINAL_MODIFIER__DESCRIPTION = ANOMALY__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Unnecessary Final Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_FINAL_MODIFIER_FEATURE_COUNT = ANOMALY_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Unnecessary Final Modifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNNECESSARY_FINAL_MODIFIER_OPERATION_COUNT = ANOMALY_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.Anomaly <em>Anomaly</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Anomaly</em>'.
	 * @see a2l.tests.atlmr.anomalies.Anomaly
	 * @generated
	 */
	EClass getAnomaly();

	/**
	 * Returns the meta object for the reference list '{@link a2l.tests.atlmr.anomalies.Anomaly#getTrace <em>Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Trace</em>'.
	 * @see a2l.tests.atlmr.anomalies.Anomaly#getTrace()
	 * @see #getAnomaly()
	 * @generated
	 */
	EReference getAnomaly_Trace();

	/**
	 * Returns the meta object for the attribute '{@link a2l.tests.atlmr.anomalies.Anomaly#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see a2l.tests.atlmr.anomalies.Anomaly#getDescription()
	 * @see #getAnomaly()
	 * @generated
	 */
	EAttribute getAnomaly_Description();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.AvoidStartImport <em>Avoid Start Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Avoid Start Import</em>'.
	 * @see a2l.tests.atlmr.anomalies.AvoidStartImport
	 * @generated
	 */
	EClass getAvoidStartImport();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.ConstantName <em>Constant Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.ConstantName
	 * @generated
	 */
	EClass getConstantName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.AbbreviationAsWordInName <em>Abbreviation As Word In Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abbreviation As Word In Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.AbbreviationAsWordInName
	 * @generated
	 */
	EClass getAbbreviationAsWordInName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.AbstractClassName <em>Abstract Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Class Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.AbstractClassName
	 * @generated
	 */
	EClass getAbstractClassName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.AvoidEscapedUnicodeCharacters <em>Avoid Escaped Unicode Characters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Avoid Escaped Unicode Characters</em>'.
	 * @see a2l.tests.atlmr.anomalies.AvoidEscapedUnicodeCharacters
	 * @generated
	 */
	EClass getAvoidEscapedUnicodeCharacters();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.LocalFinalVariableName <em>Local Final Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Final Variable Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.LocalFinalVariableName
	 * @generated
	 */
	EClass getLocalFinalVariableName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.LocalVariableName <em>Local Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Variable Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.LocalVariableName
	 * @generated
	 */
	EClass getLocalVariableName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.MemberName <em>Member Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.MemberName
	 * @generated
	 */
	EClass getMemberName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.MethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.MethodName
	 * @generated
	 */
	EClass getMethodName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.PackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.PackageName
	 * @generated
	 */
	EClass getPackageName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.ParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.ParameterName
	 * @generated
	 */
	EClass getParameterName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.StaticVariableName <em>Static Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Static Variable Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.StaticVariableName
	 * @generated
	 */
	EClass getStaticVariableName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.TypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Name</em>'.
	 * @see a2l.tests.atlmr.anomalies.TypeName
	 * @generated
	 */
	EClass getTypeName();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.UnusedImports <em>Unused Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unused Imports</em>'.
	 * @see a2l.tests.atlmr.anomalies.UnusedImports
	 * @generated
	 */
	EClass getUnusedImports();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.RedundantImport <em>Redundant Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redundant Import</em>'.
	 * @see a2l.tests.atlmr.anomalies.RedundantImport
	 * @generated
	 */
	EClass getRedundantImport();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.ParameterNumber <em>Parameter Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Number</em>'.
	 * @see a2l.tests.atlmr.anomalies.ParameterNumber
	 * @generated
	 */
	EClass getParameterNumber();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.RedundantModifier <em>Redundant Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redundant Modifier</em>'.
	 * @see a2l.tests.atlmr.anomalies.RedundantModifier
	 * @generated
	 */
	EClass getRedundantModifier();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.AvoidInlineConditionals <em>Avoid Inline Conditionals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Avoid Inline Conditionals</em>'.
	 * @see a2l.tests.atlmr.anomalies.AvoidInlineConditionals
	 * @generated
	 */
	EClass getAvoidInlineConditionals();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.EqualsHashCode <em>Equals Hash Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equals Hash Code</em>'.
	 * @see a2l.tests.atlmr.anomalies.EqualsHashCode
	 * @generated
	 */
	EClass getEqualsHashCode();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.HiddenField <em>Hidden Field</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hidden Field</em>'.
	 * @see a2l.tests.atlmr.anomalies.HiddenField
	 * @generated
	 */
	EClass getHiddenField();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.MissingSwitchDefault <em>Missing Switch Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Missing Switch Default</em>'.
	 * @see a2l.tests.atlmr.anomalies.MissingSwitchDefault
	 * @generated
	 */
	EClass getMissingSwitchDefault();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.RedundantThrows <em>Redundant Throws</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redundant Throws</em>'.
	 * @see a2l.tests.atlmr.anomalies.RedundantThrows
	 * @generated
	 */
	EClass getRedundantThrows();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.SimplifyBooleanExpression <em>Simplify Boolean Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simplify Boolean Expression</em>'.
	 * @see a2l.tests.atlmr.anomalies.SimplifyBooleanExpression
	 * @generated
	 */
	EClass getSimplifyBooleanExpression();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.SimplifyBooleanReturn <em>Simplify Boolean Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simplify Boolean Return</em>'.
	 * @see a2l.tests.atlmr.anomalies.SimplifyBooleanReturn
	 * @generated
	 */
	EClass getSimplifyBooleanReturn();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.FinalClass <em>Final Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Final Class</em>'.
	 * @see a2l.tests.atlmr.anomalies.FinalClass
	 * @generated
	 */
	EClass getFinalClass();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.InterfaceIsType <em>Interface Is Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interface Is Type</em>'.
	 * @see a2l.tests.atlmr.anomalies.InterfaceIsType
	 * @generated
	 */
	EClass getInterfaceIsType();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.VisibilityModifier <em>Visibility Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility Modifier</em>'.
	 * @see a2l.tests.atlmr.anomalies.VisibilityModifier
	 * @generated
	 */
	EClass getVisibilityModifier();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.LooseCoupling <em>Loose Coupling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loose Coupling</em>'.
	 * @see a2l.tests.atlmr.anomalies.LooseCoupling
	 * @generated
	 */
	EClass getLooseCoupling();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.SignatureDeclareThrowsException <em>Signature Declare Throws Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signature Declare Throws Exception</em>'.
	 * @see a2l.tests.atlmr.anomalies.SignatureDeclareThrowsException
	 * @generated
	 */
	EClass getSignatureDeclareThrowsException();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.DefaultLabelNotLastInSwitchStmt <em>Default Label Not Last In Switch Stmt</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Default Label Not Last In Switch Stmt</em>'.
	 * @see a2l.tests.atlmr.anomalies.DefaultLabelNotLastInSwitchStmt
	 * @generated
	 */
	EClass getDefaultLabelNotLastInSwitchStmt();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.EqualsNull <em>Equals Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equals Null</em>'.
	 * @see a2l.tests.atlmr.anomalies.EqualsNull
	 * @generated
	 */
	EClass getEqualsNull();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.CompareObjectsWithEquals <em>Compare Objects With Equals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compare Objects With Equals</em>'.
	 * @see a2l.tests.atlmr.anomalies.CompareObjectsWithEquals
	 * @generated
	 */
	EClass getCompareObjectsWithEquals();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.PositionLiteralsFirstInComparisons <em>Position Literals First In Comparisons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position Literals First In Comparisons</em>'.
	 * @see a2l.tests.atlmr.anomalies.PositionLiteralsFirstInComparisons
	 * @generated
	 */
	EClass getPositionLiteralsFirstInComparisons();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.UseEqualsToCompareStrings <em>Use Equals To Compare Strings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Equals To Compare Strings</em>'.
	 * @see a2l.tests.atlmr.anomalies.UseEqualsToCompareStrings
	 * @generated
	 */
	EClass getUseEqualsToCompareStrings();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.IntegerInstantiation <em>Integer Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Instantiation</em>'.
	 * @see a2l.tests.atlmr.anomalies.IntegerInstantiation
	 * @generated
	 */
	EClass getIntegerInstantiation();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.ByteInstantiation <em>Byte Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Byte Instantiation</em>'.
	 * @see a2l.tests.atlmr.anomalies.ByteInstantiation
	 * @generated
	 */
	EClass getByteInstantiation();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.LongInstantiation <em>Long Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Long Instantiation</em>'.
	 * @see a2l.tests.atlmr.anomalies.LongInstantiation
	 * @generated
	 */
	EClass getLongInstantiation();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.BooleanInstantiation <em>Boolean Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Instantiation</em>'.
	 * @see a2l.tests.atlmr.anomalies.BooleanInstantiation
	 * @generated
	 */
	EClass getBooleanInstantiation();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.ShortInstantiation <em>Short Instantiation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Short Instantiation</em>'.
	 * @see a2l.tests.atlmr.anomalies.ShortInstantiation
	 * @generated
	 */
	EClass getShortInstantiation();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.SimplifyStartsWith <em>Simplify Starts With</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simplify Starts With</em>'.
	 * @see a2l.tests.atlmr.anomalies.SimplifyStartsWith
	 * @generated
	 */
	EClass getSimplifyStartsWith();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.UnnecessaryReturn <em>Unnecessary Return</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unnecessary Return</em>'.
	 * @see a2l.tests.atlmr.anomalies.UnnecessaryReturn
	 * @generated
	 */
	EClass getUnnecessaryReturn();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.UnconditionalIfStatement <em>Unconditional If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unconditional If Statement</em>'.
	 * @see a2l.tests.atlmr.anomalies.UnconditionalIfStatement
	 * @generated
	 */
	EClass getUnconditionalIfStatement();

	/**
	 * Returns the meta object for class '{@link a2l.tests.atlmr.anomalies.UnnecessaryFinalModifier <em>Unnecessary Final Modifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unnecessary Final Modifier</em>'.
	 * @see a2l.tests.atlmr.anomalies.UnnecessaryFinalModifier
	 * @generated
	 */
	EClass getUnnecessaryFinalModifier();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnomaliesFactory getAnomaliesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AnomalyImpl <em>Anomaly</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AnomalyImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAnomaly()
		 * @generated
		 */
		EClass ANOMALY = eINSTANCE.getAnomaly();

		/**
		 * The meta object literal for the '<em><b>Trace</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANOMALY__TRACE = eINSTANCE.getAnomaly_Trace();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANOMALY__DESCRIPTION = eINSTANCE.getAnomaly_Description();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidStartImportImpl <em>Avoid Start Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AvoidStartImportImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidStartImport()
		 * @generated
		 */
		EClass AVOID_START_IMPORT = eINSTANCE.getAvoidStartImport();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.ConstantNameImpl <em>Constant Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.ConstantNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getConstantName()
		 * @generated
		 */
		EClass CONSTANT_NAME = eINSTANCE.getConstantName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AbbreviationAsWordInNameImpl <em>Abbreviation As Word In Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AbbreviationAsWordInNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAbbreviationAsWordInName()
		 * @generated
		 */
		EClass ABBREVIATION_AS_WORD_IN_NAME = eINSTANCE.getAbbreviationAsWordInName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AbstractClassNameImpl <em>Abstract Class Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AbstractClassNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAbstractClassName()
		 * @generated
		 */
		EClass ABSTRACT_CLASS_NAME = eINSTANCE.getAbstractClassName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidEscapedUnicodeCharactersImpl <em>Avoid Escaped Unicode Characters</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AvoidEscapedUnicodeCharactersImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidEscapedUnicodeCharacters()
		 * @generated
		 */
		EClass AVOID_ESCAPED_UNICODE_CHARACTERS = eINSTANCE.getAvoidEscapedUnicodeCharacters();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.LocalFinalVariableNameImpl <em>Local Final Variable Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.LocalFinalVariableNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLocalFinalVariableName()
		 * @generated
		 */
		EClass LOCAL_FINAL_VARIABLE_NAME = eINSTANCE.getLocalFinalVariableName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.LocalVariableNameImpl <em>Local Variable Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.LocalVariableNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLocalVariableName()
		 * @generated
		 */
		EClass LOCAL_VARIABLE_NAME = eINSTANCE.getLocalVariableName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.MemberNameImpl <em>Member Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.MemberNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMemberName()
		 * @generated
		 */
		EClass MEMBER_NAME = eINSTANCE.getMemberName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.MethodNameImpl <em>Method Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.MethodNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMethodName()
		 * @generated
		 */
		EClass METHOD_NAME = eINSTANCE.getMethodName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.PackageNameImpl <em>Package Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.PackageNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getPackageName()
		 * @generated
		 */
		EClass PACKAGE_NAME = eINSTANCE.getPackageName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.ParameterNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getParameterName()
		 * @generated
		 */
		EClass PARAMETER_NAME = eINSTANCE.getParameterName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.StaticVariableNameImpl <em>Static Variable Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.StaticVariableNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getStaticVariableName()
		 * @generated
		 */
		EClass STATIC_VARIABLE_NAME = eINSTANCE.getStaticVariableName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.TypeNameImpl <em>Type Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.TypeNameImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getTypeName()
		 * @generated
		 */
		EClass TYPE_NAME = eINSTANCE.getTypeName();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.UnusedImportsImpl <em>Unused Imports</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.UnusedImportsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnusedImports()
		 * @generated
		 */
		EClass UNUSED_IMPORTS = eINSTANCE.getUnusedImports();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantImportImpl <em>Redundant Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.RedundantImportImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantImport()
		 * @generated
		 */
		EClass REDUNDANT_IMPORT = eINSTANCE.getRedundantImport();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.ParameterNumberImpl <em>Parameter Number</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.ParameterNumberImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getParameterNumber()
		 * @generated
		 */
		EClass PARAMETER_NUMBER = eINSTANCE.getParameterNumber();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantModifierImpl <em>Redundant Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.RedundantModifierImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantModifier()
		 * @generated
		 */
		EClass REDUNDANT_MODIFIER = eINSTANCE.getRedundantModifier();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.AvoidInlineConditionalsImpl <em>Avoid Inline Conditionals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.AvoidInlineConditionalsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getAvoidInlineConditionals()
		 * @generated
		 */
		EClass AVOID_INLINE_CONDITIONALS = eINSTANCE.getAvoidInlineConditionals();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.EqualsHashCodeImpl <em>Equals Hash Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.EqualsHashCodeImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getEqualsHashCode()
		 * @generated
		 */
		EClass EQUALS_HASH_CODE = eINSTANCE.getEqualsHashCode();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.HiddenFieldImpl <em>Hidden Field</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.HiddenFieldImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getHiddenField()
		 * @generated
		 */
		EClass HIDDEN_FIELD = eINSTANCE.getHiddenField();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.MissingSwitchDefaultImpl <em>Missing Switch Default</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.MissingSwitchDefaultImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getMissingSwitchDefault()
		 * @generated
		 */
		EClass MISSING_SWITCH_DEFAULT = eINSTANCE.getMissingSwitchDefault();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.RedundantThrowsImpl <em>Redundant Throws</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.RedundantThrowsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getRedundantThrows()
		 * @generated
		 */
		EClass REDUNDANT_THROWS = eINSTANCE.getRedundantThrows();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyBooleanExpressionImpl <em>Simplify Boolean Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.SimplifyBooleanExpressionImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyBooleanExpression()
		 * @generated
		 */
		EClass SIMPLIFY_BOOLEAN_EXPRESSION = eINSTANCE.getSimplifyBooleanExpression();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyBooleanReturnImpl <em>Simplify Boolean Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.SimplifyBooleanReturnImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyBooleanReturn()
		 * @generated
		 */
		EClass SIMPLIFY_BOOLEAN_RETURN = eINSTANCE.getSimplifyBooleanReturn();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.FinalClassImpl <em>Final Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.FinalClassImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getFinalClass()
		 * @generated
		 */
		EClass FINAL_CLASS = eINSTANCE.getFinalClass();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.InterfaceIsTypeImpl <em>Interface Is Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.InterfaceIsTypeImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getInterfaceIsType()
		 * @generated
		 */
		EClass INTERFACE_IS_TYPE = eINSTANCE.getInterfaceIsType();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.VisibilityModifierImpl <em>Visibility Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.VisibilityModifierImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getVisibilityModifier()
		 * @generated
		 */
		EClass VISIBILITY_MODIFIER = eINSTANCE.getVisibilityModifier();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.LooseCouplingImpl <em>Loose Coupling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.LooseCouplingImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLooseCoupling()
		 * @generated
		 */
		EClass LOOSE_COUPLING = eINSTANCE.getLooseCoupling();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.SignatureDeclareThrowsExceptionImpl <em>Signature Declare Throws Exception</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.SignatureDeclareThrowsExceptionImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSignatureDeclareThrowsException()
		 * @generated
		 */
		EClass SIGNATURE_DECLARE_THROWS_EXCEPTION = eINSTANCE.getSignatureDeclareThrowsException();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.DefaultLabelNotLastInSwitchStmtImpl <em>Default Label Not Last In Switch Stmt</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.DefaultLabelNotLastInSwitchStmtImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getDefaultLabelNotLastInSwitchStmt()
		 * @generated
		 */
		EClass DEFAULT_LABEL_NOT_LAST_IN_SWITCH_STMT = eINSTANCE.getDefaultLabelNotLastInSwitchStmt();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.EqualsNullImpl <em>Equals Null</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.EqualsNullImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getEqualsNull()
		 * @generated
		 */
		EClass EQUALS_NULL = eINSTANCE.getEqualsNull();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.CompareObjectsWithEqualsImpl <em>Compare Objects With Equals</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.CompareObjectsWithEqualsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getCompareObjectsWithEquals()
		 * @generated
		 */
		EClass COMPARE_OBJECTS_WITH_EQUALS = eINSTANCE.getCompareObjectsWithEquals();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.PositionLiteralsFirstInComparisonsImpl <em>Position Literals First In Comparisons</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.PositionLiteralsFirstInComparisonsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getPositionLiteralsFirstInComparisons()
		 * @generated
		 */
		EClass POSITION_LITERALS_FIRST_IN_COMPARISONS = eINSTANCE.getPositionLiteralsFirstInComparisons();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.UseEqualsToCompareStringsImpl <em>Use Equals To Compare Strings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.UseEqualsToCompareStringsImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUseEqualsToCompareStrings()
		 * @generated
		 */
		EClass USE_EQUALS_TO_COMPARE_STRINGS = eINSTANCE.getUseEqualsToCompareStrings();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.IntegerInstantiationImpl <em>Integer Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.IntegerInstantiationImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getIntegerInstantiation()
		 * @generated
		 */
		EClass INTEGER_INSTANTIATION = eINSTANCE.getIntegerInstantiation();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.ByteInstantiationImpl <em>Byte Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.ByteInstantiationImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getByteInstantiation()
		 * @generated
		 */
		EClass BYTE_INSTANTIATION = eINSTANCE.getByteInstantiation();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.LongInstantiationImpl <em>Long Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.LongInstantiationImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getLongInstantiation()
		 * @generated
		 */
		EClass LONG_INSTANTIATION = eINSTANCE.getLongInstantiation();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.BooleanInstantiationImpl <em>Boolean Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.BooleanInstantiationImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getBooleanInstantiation()
		 * @generated
		 */
		EClass BOOLEAN_INSTANTIATION = eINSTANCE.getBooleanInstantiation();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.ShortInstantiationImpl <em>Short Instantiation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.ShortInstantiationImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getShortInstantiation()
		 * @generated
		 */
		EClass SHORT_INSTANTIATION = eINSTANCE.getShortInstantiation();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.SimplifyStartsWithImpl <em>Simplify Starts With</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.SimplifyStartsWithImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getSimplifyStartsWith()
		 * @generated
		 */
		EClass SIMPLIFY_STARTS_WITH = eINSTANCE.getSimplifyStartsWith();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.UnnecessaryReturnImpl <em>Unnecessary Return</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.UnnecessaryReturnImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnnecessaryReturn()
		 * @generated
		 */
		EClass UNNECESSARY_RETURN = eINSTANCE.getUnnecessaryReturn();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.UnconditionalIfStatementImpl <em>Unconditional If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.UnconditionalIfStatementImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnconditionalIfStatement()
		 * @generated
		 */
		EClass UNCONDITIONAL_IF_STATEMENT = eINSTANCE.getUnconditionalIfStatement();

		/**
		 * The meta object literal for the '{@link a2l.tests.atlmr.anomalies.impl.UnnecessaryFinalModifierImpl <em>Unnecessary Final Modifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.tests.atlmr.anomalies.impl.UnnecessaryFinalModifierImpl
		 * @see a2l.tests.atlmr.anomalies.impl.AnomaliesPackageImpl#getUnnecessaryFinalModifier()
		 * @generated
		 */
		EClass UNNECESSARY_FINAL_MODIFIER = eINSTANCE.getUnnecessaryFinalModifier();

	}

} //AnomaliesPackage
