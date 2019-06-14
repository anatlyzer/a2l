/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.InCollection#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getBookTitle <em>Book Title</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getEditors <em>Editors</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getSponsoredBy <em>Sponsored By</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.InCollection#getMonth <em>Month</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getInCollection()
 * @model
 * @generated
 */
public interface InCollection extends Record {
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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Book Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Book Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Book Title</em>' attribute.
	 * @see #setBookTitle(String)
	 * @see dblp.DBLP.DBLPPackage#getInCollection_BookTitle()
	 * @model
	 * @generated
	 */
	String getBookTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getBookTitle <em>Book Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Book Title</em>' attribute.
	 * @see #getBookTitle()
	 * @generated
	 */
	void setBookTitle(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getYear <em>Year</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_Editors()
	 * @model
	 * @generated
	 */
	EList<Editor> getEditors();

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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_FromPage()
	 * @model
	 * @generated
	 */
	int getFromPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getFromPage <em>From Page</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_ToPage()
	 * @model
	 * @generated
	 */
	int getToPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getToPage <em>To Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Page</em>' attribute.
	 * @see #getToPage()
	 * @generated
	 */
	void setToPage(int value);

	/**
	 * Returns the value of the '<em><b>Sponsored By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sponsored By</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sponsored By</em>' reference.
	 * @see #setSponsoredBy(Organization)
	 * @see dblp.DBLP.DBLPPackage#getInCollection_SponsoredBy()
	 * @model
	 * @generated
	 */
	Organization getSponsoredBy();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getSponsoredBy <em>Sponsored By</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sponsored By</em>' reference.
	 * @see #getSponsoredBy()
	 * @generated
	 */
	void setSponsoredBy(Organization value);

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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_Publisher()
	 * @model
	 * @generated
	 */
	Publisher getPublisher();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(Publisher value);

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
	 * @see dblp.DBLP.DBLPPackage#getInCollection_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.InCollection#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

} // InCollection
