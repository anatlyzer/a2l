package example.vmtesting.xml2dslmodel;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class XML2DSLModelTestCase extends AbstractTestCase {
	private static final String t = "transformations/XML2DSLModel/";
	
	private static final String METAMODEL_XML_ECORE = t + "XML.ecore";
	private static final String METAMODEL_DSL_ECORE =  t + "DSL.ecore";
	private static final String METAMODEL_DSL_MODEL_ECORE =  t + "DSLModel.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/XML2DSLModel.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/XML2DSLModel.out.lintra.xmi";
	private static final String IN_MODEL = t + "SimpleExampleM-XML.xmi";
	private static final String IN_MODEL2 = t + "SimpleExampleMM-DSL.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "XML2DSLModel.atl", 
				inModel("IN1", IN_MODEL, "XML", METAMODEL_XML_ECORE),
				inModel("IN2", IN_MODEL2, "DSL", METAMODEL_DSL_ECORE),				
				outModel("OUT", OUT_MODEL_ATL, "DSLModel", METAMODEL_DSL_MODEL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new XML2DSLModelRunner().
			setIN1(IN_MODEL, METAMODEL_XML_ECORE).
			setIN2(IN_MODEL2, METAMODEL_DSL_ECORE).			
			setOUT(OUT_MODEL_LINTRA, METAMODEL_DSL_MODEL_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra, UseIdentifiers.WHEN_AVAILABLE);
	}

}
