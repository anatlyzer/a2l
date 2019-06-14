package linda.atlcompiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.LibraryLocation;

import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.BooleanType;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.FloatType;
import anatlyzer.atl.types.IntegerType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.PrimitiveType;
import anatlyzer.atl.types.StringType;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.ATL.RuleResolutionInfo;
import anatlyzer.atlext.OCL.BooleanExp;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.VariableExp;
import anatlyzer.atlext.processing.AbstractVisitor;

public class LindaCompilerAll extends AbstractVisitor {

	private ATLModel model;
	private IAnalyserResult result;
	private IJavaProject javaProject;
	private IFolder sourceFolder;

	public LindaCompilerAll(IAnalyserResult result) {
		this.result = result;
		this.model  = result.getATLModel();
	}

	protected HashMap<EObject, String> map = new HashMap<EObject, String>();
	protected HashMap<EObject, String> mapStatements = new HashMap<EObject, String>();
	protected int varId = 0;
	
	
	@Override
	public void beforeModule(Module self) {
	}
	
	@Override
	public void inModule(Module self) {
		String text = "";
	
		text = "@Override public void transform(Collection<IdentifiableElement> objs, IMaster masterNextTransfo) throws BlackboardException { \n";
		text += "List<IdentifiableElement> elems = new LinkedList<IdentifiableElement>();\n";
		text += "for (IdentifiableElement e : objs){\n";
		
		for (ModuleElement e : self.getElements()) {
			if ( e instanceof MatchedRule ) {
				MatchedRule r = (MatchedRule) e;
				text += "if check" + r.getName() + "(e) { elems.add(create" + r.getName() + "(e)); }\n";				
			}
		}
	
		text += "\n}";
		
		for (ModuleElement e : self.getElements()) {
			text += get(e) + "\n";
		}
		
		mapStatements.put(self, text);
	}

	@Override
	public void beforeMatchedRule(MatchedRule self) {
		for (InPatternElement element : self.getInPattern().getElements()) {
			map.put(element, element.getVarName());
		}
	}
	
	@Override
	public void inMatchedRule(MatchedRule self) {
		String type = getType(self.getInPattern().getElements().get(0).getInferredType());
		String varName = self.getInPattern().getElements().get(0).getVarName();
		String param = type + " " + varName;
		
		// map.get(self.getInPattern().getFilter());
		
		String body = "return " + varName + " instanceof " + type + ";";
		
		String textCheck = "protected boolean check" + self.getName() + "(" + param + ") {\n" + body + "\n}";
		
		
		String typeOut = getType(self.getOutPattern().getElements().get(0).getInferredType());
		String varNameOut = self.getOutPattern().getElements().get(0).getVarName();
		
		String bodyCreate = "";
		String newTarget = typeOut + " " + varNameOut + " = new " + typeOut + "();\n";
		String setId     = varNameOut + ".setId(TraceFunction.create(" + varName + ".getId(), \"" + self.getName() + "\"));\n";

		bodyCreate = newTarget + setId;
		
		for (Binding binding : self.getOutPattern().getElements().get(0).getBindings()) {
			bodyCreate += getStatements(binding.getValue());
		}
		
		for (Binding binding : self.getOutPattern().getElements().get(0).getBindings()) {
			OclExpression right = binding.getValue();
			Type rightType = ATLUtils.getUnderlyingBindingRightType(binding);
			
			if ( rightType instanceof PrimitiveType ) {
				String setter = varNameOut + ".set" + binding.getPropertyName() + "( " + get(right) + ");\n";
				bodyCreate += setter;
			} else {
				Metaclass m = (Metaclass) rightType;
				// TODO: XX
				
				String tmp = ""; 
				if ( rightType instanceof CollectionType ) {
					// TODO: Support nested collection types (automatic flattening)
					Type colType = ((CollectionType) rightType).getContainedType();
					
					String var = getVar();
					tmp += "List<String> " + var + " = new java.util.ArrayList<String>();";
					tmp += "for(" + getType(colType) + "tmp : " + get(right) + ") {\n";
					for (RuleResolutionInfo rri : binding.getResolvedBy()) {
						tmp += "if ( check" + rri.getRule().getName() + "(tmp) ) {\n";
						tmp += "  " + var + ".add( TraceFunction.resolve(tmp.getId(), \"" + rri.getRule().getName() + "\"));"; 
						tmp += "}";
					}
					tmp += "}\n";
					
					String setter = varNameOut + ".set" + binding.getPropertyName() + "((String[])" + var + ".toArray());\n";
					
					bodyCreate += tmp + setter;
				} else {
					String setter = "";
					for (RuleResolutionInfo rri : binding.getResolvedBy()) {
						setter += "if ( check" + rri.getRule().getName() + "(" + get(right) + ") ) {\n";
						setter += " " + varNameOut + ".set" + binding.getPropertyName() + 
								"(TraceFunction.resolve(" + get(right) + ".getId(), \"" + rri.getRule().getName() + "\"));\n";
						setter += "}";
					}
					
					bodyCreate += setter;
				}
				
			}
			
		}
		
		String textCreate = "protected boolean create" + self.getName() + "(" + param + ") {\n" + bodyCreate + "\n}";
		
		
		
		map.put(self, textCheck + "\n" + textCreate);
	}
	
