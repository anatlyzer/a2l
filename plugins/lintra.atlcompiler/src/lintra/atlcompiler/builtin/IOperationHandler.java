package lintra.atlcompiler.builtin;

import java.util.List;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Type;
import anatlyzer.atlext.OCL.OperationCallExp;
import linda.atlcompiler.ICompilationContext.Context;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public interface IOperationHandler {
	
	public String getOperationName();
	public boolean supportType(Class<? extends Type> t);
	
	public List<JStatement> compile(Context ctx, OperationCallExp op, JVariableDeclaration source, JVariableDeclaration[] args, JVariableDeclaration resultVar);
	
	
}
