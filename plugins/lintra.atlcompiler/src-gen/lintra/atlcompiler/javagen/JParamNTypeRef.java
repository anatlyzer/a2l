/**
 */
package lintra.atlcompiler.javagen;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JParam NType Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link lintra.atlcompiler.javagen.JParamNTypeRef#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @see lintra.atlcompiler.javagen.JavagenPackage#getJParamNTypeRef()
 * @model
 * @generated
 */
public interface JParamNTypeRef extends JTypeRef {
	/**
	 * Returns the value of the '<em><b>Params</b></em>' containment reference list.
	 * The list contents are of type {@link lintra.atlcompiler.javagen.JTypeRef}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Params</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Params</em>' containment reference list.
	 * @see lintra.atlcompiler.javagen.JavagenPackage#getJParamNTypeRef_Params()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<JTypeRef> getParams();

} // JParamNTypeRef
