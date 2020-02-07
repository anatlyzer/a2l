package a2l.driver.emf;

import static linda.atlcompiler.CreationHelpers.createAssignment;
import static linda.atlcompiler.CreationHelpers.createCommentedList;
import static linda.atlcompiler.CreationHelpers.createText;
import static linda.atlcompiler.CreationHelpers.quote;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.codegen.ecore.genmodel.GenEnum;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.utils.A2LUtils;
import anatlyzer.atl.analyser.batch.ChildStealingAnalysis;
import anatlyzer.atl.analyser.batch.PossibleStealingNode;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.CollectionType;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.types.UnionType;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPattern;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleWithPattern;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
import anatlyzer.atlext.OCL.Parameter;
import linda.atlcompiler.CompilationEnv;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.GenList;
import linda.atlcompiler.ICompilationContext;
import linda.atlcompiler.ICompilationContext.Context;
import linda.atlcompiler.LindaTyping;
import lintra.atlcompiler.javagen.JAssignment;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JExpression;
import lintra.atlcompiler.javagen.JInvoke;
import lintra.atlcompiler.javagen.JNewObject;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JType;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.atlcompiler.javagen.JavagenFactory;

public class EMFDriver implements IMetaDriver {

	private GenModel genModel;
	private HashSet<Binding> mayConflictingBindings = new HashSet<Binding>();
	
	public EMFDriver(String mmName, ATLModel m) {
		Map<String, GenModel> genModels = A2LUtils.loadGenModels(m);
		if ( ! genModels.containsKey(mmName) ) {
			// throw new IllegalArgumentException("No genmodel for " + mmName);
			System.out.println("No genmodel for " + mmName);
		}
		
		this.genModel = genModels.get(mmName);

	
		// Check which bindings may cause conflicts if assigned in parallel
		ChildStealingAnalysis analysis = new ChildStealingAnalysis(m);
		for (PossibleStealingNode stealing : analysis.perform()) {
			mayConflictingBindings.add(stealing.getBinding1());
			mayConflictingBindings.add(stealing.getBinding2());
		}
		
		
		List<Binding> allBindings = m.allObjectsOf(Binding.class);
		for(Binding b : allBindings) {
			EStructuralFeature f = (EStructuralFeature) b.getWrittenFeature();
			if ( f == null )
				continue;
			if ( f instanceof EReference ) {
				EReference ref = (EReference) f;
				EReference opposite = ref.getEOpposite();
				for (Binding binding : allBindings) {
					if ( opposite != null && binding.getWrittenFeature() == opposite ) {
						mayConflictingBindings.add(b);
						mayConflictingBindings.add(binding);
					}
				}
			}
		}
		
	}

	private GenPackage findPackage(EPackage pkg) {
		if ( genModel == null )
			return null;
		
		return genModel.findGenPackage(pkg);
	}
		
	private GenClassifier findClassifier(EClassifier klassifier) {
		if ( genModel == null )
			return null;

		return genModel.findGenClassifier(klassifier);
//		TreeIterator<EObject> it = genModel.eAllContents();
//		while ( it.hasNext() ) {
//			Object o = it.next();
//			if ( o instanceof GenClassifier ) {
//				EClassifier ecoreClass = ((GenClassifier) o).getEcoreClassifier();				
//				if ( klassifier.getName().equals(ecoreClass.getName()) &&
//						klassifier.getEPackage().getNsURI().equals(ecoreClass.getEPackage().getNsURI()) ) {
//					return (GenClassifier) o;
//				}
//			}
//		}
//		return null;
	}

	private GenFeature findFeature(EStructuralFeature f) {
		if ( genModel == null )
			return null;

		return genModel.findGenFeature(f);
	}
	
	public String ifGenFeature(EStructuralFeature f, Function<GenFeature, String> ifFound, Supplier<String> notFound) {
		GenFeature c = findFeature(f);
		if ( c != null ) 
			return ifFound.apply(c);
		return notFound.get();
	}
	
	public String ifGenClass(EClass klass, Function<GenClass, String> ifFound, Supplier<String> notFound) {
		GenClass c = (GenClass) findClassifier(klass);
		if ( c != null ) 
			return ifFound.apply(c);
		return notFound.get();
	}

	public String ifGenEnum(EEnum eenum, Function<GenEnum, String> ifFound, Supplier<String> notFound) {
		GenEnum c = (GenEnum) findClassifier(eenum);
		if ( c != null ) 
			return ifFound.apply(c);
		return notFound.get();
	}
	
	public String ifGenPackage(EPackage pkg, Function<GenPackage, String> ifFound, Supplier<String> notFound) {
		GenPackage c = (GenPackage) findPackage(pkg);
		if ( c != null ) 
			return ifFound.apply(c);
		return notFound.get();
	}	
	
	@Override
	public String getBaseType() {
		return "org.eclipse.emf.ecore.EObject";
	}

	@Override
	public String getInterfaceName(EClass klass) {
		return klass.getName();
	}

