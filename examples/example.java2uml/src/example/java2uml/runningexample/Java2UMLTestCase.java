package example.java2uml.runningexample;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;
import java.util.logging.Level;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.common.ATLLogger;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Java2UMLTestCase extends AbstractTestCase {
	private static final String t = "transformations/java2uml/";
	
	private static final String METAMODEL_UML_ECORE = "http://www.eclipse.org/uml2/3.0.0/UML";
	private static final String METAMODEL_JAVA_ECORE = "http://www.eclipse.org/MoDisco/Java/0.2.incubation/java";
	
	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
	 private static final String IN_MODEL = t + "models/ac.at.tuwien.big.scenario.test_java.xmi";
	// private static final String IN_MODEL = t + "models/eclipseModel-0.1.xmi";
//	private static final String IN_MODEL = t + "models/eclipseModel-2.0.xmi";

	int NUM_EXECUTIONS = 1;
	
	@Test
	public void test() throws Exception {
		ATLLogger.getLogger().setLevel(Level.OFF);

		
		for(int i = 0; i < NUM_EXECUTIONS; i++ ) {
			
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.allowInterModelReferences(false);
		executor.perform(t + "java2uml_running_emf.atl", 
				inModel("CM", IN_MODEL, "JMM", METAMODEL_JAVA_ECORE),
				outModel("UCD", OUT_MODEL_ATL, "UMLMM", METAMODEL_UML_ECORE));
		Resource outATL = executor.getModelResource("UCD");
//		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new RunJava2UML().
			setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_UML_ECORE).
			run().
			getOUTResource();
		
//		assertDiff(outATL, outLintra);

		
		}
	}
}
