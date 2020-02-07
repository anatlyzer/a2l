package a2l.driver.uml;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.driver.IMetaDriver.ITransformationConfigurator;
import a2l.driver.emf.EMFDriver;
import a2l.driver.emf.EMFDriver.EMFTransformationConfigurator;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.types.Metaclass;
import anatlyzer.atl.types.Type;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.ICompilationContext;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JStatement;
import lintra.atlcompiler.javagen.JVariableDeclaration;
import lintra.lingen.LinGen;

public class UMLDriver extends EMFDriver implements IMetaDriver {

	public UMLDriver(String mmName, ATLModel m) {
		super(mmName, m);
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
		if ( klass.getName().equals("EObject") ) {
			return "org.eclipse.emf.ecore.EObject"; // Quick hack... for vmtesting#Relational2UML
		}
		return "org.eclipse.uml2.uml." + klass.getName();
	}

	@Override
	public String getClassName(EClass klass) {
		return getInterfaceName(klass);
	}

	@Override
	public String getClassQName(EClass klass) {
		return getInterfaceQName(klass);
	}
	
	@Override
	public String compileGetterExpression(JVariableDeclaration srcVar, EStructuralFeature f) {
		return compileGetterExpressionUML(srcVar.getName(), f);
	}

	public String compileGetterExpressionDirect(JVariableDeclaration srcVar, EStructuralFeature f) {
		return compileGetterExpression(srcVar, f);
	}
	
	protected static String compileGetterExpressionUML(String objExpr, EStructuralFeature f) {
		// TODO: Use UML/EMF naming rules
		String getterName = LinGen.getter(f);

		if ( f.isMany() && !getterName.endsWith("s")) {
			if ( f.getName().equals("clientDependency") ) {
				getterName = "getClientDependencies";
			} else {
				getterName += "s";
			}
		}

		
		if ( f.getEType() instanceof EDataType && f.getEType().getName().toLowerCase().contains("bool") ) {
			if ( f.getName().startsWith("is")) {
				getterName = f.getName();
			} else {
				getterName = getterName.replaceFirst("get", "is");
			}
		}
			
		return  objExpr + "." + getterName + "()";
	}
	
	@Override
	public List<ITransformationConfigurator> getTransformationConfigurators() {
		List<ITransformationConfigurator> config = new ArrayList<IMetaDriver.ITransformationConfigurator>();
		config.addAll(super.getTransformationConfigurators());
		config.add(configurator);
		return config;
	}

	private static UMLTransformationConfigurator configurator = new UMLTransformationConfigurator();
	
	public static class UMLTransformationConfigurator extends EMFTransformationConfigurator {

		@Override
		public String getConfiguratorId() { return "uml"; } 

		@Override
		public void configureTransformationClass(ICompilationContext ctx, DriverConfiguration conf, JClass tclass) {
			String utilities = "";
			utilities += "protected String get_UML_Id(org.eclipse.emf.ecore.EObject obj) { return org.eclipse.uml2.common.util.UML2Util.getXMIIdentifier((org.eclipse.emf.ecore.InternalEObject) obj); }" + "\n";	
			
			tclass.setExtra(tclass.getExtra() + "\n" + utilities);
			
			generateTaskClasses(ctx, tclass);
		}		
		
		protected String generateGetter(String var, EStructuralFeature r) {
			return compileGetterExpressionUML(var, r);
		}
		
		protected boolean checkShouldGenerate(IMetaDriver driver) {
			return driver.getClass() != UMLDriver.class;
		}		

	}	
	
	@Override
	public List<JStatement> compileObjectCreation(Metaclass type, JVariableDeclaration outVar, ICompilationContext ctx) {
		ArrayList<JStatement> stms = new ArrayList<JStatement>();
		stms.add(CreationHelpers.createAssignment(outVar, "org.eclipse.uml2.uml.UMLFactory.eINSTANCE.create" + type.getName() + "()") );
		return stms;
	}
	
	
}
