/**
 */
package dblp.AuthorInfo;

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
 *   <li>{@link dblp.AuthorInfo.Author#getName <em>Name</em>}</li>
 *   <li>{@link dblp.AuthorInfo.Author#getNumOfPapers <em>Num Of Papers</em>}</li>
 *   <li>{@link dblp.AuthorInfo.Author#isActive <em>Active</em>}</li>
 *   <li>{@link dblp.AuthorInfo.Author#getPublishesInC <em>Publishes In C</em>}</li>
 *   <li>{@link dblp.AuthorInfo.Author#getCoauthor <em>Coauthor</em>}</li>
 *   <li>{@link dblp.AuthorInfo.Author#getPublishesInJ <em>Publishes In J</em>}</li>
 * </ul>
 *
 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor()
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
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link dblp.AuthorInfo.Author#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Num Of Papers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Of Papers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Of Papers</em>' attribute.
	 * @see #setNumOfPapers(int)
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_NumOfPapers()
	 * @model
	 * @generated
	 */
	int getNumOfPapers();

	/**
	 * Sets the value of the '{@link dblp.AuthorInfo.Author#getNumOfPapers <em>Num Of Papers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Of Papers</em>' attribute.
	 * @see #getNumOfPapers()
	 * @generated
	 */
	void setNumOfPapers(int value);

	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_Active()
	 * @model
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link dblp.AuthorInfo.Author#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Publishes In C</b></em>' reference list.
	 * The list contents are of type {@link dblp.AuthorInfo.Conference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publishes In C</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publishes In C</em>' reference list.
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_PublishesInC()
	 * @model
	 * @generated
	 */
	EList<Conference> getPublishesInC();

	/**
	 * Returns the value of the '<em><b>Coauthor</b></em>' reference list.
	 * The list contents are of type {@link dblp.AuthorInfo.Author}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Coauthor</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Coauthor</em>' reference list.
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_Coauthor()
	 * @model
	 * @generated
	 */
	EList<Author> getCoauthor();

	/**
	 * Returns the value of the '<em><b>Publishes In J</b></em>' reference list.
	 * The list contents are of type {@link dblp.AuthorInfo.Journal}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Publishes In J</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Publishes In J</em>' reference list.
	 * @see dblp.AuthorInfo.AuthorInfoPackage#getAuthor_PublishesInJ()
	 * @model
	 * @generated
	 */
	EList<Journal> getPublishesInJ();

} // Author
