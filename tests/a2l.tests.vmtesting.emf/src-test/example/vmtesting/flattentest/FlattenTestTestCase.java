package example.vmtesting.flattentest;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import a2l.tests.vmtesting.emf.families2persons.Families2PersonsRunner;
import a2l.tests.vmtesting.emf.flattentest.FlattenTestRunner;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class FlattenTestTestCase extends AbstractTestCase {
	private static final String t = "transformations/FlattenTest/";
	
	private static final String METAMODEL_UML = "http://www.eclipse.org/uml2/2.1.0/UML";
	private static final String OUT_MODEL_ATL = "outputs/FlattenTest.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/FlattenTest.out.lintra.xmi";
	private static final String IN_MODEL = t + "TestEntry.uml";

	@Test
	public void test() throws Exception {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML", UMLPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		
		ResourceSet rs = new ResourceSetImpl();
		Resource outLintra = rs.createResource(URI.createFileURI(OUT_MODEL_LINTRA));
		
		FlattenTestRunner trafo = new FlattenTestRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(outLintra, UMLPackage.eINSTANCE.eResource()).
				run();
			
		//Resource outLintra = trafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;	
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "Flatten_fixed.atl", 
				inModel("IN", IN_MODEL, "UML", METAMODEL_UML),
				outModel("OUT", OUT_MODEL_ATL, "UML2", METAMODEL_UML));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
		
		return outATL;
	}

}
