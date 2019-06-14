package linda.atlcompiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public class GenList {

	private ICompilationContext ctx;
	private JVariableDeclaration result;
	private List<JStatement> stms = new ArrayList<>();
	
	public GenList(ICompilationContext ctx) {
		this.ctx = ctx;
	}

	public JVariableDeclaration initResult(JTypeRef tr) {
		this.result = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "tmp", tr);
		return result;
	}

	public JVariableDeclaration assignTemporal(JExpression expr, JTypeRef type) {
		JVariableDeclaration var = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "tmp", type);

		stms.add(CreationHelpers.createAssignment(var, expr));
		
		return var;
	}

	public void assignResult(JExpression expr) {
		stms.add(CreationHelpers.createAssignment(result, expr));		
	}

	public JVariableDeclaration getResult() {
		return result;
	}

	public List<? extends JStatement> getStatements() {
		return stms;
	}

}
