package example.vmtesting.dsl2km3;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class DSL2KM3TestCase extends AbstractTestCase {
	private static final String t = "transformations/DSL2KM3/";
	
	private static final String METAMODEL_DSL_ECORE = t + "DSL.ecore";
	private static final String METAMODEL_KM3_ECORE =  t + "KM3_fixed.ecore";
	private static final String OUT_MODEL_ATL = "outputs/SimpleExampleMM-DSL.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/SimpleExampleMM-DSL.out.lintra.xmi";
	private static final String IN_MODEL = t + "SimpleExampleMM-DSL.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "DSL2KM3.atl", 
				inModel("IN", IN_MODEL, "DSL", METAMODEL_DSL_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "KM3", METAMODEL_KM3_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new DSL2KM3Runner().
			setIN(IN_MODEL, METAMODEL_DSL_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_KM3_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
