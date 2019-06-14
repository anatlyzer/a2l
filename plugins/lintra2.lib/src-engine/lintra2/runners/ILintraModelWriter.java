package lintra2.runners;

import org.eclipse.emf.ecore.resource.Resource;

import a2l.runtime.lintra.ILintraModel;

public interface ILintraModelWriter {

	public void doWrite(ILintraModel m, Resource r, Resource mm);
	
}
