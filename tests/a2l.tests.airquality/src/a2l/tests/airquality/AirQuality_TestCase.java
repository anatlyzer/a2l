package a2l.tests.airquality;


import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import airquality.AirqualityPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class AirQuality_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_MOVIES = "metamodels/AirQuality.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static final String trafo = "AirQualityReport.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(AirqualityPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new AirQuality_TestCase().doBenchmark(arguments, trafo);		
	}

	@Test
	public void testCompareResults() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "AirMeasurement-small.xmi", ExecutionFramework.BOTH), trafo);
	}
	
	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		System.out.println(input.getURI().toString());
		
		if ( optimised ) {
			IFootprint footprintObject = footprint ? 
					// new a2l.tests.airquality.optimised.AirQualityReportFootprint(): 
					new a2l.tests.airquality.optimised.AirQualityReportFootprint():
					null; 

			outLintra = new a2l.tests.airquality.optimised.AirQualityReportRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.airquality.normal.AirQualityReportFootprint(): 
					null; 

			outLintra = new a2l.tests.airquality.normal.AirQualityReportRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setIN(input).
					setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
					setNumThreads(numThreads).
					run().
					getOUTResource();						
		}
		
		outLintra.save(null);
		
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
 
