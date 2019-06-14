/**
 *
 * $Id$
 */
package lintra.atlcompiler.javagen.validation;

import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JMethod;

/**
 * A sample validator interface for {@link lintra.atlcompiler.javagen.LMatchCase}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface LMatchCaseValidator {
	boolean validate();

	boolean validatePredicate(JMethod value);
	boolean validateObj(JExpression value);
}