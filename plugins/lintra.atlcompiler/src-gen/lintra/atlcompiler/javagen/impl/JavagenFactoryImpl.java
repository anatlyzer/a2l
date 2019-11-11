/**
 */
package lintra.atlcompiler.javagen.impl;

import lintra.atlcompiler.javagen.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class JavagenFactoryImpl extends EFactoryImpl implements JavagenFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JavagenFactory init() {
		try {
			JavagenFactory theJavagenFactory = (JavagenFactory)EPackage.Registry.INSTANCE.getEFactory(JavagenPackage.eNS_URI);
			if (theJavagenFactory != null) {
				return theJavagenFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JavagenFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavagenFactoryImpl() {
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
			case JavagenPackage.JAVA_GEN_MODEL: return createJavaGenModel();
			case JavagenPackage.JLIB_TYPE: return createJLibType();
			case JavagenPackage.JMETA_TYPE: return createJMetaType();
			case JavagenPackage.JTYPE_REF: return createJTypeRef();
			case JavagenPackage.JPARAM_TYPE_REF: return createJParamTypeRef();
			case JavagenPackage.JPARAM_NTYPE_REF: return createJParamNTypeRef();
			case JavagenPackage.JGENERIC_TYPE_REF: return createJGenericTypeRef();
			case JavagenPackage.JARRAY_TYPE_REF: return createJArrayTypeRef();
			case JavagenPackage.JCLASS: return createJClass();
			case JavagenPackage.JTHIS: return createJThis();
			case JavagenPackage.JATTRIBUTE: return createJAttribute();
			case JavagenPackage.JCOMMENT: return createJComment();
			case JavagenPackage.JMETHOD: return createJMethod();
			case JavagenPackage.JRETURN: return createJReturn();
			case JavagenPackage.JLOOP: return createJLoop();
			case JavagenPackage.JFOREACH: return createJForeach();
			case JavagenPackage.ITERATOR_LOOP: return createIteratorLoop();
			case JavagenPackage.JCONDITIONAL: return createJConditional();
			case JavagenPackage.JCONDITIONAL_BLOCK: return createJConditionalBlock();
			case JavagenPackage.JASSIGNMENT: return createJAssignment();
			case JavagenPackage.JTEXT: return createJText();
			case JavagenPackage.JVAR_EXP: return createJVarExp();
			case JavagenPackage.JTEXT_EXP: return createJTextExp();
			case JavagenPackage.JVARIABLE_DECLARATION: return createJVariableDeclaration();
			case JavagenPackage.LMATCH_OBJECT: return createLMatchObject();
			case JavagenPackage.LMATCH_CASE: return createLMatchCase();
			case JavagenPackage.JPARAMETER: return createJParameter();
			case JavagenPackage.JCLOSURE: return createJClosure();
			case JavagenPackage.JINVOKE: return createJInvoke();
			case JavagenPackage.JINVOKE_STATIC: return createJInvokeStatic();
			case JavagenPackage.JNEW_OBJECT: return createJNewObject();
			case JavagenPackage.JEXPR_STATEMENT: return createJExprStatement();
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
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JavagenPackage.VISIBILITY:
				return createVisibilityFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JavagenPackage.VISIBILITY:
				return convertVisibilityToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavaGenModel createJavaGenModel() {
		JavaGenModelImpl javaGenModel = new JavaGenModelImpl();
		return javaGenModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JLibType createJLibType() {
		JLibTypeImpl jLibType = new JLibTypeImpl();
		return jLibType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JMetaType createJMetaType() {
		JMetaTypeImpl jMetaType = new JMetaTypeImpl();
		return jMetaType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JTypeRef createJTypeRef() {
		JTypeRefImpl jTypeRef = new JTypeRefImpl();
		return jTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JParamTypeRef createJParamTypeRef() {
		JParamTypeRefImpl jParamTypeRef = new JParamTypeRefImpl();
		return jParamTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JParamNTypeRef createJParamNTypeRef() {
		JParamNTypeRefImpl jParamNTypeRef = new JParamNTypeRefImpl();
		return jParamNTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JGenericTypeRef createJGenericTypeRef() {
		JGenericTypeRefImpl jGenericTypeRef = new JGenericTypeRefImpl();
		return jGenericTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JArrayTypeRef createJArrayTypeRef() {
		JArrayTypeRefImpl jArrayTypeRef = new JArrayTypeRefImpl();
		return jArrayTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JClass createJClass() {
		JClassImpl jClass = new JClassImpl();
		return jClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JThis createJThis() {
		JThisImpl jThis = new JThisImpl();
		return jThis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JAttribute createJAttribute() {
		JAttributeImpl jAttribute = new JAttributeImpl();
		return jAttribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JComment createJComment() {
		JCommentImpl jComment = new JCommentImpl();
		return jComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JMethod createJMethod() {
		JMethodImpl jMethod = new JMethodImpl();
		return jMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JReturn createJReturn() {
		JReturnImpl jReturn = new JReturnImpl();
		return jReturn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JLoop createJLoop() {
		JLoopImpl jLoop = new JLoopImpl();
		return jLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JForeach createJForeach() {
		JForeachImpl jForeach = new JForeachImpl();
		return jForeach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IteratorLoop createIteratorLoop() {
		IteratorLoopImpl iteratorLoop = new IteratorLoopImpl();
		return iteratorLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JConditional createJConditional() {
		JConditionalImpl jConditional = new JConditionalImpl();
		return jConditional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JConditionalBlock createJConditionalBlock() {
		JConditionalBlockImpl jConditionalBlock = new JConditionalBlockImpl();
		return jConditionalBlock;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JAssignment createJAssignment() {
		JAssignmentImpl jAssignment = new JAssignmentImpl();
		return jAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JText createJText() {
		JTextImpl jText = new JTextImpl();
		return jText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JVarExp createJVarExp() {
		JVarExpImpl jVarExp = new JVarExpImpl();
		return jVarExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JTextExp createJTextExp() {
		JTextExpImpl jTextExp = new JTextExpImpl();
		return jTextExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JVariableDeclaration createJVariableDeclaration() {
		JVariableDeclarationImpl jVariableDeclaration = new JVariableDeclarationImpl();
		return jVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LMatchObject createLMatchObject() {
		LMatchObjectImpl lMatchObject = new LMatchObjectImpl();
		return lMatchObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LMatchCase createLMatchCase() {
		LMatchCaseImpl lMatchCase = new LMatchCaseImpl();
		return lMatchCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JParameter createJParameter() {
		JParameterImpl jParameter = new JParameterImpl();
		return jParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JClosure createJClosure() {
		JClosureImpl jClosure = new JClosureImpl();
		return jClosure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JInvoke createJInvoke() {
		JInvokeImpl jInvoke = new JInvokeImpl();
		return jInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JInvokeStatic createJInvokeStatic() {
		JInvokeStaticImpl jInvokeStatic = new JInvokeStaticImpl();
		return jInvokeStatic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JNewObject createJNewObject() {
		JNewObjectImpl jNewObject = new JNewObjectImpl();
		return jNewObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JExprStatement createJExprStatement() {
		JExprStatementImpl jExprStatement = new JExprStatementImpl();
		return jExprStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Visibility createVisibilityFromString(EDataType eDataType, String initialValue) {
		Visibility result = Visibility.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVisibilityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public JavagenPackage getJavagenPackage() {
		return (JavagenPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JavagenPackage getPackage() {
		return JavagenPackage.eINSTANCE;
	}

} //JavagenFactoryImpl
