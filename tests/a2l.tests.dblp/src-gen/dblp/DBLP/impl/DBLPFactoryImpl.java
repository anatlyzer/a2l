/**
 */
package dblp.DBLP.impl;

import dblp.DBLP.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DBLPFactoryImpl extends EFactoryImpl implements DBLPFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DBLPFactory init() {
		try {
			DBLPFactory theDBLPFactory = (DBLPFactory)EPackage.Registry.INSTANCE.getEFactory(DBLPPackage.eNS_URI);
			if (theDBLPFactory != null) {
				return theDBLPFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DBLPFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLPFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DBLPPackage.ARTICLE: return createArticle();
			case DBLPPackage.AUTHOR: return createAuthor();
			case DBLPPackage.JOURNAL: return createJournal();
			case DBLPPackage.BOOK: return createBook();
			case DBLPPackage.IN_COLLECTION: return createInCollection();
			case DBLPPackage.IN_PROCEEDINGS: return createInProceedings();
			case DBLPPackage.MASTERS_THESIS: return createMastersThesis();
			case DBLPPackage.PROCEEDINGS: return createProceedings();
			case DBLPPackage.PH_DTHESIS: return createPhDThesis();
			case DBLPPackage.WWW: return createWww();
			case DBLPPackage.EDITOR: return createEditor();
			case DBLPPackage.ORGANIZATION: return createOrganization();
			case DBLPPackage.PUBLISHER: return createPublisher();
			case DBLPPackage.SCHOOL: return createSchool();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Article createArticle() {
		ArticleImpl article = new ArticleImpl();
		return article;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Author createAuthor() {
		AuthorImpl author = new AuthorImpl();
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Journal createJournal() {
		JournalImpl journal = new JournalImpl();
		return journal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Book createBook() {
		BookImpl book = new BookImpl();
		return book;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InCollection createInCollection() {
		InCollectionImpl inCollection = new InCollectionImpl();
		return inCollection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InProceedings createInProceedings() {
		InProceedingsImpl inProceedings = new InProceedingsImpl();
		return inProceedings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MastersThesis createMastersThesis() {
		MastersThesisImpl mastersThesis = new MastersThesisImpl();
		return mastersThesis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Proceedings createProceedings() {
		ProceedingsImpl proceedings = new ProceedingsImpl();
		return proceedings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PhDThesis createPhDThesis() {
		PhDThesisImpl phDThesis = new PhDThesisImpl();
		return phDThesis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Www createWww() {
		WwwImpl www = new WwwImpl();
		return www;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Editor createEditor() {
		EditorImpl editor = new EditorImpl();
		return editor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Organization createOrganization() {
		OrganizationImpl organization = new OrganizationImpl();
		return organization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Publisher createPublisher() {
		PublisherImpl publisher = new PublisherImpl();
		return publisher;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public School createSchool() {
		SchoolImpl school = new SchoolImpl();
		return school;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLPPackage getDBLPPackage() {
		return (DBLPPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DBLPPackage getPackage() {
		return DBLPPackage.eINSTANCE;
	}

} //DBLPFactoryImpl
