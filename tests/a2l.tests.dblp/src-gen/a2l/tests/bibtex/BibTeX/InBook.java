/**
 */
package a2l.tests.bibtex.BibTeX;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>In Book</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.InBook#getChapter <em>Chapter</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getInBook()
 * @model
 * @generated
 */
public interface InBook extends Book {
	/**
	 * Returns the value of the '<em><b>Chapter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chapter</em>' attribute.
	 * @see #setChapter(Integer)
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getInBook_Chapter()
	 * @model dataType="a2l.tests.bibtex.PrimitiveTypes.Integer" required="true" ordered="false"
	 * @generated
	 */
	Integer getChapter();

	/**
	 * Sets the value of the '{@link a2l.tests.bibtex.BibTeX.InBook#getChapter <em>Chapter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Chapter</em>' attribute.
	 * @see #getChapter()
	 * @generated
	 */
	void setChapter(Integer value);

} // InBook
