package lintra.evaluation.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.MessageDialog;

import a2l.compiler.A2LOptimiser;
import a2l.compiler.A2LOptimiser.Optimisation;
import a2l.utils.A2LUtils;
import anatlyzer.atl.editor.builder.AnalyserExecutor;
import anatlyzer.atl.editor.builder.AnalyserExecutor.AnalyserData;
import anatlyzer.atl.util.AnalyserUtils.CannotLoadMetamodel;
import anatlyzer.atl.util.AnalyserUtils.PreconditionParseError;
import linda.atlcompiler.LindaCompiler;
import linda.atlcompiler.LintraJDT;
import lintra.commands.GenerateMetamodelClasses;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class CompileTestCasesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ArrayList<IFile> resources = new ArrayList<IFile>();
		
		try {
			ResourcesPlugin.getWorkspace().getRoot().accept(new IResourceVisitor() {			
				@Override
				public boolean visit(IResource resource) throws CoreException {
					if ( resource instanceof IFile && "a2l_tests".equals(resource.getFileExtension()) ) {
						resources.add((IFile) resource);
					}
					return true;
				}
			});

			List<TransformationToCompile> trafos = readTestCaseDescriptions(resources);

			compileAll(trafos);
		} catch (CoreException | IOException e) {
			throw new ExecutionException("Error finding test case files", e);
		}
		
		
		return null;
	}

	protected static void compileAll(List<TransformationToCompile> trafos) {
		ArrayList<TransformationToCompile> withErrors = new ArrayList<CompileTestCasesHandler.TransformationToCompile>();
		for (TransformationToCompile t : trafos) {
			try {
				t.compile();
				if ( true )
					t.compileClasses();
			} catch ( Exception e ) {
				t.error = e;
				withErrors.add(t);
			}		
		}	
		
		if ( withErrors.size() > 0 ) {
			String filesWithErrors = "";
			
			System.err.println();
			System.err.println("There are errors!");
			for (TransformationToCompile t : withErrors) {
				System.out.println("* " + t.path);
				
				filesWithErrors += "\n" + t.path;
			}

			System.err.println();
			System.err.println();
			System.out.println("Details:");
			for (TransformationToCompile t : withErrors) {
				System.out.println("* " + t.path + " ");
				t.error.printStackTrace(System.err);
			}

			MessageDialog.openInformation(null, "There are compilation errors", filesWithErrors);
		}
		
		
	}

	private List<TransformationToCompile> readTestCaseDescriptions(ArrayList<IFile> resources) throws CoreException, IOException {
		ArrayList<TransformationToCompile> trafos = new ArrayList<CompileTestCasesHandler.TransformationToCompile>();
		for (IFile r : resources) {
			trafos.addAll( readTestCaseDescription(r) );
		}
		return trafos;
	}

	private List<TransformationToCompile> readTestCaseDescription(IFile r) throws CoreException, IOException {
		List<TransformationToCompile> l = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(r.getContents()));
		String line = null;
		while ( ((line = reader.readLine()) != null) ) {
			line = line.trim();
			if ( line.startsWith("testcase:")) {
				String path = line.substring("testcase:".length()).trim();
				l.add(new TransformationToCompile(path));
			}
		}
		
		return l;
	}
	
	public static class TransformationToCompile {
		public Exception error;
		protected String path;
		private Set<? extends Optimisation> optimisations;
		private String packageName;

		public TransformationToCompile(String f) {
			this.path = f;
		}
		
		public void setOptimisations(Set<? extends Optimisation> opts) {
			this.optimisations = opts;
		}

		public void compileClasses() {
			IFile r = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			try {
				System.out.print("Compiling classes" + path.toString() + " ... ");

				// TODO: Put in A2LUtils, share result instance, etc.
				AnalyserData result = new AnalyserExecutor().exec(r, false);
				GenerateMetamodelClasses.compileClasses(result);

				System.out.println("Ok!");
			} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
				throw new RuntimeException(e);
			}		
		}

		public void compile() {
			IFile r = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(path));
			try {
				System.out.print("Compiling " + path.toString() + " ... ");
				// A2LUtils.compile(r);
				LindaCompiler c = A2LUtils.createCompiler(r);
				LintraJDT lintraJdt = new LintraJDT(c.getAnalysisResult());				
				lintraJdt.forceOptimistations(optimisations);
				lintraJdt.forcePackageName(packageName);
				lintraJdt.exec(c);
				
				System.out.println("Ok!");
			} catch (IOException | CoreException | CannotLoadMetamodel | PreconditionParseError e) {
				throw new RuntimeException(e);
			}		
		}

		public void setPackageName(String pkgName) {
			this.packageName = pkgName;
		}
	}
}
