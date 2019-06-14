/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Proceedings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Proceedings#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getSponsoredBy <em>Sponsored By</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.Proceedings#getIsbn <em>Isbn</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getProceedings()
 * @model
 * @generated
 */
public interface Proceedings extends Record {
	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Title()
	 * @model default=""
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Proceedings#getTitle <em>Title</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Proceedings#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

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
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

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
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Publisher()
	 * @model
	 * @generated
	 */
	Publisher getPublisher();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Proceedings#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(Publisher value);

	/**
	 * Returns the value of the '<em><b>Sponsored By</b></em>' reference list.
	 * The list contents are of type {@link dblp.DBLP.Organization}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sponsored By</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sponsored By</em>' reference list.
	 * @see dblp.DBLP.DBLPPackage#getProceedings_SponsoredBy()
	 * @model
	 * @generated
	 */
	EList<Organization> getSponsoredBy();

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
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Proceedings#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

	/**
	 * Returns the value of the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Isbn</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Isbn</em>' attribute.
	 * @see #setIsbn(String)
	 * @see dblp.DBLP.DBLPPackage#getProceedings_Isbn()
	 * @model
	 * @generated
	 */
	String getIsbn();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Proceedings#getIsbn <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isbn</em>' attribute.
	 * @see #getIsbn()
	 * @generated
	 */
	void setIsbn(String value);

} // Proceedings
