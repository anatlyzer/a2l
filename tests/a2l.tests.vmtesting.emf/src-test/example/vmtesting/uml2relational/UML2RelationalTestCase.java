package example.vmtesting.uml2relational;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import a2l.tests.vmtesting.emf.class2relational.relational.Relational.RelationalPackage;
import a2l.tests.vmtesting.emf.families2persons.Families2PersonsRunner;
import junit.framework.Assert;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class UML2RelationalTestCase extends AbstractTestCase {
	private static final String t = "transformations/UML2Relational/";
	
	private static final String METAMODEL_UML = "http://www.eclipse.org/uml2/2.1.0/UML";
	private static final String METAMODEL_RELATIONAL_ECORE =  t + "relational.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/UML2Relational.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/UML2Relational.out.lintra.xmi";
	private static final String IN_MODEL = t + "sample-Relational.uml";

	@Test
	public void test() throws Exception {
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML", UMLPackage.eINSTANCE);
		registerMetamodel(RelationalPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
		
//		if ( outATL != null ) {
//			// TODO: For some reason this only works with ONLY. 
//			// If WHEN_AVAILABLE is used if fails with a False difference...
//			assertDiff(outATL, outLintra, UseIdentifiers.ONLY);
//		} else {
//			org.junit.Assert.fail("ATL resource is null");
//		}
	}
	@Override
	protected Resource load(String inXmiPath) {
		ResourceSet rs = new ResourceSetImpl();
		Resource profile = rs.getResource(URI.createFileURI(t + "relational.uml"), true); 
		Resource input_custom_load = rs.getResource(URI.createFileURI(new File(IN_MODEL).getAbsolutePath()), true);

		return input_custom_load;
	}
	

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {

		Families2PersonsRunner trafo = new Families2PersonsRunner().
				setStatsRecorder(recorder).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_RELATIONAL_ECORE).
				run();
			
		Resource outLintra = trafo.getOUTResource();
					
		outLintra.save(null);
		return outLintra;	
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "UML2Relational.atl", 
				inModel("IN", input, "UML", METAMODEL_UML),
				outModel("OUT", OUT_MODEL_ATL, "Relational", METAMODEL_RELATIONAL_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
		
		return outATL;
	}

}
