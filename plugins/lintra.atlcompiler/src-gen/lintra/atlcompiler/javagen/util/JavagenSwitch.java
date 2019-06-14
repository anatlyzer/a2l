/**
 */
package lintra.atlcompiler.javagen.util;

import lintra.atlcompiler.javagen.*;

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
 * @see lintra.atlcompiler.javagen.JavagenPackage
 * @generated
 */
public class JavagenSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JavagenPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavagenSwitch() {
		if (modelPackage == null) {
			modelPackage = JavagenPackage.eINSTANCE;
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
			case JavagenPackage.JAVA_GEN_MODEL: {
				JavaGenModel javaGenModel = (JavaGenModel)theEObject;
				T result = caseJavaGenModel(javaGenModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JTYPE: {
				JType jType = (JType)theEObject;
				T result = caseJType(jType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JLIB_TYPE: {
				JLibType jLibType = (JLibType)theEObject;
				T result = caseJLibType(jLibType);
				if (result == null) result = caseJType(jLibType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JMETA_TYPE: {
				JMetaType jMetaType = (JMetaType)theEObject;
				T result = caseJMetaType(jMetaType);
				if (result == null) result = caseJType(jMetaType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JTYPE_REF: {
				JTypeRef jTypeRef = (JTypeRef)theEObject;
				T result = caseJTypeRef(jTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JPARAM_TYPE_REF: {
				JParamTypeRef jParamTypeRef = (JParamTypeRef)theEObject;
				T result = caseJParamTypeRef(jParamTypeRef);
				if (result == null) result = caseJTypeRef(jParamTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JPARAM_NTYPE_REF: {
				JParamNTypeRef jParamNTypeRef = (JParamNTypeRef)theEObject;
				T result = caseJParamNTypeRef(jParamNTypeRef);
				if (result == null) result = caseJTypeRef(jParamNTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JGENERIC_TYPE_REF: {
				JGenericTypeRef jGenericTypeRef = (JGenericTypeRef)theEObject;
				T result = caseJGenericTypeRef(jGenericTypeRef);
				if (result == null) result = caseJTypeRef(jGenericTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JARRAY_TYPE_REF: {
				JArrayTypeRef jArrayTypeRef = (JArrayTypeRef)theEObject;
				T result = caseJArrayTypeRef(jArrayTypeRef);
				if (result == null) result = caseJTypeRef(jArrayTypeRef);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JCLASS: {
				JClass jClass = (JClass)theEObject;
				T result = caseJClass(jClass);
				if (result == null) result = caseJType(jClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JTHIS: {
				JThis jThis = (JThis)theEObject;
				T result = caseJThis(jThis);
				if (result == null) result = caseJVariableDeclaration(jThis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JATTRIBUTE: {
				JAttribute jAttribute = (JAttribute)theEObject;
				T result = caseJAttribute(jAttribute);
				if (result == null) result = caseJVariableDeclaration(jAttribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JCOMMENT: {
				JComment jComment = (JComment)theEObject;
				T result = caseJComment(jComment);
				if (result == null) result = caseJStatement(jComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JBLOCK: {
				JBlock jBlock = (JBlock)theEObject;
				T result = caseJBlock(jBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JMETHOD: {
				JMethod jMethod = (JMethod)theEObject;
				T result = caseJMethod(jMethod);
				if (result == null) result = caseJBlock(jMethod);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JSTATEMENT: {
				JStatement jStatement = (JStatement)theEObject;
				T result = caseJStatement(jStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JRETURN: {
				JReturn jReturn = (JReturn)theEObject;
				T result = caseJReturn(jReturn);
				if (result == null) result = caseJStatement(jReturn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JLOOP: {
				JLoop jLoop = (JLoop)theEObject;
				T result = caseJLoop(jLoop);
				if (result == null) result = caseJStatement(jLoop);
				if (result == null) result = caseJBlock(jLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JFOREACH: {
				JForeach jForeach = (JForeach)theEObject;
				T result = caseJForeach(jForeach);
				if (result == null) result = caseJLoop(jForeach);
				if (result == null) result = caseJStatement(jForeach);
				if (result == null) result = caseJBlock(jForeach);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.ITERATOR_LOOP: {
				IteratorLoop iteratorLoop = (IteratorLoop)theEObject;
				T result = caseIteratorLoop(iteratorLoop);
				if (result == null) result = caseJLoop(iteratorLoop);
				if (result == null) result = caseJStatement(iteratorLoop);
				if (result == null) result = caseJBlock(iteratorLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JCONDITIONAL: {
				JConditional jConditional = (JConditional)theEObject;
				T result = caseJConditional(jConditional);
				if (result == null) result = caseJStatement(jConditional);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JCONDITIONAL_BLOCK: {
				JConditionalBlock jConditionalBlock = (JConditionalBlock)theEObject;
				T result = caseJConditionalBlock(jConditionalBlock);
				if (result == null) result = caseJBlock(jConditionalBlock);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JASSIGNMENT: {
				JAssignment jAssignment = (JAssignment)theEObject;
				T result = caseJAssignment(jAssignment);
				if (result == null) result = caseJText(jAssignment);
				if (result == null) result = caseJStatement(jAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JTEXT: {
				JText jText = (JText)theEObject;
				T result = caseJText(jText);
				if (result == null) result = caseJStatement(jText);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JEXPRESSION: {
				JExpression jExpression = (JExpression)theEObject;
				T result = caseJExpression(jExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JVAR_EXP: {
				JVarExp jVarExp = (JVarExp)theEObject;
				T result = caseJVarExp(jVarExp);
				if (result == null) result = caseJExpression(jVarExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JTEXT_EXP: {
				JTextExp jTextExp = (JTextExp)theEObject;
				T result = caseJTextExp(jTextExp);
				if (result == null) result = caseJExpression(jTextExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JVARIABLE_DECLARATION: {
				JVariableDeclaration jVariableDeclaration = (JVariableDeclaration)theEObject;
				T result = caseJVariableDeclaration(jVariableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.LMATCH_OBJECT: {
				LMatchObject lMatchObject = (LMatchObject)theEObject;
				T result = caseLMatchObject(lMatchObject);
				if (result == null) result = caseJStatement(lMatchObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.LMATCH_CASE: {
				LMatchCase lMatchCase = (LMatchCase)theEObject;
				T result = caseLMatchCase(lMatchCase);
				if (result == null) result = caseJBlock(lMatchCase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JPARAMETER: {
				JParameter jParameter = (JParameter)theEObject;
				T result = caseJParameter(jParameter);
				if (result == null) result = caseJVariableDeclaration(jParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JCLOSURE: {
				JClosure jClosure = (JClosure)theEObject;
				T result = caseJClosure(jClosure);
				if (result == null) result = caseJExpression(jClosure);
				if (result == null) result = caseJBlock(jClosure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JINVOKE: {
				JInvoke jInvoke = (JInvoke)theEObject;
				T result = caseJInvoke(jInvoke);
				if (result == null) result = caseJExpression(jInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JINVOKE_STATIC: {
				JInvokeStatic jInvokeStatic = (JInvokeStatic)theEObject;
				T result = caseJInvokeStatic(jInvokeStatic);
				if (result == null) result = caseJExpression(jInvokeStatic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JNEW_OBJECT: {
				JNewObject jNewObject = (JNewObject)theEObject;
				T result = caseJNewObject(jNewObject);
				if (result == null) result = caseJExpression(jNewObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JavagenPackage.JEXPR_STATEMENT: {
				JExprStatement jExprStatement = (JExprStatement)theEObject;
				T result = caseJExprStatement(jExprStatement);
				if (result == null) result = caseJStatement(jExprStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Java Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Java Gen Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJavaGenModel(JavaGenModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JType</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JType</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJType(JType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JLib Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JLib Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJLibType(JLibType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMeta Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMeta Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJMetaType(JMetaType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JType Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JType Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJTypeRef(JTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JParam Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JParam Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJParamTypeRef(JParamTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JParam NType Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JParam NType Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJParamNTypeRef(JParamNTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JGeneric Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JGeneric Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJGenericTypeRef(JGenericTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JArray Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JArray Type Ref</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJArrayTypeRef(JArrayTypeRef object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJClass(JClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JThis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JThis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJThis(JThis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JAttribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJAttribute(JAttribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JComment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JComment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJComment(JComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JBlock</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JBlock</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJBlock(JBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JMethod</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JMethod</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJMethod(JMethod object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JStatement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JStatement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJStatement(JStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JReturn</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JReturn</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJReturn(JReturn object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JLoop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JLoop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJLoop(JLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JForeach</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JForeach</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJForeach(JForeach object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorLoop(IteratorLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JConditional</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JConditional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJConditional(JConditional object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JConditional Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JConditional Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJConditionalBlock(JConditionalBlock object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JAssignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJAssignment(JAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JText</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JText</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJText(JText object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JExpression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JExpression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJExpression(JExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JVar Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JVar Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJVarExp(JVarExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JText Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JText Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJTextExp(JTextExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JVariable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJVariableDeclaration(JVariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LMatch Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LMatch Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLMatchObject(LMatchObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>LMatch Case</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>LMatch Case</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLMatchCase(LMatchCase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JParameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JParameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJParameter(JParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JClosure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JClosure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJClosure(JClosure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JInvoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JInvoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJInvoke(JInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JInvoke Static</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JInvoke Static</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJInvokeStatic(JInvokeStatic object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JNew Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JNew Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJNewObject(JNewObject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JExpr Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JExpr Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJExprStatement(JExprStatement object) {
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

} //JavagenSwitch
