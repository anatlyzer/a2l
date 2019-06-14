package a2l.compiler;

import java.util.List;

import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

/**
 * Some compilation steps need to return a list of statements plus a variable
 * with the result. This allows us to communicate this result.
 * 
 * @author jesus
 *
 */
public class VarStatementPair {
	private JVariableDeclaration variable;
	private List<JStatement> statements;

	public VarStatementPair(JVariableDeclaration var, List<JStatement> statements) {
		this.variable = var;
		this.statements = statements;
	}
	
	public JVariableDeclaration getVariable() {
		return variable;
	}
	
	public List<JStatement> getStatements() {
		return statements;
	}	
}
