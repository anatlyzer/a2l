package a2l.compiler;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import a2l.driver.DriverConfiguration;
import a2l.driver.ICollectionsDriver;
import a2l.driver.IMetaDriver;
import a2l.driver.IMetaDriver.IDataSourceInitializerDriver;
import a2l.driver.JavaslangDriver;
import a2l.utils.A2LUtils;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atlext.ATL.Module;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.GenCompiler;
import linda.atlcompiler.ICompilationContext;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.ITyping;
import linda.atlcompiler.LindaTyping;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;

/**
 * This generates a default runner for the Lintra framework.
 * 
 * @author jesus
 *
 */
public class LintraRunnerGenerator {
	private IAnalyserResult result;
	private DriverConfiguration drivers;
	protected ITyping typ;
	
	public LintraRunnerGenerator(IAnalyserResult result, DriverConfiguration driverConfiguration) {
		this.result = result;
		this.drivers = driverConfiguration;		
	}
	
	public JavaGenModel generate(String basePkg) {
		Module m = result.getATLModel().getModule();
		
		JavaGenModel jmodel = JavagenFactory.eINSTANCE.createJavaGenModel();
		typ = new SimpleTyping(jmodel, result.getATLModel(),  drivers);
		
		JClass gclass = JavagenFactory.eINSTANCE.createJClass();
		jmodel.getClasses().add(gclass);
		
		gclass.setPkg(basePkg);
		gclass.setName(A2LUtils.getTransformationClassName(m) + "Runner");

		gclass.getImports().add(typ.getType("lintra2.blackboard.IdMapper"));
		gclass.getImports().add(typ.getType("lintra2.runners.MTLauncherOutplace"));
		gclass.getImports().add(typ.getType("lintra2.transfo.IFootprint"));
		gclass.getImports().add(typ.getType("lintra2.stats.IStatsRecorder"));

		// mtLauncher field		
		JAttribute mtLauncher = JavagenFactory.eINSTANCE.createJAttribute();
		mtLauncher.setName("mtLauncher");
		mtLauncher.setType(typ.createTypeRef("MTLauncherOutplace"));
		
		gclass.getAttributes().add(mtLauncher);
		
		// Field: numThreads
		JAttribute numThreads = JavagenFactory.eINSTANCE.createJAttribute();
		numThreads.setName("numThreads");
		numThreads.setType(typ.createTypeRef("int"));
		
		gclass.getAttributes().add(numThreads);
		createSetter(gclass, numThreads, "setNumThreads");

		// Field: footprint
		JAttribute footprint = JavagenFactory.eINSTANCE.createJAttribute();
		footprint.setName("footprint");
		footprint.setType(typ.createTypeRef("IFootprint"));
		
		gclass.getAttributes().add(footprint);
		createSetter(gclass, footprint, "setFootprint");
		

		// Field: stats
		JAttribute stats = JavagenFactory.eINSTANCE.createJAttribute();
		stats.setName("stats");
		stats.setType(typ.createTypeRef("IStatsRecorder"));
		
		gclass.getAttributes().add(stats);
		createSetter(gclass, stats, "setStatsRecorder");

		
		// 
		
		List<ModelInfo> infos = ATLUtils.getModelInfo(result.getATLModel());
		for (ModelInfo i : infos) {
			
			if ( i.isInput() ) {
				JAttribute attr = JavagenFactory.eINSTANCE.createJAttribute();
				attr.setName(i.getModelName() + "DataSource");
				attr.setType(typ.createTypeRef("IDataSource"));
				
				
				gclass.getAttributes().add(attr);
	
				JMethod method = createSetInputModelMethod(i, gclass, attr);
				gclass.getMethods().add(method);
				
				JMethod method2 = createSetInputModelMethod_ForXMI(i, gclass, attr);
				gclass.getMethods().add(method2);
				
			} else if ( i.isOutput() ) {
				JAttribute modelField = JavagenFactory.eINSTANCE.createJAttribute();
				modelField.setName(i.getModelName() + "ModelResource");
				modelField.setType(typ.createTypeRef("Resource"));

				JAttribute metamodelField = JavagenFactory.eINSTANCE.createJAttribute();
				metamodelField.setName(i.getModelName() + "MetamodelResource");
				metamodelField.setType(typ.createTypeRef("Resource"));

				outputMetamodelResources.put(i.getModelName(), metamodelField);
				modelResources.put(i.getModelName(), modelField);
				
				gclass.getAttributes().add(modelField);
				gclass.getAttributes().add(metamodelField);
	
				JMethod method = createSetOutputModelMethod(i, gclass, modelField, metamodelField);
				gclass.getMethods().add(method);			
				
				JMethod method2 = createSetOutputModelMethod_ForXMI(i, gclass);
				gclass.getMethods().add(method2);
			
				JMethod method3 = createGetOutputResource(i, gclass, modelField);
				gclass.getMethods().add(method3);
				
			}
			
			
		}
		
		createExecutionMethod(gclass, basePkg);
		
		return jmodel;
	}
	
