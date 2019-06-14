/**
 */
package dblp.DBLP.util;

import dblp.DBLP.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see dblp.DBLP.DBLPPackage
 * @generated
 */
public class DBLPAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DBLPPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DBLPAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DBLPPackage.eINSTANCE;
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
	protected DBLPSwitch<Adapter> modelSwitch =
		new DBLPSwitch<Adapter>() {
			@Override
			public Adapter caseRecord(Record object) {
				return createRecordAdapter();
			}
			@Override
			public Adapter caseArticle(Article object) {
				return createArticleAdapter();
			}
			@Override
			public Adapter caseAuthor(Author object) {
				return createAuthorAdapter();
			}
			@Override
			public Adapter caseJournal(Journal object) {
				return createJournalAdapter();
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
			public Adapter caseInProceedings(InProceedings object) {
				return createInProceedingsAdapter();
			}
			@Override
			public Adapter caseMastersThesis(MastersThesis object) {
				return createMastersThesisAdapter();
			}
			@Override
			public Adapter caseProceedings(Proceedings object) {
				return createProceedingsAdapter();
			}
			@Override
			public Adapter casePhDThesis(PhDThesis object) {
				return createPhDThesisAdapter();
			}
			@Override
			public Adapter caseWww(Www object) {
				return createWwwAdapter();
			}
			@Override
			public Adapter caseEditor(Editor object) {
				return createEditorAdapter();
			}
			@Override
			public Adapter caseOrganization(Organization object) {
				return createOrganizationAdapter();
			}
			@Override
			public Adapter casePublisher(Publisher object) {
				return createPublisherAdapter();
			}
			@Override
			public Adapter caseSchool(School object) {
				return createSchoolAdapter();
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
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Record <em>Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Record
	 * @generated
	 */
	public Adapter createRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Article <em>Article</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Article
	 * @generated
	 */
	public Adapter createArticleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Author <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Author
	 * @generated
	 */
	public Adapter createAuthorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Journal <em>Journal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Journal
	 * @generated
	 */
	public Adapter createJournalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Book <em>Book</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Book
	 * @generated
	 */
	public Adapter createBookAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.InCollection <em>In Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.InCollection
	 * @generated
	 */
	public Adapter createInCollectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.InProceedings <em>In Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.InProceedings
	 * @generated
	 */
	public Adapter createInProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.MastersThesis <em>Masters Thesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.MastersThesis
	 * @generated
	 */
	public Adapter createMastersThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Proceedings <em>Proceedings</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Proceedings
	 * @generated
	 */
	public Adapter createProceedingsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.PhDThesis <em>Ph DThesis</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.PhDThesis
	 * @generated
	 */
	public Adapter createPhDThesisAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Www <em>Www</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Www
	 * @generated
	 */
	public Adapter createWwwAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Editor <em>Editor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Editor
	 * @generated
	 */
	public Adapter createEditorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Organization <em>Organization</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Organization
	 * @generated
	 */
	public Adapter createOrganizationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.Publisher <em>Publisher</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.Publisher
	 * @generated
	 */
	public Adapter createPublisherAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dblp.DBLP.School <em>School</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dblp.DBLP.School
	 * @generated
	 */
	public Adapter createSchoolAdapter() {
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

} //DBLPAdapterFactory
