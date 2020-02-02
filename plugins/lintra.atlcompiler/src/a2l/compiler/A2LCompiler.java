package a2l.compiler;

import static linda.atlcompiler.CreationHelpers.addStm;
import static linda.atlcompiler.CreationHelpers.createParameter;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.quote;

import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;

import a2l.compiler.A2LOptimiser.Optimisation;
import a2l.driver.DriverConfiguration;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.Pair;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.atlext.OCL.OclExpression;
import linda.atlcompiler.BaseTyping;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.GenCompiler;
import linda.atlcompiler.ITyping;
import linda.atlcompiler.LindaCompiler;
import linda.atlcompiler.LindaOclCompiler;
import linda.atlcompiler.LindaTyping;
import linda.atlcompiler.Names;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JBlock;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JLibType;
import lintra.atlcompiler.javagen.JMetaType;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;

public class A2LCompiler extends LindaCompiler {


	public A2LCompiler(IAnalyserResult result, DriverConfiguration driverConfiguration) {
		super(result, driverConfiguration);
	}

	// Overriding to adapt to Lintra2

	@Override
	public void atlOptimize(Set<? extends Optimisation> opts) {
		super.atlOptimize(opts);
		hints = new A2LOptimiser(result).
			withOptimisations(opts).
			run();
	}

	public Pair<List<JStatement>, JVariableDeclaration>  compileExpression(OclExpression expr, JavaGenModel externalModel, BiFunction<CompilationEnv, GenCompiler, JBlock> setup) {
		A2LCompiler newCompiler = new A2LCompiler(result, driverConfiguration);
		
		newCompiler.typ = new LindaTyping(jmodel, model, driverConfiguration);
		newCompiler.ocl = new LindaOclCompiler(this, newCompiler.env, typ, gen, hints);		
		newCompiler.tclass = this.tclass;
		newCompiler.jmodel = this.jmodel;

		
		JBlock block = setup.apply(newCompiler.env, newCompiler.gen);
		newCompiler.env.pushBlock(block);
		
		newCompiler.startVisiting(expr);
		JVariableDeclaration var = newCompiler.env.getVar(expr);
		block.getStatements().addAll(newCompiler.env.getStatements(expr));
		newCompiler.env.popBlock();
		
		if (externalModel != null) {
			
			Set<JType> allTypes = new HashSet<JType>();
			allTypes.addAll(jmodel.getLibTypes());
			allTypes.addAll(jmodel.getMetaTypes());
			Map<JType, JType> typeMap = new HashMap<JType, JType>();
			
			// This is a hack to merge the types used in the compiled expression with the current model using by the footprint compiler
			block.eAllContents().forEachRemaining(o -> {
				if (o instanceof JTypeRef) {
					JTypeRef ref = (JTypeRef) o;
					JType type = ref.getType();
					if (allTypes.contains(type)) {
						JType copy = typeMap.get(type);
						if (copy == null) {
							copy = EcoreUtil.copy(type);
							typeMap.put(type, copy);
						}
						ref.setType(copy);
					}
				}
			});
			
			typeMap.forEach((original, copy) -> {
				if (copy instanceof JLibType) {
					externalModel.getLibTypes().add((JLibType) copy);
				} else if (copy instanceof JMetaType) {
					externalModel.getMetaTypes().add((JMetaType) copy);
				} else {
					throw new IllegalStateException();
				}
			});			
		}
		
		return new Pair<List<JStatement>, JVariableDeclaration>(newCompiler.env.getStatements(expr), var);
	}

	
	@Override
	public String getTransformInputType() {
		return "Object";
	}
	
	// TODO: For some reason this doesn't call super...
	@Override
	protected void initTyping(ITyping typ, JClass tclass) {
		typ.createLibType("lintra2.blackboard", "IdentifiableElement");
		typ.createLibType("lintra2.blackboard", "IArea");		
		typ.createLibType("lintra2.blackboard", "BlackboardException");		
		
		typ.createLibType("lintra2.transfo", "ITransformation");
		typ.createLibType("lintra2.transfo", "ITransformation2");
		typ.createLibType("lintra2.transfo", "IMaster");
		typ.createLibType("lintra2.transfo", "TraceFunction");

		typ.createLibType("a2l.runtime", "IModel");
		typ.createLibType("a2l.runtime.IModel", "IOutputModel");
		typ.createLibType("a2l.runtime", "PartialOutputModel");
		
		addImport(tclass, "lintra2.blackboard", "IdentifiableElement");
		addImport(tclass, "lintra2.blackboard", "IArea");		
		addImport(tclass, "lintra2.blackboard", "BlackboardException");		
		
		addImport(tclass, "lintra2.transfo", "ITransformation");
		addImport(tclass, "lintra2.transfo", "IMaster");
		addImport(tclass, "lintra2.transfo", "TraceFunction");
		
		addImport(tclass, "a2l.runtime", "IModel");
		addImport(tclass, "a2l.runtime.IModel", "IOutputModel");
		addImport(tclass, "a2l.runtime", "PartialOutputModel");

		// Looks duplicated from LindaCompiler... 
		for (BaseTyping.TupleTypeInformation tti : env.getUsedTupleTypes()) {
			typ.addInternalType(tti.getGeneratedClassName());
		}
	}

