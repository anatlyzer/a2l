package lintra.emf;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class LintraEMFUtils {

	public static  ModelMetamodelPair readModel(String xmiFile, String xmiMMFile) {
		ResourceSet resSet = new ResourceSetImpl();

		Resource metamodel;
		if (xmiMMFile.contains("http://") || xmiMMFile.contains("www.")) {
			metamodel = resSet.getResource(URI.createURI(xmiMMFile), true);
		} else {
			metamodel = resSet.getResource(URI.createFileURI(xmiMMFile), true);
			adapt(metamodel);
		}
		
		metamodel.getContents().forEach(p -> resSet.getPackageRegistry().put(((EPackage) p).getNsURI(), p));

		Resource model = resSet.getResource(URI.createFileURI(xmiFile), true);
		
		return new ModelMetamodelPair(model, metamodel);
	}
	
	public static  ModelMetamodelPair newModel(String xmiFile, String xmiMMFile) {
		ResourceSet resSet = new ResourceSetImpl();

		Resource metamodel;
		if (xmiMMFile.contains("http://") || xmiMMFile.contains("www.")) {
			metamodel = resSet.getResource(URI.createURI(xmiMMFile), true);
		} else {
			metamodel = resSet.getResource(URI.createFileURI(xmiMMFile), true);
			adapt(metamodel);
		}
		
		metamodel.getContents().forEach(p -> resSet.getPackageRegistry().put(((EPackage) p).getNsURI(), p));

		Resource model = resSet.createResource(URI.createFileURI(xmiFile));
		
		return new ModelMetamodelPair(model, metamodel);
	}
	
	public static class ModelMetamodelPair {
		private Resource model;
		private Resource metamodel;

		public ModelMetamodelPair(Resource m, Resource mm) {
			this.model = m;
			this.metamodel = mm;
		}
		
		public Resource getMetamodel() {
			return metamodel;
		}
		
		public Resource getModel() {
			return model;
		}
	}
	
	// Copied from the ATL plug-in EReferenceModel. This is needed to make the parser
	// work with KM3 exported meta-models (not very elegant workaround though...)
	private static void adapt(Resource metamodel) {
		for (Iterator<EObject> i = metamodel.getAllContents(); i.hasNext();) {
			EObject v = i.next();
			if ( ! (v instanceof EDataType) ) 
				continue;
			EDataType dt = (EDataType)v;
			String tname = dt.getName();
			String icn = dt.getInstanceClassName();
			if (icn == null) {
				if (tname.equals("Boolean")) { //$NON-NLS-1$
					icn = "boolean"; //$NON-NLS-1$
				} else if (tname.equals("Double") || tname.equals("Real")) { //$NON-NLS-1$ //$NON-NLS-2$
					icn = "java.lang.Double"; //$NON-NLS-1$
				} else if (tname.equals("Float")) { //$NON-NLS-1$
					icn = "java.lang.Float"; //$NON-NLS-1$
				} else if (tname.equals("Integer")) { //$NON-NLS-1$
					icn = "java.lang.Integer"; //$NON-NLS-1$
				} else if (tname.equals("String")) { //$NON-NLS-1$
					icn = "java.lang.String"; //$NON-NLS-1$
				}
				if (icn != null) {
					dt.setInstanceClassName(icn);
				}
			}
		}
	}
	
}
