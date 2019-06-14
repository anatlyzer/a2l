package a2l.tests.findcouples;


import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import imdb.movies.MoviesPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class FindCouples_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_MOVIES = "metamodels/movies.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static final String trafo = "FindCouples.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(MoviesPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new FindCouples_TestCase().doBenchmark(arguments, trafo);		
	}

	@Test
	public void testCompareResults() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "imdb-0.1.xmi", ExecutionFramework.BOTH), trafo);
	}
	
	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		if ( optimised ) {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.findcouples.optimised.FindCouplesIMDbFootprint() : 
					null; 

			outLintra = new a2l.tests.findcouples.optimised.FindCouplesIMDbRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.findcouples.normal.FindCouplesIMDbFootprint() : 
					null; 

			outLintra = new a2l.tests.findcouples.normal.FindCouplesIMDbRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setIN(input).
					setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
					setNumThreads(numThreads).
					run().
					getOUTResource();						
		}
		
		System.out.println();
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
		if ( save ) {
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");
		return outATL;
	}


}
 
