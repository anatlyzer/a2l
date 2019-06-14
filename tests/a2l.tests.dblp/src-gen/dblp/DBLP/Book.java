/**
 */
package dblp.DBLP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Book#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getYear <em>Year</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getPublisher <em>Publisher</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getVolume <em>Volume</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getSeries <em>Series</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getEdition <em>Edition</em>}</li>
 *   <li>{@link dblp.DBLP.Book#getIsbn <em>Isbn</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends Record {
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
	 * @see dblp.DBLP.DBLPPackage#getBook_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getTitle <em>Title</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getBook_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

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
	 * @see dblp.DBLP.DBLPPackage#getBook_Publisher()
	 * @model
	 * @generated
	 */
	Publisher getPublisher();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getPublisher <em>Publisher</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' reference.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(Publisher value);

	/**
	 * Returns the value of the '<em><b>Month</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Month</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Month</em>' attribute.
	 * @see #setMonth(String)
	 * @see dblp.DBLP.DBLPPackage#getBook_Month()
	 * @model default="0"
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(int)
	 * @see dblp.DBLP.DBLPPackage#getBook_Volume()
	 * @model
	 * @generated
	 */
	int getVolume();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(int value);

	/**
	 * Returns the value of the '<em><b>Series</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Series</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Series</em>' attribute.
	 * @see #setSeries(String)
	 * @see dblp.DBLP.DBLPPackage#getBook_Series()
	 * @model
	 * @generated
	 */
	String getSeries();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getSeries <em>Series</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Series</em>' attribute.
	 * @see #getSeries()
	 * @generated
	 */
	void setSeries(String value);

	/**
	 * Returns the value of the '<em><b>Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edition</em>' attribute.
	 * @see #setEdition(int)
	 * @see dblp.DBLP.DBLPPackage#getBook_Edition()
	 * @model
	 * @generated
	 */
	int getEdition();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getEdition <em>Edition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edition</em>' attribute.
	 * @see #getEdition()
	 * @generated
	 */
	void setEdition(int value);

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
	 * @see dblp.DBLP.DBLPPackage#getBook_Isbn()
	 * @model
	 * @generated
	 */
	String getIsbn();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Book#getIsbn <em>Isbn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Isbn</em>' attribute.
	 * @see #getIsbn()
	 * @generated
	 */
	void setIsbn(String value);

} // Book
