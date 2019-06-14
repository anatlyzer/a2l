package lintra.atlcompiler.builtin;

import java.util.List;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Type;
import anatlyzer.atlext.OCL.OperationCallExp;
import linda.atlcompiler.ICompilationContext.Context;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

public interface ICollectionOperationHandler extends IOperationHandler {
	
	public Class<? extends CollectionType> getSupportedType();


	
}
