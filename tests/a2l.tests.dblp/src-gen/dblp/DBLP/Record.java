/**
 */
package dblp.DBLP;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link dblp.DBLP.Record#getEe <em>Ee</em>}</li>
 *   <li>{@link dblp.DBLP.Record#getUrl <em>Url</em>}</li>
 *   <li>{@link dblp.DBLP.Record#getKey <em>Key</em>}</li>
 *   <li>{@link dblp.DBLP.Record#getAuthors <em>Authors</em>}</li>
 *   <li>{@link dblp.DBLP.Record#getMdate <em>Mdate</em>}</li>
 * </ul>
 *
 * @see dblp.DBLP.DBLPPackage#getRecord()
 * @model abstract="true"
 * @generated
 */
public interface Record extends EObject {
	/**
	 * Returns the value of the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ee</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ee</em>' attribute.
	 * @see #setEe(String)
	 * @see dblp.DBLP.DBLPPackage#getRecord_Ee()
	 * @model
	 * @generated
	 */
	String getEe();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Record#getEe <em>Ee</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ee</em>' attribute.
	 * @see #getEe()
	 * @generated
	 */
	void setEe(String value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see dblp.DBLP.DBLPPackage#getRecord_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Record#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see dblp.DBLP.DBLPPackage#getRecord_Key()
	 * @model
	 * @generated
	 */
	String getKey();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Record#getKey <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Returns the value of the '<em><b>Authors</b></em>' reference list.
	 * The list contents are of type {@link dblp.DBLP.Author}.
	 * It is bidirectional and its opposite is '{@link dblp.DBLP.Author#getRecords <em>Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Authors</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Authors</em>' reference list.
	 * @see dblp.DBLP.DBLPPackage#getRecord_Authors()
	 * @see dblp.DBLP.Author#getRecords
	 * @model opposite="records"
	 * @generated
	 */
	EList<Author> getAuthors();

	/**
	 * Returns the value of the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mdate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mdate</em>' attribute.
	 * @see #setMdate(String)
	 * @see dblp.DBLP.DBLPPackage#getRecord_Mdate()
	 * @model
	 * @generated
	 */
	String getMdate();

	/**
	 * Sets the value of the '{@link dblp.DBLP.Record#getMdate <em>Mdate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mdate</em>' attribute.
	 * @see #getMdate()
	 * @generated
	 */
	void setMdate(String value);

} // Record
