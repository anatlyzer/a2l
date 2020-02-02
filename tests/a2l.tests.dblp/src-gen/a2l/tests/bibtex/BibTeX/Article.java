/**
 */
package a2l.tests.bibtex.BibTeX;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Article</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.Article#getJournal <em>Journal</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getArticle()
 * @model
 * @generated
 */
public interface Article extends AuthoredEntry, DatedEntry, TitledEntry {
	/**
	 * Returns the value of the '<em><b>Journal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Journal</em>' attribute.
	 * @see #setJournal(String)
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getArticle_Journal()
	 * @model dataType="a2l.tests.bibtex.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getJournal();

	/**
	 * Sets the value of the '{@link a2l.tests.bibtex.BibTeX.Article#getJournal <em>Journal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Journal</em>' attribute.
	 * @see #getJournal()
	 * @generated
	 */
	void setJournal(String value);

} // Article
