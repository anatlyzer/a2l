/**
 */
package a2l.tests.vmtesting.emf.metamodels.atl.OCL;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.TupleExp#getTuplePart <em>Tuple Part</em>}</li>
 * </ul>
 *
 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getTupleExp()
 * @model
 * @generated
 */
public interface TupleExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Tuple Part</b></em>' containment reference list.
	 * The list contents are of type {@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.TuplePart}.
	 * It is bidirectional and its opposite is '{@link a2l.tests.vmtesting.emf.metamodels.atl.OCL.TuplePart#getTuple <em>Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuple Part</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuple Part</em>' containment reference list.
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage#getTupleExp_TuplePart()
	 * @see a2l.tests.vmtesting.emf.metamodels.atl.OCL.TuplePart#getTuple
	 * @model opposite="tuple" containment="true"
	 * @generated
	 */
	EList<TuplePart> getTuplePart();

} // TupleExp
