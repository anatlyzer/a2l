package example.java2uml.runningexample;

import java.io.FileOutputStream;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import example.java2uml.runningexample.java2uml_running_emf.IPendingTask;
import lintra2.blackboard.BlackboardException;
import lintra2.blackboard.IdentifiableElementMapper;
import lintra2.runners.MTLauncherOutplace;
import lintra2.transfo.LinTraParameters;

public class RunJava2UML {

	private String inXmiPath;
	private String inmmPath;
	private String outXmiPath;
	private String outmmPath;
	private Resource tgtRes;


	public RunJava2UML setIN(String inXmiPath, String inmmPath) {
		this.inXmiPath = inXmiPath;
		this.inmmPath = inmmPath;
		return this;
	}
	
	public RunJava2UML setOUT(String outXmiPath, String outmmPath) {
		this.outXmiPath = outXmiPath;
		this.outmmPath = outmmPath;
		return this;
	}
	
	public RunJava2UML run() throws Exception {
		System.out.println("Loading models");

		ResourceSet rs = new ResourceSetImpl();
		Resource input = rs.getResource(URI.createFileURI(inXmiPath), true);
		
		System.out.println("Transforming");
		MTLauncherOutplace mtLauncher = new MTLauncherOutplace();
		mtLauncher.createBlackboard();
		mtLauncher.createSrcArea("srcArea", new EMFDataSource(input));
		System.out.println("Model loaded");
		
		mtLauncher.createTrgArea("trgArea", new EMFTargetIdMapper());
		
		int numThreads = Runtime.getRuntime().availableProcessors() ;
		// int numThreads = LinTraParameters.NUMBER_OF_THREADS_T1;

		java2uml_running_emf trafo = new java2uml_running_emf(
				mtLauncher.getArea(mtLauncher.getSrcAreas(), "srcArea"), 
				mtLauncher.getArea(mtLauncher.getTrgAreas(), "trgArea"), 
				mtLauncher.getCachingArea());

		double time0 = System.currentTimeMillis();
		
		double time = mtLauncher.launch(
				trafo, 
				mtLauncher.getSrcAreas().stream().map(a -> a.getName()).collect(Collectors.toList()).toArray(new String[mtLauncher.getSrcAreas().size()]),
				numThreads);

		
		tgtRes = trafo.postprocessing();
		double timeF = (System.currentTimeMillis() - time0) / 1000;
		
		System.out.println("Lintra time: " + timeF);

		tgtRes.save(new FileOutputStream(outXmiPath), null);
//		public void postprocessing() throws BlackboardException {
//			for (IPendingTask tasks : pendingTasks) {
//				tasks.execute();
//			}
//		}
		
		System.out.println("Serializing");
		// mtLauncher.serialize(mtLauncher.getTrgArea(), getOutLintraModelPath());
		// ModelParser.lintra2xmi(mtLauncher.getArea(mtLauncher.getTrgAreas(), "trgArea"), outmmPath, outXmiPath);

		mtLauncher.getTrgAreas().clear();
		mtLauncher.getSrcAreas().forEach(a -> a.clear());
		mtLauncher.destroy();

		return this;
	}
	

	public Resource getOUTResource() {
		return tgtRes;
//		ResourceSet rs = new ResourceSetImpl();
//		Resource mm = rs.getResource(URI.createFileURI(outmmPath), true);
//		mm.getContents().forEach(p -> rs.getPackageRegistry().put(((EPackage) p).getNsURI(), p));
//		return rs.getResource(URI.createFileURI(outXmiPath), true);		
	}

}