	private String getType(Type t) {
		if ( t instanceof Metaclass ) {
			Metaclass m = (Metaclass) t;
			return m.getName();
		} else if ( t instanceof BooleanType ) {
			return "boolean";
		} else if ( t instanceof StringType ) {
			return "String";
		} else if ( t instanceof IntegerType ) {
			return "Integer";
		} else if ( t instanceof FloatType ) {
			return "Double";
		} else if ( t instanceof CollectionType ) {
			return "List<" + getType(((CollectionType) t).getContainedType() ) + ">";
		}
		throw new UnsupportedOperationException("Not supported: " + t);
	}

	@Override
	public void inNavigationOrAttributeCallExp(NavigationOrAttributeCallExp self) {
		EStructuralFeature f = (EStructuralFeature) self.getUsedFeature();
		
		String var = getVar();
		
		String getter = get(self.getSource()) + ".get" + f.getName() + "();\n";
		String text = "";
		if ( f instanceof EAttribute ) {
			text = getType(self.getInferredType()) + " " + var + " = " + getter; 
		} else {
			if ( f.isMany() ) {
				String idVar = getVar();
				text  = "String[] " + idVar + " = " + getter + ";\n";
				text += getType(self.getInferredType()) + " " + var + " = " + cast(self.getInferredType()) + 
						"srcArea.readAll(" + idVar + ");\n"; 	
			} else {
				String idVar = getVar();
				text  = "String " + idVar + " = " + getter + ";\n";
				text += getType(self.getInferredType()) + " " + var + " = " + cast(self.getInferredType()) + 
						"srcArea.read(" + idVar + ");\n"; 
			}
		}
		
		map.put(self, var);
		mapStatements.put(self, text);		
	}
	
	private String cast(Type t) {
		return "(" + getType(t) + ")";
	}

	@Override
	public void inVariableExp(VariableExp self) {
		mapStatements.put(self, "");
		map.put(self, get(self.getReferredVariable())); 	
	}
	
	private String getVar() {
		return "var" + (varId++);
	}

	@Override
	public void inBinding(Binding self) {
		System.out.println(self.getLocation());
		for (RuleResolutionInfo rri : self.getResolvedBy()) {
			System.out.println("====> " + rri.getRule().getName());
		}
//		
//		String type = "Object";
//		if ( self.getValue().getInferredType() instanceof BooleanType ) {
//			type = "boolean";
//		}
//		String text = type + " obj = " + map.get(self.getValue());
	}
	
	@Override
	public void inBooleanExp(BooleanExp self) {
		map.put(self, self.isBooleanSymbol() + "");		
	}

	private String get(EObject e) {
		if ( ! map.containsKey(e)) {
			throw new IllegalStateException("No key for: " + e);
		}
		return map.get(e);
	}

	private String getStatements(EObject e) {
		if ( ! mapStatements.containsKey(e)) {
			throw new IllegalStateException("No key for: " + e);
		}
		return mapStatements.get(e);
	}

		
	public void exec() {
		Module module = model.getModule();
		startVisiting(module);
		
		String source = getStatements(module);
		
		createJavaProject(module.getName() + ".linda");
		
		// TODO Auto-generated method stub
		System.out.println("Compiling...");

		String packages = "import java.util.Collection;" + "\n" + 
							"import java.util.HashSet;" + "\n" +
							"import java.util.LinkedList;" + "\n" +
							"import java.util.List;" + "\n" +
							"import java.util.Set;" + "\n" +

							"import blackboard.BlackboardException;" + "\n" +
							"import blackboard.IArea;" + "\n" +
							"import blackboard.IdentifiableElement;" + "\n" +
							"import blackboard.SearchByIdRange;" + "\n" +
							"import transfo.IMaster;" + "\n" +
							"import transfo.ITransformation;" + "\n" +
							"import transfo.TraceFunction;" + "\n";
		
		String classDcl = "public class " + module.getName() + " implements ITransformation {\n";
		
		source = packages + "\n" + classDcl + source + "\n}";
		
		// Storing
		String packageName = "test.atl";
		String className = "Test";
		
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
				this.sourceFolder = project.getFolder("src");
				return;
			}
			
			
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { JavaCore.NATURE_ID });
			project.setDescription(description, null);
			
			IJavaProject javaProject = JavaCore.create(project); 
			
			IFolder binFolder = project.getFolder("bin");
			binFolder.create(false, true, null);
			javaProject.setOutputLocation(binFolder.getFullPath(), null);

			 List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
IVMInstall vmInstall = JavaRuntime.getDefaultVMInstall();
LibraryLocation[] locations = JavaRuntime.getLibraryLocations(vmInstall);
for (LibraryLocation element : locations) {
 entries.add(JavaCore.newLibraryEntry(element.getSystemLibraryPath(), null, null));
}
//add libs to project class path
javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), null);
			
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

}
