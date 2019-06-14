package a2l.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import lintra2.blackboard.BlackboardException;
import lintra2.transfo.ITransformation2;
import lintra2.transfo.LinTraParameters;

/**
 * This class implements a simple execution service which descomposes a list
 * of objects to be transformed into several threads.
 * 
 * This is based on the proof-of-concept NonBlockingExecutor.
 * 
 * 
 * @author jesus
 *
 */
public class DirectExecutor {

	private final int numThreads;
	private final InputExtent extent;
	private final ITransformationFactory factory;
	private ArrayList<ITransformation2> partialTrafos;

	public DirectExecutor(int numThreads, ITransformationFactory factory, InputExtent extent) {
		this.numThreads = numThreads <= 0 ? 1 : numThreads;
		this.extent = extent;
		this.factory    = factory;
	}
	
	public void execute() throws InterruptedException {
		List<Worker> workers = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
				
		long lastId = extent.size();
		
		int jobSize = LinTraParameters.JOB_SIZE;
		jobSize = (int) ((lastId / (numThreads * 1.0)) / 100.0);
		long increase = computeOptimalIncrease(numThreads, lastId, jobSize);
		if ( increase == 0 ) {
			increase = lastId;
		}
		
		increase = 1;
		
		//System.out.println();
		//System.out.println("Input extent is " + lastId);
		//System.out.println("Increase    is " + increase);
		long numChunks = lastId / increase;
		
		long numWorkers = Math.min(numThreads, numChunks);
		
		Scheduler scheduler = new Scheduler(numWorkers, numChunks);
		
		Worker firstWorker = null;
		
		for (long i = 0; i < numWorkers; i++) {
			Worker worker = new Worker("Worker " + i, i, increase, scheduler);
			if ( firstWorker == null ) {
				firstWorker = worker;
				continue;
			}
			workers.add(worker);

//			Thread e = new Thread(worker, worker.getName());
//			tasks.add(e);
						
		}

		for(int i = 0; i < workers.size(); i++) {
			Worker w = workers.get(i);
			Thread e = new Thread(w, w.getName());
			threads.add(e);
			e.start();
		}

		if ( firstWorker != null ) {
			firstWorker.run();
		}
		
		for (Thread thread : threads) {
			thread.join();
		}
		
		// 
		this.partialTrafos = new ArrayList<ITransformation2>();
		if ( firstWorker != null ) {
			partialTrafos.add(firstWorker.getTransformation());
		}
		
		for (Worker w : workers) {
			partialTrafos.add(w.getTransformation());
		}
	}
	
	public void postprocessing(IGlobalContext context) {
		context.getGlobalTrace().pack();
	
		for (ITransformation2 t : partialTrafos) {
			t.doSequentialPostprocessing();
		}
		java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(this.numThreads);
		try {
			myPool.submit(() -> {
				partialTrafos.parallelStream().forEach(t -> { 
					t.doParallelPostprocessing();; 
				}); 			
			}).get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO: do this with threads
//		for (ITransformation2 t : partialTrafos) {
//			t.doPostprocessing();
//		}
	}
	
	public static class Scheduler {
		private final AtomicLong nextChunk;
		private final long numChunks;
		
		public Scheduler(long nextChunk, long numChunks) {
			this.nextChunk = new AtomicLong(nextChunk);
			this.numChunks = numChunks;
		}
		
		public long getNextChunk(long currentChunk) {
			long next = nextChunk.getAndIncrement();
			if ( next > numChunks ) 
				return -1;
			return next;

			// Seems to be very little difference (or nothing actually), 
			// which is logical because getAndIncrement does essentially the same
			
//			long expectedChunk = currentChunk;
//			while ( true ) {
//				expectedChunk++;
//				if ( expectedChunk >= numChunks )
//					return -1;
//				
//				if ( nextChunk.compareAndSet(expectedChunk, expectedChunk + 1) ) {
//					return expectedChunk;
//				}
//			}
			
			// This eventually finishes
		}
		
	}

	
	private int computeOptimalIncrease(int numThreads, double numElems, int workExcerptSize) {
//		int increase;
//		if (numElems / numThreads <  1){
//			increase = 1;
//		} else if (numElems / numThreads <  workExcerptSize){
//			increase = (int) (numElems / numThreads);
//		} else {
//			increase = workExcerptSize;
//		}
//		return increase;
		
		if (numElems / numThreads <  1){
			return 1;
		}
		
		int maxIncrement = (int) (numElems / numThreads);
		if ( workExcerptSize * numThreads > maxIncrement ) {
			return maxIncrement;
		}
		return workExcerptSize * numThreads;
		
	}	
	
	private final class Worker implements Runnable {
		
		private long currentChunk;
		private final long chunkSize;
		private final Scheduler scheduler;
		private final ITransformation2 trafo;
		private String name;

		public Worker(String name, long chunk, long chunkSize, Scheduler scheduler) {
			this.name = name;
			this.currentChunk = chunk;
			this.chunkSize = chunkSize;
			this.scheduler = scheduler;
			this.trafo = factory.create();	
		}

		public String getName() {
			return "(" + currentChunk + " for " + chunkSize + ")";
		}
		
		public ITransformation2 getTransformation() {
			return trafo;
		}

		@Override
		public void run() {
			long total = extent.size();
			while ( true ) {
				long min = currentChunk * chunkSize;
				long max = Math.min(currentChunk * chunkSize + chunkSize, total);
				//System.out.println(name + " " + currentChunk + "[" + min + ".." + max +"]");
				//System.out.println("Doing: " + min + "..." + max);
				for(long i = min; i < max; i++) {
					try {
						trafo.transform(extent.get(i));
					} catch (BlackboardException e) {
						e.printStackTrace();
						return;
					}
				}
				
				long nextChunk = scheduler.getNextChunk(currentChunk);
				if ( nextChunk == - 1 ) {
					return;
				} else {
					currentChunk = nextChunk;
				}
			}
		}
	}
	
}
