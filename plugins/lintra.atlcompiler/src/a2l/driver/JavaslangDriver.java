package a2l.driver;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.SetType;
import linda.atlcompiler.CreationHelpers;
import lintra.atlcompiler.javagen.JExpression;

public class JavaslangDriver implements ICollectionsDriver {

	@Override
	public JExpression toCollection(JExpression expr, CollectionType toType) {
		if ( toType instanceof SetType ) {
			return CreationHelpers.createInvokeStatic("javaslang.collection.HashSet.ofAll", expr);
		}
		
		return CreationHelpers.createInvokeStatic("javaslang.collection.List.ofAll", expr);
	}

}
