package a2l.driver;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atlext.ATL.Binding;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.RuleWithPattern;
import anatlyzer.atlext.OCL.NavigationOrAttributeCallExp;
import anatlyzer.atlext.OCL.OclExpression;
import anatlyzer.atlext.OCL.OperationCallExp;
import linda.atlcompiler.ICompilationContext;
import linda.atlcompiler.ICompilationContext.Context;
import lintra.atlcompiler.javagen.JAttribute;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;

/**
 * This represents some meta-modelling technology for
 * which it is possible to access.
 * 
 * @author jesus
 *
 */
public interface IMetaDriver {

	/**
	 * @return the name of the base class for the model elements of the meta-modeling technology.
	 */
	public String getBaseType();
	
	public String getInterfaceName(EClass klass);
	public String getInterfaceQName(EClass klass);

	public String getClassName(EClass klass);
	public String getClassQName(EClass klass);

	public String getEnumName(EEnum enum_);
	public String getEnumQName(EEnum enum_);
	public String getLiteralAccess(EEnum found, EEnumLiteral lit);
	
	/** Code generation methods */
	public List<ITransformationConfigurator> getTransformationConfigurators();
	
	public List<JStatement> compileObjectCreation(Metaclass type, JVariableDeclaration outVar, ICompilationContext ctx);

//	/**
//	 * Given an object (stored in srcVar) it returns a new var plus a list of statements needed 
//	 * to access the feature.
//	 * @param srcVar
//	 * @param f
//	 * @return
//	 */
	//public VarStatementPair compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f);
	public String compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f);

	public List<JStatement> compileMultivaluedGetter(
			NavigationOrAttributeCallExp self,
			EStructuralFeature f,
			JVariableDeclaration newVar, String getterExpr, ICompilationContext ctx);

	public List<JStatement> compileMonovaluedGetter(
			NavigationOrAttributeCallExp self,
			EStructuralFeature f, JVariableDeclaration newVar, String getterExpr, ICompilationContext ctx);

	public List<JStatement> compileSetValue(JVariableDeclaration receptor, EStructuralFeature f, JVariableDeclaration value, Type valueType, ICompilationContext ctx);
	
	/**
	 * 
	 * If inPatternElement is null, then it means that the trace element will not have a 1:1 correspondence
	 * with a source element. The implementation must generate an unique id by other means.
	 * 
	 * @param self
	 * @param inPatternElement may be null
	 * @param ope
	 * @param ctx
	 * @return
	 */
	public List<JStatement> compileTraceGeneration(Rule self, InPatternElement inPatternElement, OutPatternElement ope, ICompilationContext ctx);

	/**
	 * 
	 * @param obj must be an OclExpression or a VariableDeclaration
	 * @param ctx
	 * @return
	 */
	public String compileSourceIdGetter(EObject obj, ICompilationContext ctx);
	public String compileGetSourceIdMapper(EObject obj, ICompilationContext ctx);
	
	public interface ITransformationConfigurator {
		public String getConfiguratorId();
		public void configureTransformationClass(ICompilationContext ctx, DriverConfiguration driverConfiguration, JClass tclass);
	}

	public String compileTypeOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx);
	public String compileKindOfExpression(OclExpression source, OclExpression arg, ICompilationContext ctx);
	public String castTo(OclExpression source, OclExpression typeExpr, ICompilationContext ctx);
	
	// Binding resolution methods
	public JStatement defaultBindingResolution(Binding binding, MatchedRule r, JVariableDeclaration outVar, ICompilationContext ctx);

	// tgtElemsCol can be null if there is no need for it
	public JStatement compileMultiValuedBindingResolution(Binding binding, JVariableDeclaration outVar, JVariableDeclaration inputIds, JVariableDeclaration tgtElemsCol, ICompilationContext ctx);

	public List<JStatement> compileResolveTemp(OperationCallExp resolveTemp, JVariableDeclaration inElement, RuleWithPattern r,
			OutPatternElement ope, JVariableDeclaration newVar, ICompilationContext ctx);

	public boolean checkIsJavaOperation(OperationCallExp self);

	/**
	 * The implementation is responsible of adding the generated environments and the result
	 * variable to ctx().getEnv()
	 * 
	 * @param self
	 * @param ctx
	 */
	public void compileJavaOperation(OperationCallExp self, ICompilationContext ctx);

	
	/** 
	 * Returns an object able to generate the code for data source initialization.
	 * It can return null if it is not implemented. The user would need to generate the correct code.
	 */	
	public default IDataSourceInitializerDriver getDataSourceInitializer() { return null; }
	
	public static interface IDataSourceInitializerDriver {
		/**
		 * 
		 * @param ctx
		 * @param var The var to be initialized with the data source object
		 * @return
		 */
		public List<JStatement> initDriver(ModelInfo model, JVariableDeclaration var, JVariableDeclaration resourceVar, ICompilationContext ctx);

		public List<JStatement> initIdMapper(ModelInfo i, JVariableDeclaration idMapperVar, ICompilationContext ctx);

		public List<JStatement> generateWriter(ModelInfo i, JVariableDeclaration trafoVar, JVariableDeclaration modelVar, JVariableDeclaration metamodelVar, ICompilationContext ctx);

		// TODO: Delete generateWriter, since it is superceded by this method
		public String createOutputModel(ModelInfo i, JVariableDeclaration trafoVar, JAttribute modelAttr, JAttribute mmAttr, Context ctx);

//		public String getOutputModelClass();

	}

	public String toBinding(JVariableDeclaration loopVar, MatchedRule r);


	
}
