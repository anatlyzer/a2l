package lintra.evaluation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Module;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleNotFoundException;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.TimingData;
import org.eclipse.m2m.atl.engine.compiler.AtlStandaloneCompiler;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;

import lintra2.stats.IStatsRecorder;

public class ATLExecutor {
	
	/**
	 * The refining trace model.
	 */
	protected IModel refiningTraceModel;

	private String transformationFile;
	private String temporalAsmPath = null;
	
	private ArrayList<ModelData> modelData;

	private ILauncher launcher;
	
	private boolean useEMFTVM = true;		
	
	public static class ModelData {
		public final String metamodelName;
		public final String metamodelPath;
		private String modelName;
		public final String modelPath;
		private IReferenceModel loadedMetamodel;
		private IModel loadedModel;
		private ModelKind kind;
		private String newModelPath;
		private Resource inputResource;
		
		public ModelData(String modelName, String modelPath, String metamodelName, String metamodelPath, ModelKind kind) {
			this.metamodelName = metamodelName;
			this.metamodelPath = metamodelPath;
			this.modelName = modelName;
			this.modelPath = modelPath;    // This what it is read
			this.newModelPath = modelPath; // This is for serialization
			this.kind = kind;			
		}

		public ModelData(String modelName, String modelPath, String metamodelName, String metamodelPath, ModelKind kind, String newModelPath) {
			this(modelName, modelPath, metamodelName, metamodelPath, kind);
			if ( kind != ModelKind.INOUT )
				throw new IllegalArgumentException();
			this.newModelPath = newModelPath;
		}
		
		public ModelData(String modelName, Resource resource, String metamodelName, String metamodelPath, ModelKind kind) {
			this(modelName, "no-model", metamodelName, metamodelPath, kind);
			this.inputResource = resource;
		}

		public void load() {
			try {
				ModelFactory factory = new EMFModelFactory();
				EMFInjector injector = new EMFInjector();
			 	loadedMetamodel = factory.newReferenceModel();
				injector.inject(loadedMetamodel, metamodelPath);
				this.loadedModel = factory.newModel(loadedMetamodel);
				if ( kind != ModelKind.OUT) {
					if ( inputResource != null ) {
						injector.inject(loadedModel, inputResource);
					} else {
						injector.inject(loadedModel, modelPath);
					}
				}
			} catch ( ATLCoreException e ) {
				throw new RuntimeException(e);
			}
		}

		public void save() throws ATLCoreException {
			IExtractor extractor = new EMFExtractor();
			extractor.extract(this.loadedModel, this.newModelPath);
		}
	}
	
	public static enum ModelKind {
		IN,
		OUT,
		INOUT
	}
	
