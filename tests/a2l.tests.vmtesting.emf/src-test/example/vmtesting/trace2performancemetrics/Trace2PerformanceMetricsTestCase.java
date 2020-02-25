package example.vmtesting.trace2performancemetrics;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;
import java.util.Arrays;

import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.maven2xml.Maven2XMLRunner;
import a2l.tests.vmtesting.emf.maven2xml.mavenmaven.MavenMaven.MavenMavenPackage;
import a2l.tests.vmtesting.emf.maven2xml.mavenprojet.MavenProject.MavenProjectPackage;
import a2l.tests.vmtesting.emf.metamodels.xml.XML.XML.XMLPackage;
import a2l.tests.vmtesting.emf.trace2performancemetrics.Trace2PerformanceMetricsRunner;
import a2l.tests.vmtesting.emf.trace2performancemetrics.Metrics.MetricsPackage;
import a2l.tests.vmtesting.emf.trace2performancemetrics.Trace.TracePackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra.evaluation.AbstractTestCase.Arguments;
import lintra.evaluation.AbstractTestCase.ExecutionFramework;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;
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
		registerMetamodel(TracePackage.eINSTANCE);
		registerMetamodel(MetricsPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);		
	}

	@Override
	protected void assertDiff(Resource m1, Resource m2) throws Exception {
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
		
		assertDiff(m1, m2, idFunction, featureFilter, UseIdentifiers.WHEN_AVAILABLE);
	}
		
	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "Trace2PerformanceMetrics_simplified.atl", 
				inModel("IN", IN_MODEL, "Trace", METAMODEL_TRACE_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "Metrics", METAMODEL_METRICS_ECORE)
		);
		
		Resource out = executor.getModelResource("OUT");
		out.save(new FileOutputStream(OUT_MODEL_ATL), null);

		return out;
	}
		
	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		
		Resource outLintra = new Trace2PerformanceMetricsRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_METRICS_ECORE).
				run().
				getOUTResource();
			
		outLintra.save(null);
		return outLintra;
	}	
	

}
