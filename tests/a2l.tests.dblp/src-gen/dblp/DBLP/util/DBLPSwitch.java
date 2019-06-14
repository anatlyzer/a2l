/**
 */
package dblp.DBLP.util;

import dblp.DBLP.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see dblp.DBLP.DBLPPackage
 * @generated
 */
public class DBLPSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DBLPPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLPSwitch() {
		if (modelPackage == null) {
			modelPackage = DBLPPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DBLPPackage.RECORD: {
				Record record = (Record)theEObject;
				T result = caseRecord(record);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.ARTICLE: {
				Article article = (Article)theEObject;
				T result = caseArticle(article);
				if (result == null) result = caseRecord(article);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.AUTHOR: {
				Author author = (Author)theEObject;
				T result = caseAuthor(author);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.JOURNAL: {
				Journal journal = (Journal)theEObject;
				T result = caseJournal(journal);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.BOOK: {
				Book book = (Book)theEObject;
				T result = caseBook(book);
				if (result == null) result = caseRecord(book);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.IN_COLLECTION: {
				InCollection inCollection = (InCollection)theEObject;
				T result = caseInCollection(inCollection);
				if (result == null) result = caseRecord(inCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.IN_PROCEEDINGS: {
				InProceedings inProceedings = (InProceedings)theEObject;
				T result = caseInProceedings(inProceedings);
				if (result == null) result = caseRecord(inProceedings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.MASTERS_THESIS: {
				MastersThesis mastersThesis = (MastersThesis)theEObject;
				T result = caseMastersThesis(mastersThesis);
				if (result == null) result = caseRecord(mastersThesis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.PROCEEDINGS: {
				Proceedings proceedings = (Proceedings)theEObject;
				T result = caseProceedings(proceedings);
				if (result == null) result = caseRecord(proceedings);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.PH_DTHESIS: {
				PhDThesis phDThesis = (PhDThesis)theEObject;
				T result = casePhDThesis(phDThesis);
				if (result == null) result = caseRecord(phDThesis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.WWW: {
				Www www = (Www)theEObject;
				T result = caseWww(www);
				if (result == null) result = caseRecord(www);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.EDITOR: {
				Editor editor = (Editor)theEObject;
				T result = caseEditor(editor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.ORGANIZATION: {
				Organization organization = (Organization)theEObject;
				T result = caseOrganization(organization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.PUBLISHER: {
				Publisher publisher = (Publisher)theEObject;
				T result = casePublisher(publisher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DBLPPackage.SCHOOL: {
				School school = (School)theEObject;
				T result = caseSchool(school);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Record</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecord(Record object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Article</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Article</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArticle(Article object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Author</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Author</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAuthor(Author object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Journal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Journal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJournal(Journal object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Book</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBook(Book object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInCollection(InCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Proceedings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Proceedings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInProceedings(InProceedings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Masters Thesis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Masters Thesis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMastersThesis(MastersThesis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Proceedings</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Proceedings</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProceedings(Proceedings object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ph DThesis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ph DThesis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhDThesis(PhDThesis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Www</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Www</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWww(Www object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Editor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEditor(Editor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Organization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrganization(Organization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publisher</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publisher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublisher(Publisher object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>School</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>School</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchool(School object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DBLPSwitch
