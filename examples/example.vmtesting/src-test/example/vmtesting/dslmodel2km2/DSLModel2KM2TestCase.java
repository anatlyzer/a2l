package example.vmtesting.dslmodel2km2;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class DSLModel2KM2TestCase extends AbstractTestCase {
	private static final String t = "transformations/DSLModel2KM2/";
	
	private static final String METAMODEL_DSL_ECORE = t + "DSL.ecore";
	private static final String METAMODEL_DSL_MODEL_ECORE = t + "DSLModel.ecore";
	private static final String METAMODEL_KM2_ECORE =  t + "KM2.ecore";
	private static final String OUT_MODEL_ATL = "outputs/DSLModel2KM2.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/DSLModel2KM2.out.lintra.xmi";
	private static final String IN1_MODEL = t + "SimpleExampleM-DSLModel.xmi";
	private static final String IN2_MODEL = t + "SimpleExampleMM-DSL.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "DSLModel2KM2_fixed.atl", 
				inModel("IN1", IN1_MODEL, "DSLModel", METAMODEL_DSL_MODEL_ECORE),
				inModel("IN2", IN2_MODEL, "DSL", METAMODEL_DSL_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "KM2", METAMODEL_KM2_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new DSLModel2KM2Runner().
			setIN1(IN1_MODEL, METAMODEL_DSL_MODEL_ECORE).
			setIN2(IN2_MODEL, METAMODEL_DSL_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_KM2_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra, UseIdentifiers.ONLY);
	}

}
