package a2l.runtime.emf;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import a2l.runtime.DefaultOutputModel;

public class EMFOutputModel extends DefaultOutputModel {

	private Resource modelResource;

	public EMFOutputModel(Resource modelResource, Resource metamodelResource) {
		this.modelResource = modelResource;
	}

	@Override
	public void write() {
		try {
			modelResource.save(null);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void add(Object obj) {
		modelResource.getContents().add((EObject) obj);
	}

	@Override
	public Object forBinding(Object o, String resolvingRule) {
		return o;
	}

}
