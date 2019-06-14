package example.vmtesting.class2relational;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.book2publication.Book2PublicationRunner;
import a2l.tests.vmtesting.emf.class2relational.Class2RelationalRunner;
import a2l.tests.vmtesting.emf.class2relational.classmm.Class.ClassPackage;
import a2l.tests.vmtesting.emf.class2relational.relational.Relational.RelationalPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class Class2RelationalTestCase extends AbstractTestCase {
	private static final String t = "transformations/Class2Relational/";
	
	private static final String METAMODEL_CLASS_ECORE = t + "Class.ecore";
	private static final String METAMODEL_RELATIONAL_ECORE =  t + "Relational.ecore";
	private static final String OUT_MODEL_ATL = "outputs/inClass.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/inClass.out.lintra.xmi";
	private static final String IN_MODEL = t + "inClass.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(ClassPackage.eINSTANCE);
		registerMetamodel(RelationalPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {
		Class2RelationalRunner lintraTrafo = new Class2RelationalRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_CLASS_ECORE).		
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
		executor.perform(t + "Class2Relational.atl", 
				inModel("IN", IN_MODEL, "Class", METAMODEL_CLASS_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Relational", METAMODEL_RELATIONAL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
	
		return outATL;
	}

}
