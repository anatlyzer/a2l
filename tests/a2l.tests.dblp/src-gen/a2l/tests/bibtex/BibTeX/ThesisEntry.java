/**
 */
package a2l.tests.bibtex.BibTeX;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thesis Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.bibtex.BibTeX.ThesisEntry#getSchool <em>School</em>}</li>
 * </ul>
 *
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getThesisEntry()
 * @model abstract="true"
 * @generated
 */
public interface ThesisEntry extends AuthoredEntry, DatedEntry, TitledEntry {
	/**
	 * Returns the value of the '<em><b>School</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>School</em>' attribute.
	 * @see #setSchool(String)
	 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage#getThesisEntry_School()
	 * @model dataType="a2l.tests.bibtex.PrimitiveTypes.String" required="true" ordered="false"
	 * @generated
	 */
	String getSchool();

	/**
	 * Sets the value of the '{@link a2l.tests.bibtex.BibTeX.ThesisEntry#getSchool <em>School</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>School</em>' attribute.
	 * @see #getSchool()
	 * @generated
	 */
	void setSchool(String value);

} // ThesisEntry
