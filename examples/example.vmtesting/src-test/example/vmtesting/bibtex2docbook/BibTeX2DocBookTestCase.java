package example.vmtesting.bibtex2docbook;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class BibTeX2DocBookTestCase extends AbstractTestCase {
	private static final String t = "transformations/BibTeX2DocBook/";
	
	private static final String METAMODEL_BIBTEX_ECORE = t + "BibTeX.ecore";
	private static final String METAMODEL_DOCBOOK_ECORE =  t + "DocBook.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-BibTeX.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-BibTeX.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample-BibTeX.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "BibTeX2DocBook.atl", 
				inModel("IN", IN_MODEL, "BibTeX", METAMODEL_BIBTEX_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "DocBook", METAMODEL_DOCBOOK_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new BibTeX2DocBookRunner().
			setIN(IN_MODEL, METAMODEL_BIBTEX_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_DOCBOOK_ECORE).
			run().
			getOUTResource();

		outLintra.save(null);
		
		assertDiff(METAMODEL_DOCBOOK_ECORE, outATL, outLintra);
	}

}
