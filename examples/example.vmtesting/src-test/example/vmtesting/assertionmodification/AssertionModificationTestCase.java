package example.vmtesting.assertionmodification;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class AssertionModificationTestCase extends AbstractTestCase {
	private static final String t = "transformations/AssertionModification/";
	
	private static final String METAMODEL_UML = "http://www.eclipse.org/uml2/2.1.0/UML";
	private static final String METAMODEL_XML_ECORE =  t + "XML.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/AssertionModification.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/AssertionModification.out.lintra.xmi";
	private static final String IN_MODEL = t + "example-UML2.uml";
	private static final String IN_MODEL_XML = t + "lib-XML.xmi";

	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		
		executor.useEMFVM();
		executor.perform(t + "AssertionModification_modified.atl", 
				inModel("IN", IN_MODEL, "UML2", METAMODEL_UML),
				inModel("Lib", IN_MODEL_XML, "XML", METAMODEL_XML_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "UML2Target", METAMODEL_UML));
		Resource outATL = executor.getModelResource("OUT");
		if ( outATL != null ) {
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new AssertionModificationRunner().
			setIN(IN_MODEL, METAMODEL_UML).
			setLib(IN_MODEL_XML, METAMODEL_XML_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_UML).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		if ( outATL != null ) {
			assertDiff(outATL, outLintra);
		} else {
			org.junit.Assert.fail("ATL resource is null");
		}
	}

}
