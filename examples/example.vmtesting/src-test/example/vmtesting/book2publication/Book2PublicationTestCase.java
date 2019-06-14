package example.vmtesting.book2publication;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Book2PublicationTestCase extends AbstractTestCase {
	private static final String t = "transformations/Book2Publication/";
	
	private static final String METAMODEL_BOOK_ECORE = t + "Book.ecore";
	private static final String METAMODEL_PUB_ECORE =  t + "Publication.ecore";
	private static final String OUT_MODEL_ATL = "outputs/modelBook.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/modelBook.out.lintra.xmi";
	private static final String IN_MODEL = t + "modelBook.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Book2Publication.atl", 
				inModel("IN", IN_MODEL, "Book", METAMODEL_BOOK_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Publication", METAMODEL_PUB_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new Book2PublicationRunner().
			setIN(IN_MODEL, METAMODEL_BOOK_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_PUB_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(outATL, outLintra);
	}

}
