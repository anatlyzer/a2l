/**
 */
package lintra.atlcompiler.javagen.util;

import lintra.atlcompiler.javagen.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see lintra.atlcompiler.javagen.JavagenPackage
 * @generated
 */
public class JavagenAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JavagenPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavagenAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JavagenPackage.eINSTANCE;
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
	protected JavagenSwitch<Adapter> modelSwitch =
		new JavagenSwitch<Adapter>() {
			@Override
			public Adapter caseJavaGenModel(JavaGenModel object) {
				return createJavaGenModelAdapter();
			}
			@Override
			public Adapter caseJType(JType object) {
				return createJTypeAdapter();
			}
			@Override
			public Adapter caseJLibType(JLibType object) {
				return createJLibTypeAdapter();
			}
			@Override
			public Adapter caseJMetaType(JMetaType object) {
				return createJMetaTypeAdapter();
			}
			@Override
			public Adapter caseJTypeRef(JTypeRef object) {
				return createJTypeRefAdapter();
			}
			@Override
			public Adapter caseJParamTypeRef(JParamTypeRef object) {
				return createJParamTypeRefAdapter();
			}
			@Override
			public Adapter caseJParamNTypeRef(JParamNTypeRef object) {
				return createJParamNTypeRefAdapter();
			}
			@Override
			public Adapter caseJGenericTypeRef(JGenericTypeRef object) {
				return createJGenericTypeRefAdapter();
			}
			@Override
			public Adapter caseJArrayTypeRef(JArrayTypeRef object) {
				return createJArrayTypeRefAdapter();
			}
			@Override
			public Adapter caseJClass(JClass object) {
				return createJClassAdapter();
			}
			@Override
			public Adapter caseJThis(JThis object) {
				return createJThisAdapter();
			}
			@Override
			public Adapter caseJAttribute(JAttribute object) {
				return createJAttributeAdapter();
			}
			@Override
			public Adapter caseJComment(JComment object) {
				return createJCommentAdapter();
			}
			@Override
			public Adapter caseJBlock(JBlock object) {
				return createJBlockAdapter();
			}
			@Override
			public Adapter caseJMethod(JMethod object) {
				return createJMethodAdapter();
			}
			@Override
			public Adapter caseJStatement(JStatement object) {
				return createJStatementAdapter();
			}
			@Override
			public Adapter caseJReturn(JReturn object) {
				return createJReturnAdapter();
			}
			@Override
			public Adapter caseJLoop(JLoop object) {
				return createJLoopAdapter();
			}
			@Override
			public Adapter caseJForeach(JForeach object) {
				return createJForeachAdapter();
			}
			@Override
			public Adapter caseIteratorLoop(IteratorLoop object) {
				return createIteratorLoopAdapter();
			}
			@Override
			public Adapter caseJConditional(JConditional object) {
				return createJConditionalAdapter();
			}
			@Override
			public Adapter caseJConditionalBlock(JConditionalBlock object) {
				return createJConditionalBlockAdapter();
			}
			@Override
			public Adapter caseJAssignment(JAssignment object) {
				return createJAssignmentAdapter();
			}
			@Override
			public Adapter caseJText(JText object) {
				return createJTextAdapter();
			}
			@Override
			public Adapter caseJExpression(JExpression object) {
				return createJExpressionAdapter();
			}
			@Override
			public Adapter caseJVarExp(JVarExp object) {
				return createJVarExpAdapter();
			}
			@Override
			public Adapter caseJTextExp(JTextExp object) {
				return createJTextExpAdapter();
			}
			@Override
			public Adapter caseJVariableDeclaration(JVariableDeclaration object) {
				return createJVariableDeclarationAdapter();
			}
			@Override
			public Adapter caseLMatchObject(LMatchObject object) {
				return createLMatchObjectAdapter();
			}
			@Override
			public Adapter caseLMatchCase(LMatchCase object) {
				return createLMatchCaseAdapter();
			}
			@Override
			public Adapter caseJParameter(JParameter object) {
				return createJParameterAdapter();
			}
			@Override
			public Adapter caseJClosure(JClosure object) {
				return createJClosureAdapter();
			}
			@Override
			public Adapter caseJInvoke(JInvoke object) {
				return createJInvokeAdapter();
			}
			@Override
			public Adapter caseJInvokeStatic(JInvokeStatic object) {
				return createJInvokeStaticAdapter();
			}
			@Override
			public Adapter caseJNewObject(JNewObject object) {
				return createJNewObjectAdapter();
			}
			@Override
			public Adapter caseJExprStatement(JExprStatement object) {
				return createJExprStatementAdapter();
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
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JavaGenModel <em>Java Gen Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JavaGenModel
	 * @generated
	 */
	public Adapter createJavaGenModelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JType <em>JType</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JType
	 * @generated
	 */
	public Adapter createJTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JLibType <em>JLib Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JLibType
	 * @generated
	 */
	public Adapter createJLibTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JMetaType <em>JMeta Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JMetaType
	 * @generated
	 */
	public Adapter createJMetaTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JTypeRef <em>JType Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JTypeRef
	 * @generated
	 */
	public Adapter createJTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JParamTypeRef <em>JParam Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JParamTypeRef
	 * @generated
	 */
	public Adapter createJParamTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JParamNTypeRef <em>JParam NType Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JParamNTypeRef
	 * @generated
	 */
	public Adapter createJParamNTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JGenericTypeRef <em>JGeneric Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JGenericTypeRef
	 * @generated
	 */
	public Adapter createJGenericTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JArrayTypeRef <em>JArray Type Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JArrayTypeRef
	 * @generated
	 */
	public Adapter createJArrayTypeRefAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JClass <em>JClass</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JClass
	 * @generated
	 */
	public Adapter createJClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JThis <em>JThis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JThis
	 * @generated
	 */
	public Adapter createJThisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JAttribute <em>JAttribute</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JAttribute
	 * @generated
	 */
	public Adapter createJAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JComment <em>JComment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JComment
	 * @generated
	 */
	public Adapter createJCommentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JBlock <em>JBlock</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JBlock
	 * @generated
	 */
	public Adapter createJBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JMethod <em>JMethod</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JMethod
	 * @generated
	 */
	public Adapter createJMethodAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JStatement <em>JStatement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JStatement
	 * @generated
	 */
	public Adapter createJStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JReturn <em>JReturn</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JReturn
	 * @generated
	 */
	public Adapter createJReturnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JLoop <em>JLoop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JLoop
	 * @generated
	 */
	public Adapter createJLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JForeach <em>JForeach</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JForeach
	 * @generated
	 */
	public Adapter createJForeachAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.IteratorLoop <em>Iterator Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.IteratorLoop
	 * @generated
	 */
	public Adapter createIteratorLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JConditional <em>JConditional</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JConditional
	 * @generated
	 */
	public Adapter createJConditionalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JConditionalBlock <em>JConditional Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JConditionalBlock
	 * @generated
	 */
	public Adapter createJConditionalBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JAssignment <em>JAssignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JAssignment
	 * @generated
	 */
	public Adapter createJAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JText <em>JText</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JText
	 * @generated
	 */
	public Adapter createJTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JExpression <em>JExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JExpression
	 * @generated
	 */
	public Adapter createJExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JVarExp <em>JVar Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JVarExp
	 * @generated
	 */
	public Adapter createJVarExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JTextExp <em>JText Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JTextExp
	 * @generated
	 */
	public Adapter createJTextExpAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JVariableDeclaration <em>JVariable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JVariableDeclaration
	 * @generated
	 */
	public Adapter createJVariableDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.LMatchObject <em>LMatch Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.LMatchObject
	 * @generated
	 */
	public Adapter createLMatchObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.LMatchCase <em>LMatch Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.LMatchCase
	 * @generated
	 */
	public Adapter createLMatchCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JParameter <em>JParameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JParameter
	 * @generated
	 */
	public Adapter createJParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JClosure <em>JClosure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JClosure
	 * @generated
	 */
	public Adapter createJClosureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JInvoke <em>JInvoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JInvoke
	 * @generated
	 */
	public Adapter createJInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JInvokeStatic <em>JInvoke Static</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JInvokeStatic
	 * @generated
	 */
	public Adapter createJInvokeStaticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JNewObject <em>JNew Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JNewObject
	 * @generated
	 */
	public Adapter createJNewObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link lintra.atlcompiler.javagen.JExprStatement <em>JExpr Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see lintra.atlcompiler.javagen.JExprStatement
	 * @generated
	 */
	public Adapter createJExprStatementAdapter() {
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

} //JavagenAdapterFactory
