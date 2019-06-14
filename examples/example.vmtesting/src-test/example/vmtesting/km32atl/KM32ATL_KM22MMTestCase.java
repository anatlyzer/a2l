package example.vmtesting.km32atl;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class KM32ATL_KM22MMTestCase extends AbstractTestCase {
	private static final String t = "transformations/KM32ATL_KM22MM/";
	
	private static final String METAMODEL_KM3_ECORE = t + "KM3.ecore";
	private static final String METAMODEL_ATL_ECORE =  t + "ATL.ecore";
	private static final String OUT_MODEL_ATL = "outputs/SimpleExampleMM-KM3-2.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/SimpleExampleMM-KM3-2.out.lintra.xmi";
	private static final String IN_MODEL = t + "SimpleExampleMM-KM3-2.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "KM32ATL_KM22MM2_fixed.atl", 
				inModel("IN", IN_MODEL, "KM3", METAMODEL_KM3_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "ATL", METAMODEL_ATL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new KM32ATL_KM22MMRunner().
			setIN(IN_MODEL, METAMODEL_KM3_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_ATL_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra, UseIdentifiers.WHEN_AVAILABLE);
	}

}
