/**
 */
package a2l.optimiser.anatlyzerext;

import anatlyzer.atlext.OCL.OCLPackage;

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
 * @see a2l.optimiser.anatlyzerext.AnatlyzerExtFactory
 * @model kind="package"
 * @generated
 */
public interface AnatlyzerExtPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "anatlyzerext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://a2l/anatlyzer_ext";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "anatlyzer_ext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnatlyzerExtPackage eINSTANCE = a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl.init();

	/**
	 * The meta object id for the '{@link a2l.optimiser.anatlyzerext.impl.NavRefAsSetImpl <em>Nav Ref As Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.optimiser.anatlyzerext.impl.NavRefAsSetImpl
	 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getNavRefAsSet()
	 * @generated
	 */
	int NAV_REF_AS_SET = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__LOCATION = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__COMMENTS_BEFORE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__COMMENTS_AFTER = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__FILE_LOCATION = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__FILE_LOCATION;

	/**
	 * The feature id for the '<em><b>File Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__FILE_OBJECT = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__FILE_OBJECT;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__PROBLEMS = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__PROBLEMS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__ANNOTATIONS = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__INFERRED_TYPE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__TYPE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>If Exp3</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__IF_EXP3 = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__IF_EXP3;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__APPLIED_PROPERTY = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__COLLECTION = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__COLLECTION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__LET_EXP = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__LET_EXP;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__LOOP_EXP = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__PARENT_OPERATION = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__INITIALIZED_VARIABLE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>If Exp2</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__IF_EXP2 = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__IF_EXP2;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__OWNING_OPERATION = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__OWNING_OPERATION;

	/**
	 * The feature id for the '<em><b>If Exp1</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__IF_EXP1 = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__IF_EXP1;

	/**
	 * The feature id for the '<em><b>Owning Attribute</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__OWNING_ATTRIBUTE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__OWNING_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Implicitly Casted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__IMPLICITLY_CASTED = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__IMPLICITLY_CASTED;

	/**
	 * The feature id for the '<em><b>No Casted Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__NO_CASTED_TYPE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__NO_CASTED_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__SOURCE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Used Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__USED_FEATURE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__USED_FEATURE;

	/**
	 * The feature id for the '<em><b>Subtype Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__SUBTYPE_FEATURES = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__SUBTYPE_FEATURES;

	/**
	 * The feature id for the '<em><b>Receptor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__RECEPTOR_TYPE = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__RECEPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Is Static Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__IS_STATIC_CALL = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__IS_STATIC_CALL;

	/**
	 * The feature id for the '<em><b>Static Resolver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__STATIC_RESOLVER = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__STATIC_RESOLVER;

	/**
	 * The feature id for the '<em><b>Dynamic Resolvers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__DYNAMIC_RESOLVERS = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__DYNAMIC_RESOLVERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET__NAME = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP__NAME;

	/**
	 * The number of structural features of the '<em>Nav Ref As Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET_FEATURE_COUNT = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Nav Ref As Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAV_REF_AS_SET_OPERATION_COUNT = OCLPackage.NAVIGATION_OR_ATTRIBUTE_CALL_EXP_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link a2l.optimiser.anatlyzerext.impl.MutableIteratorExpImpl <em>Mutable Iterator Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.optimiser.anatlyzerext.impl.MutableIteratorExpImpl
	 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getMutableIteratorExp()
	 * @generated
	 */
	int MUTABLE_ITERATOR_EXP = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__LOCATION = OCLPackage.ITERATOR_EXP__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__COMMENTS_BEFORE = OCLPackage.ITERATOR_EXP__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__COMMENTS_AFTER = OCLPackage.ITERATOR_EXP__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__FILE_LOCATION = OCLPackage.ITERATOR_EXP__FILE_LOCATION;

	/**
	 * The feature id for the '<em><b>File Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__FILE_OBJECT = OCLPackage.ITERATOR_EXP__FILE_OBJECT;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__PROBLEMS = OCLPackage.ITERATOR_EXP__PROBLEMS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__ANNOTATIONS = OCLPackage.ITERATOR_EXP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__INFERRED_TYPE = OCLPackage.ITERATOR_EXP__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__TYPE = OCLPackage.ITERATOR_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>If Exp3</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__IF_EXP3 = OCLPackage.ITERATOR_EXP__IF_EXP3;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__APPLIED_PROPERTY = OCLPackage.ITERATOR_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__COLLECTION = OCLPackage.ITERATOR_EXP__COLLECTION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__LET_EXP = OCLPackage.ITERATOR_EXP__LET_EXP;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__LOOP_EXP = OCLPackage.ITERATOR_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__PARENT_OPERATION = OCLPackage.ITERATOR_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__INITIALIZED_VARIABLE = OCLPackage.ITERATOR_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>If Exp2</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__IF_EXP2 = OCLPackage.ITERATOR_EXP__IF_EXP2;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__OWNING_OPERATION = OCLPackage.ITERATOR_EXP__OWNING_OPERATION;

	/**
	 * The feature id for the '<em><b>If Exp1</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__IF_EXP1 = OCLPackage.ITERATOR_EXP__IF_EXP1;

	/**
	 * The feature id for the '<em><b>Owning Attribute</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__OWNING_ATTRIBUTE = OCLPackage.ITERATOR_EXP__OWNING_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Implicitly Casted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__IMPLICITLY_CASTED = OCLPackage.ITERATOR_EXP__IMPLICITLY_CASTED;

	/**
	 * The feature id for the '<em><b>No Casted Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__NO_CASTED_TYPE = OCLPackage.ITERATOR_EXP__NO_CASTED_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__SOURCE = OCLPackage.ITERATOR_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Used Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__USED_FEATURE = OCLPackage.ITERATOR_EXP__USED_FEATURE;

	/**
	 * The feature id for the '<em><b>Subtype Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__SUBTYPE_FEATURES = OCLPackage.ITERATOR_EXP__SUBTYPE_FEATURES;

	/**
	 * The feature id for the '<em><b>Receptor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__RECEPTOR_TYPE = OCLPackage.ITERATOR_EXP__RECEPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Is Static Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__IS_STATIC_CALL = OCLPackage.ITERATOR_EXP__IS_STATIC_CALL;

	/**
	 * The feature id for the '<em><b>Static Resolver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__STATIC_RESOLVER = OCLPackage.ITERATOR_EXP__STATIC_RESOLVER;

	/**
	 * The feature id for the '<em><b>Dynamic Resolvers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__DYNAMIC_RESOLVERS = OCLPackage.ITERATOR_EXP__DYNAMIC_RESOLVERS;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__BODY = OCLPackage.ITERATOR_EXP__BODY;

	/**
	 * The feature id for the '<em><b>Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__ITERATORS = OCLPackage.ITERATOR_EXP__ITERATORS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP__NAME = OCLPackage.ITERATOR_EXP__NAME;

	/**
	 * The number of structural features of the '<em>Mutable Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP_FEATURE_COUNT = OCLPackage.ITERATOR_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mutable Iterator Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_ITERATOR_EXP_OPERATION_COUNT = OCLPackage.ITERATOR_EXP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link a2l.optimiser.anatlyzerext.impl.MutableCollectionOperationCallExpImpl <em>Mutable Collection Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.optimiser.anatlyzerext.impl.MutableCollectionOperationCallExpImpl
	 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getMutableCollectionOperationCallExp()
	 * @generated
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP = 2;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__LOCATION = OCLPackage.COLLECTION_OPERATION_CALL_EXP__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__COMMENTS_BEFORE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__COMMENTS_AFTER = OCLPackage.COLLECTION_OPERATION_CALL_EXP__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__FILE_LOCATION = OCLPackage.COLLECTION_OPERATION_CALL_EXP__FILE_LOCATION;

	/**
	 * The feature id for the '<em><b>File Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__FILE_OBJECT = OCLPackage.COLLECTION_OPERATION_CALL_EXP__FILE_OBJECT;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__PROBLEMS = OCLPackage.COLLECTION_OPERATION_CALL_EXP__PROBLEMS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__ANNOTATIONS = OCLPackage.COLLECTION_OPERATION_CALL_EXP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__INFERRED_TYPE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__TYPE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>If Exp3</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__IF_EXP3 = OCLPackage.COLLECTION_OPERATION_CALL_EXP__IF_EXP3;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__APPLIED_PROPERTY = OCLPackage.COLLECTION_OPERATION_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__COLLECTION = OCLPackage.COLLECTION_OPERATION_CALL_EXP__COLLECTION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__LET_EXP = OCLPackage.COLLECTION_OPERATION_CALL_EXP__LET_EXP;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__LOOP_EXP = OCLPackage.COLLECTION_OPERATION_CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__PARENT_OPERATION = OCLPackage.COLLECTION_OPERATION_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__INITIALIZED_VARIABLE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>If Exp2</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__IF_EXP2 = OCLPackage.COLLECTION_OPERATION_CALL_EXP__IF_EXP2;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__OWNING_OPERATION = OCLPackage.COLLECTION_OPERATION_CALL_EXP__OWNING_OPERATION;

	/**
	 * The feature id for the '<em><b>If Exp1</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__IF_EXP1 = OCLPackage.COLLECTION_OPERATION_CALL_EXP__IF_EXP1;

	/**
	 * The feature id for the '<em><b>Owning Attribute</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__OWNING_ATTRIBUTE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__OWNING_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Implicitly Casted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__IMPLICITLY_CASTED = OCLPackage.COLLECTION_OPERATION_CALL_EXP__IMPLICITLY_CASTED;

	/**
	 * The feature id for the '<em><b>No Casted Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__NO_CASTED_TYPE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__NO_CASTED_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__SOURCE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Used Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__USED_FEATURE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__USED_FEATURE;

	/**
	 * The feature id for the '<em><b>Subtype Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__SUBTYPE_FEATURES = OCLPackage.COLLECTION_OPERATION_CALL_EXP__SUBTYPE_FEATURES;

	/**
	 * The feature id for the '<em><b>Receptor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__RECEPTOR_TYPE = OCLPackage.COLLECTION_OPERATION_CALL_EXP__RECEPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Is Static Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__IS_STATIC_CALL = OCLPackage.COLLECTION_OPERATION_CALL_EXP__IS_STATIC_CALL;

	/**
	 * The feature id for the '<em><b>Static Resolver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__STATIC_RESOLVER = OCLPackage.COLLECTION_OPERATION_CALL_EXP__STATIC_RESOLVER;

	/**
	 * The feature id for the '<em><b>Dynamic Resolvers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__DYNAMIC_RESOLVERS = OCLPackage.COLLECTION_OPERATION_CALL_EXP__DYNAMIC_RESOLVERS;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__ARGUMENTS = OCLPackage.COLLECTION_OPERATION_CALL_EXP__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Operation Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__OPERATION_NAME = OCLPackage.COLLECTION_OPERATION_CALL_EXP__OPERATION_NAME;

	/**
	 * The feature id for the '<em><b>Resolve Temp Resolved By</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP__RESOLVE_TEMP_RESOLVED_BY = OCLPackage.COLLECTION_OPERATION_CALL_EXP__RESOLVE_TEMP_RESOLVED_BY;

	/**
	 * The number of structural features of the '<em>Mutable Collection Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP_FEATURE_COUNT = OCLPackage.COLLECTION_OPERATION_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mutable Collection Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTABLE_COLLECTION_OPERATION_CALL_EXP_OPERATION_COUNT = OCLPackage.COLLECTION_OPERATION_CALL_EXP_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl <em>Iterator Chain Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl
	 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getIteratorChainExp()
	 * @generated
	 */
	int ITERATOR_CHAIN_EXP = 3;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__LOCATION = OCLPackage.PROPERTY_CALL_EXP__LOCATION;

	/**
	 * The feature id for the '<em><b>Comments Before</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__COMMENTS_BEFORE = OCLPackage.PROPERTY_CALL_EXP__COMMENTS_BEFORE;

	/**
	 * The feature id for the '<em><b>Comments After</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__COMMENTS_AFTER = OCLPackage.PROPERTY_CALL_EXP__COMMENTS_AFTER;

	/**
	 * The feature id for the '<em><b>File Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__FILE_LOCATION = OCLPackage.PROPERTY_CALL_EXP__FILE_LOCATION;

	/**
	 * The feature id for the '<em><b>File Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__FILE_OBJECT = OCLPackage.PROPERTY_CALL_EXP__FILE_OBJECT;

	/**
	 * The feature id for the '<em><b>Problems</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__PROBLEMS = OCLPackage.PROPERTY_CALL_EXP__PROBLEMS;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__ANNOTATIONS = OCLPackage.PROPERTY_CALL_EXP__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Inferred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__INFERRED_TYPE = OCLPackage.PROPERTY_CALL_EXP__INFERRED_TYPE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__TYPE = OCLPackage.PROPERTY_CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>If Exp3</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__IF_EXP3 = OCLPackage.PROPERTY_CALL_EXP__IF_EXP3;

	/**
	 * The feature id for the '<em><b>Applied Property</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__APPLIED_PROPERTY = OCLPackage.PROPERTY_CALL_EXP__APPLIED_PROPERTY;

	/**
	 * The feature id for the '<em><b>Collection</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__COLLECTION = OCLPackage.PROPERTY_CALL_EXP__COLLECTION;

	/**
	 * The feature id for the '<em><b>Let Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__LET_EXP = OCLPackage.PROPERTY_CALL_EXP__LET_EXP;

	/**
	 * The feature id for the '<em><b>Loop Exp</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__LOOP_EXP = OCLPackage.PROPERTY_CALL_EXP__LOOP_EXP;

	/**
	 * The feature id for the '<em><b>Parent Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__PARENT_OPERATION = OCLPackage.PROPERTY_CALL_EXP__PARENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Initialized Variable</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__INITIALIZED_VARIABLE = OCLPackage.PROPERTY_CALL_EXP__INITIALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>If Exp2</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__IF_EXP2 = OCLPackage.PROPERTY_CALL_EXP__IF_EXP2;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__OWNING_OPERATION = OCLPackage.PROPERTY_CALL_EXP__OWNING_OPERATION;

	/**
	 * The feature id for the '<em><b>If Exp1</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__IF_EXP1 = OCLPackage.PROPERTY_CALL_EXP__IF_EXP1;

	/**
	 * The feature id for the '<em><b>Owning Attribute</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__OWNING_ATTRIBUTE = OCLPackage.PROPERTY_CALL_EXP__OWNING_ATTRIBUTE;

	/**
	 * The feature id for the '<em><b>Implicitly Casted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__IMPLICITLY_CASTED = OCLPackage.PROPERTY_CALL_EXP__IMPLICITLY_CASTED;

	/**
	 * The feature id for the '<em><b>No Casted Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__NO_CASTED_TYPE = OCLPackage.PROPERTY_CALL_EXP__NO_CASTED_TYPE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__SOURCE = OCLPackage.PROPERTY_CALL_EXP__SOURCE;

	/**
	 * The feature id for the '<em><b>Used Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__USED_FEATURE = OCLPackage.PROPERTY_CALL_EXP__USED_FEATURE;

	/**
	 * The feature id for the '<em><b>Subtype Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__SUBTYPE_FEATURES = OCLPackage.PROPERTY_CALL_EXP__SUBTYPE_FEATURES;

	/**
	 * The feature id for the '<em><b>Receptor Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__RECEPTOR_TYPE = OCLPackage.PROPERTY_CALL_EXP__RECEPTOR_TYPE;

	/**
	 * The feature id for the '<em><b>Is Static Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__IS_STATIC_CALL = OCLPackage.PROPERTY_CALL_EXP__IS_STATIC_CALL;

	/**
	 * The feature id for the '<em><b>Static Resolver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__STATIC_RESOLVER = OCLPackage.PROPERTY_CALL_EXP__STATIC_RESOLVER;

	/**
	 * The feature id for the '<em><b>Dynamic Resolvers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__DYNAMIC_RESOLVERS = OCLPackage.PROPERTY_CALL_EXP__DYNAMIC_RESOLVERS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__NAME = OCLPackage.PROPERTY_CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__ITERATOR = OCLPackage.PROPERTY_CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Pre Chain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__PRE_CHAIN = OCLPackage.PROPERTY_CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Chain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP__CHAIN = OCLPackage.PROPERTY_CALL_EXP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Iterator Chain Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP_FEATURE_COUNT = OCLPackage.PROPERTY_CALL_EXP_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Iterator Chain Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_EXP_OPERATION_COUNT = OCLPackage.PROPERTY_CALL_EXP_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link a2l.optimiser.anatlyzerext.impl.IteratorChainElementImpl <em>Iterator Chain Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see a2l.optimiser.anatlyzerext.impl.IteratorChainElementImpl
	 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getIteratorChainElement()
	 * @generated
	 */
	int ITERATOR_CHAIN_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_ELEMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_ELEMENT__ITERATOR = 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_ELEMENT__BODY = 2;

	/**
	 * The number of structural features of the '<em>Iterator Chain Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_ELEMENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Iterator Chain Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_CHAIN_ELEMENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link a2l.optimiser.anatlyzerext.NavRefAsSet <em>Nav Ref As Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nav Ref As Set</em>'.
	 * @see a2l.optimiser.anatlyzerext.NavRefAsSet
	 * @generated
	 */
	EClass getNavRefAsSet();

	/**
	 * Returns the meta object for class '{@link a2l.optimiser.anatlyzerext.MutableIteratorExp <em>Mutable Iterator Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutable Iterator Exp</em>'.
	 * @see a2l.optimiser.anatlyzerext.MutableIteratorExp
	 * @generated
	 */
	EClass getMutableIteratorExp();

	/**
	 * Returns the meta object for class '{@link a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp <em>Mutable Collection Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutable Collection Operation Call Exp</em>'.
	 * @see a2l.optimiser.anatlyzerext.MutableCollectionOperationCallExp
	 * @generated
	 */
	EClass getMutableCollectionOperationCallExp();

	/**
	 * Returns the meta object for class '{@link a2l.optimiser.anatlyzerext.IteratorChainExp <em>Iterator Chain Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Chain Exp</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainExp
	 * @generated
	 */
	EClass getIteratorChainExp();

	/**
	 * Returns the meta object for the attribute '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainExp#getName()
	 * @see #getIteratorChainExp()
	 * @generated
	 */
	EAttribute getIteratorChainExp_Name();

	/**
	 * Returns the meta object for the containment reference '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainExp#getIterator()
	 * @see #getIteratorChainExp()
	 * @generated
	 */
	EReference getIteratorChainExp_Iterator();

	/**
	 * Returns the meta object for the containment reference list '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getPreChain <em>Pre Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pre Chain</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainExp#getPreChain()
	 * @see #getIteratorChainExp()
	 * @generated
	 */
	EReference getIteratorChainExp_PreChain();

	/**
	 * Returns the meta object for the containment reference list '{@link a2l.optimiser.anatlyzerext.IteratorChainExp#getChain <em>Chain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Chain</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainExp#getChain()
	 * @see #getIteratorChainExp()
	 * @generated
	 */
	EReference getIteratorChainExp_Chain();

	/**
	 * Returns the meta object for class '{@link a2l.optimiser.anatlyzerext.IteratorChainElement <em>Iterator Chain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Chain Element</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainElement
	 * @generated
	 */
	EClass getIteratorChainElement();

	/**
	 * Returns the meta object for the attribute '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainElement#getName()
	 * @see #getIteratorChainElement()
	 * @generated
	 */
	EAttribute getIteratorChainElement_Name();

	/**
	 * Returns the meta object for the containment reference '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getIterator <em>Iterator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Iterator</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainElement#getIterator()
	 * @see #getIteratorChainElement()
	 * @generated
	 */
	EReference getIteratorChainElement_Iterator();

	/**
	 * Returns the meta object for the containment reference '{@link a2l.optimiser.anatlyzerext.IteratorChainElement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see a2l.optimiser.anatlyzerext.IteratorChainElement#getBody()
	 * @see #getIteratorChainElement()
	 * @generated
	 */
	EReference getIteratorChainElement_Body();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnatlyzerExtFactory getAnatlyzerExtFactory();

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
		 * The meta object literal for the '{@link a2l.optimiser.anatlyzerext.impl.NavRefAsSetImpl <em>Nav Ref As Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.optimiser.anatlyzerext.impl.NavRefAsSetImpl
		 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getNavRefAsSet()
		 * @generated
		 */
		EClass NAV_REF_AS_SET = eINSTANCE.getNavRefAsSet();
		/**
		 * The meta object literal for the '{@link a2l.optimiser.anatlyzerext.impl.MutableIteratorExpImpl <em>Mutable Iterator Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.optimiser.anatlyzerext.impl.MutableIteratorExpImpl
		 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getMutableIteratorExp()
		 * @generated
		 */
		EClass MUTABLE_ITERATOR_EXP = eINSTANCE.getMutableIteratorExp();
		/**
		 * The meta object literal for the '{@link a2l.optimiser.anatlyzerext.impl.MutableCollectionOperationCallExpImpl <em>Mutable Collection Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.optimiser.anatlyzerext.impl.MutableCollectionOperationCallExpImpl
		 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getMutableCollectionOperationCallExp()
		 * @generated
		 */
		EClass MUTABLE_COLLECTION_OPERATION_CALL_EXP = eINSTANCE.getMutableCollectionOperationCallExp();
		/**
		 * The meta object literal for the '{@link a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl <em>Iterator Chain Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.optimiser.anatlyzerext.impl.IteratorChainExpImpl
		 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getIteratorChainExp()
		 * @generated
		 */
		EClass ITERATOR_CHAIN_EXP = eINSTANCE.getIteratorChainExp();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR_CHAIN_EXP__NAME = eINSTANCE.getIteratorChainExp_Name();
		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_CHAIN_EXP__ITERATOR = eINSTANCE.getIteratorChainExp_Iterator();
		/**
		 * The meta object literal for the '<em><b>Pre Chain</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_CHAIN_EXP__PRE_CHAIN = eINSTANCE.getIteratorChainExp_PreChain();
		/**
		 * The meta object literal for the '<em><b>Chain</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_CHAIN_EXP__CHAIN = eINSTANCE.getIteratorChainExp_Chain();
		/**
		 * The meta object literal for the '{@link a2l.optimiser.anatlyzerext.impl.IteratorChainElementImpl <em>Iterator Chain Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see a2l.optimiser.anatlyzerext.impl.IteratorChainElementImpl
		 * @see a2l.optimiser.anatlyzerext.impl.AnatlyzerExtPackageImpl#getIteratorChainElement()
		 * @generated
		 */
		EClass ITERATOR_CHAIN_ELEMENT = eINSTANCE.getIteratorChainElement();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATOR_CHAIN_ELEMENT__NAME = eINSTANCE.getIteratorChainElement_Name();
		/**
		 * The meta object literal for the '<em><b>Iterator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_CHAIN_ELEMENT__ITERATOR = eINSTANCE.getIteratorChainElement_Iterator();
		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATOR_CHAIN_ELEMENT__BODY = eINSTANCE.getIteratorChainElement_Body();

	}

} //AnatlyzerExtPackage
