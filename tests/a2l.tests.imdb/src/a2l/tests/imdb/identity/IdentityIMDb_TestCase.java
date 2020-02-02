package a2l.tests.imdb.identity;


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

public class IdentityIMDb_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_MOVIES = MoviesPackage.eINSTANCE.getNsURI();
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static final String trafo = "IdentityIMDb.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(MoviesPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new IdentityIMDb_TestCase().doBenchmark(arguments, trafo);		
	}

	@Test
	public void testCompareResults() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "imdb-0.1.xmi", ExecutionFramework.BOTH), trafo);
	}
	
	
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder, boolean save) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		IFootprint footprintObject = footprint ? 
				new a2l.tests.imdb.identity.optimised.IdentityIMDbFootprint() : 
				null; 
		
		if ( optimised ) {
			System.out.println("Optimised");
			outLintra = new a2l.tests.imdb.identity.optimised.IdentityIMDbRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			System.out.println("Normal");
			outLintra = new a2l.tests.imdb.identity.normal.IdentityIMDbRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setIN(input).
					setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
					setNumThreads(numThreads).
					run().
					getOUTResource();			
		}
		
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
		if ( save ) {
			System.out.println("Finished... saving result...");
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");
		return outATL;
	}

	@Override
	protected Object executeEMFTVM(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean footprint, boolean save) throws Exception {
		Resource outATL;
		System.out.print("Executing EMTFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFTVM();
		executor.setStatsRecorder(recorder);
		executor.doModelWarmup(true);
		executor.allowInterModelReferences(false);
		executor.perform(t + trafo, 
				inModel("IN", inXmiPath, "MM", METAMODEL_MOVIES),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_MOVIES));
		outATL = executor.getModelResource("OUT");
		if ( save ) {
			System.out.println("Finished... saving result...");
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");
		return outATL;
	}
	
	

}
 