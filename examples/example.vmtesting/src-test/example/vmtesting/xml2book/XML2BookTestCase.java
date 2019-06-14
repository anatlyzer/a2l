package example.vmtesting.xml2book;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class XML2BookTestCase extends AbstractTestCase {
	private static final String t = "transformations/XML2Book/";
	
	private static final String METAMODEL_XML_ECORE = t + "XML.ecore";
	private static final String METAMODEL_BOOK_ECORE =  t + "Book.ecore";
	private static final String OUT_MODEL_ATL = "outputs/XML2Book.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/XML2Book.out.lintra.xmi";
	private static final String IN_MODEL = t + "inputModelXML.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "XML2Book.atl", 
				inModel("IN", IN_MODEL, "XML", METAMODEL_XML_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Book", METAMODEL_BOOK_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new XML2BookRunner().
			setIN(IN_MODEL, METAMODEL_XML_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_BOOK_ECORE).
			run().
			getOUTResource();

		assertDiff(outATL, outLintra);
	}

}
