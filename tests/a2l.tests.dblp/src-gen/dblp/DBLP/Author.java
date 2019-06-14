/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Author#getName <em>Name</em>}</li>
 *   <li>{@link dblp.DBLP.Author#getRecords <em>Records</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getAuthor()
 * @model
 * @generated
 */
public interface Author extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see dblp.DBLP.DBLPPackage#getAuthor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Records</b></em>' reference list.
	 * The list contents are of type {@link dblp.DBLP.Record}.
	 * It is bidirectional and its opposite is '{@link dblp.DBLP.Record#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Records</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Records</em>' reference list.
	 * @see dblp.DBLP.DBLPPackage#getAuthor_Records()
	 * @see dblp.DBLP.Record#getAuthors
	 * @model opposite="authors"
	 * @generated
	 */
	EList<Record> getRecords();

} // Author
