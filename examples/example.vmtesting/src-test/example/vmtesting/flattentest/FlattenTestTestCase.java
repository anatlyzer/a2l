package example.vmtesting.flattentest;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class FlattenTestTestCase extends AbstractTestCase {
	private static final String t = "transformations/FlattenTest/";
	
	private static final String METAMODEL_UML = "http://www.eclipse.org/uml2/3.0.0/UML";
	private static final String OUT_MODEL_ATL = "outputs/FlattenTest.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/FlattenTest.out.lintra.xmi";
	private static final String IN_MODEL = t + "TestEntry.uml";

	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Flatten_fixed.atl", 
				inModel("IN", IN_MODEL, "UML", METAMODEL_UML),
				outModel("OUT", OUT_MODEL_ATL, "UML2", METAMODEL_UML));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new FlattenTestRunner().
			setIN(IN_MODEL, METAMODEL_UML).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_UML).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
