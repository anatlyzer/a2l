package a2l.runtime.lintra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import a2l.runtime.DefaultOutputModel;
import lintra2.blackboard.IdentifiableElement;
import lintra2.runners.ILintraModelWriter;

public class LintraOutputModel extends DefaultOutputModel implements ILintraModel {

	private Resource outResource;
	private ILintraModelWriter writer;
	private Resource outMetamodel;

	// lintra2.runners.ILintraModelWriter
	
	public LintraOutputModel(Resource outResource, Resource outMetamodel, ILintraModelWriter writer) {
		this.outResource = outResource;
		this.outMetamodel = outMetamodel;
		this.writer = writer;
	}

	@Override
	public void add(Object obj) {
		throw new UnsupportedOperationException();
		
	}

	@Override
	public void write() {
		writer.doWrite(this, outResource, outMetamodel);
	}

	@Override
	public Object forBinding(Object o, String resolvingRule) {
		return ((IdentifiableElement) o).getId();
	}

	@Override
	public Object read(String id) {
		List<IdentifiableElement> elements = (List<IdentifiableElement>) allInstances();
		for (IdentifiableElement identifiableElement : elements) {
			if ( identifiableElement.getId().equals(id)) {
				return identifiableElement;
			}
		}
		return null;
	}

	@Override
	public <T> List<T> readAll(Collection<String> list) {
		List<IdentifiableElement> elements = (List<IdentifiableElement>) allInstances();
		List<Object> result = new ArrayList<Object>(list.size());
		for (String string : list) {
			for (IdentifiableElement identifiableElement : elements) {
				if ( identifiableElement.getId().equals(string)) {
					result.add(identifiableElement);
				}
			}			
		}
		return (List<T>) result;
	}

}
