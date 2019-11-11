/**
 */
package lintra.atlcompiler.javagen.impl;

import lintra.atlcompiler.javagen.IteratorLoop;
import lintra.atlcompiler.javagen.JArrayTypeRef;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JClosure;
import lintra.atlcompiler.javagen.JComment;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JExprStatement;
import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JForeach;
import lintra.atlcompiler.javagen.JGenericTypeRef;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JInvokeStatic;
import lintra.atlcompiler.javagen.JLibType;
import lintra.atlcompiler.javagen.JLoop;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JNewObject;
import lintra.atlcompiler.javagen.JParamNTypeRef;
import lintra.atlcompiler.javagen.JParamTypeRef;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JReturn;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JText;
import lintra.atlcompiler.javagen.JTextExp;
import lintra.atlcompiler.javagen.JThis;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVarExp;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.atlcompiler.javagen.JavagenPackage;
import lintra.atlcompiler.javagen.LMatchCase;
import lintra.atlcompiler.javagen.LMatchObject;

import lintra.atlcompiler.javagen.Visibility;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavagenPackageImpl extends EPackageImpl implements JavagenPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass javaGenModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jLibTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jMetaTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jParamTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jParamNTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jGenericTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jArrayTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jThisEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jAttributeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jReturnEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jForeachEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iteratorLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jConditionalEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jConditionalBlockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jTextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jVarExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jTextExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jVariableDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lMatchObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lMatchCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jClosureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jInvokeStaticEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jNewObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass jExprStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

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
	 * @see lintra.atlcompiler.javagen.JavagenPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JavagenPackageImpl() {
		super(eNS_URI, JavagenFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link JavagenPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JavagenPackage init() {
		if (isInited) return (JavagenPackage)EPackage.Registry.INSTANCE.getEPackage(JavagenPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredJavagenPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		JavagenPackageImpl theJavagenPackage = registeredJavagenPackage instanceof JavagenPackageImpl ? (JavagenPackageImpl)registeredJavagenPackage : new JavagenPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theJavagenPackage.createPackageContents();

		// Initialize created meta-data
		theJavagenPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJavagenPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JavagenPackage.eNS_URI, theJavagenPackage);
		return theJavagenPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJavaGenModel() {
		return javaGenModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJavaGenModel_LibTypes() {
		return (EReference)javaGenModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJavaGenModel_MetaTypes() {
		return (EReference)javaGenModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJavaGenModel_Classes() {
		return (EReference)javaGenModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJType() {
		return jTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJType_Name() {
		return (EAttribute)jTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJLibType() {
		return jLibTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJLibType_Pkg() {
		return (EAttribute)jLibTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJMetaType() {
		return jMetaTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJMetaType_QualifiedJavaName() {
		return (EAttribute)jMetaTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJTypeRef() {
		return jTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJTypeRef_Type() {
		return (EReference)jTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJParamTypeRef() {
		return jParamTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJParamTypeRef_ContainedType() {
		return (EReference)jParamTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJParamNTypeRef() {
		return jParamNTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJParamNTypeRef_Params() {
		return (EReference)jParamNTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJGenericTypeRef() {
		return jGenericTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJGenericTypeRef_TypeParams() {
		return (EReference)jGenericTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJArrayTypeRef() {
		return jArrayTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJArrayTypeRef_ContainedType() {
		return (EReference)jArrayTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJClass() {
		return jClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJClass_Extra() {
		return (EAttribute)jClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJClass_Pkg() {
		return (EAttribute)jClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_Methods() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_Attributes() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_Implements() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_Extends_() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_Imports() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClass_This_() {
		return (EReference)jClassEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJThis() {
		return jThisEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJAttribute() {
		return jAttributeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJComment() {
		return jCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJComment_Value() {
		return (EAttribute)jCommentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJBlock() {
		return jBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJBlock_LocalVars() {
		return (EReference)jBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJBlock_Statements() {
		return (EReference)jBlockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJMethod() {
		return jMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJMethod_Name() {
		return (EAttribute)jMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJMethod_Parameters() {
		return (EReference)jMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJMethod_ReturnType() {
		return (EReference)jMethodEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJMethod_Throws_() {
		return (EReference)jMethodEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJMethod_Visibility() {
		return (EAttribute)jMethodEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJStatement() {
		return jStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJReturn() {
		return jReturnEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJReturn_Result() {
		return (EReference)jReturnEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJLoop() {
		return jLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJLoop_LoopVar() {
		return (EReference)jLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJForeach() {
		return jForeachEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJForeach_Collection() {
		return (EReference)jForeachEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIteratorLoop() {
		return iteratorLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorLoop_IteratorVar() {
		return (EReference)iteratorLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIteratorLoop_IteratorInit() {
		return (EReference)iteratorLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJConditional() {
		return jConditionalEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJConditional_Conditions() {
		return (EReference)jConditionalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJConditional_Else() {
		return (EReference)jConditionalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJConditionalBlock() {
		return jConditionalBlockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJConditionalBlock_Expr() {
		return (EReference)jConditionalBlockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJAssignment() {
		return jAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJAssignment_Declaration() {
		return (EReference)jAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJAssignment_RightPart() {
		return (EReference)jAssignmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJText() {
		return jTextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJText_Body() {
		return (EAttribute)jTextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJExpression() {
		return jExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJVarExp() {
		return jVarExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJVarExp_Reference() {
		return (EReference)jVarExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJTextExp() {
		return jTextExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJTextExp_Body() {
		return (EAttribute)jTextExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJVariableDeclaration() {
		return jVariableDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJVariableDeclaration_Type() {
		return (EReference)jVariableDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJVariableDeclaration_Name() {
		return (EAttribute)jVariableDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLMatchObject() {
		return lMatchObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLMatchObject_Cases() {
		return (EReference)lMatchObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLMatchCase() {
		return lMatchCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLMatchCase_Predicate() {
		return (EReference)lMatchCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLMatchCase_Obj() {
		return (EReference)lMatchCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJParameter() {
		return jParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJClosure() {
		return jClosureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJClosure_Parameters() {
		return (EReference)jClosureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJInvoke() {
		return jInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJInvoke_Name() {
		return (EAttribute)jInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJInvoke_Obj() {
		return (EReference)jInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJInvoke_Arguments() {
		return (EReference)jInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJInvokeStatic() {
		return jInvokeStaticEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getJInvokeStatic_Name() {
		return (EAttribute)jInvokeStaticEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJInvokeStatic_Arguments() {
		return (EReference)jInvokeStaticEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJNewObject() {
		return jNewObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJNewObject_TypeRef() {
		return (EReference)jNewObjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJNewObject_Arguments() {
		return (EReference)jNewObjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getJExprStatement() {
		return jExprStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getJExprStatement_Expr() {
		return (EReference)jExprStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavagenFactory getJavagenFactory() {
		return (JavagenFactory)getEFactoryInstance();
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
		javaGenModelEClass = createEClass(JAVA_GEN_MODEL);
		createEReference(javaGenModelEClass, JAVA_GEN_MODEL__LIB_TYPES);
		createEReference(javaGenModelEClass, JAVA_GEN_MODEL__META_TYPES);
		createEReference(javaGenModelEClass, JAVA_GEN_MODEL__CLASSES);

		jTypeEClass = createEClass(JTYPE);
		createEAttribute(jTypeEClass, JTYPE__NAME);

		jLibTypeEClass = createEClass(JLIB_TYPE);
		createEAttribute(jLibTypeEClass, JLIB_TYPE__PKG);

		jMetaTypeEClass = createEClass(JMETA_TYPE);
		createEAttribute(jMetaTypeEClass, JMETA_TYPE__QUALIFIED_JAVA_NAME);

		jTypeRefEClass = createEClass(JTYPE_REF);
		createEReference(jTypeRefEClass, JTYPE_REF__TYPE);

		jParamTypeRefEClass = createEClass(JPARAM_TYPE_REF);
		createEReference(jParamTypeRefEClass, JPARAM_TYPE_REF__CONTAINED_TYPE);

		jParamNTypeRefEClass = createEClass(JPARAM_NTYPE_REF);
		createEReference(jParamNTypeRefEClass, JPARAM_NTYPE_REF__PARAMS);

		jGenericTypeRefEClass = createEClass(JGENERIC_TYPE_REF);
		createEReference(jGenericTypeRefEClass, JGENERIC_TYPE_REF__TYPE_PARAMS);

		jArrayTypeRefEClass = createEClass(JARRAY_TYPE_REF);
		createEReference(jArrayTypeRefEClass, JARRAY_TYPE_REF__CONTAINED_TYPE);

		jClassEClass = createEClass(JCLASS);
		createEAttribute(jClassEClass, JCLASS__EXTRA);
		createEAttribute(jClassEClass, JCLASS__PKG);
		createEReference(jClassEClass, JCLASS__METHODS);
		createEReference(jClassEClass, JCLASS__ATTRIBUTES);
		createEReference(jClassEClass, JCLASS__IMPLEMENTS);
		createEReference(jClassEClass, JCLASS__EXTENDS_);
		createEReference(jClassEClass, JCLASS__IMPORTS);
		createEReference(jClassEClass, JCLASS__THIS_);

		jThisEClass = createEClass(JTHIS);

		jAttributeEClass = createEClass(JATTRIBUTE);

		jCommentEClass = createEClass(JCOMMENT);
		createEAttribute(jCommentEClass, JCOMMENT__VALUE);

		jBlockEClass = createEClass(JBLOCK);
		createEReference(jBlockEClass, JBLOCK__LOCAL_VARS);
		createEReference(jBlockEClass, JBLOCK__STATEMENTS);

		jMethodEClass = createEClass(JMETHOD);
		createEAttribute(jMethodEClass, JMETHOD__NAME);
		createEReference(jMethodEClass, JMETHOD__PARAMETERS);
		createEReference(jMethodEClass, JMETHOD__RETURN_TYPE);
		createEReference(jMethodEClass, JMETHOD__THROWS_);
		createEAttribute(jMethodEClass, JMETHOD__VISIBILITY);

		jStatementEClass = createEClass(JSTATEMENT);

		jReturnEClass = createEClass(JRETURN);
		createEReference(jReturnEClass, JRETURN__RESULT);

		jLoopEClass = createEClass(JLOOP);
		createEReference(jLoopEClass, JLOOP__LOOP_VAR);

		jForeachEClass = createEClass(JFOREACH);
		createEReference(jForeachEClass, JFOREACH__COLLECTION);

		iteratorLoopEClass = createEClass(ITERATOR_LOOP);
		createEReference(iteratorLoopEClass, ITERATOR_LOOP__ITERATOR_VAR);
		createEReference(iteratorLoopEClass, ITERATOR_LOOP__ITERATOR_INIT);

		jConditionalEClass = createEClass(JCONDITIONAL);
		createEReference(jConditionalEClass, JCONDITIONAL__CONDITIONS);
		createEReference(jConditionalEClass, JCONDITIONAL__ELSE);

		jConditionalBlockEClass = createEClass(JCONDITIONAL_BLOCK);
		createEReference(jConditionalBlockEClass, JCONDITIONAL_BLOCK__EXPR);

		jAssignmentEClass = createEClass(JASSIGNMENT);
		createEReference(jAssignmentEClass, JASSIGNMENT__DECLARATION);
		createEReference(jAssignmentEClass, JASSIGNMENT__RIGHT_PART);

		jTextEClass = createEClass(JTEXT);
		createEAttribute(jTextEClass, JTEXT__BODY);

		jExpressionEClass = createEClass(JEXPRESSION);

		jVarExpEClass = createEClass(JVAR_EXP);
		createEReference(jVarExpEClass, JVAR_EXP__REFERENCE);

		jTextExpEClass = createEClass(JTEXT_EXP);
		createEAttribute(jTextExpEClass, JTEXT_EXP__BODY);

		jVariableDeclarationEClass = createEClass(JVARIABLE_DECLARATION);
		createEReference(jVariableDeclarationEClass, JVARIABLE_DECLARATION__TYPE);
		createEAttribute(jVariableDeclarationEClass, JVARIABLE_DECLARATION__NAME);

		lMatchObjectEClass = createEClass(LMATCH_OBJECT);
		createEReference(lMatchObjectEClass, LMATCH_OBJECT__CASES);

		lMatchCaseEClass = createEClass(LMATCH_CASE);
		createEReference(lMatchCaseEClass, LMATCH_CASE__PREDICATE);
		createEReference(lMatchCaseEClass, LMATCH_CASE__OBJ);

		jParameterEClass = createEClass(JPARAMETER);

		jClosureEClass = createEClass(JCLOSURE);
		createEReference(jClosureEClass, JCLOSURE__PARAMETERS);

		jInvokeEClass = createEClass(JINVOKE);
		createEAttribute(jInvokeEClass, JINVOKE__NAME);
		createEReference(jInvokeEClass, JINVOKE__OBJ);
		createEReference(jInvokeEClass, JINVOKE__ARGUMENTS);

		jInvokeStaticEClass = createEClass(JINVOKE_STATIC);
		createEAttribute(jInvokeStaticEClass, JINVOKE_STATIC__NAME);
		createEReference(jInvokeStaticEClass, JINVOKE_STATIC__ARGUMENTS);

		jNewObjectEClass = createEClass(JNEW_OBJECT);
		createEReference(jNewObjectEClass, JNEW_OBJECT__TYPE_REF);
		createEReference(jNewObjectEClass, JNEW_OBJECT__ARGUMENTS);

		jExprStatementEClass = createEClass(JEXPR_STATEMENT);
		createEReference(jExprStatementEClass, JEXPR_STATEMENT__EXPR);

		// Create enums
		visibilityEEnum = createEEnum(VISIBILITY);
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
		jLibTypeEClass.getESuperTypes().add(this.getJType());
		jMetaTypeEClass.getESuperTypes().add(this.getJType());
		jParamTypeRefEClass.getESuperTypes().add(this.getJTypeRef());
		jParamNTypeRefEClass.getESuperTypes().add(this.getJTypeRef());
		jGenericTypeRefEClass.getESuperTypes().add(this.getJTypeRef());
		jArrayTypeRefEClass.getESuperTypes().add(this.getJTypeRef());
		jClassEClass.getESuperTypes().add(this.getJType());
		jThisEClass.getESuperTypes().add(this.getJVariableDeclaration());
		jAttributeEClass.getESuperTypes().add(this.getJVariableDeclaration());
		jCommentEClass.getESuperTypes().add(this.getJStatement());
		jMethodEClass.getESuperTypes().add(this.getJBlock());
		jReturnEClass.getESuperTypes().add(this.getJStatement());
		jLoopEClass.getESuperTypes().add(this.getJStatement());
		jLoopEClass.getESuperTypes().add(this.getJBlock());
		jForeachEClass.getESuperTypes().add(this.getJLoop());
		iteratorLoopEClass.getESuperTypes().add(this.getJLoop());
		jConditionalEClass.getESuperTypes().add(this.getJStatement());
		jConditionalBlockEClass.getESuperTypes().add(this.getJBlock());
		jAssignmentEClass.getESuperTypes().add(this.getJText());
		jTextEClass.getESuperTypes().add(this.getJStatement());
		jVarExpEClass.getESuperTypes().add(this.getJExpression());
		jTextExpEClass.getESuperTypes().add(this.getJExpression());
		lMatchObjectEClass.getESuperTypes().add(this.getJStatement());
		lMatchCaseEClass.getESuperTypes().add(this.getJBlock());
		jParameterEClass.getESuperTypes().add(this.getJVariableDeclaration());
		jClosureEClass.getESuperTypes().add(this.getJExpression());
		jClosureEClass.getESuperTypes().add(this.getJBlock());
		jInvokeEClass.getESuperTypes().add(this.getJExpression());
		jInvokeStaticEClass.getESuperTypes().add(this.getJExpression());
		jNewObjectEClass.getESuperTypes().add(this.getJExpression());
		jExprStatementEClass.getESuperTypes().add(this.getJStatement());

		// Initialize classes, features, and operations; add parameters
		initEClass(javaGenModelEClass, JavaGenModel.class, "JavaGenModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJavaGenModel_LibTypes(), this.getJLibType(), null, "libTypes", null, 0, -1, JavaGenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaGenModel_MetaTypes(), this.getJMetaType(), null, "metaTypes", null, 0, -1, JavaGenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJavaGenModel_Classes(), this.getJClass(), null, "classes", null, 0, -1, JavaGenModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jTypeEClass, JType.class, "JType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJType_Name(), ecorePackage.getEString(), "name", null, 1, 1, JType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jLibTypeEClass, JLibType.class, "JLibType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJLibType_Pkg(), ecorePackage.getEString(), "pkg", null, 1, 1, JLibType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jMetaTypeEClass, JMetaType.class, "JMetaType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJMetaType_QualifiedJavaName(), ecorePackage.getEString(), "qualifiedJavaName", null, 1, 1, JMetaType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jTypeRefEClass, JTypeRef.class, "JTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJTypeRef_Type(), this.getJType(), null, "type", null, 1, 1, JTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jParamTypeRefEClass, JParamTypeRef.class, "JParamTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJParamTypeRef_ContainedType(), this.getJTypeRef(), null, "containedType", null, 1, 1, JParamTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jParamNTypeRefEClass, JParamNTypeRef.class, "JParamNTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJParamNTypeRef_Params(), this.getJTypeRef(), null, "params", null, 1, -1, JParamNTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jGenericTypeRefEClass, JGenericTypeRef.class, "JGenericTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJGenericTypeRef_TypeParams(), this.getJTypeRef(), null, "typeParams", null, 1, -1, JGenericTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jArrayTypeRefEClass, JArrayTypeRef.class, "JArrayTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJArrayTypeRef_ContainedType(), this.getJTypeRef(), null, "containedType", null, 1, 1, JArrayTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jClassEClass, JClass.class, "JClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJClass_Extra(), ecorePackage.getEString(), "extra", null, 0, 1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJClass_Pkg(), ecorePackage.getEString(), "pkg", null, 1, 1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_Methods(), this.getJMethod(), null, "methods", null, 0, -1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_Attributes(), this.getJAttribute(), null, "attributes", null, 0, -1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_Implements(), this.getJTypeRef(), null, "implements", null, 0, -1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_Extends_(), this.getJTypeRef(), null, "extends_", null, 0, 1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_Imports(), this.getJType(), null, "imports", null, 0, -1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJClass_This_(), this.getJThis(), null, "this_", null, 1, 1, JClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jThisEClass, JThis.class, "JThis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jAttributeEClass, JAttribute.class, "JAttribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jCommentEClass, JComment.class, "JComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJComment_Value(), ecorePackage.getEString(), "value", null, 1, 1, JComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jBlockEClass, JBlock.class, "JBlock", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJBlock_LocalVars(), this.getJVariableDeclaration(), null, "localVars", null, 0, -1, JBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJBlock_Statements(), this.getJStatement(), null, "statements", null, 0, -1, JBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jMethodEClass, JMethod.class, "JMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJMethod_Name(), ecorePackage.getEString(), "name", null, 1, 1, JMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJMethod_Parameters(), this.getJParameter(), null, "parameters", null, 0, -1, JMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJMethod_ReturnType(), this.getJTypeRef(), null, "returnType", null, 0, 1, JMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJMethod_Throws_(), this.getJTypeRef(), null, "throws_", null, 0, -1, JMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJMethod_Visibility(), this.getVisibility(), "visibility", null, 1, 1, JMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jStatementEClass, JStatement.class, "JStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jReturnEClass, JReturn.class, "JReturn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJReturn_Result(), this.getJExpression(), null, "result", null, 1, 1, JReturn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jLoopEClass, JLoop.class, "JLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJLoop_LoopVar(), this.getJVariableDeclaration(), null, "loopVar", null, 1, 1, JLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jForeachEClass, JForeach.class, "JForeach", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJForeach_Collection(), this.getJExpression(), null, "collection", null, 1, 1, JForeach.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iteratorLoopEClass, IteratorLoop.class, "IteratorLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIteratorLoop_IteratorVar(), this.getJVariableDeclaration(), null, "iteratorVar", null, 1, 1, IteratorLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIteratorLoop_IteratorInit(), this.getJExpression(), null, "iteratorInit", null, 1, 1, IteratorLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jConditionalEClass, JConditional.class, "JConditional", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJConditional_Conditions(), this.getJConditionalBlock(), null, "conditions", null, 1, -1, JConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJConditional_Else(), this.getJConditionalBlock(), null, "else", null, 0, 1, JConditional.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jConditionalBlockEClass, JConditionalBlock.class, "JConditionalBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJConditionalBlock_Expr(), this.getJExpression(), null, "expr", null, 1, 1, JConditionalBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jAssignmentEClass, JAssignment.class, "JAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJAssignment_Declaration(), this.getJVariableDeclaration(), null, "declaration", null, 1, 1, JAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJAssignment_RightPart(), this.getJExpression(), null, "rightPart", null, 1, 1, JAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jTextEClass, JText.class, "JText", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJText_Body(), ecorePackage.getEString(), "body", null, 1, 1, JText.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jExpressionEClass, JExpression.class, "JExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jVarExpEClass, JVarExp.class, "JVarExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJVarExp_Reference(), this.getJVariableDeclaration(), null, "reference", null, 1, 1, JVarExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jTextExpEClass, JTextExp.class, "JTextExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJTextExp_Body(), ecorePackage.getEString(), "body", null, 1, 1, JTextExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jVariableDeclarationEClass, JVariableDeclaration.class, "JVariableDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJVariableDeclaration_Type(), this.getJTypeRef(), null, "type", null, 1, 1, JVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getJVariableDeclaration_Name(), ecorePackage.getEString(), "name", null, 1, 1, JVariableDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lMatchObjectEClass, LMatchObject.class, "LMatchObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLMatchObject_Cases(), this.getLMatchCase(), null, "cases", null, 0, -1, LMatchObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lMatchCaseEClass, LMatchCase.class, "LMatchCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLMatchCase_Predicate(), this.getJMethod(), null, "predicate", null, 1, 1, LMatchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLMatchCase_Obj(), this.getJExpression(), null, "obj", null, 1, 1, LMatchCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jParameterEClass, JParameter.class, "JParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(jClosureEClass, JClosure.class, "JClosure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJClosure_Parameters(), this.getJParameter(), null, "parameters", null, 0, -1, JClosure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jInvokeEClass, JInvoke.class, "JInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJInvoke_Name(), ecorePackage.getEString(), "name", null, 1, 1, JInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJInvoke_Obj(), this.getJExpression(), null, "obj", null, 1, 1, JInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJInvoke_Arguments(), this.getJExpression(), null, "arguments", null, 0, -1, JInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jInvokeStaticEClass, JInvokeStatic.class, "JInvokeStatic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getJInvokeStatic_Name(), ecorePackage.getEString(), "name", null, 1, 1, JInvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJInvokeStatic_Arguments(), this.getJExpression(), null, "arguments", null, 0, -1, JInvokeStatic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jNewObjectEClass, JNewObject.class, "JNewObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJNewObject_TypeRef(), this.getJTypeRef(), null, "typeRef", null, 1, 1, JNewObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getJNewObject_Arguments(), this.getJExpression(), null, "arguments", null, 0, -1, JNewObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(jExprStatementEClass, JExprStatement.class, "JExprStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getJExprStatement_Expr(), this.getJExpression(), null, "expr", null, 1, 1, JExprStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);
		addEEnumLiteral(visibilityEEnum, Visibility.PROTECTED);

		// Create resource
		createResource(eNS_URI);
	}

} //JavagenPackageImpl