	@Override
	public String getInterfaceQName(EClass klass) {
		// return findClass(klass).getQualifiedInterfaceName();
		return ifGenClass(klass, GenClass::getQualifiedInterfaceName, () -> klass.getInstanceClass().getCanonicalName());
	}
		
	@Override
	public String getClassName(EClass klass) {
		return klass.getName();
	}

	@Override
	public String getClassQName(EClass klass) {
		return ifGenClass(klass, GenClass::getQualifiedInterfaceName, () -> klass.getInstanceClass().getCanonicalName());
	}

	public String getClassQNameImpl(EClass klass) {
		// return ifGenClass(klass, GenClass::getGeneratedInstanceClassFlag, () -> klass.getInstanceClass().getCanonicalName());		
		String qname = getClassQName(klass);
		int idx = qname.lastIndexOf(".");
		// TODO: There must be a place in the genmodel to get this value, but I can't find it
		return qname.substring(0, idx) + ".impl." + qname.substring(idx + 1, qname.length()) + "Impl";
	}

	
	@Override
	public String getEnumName(EEnum e) {
		return e.getName();
	}

	@Override
	public String getEnumQName(EEnum e) {
		return ifGenEnum(e, GenEnum::getQualifiedName, () -> e.getInstanceClass().getCanonicalName());
		// return e.getInstanceClass().getCanonicalName();
	}
	
	@Override
	public String getLiteralAccess(EEnum found, EEnumLiteral lit) {
		return ifGenEnum(found, (genEnum) -> {
			return genEnum.getGenEnumLiteral(lit.getName()).getEnumLiteralInstanceConstantName();
		}, () -> lit.getName().toUpperCase());
	}

	
	@Override
	public List<ITransformationConfigurator> getTransformationConfigurators() {
		return Collections.singletonList(configurator);
	}

	private static EMFTransformationConfigurator configurator = new EMFTransformationConfigurator();
	
	public static class EMFTransformationConfigurator implements ITransformationConfigurator {

		@Override
		public String getConfiguratorId() { return "emf"; } 

