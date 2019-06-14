package a2l.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import a2l.compiler.A2LCompiler;
import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.driver.emf.EMFDriver;
import a2l.driver.lintra.LintraDriver;
import a2l.driver.uml.UMLDriver;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.ATL.Unit;
import linda.atlcompiler.LindaCompiler;
import linda.atlcompiler.LintraJDT;

public class A2LUtils {

	public static final String LINTRA_DRIVER_TAG = "lintra-classes";

	public static LindaCompiler createCompiler(IResource r) throws IOException, CoreException, CannotLoadMetamodel, PreconditionParseError {
		AnalyserData data = new AnalyserExecutor().exec(r, false);
		return A2LUtils.createCompiler(data.getAnalyser());		
	}
	
	public static void compile(IResource r) throws IOException, CoreException, CannotLoadMetamodel, PreconditionParseError {
		LindaCompiler c = createCompiler(r);
		new LintraJDT(c.getAnalysisResult()).exec(c);
	}
	
	/**
	 * Creates a new Lintra compiler taking account the annotations to decide
	 * which meta-modeling driver instantiate.
	 * 
	 * @param result
	 * @return
	 */
	public static LindaCompiler createCompiler(IAnalyserResult result) {
		DriverConfiguration config = new DriverConfiguration();
		Map<String, String> map = getMetamodelDrivers(result);
		map.forEach((mmName, driver) -> {
			config.addDriver(mmName, selectDriver(driver, mmName, result.getATLModel()));			
		});
		
		// if ( ! map.values().contains(A2LUtils.LINTRA_DRIVER_TAG) )
		// Always use the new A2L compiler which is configured via drivers
		return new A2LCompiler(result, config);
		
		// return new LindaCompiler(result, config);
	}

	public static Map<String, String> getMetamodelDrivers(IAnalyserResult result) {
		Unit unit = result.getATLModel().getRoot();
		HashMap<String, String> map = new HashMap<String, String>();
		Set<String> mmNames = ATLUtils.getModelInfo(result.getATLModel()).stream().map(info -> info.getMetamodelName()).collect(Collectors.toSet());
		
		for (String str : unit.getCommentsBefore()) {
			str = str.replace("--", "").trim();
			if ( str.startsWith("@driver ") ) {
				String[] parts = str.substring("@driver ".length()).split("=");
				if ( parts.length != 2 ) {
					throw new IllegalArgumentException("TODO: Check this statically");
				}
				
				String mm = parts[0].trim();
				
				map.put(mm, parts[1].trim());

				mmNames.remove(mm);
			}
		}

		for (String string : mmNames) {
			map.put(string, LINTRA_DRIVER_TAG);
		}
		
		return map;
	}
	
	private static IMetaDriver selectDriver(String str, String mmName, ATLModel m) {
		switch(str.toLowerCase()) {
		case LINTRA_DRIVER_TAG: return new LintraDriver();
		case "emf-uml": return new UMLDriver(mmName, m);
		case "emf": return new EMFDriver(mmName, m);
		default:
			throw new IllegalArgumentException("Unknown driver: " + str);
		}
		
	}

	
	public static Map<String, GenModel> loadGenModels(ATLModel model) {
		List<String> genmodels = ATLUtils.findCommaTags(model.getModule(), "genpath");
		Map<String, GenModel> genmap = genmodels.stream().
			map(line -> line.split("=")).
			filter(array -> array.length == 2).
			collect(Collectors.toMap(array -> array[0], array -> loadGenModel(array[1])));
		return genmap;
	}	
	
	private static GenModel loadGenModel(String path) {
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.getResource(URI.createPlatformResourceURI(path, true), true);
		
		GenModel m = (GenModel) r.getContents().get(0);
		return m;
	}	
	
	public static String getTransformationClassName(Module m) {
		return m.getName();
	}
}
