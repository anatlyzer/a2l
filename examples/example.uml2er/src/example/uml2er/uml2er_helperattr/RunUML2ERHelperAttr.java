package example.uml2er.uml2er_helperattr;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import emfm2lintra.ModelParser;
import runners.MTLauncherOutplace;
import transfo.LinTraParameters;

public class RunUML2ERHelperAttr {

	private String inXmiPath;
	private String inmmPath;
	private String outXmiPath;
	private String outmmPath;

	public RunUML2ERHelperAttr setIN(String inXmiPath, String inmmPath) {
		this.inXmiPath = inXmiPath;
		this.inmmPath = inmmPath;
		return this;
	}

	public RunUML2ERHelperAttr setOUT(String outXmiPath, String outmmPath) {
		this.outXmiPath = outXmiPath;
		this.outmmPath = outmmPath;
		return this;
	}
	
	public RunUML2ERHelperAttr run() throws Exception {
		System.out.println("XMI2Lintra...");
		ModelParser.xmi2lintra(getClass().getClassLoader(), inmmPath, inXmiPath, getLintraModelPath());

		System.out.println("Transforming");
		MTLauncherOutplace mtLauncher = new MTLauncherOutplace();
		mtLauncher.createBlackboard();
		mtLauncher.loadModel("srcArea", 1, getLintraModelPath(), getClass().getClassLoader());
		System.out.println("Model loaded");
		int numThreads = LinTraParameters.NUMBER_OF_THREADS_T1;

		double time = mtLauncher.launch(
				new UML2ERHelperAttr(mtLauncher.getSrcAreas().get(0), mtLauncher.getTrgArea(), mtLauncher.getCachingArea()),
				mtLauncher.getSrcAreas().stream().map(a -> a.getName()).collect(Collectors.toList()).toArray(new String[mtLauncher.getSrcAreas().size()]),
				numThreads);

		System.out.println(time);
		System.out.println("Serializing");
		// mtLauncher.serialize(mtLauncher.getTrgArea(), getOutLintraModelPath());
		ModelParser.lintra2xmi(mtLauncher.getTrgArea(), outmmPath, outXmiPath);

		mtLauncher.getTrgArea().clear();
		mtLauncher.getSrcAreas().forEach(a -> a.clear());
		mtLauncher.destroy();

		return this;
	}

	private String getLintraModelPath() {
		return inXmiPath + ".ser";
	}

	public Resource getOUTResource() {
		ResourceSet rs = new ResourceSetImpl();
		Resource mm = rs.getResource(URI.createFileURI(outmmPath), true);
		mm.getContents().forEach(p -> rs.getPackageRegistry().put(((EPackage) p).getNsURI(), p));
		return rs.getResource(URI.createFileURI(outXmiPath), true);		
	}

}
