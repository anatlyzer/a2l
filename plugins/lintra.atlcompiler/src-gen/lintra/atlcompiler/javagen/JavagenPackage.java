/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see lintra.atlcompiler.javagen.JavagenFactory
 * @model kind="package"
 * @generated
 */
public interface JavagenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "javagen";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://lintra/javagen";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "lintra_javagen";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavagenPackage eINSTANCE = lintra.atlcompiler.javagen.impl.JavagenPackageImpl.init();

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JavaGenModelImpl <em>Java Gen Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JavaGenModelImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJavaGenModel()
	 * @generated
	 */
	int JAVA_GEN_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Lib Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_MODEL__LIB_TYPES = 0;

	/**
	 * The feature id for the '<em><b>Meta Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_MODEL__META_TYPES = 1;

	/**
	 * The feature id for the '<em><b>Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_MODEL__CLASSES = 2;

	/**
	 * The number of structural features of the '<em>Java Gen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_MODEL_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Java Gen Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_GEN_MODEL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JTypeImpl <em>JType</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JTypeImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJType()
	 * @generated
	 */
	int JTYPE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE__NAME = 0;

	/**
	 * The number of structural features of the '<em>JType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JType</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JLibTypeImpl <em>JLib Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JLibTypeImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJLibType()
	 * @generated
	 */
	int JLIB_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLIB_TYPE__NAME = JTYPE__NAME;

	/**
	 * The feature id for the '<em><b>Pkg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLIB_TYPE__PKG = JTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JLib Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLIB_TYPE_FEATURE_COUNT = JTYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JLib Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLIB_TYPE_OPERATION_COUNT = JTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JMetaTypeImpl <em>JMeta Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JMetaTypeImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJMetaType()
	 * @generated
	 */
	int JMETA_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETA_TYPE__NAME = JTYPE__NAME;

	/**
	 * The feature id for the '<em><b>Qualified Java Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETA_TYPE__QUALIFIED_JAVA_NAME = JTYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JMeta Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETA_TYPE_FEATURE_COUNT = JTYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JMeta Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETA_TYPE_OPERATION_COUNT = JTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JTypeRefImpl <em>JType Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JTypeRefImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJTypeRef()
	 * @generated
	 */
	int JTYPE_REF = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE_REF__TYPE = 0;

	/**
	 * The number of structural features of the '<em>JType Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE_REF_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>JType Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTYPE_REF_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JParamTypeRefImpl <em>JParam Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JParamTypeRefImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParamTypeRef()
	 * @generated
	 */
	int JPARAM_TYPE_REF = 5;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_TYPE_REF__TYPE = JTYPE_REF__TYPE;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_TYPE_REF__CONTAINED_TYPE = JTYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JParam Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_TYPE_REF_FEATURE_COUNT = JTYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JParam Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_TYPE_REF_OPERATION_COUNT = JTYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JParamNTypeRefImpl <em>JParam NType Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JParamNTypeRefImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParamNTypeRef()
	 * @generated
	 */
	int JPARAM_NTYPE_REF = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_NTYPE_REF__TYPE = JTYPE_REF__TYPE;

	/**
	 * The feature id for the '<em><b>Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_NTYPE_REF__PARAMS = JTYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JParam NType Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_NTYPE_REF_FEATURE_COUNT = JTYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JParam NType Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAM_NTYPE_REF_OPERATION_COUNT = JTYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JGenericTypeRefImpl <em>JGeneric Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JGenericTypeRefImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJGenericTypeRef()
	 * @generated
	 */
	int JGENERIC_TYPE_REF = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JGENERIC_TYPE_REF__TYPE = JTYPE_REF__TYPE;

	/**
	 * The feature id for the '<em><b>Type Params</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JGENERIC_TYPE_REF__TYPE_PARAMS = JTYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JGeneric Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JGENERIC_TYPE_REF_FEATURE_COUNT = JTYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JGeneric Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JGENERIC_TYPE_REF_OPERATION_COUNT = JTYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JArrayTypeRefImpl <em>JArray Type Ref</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JArrayTypeRefImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJArrayTypeRef()
	 * @generated
	 */
	int JARRAY_TYPE_REF = 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_TYPE_REF__TYPE = JTYPE_REF__TYPE;

	/**
	 * The feature id for the '<em><b>Contained Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_TYPE_REF__CONTAINED_TYPE = JTYPE_REF_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JArray Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_TYPE_REF_FEATURE_COUNT = JTYPE_REF_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JArray Type Ref</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JARRAY_TYPE_REF_OPERATION_COUNT = JTYPE_REF_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JClassImpl <em>JClass</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JClassImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJClass()
	 * @generated
	 */
	int JCLASS = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__NAME = JTYPE__NAME;

	/**
	 * The feature id for the '<em><b>Extra</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__EXTRA = JTYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pkg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__PKG = JTYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__METHODS = JTYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__ATTRIBUTES = JTYPE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__IMPLEMENTS = JTYPE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Extends </b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__EXTENDS_ = JTYPE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__IMPORTS = JTYPE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>This </b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS__THIS_ = JTYPE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>JClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS_FEATURE_COUNT = JTYPE_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>JClass</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLASS_OPERATION_COUNT = JTYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JBlockImpl <em>JBlock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JBlockImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJBlock()
	 * @generated
	 */
	int JBLOCK = 13;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JMethodImpl <em>JMethod</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JMethodImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJMethod()
	 * @generated
	 */
	int JMETHOD = 14;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JStatementImpl <em>JStatement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JStatementImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJStatement()
	 * @generated
	 */
	int JSTATEMENT = 15;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JCommentImpl <em>JComment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JCommentImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJComment()
	 * @generated
	 */
	int JCOMMENT = 12;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JLoopImpl <em>JLoop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JLoopImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJLoop()
	 * @generated
	 */
	int JLOOP = 17;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JForeachImpl <em>JForeach</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JForeachImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJForeach()
	 * @generated
	 */
	int JFOREACH = 18;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.IteratorLoopImpl <em>Iterator Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.IteratorLoopImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getIteratorLoop()
	 * @generated
	 */
	int ITERATOR_LOOP = 19;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JConditionalImpl <em>JConditional</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JConditionalImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJConditional()
	 * @generated
	 */
	int JCONDITIONAL = 20;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JConditionalBlockImpl <em>JConditional Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JConditionalBlockImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJConditionalBlock()
	 * @generated
	 */
	int JCONDITIONAL_BLOCK = 21;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JTextImpl <em>JText</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JTextImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJText()
	 * @generated
	 */
	int JTEXT = 23;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JAssignmentImpl <em>JAssignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JAssignmentImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJAssignment()
	 * @generated
	 */
	int JASSIGNMENT = 22;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JExpressionImpl <em>JExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JExpressionImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJExpression()
	 * @generated
	 */
	int JEXPRESSION = 24;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JVarExpImpl <em>JVar Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JVarExpImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJVarExp()
	 * @generated
	 */
	int JVAR_EXP = 25;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JTextExpImpl <em>JText Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JTextExpImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJTextExp()
	 * @generated
	 */
	int JTEXT_EXP = 26;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JVariableDeclarationImpl <em>JVariable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JVariableDeclarationImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJVariableDeclaration()
	 * @generated
	 */
	int JVARIABLE_DECLARATION = 27;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVARIABLE_DECLARATION__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVARIABLE_DECLARATION__NAME = 1;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVARIABLE_DECLARATION__IS_FINAL = 2;

	/**
	 * The number of structural features of the '<em>JVariable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVARIABLE_DECLARATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>JVariable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVARIABLE_DECLARATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JThisImpl <em>JThis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JThisImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJThis()
	 * @generated
	 */
	int JTHIS = 10;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTHIS__TYPE = JVARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTHIS__NAME = JVARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTHIS__IS_FINAL = JVARIABLE_DECLARATION__IS_FINAL;

	/**
	 * The number of structural features of the '<em>JThis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTHIS_FEATURE_COUNT = JVARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JThis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTHIS_OPERATION_COUNT = JVARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JAttributeImpl <em>JAttribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JAttributeImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJAttribute()
	 * @generated
	 */
	int JATTRIBUTE = 11;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JATTRIBUTE__TYPE = JVARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JATTRIBUTE__NAME = JVARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JATTRIBUTE__IS_FINAL = JVARIABLE_DECLARATION__IS_FINAL;

	/**
	 * The number of structural features of the '<em>JAttribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JATTRIBUTE_FEATURE_COUNT = JVARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JAttribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JATTRIBUTE_OPERATION_COUNT = JVARIABLE_DECLARATION_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JStatement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTATEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>JStatement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JSTATEMENT_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCOMMENT__VALUE = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JComment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCOMMENT_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JComment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCOMMENT_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBLOCK__LOCAL_VARS = 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBLOCK__STATEMENTS = 1;

	/**
	 * The number of structural features of the '<em>JBlock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBLOCK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>JBlock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JBLOCK_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__LOCAL_VARS = JBLOCK__LOCAL_VARS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__STATEMENTS = JBLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__NAME = JBLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__PARAMETERS = JBLOCK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__RETURN_TYPE = JBLOCK_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Throws </b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__THROWS_ = JBLOCK_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD__VISIBILITY = JBLOCK_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>JMethod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD_FEATURE_COUNT = JBLOCK_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>JMethod</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JMETHOD_OPERATION_COUNT = JBLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JReturnImpl <em>JReturn</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JReturnImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJReturn()
	 * @generated
	 */
	int JRETURN = 16;

	/**
	 * The feature id for the '<em><b>Result</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRETURN__RESULT = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JReturn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRETURN_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JReturn</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JRETURN_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLOOP__LOCAL_VARS = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLOOP__STATEMENTS = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Loop Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLOOP__LOOP_VAR = JSTATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>JLoop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLOOP_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>JLoop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JLOOP_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH__LOCAL_VARS = JLOOP__LOCAL_VARS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH__STATEMENTS = JLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Loop Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH__LOOP_VAR = JLOOP__LOOP_VAR;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH__COLLECTION = JLOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JForeach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH_FEATURE_COUNT = JLOOP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JForeach</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JFOREACH_OPERATION_COUNT = JLOOP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP__LOCAL_VARS = JLOOP__LOCAL_VARS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP__STATEMENTS = JLOOP__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Loop Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP__LOOP_VAR = JLOOP__LOOP_VAR;

	/**
	 * The feature id for the '<em><b>Iterator Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP__ITERATOR_VAR = JLOOP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP__ITERATOR_INIT = JLOOP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iterator Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP_FEATURE_COUNT = JLOOP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Iterator Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_LOOP_OPERATION_COUNT = JLOOP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL__CONDITIONS = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL__ELSE = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JConditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JConditional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_BLOCK__LOCAL_VARS = JBLOCK__LOCAL_VARS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_BLOCK__STATEMENTS = JBLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_BLOCK__EXPR = JBLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JConditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_BLOCK_FEATURE_COUNT = JBLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JConditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCONDITIONAL_BLOCK_OPERATION_COUNT = JBLOCK_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT__BODY = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JText</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JText</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JASSIGNMENT__BODY = JTEXT__BODY;

	/**
	 * The feature id for the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JASSIGNMENT__DECLARATION = JTEXT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JASSIGNMENT__RIGHT_PART = JTEXT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JAssignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JASSIGNMENT_FEATURE_COUNT = JTEXT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JAssignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JASSIGNMENT_OPERATION_COUNT = JTEXT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>JExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEXPRESSION_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVAR_EXP__REFERENCE = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JVar Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVAR_EXP_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JVar Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JVAR_EXP_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT_EXP__BODY = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JText Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT_EXP_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JText Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JTEXT_EXP_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.LMatchObjectImpl <em>LMatch Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.LMatchObjectImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getLMatchObject()
	 * @generated
	 */
	int LMATCH_OBJECT = 28;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_OBJECT__CASES = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>LMatch Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_OBJECT_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>LMatch Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_OBJECT_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.LMatchCaseImpl <em>LMatch Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.LMatchCaseImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getLMatchCase()
	 * @generated
	 */
	int LMATCH_CASE = 29;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE__LOCAL_VARS = JBLOCK__LOCAL_VARS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE__STATEMENTS = JBLOCK__STATEMENTS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE__PREDICATE = JBLOCK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE__OBJ = JBLOCK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>LMatch Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE_FEATURE_COUNT = JBLOCK_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>LMatch Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LMATCH_CASE_OPERATION_COUNT = JBLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JParameterImpl <em>JParameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JParameterImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParameter()
	 * @generated
	 */
	int JPARAMETER = 30;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAMETER__TYPE = JVARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAMETER__NAME = JVARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAMETER__IS_FINAL = JVARIABLE_DECLARATION__IS_FINAL;

	/**
	 * The number of structural features of the '<em>JParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAMETER_FEATURE_COUNT = JVARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>JParameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JPARAMETER_OPERATION_COUNT = JVARIABLE_DECLARATION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JClosureImpl <em>JClosure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JClosureImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJClosure()
	 * @generated
	 */
	int JCLOSURE = 31;

	/**
	 * The feature id for the '<em><b>Local Vars</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLOSURE__LOCAL_VARS = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLOSURE__STATEMENTS = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLOSURE__PARAMETERS = JEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>JClosure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLOSURE_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>JClosure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JCLOSURE_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JInvokeImpl <em>JInvoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JInvokeImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJInvoke()
	 * @generated
	 */
	int JINVOKE = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE__NAME = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Obj</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE__OBJ = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE__ARGUMENTS = JEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>JInvoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>JInvoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JInvokeStaticImpl <em>JInvoke Static</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JInvokeStaticImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJInvokeStatic()
	 * @generated
	 */
	int JINVOKE_STATIC = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_STATIC__NAME = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_STATIC__ARGUMENTS = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JInvoke Static</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_STATIC_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JInvoke Static</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JINVOKE_STATIC_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JNewObjectImpl <em>JNew Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JNewObjectImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJNewObject()
	 * @generated
	 */
	int JNEW_OBJECT = 34;

	/**
	 * The feature id for the '<em><b>Type Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNEW_OBJECT__TYPE_REF = JEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNEW_OBJECT__ARGUMENTS = JEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>JNew Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNEW_OBJECT_FEATURE_COUNT = JEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>JNew Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JNEW_OBJECT_OPERATION_COUNT = JEXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.impl.JExprStatementImpl <em>JExpr Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.impl.JExprStatementImpl
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJExprStatement()
	 * @generated
	 */
	int JEXPR_STATEMENT = 35;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEXPR_STATEMENT__EXPR = JSTATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>JExpr Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEXPR_STATEMENT_FEATURE_COUNT = JSTATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>JExpr Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JEXPR_STATEMENT_OPERATION_COUNT = JSTATEMENT_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link lintra.atlcompiler.javagen.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see lintra.atlcompiler.javagen.Visibility
	 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 36;


	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JavaGenModel <em>Java Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Gen Model</em>'.
	 * @see lintra.atlcompiler.javagen.JavaGenModel
	 * @generated
	 */
	EClass getJavaGenModel();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JavaGenModel#getLibTypes <em>Lib Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Lib Types</em>'.
	 * @see lintra.atlcompiler.javagen.JavaGenModel#getLibTypes()
	 * @see #getJavaGenModel()
	 * @generated
	 */
	EReference getJavaGenModel_LibTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JavaGenModel#getMetaTypes <em>Meta Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Meta Types</em>'.
	 * @see lintra.atlcompiler.javagen.JavaGenModel#getMetaTypes()
	 * @see #getJavaGenModel()
	 * @generated
	 */
	EReference getJavaGenModel_MetaTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JavaGenModel#getClasses <em>Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Classes</em>'.
	 * @see lintra.atlcompiler.javagen.JavaGenModel#getClasses()
	 * @see #getJavaGenModel()
	 * @generated
	 */
	EReference getJavaGenModel_Classes();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JType <em>JType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JType</em>'.
	 * @see lintra.atlcompiler.javagen.JType
	 * @generated
	 */
	EClass getJType();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see lintra.atlcompiler.javagen.JType#getName()
	 * @see #getJType()
	 * @generated
	 */
	EAttribute getJType_Name();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JLibType <em>JLib Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JLib Type</em>'.
	 * @see lintra.atlcompiler.javagen.JLibType
	 * @generated
	 */
	EClass getJLibType();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JLibType#getPkg <em>Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pkg</em>'.
	 * @see lintra.atlcompiler.javagen.JLibType#getPkg()
	 * @see #getJLibType()
	 * @generated
	 */
	EAttribute getJLibType_Pkg();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JMetaType <em>JMeta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMeta Type</em>'.
	 * @see lintra.atlcompiler.javagen.JMetaType
	 * @generated
	 */
	EClass getJMetaType();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JMetaType#getQualifiedJavaName <em>Qualified Java Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualified Java Name</em>'.
	 * @see lintra.atlcompiler.javagen.JMetaType#getQualifiedJavaName()
	 * @see #getJMetaType()
	 * @generated
	 */
	EAttribute getJMetaType_QualifiedJavaName();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JTypeRef <em>JType Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JType Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JTypeRef
	 * @generated
	 */
	EClass getJTypeRef();

	/**
	 * Returns the meta object for the reference '{@link lintra.atlcompiler.javagen.JTypeRef#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see lintra.atlcompiler.javagen.JTypeRef#getType()
	 * @see #getJTypeRef()
	 * @generated
	 */
	EReference getJTypeRef_Type();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JParamTypeRef <em>JParam Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JParam Type Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JParamTypeRef
	 * @generated
	 */
	EClass getJParamTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JParamTypeRef#getContainedType <em>Contained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Type</em>'.
	 * @see lintra.atlcompiler.javagen.JParamTypeRef#getContainedType()
	 * @see #getJParamTypeRef()
	 * @generated
	 */
	EReference getJParamTypeRef_ContainedType();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JParamNTypeRef <em>JParam NType Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JParam NType Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JParamNTypeRef
	 * @generated
	 */
	EClass getJParamNTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JParamNTypeRef#getParams <em>Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Params</em>'.
	 * @see lintra.atlcompiler.javagen.JParamNTypeRef#getParams()
	 * @see #getJParamNTypeRef()
	 * @generated
	 */
	EReference getJParamNTypeRef_Params();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JGenericTypeRef <em>JGeneric Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JGeneric Type Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JGenericTypeRef
	 * @generated
	 */
	EClass getJGenericTypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JGenericTypeRef#getTypeParams <em>Type Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Type Params</em>'.
	 * @see lintra.atlcompiler.javagen.JGenericTypeRef#getTypeParams()
	 * @see #getJGenericTypeRef()
	 * @generated
	 */
	EReference getJGenericTypeRef_TypeParams();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JArrayTypeRef <em>JArray Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JArray Type Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JArrayTypeRef
	 * @generated
	 */
	EClass getJArrayTypeRef();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JArrayTypeRef#getContainedType <em>Contained Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Contained Type</em>'.
	 * @see lintra.atlcompiler.javagen.JArrayTypeRef#getContainedType()
	 * @see #getJArrayTypeRef()
	 * @generated
	 */
	EReference getJArrayTypeRef_ContainedType();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JClass <em>JClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JClass</em>'.
	 * @see lintra.atlcompiler.javagen.JClass
	 * @generated
	 */
	EClass getJClass();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JClass#getExtra <em>Extra</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extra</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getExtra()
	 * @see #getJClass()
	 * @generated
	 */
	EAttribute getJClass_Extra();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JClass#getPkg <em>Pkg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pkg</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getPkg()
	 * @see #getJClass()
	 * @generated
	 */
	EAttribute getJClass_Pkg();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JClass#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getMethods()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getAttributes()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JClass#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Implements</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getImplements()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_Implements();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JClass#getExtends_ <em>Extends </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Extends </em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getExtends_()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_Extends_();

	/**
	 * Returns the meta object for the reference list '{@link lintra.atlcompiler.javagen.JClass#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getImports()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_Imports();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JClass#getThis_ <em>This </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>This </em>'.
	 * @see lintra.atlcompiler.javagen.JClass#getThis_()
	 * @see #getJClass()
	 * @generated
	 */
	EReference getJClass_This_();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JThis <em>JThis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JThis</em>'.
	 * @see lintra.atlcompiler.javagen.JThis
	 * @generated
	 */
	EClass getJThis();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JAttribute <em>JAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JAttribute</em>'.
	 * @see lintra.atlcompiler.javagen.JAttribute
	 * @generated
	 */
	EClass getJAttribute();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JComment <em>JComment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JComment</em>'.
	 * @see lintra.atlcompiler.javagen.JComment
	 * @generated
	 */
	EClass getJComment();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JComment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see lintra.atlcompiler.javagen.JComment#getValue()
	 * @see #getJComment()
	 * @generated
	 */
	EAttribute getJComment_Value();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JBlock <em>JBlock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JBlock</em>'.
	 * @see lintra.atlcompiler.javagen.JBlock
	 * @generated
	 */
	EClass getJBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JBlock#getLocalVars <em>Local Vars</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Vars</em>'.
	 * @see lintra.atlcompiler.javagen.JBlock#getLocalVars()
	 * @see #getJBlock()
	 * @generated
	 */
	EReference getJBlock_LocalVars();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JBlock#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see lintra.atlcompiler.javagen.JBlock#getStatements()
	 * @see #getJBlock()
	 * @generated
	 */
	EReference getJBlock_Statements();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JMethod <em>JMethod</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JMethod</em>'.
	 * @see lintra.atlcompiler.javagen.JMethod
	 * @generated
	 */
	EClass getJMethod();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JMethod#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see lintra.atlcompiler.javagen.JMethod#getName()
	 * @see #getJMethod()
	 * @generated
	 */
	EAttribute getJMethod_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JMethod#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see lintra.atlcompiler.javagen.JMethod#getParameters()
	 * @see #getJMethod()
	 * @generated
	 */
	EReference getJMethod_Parameters();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JMethod#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Return Type</em>'.
	 * @see lintra.atlcompiler.javagen.JMethod#getReturnType()
	 * @see #getJMethod()
	 * @generated
	 */
	EReference getJMethod_ReturnType();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JMethod#getThrows_ <em>Throws </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Throws </em>'.
	 * @see lintra.atlcompiler.javagen.JMethod#getThrows_()
	 * @see #getJMethod()
	 * @generated
	 */
	EReference getJMethod_Throws_();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JMethod#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see lintra.atlcompiler.javagen.JMethod#getVisibility()
	 * @see #getJMethod()
	 * @generated
	 */
	EAttribute getJMethod_Visibility();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JStatement <em>JStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JStatement</em>'.
	 * @see lintra.atlcompiler.javagen.JStatement
	 * @generated
	 */
	EClass getJStatement();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JReturn <em>JReturn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JReturn</em>'.
	 * @see lintra.atlcompiler.javagen.JReturn
	 * @generated
	 */
	EClass getJReturn();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JReturn#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result</em>'.
	 * @see lintra.atlcompiler.javagen.JReturn#getResult()
	 * @see #getJReturn()
	 * @generated
	 */
	EReference getJReturn_Result();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JLoop <em>JLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JLoop</em>'.
	 * @see lintra.atlcompiler.javagen.JLoop
	 * @generated
	 */
	EClass getJLoop();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JLoop#getLoopVar <em>Loop Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Var</em>'.
	 * @see lintra.atlcompiler.javagen.JLoop#getLoopVar()
	 * @see #getJLoop()
	 * @generated
	 */
	EReference getJLoop_LoopVar();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JForeach <em>JForeach</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JForeach</em>'.
	 * @see lintra.atlcompiler.javagen.JForeach
	 * @generated
	 */
	EClass getJForeach();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JForeach#getCollection <em>Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection</em>'.
	 * @see lintra.atlcompiler.javagen.JForeach#getCollection()
	 * @see #getJForeach()
	 * @generated
	 */
	EReference getJForeach_Collection();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.IteratorLoop <em>Iterator Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Loop</em>'.
	 * @see lintra.atlcompiler.javagen.IteratorLoop
	 * @generated
	 */
	EClass getIteratorLoop();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorVar <em>Iterator Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator Var</em>'.
	 * @see lintra.atlcompiler.javagen.IteratorLoop#getIteratorVar()
	 * @see #getIteratorLoop()
	 * @generated
	 */
	EReference getIteratorLoop_IteratorVar();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.IteratorLoop#getIteratorInit <em>Iterator Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator Init</em>'.
	 * @see lintra.atlcompiler.javagen.IteratorLoop#getIteratorInit()
	 * @see #getIteratorLoop()
	 * @generated
	 */
	EReference getIteratorLoop_IteratorInit();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JConditional <em>JConditional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JConditional</em>'.
	 * @see lintra.atlcompiler.javagen.JConditional
	 * @generated
	 */
	EClass getJConditional();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JConditional#getConditions <em>Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Conditions</em>'.
	 * @see lintra.atlcompiler.javagen.JConditional#getConditions()
	 * @see #getJConditional()
	 * @generated
	 */
	EReference getJConditional_Conditions();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JConditional#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see lintra.atlcompiler.javagen.JConditional#getElse()
	 * @see #getJConditional()
	 * @generated
	 */
	EReference getJConditional_Else();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JConditionalBlock <em>JConditional Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JConditional Block</em>'.
	 * @see lintra.atlcompiler.javagen.JConditionalBlock
	 * @generated
	 */
	EClass getJConditionalBlock();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JConditionalBlock#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see lintra.atlcompiler.javagen.JConditionalBlock#getExpr()
	 * @see #getJConditionalBlock()
	 * @generated
	 */
	EReference getJConditionalBlock_Expr();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JAssignment <em>JAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JAssignment</em>'.
	 * @see lintra.atlcompiler.javagen.JAssignment
	 * @generated
	 */
	EClass getJAssignment();

	/**
	 * Returns the meta object for the reference '{@link lintra.atlcompiler.javagen.JAssignment#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Declaration</em>'.
	 * @see lintra.atlcompiler.javagen.JAssignment#getDeclaration()
	 * @see #getJAssignment()
	 * @generated
	 */
	EReference getJAssignment_Declaration();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JAssignment#getRightPart <em>Right Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Part</em>'.
	 * @see lintra.atlcompiler.javagen.JAssignment#getRightPart()
	 * @see #getJAssignment()
	 * @generated
	 */
	EReference getJAssignment_RightPart();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JText <em>JText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JText</em>'.
	 * @see lintra.atlcompiler.javagen.JText
	 * @generated
	 */
	EClass getJText();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JText#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see lintra.atlcompiler.javagen.JText#getBody()
	 * @see #getJText()
	 * @generated
	 */
	EAttribute getJText_Body();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JExpression <em>JExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JExpression</em>'.
	 * @see lintra.atlcompiler.javagen.JExpression
	 * @generated
	 */
	EClass getJExpression();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JVarExp <em>JVar Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JVar Exp</em>'.
	 * @see lintra.atlcompiler.javagen.JVarExp
	 * @generated
	 */
	EClass getJVarExp();

	/**
	 * Returns the meta object for the reference '{@link lintra.atlcompiler.javagen.JVarExp#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see lintra.atlcompiler.javagen.JVarExp#getReference()
	 * @see #getJVarExp()
	 * @generated
	 */
	EReference getJVarExp_Reference();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JTextExp <em>JText Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JText Exp</em>'.
	 * @see lintra.atlcompiler.javagen.JTextExp
	 * @generated
	 */
	EClass getJTextExp();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JTextExp#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Body</em>'.
	 * @see lintra.atlcompiler.javagen.JTextExp#getBody()
	 * @see #getJTextExp()
	 * @generated
	 */
	EAttribute getJTextExp_Body();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JVariableDeclaration <em>JVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JVariable Declaration</em>'.
	 * @see lintra.atlcompiler.javagen.JVariableDeclaration
	 * @generated
	 */
	EClass getJVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JVariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see lintra.atlcompiler.javagen.JVariableDeclaration#getType()
	 * @see #getJVariableDeclaration()
	 * @generated
	 */
	EReference getJVariableDeclaration_Type();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see lintra.atlcompiler.javagen.JVariableDeclaration#getName()
	 * @see #getJVariableDeclaration()
	 * @generated
	 */
	EAttribute getJVariableDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JVariableDeclaration#isIsFinal <em>Is Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Final</em>'.
	 * @see lintra.atlcompiler.javagen.JVariableDeclaration#isIsFinal()
	 * @see #getJVariableDeclaration()
	 * @generated
	 */
	EAttribute getJVariableDeclaration_IsFinal();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.LMatchObject <em>LMatch Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LMatch Object</em>'.
	 * @see lintra.atlcompiler.javagen.LMatchObject
	 * @generated
	 */
	EClass getLMatchObject();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.LMatchObject#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see lintra.atlcompiler.javagen.LMatchObject#getCases()
	 * @see #getLMatchObject()
	 * @generated
	 */
	EReference getLMatchObject_Cases();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.LMatchCase <em>LMatch Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>LMatch Case</em>'.
	 * @see lintra.atlcompiler.javagen.LMatchCase
	 * @generated
	 */
	EClass getLMatchCase();

	/**
	 * Returns the meta object for the reference '{@link lintra.atlcompiler.javagen.LMatchCase#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Predicate</em>'.
	 * @see lintra.atlcompiler.javagen.LMatchCase#getPredicate()
	 * @see #getLMatchCase()
	 * @generated
	 */
	EReference getLMatchCase_Predicate();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.LMatchCase#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Obj</em>'.
	 * @see lintra.atlcompiler.javagen.LMatchCase#getObj()
	 * @see #getLMatchCase()
	 * @generated
	 */
	EReference getLMatchCase_Obj();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JParameter <em>JParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JParameter</em>'.
	 * @see lintra.atlcompiler.javagen.JParameter
	 * @generated
	 */
	EClass getJParameter();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JClosure <em>JClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JClosure</em>'.
	 * @see lintra.atlcompiler.javagen.JClosure
	 * @generated
	 */
	EClass getJClosure();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JClosure#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see lintra.atlcompiler.javagen.JClosure#getParameters()
	 * @see #getJClosure()
	 * @generated
	 */
	EReference getJClosure_Parameters();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JInvoke <em>JInvoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JInvoke</em>'.
	 * @see lintra.atlcompiler.javagen.JInvoke
	 * @generated
	 */
	EClass getJInvoke();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JInvoke#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see lintra.atlcompiler.javagen.JInvoke#getName()
	 * @see #getJInvoke()
	 * @generated
	 */
	EAttribute getJInvoke_Name();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JInvoke#getObj <em>Obj</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Obj</em>'.
	 * @see lintra.atlcompiler.javagen.JInvoke#getObj()
	 * @see #getJInvoke()
	 * @generated
	 */
	EReference getJInvoke_Obj();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JInvoke#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see lintra.atlcompiler.javagen.JInvoke#getArguments()
	 * @see #getJInvoke()
	 * @generated
	 */
	EReference getJInvoke_Arguments();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JInvokeStatic <em>JInvoke Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JInvoke Static</em>'.
	 * @see lintra.atlcompiler.javagen.JInvokeStatic
	 * @generated
	 */
	EClass getJInvokeStatic();

	/**
	 * Returns the meta object for the attribute '{@link lintra.atlcompiler.javagen.JInvokeStatic#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see lintra.atlcompiler.javagen.JInvokeStatic#getName()
	 * @see #getJInvokeStatic()
	 * @generated
	 */
	EAttribute getJInvokeStatic_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JInvokeStatic#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see lintra.atlcompiler.javagen.JInvokeStatic#getArguments()
	 * @see #getJInvokeStatic()
	 * @generated
	 */
	EReference getJInvokeStatic_Arguments();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JNewObject <em>JNew Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JNew Object</em>'.
	 * @see lintra.atlcompiler.javagen.JNewObject
	 * @generated
	 */
	EClass getJNewObject();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JNewObject#getTypeRef <em>Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type Ref</em>'.
	 * @see lintra.atlcompiler.javagen.JNewObject#getTypeRef()
	 * @see #getJNewObject()
	 * @generated
	 */
	EReference getJNewObject_TypeRef();

	/**
	 * Returns the meta object for the containment reference list '{@link lintra.atlcompiler.javagen.JNewObject#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see lintra.atlcompiler.javagen.JNewObject#getArguments()
	 * @see #getJNewObject()
	 * @generated
	 */
	EReference getJNewObject_Arguments();

	/**
	 * Returns the meta object for class '{@link lintra.atlcompiler.javagen.JExprStatement <em>JExpr Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>JExpr Statement</em>'.
	 * @see lintra.atlcompiler.javagen.JExprStatement
	 * @generated
	 */
	EClass getJExprStatement();

	/**
	 * Returns the meta object for the containment reference '{@link lintra.atlcompiler.javagen.JExprStatement#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see lintra.atlcompiler.javagen.JExprStatement#getExpr()
	 * @see #getJExprStatement()
	 * @generated
	 */
	EReference getJExprStatement_Expr();

	/**
	 * Returns the meta object for enum '{@link lintra.atlcompiler.javagen.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see lintra.atlcompiler.javagen.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	JavagenFactory getJavagenFactory();

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
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JavaGenModelImpl <em>Java Gen Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JavaGenModelImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJavaGenModel()
		 * @generated
		 */
		EClass JAVA_GEN_MODEL = eINSTANCE.getJavaGenModel();

		/**
		 * The meta object literal for the '<em><b>Lib Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_GEN_MODEL__LIB_TYPES = eINSTANCE.getJavaGenModel_LibTypes();

		/**
		 * The meta object literal for the '<em><b>Meta Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_GEN_MODEL__META_TYPES = eINSTANCE.getJavaGenModel_MetaTypes();

		/**
		 * The meta object literal for the '<em><b>Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_GEN_MODEL__CLASSES = eINSTANCE.getJavaGenModel_Classes();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JTypeImpl <em>JType</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JTypeImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJType()
		 * @generated
		 */
		EClass JTYPE = eINSTANCE.getJType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JTYPE__NAME = eINSTANCE.getJType_Name();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JLibTypeImpl <em>JLib Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JLibTypeImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJLibType()
		 * @generated
		 */
		EClass JLIB_TYPE = eINSTANCE.getJLibType();

		/**
		 * The meta object literal for the '<em><b>Pkg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JLIB_TYPE__PKG = eINSTANCE.getJLibType_Pkg();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JMetaTypeImpl <em>JMeta Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JMetaTypeImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJMetaType()
		 * @generated
		 */
		EClass JMETA_TYPE = eINSTANCE.getJMetaType();

		/**
		 * The meta object literal for the '<em><b>Qualified Java Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMETA_TYPE__QUALIFIED_JAVA_NAME = eINSTANCE.getJMetaType_QualifiedJavaName();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JTypeRefImpl <em>JType Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JTypeRefImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJTypeRef()
		 * @generated
		 */
		EClass JTYPE_REF = eINSTANCE.getJTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JTYPE_REF__TYPE = eINSTANCE.getJTypeRef_Type();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JParamTypeRefImpl <em>JParam Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JParamTypeRefImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParamTypeRef()
		 * @generated
		 */
		EClass JPARAM_TYPE_REF = eINSTANCE.getJParamTypeRef();

		/**
		 * The meta object literal for the '<em><b>Contained Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JPARAM_TYPE_REF__CONTAINED_TYPE = eINSTANCE.getJParamTypeRef_ContainedType();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JParamNTypeRefImpl <em>JParam NType Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JParamNTypeRefImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParamNTypeRef()
		 * @generated
		 */
		EClass JPARAM_NTYPE_REF = eINSTANCE.getJParamNTypeRef();

		/**
		 * The meta object literal for the '<em><b>Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JPARAM_NTYPE_REF__PARAMS = eINSTANCE.getJParamNTypeRef_Params();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JGenericTypeRefImpl <em>JGeneric Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JGenericTypeRefImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJGenericTypeRef()
		 * @generated
		 */
		EClass JGENERIC_TYPE_REF = eINSTANCE.getJGenericTypeRef();

		/**
		 * The meta object literal for the '<em><b>Type Params</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JGENERIC_TYPE_REF__TYPE_PARAMS = eINSTANCE.getJGenericTypeRef_TypeParams();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JArrayTypeRefImpl <em>JArray Type Ref</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JArrayTypeRefImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJArrayTypeRef()
		 * @generated
		 */
		EClass JARRAY_TYPE_REF = eINSTANCE.getJArrayTypeRef();

		/**
		 * The meta object literal for the '<em><b>Contained Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JARRAY_TYPE_REF__CONTAINED_TYPE = eINSTANCE.getJArrayTypeRef_ContainedType();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JClassImpl <em>JClass</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JClassImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJClass()
		 * @generated
		 */
		EClass JCLASS = eINSTANCE.getJClass();

		/**
		 * The meta object literal for the '<em><b>Extra</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JCLASS__EXTRA = eINSTANCE.getJClass_Extra();

		/**
		 * The meta object literal for the '<em><b>Pkg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JCLASS__PKG = eINSTANCE.getJClass_Pkg();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__METHODS = eINSTANCE.getJClass_Methods();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__ATTRIBUTES = eINSTANCE.getJClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__IMPLEMENTS = eINSTANCE.getJClass_Implements();

		/**
		 * The meta object literal for the '<em><b>Extends </b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__EXTENDS_ = eINSTANCE.getJClass_Extends_();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__IMPORTS = eINSTANCE.getJClass_Imports();

		/**
		 * The meta object literal for the '<em><b>This </b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLASS__THIS_ = eINSTANCE.getJClass_This_();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JThisImpl <em>JThis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JThisImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJThis()
		 * @generated
		 */
		EClass JTHIS = eINSTANCE.getJThis();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JAttributeImpl <em>JAttribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JAttributeImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJAttribute()
		 * @generated
		 */
		EClass JATTRIBUTE = eINSTANCE.getJAttribute();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JCommentImpl <em>JComment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JCommentImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJComment()
		 * @generated
		 */
		EClass JCOMMENT = eINSTANCE.getJComment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JCOMMENT__VALUE = eINSTANCE.getJComment_Value();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JBlockImpl <em>JBlock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JBlockImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJBlock()
		 * @generated
		 */
		EClass JBLOCK = eINSTANCE.getJBlock();

		/**
		 * The meta object literal for the '<em><b>Local Vars</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JBLOCK__LOCAL_VARS = eINSTANCE.getJBlock_LocalVars();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JBLOCK__STATEMENTS = eINSTANCE.getJBlock_Statements();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JMethodImpl <em>JMethod</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JMethodImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJMethod()
		 * @generated
		 */
		EClass JMETHOD = eINSTANCE.getJMethod();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMETHOD__NAME = eINSTANCE.getJMethod_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMETHOD__PARAMETERS = eINSTANCE.getJMethod_Parameters();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMETHOD__RETURN_TYPE = eINSTANCE.getJMethod_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Throws </b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JMETHOD__THROWS_ = eINSTANCE.getJMethod_Throws_();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JMETHOD__VISIBILITY = eINSTANCE.getJMethod_Visibility();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JStatementImpl <em>JStatement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JStatementImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJStatement()
		 * @generated
		 */
		EClass JSTATEMENT = eINSTANCE.getJStatement();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JReturnImpl <em>JReturn</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JReturnImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJReturn()
		 * @generated
		 */
		EClass JRETURN = eINSTANCE.getJReturn();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JRETURN__RESULT = eINSTANCE.getJReturn_Result();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JLoopImpl <em>JLoop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JLoopImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJLoop()
		 * @generated
		 */
		EClass JLOOP = eINSTANCE.getJLoop();

		/**
		 * The meta object literal for the '<em><b>Loop Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JLOOP__LOOP_VAR = eINSTANCE.getJLoop_LoopVar();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JForeachImpl <em>JForeach</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JForeachImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJForeach()
		 * @generated
		 */
		EClass JFOREACH = eINSTANCE.getJForeach();

		/**
		 * The meta object literal for the '<em><b>Collection</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JFOREACH__COLLECTION = eINSTANCE.getJForeach_Collection();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.IteratorLoopImpl <em>Iterator Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.IteratorLoopImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getIteratorLoop()
		 * @generated
		 */
		EClass ITERATOR_LOOP = eINSTANCE.getIteratorLoop();

		/**
		 * The meta object literal for the '<em><b>Iterator Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_LOOP__ITERATOR_VAR = eINSTANCE.getIteratorLoop_IteratorVar();

		/**
		 * The meta object literal for the '<em><b>Iterator Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_LOOP__ITERATOR_INIT = eINSTANCE.getIteratorLoop_IteratorInit();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JConditionalImpl <em>JConditional</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JConditionalImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJConditional()
		 * @generated
		 */
		EClass JCONDITIONAL = eINSTANCE.getJConditional();

		/**
		 * The meta object literal for the '<em><b>Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCONDITIONAL__CONDITIONS = eINSTANCE.getJConditional_Conditions();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCONDITIONAL__ELSE = eINSTANCE.getJConditional_Else();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JConditionalBlockImpl <em>JConditional Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JConditionalBlockImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJConditionalBlock()
		 * @generated
		 */
		EClass JCONDITIONAL_BLOCK = eINSTANCE.getJConditionalBlock();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCONDITIONAL_BLOCK__EXPR = eINSTANCE.getJConditionalBlock_Expr();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JAssignmentImpl <em>JAssignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JAssignmentImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJAssignment()
		 * @generated
		 */
		EClass JASSIGNMENT = eINSTANCE.getJAssignment();

		/**
		 * The meta object literal for the '<em><b>Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JASSIGNMENT__DECLARATION = eINSTANCE.getJAssignment_Declaration();

		/**
		 * The meta object literal for the '<em><b>Right Part</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JASSIGNMENT__RIGHT_PART = eINSTANCE.getJAssignment_RightPart();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JTextImpl <em>JText</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JTextImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJText()
		 * @generated
		 */
		EClass JTEXT = eINSTANCE.getJText();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JTEXT__BODY = eINSTANCE.getJText_Body();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JExpressionImpl <em>JExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JExpressionImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJExpression()
		 * @generated
		 */
		EClass JEXPRESSION = eINSTANCE.getJExpression();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JVarExpImpl <em>JVar Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JVarExpImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJVarExp()
		 * @generated
		 */
		EClass JVAR_EXP = eINSTANCE.getJVarExp();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVAR_EXP__REFERENCE = eINSTANCE.getJVarExp_Reference();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JTextExpImpl <em>JText Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JTextExpImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJTextExp()
		 * @generated
		 */
		EClass JTEXT_EXP = eINSTANCE.getJTextExp();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JTEXT_EXP__BODY = eINSTANCE.getJTextExp_Body();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JVariableDeclarationImpl <em>JVariable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JVariableDeclarationImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJVariableDeclaration()
		 * @generated
		 */
		EClass JVARIABLE_DECLARATION = eINSTANCE.getJVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JVARIABLE_DECLARATION__TYPE = eINSTANCE.getJVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVARIABLE_DECLARATION__NAME = eINSTANCE.getJVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Is Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JVARIABLE_DECLARATION__IS_FINAL = eINSTANCE.getJVariableDeclaration_IsFinal();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.LMatchObjectImpl <em>LMatch Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.LMatchObjectImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getLMatchObject()
		 * @generated
		 */
		EClass LMATCH_OBJECT = eINSTANCE.getLMatchObject();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LMATCH_OBJECT__CASES = eINSTANCE.getLMatchObject_Cases();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.LMatchCaseImpl <em>LMatch Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.LMatchCaseImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getLMatchCase()
		 * @generated
		 */
		EClass LMATCH_CASE = eINSTANCE.getLMatchCase();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LMATCH_CASE__PREDICATE = eINSTANCE.getLMatchCase_Predicate();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LMATCH_CASE__OBJ = eINSTANCE.getLMatchCase_Obj();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JParameterImpl <em>JParameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JParameterImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJParameter()
		 * @generated
		 */
		EClass JPARAMETER = eINSTANCE.getJParameter();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JClosureImpl <em>JClosure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JClosureImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJClosure()
		 * @generated
		 */
		EClass JCLOSURE = eINSTANCE.getJClosure();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JCLOSURE__PARAMETERS = eINSTANCE.getJClosure_Parameters();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JInvokeImpl <em>JInvoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JInvokeImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJInvoke()
		 * @generated
		 */
		EClass JINVOKE = eINSTANCE.getJInvoke();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JINVOKE__NAME = eINSTANCE.getJInvoke_Name();

		/**
		 * The meta object literal for the '<em><b>Obj</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JINVOKE__OBJ = eINSTANCE.getJInvoke_Obj();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JINVOKE__ARGUMENTS = eINSTANCE.getJInvoke_Arguments();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JInvokeStaticImpl <em>JInvoke Static</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JInvokeStaticImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJInvokeStatic()
		 * @generated
		 */
		EClass JINVOKE_STATIC = eINSTANCE.getJInvokeStatic();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JINVOKE_STATIC__NAME = eINSTANCE.getJInvokeStatic_Name();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JINVOKE_STATIC__ARGUMENTS = eINSTANCE.getJInvokeStatic_Arguments();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JNewObjectImpl <em>JNew Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JNewObjectImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJNewObject()
		 * @generated
		 */
		EClass JNEW_OBJECT = eINSTANCE.getJNewObject();

		/**
		 * The meta object literal for the '<em><b>Type Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JNEW_OBJECT__TYPE_REF = eINSTANCE.getJNewObject_TypeRef();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JNEW_OBJECT__ARGUMENTS = eINSTANCE.getJNewObject_Arguments();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.impl.JExprStatementImpl <em>JExpr Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.impl.JExprStatementImpl
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getJExprStatement()
		 * @generated
		 */
		EClass JEXPR_STATEMENT = eINSTANCE.getJExprStatement();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JEXPR_STATEMENT__EXPR = eINSTANCE.getJExprStatement_Expr();

		/**
		 * The meta object literal for the '{@link lintra.atlcompiler.javagen.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see lintra.atlcompiler.javagen.Visibility
		 * @see lintra.atlcompiler.javagen.impl.JavagenPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //JavagenPackage
