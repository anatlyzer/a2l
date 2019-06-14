package a2l.tests.findcouples.lintra;


import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import imdb.movies.MoviesPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class FindCouplesIMDb_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_MOVIES = "metamodels/movies.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static final String trafo = "IdentityIMDb.atl";
	
	public static void main(String[] args) throws Exception {
		if ( args.length == 0 ) {
			System.out.println("Run with:");
			System.out.println("   minThreads maxThreads numRuns model framework");
		} else {
			int min  = Integer.parseInt(args[0]);
			int max  = Integer.parseInt(args[1]);
			int runs = Integer.parseInt(args[2]);			
			String model = args[3];
			ExecutionFramework framework = toFramework(args[4]);			
			new FindCouplesIMDb_TestCase().testRun(min, max, runs, model, framework);
		}
	}
	
	@Test
	public void testCompareResults() throws Exception {
		testRun(1, 1, 1, "imdb-0.1.xmi", ExecutionFramework.BOTH);
	}
	
	public void testRun(int minThreads, int maxThreads, int runsPerTest, String model, ExecutionFramework framework) throws FileNotFoundException, IOException, Exception {
		Resource outLintra = null;
		Resource outATL = null; 
		
		registerMetamodel(MoviesPackage.eINSTANCE);
		String inXmiPath = "inputs/" + model;
		Resource input = load(inXmiPath);
		
		if ( framework == ExecutionFramework.A2L || framework == ExecutionFramework.BOTH ) {
			AggregatedStatsRecorder recorder = new AggregatedStatsRecorder(getName() + "_" + inXmiPath);
			for(int i = minThreads; i <= maxThreads; i++) {
				int numThreads = i;
				recorder.testWithNumThreads(i);
				for(int j = 0; j < runsPerTest; j++) {
					recorder.startNewTest();
					outLintra = executeLintra(input, numThreads, recorder);
					recorder.printCurrentTo(System.out);
					System.gc();
				}
			}
	
			System.out.println("************");
			System.out.println("Run finised!");
			System.out.println("************");
			recorder.printTo(System.out);
			
			recorder.printCSVto(new PrintStream("tmp/" + "result_" + getName() + ".csv"));
		}

		if ( framework == ExecutionFramework.ATL || framework == ExecutionFramework.BOTH ) {
			AggregatedStatsRecorder recorder = new AggregatedStatsRecorder(getName() + "_" + inXmiPath + "_ATL");
			recorder.testWithNumThreads(1);
			for(int j = 0; j < runsPerTest; j++) {
				recorder.startNewTest();			
				outATL = executeATL(trafo, inXmiPath, input, recorder, true);
				recorder.printCurrentTo(System.out);
			}
			
			recorder.printTo(System.out);
			
			recorder.printCSVto(new PrintStream("/tmp/" + "result_" + getName() + "-ATL.csv"));
		}
		
		System.out.println("*******");
		System.out.println("Bye!");
		System.out.println("*******");
		
		if ( framework == ExecutionFramework.BOTH ) {		
			assertDiff(outATL, outLintra);
		}		
	}
	

	private Resource executeLintra(Resource input, int numThreads, AggregatedStatsRecorder recorder)
			throws Exception, IOException, FileNotFoundException {
		Resource outLintra;
		System.out.print("Executing Lintra with " + numThreads + " ... ");
		
		// SingleStatsRecorder recorder = new SingleStatsRecorder();
		outLintra = new FindCouplesIMDbRunner().
		//outLintra = new FindCouplesIMDbRunner_Nonblocking().
			setStatsRecorder(recorder).
			//setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
			setIN(input).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
			setNumThreads(numThreads).
			run().
			getOUTResource();
		
		System.out.println();
		//recorder.printTo(System.out);
		
		//outLintra.save(new FileOutputStream(OUT_MODEL_LINTRA), null);
		return outLintra;
	}

	@Override
	protected Resource executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save) throws IOException, FileNotFoundException {
		Resource outATL;
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.doModelWarmup(true);
		executor.allowInterModelReferences(false);
		executor.perform(t + trafo, 
				inModel("IN", inXmiPath, "MM", METAMODEL_MOVIES),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_MOVIES));
		outATL = executor.getModelResource("OUT");
		if ( save ) 
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}

	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {
		throw new UnsupportedOperationException("TODO: Fix this test case");
	}



}
 