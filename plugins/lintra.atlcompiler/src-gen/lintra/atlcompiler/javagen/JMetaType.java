/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JMeta Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JMetaType#getQualifiedJavaName <em>Qualified Java Name</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMetaType()
 * @model
 * @generated
 */
public interface JMetaType extends JType {

	/**
	 * Returns the value of the '<em><b>Qualified Java Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Java Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Java Name</em>' attribute.
	 * @see #setQualifiedJavaName(String)
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJMetaType_QualifiedJavaName()
	 * @model required="true"
	 * @generated
	 */
	String getQualifiedJavaName();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JMetaType#getQualifiedJavaName <em>Qualified Java Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualified Java Name</em>' attribute.
	 * @see #getQualifiedJavaName()
	 * @generated
	 */
	void setQualifiedJavaName(String value);
} // JMetaType
