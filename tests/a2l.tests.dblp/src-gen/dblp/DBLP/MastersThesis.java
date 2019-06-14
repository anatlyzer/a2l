/**
 */
package dblp.DBLP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Masters Thesis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.MastersThesis#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.MastersThesis#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.MastersThesis#getSchool <em>School</em>}</li>
 *   <li>{@link dblp.DBLP.MastersThesis#getMonth <em>Month</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getMastersThesis()
 * @model
 * @generated
 */
public interface MastersThesis extends Record {
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
	 * @see dblp.DBLP.DBLPPackage#getMastersThesis_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.MastersThesis#getTitle <em>Title</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getMastersThesis_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.MastersThesis#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

	/**
	 * Returns the value of the '<em><b>School</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>School</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>School</em>' reference.
	 * @see #setSchool(School)
	 * @see dblp.DBLP.DBLPPackage#getMastersThesis_School()
	 * @model
	 * @generated
	 */
	School getSchool();

	/**
	 * Sets the value of the '{@link dblp.DBLP.MastersThesis#getSchool <em>School</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>School</em>' reference.
	 * @see #getSchool()
	 * @generated
	 */
	void setSchool(School value);

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
	 * @see dblp.DBLP.DBLPPackage#getMastersThesis_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.MastersThesis#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

} // MastersThesis
