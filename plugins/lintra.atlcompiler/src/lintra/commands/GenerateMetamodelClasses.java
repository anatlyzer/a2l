package lintra.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import a2l.utils.A2LUtils;
import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.editor.AtlEditorExt;
import anatlyzer.atl.index.AnalysisIndex;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import linda.atlcompiler.LintraJDT;
import lintra.lingen.GenClass;
import lintra.lingen.LinGen2;
import lintra.lingen.LintraEMFReaderGenerator;
import lintra.lingen.LintraEMFWriterGenerator;

public class GenerateMetamodelClasses extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		
		if ( selection instanceof TextSelection ) {
			IEditorPart editor = HandlerUtil.getActiveEditor(event);
			if ( editor instanceof AtlEditorExt ) {
				AtlEditorExt atlEditor = (AtlEditorExt) editor;
				IFile file = (IFile) atlEditor.getUnderlyingResource();

				HashSet<String> transformed = new HashSet<>();
				AnalysisResult result = AnalysisIndex.getInstance().getAnalysis(file);
				compileClasses(transformed, result);
				
			}
		}
		return null;
	}

	public static void compileClasses(AnalysisResult result) {
		compileClasses(new HashSet<>(), result);
	}
	
	private static void compileClasses(HashSet<String> transformed, AnalysisResult result) {
		Map<String, String> drivers = A2LUtils.getMetamodelDrivers(result.getAnalyser());
		
		if ( result != null ) {
			for (ModelInfo info : ATLUtils.getModelInfo(result.getATLModel())) {
				if ( transformed.contains(info.getMetamodelName() ) )
					continue;
				
				if ( ! drivers.get(info.getMetamodelName()).equals(A2LUtils.LINTRA_DRIVER_TAG) )
					continue;
				
				genClasses(new LintraJDT(result.getAnalyser()), info);
				transformed.add(info.getMetamodelName());
			}					
		}
	}

	private static void genClasses(LintraJDT jdt, ModelInfo info) {
		Resource r = null;
		if ( info.isURI() ) {			
			EPackage pkg = Registry.INSTANCE.getEPackage(info.getURIorPath());
			r = pkg.eResource();
		} else {
			// assuming is a path
			IFile metamodel = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(info.getURIorPath()));
			
			ResourceSetImpl rs = new ResourceSetImpl();
			r = rs.getResource(URI.createPlatformResourceURI(metamodel.getFullPath().toOSString(), true), true);
		}
		
		LinGen2 gen = new LinGen2(r);
		genClasses(jdt, gen.generate());
		
		LintraEMFReaderGenerator emfGen = new LintraEMFReaderGenerator(r);
		genClasses(jdt, emfGen.generate());

		LintraEMFWriterGenerator emfGenW = new LintraEMFWriterGenerator(r);
		genClasses(jdt, emfGenW.generate());

		
		System.out.println("Generated: " + r.getURI());
	}

	protected static void genClasses(LintraJDT jdt, List<GenClass> classes) {
		for (GenClass f : classes) {
			try {
				jdt.createClassInFilesystem(f.getPkgName(), f.getTypeName(), f.getContents());
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
