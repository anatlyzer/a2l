/**
 */
package a2l.tests.bibtex.BibTeX;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Authored Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.AuthoredEntry#getAuthors <em>Authors</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getAuthoredEntry()
 * @model abstract="true"
 * @generated
 */
public interface AuthoredEntry extends BibTeXEntry {
	/**
	 * Returns the value of the '<em><b>Authors</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.bibtex.BibTeX.Author}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' containment reference list.
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getAuthoredEntry_Authors()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Author> getAuthors();

} // AuthoredEntry
