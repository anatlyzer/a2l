package lintra.atlcompiler.builtin;

import java.util.ArrayList;
import java.util.List;

import lintra.atlcompiler.javagen.JStatement;

public abstract class AbstractOperationHandler implements IOperationHandler {

	protected String opName;

	public AbstractOperationHandler(String opName) {
		this.opName = opName;
	}

	@Override
	public String getOperationName() {
		return opName;
	}

	protected List<JStatement> newStatements() {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		return stms;
	}
	
}
