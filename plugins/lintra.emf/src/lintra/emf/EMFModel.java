package lintra.emf;

import java.util.List;
import java.util.Set;

import a2l.runtime.IModel;

public class EMFModel implements IModel {

	private List<Object> allInstances;

	public EMFModel(List<Object> allInstances) {
		this.allInstances = allInstances;
	}
	
	@Override
	public List<? extends Object> allInstances() {
		return this.allInstances;
	}

	@Override
	public boolean belongsTo(Object obj) {
		return this.allInstances.contains(obj);
	}

	@Override
	public Object forBinding(Object o, String resolvingRule) {
		return o;
	}
	
}
