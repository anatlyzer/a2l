package example.vmtesting.assertionmodification;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.UMLPackage;
import org.junit.Test;

import a2l.tests.vmtesting.emf.assertionmodification.AssertionModificationRunner;
import a2l.tests.vmtesting.emf.metamodels.xml.XML.XML.XMLPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class AssertionModificationTestCase extends AbstractTestCase {
	private static final String t = "transformations/AssertionModification/";
	
	private static final String METAMODEL_UML = "http://www.eclipse.org/uml2/2.1.0/UML";
	private static final String METAMODEL_XML_ECORE =  "metamodels/XML.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/AssertionModification.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/AssertionModification.out.lintra.xmi";
	private static final String IN_MODEL = t + "example-UML2.uml";
	private static final String IN_MODEL_XML = t + "lib-XML.xmi";

	@Test
	public void test() throws Exception {
		registerMetamodel(XMLPackage.eINSTANCE);
		registerMetamodel(UMLPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/2.1.0/UML", UMLPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {

		AssertionModificationRunner lintraTrafo = new AssertionModificationRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setLib(load(IN_MODEL_XML)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_UML).		
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
		executor.perform(t + "AssertionModification_modified.atl", 
				inModel("IN", IN_MODEL, "UML2", METAMODEL_UML),
				inModel("Lib", IN_MODEL_XML, "XML", METAMODEL_XML_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "UML2Target", METAMODEL_UML));
		Resource outATL = executor.getModelResource("OUT");
		if ( outATL != null ) {
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		return outATL;
	}

}
