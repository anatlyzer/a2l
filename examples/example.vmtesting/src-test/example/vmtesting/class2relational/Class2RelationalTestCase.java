package example.vmtesting.class2relational;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Class2RelationalTestCase extends AbstractTestCase {
	private static final String t = "transformations/Class2Relational/";
	
	private static final String METAMODEL_CLASS_ECORE = t + "Class.ecore";
	private static final String METAMODEL_RELATIONAL_ECORE =  t + "Relational.ecore";
	private static final String OUT_MODEL_ATL = "outputs/inClass.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/inClass.out.lintra.xmi";
	private static final String IN_MODEL = t + "inClass.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Class2Relational.atl", 
				inModel("IN", IN_MODEL, "Class", METAMODEL_CLASS_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Relational", METAMODEL_RELATIONAL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new Class2RelationalRunner().
			setIN(IN_MODEL, METAMODEL_CLASS_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_RELATIONAL_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
