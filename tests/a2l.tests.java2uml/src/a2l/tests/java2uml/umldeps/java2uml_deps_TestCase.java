package a2l.tests.java2uml.umldeps;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmt.modisco.java.emf.JavaPackage;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
import lintra2.transfo.IFootprint;

public class java2uml_deps_TestCase extends AbstractTestCase {
	private static final String t = "transformations/";
	
	private static final String METAMODEL_UML_ECORE = UMLPackage.eINSTANCE.getNsURI();
	private static final String METAMODEL_JAVA_ECORE = JavaPackage.eINSTANCE.getNsURI();
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	
	private static final String trafo = "java2uml_deps.atl";
	
	public static void main(String[] args) throws Exception {
		registerMetamodel(UMLPackage.eINSTANCE);
		registerMetamodel(JavaPackage.eINSTANCE);
		Arguments arguments = parseArguments(args);
		
		new java2uml_deps_TestCase().doBenchmark(arguments, trafo);		
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
					new a2l.tests.java2uml.umldeps.optimised.java2uml_depsFootprint() : 
					null; 
								
			outLintra = new a2l.tests.java2uml.umldeps.optimised.java2uml_depsRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setCM(input).
					setUCD(OUT_MODEL_LINTRA, METAMODEL_UML_ECORE).
					setNumThreads(numThreads).
					run().
					getUCDResource();
		} else {
			IFootprint footprintObject = footprint ? 
					new a2l.tests.java2uml.umldeps.normal.java2uml_depsFootprint() : 
					null; 
								
			outLintra = new a2l.tests.java2uml.umldeps.normal.java2uml_depsRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setCM(input).
					setUCD(OUT_MODEL_LINTRA, METAMODEL_UML_ECORE).
					setNumThreads(numThreads).
					run().
					getUCDResource();			
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
				inModel("CM", input, "JMM", METAMODEL_JAVA_ECORE),
				outModel("UCD", OUT_MODEL_ATL, "UMLMM", METAMODEL_UML_ECORE));
		outATL = executor.getModelResource("UCD");
		if ( save ) {
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");
		return outATL;
		
	}
	
}
 