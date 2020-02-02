/**
 */
package a2l.tests.bibtex.BibTeX;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.Book#getPublisher <em>Publisher</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getBook()
 * @model
 * @generated
 */
public interface Book extends AuthoredEntry, DatedEntry, TitledEntry {
	/**
	 * Returns the value of the '<em><b>Publisher</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publisher</em>' attribute.
	 * @see #setPublisher(String)
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getBook_Publisher()
	 * @model dataType="a2l.tests.bibtex.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getPublisher();

	/**
	 * Sets the value of the '{@link a2l.tests.bibtex.BibTeX.Book#getPublisher <em>Publisher</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Publisher</em>' attribute.
	 * @see #getPublisher()
	 * @generated
	 */
	void setPublisher(String value);

} // Book
