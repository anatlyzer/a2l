package a2l.tests.atlmr;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.junit.Test;

import a2l.tests.atlmr.anomalies.AnomaliesPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class CheckStyleTestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_GRAPH = "metamodels/Graph.ecore";
	private static final String METAMODEL_JAVA_ECORE = JavaPackage.eINSTANCE.getNsURI();
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static String trafo = "Java2Graph.atl";

	public static void main(String[] args) throws Exception {
		registerMetamodel(AnomaliesPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new CheckStyleTestCase().doBenchmark(arguments, trafo);		
	}

	@Test
	public void testCompareResults() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "eclipseModel-0.5.xmi", ExecutionFramework.BOTH), trafo);
	}
	
	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		if ( optimised ) {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.java2graph.optimised.Java2GraphFootprint() : 
					null; 
					
			outLintra = new a2l.tests.java2graph.optimised.Java2GraphRunner().
				setFootprint(footprintObject).
				setStatsRecorder(recorder).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_GRAPH).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.java2graph.normal.Java2GraphFootprint() : 
					null; 
					
			outLintra = new a2l.tests.java2graph.normal.Java2GraphRunner().
				setFootprint(footprintObject).
				setStatsRecorder(recorder).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_GRAPH).
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
				inModel("IN", inXmiPath, "MM", METAMODEL_JAVA_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_GRAPH));
		outATL = executor.getModelResource("OUT");
		if ( save )
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}
}
 