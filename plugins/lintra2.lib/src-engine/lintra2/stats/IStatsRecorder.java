package lintra2.stats;

public interface IStatsRecorder {

	public static final IStatsRecorder NULL_RECORDER = new IStatsRecorder() {
		
		@Override
		public void startSerialization() { }
		
		@Override
		public void startPostprocessing() { }
		
		@Override
		public void startLaunch() {	}
		
		@Override
		public void startConfiguration() { 	}
		
		@Override
		public void endSerialization() { }
		
		@Override
		public void endPostprocessing() {	}
		
		@Override
		public void endLaunch() { }
		
		@Override
		public void endConfiguration() { }

		@Override
		public double getConfigurationSeconds() {
			throw new UnsupportedOperationException();
		}

		@Override
		public double getLaunchSeconds() {
			throw new UnsupportedOperationException();
		}

		@Override
		public double getPostprocessingSeconds() {
			throw new UnsupportedOperationException();
		}

		@Override
		public double getSerializationSeconds() {
			throw new UnsupportedOperationException();
		}
	};
	
	void startConfiguration();
	void endConfiguration();
	
	void startLaunch();
	void endLaunch();

	void startPostprocessing();
	void endPostprocessing();
	
	void startSerialization();
	void endSerialization();

	double getConfigurationSeconds();
	double getLaunchSeconds();
	double getPostprocessingSeconds();
	double getSerializationSeconds();
	
}