	// Overriden for the moment to avoid errors. Should be made more general in the parent
	@Override 
	protected void createIsTargetElementCheckMethod() {
		isTargetElementCheckMethod = JavagenFactory.eINSTANCE.createJMethod();
		isTargetElementCheckMethod.setName("isTargetElement");
		isTargetElementCheckMethod.getParameters().add( createParameter("obj", typ.createTypeRef("Object")) );
		isTargetElementCheckMethod.setReturnType(typ.createTypeRef("boolean"));
		tclass.getMethods().add(isTargetElementCheckMethod);
				
		JParameter obj = isTargetElementCheckMethod.getParameters().get(0);

		// This must be synchronized with BaseTyping#getModelName
		String checks = ATLUtils.getModelInfo(model).stream().
			filter(m -> m.isOutput()).
			map(m -> m.getModelName()).
			map(modelName -> {
				//String areaName = ((LindaTyping) typ).getAreaName(modelName);
				String areaName = ((LindaTyping) typ).getPartialOutputAreaName(modelName);
				return areaName + ".belongsTo(" + obj.getName() +  ")";			
			}).
			collect(Collectors.joining(" || "));
		
		addStm(isTargetElementCheckMethod, createText("if ( obj == null ) return false;"));
		addStm(isTargetElementCheckMethod, createText("return " + checks));
	}

	protected void createGetDriverDynamically() {
		getDriverDynamically = JavagenFactory.eINSTANCE.createJMethod();
		getDriverDynamically.setName("findModelDynamically");
		getDriverDynamically.getParameters().add( createParameter("obj", typ.createTypeRef("Object")) );
		getDriverDynamically.setReturnType(typ.createTypeRef("IModel"));
		tclass.getMethods().add(getDriverDynamically);
		
		
		JParameter obj = getDriverDynamically.getParameters().get(0);

		// This must be synchronized with BaseTyping#getModelName
		String checks = ATLUtils.getModelInfo(model).stream().
				map(m -> m.getModelName()).
				map(modelName -> {
					String areaName = ((LindaTyping) typ).getAreaName(modelName);
					String condition = areaName + ".belongsTo(" + obj.getName() +  ")";			
					String ifChecker = "if ( " + condition + ") return " + areaName + ";";
					return ifChecker;
				}).
				collect(Collectors.joining(" \n "));
					
		checks += "\n" + "throw new IllegalStateException()";
		addStm(getDriverDynamically, createText(checks));
	}
	
	@Override
	public void beforeModule(Module self) {
		super.beforeModule(self);
		
		// Create setter methods
		List<ModelInfo> infos = ATLUtils.getModelInfo(result.getATLModel());
		for (ModelInfo i : infos) {
			
			JAttribute attr = JavagenFactory.eINSTANCE.createJAttribute();
			String areaName = ((LindaTyping) typ).getAreaName(i.getModelName());
			attr.setName(areaName);
					
			tclass.getAttributes().add(attr);

			if ( i.isInput() ) {
				attr.setType(typ.createTypeRef("IModel"));		
				JMethod setter = CreationHelpers.createSetter(typ, tclass, attr, "set" + i.getModelName());
				tclass.getMethods().add(setter);
			} else if ( i.isOutput() ) {
				attr.setType(typ.createTypeRef("IOutputModel"));		

				// Create the partial output model objects
				JAttribute partialOutput = JavagenFactory.eINSTANCE.createJAttribute();
				String partialModelName = ((LindaTyping) typ).getPartialOutputAreaName(i.getModelName());
				partialOutput.setName(partialModelName);
				partialOutput.setType(typ.createTypeRef("PartialOutputModel"));		
				
				tclass.getAttributes().add(partialOutput);

				JMethod setter = CreationHelpers.createSetter(typ, tclass, attr, "set" + i.getModelName(), (method) -> {
					method.getStatements().add(CreationHelpers.createText(method.getParameters().get(0).getName() + ".addPartial(" + partialModelName + ")"));
				});
				tclass.getMethods().add(setter);
			}
		}		
		
	}

}
