package lintra.compiler.tasks;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tinytools.metamodel.visitor.VisitorCreator;
import tinytools.metamodel.visitor.VisitorOptions;


public class GenAnatlyzerExtensionVisitor {

	public static void main(String[] args) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel", new EcoreResourceFactoryImpl());
		// GenModelPackage.eINSTANCE
		rs.getPackageRegistry().put(GenModelPackage.eINSTANCE.getNsURI(), GenModelPackage.eINSTANCE);
		
		Resource r4 = rs.getResource(URI.createURI("file:///home/jesus/projects/anatlyzer/plugins/anatlyzer.atl.typing/model/generated/merged.genmodel"), true);		
		Resource r3 = rs.getResource(URI.createURI("file:///home/jesus/projects/atl-lintra/plugins/lintra.atlcompiler/model/anatlyzer_ext.genmodel"), true);		
		
		// file:///home/jesus/projects/atl-lintra/plugins/anatlyzer.atl.typing/model/generated/merged.ecore#//OCL/NavigationOrAttributeCallExp
		rs.getURIConverter().getURIMap().put(
				URI.createURI("file:///home/jesus/projects/atl-lintra/plugins/anatlyzer.atl.typing/model/generated/merged.ecore"),
				URI.createURI("file:///home/jesus/projects/anatlyzer/plugins/anatlyzer.atl.typing/model/generated/merged.ecore"));
		
		EcoreUtil.resolveAll(rs); // Make sure all proxies are resolved
		
		VisitorOptions options = new VisitorOptions ();
		// options.setBaseDir("tmp_");
		options.setVisitorClass("AbstractAnatlyzerExtVisitor");
		
		options.setQualifiedBaseClass("anatlyzer.atlext.processing.AbstractVisitor"); //Inherit from ATL
		options.setBaseMetamodel(r4);
		
		options.setBaseDir("/home/jesus/projects/atl-lintra/plugins/lintra.atlcompiler/src-gen");
		options.setPackagePrefix("a2l.anatlyzerext.visitor");
		
		VisitorCreator compiler = new VisitorCreator();
		compiler.compile(r3, options);
	}

}
