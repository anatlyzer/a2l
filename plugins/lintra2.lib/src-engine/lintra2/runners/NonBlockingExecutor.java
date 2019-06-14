package lintra2.runners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lintra2.transfo.LinTraParameters;

/**
 * This class implements a simple execution service which descomposes a list
 * of objects to be transformed into several threads.
 * 
 * @author jesus
 *
 */
public class NonBlockingExecutor {

	private final int numThreads;
	private List<Object> objects;
	private ITask task;

	public NonBlockingExecutor(int numThreads, ITask task, List<Object> objects) {
		this.numThreads = numThreads;
		this.objects    = objects;
		this.task = task;
	}
	
	public void execute() throws InterruptedException {
		List<Worker> workers = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
				
		long lastId = objects.size();
		long increase = computeOptimalIncrease(numThreads, lastId, LinTraParameters.JOB_SIZE);
		
		long numChunks = lastId / increase;
		
		long numWorkers = Math.min(numThreads, numChunks);
		
		Scheduler scheduler = new Scheduler(numWorkers, numChunks);
		
		Worker firstWorker = null;
		
		for (long i = 0; i < numWorkers; i++) {
			Worker worker = new Worker(i, increase, scheduler);
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
			if ( next >= numChunks ) 
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
		
		private long currentChunk;
		private final long chunkSize;
		private final Scheduler scheduler;


		public Worker(long chunk, long chunkSize, Scheduler scheduler) {
			this.currentChunk = chunk;
			this.chunkSize = chunkSize;
			this.scheduler = scheduler;
		}

		public String getName() {
			return "(" + currentChunk + " for " + chunkSize + ")";
		}
		

		@Override
		public void run() {
			long total = objects.size();
			while ( true ) {
				long min = currentChunk * chunkSize;
				long max = Math.min(currentChunk * chunkSize + chunkSize, total);
				
				for(long i = min; i < max; i++) {
					task.doTask(objects.get((int) i));
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
