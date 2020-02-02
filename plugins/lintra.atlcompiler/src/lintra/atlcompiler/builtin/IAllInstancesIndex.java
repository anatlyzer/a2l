package lintra.atlcompiler.builtin;

import a2l.compiler.VarStatementPair;
import a2l.optimiser.anatlyzerext.AllInstancesIndexed;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.LindaCompiler;

public interface IAllInstancesIndex {

	String getIndexType();

	VarStatementPair compile(Context ctx, AllInstancesIndexed self, LindaCompiler compiler);
	
}
