package a2l.tests.dblp_v2;


import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import dblp.AuthorInfo.AuthorInfoPackage;
import dblp.DBLP.DBLPPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class DBLPv2_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_DBLP = "metamodels/DBLP.ecore";
	private static final String METAMODEL_AUTHOR_INFO = "metamodels/AuthorInfo.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	private static final String trafo = "DBLP_v2.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(DBLPPackage.eINSTANCE);
		registerMetamodel(AuthorInfoPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new DBLPv2_TestCase().doBenchmark(arguments, trafo);		
	}

	
	@Test
	public void test1() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "inputs/dblp.xmi", ExecutionFramework.BOTH), trafo);
	}

	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		IFootprint footprintObject = footprint ? 
				new a2l.tests.dblp_v2.optimised.DBLPv2Footprint() : 
				null; 
		
		if ( optimised ) {
			outLintra = new a2l.tests.dblp_v2.optimised.DBLPv2Runner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				//setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_AUTHOR_INFO).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			outLintra = new a2l.tests.dblp_v2.normal.DBLPv2Runner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_AUTHOR_INFO).
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
				inModel("IN", inXmiPath, "MM", METAMODEL_DBLP),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_AUTHOR_INFO));
		outATL = executor.getModelResource("OUT");
		if ( save )
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}

	@Override
	protected Object executeEMFTVM(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder,
			boolean footprint, boolean save) throws Exception {
		Resource outATL;
		System.out.print("Executing EMFTVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFTVM();
		executor.setStatsRecorder(recorder);
		executor.doModelWarmup(footprint);
		executor.allowInterModelReferences(false);
		executor.perform(t + trafo, 
				inModel("IN", inXmiPath, "MM", METAMODEL_DBLP),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_AUTHOR_INFO));
		outATL = executor.getModelResource("OUT");
		if ( save )
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}
	
}
 