		@Override
		public void configureTransformationClass(ICompilationContext ctx, DriverConfiguration conf, JClass tclass) {
			String utilities = "";
			
			utilities += "protected String get_EMF_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.emf.ecore.util.EcoreUtil.getURI(obj).toString(); }" + "\n";	
			
			//utilities += "protected Map<org.eclipse.emf.ecore.EObject, String> object2id = new java.util.concurrent.ConcurrentHashMap<org.eclipse.emf.ecore.EObject, String>();" + "\n";
			//utilities += "protected void setObjectId(org.eclipse.emf.ecore.EObject obj, String id) { this.object2id.put(obj, id); }" + "\n";	
					
			String post = "";
//			for (ModelInfo m : ATLUtils.getModelInfo(ctx.getEnv().getAnalysis().getATLModel())) {
//				if ( m.isOutput() ) {
//					post += "Collection<org.eclipse.emf.ecore.EObject> rootOf" + m.getModelName() + " = java.util.Collections.synchronizedList(new ArrayList<org.eclipse.emf.ecore.EObject>());"; 
//				}
//			}	


			boolean driverAsOutput = false;
			for (ModelInfo m : ATLUtils.getModelInfo(ctx.getEnv().getAnalysis().getATLModel())) {
				if ( m.isOutput() && conf.get(m.getMetamodelName()) instanceof EMFDriver ) {
					driverAsOutput = true;
					break;
				}
			}
					
			if ( driverAsOutput ) {						
				post += "@Override public void doSequentialPostprocessing() { "
						+ "  for (IPendingTask tasks : pendingTasks) {"
						+ "			tasks.execute(this.globalContext.getGlobalTrace());"
						+ "  }"
						+ "}"
						+ "\n"; 
	
				// This is only in case a caller doesn't want to make the distinction
				post += "@Override public void doPostprocessing() { doSequentialPostprocessing(); doParallelPostprocessing(); }\n";
				
				post += "@Override public void doParallelPostprocessing() { "
						+ "\n"; 
				
				//post += "// TODO: Pass the number of threads explicitly to postprocessing" + "\n";
				//post += "java.util.concurrent.ForkJoinPool myPool = new java.util.concurrent.ForkJoinPool(8);";
				
				for (ModelInfo m : ATLUtils.getModelInfo(ctx.getEnv().getAnalysis().getATLModel())) {
					if ( m.isOutput() ) {
						String outputName = ((LindaTyping) ctx.getTyping()).getAreaName(m.getModelName());
						String partialOutputName = ((LindaTyping) ctx.getTyping()).getPartialOutputAreaName(m.getModelName());
						post += "  for (IPendingTask tasks : parallelPendingTasks) {";
						post += "			tasks.execute(this.globalContext.getGlobalTrace());";
						post += "  }";
						
//						post += "final Collection<? extends org.eclipse.emf.ecore.EObject> objects_" + m.getModelName() + " = (Collection<? extends org.eclipse.emf.ecore.EObject>)" + partialOutputName + ".allInstances();";
//						post += "for(org.eclipse.emf.ecore.EObject obj : " + "objects_" + m.getModelName()+ ") {";
//						post += "		if (obj.eContainer() == null) {";
//						post += "         synchronized(" + outputName + ") {";
//						post += "			" + outputName + ".add(obj);";
//						post += "		  }";
//						post += "		}";									
//						post += "}";
						// OUTModel_PartialOutput_
						
//						post += "try { ";
//						post += "myPool.submit(() -> {"
//							+ "objects_" + m.getModelName() + ".parallelStream().forEach(object -> {"
//							+ "		org.eclipse.emf.ecore.EObject obj = (org.eclipse.emf.ecore.EObject) object;"
//							+ "		if (obj.eContainer() == null) {"
//							+ "			rootOf" + m.getModelName() + ".add(obj);"
//							+ "		}"			
//							+ "  });"
//							+ "}).get();";
//						post += "} catch (InterruptedException | java.util.concurrent.ExecutionException e) { throw new RuntimeException(e); }";

// This is sequential			
//						post += "Collection objects = null;" + "\n";
//						post += "for (Object object : " + "objects_" + m.getModelName() + ") {" 
//								+ "		org.eclipse.emf.ecore.EObject obj = (org.eclipse.emf.ecore.EObject) object;"
//								+ "		if ( obj.eContainer() == null ) {"
//								+ "				" + "rootOf" + m.getModelName() + ".add(obj);"
//								+ "		}"
//								+ "}";
					}
				}
				
				post += "}" + "\n";
				
				post += "@Override public void doSequentialCleanup() { "
						+ "\n"; 

				for (ModelInfo m : ATLUtils.getModelInfo(ctx.getEnv().getAnalysis().getATLModel())) {
					if ( m.isOutput() ) {
						String outputName = ((LindaTyping) ctx.getTyping()).getAreaName(m.getModelName());
						String partialOutputName = ((LindaTyping) ctx.getTyping()).getPartialOutputAreaName(m.getModelName());						
						post += "final Collection<? extends org.eclipse.emf.ecore.EObject> objects_" + m.getModelName() + " = (Collection<? extends org.eclipse.emf.ecore.EObject>)" + partialOutputName + ".allInstances();";
						post += "for(org.eclipse.emf.ecore.EObject obj : " + "objects_" + m.getModelName()+ ") {";
						post += "		if (obj.eContainer() == null) {";
						post += "			" + outputName + ".add(obj);";
						post += "		}";									
						post += "}";
					}
				}

				post += "}" + "\n";

			}
			
			// Create the writer methods

//			for (ModelInfo m : ATLUtils.getModelInfo(ctx.getEnv().getAnalysis().getATLModel())) {
//				if ( m.isOutput() && conf.get(m.getMetamodelName()) instanceof EMFDriver ) {
//					post += "public void " + getWriteMethodName(m) + "(org.eclipse.emf.ecore.resource.Resource r) {";  
//					post += "   for(org.eclipse.emf.ecore.EObject o : rootOf" + m.getModelName() + ") {";
//					post += "      r.getContents().add(o);";
//					post += "   }";
//					post += "}";
//				}
//			}

			
			tclass.setExtra(tclass.getExtra() + "\n" + utilities + "\n" + post);

			generateTaskClasses(ctx, tclass);
			generateResolveTempClasses(ctx, tclass);
		}

		private static String getWriteMethodName(ModelInfo m) {
			return "write" + m.getModelName();
		}

		protected void generateResolveTempClasses(ICompilationContext ctx, JClass tclass) {
			StringBuilder resolveTempClasses = new StringBuilder();
			
			Set<EClass> alreadyAdded = new HashSet<EClass>();
			
			ATLModel model = ctx.getEnv().getAnalysis().getATLModel();
			for (OperationCallExp op : model.allObjectsOf(OperationCallExp.class)) {
				if (op.getOperationName().equals("resolveTemp")) {
					Type t = op.getInferredType();
					if (t instanceof Metaclass) {
						Metaclass m = (Metaclass) t;
						
						if (alreadyAdded.contains(((Metaclass) t).getKlass()))
							continue;
											
						IMetaDriver driver = ctx.getEnv().getDriver(op);
						if ( ! (driver instanceof EMFDriver))
							// This is another driver job
							continue;
						
						EMFDriver emf = (EMFDriver) driver;
						String qname = emf.getClassQNameImpl(m.getKlass());
						
						String className = getResolveTempClass(m.getKlass());
						resolveTempClasses.append("private static class " + className + " extends " + qname + " implements a2l.runtime.ResolveTempObject {");
						

						resolveTempClasses.append("private final Object source;");
						resolveTempClasses.append("private final String opeName;");

						resolveTempClasses.append("public " + className + "(Object source, String opeName) {");
						resolveTempClasses.append("this.source = source;");
						resolveTempClasses.append("this.opeName = opeName;");
						resolveTempClasses.append("}");

						resolveTempClasses.append("@Override public Object getSource() { return source; }");
						resolveTempClasses.append("@Override public String getOpeName() { return opeName; }");
						
						resolveTempClasses.append("}\n");
						
						alreadyAdded.add(m.getKlass());
					}
				}
			}
			
			tclass.setExtra(tclass.getExtra() + "\n" + resolveTempClasses.toString());
		}
		
