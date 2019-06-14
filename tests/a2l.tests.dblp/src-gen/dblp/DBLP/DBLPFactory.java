/**
 */
package dblp.DBLP;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dblp.DBLP.DBLPPackage
 * @generated
 */
public interface DBLPFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DBLPFactory eINSTANCE = dblp.DBLP.impl.DBLPFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Article</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Article</em>'.
	 * @generated
	 */
	Article createArticle();

	/**
	 * Returns a new object of class '<em>Author</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Author</em>'.
	 * @generated
	 */
	Author createAuthor();

	/**
	 * Returns a new object of class '<em>Journal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Journal</em>'.
	 * @generated
	 */
	Journal createJournal();

	/**
	 * Returns a new object of class '<em>Book</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Book</em>'.
	 * @generated
	 */
	Book createBook();

	/**
	 * Returns a new object of class '<em>In Collection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Collection</em>'.
	 * @generated
	 */
	InCollection createInCollection();

	/**
	 * Returns a new object of class '<em>In Proceedings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>In Proceedings</em>'.
	 * @generated
	 */
	InProceedings createInProceedings();

	/**
	 * Returns a new object of class '<em>Masters Thesis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Masters Thesis</em>'.
	 * @generated
	 */
	MastersThesis createMastersThesis();

	/**
	 * Returns a new object of class '<em>Proceedings</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Proceedings</em>'.
	 * @generated
	 */
	Proceedings createProceedings();

	/**
	 * Returns a new object of class '<em>Ph DThesis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ph DThesis</em>'.
	 * @generated
	 */
	PhDThesis createPhDThesis();

	/**
	 * Returns a new object of class '<em>Www</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Www</em>'.
	 * @generated
	 */
	Www createWww();

	/**
	 * Returns a new object of class '<em>Editor</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Editor</em>'.
	 * @generated
	 */
	Editor createEditor();

	/**
	 * Returns a new object of class '<em>Organization</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Organization</em>'.
	 * @generated
	 */
	Organization createOrganization();

	/**
	 * Returns a new object of class '<em>Publisher</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publisher</em>'.
	 * @generated
	 */
	Publisher createPublisher();

	/**
	 * Returns a new object of class '<em>School</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>School</em>'.
	 * @generated
	 */
	School createSchool();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DBLPPackage getDBLPPackage();

} //DBLPFactory
