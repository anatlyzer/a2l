package lintra2.runners;

import java.util.ArrayList;
import java.util.List;

import lintra2.transfo.Job;
import lintra2.transfo.LinTraParameters;

/**
 * This class implements a simple execution service which descomposes a list
 * of objects to be transformed into several threads.
 * 
 * @author jesus
 *
 */
public class ForkJoinExecutor {

	private final int numThreads;
	private List<Object> objects;
	private ITask task;

	public ForkJoinExecutor(int numThreads, ITask task, List<Object> objects) {
		this.numThreads = numThreads;
		this.objects    = objects;
		this.task = task;
	}
		
	public void executeSimplest() throws InterruptedException {
		java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(numThreads);
		try {
			myPool.submit(() -> {
				objects.parallelStream().forEach(object -> {
					task.doTask(object);
				});
			}).get();
		} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void execute() throws InterruptedException {
		List<Worker> workers = new ArrayList<>();
//		int chunkFactor = 32;
//		long lSize = objects.size();
//
//		long parts = numThreads * chunkFactor;
//		long chunkSize = lSize / parts;
//		
//		for (long i = 0; i < parts; i++) {
//			long min = i * chunkSize;
//			long max = i * chunkSize + chunkSize;
//			if (i + 1 == parts)
//				max = lSize;
//			
//			Worker worker = new Worker(min, max);
//			workers.add(worker);
//		}

		long i = 0;
		long lastId = objects.size();
		long increase = computeOptimalIncrease(numThreads, lastId, LinTraParameters.JOB_SIZE);
		//long increase = 1000;
		//System.out.println(increase);
		while(i<lastId){
			//todo.add(new Job(srcArea, i, i+increase));
			long max = i + increase;
			if ( max > lastId )
				max = lastId;
			workers.add(new Worker(i, max));
			i=i+increase + 1;
		}
		
		java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(numThreads);
		try {
			myPool.submit(() -> {
				workers.parallelStream().forEach(object -> {
					object.run();
				});
			}).get();
		} catch (InterruptedException | java.util.concurrent.ExecutionException e) {
			throw new RuntimeException(e);
		}
		
	}
	

	private int computeOptimalIncrease(int numThreads, double numElems, int workExcerptSize) {
		int increase;
		if (numElems / numThreads <  1){
			increase = 1;
		} else if (numElems / numThreads <  workExcerptSize){
			increase = (int) (numElems / numThreads);
		} else {
			increase = workExcerptSize;
		}
		return increase;
	}	
	
	private final class Worker implements Runnable {

		private long min;
		private long max;
		
		public Worker(long min, long max) {
			this.min = min;
			this.max = max;
		}

		public String getName() {
			return "(" + min + ".." + max + ")";
		}
		

		@Override
		public void run() {
			for(long i = min; i < max; i++)
				task.doTask(objects.get((int) i));
		}
	}
	
}
