package example.vmtesting.ecore2class;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.ecore2class.Ecore2ClassRunner;
import a2l.tests.vmtesting.emf.ecore2class.Class.ClassMMPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class Ecore2ClassTestCase extends AbstractTestCase {
	private static final String t = "transformations/Ecore2Class/";
	
	private static final String METAMODEL_EMF_ECORE = "http://www.eclipse.org/emf/2002/Ecore";
	private static final String METAMODEL_CLASS_ECORE =  t + "Class.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-Class.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-Class.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample.xmi";

	@Test
	public void test() throws Exception {
		registerMetamodel(ClassMMPackage.eINSTANCE);		
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}
	
	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		Ecore2ClassRunner trafo = new Ecore2ClassRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_CLASS_ECORE).		
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
		executor.perform(t + "Ecore2Class.atl", 
				inModel("IN", IN_MODEL, "MOF", METAMODEL_EMF_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Class", METAMODEL_CLASS_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
		
		return outATL;
	}

}
