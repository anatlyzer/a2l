package example.vmtesting.trace2performancemetrics;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import metrics.MetricValue;

public class Trace2PerformanceMetricsTestCase extends AbstractTestCase {
	private static final String t = "transformations/Trace2PerformanceMetrics/";
	
	private static final String METAMODEL_METRICS_ECORE = t + "Metrics.ecore";
	private static final String METAMODEL_TRACE_ECORE =  t + "Trace.ecore";
	private static final String OUT_MODEL_ATL = "outputs/TraceSamples-Trace.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/TraceSamples-Trace.out.lintra.xmi";
	private static final String IN_MODEL = t + "TraceSamples-Trace.xmi";
	// private static final String IN_MODEL = t + "custom_test_models/simple-Trace3.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Trace2PerformanceMetrics_simplified.atl", 
				inModel("IN", IN_MODEL, "Trace", METAMODEL_TRACE_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Metrics", METAMODEL_METRICS_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Resource outLintra = new Trace2PerformanceMetricsRunner().
			setIN(IN_MODEL, METAMODEL_TRACE_ECORE).
			setOUT(OUT_MODEL_LINTRA, METAMODEL_METRICS_ECORE).
			run().
			getOUTResource();
		
		outLintra.save(null);
		
		java.util.function.Function<EObject, String> idFunction = new java.util.function.Function<EObject, String>() {
			public String apply(EObject input) {
				if (input instanceof MetricValue ) {
					return ((MetricValue)input).getTag();
				}
				// a null return here tells the match engine to fall back to the other matchers
				return null;
			}
		};
		
		
		FeatureFilter featureFilter = new FeatureFilter() {
			@Override
			public boolean checkForOrderingChanges(org.eclipse.emf.ecore.EStructuralFeature feature) {
				return false; //! feature.getName().equals("values");
			}
		};
		
		assertDiff(outATL, outLintra, idFunction, featureFilter, UseIdentifiers.WHEN_AVAILABLE);
	}

}
