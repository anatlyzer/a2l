/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Www</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Www#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.Www#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.Www#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.Www#getMonth <em>Month</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getWww()
 * @model
 * @generated
 */
public interface Www extends Record {
	/**
	 * Returns the value of the '<em><b>Editors</b></em>' reference list.
	 * The list contents are of type {@link dblp.DBLP.Editor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Editors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Editors</em>' reference list.
	 * @see dblp.DBLP.DBLPPackage#getWww_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see dblp.DBLP.DBLPPackage#getWww_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Www#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Year</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Year</em>' attribute.
	 * @see #setYear(int)
	 * @see dblp.DBLP.DBLPPackage#getWww_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Www#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see #setMonth(String)
	 * @see dblp.DBLP.DBLPPackage#getWww_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Www#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

} // Www
