package a2l.runtime;

import java.util.ArrayList;
import java.util.List;

import a2l.runtime.IModel.IOutputModel;

public abstract class DefaultOutputModel implements IOutputModel {
	private List<PartialOutputModel> partialModels = new ArrayList<PartialOutputModel>();
	
	@Override
	public List<? extends Object> allInstances() {
		ArrayList<Object> l = new ArrayList<>();
		for (PartialOutputModel partialOutputModel : partialModels) {			
			l.addAll(partialOutputModel.allInstances());
		}
		return l;
	}

	@Override
	public synchronized boolean belongsTo(Object obj) {
		for (PartialOutputModel partialOutputModel : partialModels) {
			if ( partialOutputModel.belongsTo(obj) ) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void addPartial(PartialOutputModel p) {
		this.partialModels.add(p);
	}

}
