package lintra.compiler.tasks;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import tinytools.metamodel.visitor.VisitorCreator;
import tinytools.metamodel.visitor.VisitorOptions;


public class GenJavaGenVisitor {

	public static void main(String[] args) throws Exception {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel", new EcoreResourceFactoryImpl());
		// GenModelPackage.eINSTANCE
		rs.getPackageRegistry().put(GenModelPackage.eINSTANCE.getNsURI(), GenModelPackage.eINSTANCE);
		
		Resource r3 = rs.getResource(URI.createURI("file:///home/jesus/projects/atl-lintra/plugins/lintra.atlcompiler/model/javagen.genmodel"), true);
		
		VisitorOptions options = new VisitorOptions ();
		// options.setBaseDir("tmp_");
		options.setVisitorClass("AbstractJavaGenVisitor");
		options.setBaseDir("/home/jesus/projects/atl-lintra/plugins/lintra.atlcompiler/src-gen");
		options.setPackagePrefix("javagen.visitor");
		
		VisitorCreator compiler = new VisitorCreator();
		compiler.compile(r3, options);
	}

}