	private HashMap<String, JAttribute> outputMetamodelResources = new HashMap<String, JAttribute>();
	private HashMap<String, JAttribute> modelResources = new HashMap<String, JAttribute>();

	private void createSetter(JClass gclass, JAttribute attribute, String methodName) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName(methodName);
		gclass.getMethods().add(method);
		
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);


		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("n");
		param1.setType(typ.createTypeRef(attribute.getType().getType().getName()));

		method.getParameters().add(param1);
	
		method.getStatements().add( CreationHelpers.createAssignment(attribute, CreationHelpers.refVar(param1)) );
		
		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refToThis(gclass)));		
	}

	private void createExecutionMethod(JClass gclass, String basePkg) {

		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("run");
		gclass.getMethods().add(method);

		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);

		method.getThrows_().add(typ.createTypeRef("Exception"));

		Context ctx = new ICompilationContext.Context(new CompilationEnv(result, drivers), typ, new GenCompiler(), new JavaslangDriver(), null);
		ctx.getEnv().pushBlock(method);

		// Add dinamically the transformation name 
		String qTransformationClassName = getTransformationClassName(basePkg);
		typ.createLibType(basePkg, qTransformationClassName.replace(basePkg + ".", ""));
		
		
		method.getStatements().add(CreationHelpers.createText("if ( this.stats == null ) this.stats = IStatsRecorder.NULL_RECORDER;"));
		
		String s1 =  
				"mtLauncher = new MTLauncherOutplace(); " +
				"mtLauncher.createBlackboard();"; 
		
		List<ModelInfo> infos = ATLUtils.getModelInfo(result.getATLModel());

		// Configuration
		method.getStatements().add(CreationHelpers.createText("stats.startConfiguration()"));
		{
			for (ModelInfo i : infos) {
				if ( i.isInput() ) {
					s1 += "mtLauncher.createSrcArea(" + quote(i.getModelName()) + ", this." + i.getModelName() + "DataSource);";
				}
			}
	
			method.getStatements().add(CreationHelpers.createText(s1));
			
			for (ModelInfo i : infos) {
				if ( i.isOutput() ) {
					IMetaDriver driver = drivers.get(i.getMetamodelName());
					IDataSourceInitializerDriver init = driver.getDataSourceInitializer();
					if ( init != null ) {
						JVariableDeclaration idMapperVar = ctx.getGenerator().addLocalVar(method, "idMapper", typ.createTypeRef("IdMapper"));
						List<JStatement> stms =  init.initIdMapper(i, idMapperVar, ctx);
						method.getStatements().addAll(stms);
	
						String s2 = "mtLauncher.createTrgArea(" + quote(i.getModelName()) + ", " + idMapperVar.getName() + ");";
						method.getStatements().add(CreationHelpers.createText(s2));
					} else {
						String s2 = "// TODO: Init " + "mtLauncher.createTrgArea(" + quote(i.getModelName()) + " ... );";
						method.getStatements().add(CreationHelpers.createText(s2));
					}
						
				}
			}
		}
		method.getStatements().add(CreationHelpers.createText("stats.endConfiguration()"));


		String s3 = "";
		// Launching (+ some configuration, but let's neglect this)
		s3 += "stats.startLaunch();" + "\n";
		{		
			s3 += getTransformationClassName(basePkg) + " t = " + " new " + qTransformationClassName + "(";
			String srcs = infos.stream().filter(i -> i.isInput()).map(i -> "mtLauncher.getArea(mtLauncher.getSrcAreas(), " + quote(i.getModelName()) + ")").collect(Collectors.joining(","));
			String tgts = infos.stream().filter(i -> i.isOutput()).map(i -> "mtLauncher.getArea(mtLauncher.getTrgAreas(), " + quote(i.getModelName()) + ")").collect(Collectors.joining(","));
			s3 += srcs + ", " + tgts + ", " + "mtLauncher.getCachingArea()" + ");";

			s3 += "double time = mtLauncher.launch(t, " +
					"mtLauncher.getSrcAreas().stream().map(a -> a.getName()).collect(java.util.stream.Collectors.toList()).toArray(new String[mtLauncher.getSrcAreas().size()])," +
					"numThreads <= 0 ? 1 : numThreads);";
			s3 += "// System.out.println(time);" + "\n"; 
		}	
		s3 += "stats.endLaunch();" + "\n";
		
		// Postprocessing
		s3 += "stats.startPostprocessing();" + "\n";
		{
			s3 += "t.postprocessing();";
		}
		s3 += "stats.endPostprocessing();" + "\n";
		
	
		// Just a trick to make "t" available as part of the Java AST... 
		JVariableDeclaration trafoVar = ctx.getGenerator().addLocalVar(method, "trafo", typ.createTypeRef(qTransformationClassName));
		
		method.getStatements().add(CreationHelpers.createText(s3));

		method.getStatements().add(CreationHelpers.createAssignment(trafoVar, CreationHelpers.createTextExp("t")));

		// Serialize
		method.getStatements().add(CreationHelpers.createText("stats.startSerialization()"));		
		for (ModelInfo i : infos) {
			if ( i.isOutput() ) {
				// Create the writer object
				IMetaDriver driver = drivers.get(i.getMetamodelName());
				IDataSourceInitializerDriver init = driver.getDataSourceInitializer();

				JAttribute modelAttr = modelResources.get(i.getModelName());
				JAttribute mmAttr = outputMetamodelResources.get(i.getModelName());
				
				List<JStatement> expStm = init.generateWriter(i, trafoVar, modelAttr, mmAttr, ctx);

				method.getStatements().addAll(expStm);			
			}
		}
		method.getStatements().add(CreationHelpers.createText("stats.endSerialization()"));

		String s4 = "mtLauncher.getSrcAreas().forEach(a -> a.clear());" +
				"mtLauncher.getTrgAreas().forEach(a -> a.clear());" +
				"mtLauncher.destroy();";
		
		method.getStatements().add(CreationHelpers.createText(s4));

		
		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refToThis(gclass)));
		
		ctx.getEnv().popBlock();
	}

	private String getTransformationClassName(String basePkg) {
		return basePkg + "." + result.getATLModel().getModule().getName();
	}

	private JMethod createSetInputModelMethod_ForXMI(ModelInfo i, JClass gclass, JAttribute attr) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("set" + i.getModelName());
		
		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		JParameter param2 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("model" + i.getModelName() + "xmiFile");
		param1.setType(typ.createTypeRef("String"));

		param2.setName("mm" + i.getMetamodelName() + "xmiFile");
		param2.setType(typ.createTypeRef("String"));

		method.getParameters().add(param1);
		method.getParameters().add(param2);
	
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);
		
		String s = "lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.readModel(" + param1.getName() + ", " + param2.getName() + ");";
		s += "return " + method.getName() + "(m.getModel())"; //, m.getMetamodel())";
		
		method.getStatements().add(CreationHelpers.createText(s));
		
		return method;
	}

	private JMethod createGetOutputResource(ModelInfo i, JClass gclass, JAttribute modelResource) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("get" + i.getModelName() + "Resource");

		method.setReturnType(typ.createTypeRef("Resource"));

		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refVar(modelResource)));
		
		return method;
		
	}
	
	
	private JMethod createSetOutputModelMethod_ForXMI(ModelInfo i, JClass gclass) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("set" + i.getModelName());
		
		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		JParameter param2 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("model" + i.getModelName() + "xmiFile");
		param1.setType(typ.createTypeRef("String"));

		param2.setName("mm" + i.getMetamodelName() + "xmiFile");
		param2.setType(typ.createTypeRef("String"));

		method.getParameters().add(param1);
		method.getParameters().add(param2);
	
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);
		
		String s = "lintra.emf.LintraEMFUtils.ModelMetamodelPair m = lintra.emf.LintraEMFUtils.newModel(" + param1.getName() + ", " + param2.getName() + ");";
		s += "return " + method.getName() + "(m.getModel(), m.getMetamodel())";
		
		method.getStatements().add(CreationHelpers.createText(s));
		
		return method;
	}

	/**
	 * @param attr 
	 * @return 
	 */
	private JMethod createSetInputModelMethod(ModelInfo i, JClass gclass, JAttribute attr) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("set" + i.getModelName());
		
		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
