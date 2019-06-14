package example.uml2er.uml2er_distinct2;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class UML2ERDistinct2TestCase extends AbstractTestCase {
	private static final String t = "Transformations/";
	
	private static final String METAMODEL_UML_ECORE = "Metamodels/SimpleUml.ecore";
	private static final String METAMODEL_ER_ECORE =  "Metamodels/ER.ecore";
	private static final String OUT_MODEL_ATL = "outputs/distinct2-looseModel.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/distinct2-looseModel.out.lintra.xmi";
	private static final String IN_MODEL = "Models/benchmark/looseModel.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "UML2ERRefactoredDistinct2.atl", 
				inModel("IN", IN_MODEL, "SimpleUML", METAMODEL_UML_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "ER", METAMODEL_ER_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new RunUML2ERDistinct2().
			setIN(IN_MODEL, METAMODEL_UML_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_ER_ECORE).
			run().
			getOUTResource();

		assertDiff(outATL, outLintra);
	}

}
