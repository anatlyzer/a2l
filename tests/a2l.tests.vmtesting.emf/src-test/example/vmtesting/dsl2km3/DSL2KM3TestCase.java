package example.vmtesting.dsl2km3;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.dsl2km3.DSL2KM3Runner;
import a2l.tests.vmtesting.emf.metamodels.DSL.DSLPackage;
import a2l.tests.vmtesting.emf.metamodels.KM3.KM3Package;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class DSL2KM3TestCase extends AbstractTestCase {
	private static final String t = "transformations/DSL2KM3/";
	
	private static final String METAMODEL_DSL_ECORE = t + "DSL.ecore";
	private static final String METAMODEL_KM3_ECORE =  t + "KM3_fixed.ecore";
	private static final String OUT_MODEL_ATL = "outputs/SimpleExampleMM-DSL.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/SimpleExampleMM-DSL.out.lintra.xmi";
	private static final String IN_MODEL = t + "SimpleExampleMM-DSL.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(DSLPackage.eINSTANCE);
		registerMetamodel(KM3Package.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}
	
	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		DSL2KM3Runner lintraTrafo = new DSL2KM3Runner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_KM3_ECORE).
				run();
			
		Resource outLintra = lintraTrafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;	
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "DSL2KM3.atl", 
				inModel("IN", IN_MODEL, "DSL", METAMODEL_DSL_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "KM3", METAMODEL_KM3_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
	
		return outATL;
	}

}
