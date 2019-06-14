package example.java2graph.java2graph;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Java2GraphTestCase extends AbstractTestCase {

	private static final String METAMODEL_GRAPH_ECORE = "metamodels/Graph.ecore";
	private static final String METAMODEL_JAVA_ECORE = "metamodels/java.ecore";
	private static final String OUT_MODEL_ATL = "outputs/small_java.atl.out.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/small_java.lintra.out.xmi";
	private static final String IN_MODEL = "models/small_java.xmi";
	
	@Test
	public void test() throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform("transformations/Java2Graph.atl", 
				inModel("IN", IN_MODEL, "MM", METAMODEL_JAVA_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_GRAPH_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		
		Resource outLintra = new RunJava2Graph().
			setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_GRAPH_ECORE).
			run().
			getOUTResource();
		
		assertDiff(outATL, outLintra);
	}

}
