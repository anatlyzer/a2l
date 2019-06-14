//package a2l.tests.imdb.findcouples.performance;
//
//import static lintra.evaluation.ATLExecutor.inModel;
//import static lintra.evaluation.ATLExecutor.outModel;
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.eclipse.emf.ecore.EPackage;
//import org.eclipse.emf.ecore.resource.Resource;
//import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
//
//import a2l.tests.findcouples.FindCouplesIMDbRunner_CountDigits;
//import imdb.movies.MoviesPackage;
//import lintra.evaluation.ATLExecutor;
//import lintra.evaluation.AbstractTestCase;
//import lintra.evaluation.StatsCollector;
//import lintra.evaluation.StatsCollector.NullStats;
//import lintra.evaluation.StatsCollector.TransformationStats;
//
//public class FindCouples_Performance extends AbstractTestCase {
//	private static final String t = "transformations/";
//	
//	private static final String METAMODEL_MOVIES = "metamodels/movies.ecore";
//	
//	private static final String OUT_MODEL_ATL = "outputs/output.atl.xmi";
//	private static final String OUT_MODEL_LINTRA = "outputs/output.lintra.xmi";
//	private static final String OUT_MODEL_EMF = "outputs/output.emf.xmi";
//	String trafo = "FindCouples.atl";
//	String trafo_emftvm = "FindCouples_emftvm.emftvm";
//		
//	public static void main(String[] args) throws Exception {
//		EPackage.Registry.INSTANCE.put(MoviesPackage.eINSTANCE.getNsURI(), MoviesPackage.eINSTANCE);
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("emftvm", new EMFTVMResourceFactoryImpl());
//
//		//new FindCouples_Performance().execute();		
//		//new FindCouples_Performance().executeATL(); 
//		new FindCouples_Performance().executeATL_EMFTVM(); 
//
//		// new FindCouples_Performance().executeLintraExplicitScheduling();
//		// new FindCouples_Performance().executeLintraForkJoin();
//	}
//	
//	
//	private void executeLintraExplicitScheduling() throws Exception {
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//		// String inXmiPath = "inputs/eclipseModel-0.1.xmi";
//		Resource input = load(inXmiPath);
//	
//		StatsCollector stats = new StatsCollector();
//		stats.onTransformation("FindCouples-" + inXmiPath, 1);
//		
//		Resource out = new FindCouples_LintraExplicitScheduling(stats).transform(input);
//		
//		stats.begin("Serializing");
//			out.save(new FileOutputStream(OUT_MODEL_EMF), null);
//		stats.end();
//		
//		for (TransformationStats st : stats.getExecutions()) {
//			System.out.println(st.toString());
//		}		
//	}
//	
//	private void executeLintraForkJoin() throws Exception {
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//		// String inXmiPath = "inputs/eclipseModel-0.1.xmi";
//		Resource input = load(inXmiPath);
//	
//		StatsCollector stats = new StatsCollector();
//		stats.onTransformation("FindCouples-" + inXmiPath, 1);
//		
//		int numThreads = 2;
//		
//		Resource out = new FindCouples_LintraForkJoin(stats).transform(input, numThreads);
//		
//		stats.begin("Serializing");
//			out.save(new FileOutputStream(OUT_MODEL_EMF), null);
//		stats.end();
//		
//		for (TransformationStats st : stats.getExecutions()) {
//			System.out.println(st.toString());
//		}		
//	}
//	
//	private void executeATL() throws Exception {
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//		
//		// warmup
//		executeATL(t + trafo, inXmiPath, false, "emfvm");
//		
//		executeATL(t + trafo, inXmiPath, true, "emfvm");
//		executeATL(t + trafo, inXmiPath, false, "emfvm");
//	}
//
//	private void executeATL_EMFTVM() throws Exception {
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//		
//		// warmup
//		executeATL(t + trafo_emftvm, inXmiPath, false, "emftvm");
//		
//		executeATL(t + trafo_emftvm, inXmiPath, true, "emftvm");
//		executeATL(t + trafo_emftvm, inXmiPath, false, "emftvm");
//	}
//
//	private void execute() throws Exception {
//		String inXmiPath = "inputs/imdb-0.1.xmi";
//
//		Resource input = load(inXmiPath);
//		
//		// Warmup				
//		executeLintra(input, 1, new NullStats());
//		executeLintra(input, 2, new NullStats());
//
//		
//		StatsCollector stats = new StatsCollector();
//		
//		for(int i = 1; i <= 6; i++) {
//			int numThreads = i;
//			
//			stats.onTransformation(trafo, numThreads);		
//			executeLintra(input, numThreads, stats);
//		}
//		
//		System.out.println("\n\nStats:");
//		for (TransformationStats s : stats.getExecutions()) {
//			System.out.println(s);
//			System.out.println("\n");
//		}
//		
//	}
//
//	
//	private Resource executeLintra(Resource input, int numThreads, StatsCollector stats)
//			throws Exception, IOException, FileNotFoundException {
//		Resource outLintra;
//		System.out.print("Executing Lintra... ");
//		
//		
//		outLintra = new FindCouplesIMDbRunner_CountDigits().
//				//setIN(IN_MODEL, METAMODEL_JAVA_ECORE).
//				//setStats(stats).
//				setIN(input).
//				setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
//				setNumThreads(numThreads).
//				run().
//				getOUTResource();
//		
//		outLintra.save(new FileOutputStream(OUT_MODEL_LINTRA), null);
//		return outLintra;
//	}
//
//	private Resource executeATL(String trafo, String inXmiPath, boolean modelWarmup, String vm) throws IOException, FileNotFoundException {
//		Resource outATL;
//		System.out.print("Executing EMFVM... ");
//		ATLExecutor executor = new ATLExecutor();
//		switch (vm) {
//		case "emfvm":
//			executor.useEMFVM();			
//			break;
//		case "emftvm":
//			executor.useEMFTVM();
//			break;
//		default:
//			throw new IllegalArgumentException();
//		}
//		executor.allowInterModelReferences(false);
//		executor.doModelWarmup(modelWarmup);
//		executor.perform(trafo, 
//				inModel("IN", inXmiPath, "MM", METAMODEL_MOVIES),
//				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_MOVIES));
//		outATL = executor.getModelResource("OUT");
//		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
//		System.out.println("Done!");
//		return outATL;
//	}
//
//
//}
// 