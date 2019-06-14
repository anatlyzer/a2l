package a2l.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import lintra2.blackboard.BlackboardException;
import lintra2.transfo.ITransformation2;
import lintra2.transfo.LinTraParameters;

/**
 * 
 * @author jesus
 *
 */
public class PartitionedExecutor {

	private final int numThreads;
	private final InputExtendPartitioned extent;
	private final ITransformationFactory factory;
	private ArrayList<ITransformation2> partialTrafos;

	public PartitionedExecutor(int numThreads, ITransformationFactory factory, InputExtent extent) {
		this.numThreads = numThreads <= 0 ? 1 : numThreads;
		this.extent = (InputExtendPartitioned) extent;
		this.factory    = factory;
	}
	
	public void execute() throws InterruptedException {
		List<Worker> workers = new ArrayList<>();
		List<Thread> threads = new ArrayList<>();
		
		long numWorkers = numThreads;
		
		for (int i = 0; i < numWorkers; i++) {
			Worker worker = new Worker("Worker " + i, extent.getJob(i));
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
		for (Worker w : workers) {
			partialTrafos.add(w.getTransformation());
		}
	}
	
	public void postprocessing() {
		// TODO: do this with threads
		for(ITransformation2 t : partialTrafos) {
			t.doPostprocessing();
		}
	}
		
	private final class Worker implements Runnable {
		
		private final ITransformation2 trafo;
		private String name;
		private List<? extends Object> job;

		public Worker(String name, List<? extends Object> job) {
			this.name = name;
			this.job = job;
			this.trafo = factory.create();	
		}

		public String getName() {
			return name + " [size =" + job.size() + "]";
		}
		
		public ITransformation2 getTransformation() {
			return trafo;
		}

		@Override
		public void run() {
			try {
				// System.out.println("Worker " + name + ": " + "job size = " + job.size());
				for(Object o : job) {
					trafo.transform(o);
				}
			} catch (BlackboardException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
