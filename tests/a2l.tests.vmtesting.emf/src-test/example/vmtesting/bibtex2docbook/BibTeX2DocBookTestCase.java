package example.vmtesting.bibtex2docbook;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import a2l.tests.vmtesting.emf.assertionmodification.AssertionModificationRunner;
import a2l.tests.vmtesting.emf.bibtex.BibTeX.BibTeXPackage;
import a2l.tests.vmtesting.emf.bibtex2docbook.BibTeX2DocBookRunner;
import a2l.tests.vmtesting.emf.docbook.DocBook.DocBookPackage;
import a2l.tests.vmtesting.emf.metamodels.xml.XML.XML.XMLPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra.evaluation.AbstractTestCase.Arguments;
import lintra.evaluation.AbstractTestCase.ExecutionFramework;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class BibTeX2DocBookTestCase extends AbstractTestCase {
	private static final String t = "transformations/BibTeX2DocBook/";
	
	private static final String METAMODEL_BIBTEX_ECORE = t + "BibTeX.ecore";
	private static final String METAMODEL_DOCBOOK_ECORE =  t + "DocBook.ecore";
	private static final String OUT_MODEL_ATL = "outputs/sample-BibTeX.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/sample-BibTeX.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample-BibTeX.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(BibTeXPackage.eINSTANCE);
		registerMetamodel(DocBookPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		BibTeX2DocBookRunner lintraTrafo = new BibTeX2DocBookRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_DOCBOOK_ECORE).		
				run();
			
		Resource outLintra = lintraTrafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		
		executor.setStatsRecorder(recorder);
		executor.useEMFVM();
		executor.perform(t + "BibTeX2DocBook.atl", 
				inModel("IN", inXmiPath, "BibTeX", METAMODEL_BIBTEX_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "DocBook", METAMODEL_DOCBOOK_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		if ( outATL != null ) {
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		return outATL;
	}

}
