package example.vmtesting.ecore2class;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Ecore2ClassTestCase extends AbstractTestCase {
	private static final String t = "transformations/Ecore2Class/";
	
	private static final String METAMODEL_EMF_ECORE = "http://www.eclipse.org/emf/2002/Ecore";
	private static final String METAMODEL_CLASS_ECORE =  t + "Class.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-Class.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-Class.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample.xmi";

	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Ecore2Class.atl", 
				inModel("IN", IN_MODEL, "MOF", METAMODEL_EMF_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Class", METAMODEL_CLASS_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new Ecore2ClassRunner().
			setIN(IN_MODEL, METAMODEL_EMF_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_CLASS_ECORE).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
