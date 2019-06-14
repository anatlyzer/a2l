package example.vmtesting.ant2maven;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.ant2maven.Ant2MavenRunner;
import a2l.tests.vmtesting.emf.ant2maven.ant.Ant.AntPackage;
import a2l.tests.vmtesting.emf.ant2maven.mavenmaven.MavenMaven.MavenMavenPackage;
import a2l.tests.vmtesting.emf.ant2maven.mavenproject.MavenProject.MavenProjectPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

public class Ant2MavenTestCase extends AbstractTestCase {
	private static final String t = "transformations/Ant2Maven/";
	
//	private static final AntPackage METAMODEL_ANT_ECORE = AntPackage.eINSTANCE;
//	private static final MavenMavenPackage METAMODEL_MAVEN_MAVEN_ECORE =  MavenMavenPackage.eINSTANCE;
//	private static final MavenProjectPackage METAMODEL_MAVEN_PROJECT_ECORE =  MavenProjectPackage.eINSTANCE;
	
	private static final String METAMODEL_ANT_ECORE = t + "Ant.ecore";
	private static final String METAMODEL_MAVEN_MAVEN_ECORE =  t + "MavenMaven.ecore";
	private static final String METAMODEL_MAVEN_PROJECT_ECORE =  t + "MavenProject.ecore";	
	
	private static final String OUT_MODEL_ATL = "outputs/buildAnt_mavenmaven.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/buildAnt_mavenmaven.out.lintra.xmi";
	private static final String OUT_MODEL2_ATL = "outputs/buildAnt_mavenproject.out.atl.xmi";
	private static final String OUT_MODEL2_LINTRA = "outputs/buildAnt_mavenproject.out.lintra.xmi";	
	private static final String IN_MODEL = t + "buildAnt.xmi";
	
	@Test
	public void test() throws Exception {
		registerMetamodel(AntPackage.eINSTANCE);
		registerMetamodel(MavenMavenPackage.eINSTANCE);
		registerMetamodel(MavenProjectPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);
//		
//		
//		System.out.println("Done!");
//
//		System.out.print("Executing Lintra... ");
//		
//		assertDiff(METAMODEL_MAVEN_MAVEN_ECORE, outATL, outLintra);
//		assertDiff(METAMODEL_MAVEN_PROJECT_ECORE, outATL2, outLintra2);	
	}

	@Override
	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder) throws Exception {

		Ant2MavenRunner lintraTrafo = new Ant2MavenRunner().
				setStatsRecorder(recorder).
				setIN(load(IN_MODEL)).
				setOUTMaven(OUT_MODEL_LINTRA, METAMODEL_MAVEN_MAVEN_ECORE).
				setOUTProject(OUT_MODEL2_LINTRA, METAMODEL_MAVEN_PROJECT_ECORE).			
				run();
			
		Resource outLintra = lintraTrafo.getOUTMavenResource();
		Resource outLintra2 = lintraTrafo.getOUTProjectResource();
					
		outLintra.save(null);
		outLintra2.save(null);
		return outLintra;
	}

	@Override
	protected Resource executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save) throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.setStatsRecorder(recorder);
		executor.useEMFVM();
		executor.perform(t + "Ant2Maven.atl", 
				inModel("IN", IN_MODEL, "Ant", METAMODEL_ANT_ECORE),
				outModel("OUTMaven", OUT_MODEL_ATL, "MavenMaven", METAMODEL_MAVEN_MAVEN_ECORE),
				outModel("OUTProject", OUT_MODEL2_ATL, "MavenProject", METAMODEL_MAVEN_PROJECT_ECORE));
			
		Resource outATL = executor.getModelResource("OUTMaven");
		Resource outATL2 = executor.getModelResource("OUTProject");
		
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		outATL2.save(new FileOutputStream(OUT_MODEL2_ATL), null);
		
		return outATL2;
	}
	
	
	/*
	 * 
	 * 	protected Resource executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised, AggregatedStatsRecorder recorder) throws Exception {
		Resource outLintra;
		printLintraExec(numThreads, footprint, optimised);				
		
		IFootprint footprintObject = footprint ? 
				new a2l.tests.imdb.identity.optimised.IdentityIMDbFootprint() : 
				null; 
		
		if ( optimised ) {
			outLintra = new a2l.tests.imdb.identity.optimised.IdentityIMDbRunner().
				setStatsRecorder(recorder).
				setFootprint(footprintObject).
				setIN(input).
				setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
				setNumThreads(numThreads).
				run().
				getOUTResource();
		} else {
			outLintra = new a2l.tests.imdb.identity.normal.IdentityIMDbRunner().
					setStatsRecorder(recorder).
					setFootprint(footprintObject).
					setIN(input).
					setOUT(OUT_MODEL_LINTRA, METAMODEL_MOVIES).
					setNumThreads(numThreads).
					run().
					getOUTResource();			
		}
		
		System.out.println();
		//recorder.printTo(System.out);
		
		//outLintra.save(new FileOutputStream(OUT_MODEL_LINTRA), null);
		return outLintra;
	}

	@Override
	protected Resource executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save) throws IOException, FileNotFoundException {
		Resource outATL;
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.doModelWarmup(true);
		executor.allowInterModelReferences(false);
		executor.perform(t + trafo, 
				inModel("IN", inXmiPath, "MM", METAMODEL_MOVIES),
				outModel("OUT", OUT_MODEL_ATL, "MM1", METAMODEL_MOVIES));
		outATL = executor.getModelResource("OUT");
		if ( save ) {
			System.out.println("Finished... saving result...");
			outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		}
		System.out.println("Done!");
		return outATL;
	}
	 */

}
