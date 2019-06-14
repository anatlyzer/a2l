package a2l.driver;

import anatlyzer.atl.types.CollectionType;
import lintra.atlcompiler.javagen.JExpression;

/**
 * 
 * Subclasses implement strategies to initialize collections and handle
 * them in the most effective way.
 * 
 * @author jesus
 *
 */
public interface ICollectionsDriver {

	public enum BaseType {
		JAVA_UTIL_LIST
	}

	public JExpression toCollection(JExpression expr, CollectionType toType);

	public ICollectionsDriver NULL_DRIVER = new ICollectionsDriver() {

		@Override
		public JExpression toCollection(JExpression expr, CollectionType toType) {
			throw new IllegalStateException();
		}
		
	};
	
}
