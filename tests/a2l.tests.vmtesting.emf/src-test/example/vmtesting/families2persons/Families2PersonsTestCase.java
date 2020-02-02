package example.vmtesting.families2persons;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.ecore2class.Ecore2ClassRunner;
import a2l.tests.vmtesting.emf.ecore2class.Class.ClassMMPackage;
import a2l.tests.vmtesting.emf.families2persons.Families2PersonsRunner;
import a2l.tests.vmtesting.emf.families2persons.Families.FamiliesPackage;
import a2l.tests.vmtesting.emf.families2persons.Persons.PersonsPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra.evaluation.AbstractTestCase.Arguments;
import lintra.evaluation.AbstractTestCase.ExecutionFramework;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class Families2PersonsTestCase extends AbstractTestCase {
	private static final String t = "transformations/Families2Persons/";
	
	private static final String METAMODEL_FAMILIES_ECORE = t + "Families_Ecore.ecore";
	private static final String METAMODEL_PERSONS_ECORE =  t + "Persons.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-Families.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-Families.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample-Families.xmi";

	@Test
	public void test() throws Exception {
		registerMetamodel(FamiliesPackage.eINSTANCE);
		registerMetamodel(PersonsPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		
		Families2PersonsRunner trafo = new Families2PersonsRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_PERSONS_ECORE).		
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
		executor.perform(t + "Families2Persons.atl", 
				inModel("IN", IN_MODEL, "Families", METAMODEL_FAMILIES_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Persons", METAMODEL_PERSONS_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
		
		return outATL;
	}

}
