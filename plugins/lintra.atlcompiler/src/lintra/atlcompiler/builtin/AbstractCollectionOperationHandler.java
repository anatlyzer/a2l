package lintra.atlcompiler.builtin;

import java.util.ArrayList;
import java.util.List;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Type;
import lintra.atlcompiler.javagen.JStatement;

public abstract class AbstractCollectionOperationHandler implements ICollectionOperationHandler {

	protected Class<? extends CollectionType> klass;
	protected String opName;

	public AbstractCollectionOperationHandler(Class<? extends CollectionType> klass, String opName) {
		this.klass  = klass;
		this.opName = opName;
	}
	
	@Override
	public Class<? extends CollectionType> getSupportedType() {
		return klass;
	}

	@Override
	public String getOperationName() {
		return opName;
	}

	protected List<JStatement> newStatements() {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		return stms;
	}
	
	@Override
	public boolean supportType(Class<? extends Type> t) {
		throw new UnsupportedOperationException();
	}
	
}