		public static String getResolveTempClass(EClass klass) {
			return klass.getName() + "_ResolveTemp";			
		}
		
		protected void generateTaskClasses(ICompilationContext ctx, JClass tclass) {
			// This check is to avoid problems in the interplay of UMLDriver and EMFDriver
			if ( ! tclass.getExtra().contains("interface IPendingTask") ) {			
				//String utilities = "private java.util.concurrent.ConcurrentLinkedQueue<IPendingTask> pendingTasks = new java.util.concurrent.ConcurrentLinkedQueue<>();";
				String utilities = "private java.util.ArrayList<IPendingTask> pendingTasks = new java.util.ArrayList<>();";
				utilities += "private java.util.ArrayList<IPendingTask> parallelPendingTasks = new java.util.ArrayList<>();";

				utilities += "interface IPendingTask { public void execute(a2l.runtime.GlobalTrace globalTrace); }";
				tclass.setExtra(tclass.getExtra() + "\n" + utilities);
			}	
			

			Set<EReference> refs = new HashSet<>();
			for (Binding b : ctx.getEnv().getAnalysis().getATLModel().allObjectsOf(Binding.class)) {
				OutPatternElement ope = b.getOutPatternElement();
				EStructuralFeature r = (EStructuralFeature) b.getWrittenFeature();
				if ( !(r instanceof EReference) || refs.contains(r) )
					continue;

				IMetaDriver driver = ctx.getEnv().getDriver(ope);				
				if ( checkShouldGenerate(driver) )
					continue;
								
				String tgtTypeName = driver.getInterfaceQName( r.getEContainingClass() );
				
				String className = getFeatureBindingClassName(r);
				
				String objType = r.isMany() ? "Collection<Object>" : "Object";
				
				String klass = "private static final class " + className + " implements IPendingTask { " + "\n";
				klass += "private final " + tgtTypeName + " tgt;" + "\n";
				klass += "private final " + objType + " objId;" + "\n";
				klass += "private final a2l.runtime.IModel area;" + "\n";
				klass += "private final java.util.Set<? extends Object> tgtElems;" + "\n";
				klass += "public " + className + "(" + tgtTypeName + " tgt, " + objType + " objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {" + "\n";
				klass += "	this.tgt = tgt; this.objId = objId; this.area = area; this.tgtElems = tgtElems;" + "\n";
				klass += "}" + "\n";

				if ( r.isMany() ) {
					klass += "public " + className + "(" + tgtTypeName + " tgt, " + "Object" + " objId, a2l.runtime.IModel area, java.util.Set<? extends Object> tgtElems) {" + "\n";
					klass += "	this.tgt = tgt; this.objId = java.util.Collections.singletonList(objId); this.area = area; this.tgtElems = tgtElems;" + "\n";
					klass += "}" + "\n";					
				}
				
				String expectedType = driver.getInterfaceQName((EClass) r.getEType());
				klass += "public void execute(a2l.runtime.GlobalTrace globalTrace) {" + "\n";
				if ( r.isMany() ) {
					// String cast = "(" + "Collection<" + getInterfaceQNameAux((EClass) r.getEType()) + ">" + ")";					
					String cast = "(" + "Collection<? extends " + expectedType + ">" + ")";
					//String textNoTgt = generateGetter("tgt", r) + ".addAll(" + cast + "globalTrace.getAll(objId));";
					//textNoTgt = "if (tgtElems == null) {" + textNoTgt + "}";
					String textNoTgt = "ArrayList<Object> result = new ArrayList<>(objId.size());" + 
							"for (Object object : objId) {"
							+ "Object tgt = getTrace(object, globalTrace);" 
							+ "  if (tgt instanceof " + expectedType + ") { result.add(tgt); }"
							+ "}\n" + generateGetter("tgt", r) + ".addAll(" + cast + "result);";
					textNoTgt = "if (tgtElems == null) {" + textNoTgt + "}";
					
					String withTgtAlgorithm = "ArrayList<Object> result = new ArrayList<>(objId.size());"
					+ "for (Object object : objId) {"
					
							
					+ "  if (tgtElems.contains(object)) { result.add(getTargetResolveTempOrSame(object, globalTrace)); }"
					+ "  else { "
					+ "         Object tgt = getTrace(object, globalTrace); "
					+ "         if (tgt instanceof " + expectedType + ") { result.add(tgt); } "
					+ "  }"
					+ "}"
					+ generateGetter("tgt", r) + ".addAll(" + cast + "result);";

					String textTgt = "else {" + withTgtAlgorithm + "} ";
					
					klass += textNoTgt + textTgt;
				} else {
					// String cast = "(" + getInterfaceQNameAux((EClass) r.getEType()) + ")";
					String cast = "(" + expectedType + ")";
					klass += "if (tgtElems != null && tgtElems.contains(objId)) { ";
					klass +=    getSetterExpression("tgt", r) + "(" + cast + "getTargetResolveTempOrSame(objId, globalTrace)" + ");";
					klass += " } else {";
					klass += getSetterExpression("tgt", r) + "(" + cast + "getTrace(objId, globalTrace))" + ";";
					klass += "}";
				}
				klass += "}" + "\n";
				
				klass += "private final Object getTrace(Object object, a2l.runtime.GlobalTrace globalTrace) {"				
						+ " return globalTrace.get(object);"
				+ "}"
				+ "\n";
				
				klass += "private final Object getTargetResolveTempOrSame(Object object, a2l.runtime.GlobalTrace globalTrace) {"				
						// TODO: Add the ResolveTemp check only when really needed
						+ "         if (object instanceof a2l.runtime.ResolveTempObject) {"
						+ "             a2l.runtime.ResolveTempObject rtmp = (a2l.runtime.ResolveTempObject) object;" 
						+ "             return globalTrace.getSecondary(rtmp.getSource(), rtmp.getOpeName());"
						+ "         }"
						+ " return object;"
				+ "}"
				+ "\n";
				
				
				klass += "}" + "\n";

				// Add the class
				tclass.setExtra(tclass.getExtra() + "\n" + klass);
				
				refs.add((EReference) r);
			}
		}

