/**
 *
 * $Id$
 */
package lintra.atlcompiler.javagen.validation;

import lintra.atlcompiler.javagen.JExpression;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link lintra.atlcompiler.javagen.JInvoke}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JInvokeValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateObj(JExpression value);
	boolean validateArguments(EList<JExpression> value);
}
