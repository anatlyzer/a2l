package a2l.runtime;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

import lintra2.blackboard.BlackboardException;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.ITransformation2;

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

	private static final boolean DEBUG = false;
	
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
		if (numThreads == 1) {
			executeSingle();
			return;
		}
			
		long size = extent.size();
		long staticFragmentSize = (size / 5) * 4;
		if (numThreads * 10 > staticFragmentSize) {
			executeSingle();
			return;
		}
		
		// Step 1: Divide work statically for the 3/4 parts of the input
		long chunkSize_step1 = staticFragmentSize / numThreads;
		long rest_step1 = staticFragmentSize % numThreads;
		long numWorkers = numThreads; 
			
		List<Worker> workers = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		
		long increase = 10;	
		long start_step2 = staticFragmentSize;
		long numChunks = (size - start_step2) / increase;
		if ((size - start_step2) % increase != 0)
			numChunks++;
		
		Scheduler scheduler = new Scheduler(numWorkers, numChunks);
		
		for (long i = 0; i < numWorkers; i++) {
			long start_phase1 = (i == 0) 
					? 0 
					: i * chunkSize_step1 + rest_step1;
			long end_phase1 = (i == 0)
					? chunkSize_step1 + rest_step1
					: start_phase1 + chunkSize_step1;
				
			Worker worker = new Worker("Worker " + i, i, 
					/* phase 1: */ start_phase1, end_phase1,
					/* phase 2: */ start_step2,
					increase, scheduler);

			workers.add(worker);						
		}

		for(int i = 0; i < workers.size(); i++) {
			Worker w = workers.get(i);
			Thread e = new Thread(w, w.getName());
			threads.add(e);
			e.start();
		}
	
		for (Thread thread : threads) {
			thread.join();
		}
		
		// 
		this.partialTrafos = new ArrayList<ITransformation2>();
		
		if (DEBUG)
			System.out.println("\nStats:");
		int countNumExecutions = 0;
		int countNumMatchedExecutions = 0;
		
		int i = 0;
		for (Worker w : workers) {
			ITransformation2 trafo = w.getTransformation();
			partialTrafos.add(trafo);
			if (DEBUG) {			
				System.out.println("Worker: " + i++);
				countNumExecutions += trafo.getNumExecutions();
				System.out.println("  " + trafo.getNumExecutions());
				countNumMatchedExecutions += trafo.getNumMatchedRuleExecutions();
				System.out.println("  " + trafo.getNumMatchedRuleExecutions());
			}
		}
		if (DEBUG) {
			System.out.println("Total:");
			System.out.println("  " + countNumExecutions);
			System.out.println("  " + countNumMatchedExecutions);
		}
		
		partialTrafos.get(0).doEndpoint();
	}
	
	private void executeSingle() {
		ITransformation2 trafo = factory.create();
		this.partialTrafos = new ArrayList<ITransformation2>();
		partialTrafos.add(trafo);
		trafo.doInitialisation();
		for(long i = 0, len = extent.size(); i < len; i++) {
			try {
				trafo.transform(extent.get(i));
			} catch (BlackboardException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		trafo.doEndpoint();
		
		if (DEBUG) {
			System.out.println("\nStats:");
			System.out.println("  " + trafo.getNumExecutions());
			System.out.println("  " + trafo.getNumMatchedRuleExecutions());
		}
	}

	public void postprocessing(IGlobalContext context) {
		context.getGlobalTrace().pack();
	
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

		for (ITransformation2 t : partialTrafos) {
			t.doSequentialPostprocessing();
		}

		for (ITransformation2 t : partialTrafos) {
			t.doSequentialCleanup();;
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
		
		public long getNextChunk2(long currentChunk) {
			long next = nextChunk.getAndIncrement();
			return next;
		}
		
	}

	private static enum SchedulingKind {
		DYNAMIC,
		GUIDED,
		NESTED
	}
	
	private final class Worker implements Runnable {
		
		private long currentChunk;
		private final long chunkSize;
		private final Scheduler scheduler;
		private final ITransformation2 trafo;
		private String name;
		
		private final SchedulingKind kind = SchedulingKind.DYNAMIC;
		
		private final long start_phase1;  
		private final long end_phase1;
		private final long start_phase2;  
		
		public Worker(String name, long chunk, long start_phase1, long end_phase1, long start_phase2, long chunkSize, Scheduler scheduler) {
			this.name = name;
			this.currentChunk = chunk;
			this.chunkSize = chunkSize;
			this.scheduler = scheduler;
			this.start_phase1 = start_phase1;
			this.end_phase1 = end_phase1;
			this.start_phase2 = start_phase2;
			
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
			final long total = extent.size();
			
			// At the beginning currentChunk = 0 if it is thread 0
			if (currentChunk == 0) {
				trafo.doInitialisation();
			}
			
			for(long i = start_phase1; i < end_phase1; i++) {
				try {
					trafo.transform(extent.get(i));
				} catch (BlackboardException e) {
					e.printStackTrace();
				}
			}
			
			while ( true ) {
				long min = currentChunk * chunkSize + start_phase2;
				long max = Math.min(min + chunkSize, total);
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
					//System.out.println("Finished: " + System.currentTimeMillis());
					return;
				} else {
					currentChunk = nextChunk;
				}
			}
		}
	}


	public void addProfilingTo(IStatsRecorder stats) {
//		int i = 0;
//		for (ITransformation2 t : partialTrafos) {
//			System.out.println(i + "numExecutions: " + t.getNumExecutions());
//			System.out.println(i + "matchedRuleEx: " + t.getNumMatchedRuleExecutions());
//			i++;
//		}
	}
	
}
