/**
 */
package dblp.DBLP;

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
 * @see dblp.DBLP.DBLPFactory
 * @model kind="package"
 * @generated
 */
public interface DBLPPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DBLP";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://dblp.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DBLP";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DBLPPackage eINSTANCE = dblp.DBLP.impl.DBLPPackageImpl.init();

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.RecordImpl <em>Record</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.RecordImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getRecord()
	 * @generated
	 */
	int RECORD = 0;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__EE = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__URL = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__KEY = 2;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__AUTHORS = 3;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD__MDATE = 4;

	/**
	 * The number of structural features of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Record</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECORD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.ArticleImpl <em>Article</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.ArticleImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getArticle()
	 * @generated
	 */
	int ARTICLE = 1;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__FROM_PAGE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__TO_PAGE = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__NUMBER = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Journal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__JOURNAL = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__VOLUME = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__MONTH = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE__YEAR = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_FEATURE_COUNT = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Article</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARTICLE_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.AuthorImpl <em>Author</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.AuthorImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getAuthor()
	 * @generated
	 */
	int AUTHOR = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Records</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR__RECORDS = 1;

	/**
	 * The number of structural features of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Author</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTHOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.JournalImpl <em>Journal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.JournalImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getJournal()
	 * @generated
	 */
	int JOURNAL = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Articles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL__ARTICLES = 1;

	/**
	 * The number of structural features of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Journal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOURNAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.BookImpl <em>Book</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.BookImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getBook()
	 * @generated
	 */
	int BOOK = 4;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__PUBLISHER = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__VOLUME = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Series</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__SERIES = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Edition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__EDITION = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK__ISBN = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_FEATURE_COUNT = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of operations of the '<em>Book</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOK_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.InCollectionImpl <em>In Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.InCollectionImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getInCollection()
	 * @generated
	 */
	int IN_COLLECTION = 5;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Book Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__BOOK_TITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__EDITORS = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__FROM_PAGE = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__TO_PAGE = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sponsored By</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__SPONSORED_BY = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__PUBLISHER = RECORD_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION__MONTH = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>In Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION_FEATURE_COUNT = RECORD_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>In Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_COLLECTION_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.InProceedingsImpl <em>In Proceedings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.InProceedingsImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getInProceedings()
	 * @generated
	 */
	int IN_PROCEEDINGS = 6;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bootitle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__BOOTITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>From Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__FROM_PAGE = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>To Page</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__TO_PAGE = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__MONTH = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__EDITORS = RECORD_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Organization</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__ORGANIZATION = RECORD_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS__PUBLISHER = RECORD_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>In Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>In Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_PROCEEDINGS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.MastersThesisImpl <em>Masters Thesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.MastersThesisImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getMastersThesis()
	 * @generated
	 */
	int MASTERS_THESIS = 7;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>School</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__SCHOOL = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Masters Thesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Masters Thesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MASTERS_THESIS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.ProceedingsImpl <em>Proceedings</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.ProceedingsImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getProceedings()
	 * @generated
	 */
	int PROCEEDINGS = 8;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__EDITORS = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Publisher</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__PUBLISHER = RECORD_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sponsored By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__SPONSORED_BY = RECORD_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__MONTH = RECORD_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Isbn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS__ISBN = RECORD_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Proceedings</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCEEDINGS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.PhDThesisImpl <em>Ph DThesis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.PhDThesisImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getPhDThesis()
	 * @generated
	 */
	int PH_DTHESIS = 9;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__TITLE = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__YEAR = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__MONTH = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>School</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS__SCHOOL = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Ph DThesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Ph DThesis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PH_DTHESIS_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.WwwImpl <em>Www</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.WwwImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getWww()
	 * @generated
	 */
	int WWW = 10;

	/**
	 * The feature id for the '<em><b>Ee</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__EE = RECORD__EE;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__URL = RECORD__URL;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__KEY = RECORD__KEY;

	/**
	 * The feature id for the '<em><b>Authors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__AUTHORS = RECORD__AUTHORS;

	/**
	 * The feature id for the '<em><b>Mdate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__MDATE = RECORD__MDATE;

	/**
	 * The feature id for the '<em><b>Editors</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__EDITORS = RECORD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__TITLE = RECORD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Year</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__YEAR = RECORD_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Month</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW__MONTH = RECORD_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Www</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW_FEATURE_COUNT = RECORD_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Www</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WWW_OPERATION_COUNT = RECORD_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.EditorImpl <em>Editor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.EditorImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getEditor()
	 * @generated
	 */
	int EDITOR = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR__NAME = 0;

	/**
	 * The number of structural features of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Editor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDITOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.OrganizationImpl <em>Organization</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.OrganizationImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getOrganization()
	 * @generated
	 */
	int ORGANIZATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Organization</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORGANIZATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.PublisherImpl <em>Publisher</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.PublisherImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getPublisher()
	 * @generated
	 */
	int PUBLISHER = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>Publisher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Publisher</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISHER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link dblp.DBLP.impl.SchoolImpl <em>School</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dblp.DBLP.impl.SchoolImpl
	 * @see dblp.DBLP.impl.DBLPPackageImpl#getSchool()
	 * @generated
	 */
	int SCHOOL = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL__NAME = 0;

	/**
	 * The feature id for the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL__ADDRESS = 1;

	/**
	 * The number of structural features of the '<em>School</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>School</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHOOL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Record <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Record</em>'.
	 * @see dblp.DBLP.Record
	 * @generated
	 */
	EClass getRecord();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Record#getEe <em>Ee</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ee</em>'.
	 * @see dblp.DBLP.Record#getEe()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Ee();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Record#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see dblp.DBLP.Record#getUrl()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Url();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Record#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see dblp.DBLP.Record#getKey()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Key();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Record#getAuthors <em>Authors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Authors</em>'.
	 * @see dblp.DBLP.Record#getAuthors()
	 * @see #getRecord()
	 * @generated
	 */
	EReference getRecord_Authors();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Record#getMdate <em>Mdate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mdate</em>'.
	 * @see dblp.DBLP.Record#getMdate()
	 * @see #getRecord()
	 * @generated
	 */
	EAttribute getRecord_Mdate();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Article</em>'.
	 * @see dblp.DBLP.Article
	 * @generated
	 */
	EClass getArticle();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.Article#getTitle()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see dblp.DBLP.Article#getFromPage()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see dblp.DBLP.Article#getToPage()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_ToPage();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see dblp.DBLP.Article#getNumber()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Number();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.Article#getJournal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Journal</em>'.
	 * @see dblp.DBLP.Article#getJournal()
	 * @see #getArticle()
	 * @generated
	 */
	EReference getArticle_Journal();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see dblp.DBLP.Article#getVolume()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Volume();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.Article#getMonth()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Month();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Article#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.Article#getYear()
	 * @see #getArticle()
	 * @generated
	 */
	EAttribute getArticle_Year();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Author</em>'.
	 * @see dblp.DBLP.Author
	 * @generated
	 */
	EClass getAuthor();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Author#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.Author#getName()
	 * @see #getAuthor()
	 * @generated
	 */
	EAttribute getAuthor_Name();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Author#getRecords <em>Records</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Records</em>'.
	 * @see dblp.DBLP.Author#getRecords()
	 * @see #getAuthor()
	 * @generated
	 */
	EReference getAuthor_Records();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Journal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Journal</em>'.
	 * @see dblp.DBLP.Journal
	 * @generated
	 */
	EClass getJournal();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Journal#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.Journal#getName()
	 * @see #getJournal()
	 * @generated
	 */
	EAttribute getJournal_Name();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Journal#getArticles <em>Articles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Articles</em>'.
	 * @see dblp.DBLP.Journal#getArticles()
	 * @see #getJournal()
	 * @generated
	 */
	EReference getJournal_Articles();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Book</em>'.
	 * @see dblp.DBLP.Book
	 * @generated
	 */
	EClass getBook();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.Book#getTitle()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.Book#getYear()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Year();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.Book#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see dblp.DBLP.Book#getPublisher()
	 * @see #getBook()
	 * @generated
	 */
	EReference getBook_Publisher();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.Book#getMonth()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Month();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see dblp.DBLP.Book#getVolume()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Volume();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getSeries <em>Series</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Series</em>'.
	 * @see dblp.DBLP.Book#getSeries()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Series();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getEdition <em>Edition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edition</em>'.
	 * @see dblp.DBLP.Book#getEdition()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Edition();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Book#getIsbn <em>Isbn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isbn</em>'.
	 * @see dblp.DBLP.Book#getIsbn()
	 * @see #getBook()
	 * @generated
	 */
	EAttribute getBook_Isbn();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.InCollection <em>In Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Collection</em>'.
	 * @see dblp.DBLP.InCollection
	 * @generated
	 */
	EClass getInCollection();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.InCollection#getTitle()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getBookTitle <em>Book Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Book Title</em>'.
	 * @see dblp.DBLP.InCollection#getBookTitle()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_BookTitle();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.InCollection#getYear()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Year();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.InCollection#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see dblp.DBLP.InCollection#getEditors()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_Editors();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see dblp.DBLP.InCollection#getFromPage()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see dblp.DBLP.InCollection#getToPage()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_ToPage();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.InCollection#getSponsoredBy <em>Sponsored By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Sponsored By</em>'.
	 * @see dblp.DBLP.InCollection#getSponsoredBy()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_SponsoredBy();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.InCollection#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see dblp.DBLP.InCollection#getPublisher()
	 * @see #getInCollection()
	 * @generated
	 */
	EReference getInCollection_Publisher();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InCollection#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.InCollection#getMonth()
	 * @see #getInCollection()
	 * @generated
	 */
	EAttribute getInCollection_Month();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.InProceedings <em>In Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Proceedings</em>'.
	 * @see dblp.DBLP.InProceedings
	 * @generated
	 */
	EClass getInProceedings();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.InProceedings#getTitle()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getBootitle <em>Bootitle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bootitle</em>'.
	 * @see dblp.DBLP.InProceedings#getBootitle()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Bootitle();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.InProceedings#getYear()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Year();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getFromPage <em>From Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From Page</em>'.
	 * @see dblp.DBLP.InProceedings#getFromPage()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_FromPage();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getToPage <em>To Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To Page</em>'.
	 * @see dblp.DBLP.InProceedings#getToPage()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_ToPage();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.InProceedings#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.InProceedings#getMonth()
	 * @see #getInProceedings()
	 * @generated
	 */
	EAttribute getInProceedings_Month();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.InProceedings#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see dblp.DBLP.InProceedings#getEditors()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Editors();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.InProceedings#getOrganization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Organization</em>'.
	 * @see dblp.DBLP.InProceedings#getOrganization()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Organization();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.InProceedings#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see dblp.DBLP.InProceedings#getPublisher()
	 * @see #getInProceedings()
	 * @generated
	 */
	EReference getInProceedings_Publisher();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.MastersThesis <em>Masters Thesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Masters Thesis</em>'.
	 * @see dblp.DBLP.MastersThesis
	 * @generated
	 */
	EClass getMastersThesis();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.MastersThesis#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.MastersThesis#getTitle()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.MastersThesis#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.MastersThesis#getYear()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Year();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.MastersThesis#getSchool <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>School</em>'.
	 * @see dblp.DBLP.MastersThesis#getSchool()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EReference getMastersThesis_School();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.MastersThesis#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.MastersThesis#getMonth()
	 * @see #getMastersThesis()
	 * @generated
	 */
	EAttribute getMastersThesis_Month();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Proceedings <em>Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Proceedings</em>'.
	 * @see dblp.DBLP.Proceedings
	 * @generated
	 */
	EClass getProceedings();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Proceedings#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.Proceedings#getTitle()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Proceedings#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.Proceedings#getYear()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Year();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Proceedings#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see dblp.DBLP.Proceedings#getEditors()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_Editors();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.Proceedings#getPublisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Publisher</em>'.
	 * @see dblp.DBLP.Proceedings#getPublisher()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_Publisher();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Proceedings#getSponsoredBy <em>Sponsored By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sponsored By</em>'.
	 * @see dblp.DBLP.Proceedings#getSponsoredBy()
	 * @see #getProceedings()
	 * @generated
	 */
	EReference getProceedings_SponsoredBy();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Proceedings#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.Proceedings#getMonth()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Month();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Proceedings#getIsbn <em>Isbn</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Isbn</em>'.
	 * @see dblp.DBLP.Proceedings#getIsbn()
	 * @see #getProceedings()
	 * @generated
	 */
	EAttribute getProceedings_Isbn();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.PhDThesis <em>Ph DThesis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ph DThesis</em>'.
	 * @see dblp.DBLP.PhDThesis
	 * @generated
	 */
	EClass getPhDThesis();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.PhDThesis#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.PhDThesis#getTitle()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.PhDThesis#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.PhDThesis#getYear()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Year();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.PhDThesis#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.PhDThesis#getMonth()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EAttribute getPhDThesis_Month();

	/**
	 * Returns the meta object for the reference '{@link dblp.DBLP.PhDThesis#getSchool <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>School</em>'.
	 * @see dblp.DBLP.PhDThesis#getSchool()
	 * @see #getPhDThesis()
	 * @generated
	 */
	EReference getPhDThesis_School();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Www <em>Www</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Www</em>'.
	 * @see dblp.DBLP.Www
	 * @generated
	 */
	EClass getWww();

	/**
	 * Returns the meta object for the reference list '{@link dblp.DBLP.Www#getEditors <em>Editors</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Editors</em>'.
	 * @see dblp.DBLP.Www#getEditors()
	 * @see #getWww()
	 * @generated
	 */
	EReference getWww_Editors();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Www#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see dblp.DBLP.Www#getTitle()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Title();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Www#getYear <em>Year</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Year</em>'.
	 * @see dblp.DBLP.Www#getYear()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Year();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Www#getMonth <em>Month</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Month</em>'.
	 * @see dblp.DBLP.Www#getMonth()
	 * @see #getWww()
	 * @generated
	 */
	EAttribute getWww_Month();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Editor</em>'.
	 * @see dblp.DBLP.Editor
	 * @generated
	 */
	EClass getEditor();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Editor#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.Editor#getName()
	 * @see #getEditor()
	 * @generated
	 */
	EAttribute getEditor_Name();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Organization</em>'.
	 * @see dblp.DBLP.Organization
	 * @generated
	 */
	EClass getOrganization();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Organization#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.Organization#getName()
	 * @see #getOrganization()
	 * @generated
	 */
	EAttribute getOrganization_Name();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.Publisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publisher</em>'.
	 * @see dblp.DBLP.Publisher
	 * @generated
	 */
	EClass getPublisher();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Publisher#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.Publisher#getName()
	 * @see #getPublisher()
	 * @generated
	 */
	EAttribute getPublisher_Name();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.Publisher#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see dblp.DBLP.Publisher#getAddress()
	 * @see #getPublisher()
	 * @generated
	 */
	EAttribute getPublisher_Address();

	/**
	 * Returns the meta object for class '{@link dblp.DBLP.School <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>School</em>'.
	 * @see dblp.DBLP.School
	 * @generated
	 */
	EClass getSchool();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.School#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dblp.DBLP.School#getName()
	 * @see #getSchool()
	 * @generated
	 */
	EAttribute getSchool_Name();

	/**
	 * Returns the meta object for the attribute '{@link dblp.DBLP.School#getAddress <em>Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Address</em>'.
	 * @see dblp.DBLP.School#getAddress()
	 * @see #getSchool()
	 * @generated
	 */
	EAttribute getSchool_Address();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DBLPFactory getDBLPFactory();

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
		 * The meta object literal for the '{@link dblp.DBLP.impl.RecordImpl <em>Record</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.RecordImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getRecord()
		 * @generated
		 */
		EClass RECORD = eINSTANCE.getRecord();

		/**
		 * The meta object literal for the '<em><b>Ee</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__EE = eINSTANCE.getRecord_Ee();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__URL = eINSTANCE.getRecord_Url();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__KEY = eINSTANCE.getRecord_Key();

		/**
		 * The meta object literal for the '<em><b>Authors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RECORD__AUTHORS = eINSTANCE.getRecord_Authors();

		/**
		 * The meta object literal for the '<em><b>Mdate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECORD__MDATE = eINSTANCE.getRecord_Mdate();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.ArticleImpl <em>Article</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.ArticleImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getArticle()
		 * @generated
		 */
		EClass ARTICLE = eINSTANCE.getArticle();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__TITLE = eINSTANCE.getArticle_Title();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__FROM_PAGE = eINSTANCE.getArticle_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__TO_PAGE = eINSTANCE.getArticle_ToPage();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__NUMBER = eINSTANCE.getArticle_Number();

		/**
		 * The meta object literal for the '<em><b>Journal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARTICLE__JOURNAL = eINSTANCE.getArticle_Journal();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__VOLUME = eINSTANCE.getArticle_Volume();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__MONTH = eINSTANCE.getArticle_Month();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARTICLE__YEAR = eINSTANCE.getArticle_Year();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.AuthorImpl <em>Author</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.AuthorImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getAuthor()
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
		 * The meta object literal for the '<em><b>Records</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTHOR__RECORDS = eINSTANCE.getAuthor_Records();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.JournalImpl <em>Journal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.JournalImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getJournal()
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

		/**
		 * The meta object literal for the '<em><b>Articles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOURNAL__ARTICLES = eINSTANCE.getJournal_Articles();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.BookImpl <em>Book</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.BookImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getBook()
		 * @generated
		 */
		EClass BOOK = eINSTANCE.getBook();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__TITLE = eINSTANCE.getBook_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__YEAR = eINSTANCE.getBook_Year();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOK__PUBLISHER = eINSTANCE.getBook_Publisher();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__MONTH = eINSTANCE.getBook_Month();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__VOLUME = eINSTANCE.getBook_Volume();

		/**
		 * The meta object literal for the '<em><b>Series</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__SERIES = eINSTANCE.getBook_Series();

		/**
		 * The meta object literal for the '<em><b>Edition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__EDITION = eINSTANCE.getBook_Edition();

		/**
		 * The meta object literal for the '<em><b>Isbn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOK__ISBN = eINSTANCE.getBook_Isbn();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.InCollectionImpl <em>In Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.InCollectionImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getInCollection()
		 * @generated
		 */
		EClass IN_COLLECTION = eINSTANCE.getInCollection();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__TITLE = eINSTANCE.getInCollection_Title();

		/**
		 * The meta object literal for the '<em><b>Book Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__BOOK_TITLE = eINSTANCE.getInCollection_BookTitle();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__YEAR = eINSTANCE.getInCollection_Year();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__EDITORS = eINSTANCE.getInCollection_Editors();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__FROM_PAGE = eINSTANCE.getInCollection_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__TO_PAGE = eINSTANCE.getInCollection_ToPage();

		/**
		 * The meta object literal for the '<em><b>Sponsored By</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__SPONSORED_BY = eINSTANCE.getInCollection_SponsoredBy();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_COLLECTION__PUBLISHER = eINSTANCE.getInCollection_Publisher();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_COLLECTION__MONTH = eINSTANCE.getInCollection_Month();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.InProceedingsImpl <em>In Proceedings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.InProceedingsImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getInProceedings()
		 * @generated
		 */
		EClass IN_PROCEEDINGS = eINSTANCE.getInProceedings();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__TITLE = eINSTANCE.getInProceedings_Title();

		/**
		 * The meta object literal for the '<em><b>Bootitle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__BOOTITLE = eINSTANCE.getInProceedings_Bootitle();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__YEAR = eINSTANCE.getInProceedings_Year();

		/**
		 * The meta object literal for the '<em><b>From Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__FROM_PAGE = eINSTANCE.getInProceedings_FromPage();

		/**
		 * The meta object literal for the '<em><b>To Page</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__TO_PAGE = eINSTANCE.getInProceedings_ToPage();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IN_PROCEEDINGS__MONTH = eINSTANCE.getInProceedings_Month();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__EDITORS = eINSTANCE.getInProceedings_Editors();

		/**
		 * The meta object literal for the '<em><b>Organization</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__ORGANIZATION = eINSTANCE.getInProceedings_Organization();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IN_PROCEEDINGS__PUBLISHER = eINSTANCE.getInProceedings_Publisher();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.MastersThesisImpl <em>Masters Thesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.MastersThesisImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getMastersThesis()
		 * @generated
		 */
		EClass MASTERS_THESIS = eINSTANCE.getMastersThesis();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__TITLE = eINSTANCE.getMastersThesis_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__YEAR = eINSTANCE.getMastersThesis_Year();

		/**
		 * The meta object literal for the '<em><b>School</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MASTERS_THESIS__SCHOOL = eINSTANCE.getMastersThesis_School();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MASTERS_THESIS__MONTH = eINSTANCE.getMastersThesis_Month();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.ProceedingsImpl <em>Proceedings</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.ProceedingsImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getProceedings()
		 * @generated
		 */
		EClass PROCEEDINGS = eINSTANCE.getProceedings();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__TITLE = eINSTANCE.getProceedings_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__YEAR = eINSTANCE.getProceedings_Year();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__EDITORS = eINSTANCE.getProceedings_Editors();

		/**
		 * The meta object literal for the '<em><b>Publisher</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__PUBLISHER = eINSTANCE.getProceedings_Publisher();

		/**
		 * The meta object literal for the '<em><b>Sponsored By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCEEDINGS__SPONSORED_BY = eINSTANCE.getProceedings_SponsoredBy();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__MONTH = eINSTANCE.getProceedings_Month();

		/**
		 * The meta object literal for the '<em><b>Isbn</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCEEDINGS__ISBN = eINSTANCE.getProceedings_Isbn();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.PhDThesisImpl <em>Ph DThesis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.PhDThesisImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getPhDThesis()
		 * @generated
		 */
		EClass PH_DTHESIS = eINSTANCE.getPhDThesis();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__TITLE = eINSTANCE.getPhDThesis_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__YEAR = eINSTANCE.getPhDThesis_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PH_DTHESIS__MONTH = eINSTANCE.getPhDThesis_Month();

		/**
		 * The meta object literal for the '<em><b>School</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PH_DTHESIS__SCHOOL = eINSTANCE.getPhDThesis_School();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.WwwImpl <em>Www</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.WwwImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getWww()
		 * @generated
		 */
		EClass WWW = eINSTANCE.getWww();

		/**
		 * The meta object literal for the '<em><b>Editors</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WWW__EDITORS = eINSTANCE.getWww_Editors();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__TITLE = eINSTANCE.getWww_Title();

		/**
		 * The meta object literal for the '<em><b>Year</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__YEAR = eINSTANCE.getWww_Year();

		/**
		 * The meta object literal for the '<em><b>Month</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WWW__MONTH = eINSTANCE.getWww_Month();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.EditorImpl <em>Editor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.EditorImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getEditor()
		 * @generated
		 */
		EClass EDITOR = eINSTANCE.getEditor();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDITOR__NAME = eINSTANCE.getEditor_Name();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.OrganizationImpl <em>Organization</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.OrganizationImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getOrganization()
		 * @generated
		 */
		EClass ORGANIZATION = eINSTANCE.getOrganization();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORGANIZATION__NAME = eINSTANCE.getOrganization_Name();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.PublisherImpl <em>Publisher</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.PublisherImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getPublisher()
		 * @generated
		 */
		EClass PUBLISHER = eINSTANCE.getPublisher();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISHER__NAME = eINSTANCE.getPublisher_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISHER__ADDRESS = eINSTANCE.getPublisher_Address();

		/**
		 * The meta object literal for the '{@link dblp.DBLP.impl.SchoolImpl <em>School</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dblp.DBLP.impl.SchoolImpl
		 * @see dblp.DBLP.impl.DBLPPackageImpl#getSchool()
		 * @generated
		 */
		EClass SCHOOL = eINSTANCE.getSchool();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHOOL__NAME = eINSTANCE.getSchool_Name();

		/**
		 * The meta object literal for the '<em><b>Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHOOL__ADDRESS = eINSTANCE.getSchool_Address();

	}

} //DBLPPackage
