package a2l.driver.lintra;

import static linda.atlcompiler.CreationHelpers.createAssignment;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.quote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.driver.DriverConfiguration;
import a2l.driver.ICollectionsDriver;
import a2l.driver.IMetaDriver;
import anatlyzer.atl.analyser.namespaces.MetamodelNamespace;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atl.util.UnsupportedTranslation;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.VariableDeclaration;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.ICompilationContext;
import linda.atlcompiler.ITyping;
import linda.atlcompiler.LindaTyping;
import linda.atlcompiler.Names;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.LindaTyping.NoModelFound;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JExprStatement;
import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JNewObject;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JTypeRef;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;
import lintra.lingen.LinGen;
import lintra.lingen.LinGen2;
import lintra.lingen.LintraEMFReaderGenerator;
import lintra.lingen.LintraEMFWriterGenerator;

public class LintraDriver implements IMetaDriver {
	
	@Override
	public String getBaseType() {
		return "lintra2.blackboard.IdentifiableElement";
	}

	@Override
	public String getInterfaceName(EClass klass) {
		return LinGen2.getInterfaceName(klass);
	}

	@Override
	public String getInterfaceQName(EClass klass) {
		return LinGen2.getInterfaceQName(klass);
	}

	@Override
	public String getClassName(EClass klass) {
		return LinGen.getClassName(klass);
	}

	@Override
	public String getClassQName(EClass klass) {
		return LinGen.getClassQName(klass);
	}

	public String getEnumName(EEnum enum_) {
		return LinGen.getEnumName(enum_);
	}
	
	public String getEnumQName(EEnum enum_) {
		return LinGen.getEnumQName(enum_);
	}
	
	@Override
	public String getLiteralAccess(EEnum found, EEnumLiteral lit) {
		return LinGen.getLiteralName(lit);
	}

	
	@Override
	public List<ITransformationConfigurator> getTransformationConfigurators() {
		return Collections.singletonList(configurator);
	}

	private static LintraTransformationConfigurator configurator = new LintraTransformationConfigurator();
	
	public static class LintraTransformationConfigurator implements ITransformationConfigurator {

		@Override
		public String getConfiguratorId() { return "lintra"; } 

		@Override
		public void configureTransformationClass(ICompilationContext ctx, DriverConfiguration driver, JClass tclass) {
			String utilities = "";
			utilities += "protected Object read(IModel model, String id) throws BlackboardException { return id == null ? null : ((a2l.runtime.lintra.ILintraModel) model).read(id); }" + "\n";
		
			tclass.setExtra(tclass.getExtra() + "\n" + utilities);			
		}		
	}
	
	@Override
	public List<JStatement> compileObjectCreation(Metaclass type, JVariableDeclaration outVar, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		JTypeRef typeOut = ctx.getTyping().createMetaTypeImplRef(type);
		String modelName = ctx.getTyping().getModelName(type);
		
		stms.add(CreationHelpers.createAssignment(outVar, "new " + CreationHelpers.toStr(typeOut) + "()") );
		stms.add(createText(outVar.getName() + "." + Names.SET_MODEL_NAME + "(" + quote(modelName) + ")") );

		return stms;
	}
	
