/**
 */
package dblp.AuthorInfo.impl;

import dblp.AuthorInfo.*;

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
public class AuthorInfoFactoryImpl extends EFactoryImpl implements AuthorInfoFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AuthorInfoFactory init() {
		try {
			AuthorInfoFactory theAuthorInfoFactory = (AuthorInfoFactory)EPackage.Registry.INSTANCE.getEFactory(AuthorInfoPackage.eNS_URI);
			if (theAuthorInfoFactory != null) {
				return theAuthorInfoFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AuthorInfoFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AuthorInfoFactoryImpl() {
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
			case AuthorInfoPackage.AUTHOR: return createAuthor();
			case AuthorInfoPackage.CONFERENCE: return createConference();
			case AuthorInfoPackage.JOURNAL: return createJournal();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
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
	public Conference createConference() {
		ConferenceImpl conference = new ConferenceImpl();
		return conference;
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
	public AuthorInfoPackage getAuthorInfoPackage() {
		return (AuthorInfoPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AuthorInfoPackage getPackage() {
		return AuthorInfoPackage.eINSTANCE;
	}

} //AuthorInfoFactoryImpl
