/**
 */
package a2l.tests.bibtex.BibTeX;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.BibTeXFile#getEntries <em>Entries</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getBibTeXFile()
 * @model
 * @generated
 */
public interface BibTeXFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Entries</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.bibtex.BibTeX.BibTeXEntry}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entries</em>' containment reference list.
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getBibTeXFile_Entries()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<BibTeXEntry> getEntries();

} // BibTeXFile