	@Override
	public String compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f) {
		return  srcVar.getName() + "." + LinGen.getter(f) + "()";
	}
	
	public List<JStatement> compileMultivaluedGetter(NavigationOrAttributeCallExp self, EStructuralFeature f, JVariableDeclaration newVar, String getterExpression, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		
		try {
			List<String> srcAreas = ((LindaTyping) ctx.getTyping()).getSrcAreaName(self);
			
			String srcArea;
			if ( srcAreas.size() != 1 ) {
				throw new UnsupportedTranslation("Cannot translate (yet) multiple areas in navigation expr." + self);
			} else {
				srcArea = srcAreas.get(0);
			}
	
			JVariableDeclaration idVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "id", ctx.getTyping().createArrayTypeRef("String"));
			stms.add( createAssignment(idVar, getterExpression));
			stms.add( createAssignment(newVar, 
					castList(ctx.getTyping(), self.getInferredType(), "((a2l.runtime.lintra.ILintraModel)" + srcArea + ").readAll( toList(" + idVar.getName() + ") )", ctx.getCollectionsDriver()) )); 	
		} catch ( NoModelFound e ) {
			// It is a target model
			String modelName = ((LindaTyping) ctx.getTyping()).getOutputModelFieldName(self);
			JVariableDeclaration idVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "id", ctx.getTyping().createArrayTypeRef("String"));
			stms.add( createAssignment(idVar, getterExpression));
			stms.add( createAssignment(newVar, 
					castList(ctx.getTyping(), self.getInferredType(), "((a2l.runtime.lintra.ILintraModel)" + modelName + ").readAll( toList(" + idVar.getName() + ") )", ctx.getCollectionsDriver()) ));			
		}
		return stms;
	}
	
	public List<JStatement> compileMonovaluedGetter(NavigationOrAttributeCallExp self, EStructuralFeature f, JVariableDeclaration newVar, String getterExpression, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		try {
			List<String> srcAreas = ((LindaTyping) ctx.getTyping()).getSrcAreaName(self);
			
			JVariableDeclaration idVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "id", ctx.getTyping().createTypeRef("String"));
			stms.add( createAssignment(idVar, getterExpression));
	
			String srcArea;
			if ( srcAreas.size() != 1 ) {
				srcArea = "findModelDynamically(" + idVar.getName() + ")";
			} else {
				srcArea = srcAreas.get(0);
			}
			
			stms.add( createAssignment(newVar, 
					cast(ctx.getTyping(), self.getInferredType()) + "read(" + srcArea + ", " + idVar.getName() + ")" ));
		} catch ( NoModelFound e ) {
			String modelName = ((LindaTyping) ctx.getTyping()).getOutputModelFieldName(self);

			JVariableDeclaration idVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "id", ctx.getTyping().createTypeRef("String"));
			stms.add( createAssignment(idVar, getterExpression));

			stms.add( createAssignment(newVar, 
					cast(ctx.getTyping(), self.getInferredType()) + "read(" + modelName + ", " + idVar.getName() + ")" ));		
		}
		return stms;
	}

	private String cast(ITyping typ, Type t) {
		return "(" + typ.getType(t) + ")";
	}

	private JExpression castList(ITyping typ, Type t, String colExp, ICollectionsDriver collections) {
		// At some point we did that, not sure now why
		// String s = "new uk.ac.ebi.utils.collections.TypeCastCollection<" + typ.getType(((CollectionType) t).getContainedType())+ ">(" + colExp + ")";;		
		// return "javaslang.collection.List.ofAll(" + s+ ")";
		
		JExpression expr = CreationHelpers.createTextExp(colExp);
		expr = collections.toCollection(expr, (CollectionType) t);
		return expr;
	}
	
	@Override
	public List<JStatement> compileTraceGeneration(Rule rule, InPatternElement inPatternElement, OutPatternElement ope, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		JVariableDeclaration outVar = ctx.getEnv().getVar(ope);
		int i = ope.getOutPattern().getElements().indexOf(ope);
	
		
		if ( inPatternElement == null ) {
			// addStm(method, outVar.getName() + ".setId(" + "TraceFunction.createUniqueId(" + quote(self.getName()) + "))");			
		
			stms.add( createText(outVar.getName() + ".setId(" + "TraceFunction.createUniqueId(" + quote(rule.getName()) + "))"));
		} else {
			IMetaDriver driver = ctx.getEnv().getDriver(inPatternElement);
			String idGetter = driver.compileSourceIdGetter(inPatternElement, ctx);

			stms.add( createText(outVar.getName() + ".setId(" + "TraceFunction.create(" + idGetter + ", " + i + "," + quote(rule.getName()) + "))"));			
		}
		
		return stms;
	}
	
	@Override
	public String compileSourceIdGetter(EObject obj, ICompilationContext ctx) {
		if ( ! (obj instanceof VariableDeclaration || obj instanceof OclExpression ))
			throw new IllegalStateException();
		JVariableDeclaration inVar = ctx.getEnv().getVar(obj);
		return inVar.getName() + ".getId()";
	}
	
	@Override
	public String compileGetSourceIdMapper(EObject obj, ICompilationContext ctx) {
//		String areaName = ((LindaTyping) ctx.getTyping()).srcAreaOf(obj);
//		return areaName + ".getIdMapper()";

		JVariableDeclaration inVar = ctx.getEnv().getVar(obj);
		List<String> areas = ((LindaTyping) ctx.getTyping()).getSrcAreaName(obj);
		if ( areas.size() != 1 ) {
			return "findModelDynamically(" + inVar.getName() + ").getId(" + inVar.getName() + ")";			
		}
		
		String areaName = areas.get(0);
		return areaName + ".getIdMapper()";
	}

	
	@Override
	public String compileTypeOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx) {
		JVariableDeclaration var = ctx.getEnv().getVar(source);
		
		return "\"" + getTypeId(arg.getInferredType()) + "\".equals(" + var.getName() + ".getTypeId())";
	}
	
	@Override
	public String compileKindOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx) {
		CompilationEnv env = ctx.getEnv();
		return "(" + env.getVar(source).getName() + " instanceof " + 
				LinGen2.getInterfaceName(((Metaclass) arg.getInferredType()).getKlass()) + ")";
	}

	@Override
	public String castTo(OclExpression source, OclExpression typeExpr, ICompilationContext ctx) {
		return "(" + LinGen2.getInterfaceName(((Metaclass) typeExpr.getInferredType()).getKlass()) + ")";
	}

	
	private String getTypeId(Type type) {
		if ( type instanceof Metaclass ) {
			return LinGen.getTypeId(((Metaclass) type).getKlass());			
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public JStatement defaultBindingResolution(Binding binding, MatchedRule r, JVariableDeclaration outVar, ICompilationContext ctx) {
		EStructuralFeature f = (EStructuralFeature) binding.getWrittenFeature();
		String setterAccess = LinGen.setter(f);
		OclExpression right = binding.getValue();
		
		//String idMapper = compileGetSourceIdMapper(right, ctx);
		//String idGetter = idMapper + ".getId(" + ctx.getEnv().getVar(right).getName() + ")";
		
		//String idGetter = ctx.getEnv().getVar(right).getName() + ".getId()";
		
		IMetaDriver driver = ctx.getEnv().getDriver(right);
		String idGetter = driver.compileSourceIdGetter(right, ctx);

		
		return createText(outVar.getName() + "." + setterAccess + "(" + 
				"TraceFunction.resolve(" + idGetter + ", 0, " + quote(r.getName()) + ") ) ");
				// "TraceFunction.resolve(" + ctx.getEnv().getVar(right).getName() + ".getId()" + ", 0, " + quote(r.getName()) + ") ) ");
	}
	
	@Override
	public JStatement compileMultiValuedBindingResolution(Binding binding, JVariableDeclaration outVar, JVariableDeclaration inputIds, JVariableDeclaration targetsCol, ICompilationContext ctx) {
		EStructuralFeature f = (EStructuralFeature) binding.getWrittenFeature();
		String setterAccess = LinGen.setter(f);
		if ( f.isMany() ) { 
			return createText(outVar.getName() + "." + setterAccess + "(" + inputIds.getName() + ".toArray(" + "new String[" + inputIds.getName() + ".size()]" + "))");
		} else {
			return createText(outVar.getName() + "." + setterAccess + "(" + inputIds.getName() + ".isEmpty() ? null : (String) " + inputIds.getName() + ".get(0))");
		}
	}

	@Override
	public List<JStatement> compileSetValue(JVariableDeclaration receptor, EStructuralFeature f, JVariableDeclaration value, Type valueType, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		String setterAccess = LinGen.setter(f);
		
		String getIdMono = (f instanceof EAttribute) ? "" : ".getId()";
		String getIdMulti = (f instanceof EAttribute) ? "" : ".map(x -> x.getId()).toJavaArray(String.class)";
		
		
		if ( f.isMany() ) {
			if ( valueType instanceof CollectionType ) {
				
				stms.add( createText(receptor.getName() + "." + setterAccess + "(" + value.getName() + getIdMulti + ")") );				
			} else {
				stms.add( createText(receptor.getName() + "." + setterAccess + "(new String[] {" + value.getName() + getIdMono + " })") );							
			}
		} else {
			stms.add( createText(receptor.getName() + "." + setterAccess + "(" + value.getName() + getIdMono + ")" ) );
		}	
		
		return stms;
	}

	@Override
	public boolean checkIsJavaOperation(OperationCallExp self) {
		return false;
	}
	
	@Override
	public void compileJavaOperation(OperationCallExp self, ICompilationContext ctx) {
		throw new IllegalStateException();
	}
	
	@Override
	public String toBinding(JVariableDeclaration var, MatchedRule rule) {
		String idGetter = "((IdentifiableElement)" + var.getName() + ").getId()";
		if ( rule == null ) /* Assume is a target element */
			return idGetter;
		return "TraceFunction.resolve(" + idGetter + ", 0, " + quote(rule.getName()) + ") ";
	}
	
	/** 
	 * Returns an object able to generate the code for data source initialization.
	 * It can return null if it is not implemented. The user would need to generate the correct code.
	 */	
	public IDataSourceInitializerDriver getDataSourceInitializer() { return new LintraDataSourceInitializer(); }
	
	public class LintraDataSourceInitializer implements IDataSourceInitializerDriver {
		public List<JStatement> initDriver(ModelInfo model, JVariableDeclaration var, JVariableDeclaration resourceVar, ICompilationContext ctx) {
			// This should go in another place
			ctx.getTyping().createLibType("lintra2.runners", "LintraDataSource");
			
			MetamodelNamespace ns = ctx.getEnv().getAnalysis().getNamespaces().getNamespace(model.getMetamodelName());
			LintraEMFReaderGenerator gen = new LintraEMFReaderGenerator(ns.getResource());
			String className = gen.getReaderName();
			
			ctx.getTyping().createLibType(gen.getReaderPackageName(), className);
			// 
			
			// new LintraDataSource(...)
			JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
			assignment.setDeclaration(var);
			
			JNewObject newDataSource = JavagenFactory.eINSTANCE.createJNewObject();
			newDataSource.setTypeRef( ctx.getTyping().createTypeRef("LintraDataSource") );
			assignment.setRightPart(newDataSource);			

			// new MetamodelReader(...)
			JVariableDeclaration readerVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "reader", ctx.getTyping().createTypeRef(className));
			
			JAssignment readerVarAssign = JavagenFactory.eINSTANCE.createJAssignment();
			readerVarAssign.setDeclaration(readerVar);
			
			JNewObject newReader = JavagenFactory.eINSTANCE.createJNewObject();
			newReader.setTypeRef( ctx.getTyping().createTypeRef(className) );
			readerVarAssign.setRightPart(newReader);			
			newReader.getArguments().add(CreationHelpers.refVar(resourceVar));
			
			newDataSource.getArguments().add(CreationHelpers.refVar(readerVar));
			newDataSource.getArguments().add(CreationHelpers.createTextExp(quote(model.getModelName())));
			newDataSource.getArguments().add(CreationHelpers.createTextExp(quote(model.getMetamodelName())));

			// this.inDataSource = new LintraDataSource(new AntReader(readResource(inmmPath, inXmiPath)));
						
			ArrayList<JStatement> stms = new ArrayList<JStatement>();
			stms.add(readerVarAssign);
			stms.add(assignment);
			
			return stms;
		}
		
		@Override
		public List<JStatement> initIdMapper(ModelInfo i, JVariableDeclaration idMapperVar, ICompilationContext ctx) {
			// This should go in another place
			ctx.getTyping().createLibType("lintra2.runners.LintraDataSource", "LintraIdMapper");

			JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
			assignment.setDeclaration(idMapperVar);
			
			JNewObject newDataSource = JavagenFactory.eINSTANCE.createJNewObject();
			newDataSource.getArguments().add(CreationHelpers.createTextExp(quote(i.getModelName())));
			newDataSource.getArguments().add(CreationHelpers.createTextExp(quote(i.getMetamodelName())));
			newDataSource.setTypeRef( ctx.getTyping().createTypeRef("LintraIdMapper") );
			assignment.setRightPart(newDataSource);			

			ArrayList<JStatement> stms = new ArrayList<JStatement>();
			stms.add(assignment);
			
			return stms;
			
		}

		
		@Override
		public List<JStatement> generateWriter(ModelInfo i, JVariableDeclaration trafoVar, JVariableDeclaration modelVar, JVariableDeclaration metamodelVar, ICompilationContext ctx) {
			MetamodelNamespace ns = ctx.getEnv().getAnalysis().getNamespaces().getNamespace(i.getMetamodelName());
			LintraEMFWriterGenerator gen = new LintraEMFWriterGenerator(ns.getResource());
			String className = gen.getWriterName();
			ctx.getTyping().createLibType(gen.getWriterPackageName(), className);

			JNewObject newWriter = JavagenFactory.eINSTANCE.createJNewObject();
			newWriter.setTypeRef( ctx.getTyping().createTypeRef(className) );
			
			// TODO: Change mtLauncher#getArea for a direct access through trafoVar
			newWriter.getArguments().add(CreationHelpers.createTextExp("mtLauncher.getArea(mtLauncher.getTrgAreas(), " + quote(i.getModelName())+ ")"));

			JInvoke invoke = CreationHelpers.createInvoke("doWrite", newWriter, CreationHelpers.refVar(modelVar), CreationHelpers.refVar(metamodelVar));

			JExprStatement expStm = JavagenFactory.eINSTANCE.createJExprStatement();
			expStm.setExpr(invoke);

			return Collections.singletonList(expStm);
		}

		@Override
		public String createOutputModel(ModelInfo i, JVariableDeclaration trafoVar, JAttribute modelAttr, JAttribute mmAttr, Context ctx) {
			MetamodelNamespace ns = ctx.getEnv().getAnalysis().getNamespaces().getNamespace(i.getMetamodelName());
			LintraEMFWriterGenerator gen = new LintraEMFWriterGenerator(ns.getResource());
			String className = gen.getWriterName();
			
			String newWriter = "new " + gen.getWriterPackageName() + "." + className + "()";
			return "new " + getOutputModelClass() + "(" + modelAttr.getName() + ", " + mmAttr.getName() + "," + newWriter+ ")";
		}
		
		private String getOutputModelClass() {
			return "a2l.runtime.lintra.LintraOutputModel";
		}
		
	}

	
}
