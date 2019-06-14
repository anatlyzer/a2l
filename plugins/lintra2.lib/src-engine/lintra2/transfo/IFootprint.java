package lintra2.transfo;

/**
 * Implementations of this class will check if an object is 
 * part of the footprint of the transformation, this means,
 * if such object will be used during the transformation execution.
 * 
 * There are two levels of footprint:
 * <ul>
 * <li>Entrypoint means that the object is needed in the match phase</li>
 * <li>Global means that the object is needed for the rule execution</li>
 * </ul>
 * 
 * @author jesus
 *
 */
public interface IFootprint {

	public default boolean inEntrypoint(Object o) { throw new UnsupportedOperationException(); }
	
	public boolean inGlobal(Object o);
	
}
