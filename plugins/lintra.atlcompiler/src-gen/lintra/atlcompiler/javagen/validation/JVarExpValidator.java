/**
 *
 * $Id$
 */
package lintra.atlcompiler.javagen.validation;

import lintra.atlcompiler.javagen.JVariableDeclaration;

/**
 * A sample validator interface for {@link lintra.atlcompiler.javagen.JVarExp}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JVarExpValidator {
	boolean validate();

	boolean validateReference(JVariableDeclaration value);
}
