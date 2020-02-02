package example.vmtesting.dslmodel2km2;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.dsl2km3.DSL2KM3Runner;
import a2l.tests.vmtesting.emf.dslmodel2km2.DSLModel2KM2Runner;
import a2l.tests.vmtesting.emf.dslmodel2km2.KM2.KM2Package;
import a2l.tests.vmtesting.emf.metamodels.DSL.DSLPackage;
import a2l.tests.vmtesting.emf.metamodels.DSLModel.DSLModelPackage;
import a2l.tests.vmtesting.emf.metamodels.KM3.KM3Package;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra.evaluation.AbstractTestCase.Arguments;
import lintra.evaluation.AbstractTestCase.ExecutionFramework;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class DSLModel2KM2TestCase extends AbstractTestCase {
	private static final String t = "transformations/DSLModel2KM2/";
	
	private static final String METAMODEL_DSL_ECORE = t + "DSL.ecore";
	private static final String METAMODEL_DSL_MODEL_ECORE = t + "DSLModel.ecore";
	private static final String METAMODEL_KM2_ECORE =  t + "KM2.ecore";
	private static final String OUT_MODEL_ATL = "outputs/DSLModel2KM2.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/DSLModel2KM2.out.lintra.xmi";
	private static final String IN1_MODEL = t + "SimpleExampleM-DSLModel.xmi";
	private static final String IN2_MODEL = t + "SimpleExampleMM-DSL.xmi";
	
	@Override
	protected boolean compareAsTextLevel() {
		return true;
	}
	
	@Test
	public void test() throws Exception {
		registerMetamodel(DSLPackage.eINSTANCE);
		registerMetamodel(DSLModelPackage.eINSTANCE);
		registerMetamodel(KM2Package.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN1_MODEL, ExecutionFramework.BOTH), t);
	}
		
	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		DSLModel2KM2Runner trafo = new DSLModel2KM2Runner().
				setStatsRecorder(recorder).
				setIN1(load(IN1_MODEL)).
				setIN2(load(IN2_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_KM2_ECORE).
				run();
			
		Resource outLintra = trafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;	
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "DSLModel2KM2_fixed.atl", 
				inModel("IN1", IN1_MODEL, "DSLModel", METAMODEL_DSL_MODEL_ECORE),
				inModel("IN2", IN2_MODEL, "DSL", METAMODEL_DSL_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "KM2", METAMODEL_KM2_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
	
		return outATL;
	}

}