		private static String getFeatureBindingClassName(EStructuralFeature r) {
			return "PendingTask_" + r.getEContainingClass().getName() + "_" + r.getName();
		}

		protected String generateGetter(String var, EStructuralFeature r) {
			return compileGetterExpression(var, r);
		}
		
		protected boolean checkShouldGenerate(IMetaDriver driver) {
			return driver.getClass() != EMFDriver.class;
		}		
	}


	@Override
	public List<JStatement> compileObjectCreation(Metaclass type, JVariableDeclaration outVar, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		// String factoryQName = type.getKlass().getEPackage().getEFactoryInstance().getClass().getCanonicalName();
		EPackage pkg = type.getKlass().getEPackage();
		String factoryQName = ifGenPackage(type.getKlass().getEPackage(), GenPackage::getQualifiedFactoryInterfaceName, () -> pkg.getEFactoryInstance().getClass().getCanonicalName());
		
		stms.add(CreationHelpers.createAssignment(outVar, factoryQName + ".eINSTANCE.create" + type.getName() + "()") );
		// TODO: Set the model name in an auxiliary element or something similar
		
		return stms;
	}	
	
//	@Override
//	public VarStatementPair compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f, ICompilationContext ctx) {
//		String plainGetter =  compileGetterExpression(srcVar.getName(), f);
//		ArrayList<JStatement> stms = new ArrayList<JStatement>();
//		
//		
//		JVariableDeclaration resultVar = ctx.getGenerator().addLocalVar(ctx.getEnv().currentBlock(), "r", resultType);
//	}
	
