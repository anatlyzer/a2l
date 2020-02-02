package example.vmtesting.maven2xml;

import static lintra.evaluation.ATLExecutor.inModel;
import static lintra.evaluation.ATLExecutor.outModel;

import java.io.FileOutputStream;
import java.util.Arrays;

import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import a2l.tests.vmtesting.emf.maven2xml.Maven2XMLRunner;
import a2l.tests.vmtesting.emf.maven2xml.mavenmaven.MavenMaven.MavenMavenPackage;
import a2l.tests.vmtesting.emf.maven2xml.mavenprojet.MavenProject.MavenProjectPackage;
import a2l.tests.vmtesting.emf.metamodels.xml.XML.XML.XMLPackage;
import lintra.evaluation.ATLExecutor;
import lintra.evaluation.AbstractTestCase;
import lintra2.stats.AggregatedStatsRecorder;
import lintra2.stats.IStatsRecorder;

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
		registerMetamodel(MavenMavenPackage.eINSTANCE);
		registerMetamodel(MavenProjectPackage.eINSTANCE);
		registerMetamodel(XMLPackage.eINSTANCE);
		
		doTest(new Arguments(1, 1, 1, IN_MODEL, ExecutionFramework.BOTH), t);		
	}

	@Override
	protected Object executeLintra(Resource input, int numThreads, boolean footprint, boolean optimised,
			AggregatedStatsRecorder recorder, boolean save) throws Exception {
		
		Maven2XMLRunner trafo = new Maven2XMLRunner().
				setStatsRecorder(recorder).
				setInMaven(load(IN_MODEL)).
				setInProject(load(IN_MODEL2)).			
				setXML1(OUT_MODEL_LINTRA, METAMODEL_XML_ECORE).
				setXML2(OUT_MODEL_LINTRA2, METAMODEL_XML_ECORE).			
				run();
			
		Resource outLintra = trafo.getXML1Resource();
		Resource outLintra2 = trafo.getXML2Resource();		
					
		outLintra.save(null);
		outLintra2.save(null);
		
		return Arrays.asList(outLintra, outLintra2);
	}

	@Override
	protected Object executeATL(String trafo, String inXmiPath, Resource input, IStatsRecorder recorder, boolean save)
			throws Exception {
		ATLExecutor executor = new ATLExecutor();
		executor.useEMFVM();
		executor.setStatsRecorder(recorder);
		executor.perform(t + "Maven2XML.atl", 
				inModel("InMaven", IN_MODEL, "MavenMaven", METAMODEL_MAVEN_MAVEN_ECORE),
				inModel("InProject", IN_MODEL2, "MavenProject", METAMODEL_MAVEN_PROJECT_ECORE),				
				outModel("XML1", OUT_MODEL_ATL, "XMLMaven", METAMODEL_XML_ECORE),
				outModel("XML2", OUT_MODEL_ATL2, "XMLProject", METAMODEL_XML_ECORE)
				);

		Resource out1 = executor.getModelResource("XML1");
		Resource out2 = executor.getModelResource("XML2");
		out1.save(new FileOutputStream(OUT_MODEL_ATL), null);
		out2.save(new FileOutputStream(OUT_MODEL_ATL2), null);
		System.out.println("Done!");	

		
		return Arrays.asList(out1, out2);
	}

}
