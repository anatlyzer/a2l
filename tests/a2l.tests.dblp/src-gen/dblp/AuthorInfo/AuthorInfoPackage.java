/**
 */
package dblp.AuthorInfo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dblp.AuthorInfo.AuthorInfoFactory
 * @model kind="package"
 * @generated
 */
public interface AuthorInfoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "AuthorInfo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://AuthorInfo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "AuthorInfo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AuthorInfoPackage eINSTANCE = dblp.AuthorInfo.impl.AuthorInfoPackageImpl.init();

	/**
	 * The meta object id for the '{@link dblp.AuthorInfo.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.AuthorInfo.impl.AuthorImpl
	 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Num Of Papers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NUM_OF_PAPERS = 1;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__ACTIVE = 2;

	/**
	 * The feature id for the '<em><b>Publishes In C</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__PUBLISHES_IN_C = 3;

	/**
	 * The feature id for the '<em><b>Coauthor</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__COAUTHOR = 4;

	/**
	 * The feature id for the '<em><b>Publishes In J</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__PUBLISHES_IN_J = 5;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.AuthorInfo.impl.ConferenceImpl <em>Conference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.AuthorInfo.impl.ConferenceImpl
	 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getConference()
	 * @generated
	 */
	int CONFERENCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Conference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Conference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.AuthorInfo.impl.JournalImpl <em>Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.AuthorInfo.impl.JournalImpl
	 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getJournal()
	 * @generated
	 */
	int JOURNAL = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL__NAME = 0;

	/**
	 * The number of structural features of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link dblp.AuthorInfo.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see dblp.AuthorInfo.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link dblp.AuthorInfo.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.AuthorInfo.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the attribute '{@link dblp.AuthorInfo.Author#getNumOfPapers <em>Num Of Papers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Of Papers</em>'.
	 * @see dblp.AuthorInfo.Author#getNumOfPapers()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_NumOfPapers();

	/**
	 * Returns the meta object for the attribute '{@link dblp.AuthorInfo.Author#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see dblp.AuthorInfo.Author#isActive()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Active();

	/**
	 * Returns the meta object for the reference list '{@link dblp.AuthorInfo.Author#getPublishesInC <em>Publishes In C</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Publishes In C</em>'.
	 * @see dblp.AuthorInfo.Author#getPublishesInC()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_PublishesInC();

	/**
	 * Returns the meta object for the reference list '{@link dblp.AuthorInfo.Author#getCoauthor <em>Coauthor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Coauthor</em>'.
	 * @see dblp.AuthorInfo.Author#getCoauthor()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_Coauthor();

	/**
	 * Returns the meta object for the reference list '{@link dblp.AuthorInfo.Author#getPublishesInJ <em>Publishes In J</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Publishes In J</em>'.
	 * @see dblp.AuthorInfo.Author#getPublishesInJ()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_PublishesInJ();

	/**
	 * Returns the meta object for class '{@link dblp.AuthorInfo.Conference <em>Conference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conference</em>'.
	 * @see dblp.AuthorInfo.Conference
	 * @generated
	 */
	EClass getConference();

	/**
	 * Returns the meta object for the attribute '{@link dblp.AuthorInfo.Conference#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.AuthorInfo.Conference#getName()
	 * @see #getConference()
	 * @generated
	 */
	EAttribute getConference_Name();

	/**
	 * Returns the meta object for class '{@link dblp.AuthorInfo.Journal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Journal</em>'.
	 * @see dblp.AuthorInfo.Journal
	 * @generated
	 */
	EClass getJournal();

	/**
	 * Returns the meta object for the attribute '{@link dblp.AuthorInfo.Journal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.AuthorInfo.Journal#getName()
	 * @see #getJournal()
	 * @generated
	 */
	EAttribute getJournal_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AuthorInfoFactory getAuthorInfoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dblp.AuthorInfo.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.AuthorInfo.impl.AuthorImpl
		 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getAuthor()
		 * @generated
		 */
		EClass AUTHOR = eINSTANCE.getAuthor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NAME = eINSTANCE.getAuthor_Name();

		/**
		 * The meta object literal for the '<em><b>Num Of Papers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__NUM_OF_PAPERS = eINSTANCE.getAuthor_NumOfPapers();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AUTHOR__ACTIVE = eINSTANCE.getAuthor_Active();

		/**
		 * The meta object literal for the '<em><b>Publishes In C</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__PUBLISHES_IN_C = eINSTANCE.getAuthor_PublishesInC();

		/**
		 * The meta object literal for the '<em><b>Coauthor</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__COAUTHOR = eINSTANCE.getAuthor_Coauthor();

		/**
		 * The meta object literal for the '<em><b>Publishes In J</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__PUBLISHES_IN_J = eINSTANCE.getAuthor_PublishesInJ();

		/**
		 * The meta object literal for the '{@link dblp.AuthorInfo.impl.ConferenceImpl <em>Conference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.AuthorInfo.impl.ConferenceImpl
		 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getConference()
		 * @generated
		 */
		EClass CONFERENCE = eINSTANCE.getConference();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFERENCE__NAME = eINSTANCE.getConference_Name();

		/**
		 * The meta object literal for the '{@link dblp.AuthorInfo.impl.JournalImpl <em>Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.AuthorInfo.impl.JournalImpl
		 * @see dblp.AuthorInfo.impl.AuthorInfoPackageImpl#getJournal()
		 * @generated
		 */
		EClass JOURNAL = eINSTANCE.getJournal();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JOURNAL__NAME = eINSTANCE.getJournal_Name();

	}

} //AuthorInfoPackage
