package a2l.compiler;

import static linda.atlcompiler.CreationHelpers.createTextExp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;

import a2l.driver.DriverConfiguration;
import a2l.driver.IMetaDriver;
import a2l.utils.A2LUtils;
import anatlyzer.atl.analyser.IAnalyserResult;
import anatlyzer.atl.analyser.namespaces.MetamodelNamespace;
import anatlyzer.atl.footprint.TrafoMetamodelData;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;
import anatlyzer.atlext.ATL.Module;
import linda.atlcompiler.CreationHelpers;
import linda.atlcompiler.ITyping;
import linda.atlcompiler.LindaTyping;
import lintra.atlcompiler.javagen.JClass;
import lintra.atlcompiler.javagen.JConditional;
import lintra.atlcompiler.javagen.JConditionalBlock;
import lintra.atlcompiler.javagen.JMethod;
import lintra.atlcompiler.javagen.JParameter;
import lintra.atlcompiler.javagen.JavaGenModel;
import lintra.atlcompiler.javagen.JavagenFactory;

/**
 * This generates a default runner for EMF input elements.
 * @author jesus
 *
 */
public class FootprintGenerator {
	private IAnalyserResult result;
	private DriverConfiguration drivers;
	protected ITyping typ;
	
	public FootprintGenerator(IAnalyserResult result, DriverConfiguration driverConfiguration) {
		this.result = result;
		this.drivers = driverConfiguration;		
	}
	
	public JavaGenModel generate(String basePkg) {
		Module m = result.getATLModel().getModule();

		Set<EClass> allFootprintClasses = new HashSet<>();
		HashMap<EClass, IMetaDriver> class2driver = new HashMap<EClass, IMetaDriver>();
		List<ModelInfo> inputs = ATLUtils.getModelInfo(result.getATLModel()).stream().filter(ModelInfo::isInput).collect(Collectors.toList());
		for(ModelInfo i : inputs) {
			MetamodelNamespace mm = result.getNamespaces().getNamespace(i.getMetamodelName());
			
			
			TrafoMetamodelData footprint = new TrafoMetamodelData(result.getATLModel(), mm);
			
			Set<EClass> classes = footprint.getDirectUsedClasses();
			allFootprintClasses.addAll(classes);
			
			IMetaDriver d = drivers.get(i.getMetamodelName());
			for (EClass eClass : classes) {
				class2driver.put(eClass, d);
			}			
		}
		
		
		
		JavaGenModel jmodel = JavagenFactory.eINSTANCE.createJavaGenModel();
		typ = new SimpleTyping(jmodel, result.getATLModel(),  drivers);
				
		JClass gclass = JavagenFactory.eINSTANCE.createJClass();
		jmodel.getClasses().add(gclass);
		
		gclass.setPkg(basePkg);
		gclass.setName(A2LUtils.getTransformationClassName(m) + "Footprint");
		gclass.getImports().add(typ.getType("lintra2.transfo.IFootprint"));
		
		gclass.getImplements().add(typ.createTypeRef("IFootprint"));
		
		createIsFootprint(gclass, allFootprintClasses, class2driver);
		
				
		return jmodel;
	}

	private void createIsFootprint(JClass gclass, Set<EClass> allFootprintClasses, HashMap<EClass, IMetaDriver> class2driver) {
		JMethod method = JavagenFactory.eINSTANCE.createJMethod();
		method.setName("inGlobal");
		method.setReturnType(typ.createTypeRef("boolean"));
		gclass.getMethods().add(method);
		

		JParameter param1 = JavagenFactory.eINSTANCE.createJParameter();	
		param1.setName("o");
		param1.setType(typ.createTypeRef("Object"));
		method.getParameters().add(param1);

		JConditional conditional = JavagenFactory.eINSTANCE.createJConditional();
		List<EClass> sorted = allFootprintClasses.stream().sorted((c1, c2) -> {
			if ( c1 == c2 )
				return 0;
			if ( c2.isSuperTypeOf(c1) ) {
				return 1;
			}
			return -1;			
		}).collect(Collectors.toList());
		
		for(EClass e : sorted) {
			JConditionalBlock cond = JavagenFactory.eINSTANCE.createJConditionalBlock();
			
			IMetaDriver driver = class2driver.get(e);
			String qName = driver.getClassQName(e);
			
			//cond.setExpr(createTextExp("o.getClass() == " + qName + ".class"));
			cond.setExpr(createTextExp("o instanceof " + qName));
			
			cond.getStatements().add(CreationHelpers.createReturn(CreationHelpers.createTextExp("true")));
			conditional.getConditions().add(cond);
		}
		
		JConditionalBlock cond = JavagenFactory.eINSTANCE.createJConditionalBlock();
		cond.getStatements().add(CreationHelpers.createReturn(CreationHelpers.createTextExp("false")));		
		conditional.setElse(cond);
		
		
		method.getStatements().add(conditional);
	}


	protected String quote(String s) {
		return "\"" + s + "\"";
	}

	private class SimpleTyping extends LindaTyping {
		public SimpleTyping(JavaGenModel jmodel, ATLModel model, DriverConfiguration drivers) {
			super(jmodel, model, drivers);
			
			createLibType("lintra2.transfo", "IFootprint");
			
		}		
	}
}