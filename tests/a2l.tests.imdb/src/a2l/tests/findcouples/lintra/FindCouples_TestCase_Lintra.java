package a2l.tests.findcouples.lintra;


import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.logging.Level;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import imdb.movies.MoviesPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class FindCouples_TestCase_Lintra extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_MOVIES = "metamodels/movies.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	String trafo = "FindCouples.atl";
	
	public static void main(String[] args) throws Exception {
		new FindCouples_TestCase_Lintra().test1();
	}
	
	@Test
	public void test1() throws Exception {		
		int numThreads = 2;
		Resource outLintra = null;
		Resource outATL = null; 
		
		registerMetamodel(MoviesPackage.eINSTANCE);
		//String inXmiPath = "inputs/imdb-0.1.xmi";
		String inXmiPath = "inputs/imdb-0.5.xmi";
		Resource input = load(inXmiPath);
		//outATL = executeATL(trafo, inXmiPath, input);
		
//		for(int i = 0; i <= 12; i = i + 2) {
//			System.gc();System.gc();
//			numThreads = i;
//			outLintra = executeLintra(input, numThreads == 0 ? 1 : numThreads);
//		}

		for(int i = 0; i < 200; i++) {
			numThreads = 12;
			outLintra = executeLintra(input, numThreads);
		}

		
		//assertDiff(outATL, outLintra);
		
//		for(int i = 1; i < 4; i++) {
//			outLintra = executeLintra(input, i);
//		}
	}
	
//	@Test
//	public void test1() throws Exception {		
//		int numThreads = 1;
//		
//		Resource outLintra = null;
//		Resource outATL = null; 
//		
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//		Resource input = load(inXmiPath);
//		outATL = executeATL(trafo, input);
//		outLintra = executeLintra(input, numThreads);
//		assertDiff(outATL, outLintra);
//	}
//	
	private Resource executeLintra(Resource input, int numThreads)
			throws Exception, IOException, FileNotFoundException {
		Resource outLintra;
		System.out.print("Executing Lintra with " + numThreads + " ... ");
		outLintra = new FindCouplesIMDbRunner().
			//setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
			setIN(input).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
			setNumThreads(numThreads).
			run().
			getOUTResource();
		
		//outLintra.save(new FileOutputStream(OUT_MODEL_LINTRA), null);
		return outLintra;
	}

	private Resource executeATL(String trafo, String inXmiPath, Resource input) throws IOException, FileNotFoundException {
		Resource outATL;
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.doModelWarmup(true);
		executor.allowInterModelReferences(false);
		executor.perform(t + trafo, 
				inModel("IN", inXmiPath, "MM", METAMODEL_MOVIES),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_MOVIES));
		outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}

	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {
		throw new UnsupportedOperationException("TODO: Fix this test case");
	}

	@Override
	protected Resource executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		throw new UnsupportedOperationException("TODO: Fix this test case");
	}



}
 