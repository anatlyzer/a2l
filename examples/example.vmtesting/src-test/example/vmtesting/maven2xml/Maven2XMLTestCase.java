package example.vmtesting.maven2xml;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;

public class Maven2XMLTestCase extends AbstractTestCase {
	private static final String t = "transformations/Maven2XML/";
	
	private static final String METAMODEL_XML_ECORE = t + "XML.ecore";
	private static final String METAMODEL_MAVEN_MAVEN_ECORE =  t + "MavenMaven.ecore";
	private static final String METAMODEL_MAVEN_PROJECT_ECORE =  t + "MavenProject.ecore";
	
	private static final String OUT_MODEL_ATL = "outputs/mavenFile.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA = "outputs/mavenFile.out.lintra.xmi";
	
	private static final String OUT_MODEL_ATL2 = "outputs/mavenProject.out.atl.xmi";
	private static final String OUT_MODEL_LINTRA2 = "outputs/mavenProject.out.lintra.xmi";
	
	private static final String IN_MODEL = t + "mavenFile.xmi";
	private static final String IN_MODEL2 = t + "projectFile.xmi";
	
	@Test
	public void test() throws Exception {
		System.out.print("Executing EMFVM... ");
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.perform(t + "Maven2XML_modified.atl", 
				inModel("InMaven", IN_MODEL, "MavenMaven", METAMODEL_MAVEN_MAVEN_ECORE),
				inModel("InProject", IN_MODEL2, "MavenProject", METAMODEL_MAVEN_PROJECT_ECORE),				
				outModel("XML1", OUT_MODEL_ATL, "XMLMaven", METAMODEL_XML_ECORE),
				outModel("XML2", OUT_MODEL_ATL2, "XMLProject", METAMODEL_XML_ECORE)
				);

		Resource outATL = executor.getModelResource("XML1");
		Resource outATL2 = executor.getModelResource("XML2");
		
		outATL.save(new FileOutputStream(OUT_MODEL_ATL), null);
		outATL2.save(new FileOutputStream(OUT_MODEL_ATL2), null);		
		System.out.println("Done!");

		System.out.print("Executing Lintra... ");
		Maven2XMLRunner trafo = new Maven2XMLRunner().
			setInMaven(IN_MODEL, METAMODEL_MAVEN_MAVEN_ECORE).
			setInProject(IN_MODEL2, METAMODEL_MAVEN_PROJECT_ECORE).			
			setXML1(OUT_MODEL_LINTRA, METAMODEL_XML_ECORE).
			setXML2(OUT_MODEL_LINTRA2, METAMODEL_XML_ECORE).			
			run();
		
		Resource outLintra = trafo.getXML1Resource();
		Resource outLintra2 = trafo.getXML2Resource();		
		
		outLintra.save(null);
		outLintra2.save(null);
		
		assertDiff(outATL, outLintra);
		assertDiff(outATL2, outLintra2);		
	}

}
