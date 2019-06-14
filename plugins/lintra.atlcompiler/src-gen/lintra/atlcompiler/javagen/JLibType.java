/**
 */
package lintra.atlcompiler.javagen;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JLib Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JLibType#getPkg <em>Pkg</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJLibType()
 * @model
 * @generated
 */
public interface JLibType extends JType {
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
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJLibType_Pkg()
	 * @model required="true"
	 * @generated
	 */
	String getPkg();

	/**
	 * Sets the value of the '{@link lintra.atlcompiler.javagen.JLibType#getPkg <em>Pkg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pkg</em>' attribute.
	 * @see #getPkg()
	 * @generated
	 */
	void setPkg(String value);

} // JLibType