	@Override
	public String compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f) {
		String expr = compileGetterExpression(srcVar.getName(), f);
		// An optimisation to avoid slow iteration
		if (f.isMany() && f instanceof EReference) {
			EReference ref = (EReference) f;
			return  "new a2l.runtime.stdlib.FastIterableList<" + getClassQName(ref.getEReferenceType()) + ">(" +  expr + ")";
		}		
		return expr;
	}

	// Similar to compileGetterExpression but it doesn't optimise so that we can add to the collection
	public String compileGetterExpressionDirect(JVariableDeclaration srcVar, EStructuralFeature f) {
		String expr = compileGetterExpression(srcVar.getName(), f);
		return expr;
	}

	@Override
	public List<JStatement> compileMonovaluedGetter(NavigationOrAttributeCallExp self, EStructuralFeature f, JVariableDeclaration newVar, String getterExpr, ICompilationContext ctx) {
		return compileGetter(self, f, newVar, getterExpr, ctx);
	}
	
	@Override
	public List<JStatement> compileMultivaluedGetter(NavigationOrAttributeCallExp self,EStructuralFeature f, JVariableDeclaration newVar, String getterExpr, ICompilationContext ctx) {
		return compileGetter(self, f, newVar, getterExpr, ctx);
	}
	
	private List<JStatement> compileGetter(NavigationOrAttributeCallExp self, EStructuralFeature f, JVariableDeclaration newVar, String getterExpr, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		JExpression expr = CreationHelpers.createTextExp(getterExpr);
		if ( f.isMany() ) {
			expr = ctx.getCollectionsDriver().toCollection(expr, (CollectionType) self.getInferredType());
			
			// getterExpr = "javaslang.collection.List.ofAll(" + getterExpr + ")";
		}
		//stms.add( createAssignment(newVar, getterExpr));
		stms.add( createAssignment(newVar, expr));
		return stms;
	}

	
	protected static String compileGetterExpression(String objExpr, EStructuralFeature f) {
		// TODO: Use EMF naming rules
		String getterName = getter(f);
		return  objExpr + "." + getterName + "()";
	}

	protected static String getSetterExpression(String objExpr, EStructuralFeature f) {
		// TODO: Use EMF naming rules
			
		// use ifGenFeature if possible
		
		String setterName = setter(f);
			
		// TODO: Not sure if this is only for UML or general for EMF...
		if ( setterName.equals("setClass") )
			setterName = "setClass_";
	
		
		return  objExpr + "." + setterName;
	}
	
	private static String setter(EStructuralFeature f) {
		String head = f.getName().substring(0, 1).toUpperCase();
		String tail = f.getName().substring(1, f.getName().length());
		String setterName = "set" + head + tail;
		if ( f.getEType() instanceof EDataType && f.getEType().getName().toLowerCase().contains("bool") ) {
			setterName = setterName.replaceFirst("get", "is");
		}
		return setterName;
	}
	
	private static String getter(EStructuralFeature f) {
		String head = f.getName().substring(0, 1).toUpperCase();
		String tail = f.getName().substring(1, f.getName().length());
		String getterName =  "get" + head + tail;
		if ( f.getEType() instanceof EDataType && f.getEType().getName().toLowerCase().contains("bool") ) {
			getterName = getterName.replaceFirst("get", "is");
		}		
		return getterName;
	}
	
	@Override
	public List<JStatement> compileSetValue(JVariableDeclaration receptor, EStructuralFeature f, JVariableDeclaration value, Type valueType, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		
		String cast = "";
		if ( valueType instanceof UnionType && f instanceof EReference ) {
			cast = "(" + this.getClassQName(((EReference) f).getEReferenceType()) + ")"; 
		}
			
		if ( f.isMany() ) {
			if ( valueType instanceof CollectionType ) {
				stms.add( createText( compileGetterExpressionDirect(receptor, f) + ".addAll(" + cast + value.getName() + ")"  ));
			} else {
				stms.add( createText( "if (" + value.getName() + "!= null ) { " + compileGetterExpressionDirect(receptor, f) + ".add(" + cast + value.getName() + ");" + "}"  ));
			}
			
		} else {
			stms.add( createText( getSetterExpression(receptor.getName(), f) + "(" + cast + value.getName() + ");" ));
		}		
		return stms;
	}
	
	@Override
	public List<JStatement> compileTraceGeneration(Rule rule, InPatternElement inPatternElement, OutPatternElement ope, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		if ( inPatternElement != null ) {
			JVariableDeclaration inVar  = ctx.getEnv().getVar(inPatternElement);
			JVariableDeclaration outVar = ctx.getEnv().getVar(ope);
		
			OutPattern pattern = ope.getOutPattern();
			int idx = pattern.getElements().indexOf(ope);
			
			if (idx == 0) {
				// Default trace
				stms.add( createText("this.trace.put(" + inVar.getName() + "," + outVar.getName() + ")"));
			} else {
				// We generate secondary output traces only when they are required 
				// TODO: Do this
				stms.add( createText("this.trace.put(" + inVar.getName() + "," + outVar.getName() + "," + quote(ope.getVarName()) + ")"));
			}
		} else {
			// This is for called rules and so on
		}
// We don't need to do this
//		JVariableDeclaration outVar = ctx.getEnv().getVar(ope);
//		int i = ope.getOutPattern().getElements().indexOf(ope);
//		
//		
//		// String tgtIdGetter = compileGetTargetIdMapper(ope, ctx);
//		
//		String tgtIdMapper = ((LindaTyping) ctx.getTyping()).getTgtAreaName(ope) + ".getIdMapper()";
//		
//		if ( inPatternElement == null ) {
//			stms.add( createText(tgtIdMapper + ".addMapping(" + outVar.getName() + "," + "TraceFunction.createUniqueId(" + quote(rule.getName())  + "))") );
//		} else {
//			IMetaDriver driver = ctx.getEnv().getDriver(inPatternElement);
//			String idGetter = driver.compileSourceIdGetter(inPatternElement, ctx);
//			// The object id is updated in the id mapper
//			stms.add( createText(tgtIdMapper + ".addMapping(" + outVar.getName() + "," + "TraceFunction.create(" + idGetter + ", " + i + "," + quote(rule.getName())  + "))") );
//		}
		
		// stms.add( createText("setObjectId(" + outVar.getName() + "," + "TraceFunction.create(" + idGetter + ", " + i + "," + quote(rule.getName()) + "))"));
		return stms;
	}	
	
	@Override
	public String compileSourceIdGetter(EObject obj, ICompilationContext ctx) {		
		JVariableDeclaration inVar = ctx.getEnv().getVar(obj);
		List<String> areas = ((LindaTyping) ctx.getTyping()).getSrcAreaName(obj);
		if ( areas.size() != 1 ) {
			return "findDriverDynamically(" + inVar.getName() + ").getId(" + inVar.getName() + ")";			
		}
		
		String areaName = new ArrayList<>(areas).get(0);
		return areaName + ".getId(" + inVar.getName() + ")";
	}
	
	@Override
	public String compileGetSourceIdMapper(EObject obj, ICompilationContext ctx) {
		if ( true )
			throw new IllegalStateException("No longer needed");
		
		JVariableDeclaration inVar = ctx.getEnv().getVar(obj);
		List<String> areas = ((LindaTyping) ctx.getTyping()).getSrcAreaName(obj);
		if ( areas.size() != 1 ) {
			return "findDriverDynamically(" + inVar.getName() + ").getId(" + inVar.getName() + ")";			
		}
		
		String areaName = areas.get(0);
		return areaName + ".getIdMapper()";

		
//		String areaName = ((LindaTyping) ctx.getTyping()).srcAreaOf(obj);
//		return areaName + ".getIdMapper()";
	}

	@Override
	public String compileTypeOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx) {
		JVariableDeclaration var = ctx.getEnv().getVar(source);
		Metaclass m = (Metaclass) arg.getInferredType();
		return var.getName() + ".eClass().getInstanceClass() == " + getClassQName(m.getKlass()) + ".class";
	}
	
	@Override
	public String compileKindOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx) {
		JVariableDeclaration var = ctx.getEnv().getVar(source);
		Metaclass m = (Metaclass) arg.getInferredType();
		return var.getName() + " instanceof " + getInterfaceQName(m.getKlass());
	}
	
	@Override
	public String castTo(OclExpression source, OclExpression typeExpr, ICompilationContext ctx) {
		JVariableDeclaration var = ctx.getEnv().getVar(source);
		Metaclass m = (Metaclass) typeExpr.getInferredType();
		return "((" + getInterfaceQName(m.getKlass()) + ")" + var.getName() + ")";
	}

	@Override
	public JStatement defaultBindingResolution(Binding binding, MatchedRule r, JVariableDeclaration outVar, ICompilationContext ctx) {
		EStructuralFeature f = (EStructuralFeature) binding.getWrittenFeature();
		OclExpression right = binding.getValue();
		
		JVariableDeclaration inVar = ctx.getEnv().getVar(right);
		
		String pendingClassName = EMFTransformationConfigurator.getFeatureBindingClassName(f);
		
		//String idExpression     = compileSourceIdGetter(right, ctx);
		String areaName         = ((LindaTyping) ctx.getTyping()).getOutputModelFieldName(binding.getOutPatternElement()); //((LindaTyping) ctx.getTyping()).srcAreaOf(right);

		//String traceId = "TraceFunction.resolve(" + idExpression + ", 0, " + quote(r.getName()) + ")";

		String pendingCollection = getPendingCollection(binding);		
		return createText(pendingCollection + ".add( new " + pendingClassName + "(" + outVar.getName() + "," + inVar.getName() + "," + areaName + ", null) )");
	}



	@Override
	public List<JStatement> compileResolveTemp(OperationCallExp resolveTemp, JVariableDeclaration inElement, RuleWithPattern r, OutPatternElement ope, JVariableDeclaration newVar, ICompilationContext ctx) {
		List<JStatement> statements = new ArrayList<JStatement>();		
		Metaclass m = (Metaclass) resolveTemp.getInferredType();
		String className = EMFTransformationConfigurator.getResolveTempClass(m.getKlass());		
		statements.add( CreationHelpers.createAssignment(newVar, "new " + className + "(" + inElement.getName() + "," + quote(ope.getVarName()) + ")"));
		return statements;
	}


	
	private String getPendingCollection(Binding binding) {
		if ( mayConflictingBindings.contains(binding) ) {
			return "this.pendingTasks";
		} 
		return "this.parallelPendingTasks";
	}

	// parallelPendingTasks
	
	@Override
	public JStatement compileMultiValuedBindingResolution(Binding binding, JVariableDeclaration outVar, JVariableDeclaration inputIds, JVariableDeclaration targetsSet, ICompilationContext ctx) {
		EStructuralFeature f = (EStructuralFeature) binding.getWrittenFeature();
		OclExpression right = binding.getValue();

		String pendingClassName = EMFTransformationConfigurator.getFeatureBindingClassName(f);
		String areaName         = ((LindaTyping) ctx.getTyping()).getOutputModelFieldName(binding.getOutPatternElement()); //((LindaTyping) ctx.getTyping()).srcAreaOf(right);
		
		String pendingCollection = getPendingCollection(binding);
		String targetsSetRef = targetsSet == null ? "null" : targetsSet.getName();
		return createText(pendingCollection + ".add( new " + pendingClassName + "(" + outVar.getName() + "," + inputIds.getName() + "," + areaName + "," + targetsSetRef + ") )");
	}
	
	@Override
	public boolean checkIsJavaOperation(OperationCallExp self) {
		return self.getStaticResolver() instanceof Helper && AnalyserUtils.isAddedEOperation((Helper) self.getStaticResolver());
	}
	
	@Override
	public void compileJavaOperation(OperationCallExp self, ICompilationContext ctx) {
		CompilationEnv env = ctx.getEnv();
		
		JVariableDeclaration newVar = ctx.getGenerator().addLocalVar(env.currentBlock(), "op", ctx.getTyping().createTypeRef(self.getInferredType()));
		List<JStatement> stms = createCommentedList(self);

		stms.addAll(env.getStatements(self.getSource()));

		List<Parameter> hArgs = ATLUtils.getHelperArguments((Helper) self.getStaticResolver());
		JExpression[] args = new JExpression[self.getArguments().size()];
		for(int i = 0; i < self.getArguments().size(); i++) {
			Type formalArgument = hArgs.get(i).getInferredType();
			JVariableDeclaration actualArgument = env.getVar(self.getArguments().get(i));
			
			stms.addAll(env.getStatements(self.getArguments().get(i)));
			
			args[i] = CreationHelpers.createTextExp("(" + ctx.getTyping().getType(formalArgument) + ")" + actualArgument.getName() );
		}
		
		JInvoke invoke = CreationHelpers.createInvoke(self.getOperationName(), CreationHelpers.refVar(env.getVar(self.getSource())), args);
		
		if ( self.getInferredType() instanceof CollectionType ) {
			// TODO: Move this to an orthogonal collections/typing driver
			GenList genList = convertToList((CollectionType) self.getInferredType(), invoke, ctx.getTyping().getType("java.util.List"), ctx);		
			JVariableDeclaration res = genList.getResult();
			
			stms.addAll(genList.getStatements());
			stms.add( createAssignment(newVar, CreationHelpers.refVar(res)) );
		} else {
			stms.add( createAssignment(newVar, invoke) );
		}
		
		env.bind(self, newVar, stms);
	}
	
	@Override
	public String toBinding(JVariableDeclaration var, MatchedRule rule) {
		return var.getName();
	}
	