	public static ModelData inModel(String modelName,  String modelPath, String metamodelName, String metamodelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.IN);
	}

	public static ModelData inModel(String modelName,  Resource resource, String metamodelName, String metamodelPath) {
		return new ModelData(modelName, resource, metamodelName, metamodelPath, ModelKind.IN);
	}

	public static ModelData outModel(String modelName,  String modelPath, String metamodelName, String metamodelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.OUT);
	}

	public static ModelData inOutModel(String modelName,  String modelPath, String metamodelName, String metamodelPath, String newModelPath) {
		return new ModelData(modelName, modelPath, metamodelName, metamodelPath, ModelKind.INOUT, newModelPath);
	}

	HashMap<String, Model> emftvmModels = new HashMap<String, Model>();
	//ArrayList<Model> outModelsEMFTVM;

	private ExecEnv execEnvEmftvm;

	private boolean allowInterModelReferences;

	private boolean doModelWarmup;

	private IStatsRecorder stats = IStatsRecorder.NULL_RECORDER; 
	
	private ATLExecutor execEMFTVM(String transformationFile, ModelData[] models) {
		// TODO Auto-generated method stub
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
		ResourceSet rs = new ResourceSetImpl();
		
		this.execEnvEmftvm = env;
		
		// outModelsEMFTVM = new ArrayList<Model>();
		emftvmModels = new HashMap<String, Model>();
		for (ModelData modelData : models) {
			Metamodel metaModel = EmftvmFactory.eINSTANCE.createMetamodel();
			metaModel.setResource(rs.getResource(URI.createURI(modelData.metamodelPath), true));
			env.registerMetaModel(modelData.metamodelName, metaModel);

			for (EObject pkg : metaModel.allInstancesOf(EcorePackage.Literals.EPACKAGE)) {
				rs.getPackageRegistry().put(((EPackage) pkg).getNsURI(), pkg);
			}
			
			Model aModel = EmftvmFactory.eINSTANCE.createModel();
			Resource r = null;

//			if ( modelData.kind == ModelKind.OUT ) {
//				r = rs.createResource(URI.createURI(modelData.modelPath, true));
//			} else {
//				r = rs.getResource(URI.createURI(modelData.modelPath, true), true);
//			}
			
			// This is to make cross references work in standalone mode
			if ( modelData.kind == ModelKind.OUT ) {
				r = rs.createResource(URI.createFileURI(new File(modelData.modelPath).getAbsolutePath()));
			} else {
				if (modelData.inputResource != null)
					r = modelData.inputResource;
				else
					r = rs.getResource(URI.createFileURI(new File(modelData.modelPath).getAbsolutePath()), true);
			}

			
			aModel.setResource(r);
			
			if ( modelData.kind == ModelKind.OUT ) {
				env.registerOutputModel(modelData.modelName, aModel);
			} else if ( modelData.kind == ModelKind.INOUT ){
				env.registerInOutModel(modelData.modelName, aModel);
			} else {
				env.registerInputModel(modelData.modelName, aModel);
			}
			
//			if ( modelData.kind == ModelKind.OUT || modelData.kind == ModelKind.INOUT ) {
//				outModelsEMFTVM.add(aModel);
//			}
			emftvmModels.put(modelData.modelName, aModel);
		}
		
		// Load and run module
		// ModuleResolver mr = new DefaultModuleResolver("platform:/plugin/my.plugin.id/transformations/", new ResourceSetImpl());
		ModuleResolver mr = new ModuleResolver() {			
			@Override
			public Module resolveModule(String name) throws ModuleNotFoundException {
				//ResourceSet rs = new ResourceSetImpl();		
				String bcode = transformationFile.replace(".atl", ".emftvm");
				Resource r = new EMFTVMResourceImpl();
				try {
					r.load(new FileInputStream(new File(bcode)), null);
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
				//Resource r = rs.getResource(URI.createFileURI(b), true);
				return (Module) r.getContents().get(0);
			}
		};
		TimingData td = new TimingData();
		env.loadModule(mr, transformationFile);
		
		td.finishLoading();
		
		//double time0 = System.currentTimeMillis();
		stats.startLaunch();
		env.run(td);
		stats.endLaunch();
		//double timeFAll = (System.currentTimeMillis() - time0) / 1000;
		//System.out.println("EMFTVM time: " + timeFAll);

		td.finish();
		
		return this;
	}

	public ATLExecutor useEMFVM() {
		this.useEMFTVM = false;
		return this;
	}
	
	public ATLExecutor useEMFTVM() {
		this.useEMFTVM = true;
		return this;
	}
	
	public ATLExecutor allowInterModelReferences(boolean v) {
		this.allowInterModelReferences = v;
		return this;
	}
	
	public ATLExecutor perform(String transformationFile, ModelData... models) throws IOException {
		modelData = new ArrayList<ATLExecutor.ModelData>();
		for (ModelData m : models) {
			modelData.add(m);
		}
		
		transformationFile = normalizePath(transformationFile);
		
		if ( useEMFTVM ) {
//			ResourceSet rs = new ResourceSetImpl();
//			Resource r = rs.getResource(URI.createPlatformPluginURI("org.eclipse.m2m.atl.emftvm.compiler/transformations/ATLWFR.emftvm", true), true);
//			System.out.println(r);
			
			if ( transformationFile.endsWith(".atl"))
				transformationFile = compileToASMFile(transformationFile);
			
			return execEMFTVM(transformationFile, models);
		}
		
		this.launcher = null;
		this.transformationFile = transformationFile;
		this.modelData = new ArrayList<ModelData>();
		for (ModelData modelData : models) {
			modelData.load();
			this.modelData.add(modelData);
		}
		
		ILauncher launcher = new EMFVMLauncher();
		Map<String, Object> launcherOptions = new HashMap<String, Object>();
		
		launcherOptions.put("allowInterModelReferences", allowInterModelReferences); // TODO: Allow configuration
		launcher.initialize(launcherOptions);
		
		for (ModelData modelData : models) {
			switch ( modelData.kind ) {
			case IN:
				
				if ( doModelWarmup )
					warmupModelInit(modelData);			
				
				launcher.addInModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			case INOUT:
				launcher.addInOutModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			case OUT:
				launcher.addOutModel(modelData.loadedModel, modelData.modelName, modelData.metamodelName);
				break;
			}
		}

		String asmFile = compileToASMFile(transformationFile);
		
		//double time0 = System.currentTimeMillis();
		stats.startLaunch();
		launcher.launch("run", null, launcherOptions, new FileInputStream(asmFile));
		stats.endLaunch();
		//double timeF = (System.currentTimeMillis() - time0) / 1000;
		//System.out.println("ATL time: " + timeF);
		this.launcher = launcher;
		
		// dummy
		stats.startPostprocessing();
		stats.endPostprocessing();
		
		return this;
		// IReferenceModel refiningTraceMetamodel = factory.getBuiltInResource("RefiningTrace.ecore");
		// refiningTraceModel = factory.newModel(refiningTraceMetamodel);

	}
	
	private void warmupModelInit(ModelData modelData) {
		//double time0 = System.currentTimeMillis();
		// Warmup to avoid bias
		stats.startConfiguration();
		EMFModel em = ((EMFModel) modelData.loadedModel);
		for (EObject eClass : em.getReferenceModel().getAllElementsByType(EcorePackage.Literals.ECLASS)) {
			em.getElementsByType(eClass);					
		}
		stats.endConfiguration();
		//double timeF = (System.currentTimeMillis() - time0) / 1000;
		//System.out.println("Input model warmup: " + timeF);
	}

	private String normalizePath(String s) {
		return s.replaceAll("\\\\", "/");
	}

	public ATLExecutor save() throws ATLCoreException, IOException {
		if ( this.useEMFTVM ) {
			// Save models
			
			for (ModelData model : modelData) {
				if ( model.kind == ModelKind.INOUT) {
					Resource r = emftvmModels.get(model.modelName).getResource();
					r.save(new FileOutputStream(model.newModelPath), Collections.emptyMap());
				} else {
					emftvmModels.get(model.modelName).getResource().save(Collections.emptyMap());
				}
			}
			return this;
		}
				
		// Normal case
		for (ModelData md : modelData) {
			if ( md.kind == ModelKind.OUT || md.kind == ModelKind.INOUT ) {
				md.save();
			}
		}
		return this;
	}
	
	public Resource getModelResource(String name) {
		if ( useEMFTVM ) {
			if ( execEnvEmftvm == null )
				throw new IllegalStateException();
			
			return emftvmModels.get(name).getResource();
		}
			
		return getModel(name).getResource();
	}
	
	public EMFModel getModel(String name) {		
		if ( launcher == null )
			throw new IllegalStateException();
		return (EMFModel) launcher.getModel(name);
	}
	
	public ATLExecutor tempAsmPath(String path) {
		this.temporalAsmPath = path;
		return this;
	}
	
		
	private String compileToASMFile(String trafo) throws IOException {
		// compile transformation
		File trafoFile = new File(trafo);		
		String asmTransformation = trafo.replace(".atl", ".asm");
		if ( temporalAsmPath != null ) {
			asmTransformation = temporalAsmPath + File.separator + trafoFile.getName().replace(".atl", ".asm");
			asmTransformation = normalizePath(asmTransformation);
		}
		
		

		// AtlCompiler.getCompiler("atl2006").compile(in, outputFileName)
		//Atl2006Compiler compiler  = new Atl2006Compiler();
		//Atl2010InPlace compiler  = new Atl2010InPlace();
		AtlStandaloneCompiler compiler = null; 
		if ( useEMFTVM ) {
			// Some adjustments...
			compiler = new AtlToEmftvmCompiler();
			asmTransformation = asmTransformation.replace(".asm", ".emftvm");
		} else 
			compiler = new Atl2006Compiler();
		
		FileInputStream fis = new FileInputStream(trafoFile);
		CompileTimeError[] errors = compiler.compile(fis, asmTransformation);
		fis.close();
				
		boolean fatalErrors = false;
		for (CompileTimeError error : errors) fatalErrors = fatalErrors || !error.getSeverity().equals("warning");		
		if  (fatalErrors || !new File(asmTransformation).exists()) {
			System.out.println( fatalErrors? "---> [" + errors[0].getLocation() + "] " + errors[0].getDescription() : "---> no asm file could be generated");
			return null;
		}
			
		return asmTransformation;		
	}

	public void doModelWarmup(boolean modelWarmup) {
		this.doModelWarmup = modelWarmup;
	}

	public ATLExecutor setStatsRecorder(IStatsRecorder n){
		stats = n;
		return this;
	}


}
