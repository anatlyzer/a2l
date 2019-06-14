package lintra.evaluation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StatsCollector {

	private TransformationStats trafo;
	private List<TransformationStats> executions = new ArrayList<>();

	public void onTransformation(String transformation, int threads) {
		this.trafo = new TransformationStats(transformation);
		this.setThreads(threads);
		executions.add(trafo);
	}
	
	public List<TransformationStats> getExecutions() {
		return executions;
	}
	
	public void setThreads(int i) {
		this.trafo.setThreads(i);
	}

	
	
	public class TransformationStats {
		private String name;
		private int numThreads;
		private double beginTask = 0;
		private String currentTask;
		private LinkedList<Measurement> measurements = new LinkedList<>();
		
		public TransformationStats(String name) {
			this.name = name;
		}

		public void setThreads(int i) {
			this.numThreads = i;
		}

		public void begin(String task) {
			if ( currentTask != null )
				throw new IllegalStateException();
			currentTask = task;
			beginTask = System.currentTimeMillis();			 
		}
		
		public void end() {
			double timeF = (System.currentTimeMillis() - beginTask) / 1000;
			measurements.add(new Measurement(currentTask, timeF));
			currentTask = null;
			beginTask = 0.0;
		}
		
		@Override
		public String toString() {
			String s = "Transformation: " + name + "\n";
			s += "   Threads = " + numThreads + "\n";
			for (Measurement measurement : measurements) {
				s += "  " + measurement.task + " = " + measurement.time + "\n";
			}
			return s;
		}
	}

	public class Measurement {
		private String task;
		private double time;

		public Measurement(String task, double time) {
			this.task = task;
			this.time = time;
		}
		
		public double getTime() {
			return time;
		}
	}

	public void begin(String task) {
		this.trafo.begin(task);
	}

	public void end() {
		this.trafo.end();
	}


	public static class NullStats extends StatsCollector {
		@Override
		public void onTransformation(String transformation, int threads) { }
		@Override
		public void begin(String task) { }
		@Override
		public void end() { }
		
	}
	
}