//	private String cast(Type t) {
//		return "(" + typ.getType(t) + ")";
//	}
	
	private GenList convertToList(CollectionType type, JExpression expr, JType t, ICompilationContext ctx) {
		GenList genList = new GenList(ctx);
		genList.initResult(ctx.getTyping().createTypeRef(type));
		JVariableDeclaration tmp = genList.assignTemporal(expr, ctx.getTyping().createTypeRef(t));
		genList.assignResult(
				ctx.getCollectionsDriver().toCollection(CreationHelpers.createTextExp(tmp.getName()), type));
		
		return genList;
	}

	@Override
	public IDataSourceInitializerDriver getDataSourceInitializer() {
		return new EMFDataSourceInitializer();
	}
	
	public class EMFDataSourceInitializer implements IDataSourceInitializerDriver {

		@Override
		public List<JStatement> initDriver(ModelInfo model, JVariableDeclaration var, JVariableDeclaration resourceVar, ICompilationContext ctx) {
			ctx.getTyping().createLibType("lintra.emf", "EMFDataSource");
			
			// INDataSource = new EMFDataSource(modelINresource);
			JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
			assignment.setDeclaration(var);
			
			JNewObject newDataSource = JavagenFactory.eINSTANCE.createJNewObject();
			newDataSource.setTypeRef( ctx.getTyping().createTypeRef("EMFDataSource") );
			assignment.setRightPart(newDataSource);			

			newDataSource.getArguments().add(CreationHelpers.refVar(resourceVar));
			newDataSource.getArguments().add(CreationHelpers.createTextExp("footprint")); // references the footprint attribute
			
			return Collections.singletonList(assignment);
		}
		
		public List<JStatement> initIdMapper(ModelInfo i, JVariableDeclaration idMapperVar, ICompilationContext ctx) { 
			ctx.getTyping().createLibType("lintra.emf", "EMFTargetIdMapper");
			
			JAssignment assignment = JavagenFactory.eINSTANCE.createJAssignment();
			assignment.setDeclaration(idMapperVar);
			
			JNewObject newDataSource = JavagenFactory.eINSTANCE.createJNewObject();
			newDataSource.setTypeRef( ctx.getTyping().createTypeRef("EMFTargetIdMapper") );
			assignment.setRightPart(newDataSource);		
			
			return Collections.singletonList(assignment);
		}

		@Override
		public List<JStatement> generateWriter(ModelInfo i, JVariableDeclaration trafoVar, JVariableDeclaration modelVar, JVariableDeclaration metamodelVar, ICompilationContext ctx) {
			String writerMethodName = EMFTransformationConfigurator.getWriteMethodName(i);
			
			JInvoke invoke = CreationHelpers.createInvoke(writerMethodName, CreationHelpers.refVar(trafoVar), CreationHelpers.refVar(modelVar));

			return Collections.singletonList(CreationHelpers.createExpresionStatement(invoke));
		}


		@Override
		public String createOutputModel(ModelInfo i, JVariableDeclaration trafoVar, JAttribute modelAttr, JAttribute mmAttr, Context ctx) {
			return "new " + getOutputModelClass() + "(" + modelAttr.getName() + ", " + mmAttr.getName() + ")";
		}
		
		private String getOutputModelClass() {
			return "a2l.runtime.emf.EMFOutputModel";
		}
		
	}
	
}
