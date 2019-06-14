package lintra.evaluation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;
import java.util.function.Function;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.diff.DefaultDiffEngine;
import org.eclipse.emf.compare.diff.DiffBuilder;
import org.eclipse.emf.compare.diff.FeatureFilter;
import org.eclipse.emf.compare.diff.IDiffEngine;
import org.eclipse.emf.compare.diff.IDiffProcessor;
import org.eclipse.emf.compare.match.DefaultComparisonFactory;
import org.eclipse.emf.compare.match.DefaultEqualityHelperFactory;
import org.eclipse.emf.compare.match.DefaultMatchEngine;
import org.eclipse.emf.compare.match.IComparisonFactory;
import org.eclipse.emf.compare.match.IMatchEngine;
import org.eclipse.emf.compare.match.eobject.IEObjectMatcher;
import org.eclipse.emf.compare.match.eobject.IdentifierEObjectMatcher;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryImpl;
import org.eclipse.emf.compare.match.impl.MatchEngineFactoryRegistryImpl;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.compare.utils.UseIdentifiers;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.junit.Assert;

import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public abstract class AbstractTestCase {
	private static final boolean pauseBeforeStart = false;

	static {
		if (!isEclipseRunning()) {
			registerFactory();
		}
	}

	public static enum ExecutionFramework {
		A2L,
		ATL,
		EMFTVM,
		BOTH /* A2L - ATL */		
	}
	
	public static ExecutionFramework toFramework(String str) {
		ExecutionFramework framework = ExecutionFramework.valueOf(str.toUpperCase());
		if ( framework == null )
			framework = ExecutionFramework.A2L;
		return framework;
	}


	public String getName() {
		return this.getClass().getSimpleName().replace("_Test", "").replace("Test", "");
	}
	
	protected void dumpRecorder(AggregatedStatsRecorder recorder) throws IOException {
		
		System.out.println("************");
		System.out.println("Run finised!");
		System.out.println("************");
		recorder.printTo(System.out);
		
		String normalized = recorder.getName().replace(" ", "_".replace("/", "_"));
		recorder.printCSVto(new PrintStream("/tmp/" + normalized + ".csv"));
		
		System.out.println("*******");
		System.out.println("Bye!");
		System.out.println("*******");		
	}

	
	public static Resource load(String inXmiPath, String mmPath) {
		double time0 = System.currentTimeMillis();

		ResourceSet rs = new ResourceSetImpl();
		Resource mm = rs.getResource(URI.createFileURI(mmPath), true);
		mm.getAllContents().forEachRemaining(c -> {
			if (c instanceof EPackage) {
				rs.getPackageRegistry().put(((EPackage) c).getNsURI(), c);
			}
		});

		Resource input = rs.getResource(URI.createFileURI(inXmiPath), true);
		double timeF = (System.currentTimeMillis() - time0) / 1000;
		System.out.println("Model loading: " + timeF);
		return input;
	}

	public static Resource load(String inXmiPath) {
		double time0 = System.currentTimeMillis();

		ResourceSet rs = new ResourceSetImpl();
		Resource input = rs.getResource(URI.createFileURI(inXmiPath), true);
		double timeF = (System.currentTimeMillis() - time0) / 1000;
		System.out.println("Model loading: " + timeF);
		return input;
	}
	

	protected void registerMetamodel(String metamodel) {
		ResourceSetImpl rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createFileURI(metamodel), true);
		for(EObject obj : r.getContents()) {
			if ( obj instanceof EPackage ) {
				EPackage.Registry.INSTANCE.put(((EPackage) obj).getNsURI(), obj);
			}
		}
	}
	

	public static void registerMetamodel(EPackage pkg) {
		EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
	}

	protected void assertDiff(Resource m1, Resource m2) {
		assertDiff(m1, m2, (obj) -> null, null, UseIdentifiers.NEVER);
	}

	protected void assertDiff(Resource m1, Resource m2, UseIdentifiers idUSE) {
		assertDiff(m1, m2, (obj) -> null, null, idUSE);
	}

	protected void assertDiff(String metamodel, Resource m1, Resource m2) {
		try {
			m1.save(new FileOutputStream("temp/m1.xmi"), null);
			m2.save(new FileOutputStream("temp/m2.xmi"), null);

			ResourceSet rs = new ResourceSetImpl();
			Resource mm = rs.getResource(URI.createURI(metamodel), true);
			mm.getContents().forEach(m -> {
				if (m instanceof EPackage) {
					rs.getPackageRegistry().put(((EPackage) m).getNsURI(), m);
				}
			});
			m1 = rs.getResource(URI.createURI("temp/m1.xmi"), true);
			m2 = rs.getResource(URI.createURI("temp/m2.xmi"), true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		assertDiff(m1, m2, (obj) -> null, null, UseIdentifiers.NEVER);
	}

	protected void assertDiff(Resource m1, Resource m2, Function<EObject, String> idFunction,
			FeatureFilter featureFilter, UseIdentifiers idUSE) {
		// 4. Test
		// We use the result of the evolved transformation as an oracle to test
		// the patched transformation.

		// final ResourceSet originSet = origin.getResourceSet();
		// final ResourceSet revisedSet = revised.getResourceSet();

		// Documentation:
		// https://www.eclipse.org/emf/compare/documentation/latest/developer/developer-guide.html#Defining_custom_identifiers
		// https://www.eclipse.org/emf/compare/documentation/latest/developer/developer-guide.html#Changing_the_FeatureFilter

		// Configure EMF Compare
		// IEObjectMatcher matcher =
		// DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
		// IEObjectMatcher fallBackMatcher =
		// DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.WHEN_AVAILABLE);
		// IEObjectMatcher fallBackMatcher =
		// DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.ONLY);
		
		
		// IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);		
		IEObjectMatcher fallBackMatcher = DefaultMatchEngine.createDefaultEObjectMatcher(idUSE);
		IEObjectMatcher customIDMatcher = new IdentifierEObjectMatcher(fallBackMatcher, new com.google.common.base.Function<EObject, String>() {

			@Override
			public String apply(EObject arg0) {
				return idFunction.apply(arg0);
			}
			
		});

		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
		IMatchEngine.Factory matchEngineFactory = new MatchEngineFactoryImpl(customIDMatcher, comparisonFactory);
		matchEngineFactory.setRanking(20);
		IMatchEngine.Factory.Registry matchEngineRegistry = new MatchEngineFactoryRegistryImpl();
		matchEngineRegistry.add(matchEngineFactory);

		IDiffProcessor diffProcessor = new DiffBuilder();
		IDiffEngine diffEngine = new DefaultDiffEngine(diffProcessor) {
			@Override
			protected FeatureFilter createFeatureFilter() {
				if (featureFilter != null) {
					return featureFilter;
				} else {
					return super.createFeatureFilter();
				}
			}
		};

		EMFCompare comparator = EMFCompare.builder().setDiffEngine(diffEngine)
				.setMatchEngineFactoryRegistry(matchEngineRegistry).build();// setDiffEngine(diffEngine).build();

		final IComparisonScope scope = new DefaultComparisonScope(m1, m2, null);
		;

		// final IComparisonScope scope =
		// EMFCompare.createDefaultScope(revisedSet, originSet);
        Comparison comparison = comparator.compare(scope);
        
        final List<Diff> differences = comparison.getDifferences();

        for (Diff diff : differences) {
                System.out.println("Diff: " + diff);
        }

        if (differences.size() > 0) 
                Assert.fail("There are differences! " + differences.size());

	}

	public static void registerFactory() {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl() {
			public Resource createResource(URI uri) {
				XMIResource xmiResource = new XMIResourceImpl(uri);
				return xmiResource;
			}
		});
	}

	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable exception) {
			// Assume that we aren't running.
		}
		return false;
	}


	// Configuration for launching
	
	
	public static Arguments parseArguments(String[] args) {
		if ( args.length == 0 ) {
			System.out.println("Run with:");
			System.out.println("   minThreads maxThreads numRuns model framework optimised");
			System.exit(-1);
		} else {
			Arguments arguments = new Arguments();
			arguments.minThreads  = Integer.parseInt(args[0]);
			arguments.maxThreads  = Integer.parseInt(args[1]);
			arguments.runs = Integer.parseInt(args[2]);			
			arguments.model = args[3];
			arguments.framework = toFramework(args[4]);
			if (args.length >= 6) {
				arguments.footprint = args[5].toLowerCase().startsWith("footprint"); 
				arguments.optimised = args[6].toLowerCase().startsWith("optimised");				
			}
			if (args.length >= 8) {
				arguments.save = args[7].toLowerCase().startsWith("save");
			}
			if (args.length >= 9) {
				arguments.reportDir = args[8];
			}
			return arguments;
		}
		return null;
	}
	
	public static class Arguments {
		public String reportDir = "/tmp";
		public boolean save;
		public boolean footprint = false;
		public boolean optimised = false;
		int minThreads;
		int maxThreads;
		int runs;
		String model;
		ExecutionFramework framework;
		
		public Arguments() {
			// Allow weird initialisation...
		}
		
		public Arguments(int minThreads, int maxThreads, int runs, String model, ExecutionFramework framework) {
			this.minThreads = minThreads;
			this.maxThreads = maxThreads;
			this.runs = runs;
			this.model = model;
			this.framework = framework;
		}
	}
	

	protected void doBenchmark(Arguments args, String trafo) throws FileNotFoundException, IOException, Exception {
		doTestAux(args, trafo, (m) -> "inputs/" + m);
	}
	
	protected void doTest(Arguments args, String trafo) throws FileNotFoundException, IOException, Exception {
		doTestAux(args, trafo, (m) -> m);
	}
	
	protected void doTestAux(Arguments args, String trafo, Function<String, String> modelPathAdapter) throws FileNotFoundException, IOException, Exception {
		int minThreads = args.minThreads;
		int maxThreads = args.maxThreads;
		String model = args.model;
		int runsPerTest = args.runs;
		ExecutionFramework framework = args.framework;
		
		Object outLintra = null;
		Object outATL = null; 
		
		String inXmiPath = modelPathAdapter.apply(model);
		Resource input = load(inXmiPath);
		
		if ( framework == ExecutionFramework.A2L || framework == ExecutionFramework.BOTH ) {
			AggregatedStatsRecorder recorder = new AggregatedStatsRecorder(getName() + "_" + inXmiPath);
			
			if ( minThreads <= maxThreads ) {
				for(int i = minThreads; i <= maxThreads; i++) {
					outLintra = testForThread(args, runsPerTest, input, recorder, i);
				}
			} else {
				for(int i = minThreads; i >= maxThreads; i--) {
					outLintra =  testForThread(args, runsPerTest, input, recorder, i);
				}
			}
			
			System.out.println("************");
			System.out.println("Run finised!");
			System.out.println("************");
			recorder.printTo(System.out);
						
			PrintStream ps = new PrintStream(createReportFileName(args.reportDir, "benchmark", "A2L"));
			recorder.printCSVto(ps);
			ps.close();
			
			PrintStream ps2 = new PrintStream(createExtendedReportFileName(args.reportDir, "benchmark", "A2L"));
			recorder.printExtendedCSVto(ps2);
			ps2.close();			
		}

		if ( framework == ExecutionFramework.ATL || framework == ExecutionFramework.BOTH ) {
			AggregatedStatsRecorder recorder = new AggregatedStatsRecorder(getName() + "_" + inXmiPath + "_ATL");
			recorder.testWithNumThreads(1);
			for(int j = 0; j < runsPerTest; j++) {
				recorder.startNewTest();			
				outATL = executeATL(trafo, inXmiPath, input, recorder, args.save);
				recorder.printCurrentTo(System.out);
			}
			
			recorder.printTo(System.out);
			
			PrintStream ps = new PrintStream(createReportFileName(args.reportDir, "benchmark", "ATL"));
			recorder.printCSVto(ps);
			ps.close();

			PrintStream ps2 = new PrintStream(createExtendedReportFileName(args.reportDir, "benchmark", "ATL"));
			recorder.printExtendedCSVto(ps2);
			ps2.close();
		}
		
		System.out.println("*******");
		System.out.println("Bye!");
		System.out.println("*******");
		
		if ( framework == ExecutionFramework.BOTH ) {
			Assert.assertNotNull(outATL);
			Assert.assertNotNull(outLintra);
			if (outATL instanceof List) {
				List<Resource> loutATL = (List<Resource>) outATL;
				List<Resource> loutA2L = (List<Resource>) outLintra;
				if (loutA2L.size() != loutATL.size()) {
					throw new IllegalStateException();
				}
				for(int i = 0; i < loutATL.size(); i++) {
					Resource rATL = loutATL.get(i);
					Resource rA2L = loutA2L.get(i);
					assertDiff(rATL, rA2L);
					System.out.println("Diff ok: " + rATL + " = " + rA2L);
				}
			} else {			
				assertDiff((Resource) outATL, (Resource) outLintra);
				System.out.println("Diff ok: " + outATL + " = " + outLintra);
			}
		}				
	}


	private Object testForThread(Arguments args, int runsPerTest, Resource input,
			AggregatedStatsRecorder recorder, int numThreads) throws IOException, Exception {
		Object outLintra = null;
		recorder.testWithNumThreads(numThreads);
		for(int j = 0; j < runsPerTest; j++) {
			recorder.startNewTest();
			if ( pauseBeforeStart ) {
				System.out.print("Paused before starting. " + getPid() + " Press a key...");
				System.in.read();
			}
			outLintra = executeLintra(input, numThreads, args.footprint, args.optimised, recorder);
			// outLintra = null; // free
			recorder.printCurrentTo(System.out);
			if ( pauseBeforeStart ) {
				System.out.print("Finished. Press a key...");
				System.in.read();
			}

			long memory = getSettledUsedMemory();
			System.out.println(String.format("Used memory: %.2f GB", memory / (1024.0 * 1024 * 1024)));
			System.out.println(String.format("Free memory: %.2f GB", Runtime.getRuntime().freeMemory() / (1024.0 * 1024 * 1024)));
			System.out.println();
		}
		return outLintra;
	}	

	protected String createReportFileName(String base, String folderName, String name) {
		String folder = createBenchmarkFolder(base, folderName);
		return folder + File.separator + "result_" + getName() + name + ".csv";
	}

	protected String createExtendedReportFileName(String base, String folderName, String name) {
		String folder = createBenchmarkFolder(base, folderName);
		return folder + File.separator + "extended_" + getName() + name + ".csv";
	}

	private String createBenchmarkFolder(String base, String name) {
		if ( base == null )
			base = "/tmp";
		
		File f = new File(base + File.separator + name);
		if ( ! f.exists() ) {
			f.mkdirs();
		}
				
		return f.getAbsolutePath();
	}

	/**
	 * May return Resource or List<Resource> if there are multiple outputs 
	 */
	protected abstract Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception;	
	
	protected abstract Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save) throws Exception;
	
	protected void printLintraExec(int numThreads, boolean footprint, boolean optimised) {
		System.out.println("Executing Lintra with " + numThreads + " ... ");
		System.out.println("          footprint = " + footprint);
		System.out.print("          optimised = " + optimised + " ...");
	}

	
	
	// Memory handling.
	// From: https://cruftex.net/2017/03/28/The-6-Memory-Metrics-You-Should-Track-in-Your-Java-Benchmarks.html#metric-used-memory-after-forced-gc
	
	long getCurrentlyUsedMemory() {
		return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed()
				+ ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage().getUsed();
	}

	long getGcCount() {
		long sum = 0;
		for (GarbageCollectorMXBean b : ManagementFactory.getGarbageCollectorMXBeans()) {
			long count = b.getCollectionCount();
			if (count != -1) {
				sum += count;
			}
		}
		return sum;
	}

	long getReallyUsedMemory() {
		long before = getGcCount();
		System.gc();
		while (getGcCount() == before)
			;
		return getCurrentlyUsedMemory();
	}
	
	long getSettledUsedMemory() {
		  long m;
		  long m2 = getReallyUsedMemory();
		  do {
		    try {
				Thread.sleep(567);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    m = m2;
		    m2 = getReallyUsedMemory();
		  } while (m2 < getReallyUsedMemory());
		  return m;
		}
	
	private String getPid() {
		return ManagementFactory.getRuntimeMXBean().getName();
	}
	
}


