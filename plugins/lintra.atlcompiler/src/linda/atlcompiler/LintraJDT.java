package linda.atlcompiler;

import java.nio.channels.IllegalSelectorException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.lang.model.util.Elements;

import linda.atlcompiler.JavaGenerator.GenData;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JavaGenModel;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICodeFormatter;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.core.formatter.DefaultCodeFormatterConstants;
import org.eclipse.jdt.internal.launching.JREContainerInitializer;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;
import org.eclipse.text.edits.TextEdit;

import a2l.compiler.A2LOptimiser;
import a2l.compiler.A2LOptimiser.Optimisation;
import a2l.compiler.FootprintGenerator;
import a2l.compiler.RunnerGenerator;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atlext.ATL.Module;

/**
 * Integration of the Lintra compiler with Eclipse JDT.
 * 
 * @author jesus
 */
public class LintraJDT {

	private ATLModel model;
	private IAnalyserResult result;

	private IJavaProject javaProject;
	private IFolder sourceFolder;
	
	// Null values means, use the one written in the transformation
	private Set<? extends Optimisation> forcedOptimisations = null;
	private String forcedPackageName = null;

	public LintraJDT(IAnalyserResult result) {
		this.result = result;
	}
	
	public void forceOptimistations(Set<? extends Optimisation> forcedOptimisations) {
		this.forcedOptimisations = forcedOptimisations;
	}