//		JParameter param2 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("model" + i.getModelName() + "resource");
		param1.setType(typ.createTypeRef("Resource"));

//		param2.setName("mm" + i.getMetamodelName() + "xmiFile");
//		param2.setType(typ.createTypeRef("String"));

		method.getParameters().add(param1);
//		method.getParameters().add(param2);
	
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);
		

		
		// TODO: Use the EMFREader to determine the name of the reader
		// Also, check the type in the configuraiton to choose the right data source
		
		IMetaDriver driver = drivers.get(i.getMetamodelName());
		IDataSourceInitializerDriver init = driver.getDataSourceInitializer();
		if ( init != null ) {
			Context ctx = new ICompilationContext.Context(new CompilationEnv(result, drivers), typ, new GenCompiler(), ICollectionsDriver.NULL_DRIVER, null);
			ctx.getEnv().pushBlock(method);
				List<JStatement> stms =  init.initDriver(i, attr, param1, ctx);
				method.getStatements().addAll(stms);
			ctx.getEnv().popBlock();
		}
		
		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refToThis(gclass)));
		
		return method;
		
	}

	/**
	 * @param attr 
	 * @return 
	 */
	private JMethod createSetOutputModelMethod(ModelInfo i, JClass gclass, JAttribute modelResource, JAttribute metamodelResource) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("set" + i.getModelName());
		
		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();
		JParameter param2 = JavagenFactory.eINSTANCE.createJParameter();
		
		param1.setName("model" + i.getModelName() + "Resource");
		param1.setType(typ.createTypeRef("Resource"));

		param2.setName("mm" + i.getMetamodelName() + "Resource");
		param2.setType(typ.createTypeRef("Resource"));

		method.getParameters().add(param1);
		method.getParameters().add(param2);
	
		JTypeRef tr = JavagenFactory.eINSTANCE.createJTypeRef();
		tr.setType(gclass);
		method.setReturnType(tr);

		method.getStatements().add( CreationHelpers.createAssignment(modelResource, CreationHelpers.refVar(param1)) );
		method.getStatements().add( CreationHelpers.createAssignment(metamodelResource, CreationHelpers.refVar(param2)) );
			
		
		method.getStatements().add(CreationHelpers.createReturn(CreationHelpers.refToThis(gclass)));
		
		return method;
		
	}

	protected String quote(String s) {
		return "\"" + s + "\"";
	}

	private class SimpleTyping extends LindaTyping {
		public SimpleTyping(JavaGenModel jmodel, ATLModel model, DriverConfiguration drivers) {
			super(jmodel, model, drivers);
			
			createLibType("lintra2.transfo", "IDataSource");
			createLibType("lintra2.transfo", "ITransformation");
			createLibType("org.eclipse.emf.ecore.resource", "Resource");
			createLibType("lintra2.blackboard", "IdMapper");
			createLibType("lintra2.runners", "MTLauncherOutplace");
			createLibType("lintra2.transfo", "IFootprint");

			createLibType("lintra2.stats", "IStatsRecorder");

			
		}		
	}
}
