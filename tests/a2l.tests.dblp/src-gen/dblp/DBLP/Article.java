/**
 */
package dblp.DBLP;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Article#getTitle <em>Title</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getFromPage <em>From Page</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getToPage <em>To Page</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getNumber <em>Number</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getJournal <em>Journal</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getVolume <em>Volume</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getMonth <em>Month</em>}</li>
 *   <li>{@link dblp.DBLP.Article#getYear <em>Year</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getArticle()
 * @model
 * @generated
 */
public interface Article extends Record {
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
	 * @see dblp.DBLP.DBLPPackage#getArticle_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getArticle_FromPage()
	 * @model
	 * @generated
	 */
	int getFromPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getFromPage <em>From Page</em>}' attribute.
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
	 * @see dblp.DBLP.DBLPPackage#getArticle_ToPage()
	 * @model
	 * @generated
	 */
	int getToPage();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getToPage <em>To Page</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Page</em>' attribute.
	 * @see #getToPage()
	 * @generated
	 */
	void setToPage(int value);

	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(int)
	 * @see dblp.DBLP.DBLPPackage#getArticle_Number()
	 * @model
	 * @generated
	 */
	int getNumber();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(int value);

	/**
	 * Returns the value of the '<em><b>Journal</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link dblp.DBLP.Journal#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Journal</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal</em>' reference.
	 * @see #setJournal(Journal)
	 * @see dblp.DBLP.DBLPPackage#getArticle_Journal()
	 * @see dblp.DBLP.Journal#getArticles
	 * @model opposite="articles"
	 * @generated
	 */
	Journal getJournal();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getJournal <em>Journal</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal</em>' reference.
	 * @see #getJournal()
	 * @generated
	 */
	void setJournal(Journal value);

	/**
	 * Returns the value of the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Volume</em>' attribute.
	 * @see #setVolume(String)
	 * @see dblp.DBLP.DBLPPackage#getArticle_Volume()
	 * @model
	 * @generated
	 */
	String getVolume();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getVolume <em>Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Volume</em>' attribute.
	 * @see #getVolume()
	 * @generated
	 */
	void setVolume(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getArticle_Month()
	 * @model
	 * @generated
	 */
	String getMonth();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getMonth <em>Month</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Month</em>' attribute.
	 * @see #getMonth()
	 * @generated
	 */
	void setMonth(String value);

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
	 * @see dblp.DBLP.DBLPPackage#getArticle_Year()
	 * @model
	 * @generated
	 */
	int getYear();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Article#getYear <em>Year</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Year</em>' attribute.
	 * @see #getYear()
	 * @generated
	 */
	void setYear(int value);

} // Article
