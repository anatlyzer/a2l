/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Proceedings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.InProceedings#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getBootitle <em>Bootitle</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getOrganization <em>Organization</em>}</li>
 *   <li>{@link dblp.DBLP.InProceedings#getPublisher <em>Publisher</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getInProceedings()
 * @model
 * @generated
 */
public interface InProceedings extends Record {
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
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Bootitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bootitle</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bootitle</em>' attribute.
	 * @see #setBootitle(String)
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Bootitle()
	 * @model
	 * @generated
	 */
	String getBootitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getBootitle <em>Bootitle</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bootitle</em>' attribute.
	 * @see #getBootitle()
	 * @generated
	 */
	void setBootitle(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

	/**
	 * Returns the value of the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Page</em>' attribute.
	 * @see #setFromPage(int)
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_FromPage()
	 * @model
	 * @generated
	 */
	int getFromPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getFromPage <em>From Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Page</em>' attribute.
	 * @see #getFromPage()
	 * @generated
	 */
	void setFromPage(int value);

	/**
	 * Returns the value of the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Page</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Page</em>' attribute.
	 * @see #setToPage(int)
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_ToPage()
	 * @model
	 * @generated
	 */
	int getToPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getToPage <em>To Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Page</em>' attribute.
	 * @see #getToPage()
	 * @generated
	 */
	void setToPage(int value);

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
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

	/**
	 * Returns the value of the '<em><b>Organization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Organization</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Organization</em>' reference.
	 * @see #setOrganization(Organization)
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Organization()
	 * @model
	 * @generated
	 */
	Organization getOrganization();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getOrganization <em>Organization</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Organization</em>' reference.
	 * @see #getOrganization()
	 * @generated
	 */
	void setOrganization(Organization value);

	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publisher</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publisher</em>' reference.
	 * @see #setPublisher(Publisher)
	 * @see dblp.DBLP.DBLPPackage#getInProceedings_Publisher()
	 * @model
	 * @generated
	 */
	Publisher getPublisher();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InProceedings#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(Publisher value);

} // InProceedings