	public void forcePackageName(String packageName) {
		this.forcedPackageName  = packageName;
	}

	
	public void exec(BaseCompiler compiler) {
		System.out.println("Compiling...");

//		if ( hasProblems(this.result) ) {
//			System.out.println("Has problems. Cannot compile.");
//			return;
//		}
		
		
		createJavaProject(getJavaProjectName());
		
		// Read the optimistations from the file, but this is overriden if a value
		// for forcedOptimisations has been set. 
		Set<? extends Optimisation> opts = getsOptimizationEnabled();
		if ( forcedOptimisations != null ) {
			opts = forcedOptimisations;
		}
				
		if ( opts.size() > 0 ) {
			compiler.atlOptimize(opts);
		}
		
		JavaGenModel jmodel = compiler.compile(getPkgName());		
		generateJavaClasses(jmodel);
		
		RunnerGenerator gen = compiler.getRunnerGenerator();
		JavaGenModel gModel = gen.generate(getPkgName());
		generateJavaClasses(gModel);

		FootprintGenerator genf = compiler.getFootprintGenerator();
		JavaGenModel gfModel = genf.generate(getPkgName());
		generateJavaClasses(gfModel);

		
/*		
 * 
		try {
			IPackageFragment pack = javaProject.getPackageFragmentRoot(sourceFolder).createPackageFragment(packageName, false, null);
			StringBuffer buffer = new StringBuffer();
			buffer.append("package " + pack.getElementName() + ";\n");
			buffer.append("\n");
			buffer.append(source);

			String cuClassName = className + ".java";
			ICompilationUnit cu = pack.getCompilationUnit(cuClassName);
			if ( cu != null && cu.exists() ) {
				cu.delete(true, null);
			}
			cu = pack.createCompilationUnit(cuClassName, buffer.toString(), false, null);
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		

		System.out.println("Finished!");

	}

	private String getPkgName() {
		if ( forcedPackageName != null ) {
			return forcedPackageName;
		}
		return getPkgName(result.getATLModel());
	}

	private void generateJavaClasses(JavaGenModel jmodel) {
		GenData data = new JavaGenerator().generate(jmodel);		
		
		data.forEachClass((c, source) -> {
			try {
				createClassInFilesystem(c.getPkg(), c.getName(), source);
			} catch (JavaModelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		});
	}



	private boolean hasProblems(IAnalyserResult result) {
		return result.getErrors().getLocalProblems().stream().anyMatch(p -> {
			return "src-typing".equals(AnalyserUtils.getProblemKind(p));
		});
	}

	public void createClassInFilesystem(String packageName, String className, String source) throws JavaModelException {
		createJavaProject(getJavaProjectName());
		
		IPackageFragment pack = javaProject.getPackageFragmentRoot(sourceFolder).createPackageFragment(packageName, false, null);

		String cuClassName = className + ".java";
		ICompilationUnit cu = pack.getCompilationUnit(cuClassName);
		if ( cu != null && cu.exists() ) {
			cu.delete(true, null);
		}
		cu = pack.createCompilationUnit(cuClassName, source, false, null);

		// format(source, cu);				
	}

	private void format(String source, ICompilationUnit cu) throws JavaModelException {
		Map options = DefaultCodeFormatterConstants.getEclipseDefaultSettings();
		// initialize the compiler settings to be able to format 1.5 code
		options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_5);
		options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_5);
		options.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_5);

		// change the option to wrap each enum constant on a new line
		options.put(
			DefaultCodeFormatterConstants.FORMATTER_ALIGNMENT_FOR_ENUM_CONSTANTS,
			DefaultCodeFormatterConstants.createAlignmentValue(
			true,
			DefaultCodeFormatterConstants.WRAP_ONE_PER_LINE,
			DefaultCodeFormatterConstants.INDENT_ON_COLUMN));
		
		CodeFormatter formatter = ToolFactory.createCodeFormatter(options);

		// http://help.eclipse.org/kepler/index.jsp?topic=%2Forg.eclipse.jdt.doc.isv%2Fguide%2Fjdt_api_codeformatter.htm
		final TextEdit edit = formatter.format(
				CodeFormatter.K_COMPILATION_UNIT, // format a compilation unit
				source, // source to format
				0, // starting position
				source.length(), // length
				0, // initial indentation
				System.getProperty("line.separator")); // line separator

		cu.applyTextEdit(edit, null);
	}

	private String getJavaProjectName() {		
		List<String> projectTags = ATLUtils.findCommaTags(result.getATLModel().getRoot(), "project");
		if ( projectTags.size() > 0 ) {
			String[] elems  = projectTags.get(0).split("=");
			if ( elems.length == 2 && elems[0].trim().length() > 0  ) {
				// && elems[1].trim().length() == 1
				return elems[0].trim();
			}
		}
		
		Module module = result.getATLModel().getModule();
		return module.getName() + ".lintra";
	}

	public static String getPkgName(ATLModel atlModel) {
		List<String> projectTags = ATLUtils.findCommaTags(atlModel.getRoot(), "project");
		if ( projectTags.size() > 0 ) {
			String[] elems  = projectTags.get(0).split("=");
			if ( elems.length == 2 && elems[1].trim().length() > 0  ) {
				return elems[1].trim();
			}
		}
		
		return "a2l.transformation";
	}
	
	private Set<Optimisation> getsOptimizationEnabled() {
		List<String> optimizationTags = ATLUtils.findCommaTags(result.getATLModel().getRoot(), "optimizations");
		Set<A2LOptimiser.Optimisation> optimizations = new HashSet<>();
		for (String string : optimizationTags) {
			if ( string.equals("all") ) {
				Collections.addAll(optimizations, A2LOptimiser.Optimisation.values());				
			} else {
				A2LOptimiser.Optimisation opt = A2LOptimiser.Optimisation.valueOf(string.toUpperCase());
				if ( opt != null ) {
					optimizations.add(opt);
				} else {
					throw new RuntimeException("No optimisation: " + string);
				}
			}
		}
		return optimizations;
	}

	
	public IJavaProject getJavaProject() {
		createJavaProject(getJavaProjectName());
		return javaProject;
	}
	
	// From: https://sdqweb.ipd.kit.edu/wiki/JDT_Tutorial:_Creating_Eclipse_Java_Projects_Programmatically
	private void createJavaProject(String projectName) {
		IWorkspaceRoot wroot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = wroot.getProject(projectName);
		
		try {
			if ( ! project.exists() ) {
				project.create(null);
				project.open(null);
			} else {
				this.javaProject = JavaCore.create(project); 
				this.sourceFolder = project.getFolder(getSrcFolder());
				return;
			}
						
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { JavaCore.NATURE_ID });
			project.setDescription(description, null);
			
			IJavaProject javaProject = JavaCore.create(project); 
			
			IFolder binFolder = project.getFolder("bin");
			binFolder.create(false, true, null);
			javaProject.setOutputLocation(binFolder.getFullPath(), null);

			configureLibrary(javaProject);
			
			IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
			
			//new JREContainerInitializer().
			
			IFolder sourceFolder = project.getFolder("src");
			sourceFolder.create(false, true, null);

			IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
			
			IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
			javaProject.setRawClasspath(newEntries, null);

		
			this.javaProject = javaProject;
			this.sourceFolder = sourceFolder;
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
		
		
	}

	private String getSrcFolder() {
		return "src-gen";
	}

	private void configureLibrary(IJavaProject javaProject) throws JavaModelException {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
		LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
		for (LibraryLocation element : locations) {
			entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
		}
		// add libs to project class path
		javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
	}
	
}
