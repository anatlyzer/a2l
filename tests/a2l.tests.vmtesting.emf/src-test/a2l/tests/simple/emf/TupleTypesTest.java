package a2l.tests.simple.emf;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.simple.emf.abcd.AbcdPackage;
import a2l.tests.simple.emf.tupletype.TupleTypesRunner;
import a2l.tests.simple.emf.wxyz.WxyzPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class TupleTypesTest extends AbstractTestCase {
	private static final String t = "transformations-simple/tuple_type/";
	
	private static final String METAMODEL_ABCD_ECORE = "metamodels/simple/ABCD.ecore";
	private static final String METAMODEL_WXYZ_ECORE = "metamodels/simple/WXYZ.ecore";
	private static final String OUT_MODEL_ATL = "outputs/tuple_type.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/tuple_type.out.lintra.xmi";
	private static final String IN_MODEL = t + "tuple_type_1.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(AbcdPackage.eINSTANCE);
		registerMetamodel(WxyzPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {
		TupleTypesRunner lintraTrafo = new TupleTypesRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_WXYZ_ECORE).		
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
		executor.perform(t + "tuple_type.atl", 
				inModel("IN", IN_MODEL, "ABCD", METAMODEL_ABCD_ECORE),
				outModel("OUT", OUT_MODEL_ATL, "WXYZ", METAMODEL_WXYZ_ECORE));
		Resource outATL = executor.getModelResource("OUT");
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		System.out.println("Done!");	
	
		return outATL;
	}

}