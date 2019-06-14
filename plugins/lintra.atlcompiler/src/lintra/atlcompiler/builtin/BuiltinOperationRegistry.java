package lintra.atlcompiler.builtin;

import java.util.ArrayList;
import java.util.List;

import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Type;

public class BuiltinOperationRegistry {

	protected List<ICollectionOperationHandler> collectionHandlers;
	protected List<IOperationHandler> operationHandlers;
	protected List<IIteratorChainHandler> iteratorHandlers;
	
	public BuiltinOperationRegistry() {
		collectionHandlers = new ArrayList<ICollectionOperationHandler>();
		operationHandlers = new ArrayList<IOperationHandler>();
		iteratorHandlers = new ArrayList<IIteratorChainHandler>();
	}
	
	public void register(ICollectionOperationHandler handler) {
		this.collectionHandlers.add(handler);
	}

	public void register(IOperationHandler handler) {
		this.operationHandlers.add(handler);
	}

	public void register(IIteratorChainHandler handler) {
		this.iteratorHandlers.add(handler);
	}
	
	public IIteratorChainHandler findIteratorChain(String op) {
		for (IIteratorChainHandler handler : iteratorHandlers) {
			if ( handler.getIteratorName().equals(op) ) {
				return handler;
			}			
		}
		return null;
	}
	
	public ICollectionOperationHandler findCollectionOperation(String op, Class<?> t) {
		for (ICollectionOperationHandler handler : collectionHandlers) {
			if ( handler.getOperationName().equals(op) && t == handler.getSupportedType() ) {
				return handler;
			}
		}
		
		// If not, check base collection types
		for (ICollectionOperationHandler handler : collectionHandlers) {
			if ( handler.getOperationName().equals(op) && CollectionType.class == handler.getSupportedType() ) {
				return handler;
			}
		}
				
		return null;
	}

	public IOperationHandler findOperation(String op, Class<? extends Type> t) {
		for (IOperationHandler handler : operationHandlers) {
			if ( handler.getOperationName().equals(op) && handler.supportType(t) ) {
				return handler;
			}
		}
		
		// TODO: Check base types??? Organize from most concrete to less concrete
		
		return null;
	}
	
}
