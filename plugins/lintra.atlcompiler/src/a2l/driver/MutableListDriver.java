package a2l.driver;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.SetType;
import linda.atlcompiler.CreationHelpers;
import lintra.atlcompiler.javagen.JExpression;

public class MutableListDriver implements ICollectionsDriver {

	@Override
	public JExpression toCollection(JExpression expr, CollectionType type) {
		if ( type instanceof SetType ) {
			return CreationHelpers.createInvokeStatic("new HashSet<>", expr); // trick
		}
		return expr;
	}

}
