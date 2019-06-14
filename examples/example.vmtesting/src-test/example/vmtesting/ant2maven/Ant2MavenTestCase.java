package example.vmtesting.ant2maven;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Ant2MavenTestCase extends AbstractTestCase {
	private static final String t = "transformations/Ant2Maven/";
	
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
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Ant2Maven.atl", 
				inModel("IN", IN_MODEL, "Ant", METAMODEL_ANT_ECORE),
				outModel("OUTMaven", OUT_MODEL_ATL, "MavenMaven", METAMODEL_MAVEN_MAVEN_ECORE),
				outModel("OUTProject", OUT_MODEL2_ATL, "MavenProject", METAMODEL_MAVEN_PROJECT_ECORE));
			
		Resource outATL = executor.getModelResource("OUTMaven");
		Resource outATL2 = executor.getModelResource("OUTProject");
		
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		outATL2.save(new FileOutputStream(OUT_MODEL2_ATL), null);
		
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Ant2MavenRunner lintraTrafo = new Ant2MavenRunner().
			setIN(IN_MODEL, METAMODEL_ANT_ECORE).
			setOUTMaven(OUT_MODEL_LINTRA, METAMODEL_MAVEN_MAVEN_ECORE).
			setOUTProject(OUT_MODEL2_LINTRA, METAMODEL_MAVEN_PROJECT_ECORE).			
			run();
		
		Resource outLintra = lintraTrafo.getOUTMavenResource();
		Resource outLintra2 = lintraTrafo.getOUTProjectResource();
			
		
		outLintra.save(null);
		outLintra2.save(null);
		
		assertDiff(METAMODEL_MAVEN_MAVEN_ECORE, outATL, outLintra);
		assertDiff(METAMODEL_MAVEN_PROJECT_ECORE, outATL2, outLintra2);	
	}

}
