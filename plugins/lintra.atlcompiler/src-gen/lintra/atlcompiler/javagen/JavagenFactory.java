/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see lintra.atlcompiler.javagen.JavagenPackage
 * @generated
 */
public interface JavagenFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	JavagenFactory eINSTANCE = lintra.atlcompiler.javagen.impl.JavagenFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Java Gen Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Gen Model</em>'.
	 * @generated
	 */
	JavaGenModel createJavaGenModel();

	/**
	 * Returns a new object of class '<em>JLib Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JLib Type</em>'.
	 * @generated
	 */
	JLibType createJLibType();

	/**
	 * Returns a new object of class '<em>JMeta Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMeta Type</em>'.
	 * @generated
	 */
	JMetaType createJMetaType();

	/**
	 * Returns a new object of class '<em>JType Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JType Ref</em>'.
	 * @generated
	 */
	JTypeRef createJTypeRef();

	/**
	 * Returns a new object of class '<em>JParam Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JParam Type Ref</em>'.
	 * @generated
	 */
	JParamTypeRef createJParamTypeRef();

	/**
	 * Returns a new object of class '<em>JParam NType Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JParam NType Ref</em>'.
	 * @generated
	 */
	JParamNTypeRef createJParamNTypeRef();

	/**
	 * Returns a new object of class '<em>JGeneric Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JGeneric Type Ref</em>'.
	 * @generated
	 */
	JGenericTypeRef createJGenericTypeRef();

	/**
	 * Returns a new object of class '<em>JArray Type Ref</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JArray Type Ref</em>'.
	 * @generated
	 */
	JArrayTypeRef createJArrayTypeRef();

	/**
	 * Returns a new object of class '<em>JClass</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JClass</em>'.
	 * @generated
	 */
	JClass createJClass();

	/**
	 * Returns a new object of class '<em>JThis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JThis</em>'.
	 * @generated
	 */
	JThis createJThis();

	/**
	 * Returns a new object of class '<em>JAttribute</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JAttribute</em>'.
	 * @generated
	 */
	JAttribute createJAttribute();

	/**
	 * Returns a new object of class '<em>JComment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JComment</em>'.
	 * @generated
	 */
	JComment createJComment();

	/**
	 * Returns a new object of class '<em>JMethod</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JMethod</em>'.
	 * @generated
	 */
	JMethod createJMethod();

	/**
	 * Returns a new object of class '<em>JReturn</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JReturn</em>'.
	 * @generated
	 */
	JReturn createJReturn();

	/**
	 * Returns a new object of class '<em>JLoop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JLoop</em>'.
	 * @generated
	 */
	JLoop createJLoop();

	/**
	 * Returns a new object of class '<em>JForeach</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JForeach</em>'.
	 * @generated
	 */
	JForeach createJForeach();

	/**
	 * Returns a new object of class '<em>Iterator Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterator Loop</em>'.
	 * @generated
	 */
	IteratorLoop createIteratorLoop();

	/**
	 * Returns a new object of class '<em>JConditional</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JConditional</em>'.
	 * @generated
	 */
	JConditional createJConditional();

	/**
	 * Returns a new object of class '<em>JConditional Block</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JConditional Block</em>'.
	 * @generated
	 */
	JConditionalBlock createJConditionalBlock();

	/**
	 * Returns a new object of class '<em>JAssignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JAssignment</em>'.
	 * @generated
	 */
	JAssignment createJAssignment();

	/**
	 * Returns a new object of class '<em>JText</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JText</em>'.
	 * @generated
	 */
	JText createJText();

	/**
	 * Returns a new object of class '<em>JVar Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JVar Exp</em>'.
	 * @generated
	 */
	JVarExp createJVarExp();

	/**
	 * Returns a new object of class '<em>JText Exp</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JText Exp</em>'.
	 * @generated
	 */
	JTextExp createJTextExp();

	/**
	 * Returns a new object of class '<em>JVariable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JVariable Declaration</em>'.
	 * @generated
	 */
	JVariableDeclaration createJVariableDeclaration();

	/**
	 * Returns a new object of class '<em>LMatch Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LMatch Object</em>'.
	 * @generated
	 */
	LMatchObject createLMatchObject();

	/**
	 * Returns a new object of class '<em>LMatch Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>LMatch Case</em>'.
	 * @generated
	 */
	LMatchCase createLMatchCase();

	/**
	 * Returns a new object of class '<em>JParameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JParameter</em>'.
	 * @generated
	 */
	JParameter createJParameter();

	/**
	 * Returns a new object of class '<em>JClosure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JClosure</em>'.
	 * @generated
	 */
	JClosure createJClosure();

	/**
	 * Returns a new object of class '<em>JInvoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JInvoke</em>'.
	 * @generated
	 */
	JInvoke createJInvoke();

	/**
	 * Returns a new object of class '<em>JInvoke Static</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JInvoke Static</em>'.
	 * @generated
	 */
	JInvokeStatic createJInvokeStatic();

	/**
	 * Returns a new object of class '<em>JNew Object</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JNew Object</em>'.
	 * @generated
	 */
	JNewObject createJNewObject();

	/**
	 * Returns a new object of class '<em>JExpr Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>JExpr Statement</em>'.
	 * @generated
	 */
	JExprStatement createJExprStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	JavagenPackage getJavagenPackage();

} //JavagenFactory
