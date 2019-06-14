package a2l.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import lintra2.blackboard.BlackboardException;
import lintra2.transfo.ITransformation2;

public class ParallelStreamExecutor {
	private final int numThreads;
	private final InputExtent extent;
	private final ITransformationFactory factory;
	private List<ITransformation2> partialTrafos;

	public ParallelStreamExecutor(int numThreads, ITransformationFactory factory, InputExtent extent) {
		this.numThreads = numThreads <= 0 ? 1 : numThreads;
		this.extent = extent;
		this.factory    = factory;
	}
	
	public void execute() throws InterruptedException {
		final List<Object> objects = extent.getAllInstances();
//		java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(numThreads,
//				new ForkJoinWorkerThreadFactory() {
//
//					@Override
//					public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
//						// TODO Auto-generated method stub
//						return null;
//					}
//				});
//		try {
//			myPool.submit(() -> {
//				objects.parallelStream().forEach(object -> {
//					task.doTask(object);
//				});
//			}).get();
//		} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
//			throw new RuntimeException(e);
//		}
//
//		List<Worker> workers = new ArrayList<>();
//		List<Thread> threads = new ArrayList<>();
//
//		long numWorkers = numThreads;

		TransformAction mainTask = new TransformAction(objects, 0, objects.size());
		ForkJoinPool pool = new ForkJoinPool(numThreads);
		this.partialTrafos = pool.invoke(mainTask);
	}
	
	public void postprocessing(IGlobalContext context) {
		context.getGlobalTrace().pack();
		
		// TODO: do this with threads
		//int i = 0;
		for(ITransformation2 t : partialTrafos) {
			//System.out.println("Postprocessing... " + i++);
			t.doPostprocessing();
		}
	}

	
	public class TransformAction extends RecursiveTask<List<ITransformation2>> {
		int number;
		int threshold = 10_000;
		int start;
		int end;
		private List<Object> objects;

		public TransformAction(List<Object> objects, int start, int end) {
			this.objects = objects;
			this.start = start;
			this.end = end;
		}

		protected List<ITransformation2> compute() {
			// System.out.println("Spliting: " + start + "..." + end);
			if (end - start < threshold) {
				return computeDirectly();
			} else {
				int middle = (end + start) / 2;

				TransformAction subTask1 = new TransformAction(objects, start, middle);
				TransformAction subTask2 = new TransformAction(objects, middle, end);
				
				invokeAll(subTask1, subTask2);
				
				List<ITransformation2> r1 = subTask1.join();
				List<ITransformation2> r2 = subTask2.join();
				ArrayList<ITransformation2> r = new ArrayList<>();
				r.addAll(r1);
				r.addAll(r2);
								
				return r;
			}
		}

		protected List<ITransformation2> computeDirectly() {
			//System.out.println("Computing: " + start + "..." + end);
			ITransformation2 trafo = factory.create();
			try {
				for(int i = start; i < end; i++) {
					trafo.transform(objects.get(i));
				}
				return Collections.singletonList(trafo);
			} catch (BlackboardException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
