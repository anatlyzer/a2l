package example.vmtesting.book2publication;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.book2publication.Book2PublicationRunner;
import a2l.tests.vmtesting.emf.metamodels.Book.BookPackage;
import a2l.tests.vmtesting.emf.metamodels.Publication.PublicationPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class Book2PublicationTestCase extends AbstractTestCase {
	private static final String t = "transformations/Book2Publication/";
	
	private static final String METAMODEL_BOOK_ECORE = t + "Book.ecore";
	private static final String METAMODEL_PUB_ECORE =  t + "Publication.ecore";
	private static final String OUT_MODEL_ATL = "outputs/modelBook.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/modelBook.out.lintra.xmi";
	private static final String IN_MODEL = t + "modelBook.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(BookPackage.eINSTANCE);
		registerMetamodel(PublicationPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		Book2PublicationRunner lintraTrafo = new Book2PublicationRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_PUB_ECORE).		
				run();
			
		Resource outLintra = lintraTrafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "Book2Publication.atl", 
				inModel("IN", IN_MODEL, "Book", METAMODEL_BOOK_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Publication", METAMODEL_PUB_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
	
		return outATL;
	}
	
	

}
