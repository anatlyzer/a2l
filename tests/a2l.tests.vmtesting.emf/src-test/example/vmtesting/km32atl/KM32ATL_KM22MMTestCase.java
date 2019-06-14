package example.vmtesting.km32atl;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.families2persons.Families2PersonsRunner;
import a2l.tests.vmtesting.emf.families2persons.Families.FamiliesPackage;
import a2l.tests.vmtesting.emf.families2persons.Persons.PersonsPackage;
import a2l.tests.vmtesting.emf.km32atl.KM32ATL_KM22MMRunner;
import a2l.tests.vmtesting.emf.metamodels.KM3.KM3Package;
import a2l.tests.vmtesting.emf.metamodels.atl.ATL.ATLPackage;
import a2l.tests.vmtesting.emf.metamodels.atl.OCL.OCLPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra.evaluation.AbstractTestCase.Arguments;
import lintra.evaluation.AbstractTestCase.ExecutionFramework;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class KM32ATL_KM22MMTestCase extends AbstractTestCase {
	private static final String t = "transformations/KM32ATL_KM22MM/";
	
	private static final String METAMODEL_KM3_ECORE = t + "KM3.ecore";
	private static final String METAMODEL_ATL_ECORE =  t + "ATL.ecore";
	private static final String OUT_MODEL_ATL = "outputs/SimpleExampleMM-KM3-2.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/SimpleExampleMM-KM3-2.out.lintra.xmi";
	private static final String IN_MODEL = t + "SimpleExampleMM-KM3-2.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(KM3Package.eINSTANCE);
		registerMetamodel(ATLPackage.eINSTANCE);
		registerMetamodel(OCLPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
		// assertDiff(outATL, outLintra, UseIdentifiers.WHEN_AVAILABLE);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {
		KM32ATL_KM22MMRunner trafo = new KM32ATL_KM22MMRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_ATL_ECORE).	
				run();
			
		Resource res = trafo.getOUTResource();
					
		res.save(null);
		return res;
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "KM32ATL_KM22MM2_fixed.atl", 
				inModel("IN", IN_MODEL, "KM3", METAMODEL_KM3_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "ATL", METAMODEL_ATL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
		
		return outATL;	}

}
