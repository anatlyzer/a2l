package lintra2.runners;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a simple execution service which descomposes a list
 * of objects to be transformed into several threads.
 * 
 * @author jesus
 *
 */
public class SimpleExecutor {

	private final int numThreads;
	private List<Object> objects;
	private ITask task;

	public SimpleExecutor(int numThreads, ITask task, List<Object> objects) {
		this.numThreads = numThreads;
		this.objects    = objects;
		this.task = task;
	}
		
	public void execute() throws InterruptedException {
		List<Thread> tasks = new ArrayList<>();
		List<Worker> workers = new ArrayList<>();
		int chunkFactor = 32;
		
		Worker first = null;
		long lSize = objects.size();
		
				
		long parts = numThreads * chunkFactor;
		long chunkSize = lSize / parts;
		
		for (long i = 0; i < parts; i++) {
			long min = i * chunkSize;
			long max = i * chunkSize + chunkSize;
			if (i + 1 == parts)
				max = lSize;
			
			Worker worker = new Worker(min, max);
			workers.add(worker);
			
//			if ( first == null ) {
//				first = task;
//				continue;
//			}	

//			Thread e = new Thread(worker, worker.getName());
//			tasks.add(e);
						
		}

		//int size = workers.size();
		for(int i = 0; i < numThreads; i++) {
			Worker w = workers.remove(0);
			Thread e = new Thread(w, w.getName());
			tasks.add(e);
			e.start();
		}

//		if ( first != null )
//			first.run();

		while ( ! tasks.isEmpty() ) {
			for (Thread thread : new ArrayList<>(tasks)) {
				if ( thread.isAlive() ) {
					// ok
				} else {
					tasks.remove(thread);
					if (! workers.isEmpty() ) {
						Worker w = workers.remove(0);
						Thread e = new Thread(w, w.getName());
						tasks.add(e);
						e.start();
					}
				}
			}
		}


//		for (Thread thread : tasks) {
//			thread.join();
//		}

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
