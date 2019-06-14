package example.vmtesting.xml2ant;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import com.google.common.base.Function;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import metrics.MetricValue;

public class XML2AntTestCase extends AbstractTestCase {
	private static final String t = "transformations/XML2Ant/";
	
	private static final String METAMODEL_XML__ECORE =  t + "XML.ecore";
	private static final String METAMODEL_ANT_ECORE = t + "Ant.ecore";
	private static final String OUT_MODEL_ATL = "outputs/XML2Ant.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/XML2Ant.out.lintra.xmi";
	private static final String IN_MODEL = t + "build.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "XML2Ant.atl", 
				inModel("IN", IN_MODEL, "XML", METAMODEL_XML__ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Ant", METAMODEL_ANT_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new XML2AntRunner().
			setIN(IN_MODEL, METAMODEL_XML__ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_ANT_ECORE).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		
		assertDiff(outATL, outLintra, UseIdentifiers.ONLY);
	}

}
