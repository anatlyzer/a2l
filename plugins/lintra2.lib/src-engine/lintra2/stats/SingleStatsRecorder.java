package lintra2.stats;

import java.io.PrintStream;

public class SingleStatsRecorder implements IStatsRecorder {

	private Record configuration;
	private Record launch;
	private Record postprocessing;
	private Record serialization;
	
	private class Record {
		private long start;
		private long end;
		
		public Record start() {
			start = System.currentTimeMillis();
			return this;
		}
		
		public Record stop() {
			end = System.currentTimeMillis();
			return this;
		}
		
		public double getSeconds() {
			return (end - start) / 1000.0;		
		}
	}
	
	@Override
	public void startConfiguration() {
		configuration = new Record().start();
	}

	@Override
	public void endConfiguration() {
		configuration.stop();
	}

	@Override
	public void startLaunch() {
		launch = new Record().start();
	}

	@Override
	public void endLaunch() {
		launch.stop();
		
	}

	@Override
	public void startPostprocessing() {
		postprocessing= new Record().start();		
	}

	@Override
	public void endPostprocessing() {
		postprocessing.stop();
	}

	@Override
	public void startSerialization() {
		serialization = new Record().start();
	}

	@Override
	public void endSerialization() {
		serialization.stop();
	}


	@Override
	public double getConfigurationSeconds() {
		return (configuration == null ? 0 : configuration.getSeconds());
	}

	@Override
	public double getLaunchSeconds() {
		return launch.getSeconds();
	}

	@Override
	public double getPostprocessingSeconds() {
		return (postprocessing == null ? 0 : postprocessing.getSeconds());
	}

	@Override
	public double getSerializationSeconds() {
		return serialization.getSeconds();
	}

	
	public double getExecutionTimeSeconds() {
		return getConfigurationSeconds() + 
				launch.getSeconds() +
				getPostprocessingSeconds(); 				
	}

	public void printTo(PrintStream out) {
		out.println("Total time      : " + getExecutionTimeSeconds());
		out.println("  Configuration : " + getConfigurationSeconds());
		out.println("  Running       : " + launch.getSeconds());
		out.println("  Postprocessing: " + getPostprocessingSeconds());
	}

}
