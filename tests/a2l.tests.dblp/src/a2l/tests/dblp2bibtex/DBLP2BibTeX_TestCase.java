package a2l.tests.dblp2bibtex;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.bibtex.BibTeX.BibTeXPackage;
import dblp.AuthorInfo.AuthorInfoPackage;
import dblp.DBLP.DBLPPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class DBLP2BibTeX_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_DBLP = "metamodels/DBLP.ecore";
	private static final String METAMODEL_BIBTEX = "metamodels/BibTeX.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/bibtex.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/bibtex.a2l.xmi";
	private static final String trafo = "dblp2bibtex/dblp2bibtex_map.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(DBLPPackage.eINSTANCE);
		registerMetamodel(BibTeXPackage.eINSTANCE);

		Arguments arguments = parseArguments(args);
		new DBLP2BibTeX_TestCase().doBenchmark(arguments, trafo);		
	}

	
	@Test
	public void test1() throws Exception {
		doBenchmark(new Arguments(1, 1, 1, "dblp.xmi", ExecutionFramework.BOTH), trafo);
	}

	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder, boolean save) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		
		if ( optimised ) {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXFootprint() : 
					null; 

			outLintra = new a2l.tests.dblp2bibtex.optimised.DBLP2BibTeXRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				//setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_BIBTEX).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.dblp2bibtex.normal.DBLP2BibTeXFootprint() : 
					null; 

			outLintra = new a2l.tests.dblp2bibtex.normal.DBLP2BibTeXRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_BIBTEX).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		}
			
		if (save)
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
				inModel("IN", inXmiPath, "DBLP", METAMODEL_DBLP),
				outModel("OUT", OUT_MODEL_ATL, "BT", METAMODEL_BIBTEX));
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
				inModel("IN", inXmiPath, "DBLP", METAMODEL_DBLP),
				outModel("OUT", OUT_MODEL_ATL, "BT", METAMODEL_BIBTEX));
		outATL = executor.getModelResource("OUT");
		if ( save )
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");
		return outATL;
	}

}
 
