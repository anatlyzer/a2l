package lintra.emf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import a2l.runtime.IModel;
import a2l.runtime.InputExtendPartitioned;
import a2l.runtime.InputExtent;
import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IArea;
import lintra2.blackboard.IdMapper;
import lintra2.transfo.IDataSource;
import lintra2.transfo.IFootprint;

public class EMFDataSource implements IDataSource {

	private Resource input;
	private IFootprint footprint = NullFootprint.INSTANCE;
	private boolean alreadyFilled = false;
	
	public EMFDataSource(Resource input) {
		this(input, null);
	}

	public EMFDataSource(Resource input, IFootprint footprint) {
		this.input = input;
		this.footprint = footprint == null ? NullFootprint.INSTANCE : footprint;
	}

	@Override
	public IdMapper getIdMapper() {
		throw new UnsupportedOperationException("Not supported anymore");
	}

	private static class NullFootprint implements IFootprint {
		private static NullFootprint INSTANCE = new NullFootprint();
		
		@Override
		public boolean inGlobal(Object o) {
			return true;
		}
		
	}
	
	public void fillList(Collection<Object> l, AllInstancesAdder adder) {
		if ( alreadyFilled )
			throw new IllegalArgumentException("Sanity check to make sure we don't fill several models with the same data source");
		alreadyFilled = true;
		TreeIterator<EObject> it = input.getAllContents();
		while ( it.hasNext() ) {
			EObject obj = it.next();

			if ( adder != null ) {
				adder.accept(obj);
			}
			
			// Only add if it is in the footprint. By default we use NullFootprint which always add
			if ( footprint.inGlobal(obj) ) { 
				l.add(obj);
			}
		}
	}
	
	public InputExtent toInputExtent() {
		ArrayList<Object> list = new ArrayList<>(1024 * 512);
		fillList(list, null);
		// TODO: Do all of this is an efficient way without duplicating lists a lot
		InputExtent extent = new InputExtent();
		extent.addAll(list);
		return extent;
	}
	
	@Override
	public InputExtent toInputExtentPartitioned(int numThreads) {
		List<List<Object>> jobs = new ArrayList<>(numThreads);
		for(int i = 0; i < numThreads; i++) {
			jobs.add(new ArrayList<Object>());			
		}
		
		Map<Class<?>, Integer> balancer = new HashMap<>();
		
		TreeIterator<EObject> it = input.getAllContents();
		while ( it.hasNext() ) {
			EObject obj = it.next();

			// If there is a footprint and the object won't appear, don't use it
			if ( footprint != null && !footprint.inGlobal(obj) ) 
				continue;
			
			
			Class<? extends EObject> clazz = obj.getClass();
			
			int thread = balancer.getOrDefault(clazz, 0);
			jobs.get(thread).add(obj);
			
			balancer.put(clazz, (thread + 1) % numThreads);						
		}
		
		return new InputExtendPartitioned(jobs);
		
	}
	
	@Override
	public void fill(IArea area) {
		throw new UnsupportedOperationException("Not supported anymore");
	}

	@Override
	public IModel createModel(AllInstancesAdder adder) {
//		HashSet<Object> list = new HashSet<>();
//		fillList(list);
//		return new EMFModel(list);
		ArrayList<Object> list = new ArrayList<>();
		fillList(list, adder);
		return new EMFModel(list);
	}
	
}
