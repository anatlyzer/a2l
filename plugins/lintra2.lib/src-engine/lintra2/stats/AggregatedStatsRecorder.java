package lintra2.stats;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AggregatedStatsRecorder implements IStatsRecorder {

	private SortedMap<Integer, List<IStatsRecorder>> records = new TreeMap<>();
	private int currentNumThreads = -1;
	private SingleStatsRecorder currentStats;
	private String name;

	public AggregatedStatsRecorder(String name) {
		this.name = name;
	}

	public void testWithNumThreads(int i) {
		currentNumThreads = i;
		records.putIfAbsent(i, new ArrayList<>());
	}
	
	public void startNewTest() {
		this.currentStats = new SingleStatsRecorder();
		records.get(currentNumThreads).add(currentStats);
	}
	
	@Override
	public void startConfiguration() {
		currentStats.startConfiguration();
	}

	@Override
	public void endConfiguration() {
		currentStats.endConfiguration();
	}

	@Override
	public void startLaunch() {
		currentStats.startLaunch();
	}

	@Override
	public void endLaunch() {
		currentStats.endLaunch();		
	}

	@Override
	public void startPostprocessing() {
		currentStats.startPostprocessing();		
	}

	@Override
	public void endPostprocessing() {
		currentStats.endPostprocessing();
	}

	@Override
	public void startSerialization() {
		currentStats.startSerialization();
	}

	@Override
	public void endSerialization() {
		currentStats.endSerialization();
	}
	
//	public double getExecutionTimeSeconds() {
//		return configuration.getSeconds() + 
//				launch.getSeconds() +
//				postprocessing.getSeconds(); 				
//	}

	public void printCurrentTo(PrintStream out) {
		this.currentStats.printTo(out);
	}

	
	public void printTo(PrintStream out) {
		double runTimeFirst = -1;
		TreeMap<Integer, Double> speedUps = new TreeMap<Integer, Double>(); 
				
		for(int numThreads : records.keySet()) {		
			List<IStatsRecorder> l = records.get(numThreads);
			
			double configuration = l.stream().collect(Collectors.averagingDouble(s -> s.getConfigurationSeconds()));
			double launch = l.stream().collect(Collectors.averagingDouble(s -> s.getLaunchSeconds()));
			double post = l.stream().collect(Collectors.averagingDouble(s -> s.getPostprocessingSeconds()));
			double total = configuration + launch + post;

			List<Double> configurations = l.stream().map(IStatsRecorder::getConfigurationSeconds).sorted().collect(Collectors.toList());
			List<Double> launchs = l.stream().map(IStatsRecorder::getLaunchSeconds).sorted().collect(Collectors.toList());
			List<Double> posts   = l.stream().map(IStatsRecorder::getPostprocessingSeconds).sorted().collect(Collectors.toList());			
			
			double configurationMedian = configurations.get(configurations.size() / 2);
			double launchsMedian = launchs.get(launchs.size() / 2);
			double postsMedian = launchs.get(posts.size() / 2);
			
			DoubleSummaryStatistics confStats = l.stream().mapToDouble(IStatsRecorder::getConfigurationSeconds).summaryStatistics();
			DoubleSummaryStatistics launchStats = l.stream().mapToDouble(IStatsRecorder::getLaunchSeconds).summaryStatistics();
			DoubleSummaryStatistics postStats = l.stream().mapToDouble(IStatsRecorder::getPostprocessingSeconds).summaryStatistics();


			out.println("Threads = " + numThreads);
			out.println("  Total time      : " + total);
			out.println("    AVG : " );			
			out.println("      Configuration : " + configuration);
			out.println("      Running       : " + launch);
			out.println("      Postprocessing: " + post);
			out.println("    MEDIAN : " );			
			out.println("      Configuration : " + configurationMedian);
			out.println("      Running       : " + launchsMedian);
			out.println("      Postprocessing: " + postsMedian);
			out.println("    MIN : " );			
			out.println("      Configuration : " + confStats.getMin());
			out.println("      Running       : " + launchStats.getMin());
			out.println("      Postprocessing: " + postStats.getMin());
			out.println();
			
			speedUps.put(numThreads, launchsMedian);
		}	
		
		double min = speedUps.get(speedUps.firstKey());
		
		out.println("Speedups:");
		speedUps.forEach((k, v) -> {
			out.println(String.format("  %2d = %.2f", k, min / v));
		});
		out.println();
	}
	
	public void printCSVto(PrintStream out) {
		String header0 = Arrays.stream(new String[] { name, "", "", "", ""}).collect(Collectors.joining(","));
		out.println(header0);
		String header = Arrays.stream(new String[] { "Threads", 
				"Total (AVG)", "Configuration (AVG)", "Run (AVG)", "Postprocessing (AVG)", 
				"Total (MIN)", "Configuration (MIN)", "Run (MIN)", "Postprocessing (MIN)",
				"Total (MEDIAN)", "Configuration (MED)", "Run (MED)", "Postprocessing (MED)"}).collect(Collectors.joining(","));
		out.println(header);
		
		for(int numThreads : records.keySet()) {
			List<IStatsRecorder> l = records.get(numThreads);
					
			double configuration = l.stream().collect(Collectors.averagingDouble(s -> s.getConfigurationSeconds()));
			double launch = l.stream().collect(Collectors.averagingDouble(s -> s.getLaunchSeconds()));
			double post = l.stream().collect(Collectors.averagingDouble(s -> s.getPostprocessingSeconds()));
			double total = configuration + launch + post;

			
			List<Double> configurations = l.stream().map(IStatsRecorder::getConfigurationSeconds).sorted().collect(Collectors.toList());
			List<Double> launchs = l.stream().map(IStatsRecorder::getLaunchSeconds).sorted().collect(Collectors.toList());
			List<Double> posts   = l.stream().map(IStatsRecorder::getPostprocessingSeconds).sorted().collect(Collectors.toList());			
			List<Double> totals   = l.stream().map(r -> r.getConfigurationSeconds() + r.getLaunchSeconds() + r.getPostprocessingSeconds()).sorted().collect(Collectors.toList());			
			
			double configurationMedian = configurations.get(configurations.size() / 2);
			double launchsMedian = launchs.get(launchs.size() / 2);
			double postsMedian = posts.get(posts.size() / 2);
			double totalMedian = totals.get(totals.size() / 2);

			DoubleSummaryStatistics confStats = l.stream().mapToDouble(IStatsRecorder::getConfigurationSeconds).summaryStatistics();
			DoubleSummaryStatistics launchStats = l.stream().mapToDouble(IStatsRecorder::getLaunchSeconds).summaryStatistics();
			DoubleSummaryStatistics postStats = l.stream().mapToDouble(IStatsRecorder::getPostprocessingSeconds).summaryStatistics();

			String[] columns = new String[5 + 4 + 4];
			columns[0] = Integer.toString(numThreads);
			columns[1] = String.format(Locale.ROOT, "%.3f", total );
			columns[2] = String.format(Locale.ROOT, "%.3f", configuration );
			columns[3] = String.format(Locale.ROOT, "%.3f", launch );
			columns[4] = String.format(Locale.ROOT, "%.3f", post );

			columns[5] = String.format(Locale.ROOT, "%.3f", confStats.getMin() + launchStats.getMin() + postStats.getMin());
			columns[6] = String.format(Locale.ROOT, "%.3f", confStats.getMin() );
			columns[7] = String.format(Locale.ROOT, "%.3f", launchStats.getMin() );
			columns[8] = String.format(Locale.ROOT, "%.3f", postStats.getMin() );
			
			columns[9] = String.format(Locale.ROOT, "%.3f", totalMedian );
			columns[10] = String.format(Locale.ROOT, "%.3f", configurationMedian );
			columns[11] = String.format(Locale.ROOT, "%.3f", launchsMedian );
			columns[12] = String.format(Locale.ROOT, "%.3f", postsMedian );

			String row = Arrays.stream(columns).collect(Collectors.joining(","));

			out.println(row);
		}
	}

	public void printExtendedCSVto(PrintStream out) {
		String header0 = Arrays.stream(new String[] { name, "", "", "", ""}).collect(Collectors.joining(","));
		out.println(header0);
		String header = Arrays.stream(new String[] { "Threads", "Total", "Configuration", "Run", "Postprocessing" })
				.collect(Collectors.joining(","));
		out.println(header);
		
		for(int numThreads : records.keySet()) {
			List<IStatsRecorder> l = records.get(numThreads);
			for(IStatsRecorder r : l) {		
			
				double configuration = r.getConfigurationSeconds();
				double launch = r.getLaunchSeconds();
				double post = r.getPostprocessingSeconds();
				double total = configuration + launch + post;
	
				String[] columns = new String[5];
				columns[0] = Integer.toString(numThreads);
				columns[1] = String.format(Locale.ROOT, "%.3f", total );
				columns[2] = String.format(Locale.ROOT, "%.3f", configuration );
				columns[3] = String.format(Locale.ROOT, "%.3f", launch );
				columns[4] = String.format(Locale.ROOT, "%.3f", post );
	
				String row = Arrays.stream(columns).collect(Collectors.joining(","));
	
				out.println(row);
			}
		}
	}

	
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

	public String getName() {
		return name;
	}


}
