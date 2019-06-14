/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JClass</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getExtra <em>Extra</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getPkg <em>Pkg</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getMethods <em>Methods</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getImplements <em>Implements</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getExtends_ <em>Extends </em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getImports <em>Imports</em>}</li>
 *   <li>{@link lintra.atlcompiler.javagen.JClass#getThis_ <em>This </em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass()
 * @model
 * @generated
 */
public interface JClass extends JType {
	/**
	 * Returns the value of the '<em><b>Extra</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extra</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extra</em>' attribute.
	 * @see #setExtra(String)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Extra()
	 * @model
	 * @generated
	 */
	String getExtra();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JClass#getExtra <em>Extra</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extra</em>' attribute.
	 * @see #getExtra()
	 * @generated
	 */
	void setExtra(String value);

	/**
	 * Returns the value of the '<em><b>Pkg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pkg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pkg</em>' attribute.
	 * @see #setPkg(String)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Pkg()
	 * @model required="true"
	 * @generated
	 */
	String getPkg();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JClass#getPkg <em>Pkg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkg</em>' attribute.
	 * @see #getPkg()
	 * @generated
	 */
	void setPkg(String value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JMethod}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<JMethod> getMethods();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JAttribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<JAttribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JTypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Implements()
	 * @model containment="true"
	 * @generated
	 */
	EList<JTypeRef> getImplements();

	/**
	 * Returns the value of the '<em><b>Extends </b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends </em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends </em>' containment reference.
	 * @see #setExtends_(JTypeRef)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Extends_()
	 * @model containment="true"
	 * @generated
	 */
	JTypeRef getExtends_();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JClass#getExtends_ <em>Extends </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extends </em>' containment reference.
	 * @see #getExtends_()
	 * @generated
	 */
	void setExtends_(JTypeRef value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_Imports()
	 * @model
	 * @generated
	 */
	EList<JType> getImports();

	/**
	 * Returns the value of the '<em><b>This </b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>This </em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>This </em>' containment reference.
	 * @see #setThis_(JThis)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJClass_This_()
	 * @model containment="true" required="true"
	 * @generated
	 */
	JThis getThis_();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JClass#getThis_ <em>This </em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>This </em>' containment reference.
	 * @see #getThis_()
	 * @generated
	 */
	void setThis_(JThis value);

} // JClass
