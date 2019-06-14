package example.vmtesting.families2persons;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Families2PersonsTestCase extends AbstractTestCase {
	private static final String t = "transformations/Families2Persons/";
	
	private static final String METAMODEL_FAMILIES_ECORE = t + "Families_Ecore.ecore";
	private static final String METAMODEL_PERSONS_ECORE =  t + "Persons.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-Families.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-Families.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample-Families.xmi";

	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Families2Persons.atl", 
				inModel("IN", IN_MODEL, "Families", METAMODEL_FAMILIES_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Persons", METAMODEL_PERSONS_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new Families2PersonsRunner().
			setIN(IN_MODEL, METAMODEL_FAMILIES_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_PERSONS_ECORE).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
