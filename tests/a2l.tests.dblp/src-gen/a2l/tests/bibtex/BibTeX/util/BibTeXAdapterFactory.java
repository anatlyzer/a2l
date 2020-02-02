/**
 */
package a2l.tests.bibtex.BibTeX.util;

import a2l.tests.bibtex.BibTeX.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see a2l.tests.bibtex.BibTeX.BibTeXPackage
 * @generated
 */
public class BibTeXAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static BibTeXPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BibTeXAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = BibTeXPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BibTeXSwitch<Adapter> modelSwitch =
		new BibTeXSwitch<Adapter>() {
			@Override
			public Adapter caseBibTeXFile(BibTeXFile object) {
				return createBibTeXFileAdapter();
			}
			@Override
			public Adapter caseAuthor(Author object) {
				return createAuthorAdapter();
			}
			@Override
			public Adapter caseBibTeXEntry(BibTeXEntry object) {
				return createBibTeXEntryAdapter();
			}
			@Override
			public Adapter caseAuthoredEntry(AuthoredEntry object) {
				return createAuthoredEntryAdapter();
			}
			@Override
			public Adapter caseDatedEntry(DatedEntry object) {
				return createDatedEntryAdapter();
			}
			@Override
			public Adapter caseTitledEntry(TitledEntry object) {
				return createTitledEntryAdapter();
			}
			@Override
			public Adapter caseBookTitledEntry(BookTitledEntry object) {
				return createBookTitledEntryAdapter();
			}
			@Override
			public Adapter caseArticle(Article object) {
				return createArticleAdapter();
			}
			@Override
			public Adapter caseTechReport(TechReport object) {
				return createTechReportAdapter();
			}
			@Override
			public Adapter caseUnpublished(Unpublished object) {
				return createUnpublishedAdapter();
			}
			@Override
			public Adapter caseManual(Manual object) {
				return createManualAdapter();
			}
			@Override
			public Adapter caseProceedings(Proceedings object) {
				return createProceedingsAdapter();
			}
			@Override
			public Adapter caseInProceedings(InProceedings object) {
				return createInProceedingsAdapter();
			}
			@Override
			public Adapter caseBooklet(Booklet object) {
				return createBookletAdapter();
			}
			@Override
			public Adapter caseBook(Book object) {
				return createBookAdapter();
			}
			@Override
			public Adapter caseInCollection(InCollection object) {
				return createInCollectionAdapter();
			}
			@Override
			public Adapter caseInBook(InBook object) {
				return createInBookAdapter();
			}
			@Override
			public Adapter caseMisc(Misc object) {
				return createMiscAdapter();
			}
			@Override
			public Adapter caseThesisEntry(ThesisEntry object) {
				return createThesisEntryAdapter();
			}
			@Override
			public Adapter casePhDThesis(PhDThesis object) {
				return createPhDThesisAdapter();
			}
			@Override
			public Adapter caseMasterThesis(MasterThesis object) {
				return createMasterThesisAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.BibTeXFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.BibTeXFile
	 * @generated
	 */
	public Adapter createBibTeXFileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Author
	 * @generated
	 */
	public Adapter createAuthorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.BibTeXEntry <em>Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.BibTeXEntry
	 * @generated
	 */
	public Adapter createBibTeXEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.AuthoredEntry <em>Authored Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.AuthoredEntry
	 * @generated
	 */
	public Adapter createAuthoredEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.DatedEntry <em>Dated Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.DatedEntry
	 * @generated
	 */
	public Adapter createDatedEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.TitledEntry <em>Titled Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.TitledEntry
	 * @generated
	 */
	public Adapter createTitledEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.BookTitledEntry <em>Book Titled Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.BookTitledEntry
	 * @generated
	 */
	public Adapter createBookTitledEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Article
	 * @generated
	 */
	public Adapter createArticleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.TechReport <em>Tech Report</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.TechReport
	 * @generated
	 */
	public Adapter createTechReportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Unpublished <em>Unpublished</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Unpublished
	 * @generated
	 */
	public Adapter createUnpublishedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Manual <em>Manual</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Manual
	 * @generated
	 */
	public Adapter createManualAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Proceedings <em>Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Proceedings
	 * @generated
	 */
	public Adapter createProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.InProceedings <em>In Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.InProceedings
	 * @generated
	 */
	public Adapter createInProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Booklet <em>Booklet</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Booklet
	 * @generated
	 */
	public Adapter createBookletAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Book
	 * @generated
	 */
	public Adapter createBookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.InCollection <em>In Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.InCollection
	 * @generated
	 */
	public Adapter createInCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.InBook <em>In Book</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.InBook
	 * @generated
	 */
	public Adapter createInBookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.Misc <em>Misc</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.Misc
	 * @generated
	 */
	public Adapter createMiscAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.ThesisEntry <em>Thesis Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.ThesisEntry
	 * @generated
	 */
	public Adapter createThesisEntryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.PhDThesis <em>Ph DThesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.PhDThesis
	 * @generated
	 */
	public Adapter createPhDThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link a2l.tests.bibtex.BibTeX.MasterThesis <em>Master Thesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see a2l.tests.bibtex.BibTeX.MasterThesis
	 * @generated
	 */
	public Adapter createMasterThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //BibTeXAdapterFactory
